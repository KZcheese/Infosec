import java.awt.EventQueue;

public class main {

	public static void main(String[] args) throws InterruptedException {
		/**
		 * Launch the application.
		 */

		
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
	
	public static void loop() throws InterruptedException{
		while(true){
			System.out.println("POLLING");
			Thread.sleep(1000);

		}
		
		
	}
	// CommandLine cmdLine = new CommandLine();
}
