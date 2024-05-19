package Project360;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Dashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable StudentTable;
	private JPanel sidebarPanel;
	private JPanel DashboardPanel;
	private JTable table;
	private int totalCourse=0, totalStudent =0;
	private JTextField titleTextField;
	private JTextField priceTextField;
	private JTextField crTextField;
	private JPanel coursesPanel; 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		if(Admin_Login.AdminLoginStatus == 0) {
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
		else
		{
			Admin_Login.main(args);
		}
		
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public Dashboard() throws Exception {
		setUndecorated(true); 
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setTitle("Student Management System");
		setBounds(100, 100, 1040, 720);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		DashboardPanel = new JPanel();
		DashboardPanel.setBounds(268, 63, 772, 657);
		contentPane.add(DashboardPanel);
		DashboardPanel.setLayout(null);
		DashboardPanel(DashboardPanel);
		
	
		coursesPanel = new JPanel();
		coursesPanel.setBounds(268, 63, 772, 657);
		contentPane.add(coursesPanel);
		coursesPanel.setVisible(false);
		coursesPanel.setLayout(null);
		CoursesPanel(coursesPanel);
			

		JPanel StudentRegistaionPanel = new JPanel();
		StudentRegistaionPanel.setBounds(268, 63, 772, 657);
		contentPane.add(StudentRegistaionPanel);
		StudentRegistaionPanel.setLayout(null);
		StudentRegistaionPanel(StudentRegistaionPanel);
		

		JPanel menuPanel = new JPanel();
		menuPanel.setBackground(new Color(143, 181, 184));
		menuPanel.setBounds(0, 0, 1040, 63);
		contentPane.add(menuPanel);
		menuPanel.setLayout(null);
		JLabel homeLabel = menuPanel2(menuPanel);
		
		
		sidebarPanel = new JPanel();
		sidebarPanel.setBackground(new Color(255, 255, 255));
		sidebarPanel.setBounds(0, 63, 268, 657);
		contentPane.add(sidebarPanel);
		sidebarPanel.setLayout(null);
		SidebarPanel(sidebarPanel, DashboardPanel, homeLabel, coursesPanel,StudentRegistaionPanel);
		
		JLabel title = new JLabel();
		title.setBounds(23, 0, 218, 50);
		menuPanel.add(title);
		title.setOpaque(true);
		title.setBackground(new Color(255, 255, 255));
		title.setForeground(new Color(255, 255, 255));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon imageLogo = new ImageIcon(Dashboard.class.getResource("/main/icon/221103094112-4840555__1_-removebg-preview.png"));
		Image imgLogo = imageLogo.getImage();
		Image resizeImage = imgLogo.getScaledInstance(200, 40, java.awt.Image.SCALE_SMOOTH);
		title.setIcon(new ImageIcon(resizeImage));
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBackground(new Color(0, 255, 255));
		lblNewLabel_3.setBounds(0, 0, 772, 657);
		StudentRegistaionPanel.add(lblNewLabel_3); 
		ImageIcon backgroudImage = new ImageIcon(Dashboard.class.getResource("/main/icon/background5.jpeg"));
		Image newBackgroudImage = backgroudImage.getImage();
		Image resizeNewBackgroudImage = newBackgroudImage.getScaledInstance(900, 700, java.awt.Image.SCALE_SMOOTH);
		lblNewLabel_3.setIcon(new ImageIcon(resizeNewBackgroudImage));
		
		
	}
	public void StudentRegistaionPanel(JPanel StudentRegistaionPanel)
	{
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblNewLabel_1.setBounds(140, 203, 141, 34);
		StudentRegistaionPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblNewLabel_2.setBounds(140, 281, 141, 35);
		StudentRegistaionPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblNewLabel_4.setBounds(140, 351, 141, 35);
		StudentRegistaionPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Re - Password");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblNewLabel_5.setBounds(140, 425, 141, 39);
		StudentRegistaionPanel.add(lblNewLabel_5);
		
		JTextField textField_name = new JTextField();
		textField_name.setColumns(10);
		textField_name.setBounds(305, 203, 255, 34);
		StudentRegistaionPanel.add(textField_name);
		
		JTextField textField_email = new JTextField();
		textField_email.setColumns(10);
		textField_email.setBounds(305, 281, 255, 34);
		StudentRegistaionPanel.add(textField_email);
		
		JTextField textField_password = new JTextField();
		textField_password.setColumns(10);
		textField_password.setBounds(305, 351, 255, 34);
		StudentRegistaionPanel.add(textField_password);
		
		JTextField textField_rePass = new JTextField();
		textField_rePass.setColumns(10);
		textField_rePass.setBounds(305, 425, 255, 34);
		StudentRegistaionPanel.add(textField_rePass);
		
		JButton btnNewButton_2 = new JButton("Sign up");
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = textField_name.getText();
				String email = textField_email.getText();
				String password = textField_password.getText();
				String re_pass = textField_rePass.getText();
				
				if(password.equals(re_pass)) {
					try {
						password = Password.passwordHash(password);
						Registation.dataInsart();
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
		btnNewButton_2.setBounds(440, 496, 120, 34);
		btnNewButton_2.setFont(new Font("Maiandra GD", Font.BOLD, 16));
		StudentRegistaionPanel.add(btnNewButton_2);
		
		JLabel lblNewLabel_6 = new JLabel(" New Student Registation");
		lblNewLabel_6.setBackground(new Color(128, 128, 128));
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setFont(new Font("Kalpurush", Font.BOLD, 35));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(10, 77, 752, 63);
		StudentRegistaionPanel.add(lblNewLabel_6);
	}
	
	public JLabel menuPanel2(JPanel menuPanel)
	{
		JLabel pageTitle = new JLabel("Admin Dashboard");
		pageTitle.setHorizontalAlignment(SwingConstants.LEFT);
		pageTitle.setForeground(new Color(0, 0, 0));
		pageTitle.setFont(new Font("Montserrat", Font.BOLD, 18));
		pageTitle.setBounds(278, 0, 187, 40);
		menuPanel.add(pageTitle);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(972, 18, 58, 22);
		menuPanel.add(lblNewLabel);
		
		ImageIcon closeIcon = new ImageIcon(Dashboard.class.getResource("/main/icon/3917189.png"));
		Image  newCloseIconImage = closeIcon.getImage();
		Image newCloseIconImageResize = newCloseIconImage.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		lblNewLabel.setIcon(new ImageIcon(newCloseIconImageResize));
		
		JLabel lblHome = new JLabel("Home");
		lblHome.setHorizontalAlignment(SwingConstants.LEFT);
		lblHome.setForeground(Color.WHITE);
		lblHome.setFont(new Font("Montserrat", Font.BOLD, 14));
		lblHome.setBounds(278, 30, 187, 22);
		menuPanel.add(lblHome);
		
		return lblHome;
	}
	
	public void SidebarPanel(JPanel sidebarPanel , JPanel DashboardPanel, JLabel homeLabel, JPanel coursesPanel, JPanel StudentRegistaionPanel) {
		
		
		
		JMenu homeMenuBtn = new JMenu("Home");
		homeMenuBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DashboardPanel.setVisible(true);
				coursesPanel.setVisible(false);
				StudentRegistaionPanel.setVisible(false);
				homeLabel.setText("Home");
			}
		});
		homeMenuBtn.setFont(new Font("Segoe UI", Font.BOLD, 12));
		homeMenuBtn.setForeground(new Color(255, 255, 255));
		homeMenuBtn.setIcon(new ImageIcon(Dashboard.class.getResource("/main/icon/3917033.png")));
		homeMenuBtn.setOpaque(true);
		homeMenuBtn.setBackground(new Color(143, 181, 184));
		homeMenuBtn.setBounds(40, 113, 187, 30);
		sidebarPanel.add(homeMenuBtn);
		
		ImageIcon menuIconHome = new ImageIcon(Dashboard.class.getResource("/main/icon/3917033.png"));
		Image menuIconHomeImage = menuIconHome.getImage();
		Image resizeMenuIconHomeImage = menuIconHomeImage.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		homeMenuBtn.setIcon(new ImageIcon(resizeMenuIconHomeImage));
		
		JMenu studentRegistationMenuBtn = new JMenu("Student Registration ");
		studentRegistationMenuBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DashboardPanel.setVisible(false);
				coursesPanel.setVisible(false);
				StudentRegistaionPanel.setVisible(true);
				homeLabel.setText("Student Resistation");
			}
		}); 
		studentRegistationMenuBtn.setOpaque(true);
		studentRegistationMenuBtn.setForeground(Color.WHITE);
		studentRegistationMenuBtn.setFont(new Font("Segoe UI", Font.BOLD, 12));
		studentRegistationMenuBtn.setBackground(new Color(143, 181, 184));
		studentRegistationMenuBtn.setBounds(40, 168, 187, 30);
		sidebarPanel.add(studentRegistationMenuBtn);
		
		ImageIcon menuIconStudentRegistation = new ImageIcon(Dashboard.class.getResource("/main/icon/student.png"));
		Image menuIconStudentRegistationImage = menuIconStudentRegistation.getImage();
		Image resizeMenuIconStudentRegistationImage = menuIconStudentRegistationImage.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		studentRegistationMenuBtn.setIcon(new ImageIcon(resizeMenuIconStudentRegistationImage));
		

		JMenu coursesAddMenuBtn = new JMenu("Courses Add");
		coursesAddMenuBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DashboardPanel.setVisible(false);
				coursesPanel.setVisible(true);
				StudentRegistaionPanel.setVisible(false);
				homeLabel.setText("Courses Insart");
			}
		});
		coursesAddMenuBtn.setOpaque(true);
		coursesAddMenuBtn.setForeground(Color.WHITE);
		coursesAddMenuBtn.setFont(new Font("Segoe UI", Font.BOLD, 12));
		coursesAddMenuBtn.setBackground(new Color(143, 181, 184));
		coursesAddMenuBtn.setBounds(40, 224, 187, 30);
		sidebarPanel.add(coursesAddMenuBtn);
		
		ImageIcon menuIconCoursesAdd = new ImageIcon(Dashboard.class.getResource("/main/icon/courses.png"));
		Image menuIconCoursesAddImage = menuIconCoursesAdd.getImage();
		Image resizeMenuIconCoursesAddImage = menuIconCoursesAddImage.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		coursesAddMenuBtn.setIcon(new ImageIcon(resizeMenuIconCoursesAddImage));
		
		
		
		JMenu LogoutBtn = new JMenu("Logout");
		LogoutBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Admin_Login.main(null);
				setVisible(false);
				homeLabel.setText("Logout");
			}
		});
		LogoutBtn.setOpaque(true);
		LogoutBtn.setForeground(Color.WHITE);
		LogoutBtn.setFont(new Font("Segoe UI", Font.BOLD, 12));
		LogoutBtn.setBackground(new Color(143, 181, 184));
		LogoutBtn.setBounds(40, 277, 187, 30);
		sidebarPanel.add(LogoutBtn);
		
		ImageIcon menuIconLogout = new ImageIcon(Dashboard.class.getResource("/main/icon/logout.png"));
		Image menuIconLogoutImage = menuIconLogout.getImage();
		Image resizeMenuIconLogoutImage = menuIconLogoutImage.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		LogoutBtn.setIcon(new ImageIcon(resizeMenuIconLogoutImage));
		
	}
	
	
	public void DashboardPanel(JPanel DashboardPanel) throws Exception {
		JPanel studentCountPanel = new JPanel();
		studentCountPanel.setBounds(52, 76, 286, 161);
		DashboardPanel.add(studentCountPanel);
		studentCountPanel.setBackground(new Color(143, 181, 184));
		studentCountPanel.setLayout(null);
		
			JLabel totalStudentTitle = new JLabel("Total Student");
			totalStudentTitle.setBackground(new Color(255, 255, 255));
			totalStudentTitle.setForeground(new Color(255, 255, 255));
			totalStudentTitle.setHorizontalAlignment(SwingConstants.CENTER);
			totalStudentTitle.setFont(new Font("Raleway SemiBold", Font.PLAIN, 25));
			totalStudentTitle.setBounds(10, 11, 266, 44);
			studentCountPanel.add(totalStudentTitle);
			
			JLabel totalStudentCount = new JLabel();
			totalStudentCount.setHorizontalAlignment(SwingConstants.CENTER);
			totalStudentCount.setForeground(Color.WHITE);
			totalStudentCount.setFont(new Font("Raleway ExtraBold", Font.PLAIN, 30));
			totalStudentCount.setBounds(81, 66, 118, 51);
			studentCountPanel.add(totalStudentCount);
			
			
			
			
		JPanel courseCountPanel = new JPanel();
		courseCountPanel.setBounds(425, 76, 286, 161);
		DashboardPanel.add(courseCountPanel);
		courseCountPanel.setLayout(null);
		courseCountPanel.setBackground(new Color(143, 181, 184));
		
			JLabel totalCourseTitle = new JLabel("Total Course");
			totalCourseTitle.setHorizontalAlignment(SwingConstants.CENTER);
			totalCourseTitle.setForeground(Color.WHITE);
			totalCourseTitle.setFont(new Font("Raleway SemiBold", Font.PLAIN, 25));
			totalCourseTitle.setBounds(10, 11, 266, 44);
			courseCountPanel.add(totalCourseTitle);
			
			JLabel totalCourseCount = new JLabel();
			totalCourseCount.setHorizontalAlignment(SwingConstants.CENTER);
			totalCourseCount.setForeground(Color.WHITE);
			totalCourseCount.setFont(new Font("Raleway ExtraBold", Font.PLAIN, 30));
			totalCourseCount.setBounds(81, 66, 118, 51);
			courseCountPanel.add(totalCourseCount);
		
		
		JPanel studentListPanel = new JPanel();
		studentListPanel.setBounds(36, 293, 322, 243);
		DashboardPanel.add(studentListPanel);
		studentListPanel.setBackground(new Color(109, 188, 231));
		studentListPanel.setLayout(null);
		
			JLabel studentListTitle = new JLabel("Student List");
			studentListTitle.setForeground(new Color(255, 255, 255));
			studentListTitle.setHorizontalAlignment(SwingConstants.CENTER);
			studentListTitle.setFont(new Font("Raleway SemiBold", Font.PLAIN, 25));
			studentListTitle.setBounds(10, 0, 302, 44);
			studentListPanel.add(studentListTitle);
			
			JScrollPane studentListScrollPane = new JScrollPane();
			studentListScrollPane.setBounds(10, 52, 302, 180);
			studentListPanel.add(studentListScrollPane);
			
			StudentTable = new JTable();
			DefaultTableModel model= (DefaultTableModel) StudentTable.getModel();
			
			String colName[] = {"id", "Name"};
			model.setColumnIdentifiers(colName);
			StudentTable.getColumnModel().getColumn(0).setPreferredWidth(27);
			StudentTable.getColumnModel().getColumn(1).setPreferredWidth(220);
			studentListScrollPane.setViewportView(StudentTable);
			
			String id,name;
			ResultSet rs= getStudent();
			while(rs.next())
			{
				id= rs.getString("id");
				name = rs.getString("name");
				totalStudent++;
				
				String row[]= {id,name};
				model.addRow(row);
			}
		
		JPanel courseListPanel = new JPanel();
		courseListPanel.setBounds(411, 293, 322, 243);
		DashboardPanel.add(courseListPanel);
		courseListPanel.setLayout(null);
		courseListPanel.setBackground(new Color(109, 188, 231));
		
			JLabel courseListTitle = new JLabel("Course List");
			courseListTitle.setHorizontalAlignment(SwingConstants.CENTER);
			courseListTitle.setForeground(Color.WHITE);
			courseListTitle.setFont(new Font("Raleway SemiBold", Font.PLAIN, 25));
			courseListTitle.setBounds(10, 0, 302, 44);
			courseListPanel.add(courseListTitle);
			
			JScrollPane courseListScrollPane = new JScrollPane();
			courseListScrollPane.setBounds(10, 51, 302, 181);
			courseListPanel.add(courseListScrollPane);
			
			table = new JTable();
			DefaultTableModel model3 = (DefaultTableModel) table.getModel();
			String ccolNames[]= {"id", "Title"};
			model3.setColumnIdentifiers(ccolNames);
			table.getColumnModel().getColumn(0).setPreferredWidth(27); 
			table.getColumnModel().getColumn(1).setPreferredWidth(220); 
			courseListScrollPane.setViewportView(table);
			
			ResultSet rsCourses = getCourse();
			String ccId, ccTitle;
			while(rsCourses.next()) {
				ccId = rsCourses.getString("id");
				ccTitle = rsCourses.getString("title");
				totalCourse++;
			
				String colRow[] = {ccId, ccTitle};
				model3.addRow(colRow);
			}
			

			JLabel lblNewLabel_3 = new JLabel("");
			lblNewLabel_3.setBackground(new Color(0, 255, 255));
			lblNewLabel_3.setBounds(0, 0, 772, 657);
			DashboardPanel.add(lblNewLabel_3); 
			ImageIcon backgroudImage = new ImageIcon(Dashboard.class.getResource("/main/icon/background5.jpeg"));
			Image newBackgroudImage = backgroudImage.getImage();
			Image resizeNewBackgroudImage = newBackgroudImage.getScaledInstance(900, 700, java.awt.Image.SCALE_SMOOTH);
			lblNewLabel_3.setIcon(new ImageIcon(resizeNewBackgroudImage)); 
			
		totalStudentCount.setText(String.valueOf(totalStudent));
		totalCourseCount.setText(String.valueOf(totalCourse));
		
	}
	
	
	public  void CoursesPanel(JPanel CoursesPanel) throws Exception {
		
		
		JLabel lblTitle = new JLabel("New Courses Insart");
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Raleway SemiBold", Font.BOLD, 35));
		lblTitle.setBounds(0, 34, 752, 32);
		CoursesPanel.add(lblTitle);
		
		JLabel inputTitle = new JLabel("Title");
		inputTitle.setForeground(new Color(255, 255, 255));
		inputTitle.setFont(new Font("Raleway SemiBold", Font.PLAIN, 18));
		inputTitle.setBounds(145, 126, 123, 20);
		CoursesPanel.add(inputTitle);
		
		titleTextField = new JTextField();
		titleTextField.setColumns(10);
		titleTextField.setBounds(302, 126, 241, 32);
		CoursesPanel.add(titleTextField);
		
		JLabel inputPrice = new JLabel("Price");
		inputPrice.setForeground(new Color(255, 255, 255));
		inputPrice.setFont(new Font("Raleway SemiBold", Font.PLAIN, 18));
		inputPrice.setBounds(145, 190, 123, 20);
		CoursesPanel.add(inputPrice);
		
		priceTextField = new JTextField();
		priceTextField.setColumns(10);
		priceTextField.setBounds(302, 190, 241, 32);
		CoursesPanel.add(priceTextField);
		
		
		
		JLabel inputCreditHours = new JLabel("Credit Hours");
		inputCreditHours.setForeground(new Color(255, 255, 255));
		inputCreditHours.setFont(new Font("Raleway SemiBold", Font.PLAIN, 18));
		inputCreditHours.setBounds(145, 257, 123, 20);
		CoursesPanel.add(inputCreditHours);
		
		crTextField = new JTextField();
		crTextField.setColumns(10);
		crTextField.setBounds(302, 257, 241, 32);
		CoursesPanel.add(crTextField);
		
		JButton coursesSubmit = new JButton("Submit");
		coursesSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String name = titleTextField.getText();
					int price = Integer.parseInt(priceTextField.getText());
					int credit_hours = Integer.parseInt(crTextField.getText());
					CoursesInsert.courseDataInsart(name, price,credit_hours);
					
					Dashboard.main(null);
					setVisible(false);
					
					JOptionPane.showMessageDialog(rootPane, "Course Create Success");
				}
				catch(Exception e1){
					e1.printStackTrace();
				}
				
			}
		});
		coursesSubmit.setFont(new Font("Raleway Black", Font.PLAIN, 16));
		coursesSubmit.setBounds(406, 315, 137, 29);
		CoursesPanel.add(coursesSubmit);
		
		
		
		JPanel coursesCourseListPanel = new JPanel();
		coursesCourseListPanel.setBounds(55, 388, 664, 243);
		CoursesPanel.add(coursesCourseListPanel);
		coursesCourseListPanel.setLayout(null);
		coursesCourseListPanel.setBackground(new Color(49, 186, 215));
		
			JLabel courseCourseListTitle = new JLabel("Course List");
			courseCourseListTitle.setHorizontalAlignment(SwingConstants.CENTER);
			courseCourseListTitle.setForeground(Color.WHITE);
			courseCourseListTitle.setFont(new Font("Raleway SemiBold", Font.PLAIN, 25));
			courseCourseListTitle.setBounds(10, 0, 644, 44);
			coursesCourseListPanel.add(courseCourseListTitle);
			
			JScrollPane courseCourseListScrollPane = new JScrollPane();
			courseCourseListScrollPane.setBounds(10, 55, 644, 177);
			coursesCourseListPanel.add(courseCourseListScrollPane);
			
			table = new JTable();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			String colNames[]= {"id", "Title", "Credit Hours"};
			model.setColumnIdentifiers(colNames);
			table.getColumnModel().getColumn(0).setPreferredWidth(27); 
			table.getColumnModel().getColumn(1).setPreferredWidth(420); 
			table.getColumnModel().getColumn(2).setPreferredWidth(120); 
			courseCourseListScrollPane.setViewportView(table);
			
			
			ResultSet courseRsCourses = getCourse();
			String cId, cTitle,cHours;
			while(courseRsCourses.next()) {
				cId = courseRsCourses.getString("id");
				cTitle = courseRsCourses.getString("title");
				cHours = courseRsCourses.getString("credit_houre");
				String colRow[] = {cId, cTitle,cHours};
				model.addRow(colRow);
			}
			

			JLabel lblNewLabel_3 = new JLabel("");
			lblNewLabel_3.setBackground(new Color(0, 255, 255));
			lblNewLabel_3.setBounds(0, 0, 772, 657);
			CoursesPanel.add(lblNewLabel_3); 
			ImageIcon backgroudImage = new ImageIcon(Dashboard.class.getResource("/main/icon/background5.jpeg"));
			Image newBackgroudImage = backgroudImage.getImage();
			Image resizeNewBackgroudImage = newBackgroudImage.getScaledInstance(900, 700, java.awt.Image.SCALE_SMOOTH);
			lblNewLabel_3.setIcon(new ImageIcon(resizeNewBackgroudImage));
	}
	
	
	public static ResultSet getStudent() throws Exception {
		Connection con = DBconnection.connection();
		PreparedStatement pr = con.prepareStatement("select *from students");
		ResultSet rs = pr.executeQuery();		
		return rs;
	}
	public static ResultSet getCourse() throws Exception {
		Connection con = DBconnection.connection();
		PreparedStatement pr = con.prepareStatement("select *from courses");
		ResultSet rs = pr.executeQuery();		
		return rs;
	}
}


