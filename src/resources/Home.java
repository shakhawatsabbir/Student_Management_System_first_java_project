package resources;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Home extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JTable table;
	private static  String StudentId;
	/**
	 * Launch the application.
	 */
	
	
	
	public static void main(String[] args) {
		if(Login.userStatus >=1) { 
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
		
		StudentId= Login.user_id;
		setUndecorated(true);
		setTitle("Student Managment System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1040, 720);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBounds(0, 0, 1040, 720);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel Title = new JLabel("Student Dashboard ");
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		Title.setForeground(new Color(255, 255, 255));
		Title.setFont(new Font("Raleway SemiBold", Font.BOLD, 40));
		Title.setBounds(10, 50, 1020, 61);
		panel.add(Title);

		JButton logoutButton = new JButton("Logout");
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.userStatus = 0;
				Login.main(null);
				setVisible(false);
			}
		});
		logoutButton.setBounds(853, 122, 85, 23);
		panel.add(logoutButton);
		
		JLabel lblNewLabel = new JLabel("ID :");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(176, 181, 128, 27);
		panel.add(lblNewLabel);
		
		JLabel id = new JLabel(String.valueOf(Login.user_id) );
		id.setForeground(new Color(255, 255, 255));
		id.setFont(new Font("Tahoma", Font.BOLD, 20));
		id.setBounds(314, 181, 128, 27);
		panel.add(id);
		
		JLabel lblEmail = new JLabel("Name :");
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEmail.setBounds(176, 219, 128, 27);
		panel.add(lblEmail);
		
		JLabel name = new JLabel(Login.user_name);
		name.setForeground(new Color(255, 255, 255));
		name.setFont(new Font("Tahoma", Font.BOLD, 20));
		name.setBounds(314, 219, 291, 27);
		panel.add(name);
		
		JLabel lblEmail_1 = new JLabel("Email :");
		lblEmail_1.setForeground(new Color(255, 255, 255));
		lblEmail_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEmail_1.setBounds(176, 257, 128, 27);
		panel.add(lblEmail_1);
		
		JLabel email = new JLabel(Login.user_email);
		email.setForeground(new Color(255, 255, 255));
		email.setFont(new Font("Tahoma", Font.BOLD, 20));
		email.setBounds(314, 257, 347, 27);
		panel.add(email);
		
		JButton enrollCourseBtn = new JButton("Enroll new Course ");
		enrollCourseBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnrollCourses.main(null);
				setVisible(false);
			}
		});
		enrollCourseBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		enrollCourseBtn.setBounds(176, 346, 211, 27);
		panel.add(enrollCourseBtn);
		
		

		JLabel closeLabel = new JLabel("");
		closeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		closeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		closeLabel.setBounds(956, 11, 58, 34);
		panel.add(closeLabel);
		ImageIcon closeIcon = new ImageIcon(Dashboard.class.getResource("/main/icon/close.png"));
		Image  newCloseIconImage = closeIcon.getImage();
		Image newCloseIconImageResize = newCloseIconImage.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		closeLabel.setIcon(new ImageIcon(newCloseIconImageResize));
		
		

		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(true);
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(176, 437, 658, 184);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 658, 184);
		panel_1.add(scrollPane);
		
		table = new JTable();
		DefaultTableModel model= (DefaultTableModel) table.getModel();
		String colName[] = {"Course Id", "Course Title","Cradit Houre"};
		model.setColumnIdentifiers(colName);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		scrollPane.setViewportView(table);
		
		String  CoursesId,CoursesTitle,CraditHour,CoursesId2;
		ResultSet rs= getEnrollCourse();
		while(rs.next())
		{
			CoursesId = rs.getString("courses_id");
			
			ResultSet rsCourse =getCourse(CoursesId);
			while(rsCourse.next())
			{
				CoursesId2 = rsCourse.getString("id");
				CoursesTitle = rsCourse.getString("title");
				CraditHour =rsCourse.getString("credit_houre");
				String row[]= {CoursesId, CoursesTitle,CraditHour};
				model.addRow(row);
			}
			
		}

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 0, 1040, 722);
		panel.add(lblNewLabel_1);
		ImageIcon backgroudImage = new ImageIcon(Dashboard.class.getResource("/main/icon/background5.jpeg"));
		Image newBackgroudImage = backgroudImage.getImage();
		Image resizeNewBackgroudImage = newBackgroudImage.getScaledInstance(1100, 722, java.awt.Image.SCALE_SMOOTH);
		lblNewLabel_1.setIcon(new ImageIcon(resizeNewBackgroudImage));
		
	}
	
	
	public static ResultSet getEnrollCourse() throws Exception {
		Connection con = DBconnection.connection();
		PreparedStatement pr = con.prepareStatement("select *from enrolls where student_id	= ?");
		pr.setString(1, StudentId);
		ResultSet rs = pr.executeQuery();		
		return rs;
	}

	public static ResultSet getCourse(String coursesId) throws Exception {
		Connection con = DBconnection.connection();
		PreparedStatement pr = con.prepareStatement("select *from courses where id= ?");
		pr.setString(1, coursesId);
		ResultSet rs = pr.executeQuery();		
		return rs;
	}
}
