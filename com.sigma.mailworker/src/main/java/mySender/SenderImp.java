package mySender;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class SenderImp implements Sender {
	private String mailDest = null;
	private String subject = "BlackJack Game";
	private String message = null;
	private String mailSrc = null;
	private String pass = null;
	public SenderImp(String email, String pass){
		mailSrc = email;
		this.pass=pass;
	}
	public String getSubject(){
		return subject;
	}
	public void setMailDest(String mail) {
		mailDest = mail;
	}

	public void setMessage(String mess) {
		message = mess;
	}

	public void setSubject(String subj) {
		subject = subj;
	}

	public void send() {
		Email email = new SimpleEmail();
        email.setHostName("smtp.googlemail.com");
        email.setSmtpPort(465);
        email.setSSLCheckServerIdentity(true);
        email.setStartTLSEnabled(true);
        email.setAuthenticator(new DefaultAuthenticator(mailSrc, pass));
        email.setSSLOnConnect(true);
        try {
			email.setFrom(mailSrc);
		} catch (EmailException e) {
			e.printStackTrace();
			return;
		}
        email.setSubject(subject);
        try {
			email.setMsg(message);
		} catch (EmailException e) {
			e.printStackTrace();
			return;
		}
        try {
			email.addTo(mailDest);
		} catch (EmailException e) {
			e.printStackTrace();
			return;
		}
        try {
			email.send();
		} catch (EmailException e) {
			e.printStackTrace();
			
		}
    	mailDest = null;
    	subject = "BlackJack Game";
    	message = null;
		
	}


}
