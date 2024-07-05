package resources;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import database.Enroll;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

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

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class Home extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private static JTable table;
	private static  String StudentId;
	static  int rowCount;
	static String listID[];
	private static JTextField CoursesIdFild;
	private static JTextField CoursesTitleFild;
	private static JTextField CoursesPriceFild;
	private static JTextField CoursesCHoursFild;
	private static JTextField studentIdFild;
	private static JTextField studentNameFild;
	private static JTextField studentEmailFild;
	private static JTable table_1;
	static JLabel lblHome;
	
	static JLabel email ;
	static JLabel name;
	static JLabel mobile;
	static JLabel gendar ;
	
	public static String StudentName;
	public static String StudentEmail;
	public static String StudentMobiel;
	public static String StudentGendar;
	public static String EnrollCoursesID;
	int windoStatus=0;
	private static JTextField nametextField;
	private static JTextField emailtextField;
	private static JTextField mobiletextField;
	static JComboBox comboBox;
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
		
		panel.setBackground(new Color(109, 182, 182));
		panel.setBounds(0, 0, 1040, 720);
		contentPane.add(panel);
		panel.setLayout(null);
		topbar(panel);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(64, 128, 128));
		panel_2.setBounds(263, 56, 777, 664);
		panel.add(panel_2);
		panel_2.setLayout(null);
		panel_2.setVisible(true);
		dashboard(panel_2 );
	
		
		JPanel enrollPanel = new JPanel();
		enrollPanel.setBackground(new Color(64, 128, 128));
		enrollPanel.setBounds(263, 56, 777, 664);
		panel.add(enrollPanel);
		enrollPanel.setLayout(null);
		enrollPanel.setVisible(false);
		enroll(enrollPanel,contentPane);
		

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(64, 128, 128));
		panel_4.setBounds(263, 56, 777, 664);
		panel.add(panel_4);
		panel_4.setLayout(null);
		panel_4.setVisible(true);
		profile(panel_4 );
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(0, 56, 263, 664);
		panel.add(panel_3);
		panel_3.setLayout(null);
		sidebar(panel_3, enrollPanel,panel_2,panel_4);
		
		
		
		
		
		JButton RefresButton = new JButton("Refresh");
		RefresButton.setHorizontalAlignment(SwingConstants.LEFT);
		RefresButton.setForeground(new Color(255, 255, 255));
		RefresButton.setBounds(23, 134, 211, 35);
		panel_3.add(RefresButton);
		RefresButton.setFont(new Font("Raleway SemiBold", Font.PLAIN, 15));
		RefresButton.setBackground(new Color(109, 182, 182));
		RefresButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home.main(null);
				setVisible(false);
				try {
//					DefaultTableModel model= (DefaultTableModel) table.getModel();
//					model.setRowCount(0);
//					setTable(model);
					
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		ImageIcon menuIconRefresh = new ImageIcon(Dashboard.class.getResource("/main/icon/pngwing.png"));
		Image menuIconRefreshImage = menuIconRefresh.getImage();
		Image resizeMenuIconRefreshImage = menuIconRefreshImage.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		RefresButton.setIcon(new ImageIcon(resizeMenuIconRefreshImage));
		
		
		
		JLabel closeLabel = new JLabel("");
		closeLabel.setBounds(972, 11, 58, 34);
		panel.add(closeLabel);
		closeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		closeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon closeIcon = new ImageIcon(Dashboard.class.getResource("/main/icon/3917189.png"));
		Image  newCloseIconImage = closeIcon.getImage();
		Image newCloseIconImageResize = newCloseIconImage.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		closeLabel.setIcon(new ImageIcon(newCloseIconImageResize));		
		
		
		
		JButton logoutButton = new JButton("Logout");
		logoutButton.setHorizontalAlignment(SwingConstants.LEFT);
		logoutButton.setForeground(new Color(255, 255, 255));
		logoutButton.setBounds(24, 363, 211, 35);
		panel_3.add(logoutButton);
		logoutButton.setFont(new Font("Raleway SemiBold", Font.PLAIN, 15));
		logoutButton.setBackground(new Color(109, 182, 182));
		
		ImageIcon menuIconLogout = new ImageIcon(Dashboard.class.getResource("/main/icon/logout.png"));
		Image menuIconLogoutImage = menuIconLogout.getImage();
		Image resizeMenuIconLogoutImage = menuIconLogoutImage.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		logoutButton.setIcon(new ImageIcon(resizeMenuIconLogoutImage));
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.userStatus = 0;
				Login.main(null);
				setVisible(false);
			}
		});
		
		
		
		
		
		JButton updateProfile = new JButton("Update");
		updateProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = StudentId;
				String name = nametextField.getText();
				String email = emailtextField.getText();
				String mobile = mobiletextField.getText();
				String gendar = (String) comboBox.getSelectedItem();
				
				
				try {
					StudentDataUpdate(id, name, email, mobile, gendar);
					studentData(id);
					JOptionPane.showMessageDialog(panel_4, "Profile update Success");
					setVisible(false);
					Home.main(null);
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
			}
		});
		updateProfile.setFont(new Font("Raleway SemiBold", Font.PLAIN, 18));
		updateProfile.setBounds(613, 526, 114, 33);
		panel_4.add(updateProfile);

	}
	
	
	public static void enroll(JPanel panel_2,JPanel contentPane) throws Exception {

		StudentId = Login.user_id;
		StudentName = Login.user_name;
		StudentEmail =Login.user_email;
		
		JLabel pageTitle = new JLabel("Enroll Courses");
		pageTitle.setForeground(new Color(255, 255, 255));
		pageTitle.setHorizontalAlignment(SwingConstants.CENTER);
		pageTitle.setFont(new Font("Raleway SemiBold", Font.BOLD, 35));
		pageTitle.setBounds(10, 33, 757, 42);
		panel_2.add(pageTitle);
		
		JPanel selectWishPanel = new JPanel();
		selectWishPanel.setLayout(null); 
		selectWishPanel.setBackground(new Color(94, 174, 174));
		selectWishPanel.setBounds(10, 129, 370, 430);
		panel_2.add(selectWishPanel);
		

		JPanel studentPanel = new JPanel();
		studentPanel.setLayout(null);
		studentPanel.setBackground(new Color(94, 174, 174));
		studentPanel.setBounds(390, 129, 370, 430);
		panel_2.add(studentPanel);
		

		JLabel errorMassange = new JLabel("");
		errorMassange.setFont(new Font("Raleway", Font.BOLD, 15));
		errorMassange.setForeground(new Color(255, 0, 0));
		errorMassange.setBounds(36, 64, 300, 14);
		selectWishPanel.add(errorMassange);
		
		JButton submitbutton = new JButton("Submit");
		submitbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					int i = checkEnrollCourses(errorMassange);
					   if (i > 0) {
							JOptionPane.showMessageDialog(panel_2, "Course Enrolld Success");
							DefaultTableModel model= (DefaultTableModel) table.getModel();
							model.setRowCount(0);
							setTable(model);
						} 
		
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		submitbutton.setBounds(227, 389, 114, 30);
		studentPanel.add(submitbutton);
		
		JLabel selectWishCourses = new JLabel("Select your wish courses");
		selectWishCourses.setHorizontalAlignment(SwingConstants.CENTER);
		selectWishCourses.setForeground(Color.WHITE);
		selectWishCourses.setFont(new Font("Raleway SemiBold", Font.BOLD, 22));
		selectWishCourses.setBounds(36, 23, 300, 30);
		selectWishPanel.add(selectWishCourses);
		
		
		
		
		JPanel tablePanel = new JPanel();
		tablePanel.setLayout(null);
		tablePanel.setBounds(36, 85, 300, 314);
		selectWishPanel.add(tablePanel);
		
		JScrollPane courseCourseListScrollPane = new JScrollPane();
		courseCourseListScrollPane.setBounds(0, 0, 300, 314);
		tablePanel.add(courseCourseListScrollPane);
		
		JTable table_1 = new JTable();
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
		

		ResultSet courseList = EnrollCourses.getData();
		 EnrollCourses.getDataCount();
		while(courseList.next())
		{
			String colRow[] = {courseList.getString("id"),courseList.getString("title"),courseList.getString("price"),courseList.getString("credit_houre")};
			model.addRow(colRow);
		}
		
		
		
		
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
		
		JLabel studentDetailLabel = new JLabel("Student Details ");
		studentDetailLabel.setHorizontalAlignment(SwingConstants.LEFT);
		studentDetailLabel.setForeground(Color.WHITE);
		studentDetailLabel.setFont(new Font("Raleway SemiBold", Font.BOLD, 20));
		studentDetailLabel.setBounds(38, 11, 303, 30);
		studentPanel.add(studentDetailLabel);
		
		JLabel studentCoursesDetailLbl = new JLabel("Selected Courses Details ");
		studentCoursesDetailLbl.setHorizontalAlignment(SwingConstants.LEFT);
		studentCoursesDetailLbl.setForeground(Color.WHITE);
		studentCoursesDetailLbl.setFont(new Font("Raleway SemiBold", Font.BOLD, 20));
		studentCoursesDetailLbl.setBounds(38, 184, 303, 30);
		studentPanel.add(studentCoursesDetailLbl);
		
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
	
	
	
		
	}
	
	public static void profile(JPanel panel_2) throws Exception {

		studentData(StudentId);
		
		JLabel Title = new JLabel("Student Profile ");
		Title.setBounds(10, 11, 757, 61);
		panel_2.add(Title);
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		Title.setForeground(new Color(255, 255, 255));
		Title.setFont(new Font("Raleway SemiBold", Font.BOLD, 31));
		
		JLabel lblNewLabel = new JLabel("Student ID :");
		lblNewLabel.setBounds(27, 96, 128, 27);
		panel_2.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Raleway SemiBold", Font.BOLD, 20));
		
		JLabel id = new JLabel(String.valueOf(Login.user_id) );
		id.setBounds(177, 96, 128, 27);
		panel_2.add(id);
		id.setForeground(new Color(255, 255, 255));
		id.setFont(new Font("Raleway SemiBold", Font.BOLD, 20));
		
		JLabel lblEmail = new JLabel("Name :");
		lblEmail.setBounds(27, 134, 128, 27);
		panel_2.add(lblEmail);
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setFont(new Font("Raleway SemiBold", Font.BOLD, 20));
		
		JLabel lblEmail_1 = new JLabel("Email :");
		lblEmail_1.setBounds(27, 177, 128, 27);
		panel_2.add(lblEmail_1);
		lblEmail_1.setForeground(new Color(255, 255, 255));
		lblEmail_1.setFont(new Font("Raleway SemiBold", Font.BOLD, 20));
		
		email = new JLabel(StudentEmail);
		email.setBounds(177, 177, 347, 27);
		panel_2.add(email);
		email.setForeground(new Color(255, 255, 255));
		email.setFont(new Font("Raleway SemiBold", Font.BOLD, 20));
		
		name = new JLabel(StudentName);
		name.setBounds(177, 134, 291, 27);
		panel_2.add(name);
		name.setForeground(new Color(255, 255, 255));
		name.setFont(new Font("Raleway SemiBold", Font.BOLD, 20));
		
		JLabel mobileLBL = new JLabel("Mobile:");
		mobileLBL.setForeground(Color.WHITE);
		mobileLBL.setFont(new Font("Raleway SemiBold", Font.BOLD, 20));
		mobileLBL.setBounds(27, 215, 128, 27);
		panel_2.add(mobileLBL);
		
		mobile = new JLabel(StudentMobiel);
		mobile.setForeground(Color.WHITE);
		mobile.setFont(new Font("Raleway SemiBold", Font.BOLD, 20));
		mobile.setBounds(177, 215, 347, 27);
		panel_2.add(mobile);
		
		gendar = new JLabel(StudentGendar);
		gendar.setForeground(Color.WHITE);
		gendar.setFont(new Font("Raleway SemiBold", Font.BOLD, 20));
		gendar.setBounds(177, 253, 347, 27);
		panel_2.add(gendar);
		
		JLabel gendarLBL = new JLabel("Gendar");
		gendarLBL.setForeground(Color.WHITE);
		gendarLBL.setFont(new Font("Raleway SemiBold", Font.BOLD, 20));
		gendarLBL.setBounds(27, 253, 128, 27);
		panel_2.add(gendarLBL);
		
		
		JLabel lblEditProfile = new JLabel("Edit Profile :");
		lblEditProfile.setForeground(Color.WHITE);
		lblEditProfile.setFont(new Font("Raleway SemiBold", Font.BOLD, 20));
		lblEditProfile.setBounds(27, 361, 188, 27);
		panel_2.add(lblEditProfile);
		
		JLabel lblNameIN = new JLabel("Name :");
		lblNameIN.setForeground(Color.WHITE);
		lblNameIN.setFont(new Font("Raleway SemiBold", Font.BOLD, 20));
		lblNameIN.setBounds(27, 409, 104, 33);
		panel_2.add(lblNameIN);
		
		nametextField = new JTextField();
		nametextField.setBounds(141, 412, 214, 33);
		panel_2.add(nametextField);
		nametextField.setColumns(10);
		nametextField.setText(StudentName);
		
		emailtextField = new JTextField();
		emailtextField.setColumns(10);
		emailtextField.setBounds(513, 412, 214, 33);
		panel_2.add(emailtextField);
		emailtextField.setText(StudentEmail);
		
		JLabel lblEmailIN = new JLabel("Email :");
		lblEmailIN.setForeground(Color.WHITE);
		lblEmailIN.setFont(new Font("Raleway SemiBold", Font.BOLD, 20));
		lblEmailIN.setBounds(399, 409, 104, 33);
		panel_2.add(lblEmailIN);
		
		mobiletextField = new JTextField();
		mobiletextField.setColumns(10);
		mobiletextField.setBounds(141, 469, 214, 33);
		panel_2.add(mobiletextField);
		mobiletextField.setText(StudentMobiel);
		
		JLabel lblMobileIN = new JLabel("Mobile :");
		lblMobileIN.setForeground(Color.WHITE);
		lblMobileIN.setFont(new Font("Raleway SemiBold", Font.BOLD, 20));
		lblMobileIN.setBounds(27, 466, 104, 33);
		panel_2.add(lblMobileIN);
		
		JLabel lblGendarIN = new JLabel("Gender :");
		lblGendarIN.setForeground(Color.WHITE);
		lblGendarIN.setFont(new Font("Maiandra GD", Font.BOLD, 18));
		lblGendarIN.setBounds(399, 465, 87, 34);
		panel_2.add(lblGendarIN);
	
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		comboBox.setBounds(513, 468, 214, 34);
		panel_2.add(comboBox);
		
	
		
		
	}
	
	
	public static void dashboard(JPanel panel_2) throws Exception {

		JLabel Title = new JLabel("Student Dashboard ");
		Title.setBounds(10, 11, 757, 61);
		panel_2.add(Title);
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		Title.setForeground(new Color(255, 255, 255));
		Title.setFont(new Font("Raleway SemiBold", Font.BOLD, 31));
		
		JLabel lblNewLabel = new JLabel("Student ID :");
		lblNewLabel.setBounds(27, 96, 128, 27);
		panel_2.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Raleway SemiBold", Font.BOLD, 20));
		
		JLabel id = new JLabel(String.valueOf(Login.user_id) );
		id.setBounds(177, 96, 128, 27);
		panel_2.add(id);
		id.setForeground(new Color(255, 255, 255));
		id.setFont(new Font("Raleway SemiBold", Font.BOLD, 20));
		
		JLabel lblEmail = new JLabel("Name :");
		lblEmail.setBounds(27, 134, 128, 27);
		panel_2.add(lblEmail);
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setFont(new Font("Raleway SemiBold", Font.BOLD, 20));
		
		JLabel lblEmail_1 = new JLabel("Email :");
		lblEmail_1.setBounds(27, 177, 128, 27);
		panel_2.add(lblEmail_1);
		lblEmail_1.setForeground(new Color(255, 255, 255));
		lblEmail_1.setFont(new Font("Raleway SemiBold", Font.BOLD, 20));
		
		JLabel email = new JLabel(StudentEmail);
		email.setBounds(177, 177, 347, 27);
		panel_2.add(email);
		email.setForeground(new Color(255, 255, 255));
		email.setFont(new Font("Raleway SemiBold", Font.BOLD, 20));
		
		JLabel name = new JLabel(StudentName);
		name.setBounds(177, 134, 291, 27);
		panel_2.add(name);
		name.setForeground(new Color(255, 255, 255));
		name.setFont(new Font("Raleway SemiBold", Font.BOLD, 20));
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(true);
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(10, 270, 757, 273);
		panel_2.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 57, 737, 207);
		panel_1.add(scrollPane);
		
		table = new JTable();
		DefaultTableModel model= (DefaultTableModel) table.getModel();
		setTable(model);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		scrollPane.setViewportView(table);
		
		
		
		JLabel lblEnrolledCoursesLisr = new JLabel("Enrolled Courses List");
		lblEnrolledCoursesLisr.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnrolledCoursesLisr.setBackground(new Color(240, 240, 240));
		lblEnrolledCoursesLisr.setForeground(new Color(64, 128, 128));
		lblEnrolledCoursesLisr.setFont(new Font("Raleway SemiBold", Font.BOLD, 24));
		lblEnrolledCoursesLisr.setBounds(20, 11, 685, 27);
		panel_1.add(lblEnrolledCoursesLisr);
	}
	
	public static void topbar(JPanel panel) {
		
		JLabel title = new JLabel();
		title.setBounds(27, 0, 218, 50);
		panel.add(title);
		title.setOpaque(true);
		title.setBackground(new Color(255, 255, 255));
		title.setForeground(new Color(255, 255, 255));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon imageLogo = new ImageIcon(Dashboard.class.getResource("/main/icon/221103094112-4840555__1_-removebg-preview.png"));
		Image imgLogo = imageLogo.getImage();
		Image resizeImage = imgLogo.getScaledInstance(200, 40, java.awt.Image.SCALE_SMOOTH);
		title.setIcon(new ImageIcon(resizeImage));
		
		
		JLabel lblStudentPanel = new JLabel("Student Panel");
		lblStudentPanel.setHorizontalAlignment(SwingConstants.LEFT);
		lblStudentPanel.setForeground(Color.BLACK);
		lblStudentPanel.setFont(new Font("Montserrat", Font.BOLD, 18));
		lblStudentPanel.setBounds(263, 0, 187, 40);
		panel.add(lblStudentPanel);
		
		
		lblHome = new JLabel("Home");
		lblHome.setHorizontalAlignment(SwingConstants.LEFT);
		lblHome.setForeground(Color.WHITE);
		lblHome.setFont(new Font("Montserrat", Font.BOLD, 14));
		lblHome.setBounds(263, 30, 187, 22);
		panel.add(lblHome);
	}
	public static void sidebar(JPanel panel_3,JPanel enrollPanel,JPanel panel_2, JPanel panel_4) {
		
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enrollPanel.setVisible(false);
				panel_2.setVisible(true);
				panel_4.setVisible(false);
				lblHome.setText("Home");
			}
		});
		btnHome.setHorizontalAlignment(SwingConstants.LEFT);
		btnHome.setForeground(Color.WHITE);
		btnHome.setFont(new Font("Raleway SemiBold", Font.PLAIN, 15));
		btnHome.setBackground(new Color(109, 182, 182));
		btnHome.setBounds(23, 191, 211, 35);
		panel_3.add(btnHome);
		ImageIcon menuIconHome = new ImageIcon(Dashboard.class.getResource("/main/icon/3917033.png"));
		Image menuIconHomeImage = menuIconHome.getImage();
		Image resizeMenuIconHomeImage = menuIconHomeImage.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		btnHome.setIcon(new ImageIcon(resizeMenuIconHomeImage));
	
		
		JButton btnProfile = new JButton("Profile");
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enrollPanel.setVisible(false);
				panel_2.setVisible(false);
				panel_4.setVisible(true);
				lblHome.setText("Profile");
			}
		});
		btnProfile.setHorizontalAlignment(SwingConstants.LEFT);
		btnProfile.setForeground(Color.WHITE);
		btnProfile.setFont(new Font("Raleway SemiBold", Font.PLAIN, 15));
		btnProfile.setBackground(new Color(109, 182, 182));
		btnProfile.setBounds(23, 250, 211, 35);
		panel_3.add(btnProfile);
		ImageIcon profileIcon = new ImageIcon(Dashboard.class.getResource("/main/icon/student.png"));
		Image profileIconImage = profileIcon.getImage();
		Image resizeprofileIconImage = profileIconImage.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		btnProfile.setIcon(new ImageIcon(resizeprofileIconImage));

		
		
		
		JButton enrollCourseBtn = new JButton("Enroll new Course ");
		enrollCourseBtn.setHorizontalAlignment(SwingConstants.LEFT);
		enrollCourseBtn.setForeground(new Color(255, 255, 255));
		enrollCourseBtn.setBounds(23, 308, 211, 35);
		panel_3.add(enrollCourseBtn);
		enrollCourseBtn.setBackground(new Color(109, 182, 182));
		enrollCourseBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				EnrollCourses.main(null);
				enrollPanel.setVisible(true);
				panel_2.setVisible(false);
				panel_4.setVisible(false);
