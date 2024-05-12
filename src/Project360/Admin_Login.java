package Project360;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Admin_Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField emailFild;
	private JTextField passwordFild;
	private static String email,currentPass,password;
	public static int AdminLoginStatus =0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Login frame = new Admin_Login();
				
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
	public Admin_Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Student Management System");
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
		
		JLabel lblNewLabel_6 = new JLabel("Admin Login");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Kalpurush", Font.BOLD, 24));
		lblNewLabel_6.setBounds(340, 139, 346, 44);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel = new JLabel("Student Managment System");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(343, 49, 311, 27);
		panel.add(lblNewLabel);
		
		emailFild = new JTextField();
		emailFild.setColumns(10);
		emailFild.setBounds(418, 264, 256, 27);
		panel.add(emailFild);
		
		JLabel emailTitle = new JLabel("Email");
		emailTitle.setFont(new Font("Maiandra GD", Font.BOLD, 16));
		emailTitle.setBounds(340, 268, 46, 14);
		panel.add(emailTitle);
		
		JLabel passwordTitle = new JLabel("Password");
		passwordTitle.setFont(new Font("Maiandra GD", Font.BOLD, 16));
		passwordTitle.setBounds(308, 326, 100, 14);
		panel.add(passwordTitle);
		
		passwordFild = new JTextField();
		passwordFild.setColumns(10);
		passwordFild.setBounds(418, 322, 256, 27);
		panel.add(passwordFild);
		
		JLabel errorMassage = new JLabel("");
		errorMassage.setForeground(new Color(255, 0, 0));
		errorMassage.setFont(new Font("Tahoma", Font.PLAIN, 13));
		errorMassage.setBounds(418, 223, 256, 14);
		panel.add(errorMassage);
		
		JButton login = new JButton("login");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				email = emailFild.getText();
				password = Password.passwordHash(passwordFild.getText()) ;
				try {
					AdminLoginStatus = LoginCheck(); 
					if(AdminLoginStatus == 1) {
						Dashboard.main(null);
						setVisible(false);
					}
					else if(AdminLoginStatus == 0)  errorMassage.setText("Email not pound");
					else errorMassage.setText("Password dos't match");
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		login.setBounds(552, 360, 122, 27);
		panel.add(login);
	}
	
	
	public static int LoginCheck() throws Exception {
		Connection con =DBconnection.connection();
		PreparedStatement pr = con.prepareStatement("Select *from Admins where email=?");
						pr.setString(1, email);
		ResultSet rs = pr.executeQuery();
		int count =0;
		while(rs.next())
		{
			currentPass = rs.getString("password");
			count++;
		}
		
		if(count > 0) {
			if(currentPass.equals(password)) AdminLoginStatus = 1;
			else AdminLoginStatus = 2;
		}
		else AdminLoginStatus = 0;
		
		return AdminLoginStatus ;
	}
}
