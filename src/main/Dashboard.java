package main;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class Dashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
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
	public Dashboard() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1039, 738);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1039, 738);
		contentPane.add(panel);
		panel.setLayout(null);
	
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(73, 185, 218));
		panel_1.setBounds(0, 0, 1039, 72);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon image = new ImageIcon(Dashboard.class.getResource("/main/icon/3917189.png"));
		Image img = image.getImage();
		Image newImg = img.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		lblNewLabel.setIcon(new ImageIcon(newImg));
		
		lblNewLabel.setBounds(981, 20, 30, 34);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Student Mangment System");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(10, 11, 335, 31);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("A Testing Project");
		lblNewLabel_3.setForeground(new Color(0, 0, 64));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_3.setBounds(10, 40, 321, 14);
		panel_1.add(lblNewLabel_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(252, 215, 67));
		panel_2.setBounds(0, 71, 234, 668);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Feni University");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBackground(new Color(20, 191, 248));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1.setBounds(10, 11, 214, 44);
		panel_2.add(lblNewLabel_1);
		
		
		JPanel menuPanel1 = new JPanel();
		menuPanel1.setBackground(new Color(255, 128, 64));
		menuPanel1.setBounds(10, 78, 214, 32);
		panel_2.add(menuPanel1);
		menuPanel1.setLayout(null);
		
		JLabel menuLbl1 = new JLabel("Home");
		menuLbl1.setForeground(new Color(255, 255, 255));
		menuLbl1.setHorizontalAlignment(SwingConstants.LEFT);
		menuLbl1.setFont(new Font("Tahoma", Font.BOLD, 20));
		menuLbl1.setBounds(76, 0, 101, 32);
		menuPanel1.add(menuLbl1);
		
		JLabel menuLblIcon1 = new JLabel("");
		menuLblIcon1.setHorizontalAlignment(SwingConstants.CENTER);
		menuLblIcon1.setBounds(42, 0, 32, 32);
		menuPanel1.add(menuLblIcon1);
		
		ImageIcon menuImage1 = new ImageIcon(Dashboard.class.getResource("/main/icon/3917033.png"));
		Image menuImg1 = menuImage1.getImage();
		Image newMenuImg1 = menuImg1.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		menuLblIcon1.setIcon(new ImageIcon(newMenuImg1));
		
		JPanel menuPanel2 = new JPanel();
		menuPanel2.setLayout(null);
		menuPanel2.setBackground(new Color(255, 128, 64));
		menuPanel2.setBounds(10, 137, 214, 32);
		panel_2.add(menuPanel2);
		
		JLabel menuLbl2 = new JLabel("Home");
		menuLbl2.setHorizontalAlignment(SwingConstants.LEFT);
		menuLbl2.setForeground(Color.WHITE);
		menuLbl2.setFont(new Font("Tahoma", Font.BOLD, 20));
		menuLbl2.setBounds(76, 0, 101, 32);
		menuPanel2.add(menuLbl2);
		
		JLabel menuLblIcon2 = new JLabel("");
		menuLblIcon2.setHorizontalAlignment(SwingConstants.CENTER);
		menuLblIcon2.setBounds(42, 0, 32, 32);
		menuPanel2.add(menuLblIcon2);
		
		ImageIcon menuImage2 = new ImageIcon(Dashboard.class.getResource("/main/icon/3917033.png"));
		Image menuImg2 = menuImage2.getImage();
		Image newMenuImg2 = menuImg2.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		menuLblIcon2.setIcon(new ImageIcon(newMenuImg2)); 
		
		JPanel menuPanel3 = new JPanel();
		menuPanel3.setLayout(null);
		menuPanel3.setBackground(new Color(255, 128, 64));
		menuPanel3.setBounds(10, 197, 214, 32);
		panel_2.add(menuPanel3);
		
		JLabel menuLbl3 = new JLabel("Home");
		menuLbl3.setHorizontalAlignment(SwingConstants.LEFT);
		menuLbl3.setForeground(Color.WHITE);
		menuLbl3.setFont(new Font("Tahoma", Font.BOLD, 20));
		menuLbl3.setBounds(76, 0, 101, 32);
		menuPanel3.add(menuLbl3);
		
		JLabel menuLblIcon3 = new JLabel("");
		menuLblIcon3.setHorizontalAlignment(SwingConstants.CENTER);
		menuLblIcon3.setBounds(42, 0, 32, 32);
		menuPanel3.add(menuLblIcon3);
		
		ImageIcon menuImage3 = new ImageIcon(Dashboard.class.getResource("/main/icon/3917033.png"));
		Image menuImg3 = menuImage3.getImage();
		Image newMenuImg3 = menuImg3.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		menuLblIcon3.setIcon(new ImageIcon(newMenuImg3));
		
		
		JPanel menuPanel4 = new JPanel();
		menuPanel4.setLayout(null);
		menuPanel4.setBackground(new Color(255, 128, 64));
		menuPanel4.setBounds(10, 256, 214, 32);
		panel_2.add(menuPanel4);
		
		JLabel menuLbl4 = new JLabel("Home");
		menuLbl4.setHorizontalAlignment(SwingConstants.LEFT);
		menuLbl4.setForeground(Color.WHITE);
		menuLbl4.setFont(new Font("Tahoma", Font.BOLD, 20));
		menuLbl4.setBounds(76, 0, 101, 32);
		menuPanel4.add(menuLbl4);
		
		JLabel menuLblIcon4 = new JLabel("");
		menuLblIcon4.setHorizontalAlignment(SwingConstants.CENTER);
		menuLblIcon4.setBounds(42, 0, 32, 32);
		menuPanel4.add(menuLblIcon4);
		
		ImageIcon menuImage4 = new ImageIcon(Dashboard.class.getResource("/main/icon/3917033.png"));
		Image menuImg4 = menuImage4.getImage();
		Image newMenuImg4 = menuImg4.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		menuLblIcon4.setIcon(new ImageIcon(newMenuImg4));
		
		
		JPanel menuPanel5 = new JPanel();
		menuPanel5.setLayout(null);
		menuPanel5.setBackground(new Color(255, 128, 64));
		menuPanel5.setBounds(10, 318, 214, 32);
		panel_2.add(menuPanel5);
		
		JLabel menuLbl5 = new JLabel("Home");
		menuLbl5.setHorizontalAlignment(SwingConstants.LEFT);
		menuLbl5.setForeground(Color.WHITE);
		menuLbl5.setFont(new Font("Tahoma", Font.BOLD, 20));
		menuLbl5.setBounds(76, 0, 101, 32);
		menuPanel5.add(menuLbl5);
		
		JLabel menuLblIcon5 = new JLabel("");
		menuLblIcon5.setHorizontalAlignment(SwingConstants.CENTER);
		menuLblIcon5.setBounds(42, 0, 32, 32);
		menuPanel5.add(menuLblIcon5);
		
		ImageIcon menuImage5 = new ImageIcon(Dashboard.class.getResource("/main/icon/3917033.png"));
		Image menuImg5 = menuImage5.getImage();
		Image newMenuImg5 = menuImg5.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		menuLblIcon5.setIcon(new ImageIcon(newMenuImg5));
		
		
		
	}

}
