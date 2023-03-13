package IS442_Quantum.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Service
public class EmailNotificationService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String toEmailAddress, String subject, String body) {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setFrom("quantum.leap.oop@gmail.com");
        email.setTo(toEmailAddress);
        email.setSubject(subject);
        email.setText(body);
        try {
            mailSender.send(email);
            System.out.println("Email Sent Successfully!");
        } catch (Exception e) {
            System.out.println("Email Failed to Send!");
        } finally {
            System.out.println("Email Notification Service Executed");
        }
    }

}
