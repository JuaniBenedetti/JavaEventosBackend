package eventos.eventos.services.sendgrid;

public interface SendGridService {

    void sendVerificationMail(String emailTo, String code) throws Exception;
}
