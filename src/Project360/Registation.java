package Project360;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Registation extends JFrame {
	
	public static String name; static String id; static String email; static String password; static String re_pass;
	public static int lastID =0;

	static Connection con= null;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_name;
	private JTextField textField_email;
	private JTextField textField_password;
	private JTextField textField_rePass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registation frame = new Registation();
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
	public Registation() {
		setTitle("Student Managment System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1040, 720);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1024, 681);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Managment System");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(336, 60, 311, 27);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("I have a account?");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(null);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(491, 501, 178, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Maiandra GD", Font.BOLD, 16));
		lblNewLabel_1.setBounds(292, 220, 98, 27);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setFont(new Font("Maiandra GD", Font.BOLD, 16));
		lblNewLabel_2.setBounds(292, 270, 98, 27);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setFont(new Font("Maiandra GD", Font.BOLD, 16));
		lblNewLabel_4.setBounds(292, 322, 98, 27);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Re-Password");
		lblNewLabel_5.setFont(new Font("Maiandra GD", Font.BOLD, 16));
		lblNewLabel_5.setBounds(292, 368, 98, 27);
		panel.add(lblNewLabel_5);
		
		textField_name = new JTextField();
		textField_name.setColumns(10);
		textField_name.setBounds(415, 220, 254, 27);
		panel.add(textField_name);
		
		textField_email = new JTextField();
		textField_email.setColumns(10);
		textField_email.setBounds(415, 270, 254, 27);
		panel.add(textField_email);
		
		textField_password = new JTextField();
		textField_password.setColumns(10);
		textField_password.setBounds(415, 322, 254, 27);
		panel.add(textField_password);
		
		textField_rePass = new JTextField();
		textField_rePass.setColumns(10);
		textField_rePass.setBounds(415, 368, 254, 27);
		panel.add(textField_rePass);
		
		JButton btnNewButton_2 = new JButton("Signup");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				name = textField_name.getText();
				email = textField_email.getText();
				password  = textField_password.getText();
				re_pass = textField_rePass.getText();
				
				if(password.equals(re_pass)) {
					try {
						password = Password.passwordHash(password);
						dataInsart();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(rootPane, "Student Create Success");
					setVisible(false);
					Login.main(null);
				}
				else
				{
					JOptionPane.showMessageDialog(rootPane, "Password dos't match");
				}
				
			}
		});
		btnNewButton_2.setBounds(571, 424, 98, 27);
		btnNewButton_2.setFont(new Font("Maiandra GD", Font.BOLD, 16));
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel_6 = new JLabel("Registation");
		lblNewLabel_6.setFont(new Font("Kalpurush", Font.BOLD, 20));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(352, 130, 283, 25);
		panel.add(lblNewLabel_6);
		
		
		
	}
	
	public static  void dataInsart() throws  Exception  {
		
		PreparedStatement 	student = DBconnection.studentInsart();
							student.setString(1, name);
							student.setString(2, email);
							student.setString(3, password);
							student.executeUpdate();
	}
}
