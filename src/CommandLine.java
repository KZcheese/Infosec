import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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

public class CommandLine {

	public static void DoCommands(ArrayList<String> commands) throws IOException {

		for(String command: commands){
			
			if (command == "$shutdown") {
				Runtime.getRuntime().exec("shutdown -f -s");
			}
			if (command == "$logoff") {
				Runtime.getRuntime().exec("logoff");
			}
			if (command == "$sleep") {
				Runtime.getRuntime().exec("powercfg -hibernate off");
			}
			
		}
	
	}

}
