package resources;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Student Management System");
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
		
		JLabel title = new JLabel();
		title.setBounds(10, 47, 1020, 80);
		panel.add(title);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon univerSityLogo = new ImageIcon(Dashboard.class.getResource("/main/icon/221103094112-4840555__1_-removebg-preview.png"));
		Image newUniverSityLogo = univerSityLogo.getImage();
		Image resizeNewUniverSityLogo = newUniverSityLogo.getScaledInstance(300, 70, java.awt.Image.SCALE_SMOOTH);
		title.setIcon(new ImageIcon(resizeNewUniverSityLogo)); 
		
		
		JLabel closeLabel = new JLabel("");
		closeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		closeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		closeLabel.setBounds(972, 11, 58, 34);
		panel.add(closeLabel);
		ImageIcon closeIcon = new ImageIcon(Dashboard.class.getResource("/main/icon/close.png"));
		Image  newCloseIconImage = closeIcon.getImage();
		Image newCloseIconImageResize = newCloseIconImage.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		closeLabel.setIcon(new ImageIcon(newCloseIconImageResize));
		
		
		JLabel lblNewLabel_6 = new JLabel("Admin Login");
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Kalpurush", Font.BOLD, 28));
		lblNewLabel_6.setBounds(328, 205, 346, 44);
		panel.add(lblNewLabel_6);
		
		emailFild = new JTextField();
		emailFild.setColumns(10);
		emailFild.setBounds(427, 328, 308, 35);
		panel.add(emailFild);
		
		JLabel emailTitle = new JLabel("Email");
		emailTitle.setForeground(new Color(255, 255, 255));
		emailTitle.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		emailTitle.setBounds(287, 328, 100, 35);
		panel.add(emailTitle);
		
		JLabel passwordTitle = new JLabel("Password");
		passwordTitle.setForeground(new Color(255, 255, 255));
		passwordTitle.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		passwordTitle.setBounds(287, 394, 100, 35);
		panel.add(passwordTitle);
		
		passwordFild = new JTextField();
		passwordFild.setColumns(10);
		passwordFild.setBounds(427, 394, 308, 35);
		panel.add(passwordFild);
		
		JLabel errorMassage = new JLabel("");
		errorMassage.setForeground(new Color(255, 0, 0));
		errorMassage.setFont(new Font("Tahoma", Font.PLAIN, 13));
		errorMassage.setBounds(429, 303, 256, 14);
		panel.add(errorMassage);
		
		JButton login = new JButton("login");
		login.setFont(new Font("Raleway SemiBold", Font.BOLD, 20));
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
		login.setBounds(622, 471, 113, 35);
		panel.add(login);
		

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBackground(new Color(0, 255, 255));
		lblNewLabel_3.setBounds(0, 0, 1040, 722);
		panel.add(lblNewLabel_3); 
		ImageIcon backgroudImage = new ImageIcon(Dashboard.class.getResource("/main/icon/background5.jpeg"));
		Image newBackgroudImage = backgroudImage.getImage();
		Image resizeNewBackgroudImage = newBackgroudImage.getScaledInstance(1100, 722, java.awt.Image.SCALE_SMOOTH);
		lblNewLabel_3.setIcon(new ImageIcon(resizeNewBackgroudImage));
		
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
