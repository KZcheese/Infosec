import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**F
 * 
 */
//import java.io.*;
/**
 * @author Gordon
 *
 */
public class CommandLine {

	/**
	 * @param args
	 */
	public CommandLine(String task) {
		String number = "9783936245";// change this number later
		String[] command = { "cmd", };
		try {
			Process p = Runtime.getRuntime().exec(command);

			new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
			new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
			PrintWriter stdin = new PrintWriter(p.getOutputStream());
			if (task == "shutdown") {
				stdin.println("shutdown -f -s");
			}
			if (task == "logoff") {
				stdin.println("logoff");
			}
			if (task == "sleep") {
				stdin.println("powercfg -hibernate off");
			}
			// stdin.println("perl sendMsg.pl "+number+" \"your computer is
			// being hacked lel\"");
			stdin.println("echo foo");
			// write any other commands you want here
			stdin.close();
			int returnCode = p.waitFor();
			System.out.println("Return code = " + returnCode);
		} catch (IOException err) {
			System.out.println("IOException oh noes probably at line 43");
		} catch (InterruptedException errr) {
			System.out.println("InterruptedException oh noes probably at line 51");
		}
	}
	
	public void sendEmail(String title, String body, String sender, String password, String receiver) {
	      String to = receiver;

	      String from = sender;

	      String host = "localhost";

	      Properties properties = System.getProperties();

	      properties.setProperty("mail.smtp.host", host);

	      Session session = Session.getDefaultInstance(properties);

	      try{
	         // Create a default MimeMessage object.
	         MimeMessage message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));

	         // Set To: header field of the header.
	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

	         // Set Subject: header field
	         message.setSubject(title);

	         // Now set the actual message
	         message.setText(body);

	         // Send message
	         Transport.send(message);
	         System.out.println("Sent message successfully....");
	      }catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
	}

}
