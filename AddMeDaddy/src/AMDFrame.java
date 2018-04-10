import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.sql.*;

import javax.swing.JButton;
//import java.awt.TextField;
import javax.swing.JComboBox;
//import javax.swing.DefaultComboBoxModel;

public class AMDFrame {

	private JFrame frameMain;
	private static JTextField txtFieldNrOne;
	private static JTextField txtFieldNrTwo;
	private static JTextField txtFieldSum;
	private JButton btnOperate = new JButton("Percuteaza");
	private String Operation;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		// Calculations calcClass = new Calculations();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AMDFrame window = new AMDFrame();
					window.frameMain.setVisible(true);
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					String url = "jdbc:sqlserver://172.17.0.88\\DORINGANDRABUR:1433;databaseName=AddMeDaddy;integratedSecurity=true";
					Connection conn = DriverManager.getConnection(url, "sql", "sql250#25");

					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
					System.err.println("D'oh! Got an exception!");
					System.err.println(e.getMessage());
				}

			}
		});
	}

	/**
	 * Create the application.
	 */
	public AMDFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameMain = new JFrame();
		frameMain.setBounds(100, 100, 652, 283);
		frameMain.setTitle("Adunare");
		frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMain.getContentPane().setLayout(null);

		txtFieldNrOne = new JTextField();
		txtFieldNrOne.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
		txtFieldNrOne.setBounds(46, 82, 118, 46);
		frameMain.getContentPane().add(txtFieldNrOne);
		txtFieldNrOne.setColumns(10);

		txtFieldNrTwo = new JTextField();
		txtFieldNrTwo.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
		txtFieldNrTwo.setColumns(10);
		txtFieldNrTwo.setBounds(248, 82, 118, 46);
		frameMain.getContentPane().add(txtFieldNrTwo);

		JLabel lblEql = new JLabel("=");
		lblEql.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
		lblEql.setHorizontalAlignment(SwingConstants.CENTER);
		lblEql.setBounds(390, 93, 64, 25);
		frameMain.getContentPane().add(lblEql);

		txtFieldSum = new JTextField();
		txtFieldSum.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
		txtFieldSum.setColumns(10);
		txtFieldSum.setBounds(464, 82, 118, 46);
		frameMain.getContentPane().add(txtFieldSum);

		// JButton btnOperate = new JButton("Percuteaza");
		btnOperate.setBounds(231, 163, 157, 58);
		btnOperate.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
		frameMain.getContentPane().add(btnOperate);

		String[] cmbOption = { "+", "-", "/", "*" };
		JComboBox<String> cmbOperation = new JComboBox<>(cmbOption);
		// cmbOperation.setModel(new DefaultComboBoxModel(new String[] {"+", "-", "/",
		// "*"}));
		cmbOperation.setFont(new Font("Tahoma", Font.BOLD, 20));
		cmbOperation.setBounds(184, 91, 43, 25);
		frameMain.getContentPane().add(cmbOperation);

		Operation = (cmbOperation.getSelectedItem().toString());

		btnOperate.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				double Summ;
				String shortSumm;
				Integer sumIntOne = Calculations.getRandomNr();
				Integer sumIntTwo = Calculations.getRandomTwo();
				txtFieldNrOne.setText(sumIntOne.toString());
				txtFieldNrTwo.setText(sumIntTwo.toString());
				// String sumStringOne = txtFieldNrOne.getText();
				// String sumStringTwo = txtFieldNrTwo.getText();

				cmbOperation.addActionListener(cmbOperation);
				{
					Operation = (cmbOperation.getSelectedItem().toString());
				}
				switch (Operation){
				
				case "+": 
					txtFieldSum.setText(Integer.toString(sumIntOne + sumIntTwo));
					break;
				case "-": 
					txtFieldSum.setText(Integer.toString(sumIntOne - sumIntTwo));
					break;
				case "*": 
					Summ = ((double) sumIntOne * sumIntTwo);
					shortSumm = String.valueOf((new DecimalFormat("###.##").format(Summ)));
					txtFieldSum.setText(shortSumm);
					break;
				case "/": 
					Summ = ((double) sumIntOne / sumIntTwo);
					shortSumm = String.valueOf((new DecimalFormat("###.##").format(Summ)));
					txtFieldSum.setText(shortSumm);
					break;
				}
				// System.out.println(txtFieldNrOne.getText());
				// System.out.println(txtFieldNrTwo.getText());
				// System.out.println(txtFieldSum.getText());

			}
		});
	}
}
