package eventos.eventos.services.sendgrid;

import eventos.eventos.exceptions.UsuarioVerificacionException;

public interface SendGridService {

    void sendVerificationMail(String emailTo, String code) throws UsuarioVerificacionException;
}
