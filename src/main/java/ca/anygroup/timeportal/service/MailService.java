package ca.anygroup.timeportal.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailService {

	public static void sendMail(String toEmailAddress, String subject, String messageText) throws Exception {

		try {

			Properties prop = new Properties();
			 InputStream input = MailService.class.getResourceAsStream("/mailConfig.properties");
			// load a properties file
			prop.load(input);


			String username = prop.getProperty("username");
			String password = prop.getProperty("password");
			String fromEmailAddress = prop.getProperty("mail.from");
			
			mailIt(prop,username,password,fromEmailAddress,toEmailAddress,subject,messageText);

			

		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}
	
	private static void mailIt(Properties properties,
			final String username, final String password,
			String fromEmailAddress, String toEmailAddress,
			String subject, String messageText) throws Exception {
		Session session = Session.getInstance(properties,
				new Authenticator() {
			@Override
			protected PasswordAuthentication
			getPasswordAuthentication() {
				return new PasswordAuthentication(username,
						password);
			}
		});
		try {
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(fromEmailAddress));
			msg.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(toEmailAddress));
			msg.setSubject(subject);
			msg.setText(messageText);
			Transport.send(msg);
		} catch (Exception ex) {
			throw new Exception(ex);
		}
	}
}
