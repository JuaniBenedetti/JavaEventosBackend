package eventos.eventos.services.sendgrid;

import com.sendgrid.*;
import eventos.eventos.exceptions.UsuarioVerificacionException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
public class SendGridServiceImpl implements SendGridService{

    @Override
    public void sendVerificationMail(String emailTo, String code) throws UsuarioVerificacionException {
        Email from = new Email("eplanner.info@gmail.com");
        String subject = "EPlanner - Verificación de cuenta";
        Email to = new Email(emailTo);

        Content content = new Content("text/html", readFile("Eplanner.html"));

        Personalization personalization = new Personalization();
        personalization.addSubstitution("{{code}}", code);
        personalization.addSubstitution("{{{unsubscribe}}}", "https://trollface.dk/");
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
            return new String(Files.readAllBytes(Paths.get("src/main/resources/sendgrid/" + fileName)));
        } catch (IOException exception) {
            throw new UsuarioVerificacionException("No se pudo leer la plantilla del email de verificación de usuario.");
        }
    }

}
