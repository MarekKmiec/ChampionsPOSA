package pl.coderunner.championsposa.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import pl.coderunner.championsposa.domain.User;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

@Service
public class MailService {

    private final Logger log = LoggerFactory.getLogger(MailService.class);

    private static final String USER = "user";

    private static final String BASE_URL = "baseUrl";

    private final JavaMailSender javaMailSender;
    private final MessageSource messageSource;
    private final SpringTemplateEngine templateEngine;

    @Value(value = "spring.mail.username")
    private String emailAddress;


    public MailService(JavaMailSender javaMailSender, MessageSource messageSource, SpringTemplateEngine templateEngine) {
        this.javaMailSender = javaMailSender;
        this.messageSource = messageSource;
        this.templateEngine = templateEngine;
    }

    @Async
    public void sendEmail(String to, String subject, String content, boolean isMultipart, boolean isHtml) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper message = new MimeMessageHelper(mimeMessage, isMultipart, StandardCharsets.UTF_8.name());
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);

        javaMailSender.send(mimeMessage);
    }

    @Async
    public void sendEmailFromTemplate(User user, String templateName, String titleKey) throws MessagingException {

        Context context = new Context();
        context.setVariable(USER, user.getActivationKey());
        context.setVariable(BASE_URL, "http://localhost:8080/");
        String content = templateEngine.process(templateName, context);
        String subject = "Aktywacja konta";
        sendEmail(user.getUsername(), subject, content, false, true);
    }

    @Async
    public void sendActivationEmail(User user) throws MessagingException {
        sendEmailFromTemplate(user, "mail/activationEmail", "email.activation.title");
    }
}
