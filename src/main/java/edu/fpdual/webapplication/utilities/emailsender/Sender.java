package edu.fpdual.webapplication.utilities.emailsender;

import lombok.Getter;
import lombok.Setter;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.*;
import java.util.Properties;

public class Sender {

    @Setter
    @Getter
    Properties mailProp = new Properties();
    @Setter
    @Getter
    Properties credentialProp = new Properties();

    /**
     * Build the sender class loading the properties from mail and credentials files.
     */
    public Sender() {
        try {
            mailProp.load(getClass().getClassLoader().getResourceAsStream("mail.properties"));
            credentialProp.load(getClass().getClassLoader().getResourceAsStream("credentials.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Send a simple email with from and recipient address, subject and a simple HTML format content.
     *
     * @param to      recipient email address
     * @param subject email subject
     * @param content email content in html format
     * @return a {@link boolean} indicating if the email was sent or not.
     */
    public boolean send(String to, String subject, String content) {
        boolean result;
        Session session = createSession();

        try {
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(credentialProp.getProperty(CredentialsConstants.USER)));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            message.setSubject(subject);

            message.setContent(content, "text/html");

            System.out.println("sending...");
            Transport.send(message);
            System.out.println("Sent message successfully....");
            result = true;
        } catch (MessagingException mex) {
            mex.printStackTrace();
            result = false;
        }

        return result;
    }

    /**
     * Send an email with from and recipient address, subject, d a simple HTML format content and an attached file.
     *
     * @param to      recipient email address
     * @param subject email subject
     * @param text    email content in html format
     * @param content path where the temp file is located
     * @return a {@link boolean} indicating if the email was sent or not.
     */
    public boolean send(String to, String subject, String text, String content) throws FileNotFoundException, IOException {
        boolean result = false;
        boolean finished = false;
        Session session = createSession();
        try {
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(credentialProp.getProperty(CredentialsConstants.USER)));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            message.setSubject(subject);

            BodyPart texto = new MimeBodyPart();
            texto.setContent(text, "text/html");

            File file = new File(content);

            InputStream fileData = getClass().getClassLoader().getResourceAsStream("mail.properties");

            try (FileOutputStream outputStream = new FileOutputStream(file, false)) {
                int read;
                byte[] bytes = new byte[8192];
                while ((read = fileData.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, read);
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
                finished = true;
            }
            if (!finished) {
                BodyPart fichero = new MimeBodyPart();
                fichero.setDataHandler(new DataHandler(new FileDataSource(file)));
                fichero.setFileName(file.getName());

                Multipart multiPart = new MimeMultipart();
                multiPart.addBodyPart(texto);
                multiPart.addBodyPart(fichero);

                message.setContent(multiPart);

                System.out.println("sending...");
                Transport.send(message);
                System.out.println("Sent message successfully....");
                result = true;
            }

        } catch (MessagingException | NullPointerException mex) {
            mex.printStackTrace();
        }
        return result;
    }

    private Session createSession() {
        Session session = Session.getInstance(mailProp, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(credentialProp.getProperty(CredentialsConstants.USER),
                        credentialProp.getProperty(CredentialsConstants.PASSWD));
            }
        });
        session.setDebug(true);
        return session;
    }
}
