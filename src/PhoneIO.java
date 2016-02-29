import java.io.IOException;

public class PhoneIO {
	
	public static void sendText(String number, String text){
		
		try {
			Runtime.getRuntime().exec("perl C:/sendMsg.pl "+number+" "+text);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void recieveText(){
		try {
			
			Runtime.getRuntime().exec("perl C:/recieveMsg.pl");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
