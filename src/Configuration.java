import java.io.BufferedReader;

public class Configuration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String number = null;
		try {
			BufferedReader br = new BufferedReader("c:/Libraries\Documents\config.txt");
			while ((this.number = br.readLine()) ! = null) {
				System.out.println(number);
			}catch(Exception e) {
				System.err.println();
			}
		}
	}

}
