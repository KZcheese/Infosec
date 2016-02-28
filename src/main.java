import java.awt.EventQueue;
import java.awt.MouseInfo;
import java.awt.Point;
import java.io.IOException;

public class Main {
//	Detector detector = new Detector();
	Point before = MouseInfo.getPointerInfo().getLocation();
	Point after;
	public static void main(String[] args) throws InterruptedException, IOException {
		/**
		 * Launch the application.
		 */
		// Runtime.getRuntime().exec("shutdown -f -s");

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayGenerated frame = new DisplayGenerated();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		Main main = new Main();
		main.loop();
	}

	Configuration config = new Configuration();

	public void loop() throws InterruptedException {
		while (true) {
			after = MouseInfo.getPointerInfo().getLocation();
			if(!before.equals(after)){
//			System.out.println("POLLING");
//			if (detector.getMouseTriggered()
//			 || detector.getKeyTriggered()) {
//			) {
				System.out.println("ALERT");
				before = after;
				// PhoneIO.sendText("9787609304", "MOUSE");
			}
			Thread.sleep(1000 * 10);
		}
	}

}
