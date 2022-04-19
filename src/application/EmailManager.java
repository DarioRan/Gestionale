package application;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailManager {
	
	String EmailSender="eshopranieri@gmail.com";
	String Server="smtp.gmail.com";
	String ServerPort="465";
	String destinatario=null;
	String Oggetto=null;
	String Testo=null;
	
	public void inviaMail(String xdest, String xogg, String xtesto ) 
	{
		destinatario=xdest;
		Oggetto=xogg;
		Testo=xtesto;
		Properties p=new Properties();
		p.put("mail.smtp.user", EmailSender );
		p.put("mail.smtp.host", Server);
		p.put("mail.smtp.port", ServerPort);
		p.put("mail.smtp.starttls.enable", true);
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.socketFactory.port", ServerPort);
		p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		p.put("mail.smtp.socketFactory.fallback", "false");
		SecurityManager security = System.getSecurityManager();
		
		try{  
			  Authenticator auth = new SMTPAuthenticator();
			  Session session = Session.getInstance(p, auth);
			  MimeMessage msg = new MimeMessage(session);
			  msg.setText(Testo);
			  msg.setSubject(Oggetto);
			  msg.setFrom(new InternetAddress(EmailSender));
			  msg.addRecipient(Message.RecipientType.TO,
			  new InternetAddress(destinatario));
			  Transport.send(msg);
			  System.out.println("Message send Successfully:)"); }
			  
			  catch (Exception mex){
			  mex.printStackTrace();}
			  
			  
			  
			 
	}
	 public class SMTPAuthenticator extends javax.mail.Authenticator
	  {
	  public PasswordAuthentication getPasswordAuthentication()
	  {
	  return new PasswordAuthentication("eshopranieri@gmail.com", "piadina1");
	  }
	  }
	
			

}
