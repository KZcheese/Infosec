import java.awt.BorderLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
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
	private JComboBox comboBox = new JComboBox();
	private JSlider slider = new JSlider();
	private JCheckBoxMenuItem chckbxmntmMinimizeOnClose = new JCheckBoxMenuItem("Minimize on Close");
	private JMenuItem mntmQuit = new JMenuItem("Quit");

	/**
	 * Create the frame.
	 */
	public DisplayGenerated() {
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
		panel_1.setLayout(sl_panel_1);

		btnTestMessage.addActionListener(this);
		btnTestMessage.setActionCommand("test");
		panel_1.add(btnTestMessage);

		sl_panel_1.putConstraint(SpringLayout.NORTH, chckbxMute, 85, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, chckbxMute, 164, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, btnTestMessage, 0, SpringLayout.WEST, chckbxMute);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, btnTestMessage, -14, SpringLayout.NORTH, chckbxMute);
		chckbxMute.addActionListener(this);
		chckbxMute.setActionCommand("mute");
		panel_1.add(chckbxMute);

		sl_panel_1.putConstraint(SpringLayout.NORTH, chckbxSendToPhone, 6, SpringLayout.SOUTH, chckbxMute);
		sl_panel_1.putConstraint(SpringLayout.WEST, chckbxSendToPhone, 0, SpringLayout.WEST, btnTestMessage);
		chckbxSendToPhone.addActionListener(this);
		chckbxSendToPhone.setActionCommand("phone");
		panel_1.add(chckbxSendToPhone);

		sl_panel_1.putConstraint(SpringLayout.NORTH, chckbxSendToEmail, 6, SpringLayout.SOUTH, chckbxSendToPhone);
		sl_panel_1.putConstraint(SpringLayout.WEST, chckbxSendToEmail, 0, SpringLayout.WEST, btnTestMessage);
		chckbxSendToEmail.addActionListener(this);
		chckbxSendToEmail.setActionCommand("email");
		panel_1.add(chckbxSendToEmail);

		sl_panel_1.putConstraint(SpringLayout.NORTH, comboBox, 10, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, comboBox, 154, SpringLayout.WEST, panel_1);
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Automatic (Location)", "Manual" }));
		comboBox.addActionListener(this);
		comboBox.setActionCommand("combo");
		panel_1.add(comboBox);

		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.NORTH);

		JLabel lblStatus = new JLabel("Status:");
		panel_2.add(lblStatus);

		txtStatusHere = new JTextField();
		txtStatusHere.setEditable(false);
		txtStatusHere.setText("Status Here");
		panel_2.add(txtStatusHere);
		txtStatusHere.setColumns(10);

		sl_panel_1.putConstraint(SpringLayout.NORTH, slider, 28, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, slider, -11, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, slider, -23, SpringLayout.EAST, panel_1);
		panel_1.add(slider);
		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setOrientation(SwingConstants.VERTICAL);
		slider.setMinorTickSpacing(5);
		slider.setMajorTickSpacing(20);
		slider.addChangeListener(this);

		Label label = new Label("Distance");
		sl_panel_1.putConstraint(SpringLayout.NORTH, label, 0, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, label, -23, SpringLayout.EAST, panel_1);
		label.setAlignment(Label.CENTER);
		panel_1.add(label);

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
		} else if (message.equalsIgnoreCase("combo")) {
			slider.setEnabled(comboBox.getSelectedIndex() == 0);
		} else if (message.equalsIgnoreCase("minimize")) {
		}
	}
}
