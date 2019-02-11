package com.blood.service;

import com.blood.pojo.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.List;

@Service("mailService")
public class MailService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private PatientService patientService;
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private TemplateEngine templateEngine;
    @Value("${spring.mail.username}") //change in application.properties
    private String from;
    public boolean sendNotification(List<Patient> patients) {
        for (Patient patient:patients) {
            if (patients.size() != 0) {
                MimeMessage message = mailSender.createMimeMessage();
                Context context = new Context();
                context.setVariable("firstName",patient.getForename());
                context.setVariable("lastName",patient.getSuername());
                String emailContent = templateEngine.process("notificationTemplate", context);
                try {
                    String email = patient.getEmail();
                    MimeMessageHelper helper = new MimeMessageHelper(message, true);
                    helper.setFrom(from);
                    helper.setTo(email);
                    helper.setSubject("Liver Test Notification");
                    helper.setText(emailContent, true);
                    mailSender.send(message);
                    logger.info("Send Successful");
                } catch (MessagingException e) {
                    logger.error("Send Failed！", e);
                }
            } else {
                return false;
            }
        }
        return true;
    }
    public boolean sendResult(Patient patient,String filePath) {
                MimeMessage message = mailSender.createMimeMessage();
                Context context = new Context();
                context.setVariable("firstName",patient.getForename());
                context.setVariable("lastName",patient.getSuername());
                String emailContent = templateEngine.process("resultTemplate", context);
                try {
                    String email = patient.getEmail();
                    FileSystemResource file = new FileSystemResource(new File(filePath));
                    MimeMessageHelper helper = new MimeMessageHelper(message, true);
                    String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
                    helper.addAttachment(fileName, file);
                    helper.setFrom(from);
                    helper.setTo(email);
                    helper.setSubject("Liver Test Result");
                    helper.setText(emailContent, true);
                    mailSender.send(message);
                    logger.info("Send Successful");
                    return true;
                } catch (MessagingException e) {
                    logger.error("Send Failed！", e);
                    return false;
                }
            }
    }
