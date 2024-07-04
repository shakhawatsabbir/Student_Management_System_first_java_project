package resources;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		setUndecorated(true);
		setTitle("Student Managment System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1040, 720);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1040, 720);
		contentPane.add(panel);
		panel.setLayout(null);
		
//		
		
		JButton btnNewButton_1 = new JButton("New Student Registation");
		btnNewButton_1.setForeground(new Color(0, 128, 255));
		btnNewButton_1.setFont(new Font("Raleway SemiBold", Font.BOLD, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registation.main(null);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(469, 459, 231, 30);
		panel.add(btnNewButton_1);
		
		
		
		
		
		JLabel emailTitle = new JLabel("Email");
		emailTitle.setForeground(new Color(255, 255, 255));
		emailTitle.setFont(new Font("Raleway SemiBold", Font.BOLD, 22));
		emailTitle.setBounds(288, 254, 100, 35);
		panel.add(emailTitle);
		
		JLabel passwordTitle = new JLabel("Password");
		passwordTitle.setForeground(new Color(255, 255, 255));
		passwordTitle.setFont(new Font("Raleway SemiBold", Font.BOLD, 22));
		passwordTitle.setBounds(288, 312, 122, 35);
		panel.add(passwordTitle);
		
		emailFild = new JTextField();
		emailFild.setColumns(10);
		emailFild.setBounds(420, 250, 280, 35);
		panel.add(emailFild);
		
		passwordFild = new JTextField();
		passwordFild.setColumns(10);
		passwordFild.setBounds(420, 312, 280, 35);
		panel.add(passwordFild);
		
		JLabel errorMassage = new JLabel("");
		errorMassage.setForeground(new Color(255, 0, 0));
		errorMassage.setFont(new Font("Tahoma", Font.PLAIN, 13));
		errorMassage.setBounds(418, 223, 256, 14);
		panel.add(errorMassage);
		
		JButton login = new JButton("login");
		login.setFont(new Font("Raleway SemiBold", Font.BOLD, 18));
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
		login.setBounds(560, 382, 140, 30);
		panel.add(login);
		

		
		JLabel lblTitle = new JLabel("Login");
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Raleway SemiBold", Font.BOLD, 35));
		lblTitle.setBounds(10, 140, 1020, 50);
		panel.add(lblTitle);

		JLabel title = new JLabel();
		title.setBounds(10, 47, 1020, 80);
		panel.add(title);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon backgroudImage = new ImageIcon(Dashboard.class.getResource("/main/icon/221103094112-4840555__1_-removebg-preview.png"));
		Image newBackgroudImage = backgroudImage.getImage();
		Image resizeNewBackgroudImage = newBackgroudImage.getScaledInstance(300, 70, java.awt.Image.SCALE_SMOOTH);
		title.setIcon(new ImageIcon(resizeNewBackgroudImage)); 
		
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(951, 11, 67, 30);
		panel.add(lblNewLabel);
		ImageIcon lblNewLabelImage2 = new ImageIcon(Login.class.getResource("/main/icon/close.png"));
		Image newlblNewLabelImage2 = lblNewLabelImage2.getImage();
		Image resizelblNewLabelImage2 = newlblNewLabelImage2.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		lblNewLabel.setIcon(new ImageIcon(resizelblNewLabelImage2));
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBackground(new Color(0, 255, 255));
		lblNewLabel_3.setBounds(0, 0, 1040, 720);
		panel.add(lblNewLabel_3); 
		ImageIcon backgroudImage2 = new ImageIcon(Dashboard.class.getResource("/main/icon/background5.jpeg"));
		Image newBackgroudImage2 = backgroudImage2.getImage();
		Image resizeNewBackgroudImage2 = newBackgroudImage2.getScaledInstance(1200, 800, java.awt.Image.SCALE_SMOOTH);
		lblNewLabel_3.setIcon(new ImageIcon(resizeNewBackgroudImage2));
		
		
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
