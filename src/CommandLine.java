/**F
 * 
 */
import java.io.*;
/**
 * @author Gordon
 *
 */
public class CommandLine {
	class SyncPipe implements Runnable
	{
	public SyncPipe(InputStream istrm, OutputStream ostrm) {
	      istrm_ = istrm;
	      ostrm_ = ostrm;
	  }
	  public void run() {
	      try
	      {
	          final byte[] buffer = new byte[1024];
	          for (int length = 0; (length = istrm_.read(buffer)) != -1; )
	          {
	              ostrm_.write(buffer, 0, length);
	          }
	      }
	      catch (Exception e)
	      {
	          e.printStackTrace();
	      }
	  }
	  private final OutputStream ostrm_;
	  private final InputStream istrm_;
	}
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


