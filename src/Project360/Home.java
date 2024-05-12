package Project360;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Home extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		if(Login.userStatus >=0) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Home frame = new Home();
						frame.setVisible(true);
	
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		else {
			Login.main(args);
		}
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public Home() throws Exception {
		setTitle("Student Managment System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1040, 720);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBounds(0, 0, 1024, 681);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel Title = new JLabel("Student Dashboard ");
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		Title.setForeground(new Color(0, 0, 0));
		Title.setFont(new Font("Tahoma", Font.BOLD, 22));
		Title.setBounds(350, 44, 311, 27);
		panel.add(Title);

		JButton logoutButton = new JButton("Logout");
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.userStatus = 0;
				Login.main(null);
				setVisible(false);
			}
		});
		logoutButton.setBounds(852, 51, 142, 23);
		panel.add(logoutButton);
		
		JLabel lblNewLabel = new JLabel("ID :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(176, 181, 128, 27);
		panel.add(lblNewLabel);
		
		JLabel id = new JLabel(String.valueOf(Login.user_id) );
		id.setFont(new Font("Tahoma", Font.BOLD, 15));
		id.setBounds(314, 181, 128, 27);
		panel.add(id);
		
		JLabel lblEmail = new JLabel("Name :");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmail.setBounds(176, 219, 128, 27);
		panel.add(lblEmail);
		
		JLabel name = new JLabel(Login.user_name);
		name.setFont(new Font("Tahoma", Font.BOLD, 15));
		name.setBounds(314, 219, 291, 27);
		panel.add(name);
		
		JLabel lblEmail_1 = new JLabel("Email :");
		lblEmail_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmail_1.setBounds(176, 257, 128, 27);
		panel.add(lblEmail_1);
		
		JLabel email = new JLabel(Login.user_email);
		email.setFont(new Font("Tahoma", Font.BOLD, 15));
		email.setBounds(314, 257, 347, 27);
		panel.add(email);
		
		JButton enrollCourseBtn = new JButton("Enroll new Course ");
		enrollCourseBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		enrollCourseBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		enrollCourseBtn.setBounds(176, 395, 211, 27);
		panel.add(enrollCourseBtn);
		
	}
}
