import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SpringLayout;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JSlider;
import java.awt.TextField;
import java.awt.Choice;
import java.awt.Label;

public class DisplayGenerated extends JFrame {
	private JTextField txtPhoneNumber;
	private JTextField txtStatusHere;
	private JTextField txtKevinwzhangmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	}

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
		
		txtKevinwzhangmail = new JTextField();
		txtKevinwzhangmail.setText("Email");
		panel.add(txtKevinwzhangmail);
		txtKevinwzhangmail.setColumns(10);
		
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
		
		JButton btnTestMessage = new JButton("Test Message");
		panel_1.add(btnTestMessage);
		
		JCheckBox chckbxEnableAlers = new JCheckBox("Mute All");
		sl_panel_1.putConstraint(SpringLayout.NORTH, chckbxEnableAlers, 85, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, chckbxEnableAlers, 164, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, btnTestMessage, 0, SpringLayout.WEST, chckbxEnableAlers);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, btnTestMessage, -14, SpringLayout.NORTH, chckbxEnableAlers);
		panel_1.add(chckbxEnableAlers);
		
		JCheckBox chckbxSendToPhone = new JCheckBox("Send to Phone");
		sl_panel_1.putConstraint(SpringLayout.NORTH, chckbxSendToPhone, 6, SpringLayout.SOUTH, chckbxEnableAlers);
		sl_panel_1.putConstraint(SpringLayout.WEST, chckbxSendToPhone, 0, SpringLayout.WEST, btnTestMessage);
		panel_1.add(chckbxSendToPhone);
		
		JCheckBox chckbxSendToEmail = new JCheckBox("Send to Email");
		sl_panel_1.putConstraint(SpringLayout.NORTH, chckbxSendToEmail, 6, SpringLayout.SOUTH, chckbxSendToPhone);
		sl_panel_1.putConstraint(SpringLayout.WEST, chckbxSendToEmail, 0, SpringLayout.WEST, btnTestMessage);
		panel_1.add(chckbxSendToEmail);
		
		JComboBox comboBox = new JComboBox();
		sl_panel_1.putConstraint(SpringLayout.NORTH, comboBox, 10, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, comboBox, 154, SpringLayout.WEST, panel_1);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Automatic (Location)", "Manual"}));
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
		
		JPanel panel_3 = new JPanel();
		getContentPane().add(panel_3, BorderLayout.EAST);
		SpringLayout sl_panel_3 = new SpringLayout();
		panel_3.setLayout(sl_panel_3);
		
		JSlider slider = new JSlider();
		sl_panel_1.putConstraint(SpringLayout.NORTH, slider, 28, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, slider, -11, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, slider, -23, SpringLayout.EAST, panel_1);
		sl_panel_3.putConstraint(SpringLayout.EAST, slider, 0, SpringLayout.EAST, panel_1);
		panel_1.add(slider);
		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setOrientation(SwingConstants.VERTICAL);
		slider.setMinorTickSpacing(5);
		slider.setMajorTickSpacing(20);
		
		Label label = new Label("Distance");
		sl_panel_1.putConstraint(SpringLayout.NORTH, label, 0, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, label, -23, SpringLayout.EAST, panel_1);
		label.setAlignment(Label.CENTER);
		panel_1.add(label);
	}
}
