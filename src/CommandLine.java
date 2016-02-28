import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;


public class CommandLine {

	public static void DoCommands(ArrayList<String> commands) {

		for(String command: commands){
			System.out.println("COMMAND: "+ command);
			//COMMENT PRINTLN & UNCOMMENT RUNTIME COMMANDS
			if (command.equals("$shutdown")) {
				
				//Runtime.getRuntime().exec("shutdown -f -s");
				System.out.println("shutdown -f -s");
				
			}else if (command.equals("$logoff")) {
				
				//Runtime.getRuntime().exec("logoff");
				System.out.println("logoff");
				
			}else if (command.equals("$sleep")) {
				
				//Runtime.getRuntime().exec("powercfg -hibernate off");
				System.out.println("powercfg -hibernate off");
				
			}else if(command.charAt(0)=="$".charAt(0)){
				
				//Runtime.getRuntime().exec(command.substring(1));
				System.out.println(command.substring(1));
				
			}
			
		}
	
	}

}
