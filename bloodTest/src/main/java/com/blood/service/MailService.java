package com.blood.service;

import com.blood.pojo.Patient;
import com.blood.pojo.PreviousTest;
import com.blood.pojo.TestSchedule;
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
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service("mailService")
public class MailService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private PatientService patientService;
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private TemplateEngine templateEngine;
    @Autowired
    private TestScheduleService testScheduleService;
    @Autowired
    private PreviousTestService previousTestService;

    @Value("${spring.mail.username}") // change in application.properties
    private String from;

    public boolean sendNotification() {
        List<TestSchedule> testSchedules = testScheduleService.findAll();
        for (TestSchedule testSchedule : testSchedules) {
            if (testSchedules.size() != 0) {
                Date date = new Date();
                long diff = testSchedule.getDate().getTime() - date.getTime();
                if ((TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) < 8) && !testSchedule.isNotified()
                        && testSchedule.getPatient().getEmail() != null) {
                    Patient patient = testSchedule.getPatient();
                    MimeMessage message = mailSender.createMimeMessage();
                    String location = patient.getLocal_hospital();
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date now = testSchedule.getDate();
                    String str = df.format(now);
                    Context context = new Context();
                    context.setVariable("firstName", patient.getForename());
                    context.setVariable("lastName", patient.getSurname());
                    context.setVariable("testTime", str);
                    context.setVariable("location", location);
                    String emailContent = templateEngine.process("sendAutomatedEmailTest", context);
                    try {
                        String email = patient.getEmail();
                        MimeMessageHelper helper = new MimeMessageHelper(message, true);
                        helper.setFrom(from);
                        helper.setTo(email);
                        helper.setSubject("Liver Test Notification");
                        helper.setText(emailContent, true);
                        mailSender.send(message);
                        testSchedule.setNotified(true);
                        testScheduleService.save(testSchedule);
                    } catch (MessagingException e) {
                        logger.error("Send Failed！", e);
                    }
                }
            } else {
                return false;
            }
        }
        return true;
    }

    // TOBE MODIFED WTH PATIENT INFO ATTACHMENT
    public boolean sendResult(String filePath, Patient patient, TestSchedule test) {
        MimeMessage message = mailSender.createMimeMessage();
        Context context = new Context();
        context.setVariable("firstName", patient.getForename());
        context.setVariable("lastName", patient.getSurname());
        context.setVariable("testTime", test.getDate());
        context.setVariable("location", test.getLocation());
        String emailContent = templateEngine.process("sendAutomatedEmailTest", context);
        try {
            String email = patient.getEmail();
            FileSystemResource file = new FileSystemResource(new File(filePath));
            System.out.println(file.getPath());
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            // String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
            String fileName = patient.getForename() + "_result.pdf";
            helper.addAttachment(fileName, file);
            helper.setFrom(from);
            helper.setTo(email);
            helper.setSubject("Liver Test Result");
            helper.setText(emailContent, true);
            mailSender.send(message);
            try {
                Path path = Paths.get(filePath);
                Files.deleteIfExists(path);
            } catch (NoSuchFileException x) {
                System.err.format("%s: no such" + " file or directory%n", filePath);
            } catch (DirectoryNotEmptyException x) {
                System.err.format("%s not empty%n", filePath);
            } catch (IOException x) {
                // File permission problems are caught here.
                System.err.println(x);
            }
            test.setResultSent(true);
            testScheduleService.save(test);
            //Keep record of this test
            PreviousTest prevT = new PreviousTest(test.getLocation(), test.getDate(), test.getCommet());
            prevT.setPatient(patient);
            previousTestService.save(prevT);
            logger.info("Send Successful");

            return true;
        } catch (MessagingException e) {
            logger.error("Send Failed！", e);
            return false;
        }
    }

    public boolean sendDeleteResult(Patient patient) {
        MimeMessage message = mailSender.createMimeMessage();
        Context context = new Context();
        context.setVariable("firstName", patient.getForename());
        context.setVariable("lastName", patient.getSurname());
        String emailContent = templateEngine.process("deleteTestEmailTemplate", context);
        try {
            String email = patient.getEmail();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(email);
            helper.setSubject("Delete Alert");
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