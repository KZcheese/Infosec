import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpringLayout;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class DisplayGenerated extends JFrame implements ActionListener, ChangeListener {
	private JTextField txtPhoneNumber;
	private JTextField txtStatusHere;
	private JTextField txtEmail;
	private JCheckBox chckbxMute = new JCheckBox("Mute All");
	private JButton btnTestMessage = new JButton("Test Message");
	private JCheckBox chckbxSendToPhone = new JCheckBox("Send to Phone");
	private JCheckBox chckbxSendToEmail = new JCheckBox("Send to Email");
	private JCheckBoxMenuItem chckbxmntmMinimizeOnClose = new JCheckBoxMenuItem("Minimize on Close");
	private JMenuItem mntmQuit = new JMenuItem("Quit");

	/**
	 * Create the frame.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public DisplayGenerated() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);

		JLabel lblEmailAddress = new JLabel("Email Address:");
		panel.add(lblEmailAddress);

		txtEmail = new JTextField();
		txtEmail.setText("Email");
		panel.add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		panel.add(lblPhoneNumber);

		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setText("Phone Number");
		panel.add(txtPhoneNumber);
		txtPhoneNumber.setColumns(10);

		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		SpringLayout sl_panel_1 = new SpringLayout();
		sl_panel_1.putConstraint(SpringLayout.EAST, btnTestMessage, -33, SpringLayout.WEST, chckbxSendToEmail);
		sl_panel_1.putConstraint(SpringLayout.WEST, chckbxMute, 239, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.NORTH, chckbxSendToEmail, 115, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, chckbxSendToEmail, -45, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, chckbxMute, -6, SpringLayout.NORTH, chckbxSendToPhone);
		sl_panel_1.putConstraint(SpringLayout.NORTH, chckbxSendToPhone, 89, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, chckbxSendToPhone, 0, SpringLayout.WEST, chckbxMute);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, chckbxSendToPhone, -6, SpringLayout.NORTH, chckbxSendToEmail);
		sl_panel_1.putConstraint(SpringLayout.WEST, chckbxSendToEmail, 0, SpringLayout.WEST, chckbxMute);
		panel_1.setLayout(sl_panel_1);

		btnTestMessage.addActionListener(this);
		btnTestMessage.setActionCommand("test");
		panel_1.add(btnTestMessage);
		chckbxMute.addActionListener(this);
		chckbxMute.setActionCommand("mute");
		panel_1.add(chckbxMute);
		chckbxSendToPhone.addActionListener(this);
		chckbxSendToPhone.setActionCommand("phone");
		panel_1.add(chckbxSendToPhone);
		chckbxSendToEmail.addActionListener(this);
		chckbxSendToEmail.setActionCommand("email");
		panel_1.add(chckbxSendToEmail);
		
		JButton btnOpenLog = new JButton("Open Log");
		sl_panel_1.putConstraint(SpringLayout.NORTH, btnTestMessage, 17, SpringLayout.SOUTH, btnOpenLog);
		sl_panel_1.putConstraint(SpringLayout.WEST, btnTestMessage, 0, SpringLayout.WEST, btnOpenLog);
		sl_panel_1.putConstraint(SpringLayout.NORTH, btnOpenLog, 0, SpringLayout.NORTH, chckbxMute);
		sl_panel_1.putConstraint(SpringLayout.EAST, btnOpenLog, -29, SpringLayout.WEST, chckbxMute);
		panel_1.add(btnOpenLog);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 0, 60, 1));
		panel_1.add(spinner);
		
		JLabel lblMessageInterval = new JLabel("Minutes to Mute After Alert");
		sl_panel_1.putConstraint(SpringLayout.NORTH, spinner, -3, SpringLayout.NORTH, lblMessageInterval);
		sl_panel_1.putConstraint(SpringLayout.WEST, spinner, 9, SpringLayout.EAST, lblMessageInterval);
		sl_panel_1.putConstraint(SpringLayout.WEST, btnOpenLog, 0, SpringLayout.WEST, lblMessageInterval);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblMessageInterval, -138, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblMessageInterval, 107, SpringLayout.WEST, panel_1);
		panel_1.add(lblMessageInterval);

		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.NORTH);

		JLabel lblStatus = new JLabel("Status:");
		panel_2.add(lblStatus);

		txtStatusHere = new JTextField();
		txtStatusHere.setEditable(false);
		txtStatusHere.setText("Status Here");
		panel_2.add(txtStatusHere);
		txtStatusHere.setColumns(10);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		chckbxmntmMinimizeOnClose.addActionListener(this);
		chckbxmntmMinimizeOnClose.setActionCommand("minimize");
		mnFile.add(chckbxmntmMinimizeOnClose);

		mntmQuit.addActionListener(this);
		mntmQuit.setActionCommand("quit");
		mnFile.add(mntmQuit);
	}

	@Override
	public void stateChanged(ChangeEvent c) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String message = e.getActionCommand();
		if (message.equalsIgnoreCase("test")) {
		} else if (message.equalsIgnoreCase("mute")) {
		} else if (message.equalsIgnoreCase("phone")) {
		} else if (message.equalsIgnoreCase("email")) {
		} else if (message.equalsIgnoreCase("minimize")) {
		}
		else if (message.equalsIgnoreCase("quit")){
			System.exit(0);
		}
	}
}
