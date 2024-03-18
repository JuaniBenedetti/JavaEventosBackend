package eventos.eventos.sendgrid;

import eventos.eventos.exceptions.UsuarioVerificacionException;
import eventos.eventos.services.sendgrid.SendGridService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SendGridTest {

    @Autowired
    SendGridService sendGridService;

    @Test
    public void sendVerificationMailTest() throws UsuarioVerificacionException {
        sendGridService.sendVerificationMail("test@hotmail.com", "999999");
    }

}