//				panel_3.setVisible(false);
				lblHome.setText("Enroll Course");
			}
		});
		enrollCourseBtn.setFont(new Font("Raleway SemiBold", Font.PLAIN, 15));
		ImageIcon menuIconCoursesAdd = new ImageIcon(Dashboard.class.getResource("/main/icon/courses.png"));
		Image menuIconCoursesAddImage = menuIconCoursesAdd.getImage();
		Image resizeMenuIconCoursesAddImage = menuIconCoursesAddImage.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		enrollCourseBtn.setIcon(new ImageIcon(resizeMenuIconCoursesAddImage));
		
		
	
	}
	
	
	public static void setTable(DefaultTableModel model) throws Exception {
		String colName[] = {"Course Id", "Course Title","Cradit Houre","Status"};
		
		model.setColumnIdentifiers(colName);
		String  CoursesId,CoursesTitle,CraditHour,CoursesId2,EStatus;
		ResultSet rs= getEnrollCourse();
		while(rs.next())
		{
			CoursesId = rs.getString("courses_id");
			EStatus = rs.getString("status");
			if(Integer.parseInt(EStatus) == 0) {
				EStatus = "Not Approved";
			}
			else
			{
				EStatus = "Approved";
			}
			ResultSet rsCourse =getCourse(CoursesId);
			while(rsCourse.next()) 
			{
				CoursesId2 = rsCourse.getString("id");
				CoursesTitle = rsCourse.getString("title");
				CraditHour =rsCourse.getString("credit_houre");
				
				String row[]= {CoursesId, CoursesTitle,CraditHour,EStatus};
				model.addRow(row);
			}
			
		}
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

	public static void studentData(String user_id) throws Exception {
		Connection con = DBconnection.connection();
		PreparedStatement pr = con.prepareStatement("select *from students where id= ?");
		pr.setString(1, user_id);
		ResultSet rs = pr.executeQuery();
		
		while(rs.next()) {
			
			StudentName = rs.getString("name");
			StudentEmail =rs.getString("email");
			StudentMobiel=rs.getString("mobile");
			StudentGendar=rs.getString("gendar");
		}
		
	}
	
	public static  void StudentDataUpdate(String id,String name, String email, String mobile, String gendar) throws  Exception  {
		
		PreparedStatement student = DBconnection.connection().prepareStatement("update students set name=?, email=?,mobile=?,gendar=? where id=?");
							student.setString(1, name);
							student.setString(2, email);
							student.setString(3, mobile);
							student.setString(4, gendar);
							student.setString(5, id);
							student.executeUpdate();
	}

}
