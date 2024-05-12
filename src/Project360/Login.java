package Project360;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField emailFild;
	private JTextField passwordFild;
	static String email; static String password; static String currentPass; public static int userStatus =0;
	public static String user_id ;
	public static String user_email,user_name;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
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
		lblNewLabel.setBounds(345, 35, 311, 27);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("New Student Registation");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registation.main(null);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(418, 391, 258, 23);
		panel.add(btnNewButton_1);
		
		JLabel emailTitle = new JLabel("Email");
		emailTitle.setFont(new Font("Maiandra GD", Font.BOLD, 16));
		emailTitle.setBounds(342, 254, 46, 14);
		panel.add(emailTitle);
		
		JLabel passwordTitle = new JLabel("Password");
		passwordTitle.setFont(new Font("Maiandra GD", Font.BOLD, 16));
		passwordTitle.setBounds(310, 312, 100, 14);
		panel.add(passwordTitle);
		
		emailFild = new JTextField();
		emailFild.setColumns(10);
		emailFild.setBounds(420, 250, 256, 27);
		panel.add(emailFild);
		
		passwordFild = new JTextField();
		passwordFild.setColumns(10);
		passwordFild.setBounds(420, 308, 256, 27);
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
					userStatus = loginCheck(); 
					if(userStatus == 1) {
						Home.main(null);
						setVisible(false);
					}
					else if(userStatus == 0)  errorMassage.setText("Email not pound");
					else errorMassage.setText("Password dos't match");
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			
			}
		});
		login.setBounds(554, 346, 122, 27);
		panel.add(login);
		
		JLabel lblNewLabel_6 = new JLabel("Student Login");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Kalpurush", Font.BOLD, 20));
		lblNewLabel_6.setBounds(373, 123, 283, 25);
		panel.add(lblNewLabel_6);
	
	}
	
	public static int loginCheck() throws Exception {
		PreparedStatement pr = DBconnection.studentLogin();
		pr.setString(1, email);
		
		ResultSet rs = pr.executeQuery();
		int count =0;
		while(rs.next())
		{
			
			currentPass = rs.getString("password");
			user_id = rs.getString("id");
			user_email =rs.getString("email");
			user_name = rs.getString("name");
			count++;
		}
		
		if(count > 0) {
			if(currentPass.equals(password)) {
				userStatus = 1 ; 
			
			}
			else {
				userStatus = 2;
				user_id = "";
				user_email ="";
				user_name = "";
			}
		}
		else userStatus = 0;
		
		return userStatus ;
	}
	
	
	
}
