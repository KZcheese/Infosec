import java.io.IOException;
import java.io.PrintWriter;

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
	public CommandLine() {
		String number = "9783936245";//change this number later
		String[] command =
		    {
		        "cmd",
		    };
		    try {
			Process p = Runtime.getRuntime().exec(command);
		    
		    new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
		    new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
		    PrintWriter stdin = new PrintWriter(p.getOutputStream());
		    //stdin.println("perl sendMsg.pl "+number+" \"your computer is being hacked lel\"");
		    stdin.println("echo foo");
		    // write any other commands you want here
		    stdin.close();
		    int returnCode = p.waitFor();
		    System.out.println("Return code = " + returnCode);
		    } catch(IOException err) {
		    		System.out.println("IOException oh noes probably at line 43");
		    } catch(InterruptedException errr) {
		    	System.out.println("InterruptedException oh noes probably at line 51");
		    }
		 }

	}


