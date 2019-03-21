package fr.mb.volontario.business.contract;

import fr.mb.volontario.model.Mail;
import freemarker.template.TemplateException;

import javax.mail.MessagingException;
import java.io.IOException;

public interface EmailService {


    /**
     * Envoie de mail
     * @param mail
     * @param template
     * @throws MessagingException
     * @throws IOException
     * @throws TemplateException
     */
    void sendSimpleMessage(Mail mail, String template) throws MessagingException, IOException, TemplateException;
}
