import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Configuration {

	public String Configuration() {
		String number = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader("c:/config.txt"));
			while ((number = br.readLine()) != null) {
				System.out.println(number);
				System.out.println("CONFIGURATION LOADED");
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.err.println("make the configuration file");
		} catch (IOException e) {
			// ioexception thing
		}
		return number;
	}
}
