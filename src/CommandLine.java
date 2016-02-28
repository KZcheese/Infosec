import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
	String number;
	String[] command;
	
	public CommandLine(ArrayList<String> commands) {

		for(String command: commands){
			if (command == "shutdown") {
				System.out.println("shutdown -f -s");
			}
			if (command == "logoff") {
				System.out.println("logoff");
			}
			if (command == "sleep") {
				System.out.println("powercfg -hibernate off");
			}
		}

	
	}

}
