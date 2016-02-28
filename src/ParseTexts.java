import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ParseTexts {

	public static ArrayList<String> parseTexts(File f){
		
		ArrayList<String> commands = new ArrayList<String>();

		BufferedReader reader;
		
		try {
			reader = new BufferedReader(new FileReader(f));
			String line;
			
			while ((line = reader.readLine()) != null) {
				
				commands.add(line);

			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("Cannot Open Texts");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		return commands;
		
	}
	
}
