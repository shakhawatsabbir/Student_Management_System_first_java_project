package resources;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
		
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(947, 11, 67, 30);
		panel.add(lblNewLabel);
		ImageIcon lblNewLabelImage2 = new ImageIcon(Login.class.getResource("/main/icon/close.png"));
		Image newlblNewLabelImage2 = lblNewLabelImage2.getImage();
		Image resizelblNewLabelImage2 = newlblNewLabelImage2.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		lblNewLabel.setIcon(new ImageIcon(resizelblNewLabelImage2));
		
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(397, 237, 98, 27);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Maiandra GD", Font.BOLD, 16));
		
		textField_name = new JTextField();
		textField_name.setBounds(397, 267, 254, 27);
		panel.add(textField_name);
		textField_name.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Signup");
		btnNewButton_2.setBounds(553, 520, 98, 27);
		panel.add(btnNewButton_2);
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
		btnNewButton_2.setFont(new Font("Maiandra GD", Font.BOLD, 16));
		
		JButton btnNewButton = new JButton("I have a account?");
		btnNewButton.setBounds(473, 570, 178, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(null);
				setVisible(false);
			}
		});
		panel.add(btnNewButton);
		
		
		textField_rePass = new JTextField();
		textField_rePass.setBounds(397, 466, 254, 27);
		panel.add(textField_rePass);
		textField_rePass.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Re-Password");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(397, 438, 98, 27);
		panel.add(lblNewLabel_5);
		lblNewLabel_5.setFont(new Font("Maiandra GD", Font.BOLD, 16));
		
		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(397, 372, 98, 27);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Maiandra GD", Font.BOLD, 16));
		
		textField_password = new JTextField();
		textField_password.setBounds(397, 400, 254, 27);
		panel.add(textField_password);
		textField_password.setColumns(10);
		
		textField_email = new JTextField();
		textField_email.setBounds(397, 334, 254, 27);
		panel.add(textField_email);
		textField_email.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(397, 305, 98, 27);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Maiandra GD", Font.BOLD, 16));
		
		JLabel lblNewLabel_6 = new JLabel("Registration ");
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setBounds(10, 157, 1020, 49);
		lblNewLabel_6.setFont(new Font("Raleway SemiBold", Font.BOLD, 35));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_6);
		
		
		JLabel title = new JLabel();
		title.setBounds(10, 47, 1020, 80);
		panel.add(title);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon backgroudImage = new ImageIcon(Dashboard.class.getResource("/main/icon/221103094112-4840555__1_-removebg-preview.png"));
		Image newBackgroudImage = backgroudImage.getImage();
		Image resizeNewBackgroudImage = newBackgroudImage.getScaledInstance(300, 70, java.awt.Image.SCALE_SMOOTH);
		title.setIcon(new ImageIcon(resizeNewBackgroudImage)); 

		
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBackground(new Color(0, 255, 255));
		lblNewLabel_3.setBounds(0, 0, 1040, 720);
		panel.add(lblNewLabel_3); 
		ImageIcon backgroudImage2 = new ImageIcon(Dashboard.class.getResource("/main/icon/background5.jpeg"));
		Image newBackgroudImage2 = backgroudImage2.getImage();
		Image resizeNewBackgroudImage2 = newBackgroudImage2.getScaledInstance(1200, 800, java.awt.Image.SCALE_SMOOTH);
		lblNewLabel_3.setIcon(new ImageIcon(resizeNewBackgroudImage2));
	
		
		
	}
	
	public static  void dataInsart() throws  Exception  {
		
		PreparedStatement 	student = DBconnection.studentInsart();
							student.setString(1, name);
							student.setString(2, email);
							student.setString(3, password);
							student.executeUpdate();
	}
	
	 
}
