import java.awt.EventQueue;
import java.awt.MouseInfo;
import java.awt.Point;
import java.io.IOException;

public class main {
	public static Point before = MouseInfo.getPointerInfo().getLocation();
	public static Point after;
	public static void main(String[] args) throws InterruptedException, IOException {
		/**
		 * Launch the application.
		 */
//		Runtime.getRuntime().exec("shutdown -f -s");

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

		loop();
	}

	Configuration config = new Configuration();

	public static void loop() throws InterruptedException {
		while (true) {
			System.out.println("POLLING");
			after = MouseInfo.getPointerInfo().getLocation();
			if(!after.equals(before)){
				System.out.println("ALERT");
				PhoneIO.sendText("9787609304", "MOUSE");
			}
			Thread.sleep(1000 * 30);
		}
	}
}
