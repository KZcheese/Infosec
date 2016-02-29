import java.awt.EventQueue;
import java.awt.MouseInfo;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.swing.UnsupportedLookAndFeelException;

public class Main2 {
	// Detector detector = new Detector();
	Point before = MouseInfo.getPointerInfo().getLocation();
	Point after;
	DisplayGenerated frame;
	String number = "";
	int timer = 0;
	int gtimer = 0;

	public Main2() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException, InvocationTargetException, InterruptedException {
		
		PhoneIO.recieveText();
		Thread.sleep(1000*5);
		
		EventQueue.invokeAndWait(new Runnable() {
			public void run() {
				try {
					frame = new DisplayGenerated();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException,
			InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, InvocationTargetException {
		/**
		 * Launch the application.
		 */
		// Runtime.getRuntime().exec("shutdown -f -s");

		Main2 main = new Main2();
		main.loop();
	}

	Configuration config = new Configuration();

	public void loop() throws InterruptedException {
		while (true) {
			if (timer <= 0) {
				after = MouseInfo.getPointerInfo().getLocation();
				number = frame.getNumber();
				if (!frame.muted && !before.equals(after)) {
					PhoneIO.sendText(number, "Alert!");
					System.out.println("alert " + number);
					before = after;
					timer = frame.interval * 20;
				}
			}
			if (gtimer == 0) {
				PhoneIO.recieveText();
				CommandLine.DoCommands(ParseTexts.parseTexts(new File("C:/Users/Admin/Desktop/texts")));
			}
			if (!frame.muted && frame.testBool) {
				System.out.println("test " + number);
				PhoneIO.sendText(number, "Test");
				frame.testBool = false;
			}
			if (timer > 0)
				timer--;

			gtimer++;
			gtimer %= 10;
			Thread.sleep(1000 * 1);
		}
	}

}
