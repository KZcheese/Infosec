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

public class DisplayGenerated extends JFrame {
	private JTextField txtPhoneNumber;
	private JTextField txtStatusHere;

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
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
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
		
		JComboBox comboBox = new JComboBox();
		sl_panel_1.putConstraint(SpringLayout.NORTH, comboBox, 10, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, comboBox, -124, SpringLayout.EAST, panel_1);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Manual", "Automatic (Requires Location)"}));
		panel_1.add(comboBox);
		
		JCheckBox chckbxEnableAlers = new JCheckBox("Enable Alerts");
		sl_panel_1.putConstraint(SpringLayout.NORTH, chckbxEnableAlers, 85, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, chckbxEnableAlers, 164, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, btnTestMessage, 0, SpringLayout.WEST, chckbxEnableAlers);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, btnTestMessage, -14, SpringLayout.NORTH, chckbxEnableAlers);
		panel_1.add(chckbxEnableAlers);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.NORTH);
		
		JLabel lblStatus = new JLabel("Status:");
		panel_2.add(lblStatus);
		
		txtStatusHere = new JTextField();
		txtStatusHere.setEditable(false);
		txtStatusHere.setText("Status Here");
		panel_2.add(txtStatusHere);
		txtStatusHere.setColumns(10);
	}
}
