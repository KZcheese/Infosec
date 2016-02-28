import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Configuration {

	public String Configuration() {
		String number = "put number here";
		String str = "lel";
		try {
			BufferedReader br = new BufferedReader(new FileReader("config.txt"));
//			while ((number = br.readLine()) != null) {
//				System.out.println(number);
//				System.out.println("CONFIGURATION LOADED");
//			}
			br.close();
		} catch (FileNotFoundException e) {
			// System.err.println("make the configuration file");
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter("config.txt"));
				bw.write(number);
				//bw.write(str);
				bw.close();
			} catch (IOException errrrrrrrr) {
				// lel
			}
		} catch (IOException e) {
			// ioexception thing
		}
		return number;
	}

	public String parseCommands() {	
		try {
			String output = "lel";
			BufferedReader cl = new BufferedReader(new FileReader("c:/filepathhere"));
			String c;
			while ((c = cl.readLine()) != null) {
				String[] checkr = c.split("");
				if (checkr[0] != "$") {
					return c;
				} else {
					switch (c) {
					case "$shutdown":
						output = "shutdown";
						cl.close();
					case "$logoff":
						output = "logoff";
						cl.close();
					case "$mute":
						output = "mute";
						cl.close();
					case "$test":
						output = "test";
						cl.close();
					}
				}
			}
			cl.close();
			return output;

		} catch (FileNotFoundException err) {
			return "something went wrong";
		} catch (IOException er) {
			return "something went wrong";
		}
	}
}
