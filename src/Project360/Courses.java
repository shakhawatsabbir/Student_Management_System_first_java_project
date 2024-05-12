package Project360;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class Courses extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static int  rowCount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Courses frame = new Courses();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public Courses() throws Exception {
		setTitle("Student Managment System");
		setBackground(new Color(0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1040, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1024, 681);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel pageTitle = new JLabel("Enroll Courses");
		pageTitle.setHorizontalAlignment(SwingConstants.CENTER);
		pageTitle.setFont(new Font("Tahoma", Font.BOLD, 22));
		pageTitle.setBounds(375, 45, 219, 36);
		panel.add(pageTitle);
		
		
		
		JComboBox comboBox = new JComboBox( getCourse());
		comboBox.setBounds(174, 186, 284, 36);
		panel.add(comboBox);
		
		
		
		
		
		
	}
	
	
	public static String[] getCourse() throws Exception {
		Connection con = DBconnection.connection();
		PreparedStatement pr =con.prepareStatement("select *from courses");
		ResultSet rs = pr.executeQuery();
		
		String coursesList[]= new String[DBconnection.totalCourses()];

		int i=0;
		while(rs.next()) {
			coursesList[i] =rs.getString("title");
			i++;
		}
		
		
		return coursesList;
	}
}
