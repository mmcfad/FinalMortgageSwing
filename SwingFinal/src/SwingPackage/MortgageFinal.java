package SwingPackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class MortgageFinal {

	private JFrame frame;
	private JTextField TGI;
	private JTextField TMD;
	private JTextField Intrate;
	private JTextField downpayment;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JTextField housingpay;
	private JTextField housingother;
	private JTextField maxpay;
	private JTextField financedmorg;
	private JLabel lblNewLabel_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MortgageFinal window = new MortgageFinal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MortgageFinal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		TGI = new JTextField();
		TGI.setBounds(124, 24, 86, 20);
		panel.add(TGI);
		TGI.setColumns(10);
		final double tgi = Double.parseDouble(TGI.getText());
		
		
		TMD = new JTextField();
		TMD.setBounds(124, 55, 86, 20);
		panel.add(TMD);
		TMD.setColumns(10);
		final double tmd = Double.parseDouble(TMD.getText());
		
		Intrate = new JTextField();
		Intrate.setBounds(124, 86, 86, 20);
		panel.add(Intrate);
		Intrate.setColumns(10);
		final double intrate = Double.parseDouble(Intrate.getText());
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"10", "15", "30"}));
		comboBox.setBounds(162, 120, 48, 20);
		panel.add(comboBox);
		final int term = ((Integer)comboBox.getSelectedItem()).intValue();
		
		downpayment = new JTextField();
		downpayment.setEnabled(false);
		downpayment.setBounds(124, 151, 86, 20);
		panel.add(downpayment);
		downpayment.setColumns(10);
		double DP = Double.parseDouble(downpayment.getText());
		
		JButton btnNewButton = new JButton("Down Payment");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (downpayment.isEnabled() == false){
					downpayment.setEnabled(true);
				}
				
			}
		});
		btnNewButton.setBounds(10, 150, 104, 23);
		panel.add(btnNewButton);
		
		lblNewLabel = new JLabel("Total Gross Inc.");
		lblNewLabel.setBounds(10, 27, 89, 14);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Total Monthly Debt");
		lblNewLabel_1.setBounds(10, 61, 104, 14);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Interest Rate");
		lblNewLabel_2.setBounds(10, 92, 89, 14);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Term (In years)");
		lblNewLabel_3.setBounds(10, 123, 89, 14);
		panel.add(lblNewLabel_3);
		
		btnNewButton_1 = new JButton("Calculate");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double HP1 = (tgi/12)*.18;
				double HP2 = (tgi/12)*.36 - tmd;
				double monthlyPayment;
				housingpay.setText(Double.toString(HP1));
				housingother.setText(Double.toString(HP2));
				if (HP1 < HP2){
					
					monthlyPayment = HP1;
				}
				else {

					monthlyPayment = HP2;
				}
				double numOfPayments = term / 12;
				double monthlyInt = intrate / 12;
				double PV = monthlyPayment / Math.pow(1 + monthlyInt,numOfPayments);
				maxpay.setText(Double.toString(monthlyPayment));
				financedmorg.setText(Double.toString(PV));
				
			}
		});
		btnNewButton_1.setBounds(121, 180, 89, 23);
		panel.add(btnNewButton_1);
		
		lblNewLabel_8 = new JLabel("Housing Payment");
		lblNewLabel_8.setBounds(264, 27, 83, 14);
		panel.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("\" \" + Other");
		lblNewLabel_9.setBounds(274, 58, 73, 14);
		panel.add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("Max Payment Allowed");
		lblNewLabel_10.setBounds(242, 92, 105, 14);
		panel.add(lblNewLabel_10);
		
		lblNewLabel_11 = new JLabel("Amt of Financed Mortgage");
		lblNewLabel_11.setBounds(220, 123, 127, 14);
		panel.add(lblNewLabel_11);
		
		housingpay = new JTextField();
		housingpay.setText("0");
		housingpay.setBounds(357, 24, 67, 20);
		panel.add(housingpay);
		housingpay.setColumns(10);
		
		housingother = new JTextField();
		housingother.setText("0");
		housingother.setColumns(10);
		housingother.setBounds(357, 55, 67, 20);
		panel.add(housingother);
		
		maxpay = new JTextField();
		maxpay.setText("0");
		maxpay.setColumns(10);
		maxpay.setBounds(357, 89, 67, 20);
		panel.add(maxpay);
		
		financedmorg = new JTextField();
		financedmorg.setText("0");
		financedmorg.setColumns(10);
		financedmorg.setBounds(357, 120, 67, 20);
		panel.add(financedmorg);
		
		lblNewLabel_4 = new JLabel("Mortgage Estimator");
		lblNewLabel_4.setBounds(182, -1, 94, 14);
		panel.add(lblNewLabel_4);
	}
}
