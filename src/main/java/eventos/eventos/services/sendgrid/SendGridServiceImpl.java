package eventos.eventos.services.sendgrid;

import com.sendgrid.*;
import eventos.eventos.exceptions.UsuarioVerificacionException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
public class SendGridServiceImpl implements SendGridService{

    @Override
    public void sendVerificationMail(String emailTo, String code) throws UsuarioVerificacionException {
        Email from = new Email("info.eplanner@gmail.com");
        String subject = "EPlanner - Verificación de cuenta";
        Email to = new Email(emailTo);

        Content content = new Content("text/html", readFile("EPlanner.html"));

        Personalization personalization = new Personalization();
        personalization.addSubstitution("{{code}}", code);
        personalization.addSubstitution("{{{unsubscribe}}}", "https://google.com/");
        personalization.addTo(to);

        Mail mail = new Mail();
        mail.setFrom(from);
        mail.setSubject(subject);
        mail.addContent(content);
        mail.addPersonalization(personalization);

        SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            sg.api(request);
        } catch (IOException ex) {
            throw new UsuarioVerificacionException("No se pudo enviar email de verificación. " + ex.getMessage());
        }
    }

    private static String readFile(String fileName) throws UsuarioVerificacionException {
        try {
            ResourceLoader resourceLoader = new DefaultResourceLoader();
            Resource resource = resourceLoader.getResource("classpath:sendgrid/" + fileName);
            Reader reader = new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8);
            return FileCopyUtils.copyToString(reader);
        } catch (IOException exception) {
            throw new UsuarioVerificacionException("No se pudo leer la plantilla del email de verificación de usuario.");
        }
    }

}
