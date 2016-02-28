import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
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
	private JTextField phoneField;
	private JTextField statusField;
	JSpinner spinner = new JSpinner();
	// private JTextField emailField;
	public JCheckBox muteBox = new JCheckBox("Mute All");
	public JButton test = new JButton("Test Message");
	public boolean testBool = false;
	public JCheckBox phoneBox = new JCheckBox("Send to Phone");
	public JCheckBox emailBox = new JCheckBox("Send to Email");
	private JMenuItem quit = new JMenuItem("Quit");
	public String status = "Okay";
	public int interval = 1;
	// private String email = "Insert Email here";
	public boolean muted = false;
	// sendPhone = false, sendEmail = false;

	/**
	 * Create the frame.
	 * 
	 * @throws UnsupportedLookAndFeelException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	public DisplayGenerated() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException {
		this.setVisible(true);
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);

		// JLabel lblEmailAddress = new JLabel("Email Address:");
		// panel.add(lblEmailAddress);

		// emailField = new JTextField();
		// emailField.setText(email);
		// panel.add(emailField);
		// emailField.setColumns(10);

		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		panel.add(lblPhoneNumber);

		phoneField = new JTextField();
		phoneField.setText("Enter Your Number Here");
		phoneField.setVisible(true);
		phoneField.setColumns(15);
		phoneField.addActionListener(this);
		phoneField.setActionCommand("number");
		panel.add(phoneField);

		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		SpringLayout sl_panel_1 = new SpringLayout();
		sl_panel_1.putConstraint(SpringLayout.EAST, test, -33, SpringLayout.WEST, emailBox);
		sl_panel_1.putConstraint(SpringLayout.WEST, muteBox, 239, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.NORTH, emailBox, 115, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, emailBox, -45, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, muteBox, -6, SpringLayout.NORTH, phoneBox);
		sl_panel_1.putConstraint(SpringLayout.NORTH, phoneBox, 89, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, phoneBox, 0, SpringLayout.WEST, muteBox);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, phoneBox, -6, SpringLayout.NORTH, emailBox);
		sl_panel_1.putConstraint(SpringLayout.WEST, emailBox, 0, SpringLayout.WEST, muteBox);
		panel_1.setLayout(sl_panel_1);
		test.setVisible(true);

		test.addActionListener(this);
		test.setActionCommand("test");
		panel_1.add(test);
		muteBox.setVisible(true);
		muteBox.addActionListener(this);
		muteBox.setSelected(muted);
		muteBox.setActionCommand("mute");
		panel_1.add(muteBox);
		// phoneBox.addActionListener(this);
		// phoneBox.setSelected(sendPhone);
		// phoneBox.setActionCommand("phone");
		// panel_1.add(phoneBox);
		// emailBox.addActionListener(this);
		// emailBox.setSelected(sendPhone);
		// emailBox.setActionCommand("email");
		// panel_1.add(emailBox);

		JButton btnOpenLog = new JButton("Open Log");
		btnOpenLog.setVisible(false);
		btnOpenLog.setEnabled(false);
		sl_panel_1.putConstraint(SpringLayout.NORTH, test, 17, SpringLayout.SOUTH, btnOpenLog);
		sl_panel_1.putConstraint(SpringLayout.WEST, test, 0, SpringLayout.WEST, btnOpenLog);
		sl_panel_1.putConstraint(SpringLayout.NORTH, btnOpenLog, 0, SpringLayout.NORTH, muteBox);
		sl_panel_1.putConstraint(SpringLayout.EAST, btnOpenLog, -29, SpringLayout.WEST, muteBox);
		panel_1.add(btnOpenLog);

		spinner.setModel(new SpinnerNumberModel(interval, 0, 60, 1));
		spinner.addChangeListener(this);
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

		statusField = new JTextField();
		statusField.setEditable(false);
		statusField.setText(status);
		panel_2.add(statusField);
		statusField.setColumns(10);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		quit.addActionListener(this);
		quit.setActionCommand("quit");
		mnFile.add(quit);
	}

	public String getNumber() {
		return phoneField.getText();
	}

	@Override
	public void stateChanged(ChangeEvent c) {
		interval = (int) spinner.getValue();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String message = e.getActionCommand();
		if (message.equalsIgnoreCase("test")) {
			testBool = true;
		} else if (message.equalsIgnoreCase("mute")) {
			muted = muteBox.isSelected();
		} else if (message.equalsIgnoreCase("quit")) {
			System.exit(0);
		}
	}
}
