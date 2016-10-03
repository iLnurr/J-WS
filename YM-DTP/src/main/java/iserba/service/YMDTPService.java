package iserba.service;

import mailSender.Sender;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class YMDTPService {
    private static final String EMAIL = "serbaevilnur@gmail.com";
    public void sendMessageAbout(String dtpEvent) {
        Properties passwordProps = new Properties();
        try (InputStream in = Files.newInputStream(Paths.get("/home/ilnur/repo/J-WS/mailSender/src/main/resources", "password.properties")))
        {
            passwordProps.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String password = passwordProps.getProperty("password");

        //        ssl
        Properties sslGMailProperties = new Properties();
        sslGMailProperties.put("mail.smtp.host", "smtp.gmail.com");
        sslGMailProperties.put("mail.smtp.socketFactory.port", "465");
        sslGMailProperties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        sslGMailProperties.put("mail.smtp.auth", "true");
        sslGMailProperties.put("mail.smtp.port", "465");
        sslGMailProperties.put("mail.smtp.ssl.enable", "true");
        sslGMailProperties.put("mail.smtp.ssl.trust", "*");
        Sender sslSender = new Sender(EMAIL, password, sslGMailProperties);

        sslSender.send("DTP", dtpEvent, "serbaevilnur@gmail.com", "serbaevilnur@mail.ru");
//        sslSender.send("DTP", dtpEvent, "serbaevilnur@gmail.com", "yandex@mobiagency.ru");
    }
}
