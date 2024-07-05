package resources;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
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
					Main frame = new Main();
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
	public Main() {
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
		ImageIcon backgroudImage = new ImageIcon(Dashboard.class.getResource("/main/icon/221103094112-4840555__1_-removebg-preview.png"));
		Image newBackgroudImage = backgroudImage.getImage();
		Image resizeNewBackgroudImage = newBackgroudImage.getScaledInstance(300, 70, java.awt.Image.SCALE_SMOOTH);
		
		
		
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(64, 128, 128));
		panel_1.setBounds(0, 0, 1040, 720);
		panel.add(panel_1);
		panel_1.setLayout(null);
			
			JPanel panel_2 = new JPanel();
			panel_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Login.main(null);
					setVisible(false);
				}
			});
			panel_2.setBounds(183, 225, 303, 289);
			panel_1.add(panel_2);
			panel_2.setLayout(null);
			
			JLabel lblNewLabel_2 = new JLabel("Student Panel");
			lblNewLabel_2.setFont(new Font("Raleway SemiBold", Font.PLAIN, 34));
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setBounds(10, 216, 283, 62);
			panel_2.add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("");
			lblNewLabel_3.setBackground(new Color(0, 255, 255));
			lblNewLabel_3.setBounds(46, 28, 200, 177);
			panel_2.add(lblNewLabel_3); 
			ImageIcon backgroudImage2 = new ImageIcon(Dashboard.class.getResource("/main/icon/studentPanel.png"));
			Image newBackgroudImage2 = backgroudImage2.getImage();
			Image resizeNewBackgroudImage2 = newBackgroudImage2.getScaledInstance(200, 176, java.awt.Image.SCALE_SMOOTH);
			lblNewLabel_3.setIcon(new ImageIcon(resizeNewBackgroudImage2));
			
			JPanel panel_2_1 = new JPanel();
			panel_2_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Admin_Login.main(null);
					setVisible(false);
				}
			});
			panel_2_1.setLayout(null);
			panel_2_1.setBounds(579, 225, 303, 289);
			panel_1.add(panel_2_1);
			
			JLabel lblNewLabel_2_1 = new JLabel("Admin Panel");
			lblNewLabel_2_1.setForeground(new Color(0, 0, 0));
			lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2_1.setFont(new Font("Raleway SemiBold", Font.PLAIN, 34));
			lblNewLabel_2_1.setBounds(10, 216, 283, 62);
			panel_2_1.add(lblNewLabel_2_1);
			
			JLabel lblNewLabel_3_1 = new JLabel("");
			lblNewLabel_3_1.setBackground(Color.CYAN);
			lblNewLabel_3_1.setBounds(46, 28, 200, 177);
			panel_2_1.add(lblNewLabel_3_1);
			ImageIcon backgroudImage3 = new ImageIcon(Dashboard.class.getResource("/main/icon/adminPanel.png"));
			Image newBackgroudImage3 = backgroudImage3.getImage();
			Image resizeNewBackgroudImage3 = newBackgroudImage3.getScaledInstance(200, 176, java.awt.Image.SCALE_SMOOTH);
			lblNewLabel_3_1.setIcon(new ImageIcon(resizeNewBackgroudImage3));
			ImageIcon backgroudImage1 = new ImageIcon(Dashboard.class.getResource("/main/icon/221103094112-4840555__1_-removebg-preview.png"));
			Image newBackgroudImage1 = backgroudImage1.getImage();
			Image resizeNewBackgroudImage1 = newBackgroudImage1.getScaledInstance(300, 70, java.awt.Image.SCALE_SMOOTH);
			
			
			JLabel lblNewLabel_1 = new JLabel("Student Managment System ");
			lblNewLabel_1.setBounds(183, 69, 699, 64);
			panel_1.add(lblNewLabel_1);
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setForeground(new Color(255, 255, 255));
			lblNewLabel_1.setFont(new Font("Raleway SemiBold", Font.PLAIN, 47));
			
			JLabel lblNewLabel_1_1 = new JLabel("***Design & Developed BY Java Slayers Team***\r\n");
			lblNewLabel_1_1.setBounds(205, 607, 677, 50);
			panel_1.add(lblNewLabel_1_1);
			lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
			lblNewLabel_1_1.setFont(new Font("Raleway SemiBold", Font.PLAIN, 24));
			
		
	
		
	
	
	}
}
