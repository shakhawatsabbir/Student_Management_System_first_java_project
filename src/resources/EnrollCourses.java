package resources;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import database.Enroll;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EnrollCourses extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	int counter;
	static  int rowCount;
	static String listID[];
	private JTextField CoursesIdFild;
	private JTextField CoursesTitleFild;
	private JTextField CoursesPriceFild;
	private JTextField CoursesCHoursFild;
	private JTextField studentIdFild;
	private JTextField studentNameFild;
	private JTextField studentEmailFild;
	private JTable table_1;
	
	

	public static String StudentId ;
	public String StudentName;
	public String StudentEmail;
	public static String EnrollCoursesID;
	int windoStatus=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		if(Login.userStatus >=1) { 
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						EnrollCourses frame = new EnrollCourses();
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
	public EnrollCourses() throws Exception {
		
		StudentId = Login.user_id;
		StudentName = Login.user_name;
		StudentEmail =Login.user_email;
		
		
		setUndecorated(true);
		setTitle("Student Managment System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1040, 720);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 0, 64));
		panel.setBounds(0, 0, 1040, 720);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		
		
		
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
		
		JLabel title = new JLabel();
		title.setBounds(10, 47, 1020, 80);
		panel.add(title);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon univerSityLogo = new ImageIcon(Dashboard.class.getResource("/main/icon/221103094112-4840555__1_-removebg-preview.png"));
		Image newUniverSityLogo = univerSityLogo.getImage();
		Image resizeNewUniverSityLogo = newUniverSityLogo.getScaledInstance(300, 70, java.awt.Image.SCALE_SMOOTH);
		title.setIcon(new ImageIcon(resizeNewUniverSityLogo)); 
						
			
			JLabel pageTitle = new JLabel("Enroll Courses");
			pageTitle.setForeground(new Color(255, 255, 255));
			pageTitle.setHorizontalAlignment(SwingConstants.CENTER);
			pageTitle.setFont(new Font("Raleway SemiBold", Font.BOLD, 40));
			pageTitle.setBounds(10, 173, 1020, 42);
			panel.add(pageTitle);
			
			JPanel selectWishPanel = new JPanel();
			selectWishPanel.setLayout(null); 
			selectWishPanel.setBackground(new Color(0, 128, 192));
			selectWishPanel.setBounds(136, 251, 370, 430);
			panel.add(selectWishPanel);
			
			JLabel selectWishCourses = new JLabel("Select your wish courses");
			selectWishCourses.setHorizontalAlignment(SwingConstants.CENTER);
			selectWishCourses.setForeground(Color.WHITE);
			selectWishCourses.setFont(new Font("Raleway SemiBold", Font.BOLD, 22));
			selectWishCourses.setBounds(36, 23, 300, 30);
			selectWishPanel.add(selectWishCourses);
			
			JLabel errorMassange = new JLabel("");
			errorMassange.setFont(new Font("Raleway", Font.BOLD, 15));
			errorMassange.setForeground(new Color(255, 0, 0));
			errorMassange.setBounds(36, 64, 300, 14);
			selectWishPanel.add(errorMassange);
			
			JPanel tablePanel = new JPanel();
			tablePanel.setLayout(null);
			tablePanel.setBounds(36, 85, 300, 314);
			selectWishPanel.add(tablePanel);
			
			JScrollPane courseCourseListScrollPane = new JScrollPane();
			courseCourseListScrollPane.setBounds(0, 0, 300, 314);
			tablePanel.add(courseCourseListScrollPane);
			
			table_1 = new JTable();
			table_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int row =table_1.getSelectedRow();
					DefaultTableModel model = (DefaultTableModel) table_1.getModel();
					CoursesIdFild.setText( model.getValueAt(row, 0).toString());
					CoursesTitleFild.setText(model.getValueAt(row, 1).toString());
					CoursesPriceFild.setText(model.getValueAt(row, 2).toString());
					CoursesCHoursFild.setText(model.getValueAt(row, 3).toString());  
					EnrollCoursesID = model.getValueAt(row, 0).toString();
					errorMassange.setText(" ");
				}
			});
			DefaultTableModel model = (DefaultTableModel) table_1.getModel();
			String colNames[]= {"id", "Title","Price", "Credit Hours"};
			model.setColumnIdentifiers(colNames);
			courseCourseListScrollPane.setColumnHeaderView(table_1);
			

			ResultSet courseList = getData();
			getDataCount();
			while(courseList.next())
			{
				String colRow[] = {courseList.getString("id"),courseList.getString("title"),courseList.getString("price"),courseList.getString("credit_houre")};
				model.addRow(colRow);
			}
		
			
			JPanel studentPanel = new JPanel();
			studentPanel.setLayout(null);
			studentPanel.setBackground(new Color(0, 128, 192));
			studentPanel.setBounds(549, 251, 370, 430);
			panel.add(studentPanel);
			
			CoursesIdFild = new JTextField();
			CoursesIdFild.setColumns(10);
			CoursesIdFild.setBounds(163, 225, 178, 30);
			studentPanel.add(CoursesIdFild);
			
			JLabel coursesIdLbl = new JLabel("Courses Id  : ");
			coursesIdLbl.setForeground(Color.WHITE);
			coursesIdLbl.setFont(new Font("Raleway SemiBold", Font.BOLD, 14));
			coursesIdLbl.setBounds(38, 225, 115, 30);
			studentPanel.add(coursesIdLbl);
			
			CoursesTitleFild = new JTextField();
			CoursesTitleFild.setColumns(10);
			CoursesTitleFild.setBounds(163, 266, 178, 30);
			studentPanel.add(CoursesTitleFild);
			
			JLabel coursesTitleLbl = new JLabel("Courses Title : ");
			coursesTitleLbl.setForeground(Color.WHITE);
			coursesTitleLbl.setFont(new Font("Raleway SemiBold", Font.BOLD, 14));
			coursesTitleLbl.setBounds(38, 266, 115, 30);
			studentPanel.add(coursesTitleLbl);
			
			CoursesPriceFild = new JTextField();
			CoursesPriceFild.setColumns(10);
			CoursesPriceFild.setBounds(163, 307, 178, 30);
			studentPanel.add(CoursesPriceFild);
			
			JLabel coursesPriceLbl = new JLabel("Coureses Price :");
			coursesPriceLbl.setForeground(Color.WHITE);
			coursesPriceLbl.setFont(new Font("Raleway SemiBold", Font.BOLD, 14));
			coursesPriceLbl.setBounds(38, 307, 115, 30);
			studentPanel.add(coursesPriceLbl);
			
			CoursesCHoursFild = new JTextField();
			CoursesCHoursFild.setColumns(10);
			CoursesCHoursFild.setBounds(163, 348, 178, 30);
			studentPanel.add(CoursesCHoursFild);
			
			JLabel craditHoursLbl = new JLabel("Credit Hours");
			craditHoursLbl.setForeground(Color.WHITE);
			craditHoursLbl.setFont(new Font("Raleway SemiBold", Font.BOLD, 14));
			craditHoursLbl.setBounds(38, 348, 115, 30);
			studentPanel.add(craditHoursLbl);
			
			JButton submitbutton = new JButton("Submit");
			submitbutton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						int i = checkEnrollCourses(errorMassange);
						   if (i > 0) {
								Home.main(null);
								setVisible(false);
							} 
			
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			});
			submitbutton.setBounds(227, 389, 114, 30);
			studentPanel.add(submitbutton);
			
			JLabel studentCoursesDetailLbl = new JLabel("Selected Courses Details ");
			studentCoursesDetailLbl.setHorizontalAlignment(SwingConstants.LEFT);
			studentCoursesDetailLbl.setForeground(Color.WHITE);
			studentCoursesDetailLbl.setFont(new Font("Raleway SemiBold", Font.BOLD, 20));
			studentCoursesDetailLbl.setBounds(38, 184, 303, 30);
			studentPanel.add(studentCoursesDetailLbl);
			
			JLabel studentDetailLabel = new JLabel("Student Details ");
			studentDetailLabel.setHorizontalAlignment(SwingConstants.LEFT);
			studentDetailLabel.setForeground(Color.WHITE);
			studentDetailLabel.setFont(new Font("Raleway SemiBold", Font.BOLD, 20));
			studentDetailLabel.setBounds(38, 11, 303, 30);
			studentPanel.add(studentDetailLabel);
			
			JLabel studentIdLabel = new JLabel("Student Id :");
			studentIdLabel.setForeground(Color.WHITE);
			studentIdLabel.setFont(new Font("Raleway SemiBold", Font.BOLD, 14));
			studentIdLabel.setBounds(38, 52, 115, 30);
			studentPanel.add(studentIdLabel);
			
			studentIdFild = new JTextField();
			studentIdFild.setColumns(10);
			studentIdFild.setBounds(163, 52, 178, 30);
			studentIdFild.setText(StudentId);
			studentPanel.add(studentIdFild);
			
			JLabel studentNameLbl = new JLabel("Student Name :");
			studentNameLbl.setForeground(Color.WHITE);
			studentNameLbl.setFont(new Font("Raleway SemiBold", Font.BOLD, 14));
			studentNameLbl.setBounds(38, 93, 115, 30);
			studentPanel.add(studentNameLbl);
			
			studentNameFild = new JTextField();
			studentNameFild.setColumns(10);
			studentNameFild.setText(StudentName);
			studentNameFild.setBounds(163, 93, 178, 30);
			studentPanel.add(studentNameFild);
			
			JLabel studentEmailLbl = new JLabel("Student Email :");
			studentEmailLbl.setForeground(Color.WHITE);
			studentEmailLbl.setFont(new Font("Raleway SemiBold", Font.BOLD, 14));
			studentEmailLbl.setBounds(38, 134, 115, 30);
			studentPanel.add(studentEmailLbl);
			
			studentEmailFild = new JTextField();
			studentEmailFild.setColumns(10);
			studentEmailFild.setText(StudentEmail);
			studentEmailFild.setBounds(163, 134, 178, 30);
			studentPanel.add(studentEmailFild);
		
		
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(0, 0, 1040, 720);
			panel.add(lblNewLabel_1);
			ImageIcon backgroudImage = new ImageIcon(Dashboard.class.getResource("/main/icon/background5.jpeg"));
			Image newBackgroudImage = backgroudImage.getImage();
			Image resizeNewBackgroudImage = newBackgroudImage.getScaledInstance(1100, 730, java.awt.Image.SCALE_SMOOTH);
			lblNewLabel_1.setIcon(new ImageIcon(resizeNewBackgroudImage)); 
		
		
	
	}
	 
	
	public static ResultSet getData() throws Exception {
		Connection con = DBconnection.connection();
		PreparedStatement pr = con.prepareStatement("select *from courses");
		ResultSet rs = pr.executeQuery("SELECT * FROM courses");
		return rs; 
	}
	
	public static int getDataCount() throws Exception {
		Connection con = DBconnection.connection();
		PreparedStatement pr = con.prepareStatement("select *from courses");
		ResultSet  rs = pr.executeQuery("SELECT COUNT(*) FROM courses");
	    rs.next();
	    rowCount = rs.getInt(1); 
	    return rowCount;
	}

	public static int checkEnrollCourses(JLabel errorMassange) throws Exception {
		 int i=0;
		Connection con = DBconnection.connection();
		PreparedStatement pr = con.prepareStatement("select *from enrolls where student_id= ? AND courses_id=?");
		pr.setString(1, StudentId);
		pr.setString(2, EnrollCoursesID);
		ResultSet  rs = pr.executeQuery();
		if(!rs.isBeforeFirst()){
			 i= enrollCourses();
			
			errorMassange.setText(" ");
			
		}
		else {
			errorMassange.setText("Already Enrolld this Courses");
		}
		return i; 
							
	}
	public static int enrollCourses() throws Exception {
		PreparedStatement pr =Enroll.enrollInsart();
							pr.setString(1, StudentId);
							pr.setString(2, EnrollCoursesID);
			int i =	pr.executeUpdate();
		       	
			return i;
							
	}
}

