import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Configuration {

	public String Configuration() {
		String number = null;
		String str = "lel";
		try {
			BufferedReader br = new BufferedReader(new FileReader("c:/config.txt"));
			while ((number = br.readLine()) != null) {
				System.out.println(number);
				System.out.println("CONFIGURATION LOADED");
			}
			br.close();
		} catch (FileNotFoundException e) {
			//System.err.println("make the configuration file");
			try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("config.txt"));
			bw.write(number);
			bw.write(str);
			bw.close();
			} catch(IOException errrrrrrrr) {
				//lel
			}
		} catch (IOException e) {
			// ioexception thing
		}
		return number;
	}
}
