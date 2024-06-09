package resources;

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
	private JTextField codeTextField;
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
		StudentRegistaionPanel.setVisible(false);
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
		

		
		
	}
	public void StudentRegistaionPanel(JPanel StudentRegistaionPanel)
	{
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblNewLabel_1.setBounds(230, 191, 141, 34);
		StudentRegistaionPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblNewLabel_2.setBounds(230, 289, 141, 35);
		StudentRegistaionPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblNewLabel_4.setBounds(230, 380, 141, 35);
		StudentRegistaionPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Re - Password");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Maiandra GD", Font.BOLD, 20));
		lblNewLabel_5.setBounds(230, 471, 141, 39);
		StudentRegistaionPanel.add(lblNewLabel_5);
		
		JTextField textField_name = new JTextField();
		textField_name.setColumns(10);
		textField_name.setBounds(233, 236, 255, 34);
		StudentRegistaionPanel.add(textField_name);
		
		JTextField textField_email = new JTextField();
		textField_email.setColumns(10);
		textField_email.setBounds(230, 335, 255, 34);
		StudentRegistaionPanel.add(textField_email);
		
		JTextField textField_password = new JTextField();
		textField_password.setColumns(10);
		textField_password.setBounds(230, 426, 255, 34);
		StudentRegistaionPanel.add(textField_password);
		
		JTextField textField_rePass = new JTextField();
		textField_rePass.setColumns(10);
		textField_rePass.setBounds(230, 521, 255, 34);
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
						StudentDataInsart(name,email,password);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(rootPane, "Student Create Success");
					Dashboard.main(null);
					setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(rootPane, "Password dos't match");
				}
				
			}
		});
		btnNewButton_2.setBounds(365, 590, 120, 34);
		btnNewButton_2.setFont(new Font("Maiandra GD", Font.BOLD, 16));
		StudentRegistaionPanel.add(btnNewButton_2);
		
		JLabel lblNewLabel_6 = new JLabel(" New Student Registation");
		lblNewLabel_6.setBackground(new Color(128, 128, 128));
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setFont(new Font("Kalpurush", Font.BOLD, 35));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(10, 77, 752, 63);
		StudentRegistaionPanel.add(lblNewLabel_6);
		
		
		JLabel background = new JLabel("");
		background.setBackground(new Color(0, 255, 255));
		background.setBounds(0, 0, 772, 657);
		StudentRegistaionPanel.add(background); 
		ImageIcon backgroudImage = new ImageIcon(Dashboard.class.getResource("/main/icon/background5.jpeg"));
		Image newBackgroudImage = backgroudImage.getImage();
		Image resizeNewBackgroudImage = newBackgroudImage.getScaledInstance(900, 700, java.awt.Image.SCALE_SMOOTH);
		background.setIcon(new ImageIcon(resizeNewBackgroudImage));
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
		
		JLabel lblError = new JLabel("");
		lblError.setForeground(new Color(255, 0, 0));
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setFont(new Font("Raleway SemiBold", Font.BOLD, 15));
		lblError.setBounds(0, 88, 752, 32);
		CoursesPanel.add(lblError);
		
		JLabel inputTitle = new JLabel("Title"); 
		inputTitle.setForeground(new Color(255, 255, 255));
		inputTitle.setFont(new Font("Raleway SemiBold", Font.PLAIN, 18));
		inputTitle.setBounds(10, 131, 123, 20);
		CoursesPanel.add(inputTitle);
		
		titleTextField = new JTextField();
		titleTextField.setColumns(10);
		titleTextField.setBounds(10, 162, 256, 32);
		CoursesPanel.add(titleTextField);
		
		
		

		
		JLabel inputCode = new JLabel("Code");
		inputCode.setForeground(new Color(255, 255, 255));
		inputCode.setFont(new Font("Raleway SemiBold", Font.PLAIN, 18));
		inputCode.setBounds(10, 217, 123, 20);
		CoursesPanel.add(inputCode);
		
		codeTextField = new JTextField();
		codeTextField.setColumns(10);
		codeTextField.setBounds(10, 248, 256, 32);
		CoursesPanel.add(codeTextField);
		
		
		JLabel inputPrice = new JLabel("Price");
		inputPrice.setForeground(new Color(255, 255, 255));
		inputPrice.setFont(new Font("Raleway SemiBold", Font.PLAIN, 18));
		inputPrice.setBounds(10, 299, 123, 20);
		CoursesPanel.add(inputPrice);
		
		priceTextField = new JTextField();
		priceTextField.setColumns(10);
		priceTextField.setBounds(10, 330, 256, 32);
		CoursesPanel.add(priceTextField);
		
		
		JLabel inputCreditHours = new JLabel("Credit Hours");
		inputCreditHours.setForeground(new Color(255, 255, 255));
		inputCreditHours.setFont(new Font("Raleway SemiBold", Font.PLAIN, 18));
		inputCreditHours.setBounds(10, 384, 123, 20);
		CoursesPanel.add(inputCreditHours);
		
		crTextField = new JTextField();
		crTextField.setColumns(10);
		crTextField.setBounds(10, 415, 256, 32);
		CoursesPanel.add(crTextField);
		
		JButton coursesSubmit = new JButton("Submit");
		coursesSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int row =table.getSelectedRow();
					String name = titleTextField.getText();
					String code = codeTextField.getText();
					int price = Integer.parseInt(priceTextField.getText());
					int credit_hours = Integer.parseInt(crTextField.getText());
					if(row >=0) {
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						int id = Integer.parseInt(model.getValueAt(row, 0).toString());
						courseDataUpdate(name,code, price,credit_hours, id);
						JOptionPane.showMessageDialog(rootPane, "Course Edit Success");
					}
					else {
						courseDataInsart(name,code, price,credit_hours);
						JOptionPane.showMessageDialog(rootPane, "Course Create Success");
					}
					
					Dashboard.main(null);
					setVisible(false);
					
					
				}
				catch(Exception e1){
					e1.printStackTrace();
				}
				
			}
		});
		coursesSubmit.setFont(new Font("Raleway Black", Font.PLAIN, 16));
		coursesSubmit.setBounds(138, 541, 123, 29);
		CoursesPanel.add(coursesSubmit);
		
		JButton coursesEdit = new JButton("Edit");
		coursesEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int row =table.getSelectedRow();
					if(row>=0) {
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						int id = Integer.parseInt(model.getValueAt(row, 0).toString());	
						String name = titleTextField.getText();
						String code = codeTextField.getText();
						int price = Integer.parseInt(priceTextField.getText());
						int credit_hours = Integer.parseInt(crTextField.getText());
						courseDataUpdate(name,code, price,credit_hours, id);
						JOptionPane.showMessageDialog(rootPane, "Course Edit Success");
						Dashboard.main(null);
						setVisible(false);
					}
					else {
						lblError.setText("Please select row for Edit");
					}
					
					
				}
				catch(Exception e1){
					e1.printStackTrace();
				}
				
			}
		});
		coursesEdit.setFont(new Font("Raleway Black", Font.PLAIN, 16));
		coursesEdit.setBounds(302, 541, 123, 29);
		CoursesPanel.add(coursesEdit);
		
		
		
		JButton coursesDelete = new JButton("Delete");
		coursesDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int row =table.getSelectedRow();
					if(row >=0) {
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						int id = Integer.parseInt(model.getValueAt(row, 0).toString());
						courseDataDelete(id);
						JOptionPane.showMessageDialog(rootPane, "Course Delete Success");
						Dashboard.main(null);
						setVisible(false);
					}
					else {
						lblError.setText("Please select row for Delete");
					}
					
					
					
				}
				catch(Exception e1){
					e1.printStackTrace();
				}
				
			}
		});
		coursesDelete.setFont(new Font("Raleway Black", Font.PLAIN, 16));
		coursesDelete.setBounds(469, 541, 143, 29);
		CoursesPanel.add(coursesDelete);
		
		
		JPanel coursesCourseListPanel = new JPanel();
		coursesCourseListPanel.setBounds(284, 131, 468, 316);
		CoursesPanel.add(coursesCourseListPanel);
		coursesCourseListPanel.setLayout(null);
		coursesCourseListPanel.setBackground(new Color(64, 128, 128));
		
			JLabel courseCourseListTitle = new JLabel("Course List");
			courseCourseListTitle.setHorizontalAlignment(SwingConstants.CENTER);
			courseCourseListTitle.setForeground(Color.WHITE);
			courseCourseListTitle.setFont(new Font("Raleway SemiBold", Font.PLAIN, 25));
			courseCourseListTitle.setBounds(10, 0, 448, 44);
			coursesCourseListPanel.add(courseCourseListTitle);
			
			JScrollPane courseCourseListScrollPane = new JScrollPane();
			courseCourseListScrollPane.setBounds(10, 45, 448, 260);
			coursesCourseListPanel.add(courseCourseListScrollPane); 
			
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int row =table.getSelectedRow();
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					titleTextField.setText( model.getValueAt(row, 1).toString());
					codeTextField.setText(model.getValueAt(row, 2).toString());
					priceTextField.setText(model.getValueAt(row, 3).toString());
					crTextField.setText(model.getValueAt(row, 4).toString());
				}
			});
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			String colNames[]= {"id", "Title","Code","Price", "Credit Hours"};
			model.setColumnIdentifiers(colNames);
			table.getColumnModel().getColumn(0).setPreferredWidth(27);  
			table.getColumnModel().getColumn(1).setPreferredWidth(220); 
			table.getColumnModel().getColumn(2).setPreferredWidth(100); 
			table.getColumnModel().getColumn(3).setPreferredWidth(100); 
			table.getColumnModel().getColumn(4).setPreferredWidth(100); 
			courseCourseListScrollPane.setViewportView(table);
			 
			 
			ResultSet courseRsCourses = getCourse();
			String cId, cTitle,cCode,cPrice,cHours;
			while(courseRsCourses.next()) { 
				cId = courseRsCourses.getString("id"); 
				cTitle = courseRsCourses.getString("title");
				cCode = courseRsCourses.getString("code");
				cPrice = courseRsCourses.getString("price");
				cHours = courseRsCourses.getString("credit_houre");
				String colRow[] = {cId, cTitle,cCode,cPrice,cHours};
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
	
	public static void courseDataInsart(String name,String code,int price,int credit_hours) throws Exception {
			
			PreparedStatement course = DBconnection.courseInsert();
							  course.setString(1, name);
							  course.setString(2, code);
							  course.setInt(3, price);
							  course.setInt(4, credit_hours);
							  course.executeUpdate();
		}
	
	public static void courseDataUpdate(String name,String code,int price,int credit_hours,int id) throws Exception {
		
		PreparedStatement course = DBconnection.courseUpdate();
						  course.setString(1, name);
						  course.setString(2, code);
						  course.setInt(3, price);
						  course.setInt(4, credit_hours);
						  course.setInt(5,id);
						  course.executeUpdate();
	}
	
	public static void courseDataDelete(int id) throws Exception {
		
		PreparedStatement course = DBconnection.courseDelete();
						  course.setInt(1, id);
						  course.executeUpdate();
	}
	public static  void StudentDataInsart(String name, String email, String password) throws  Exception  {
		
		PreparedStatement 	student = DBconnection.studentInsart();
							student.setString(1, name);
							student.setString(2, email);
							student.setString(3, password);
							student.executeUpdate();
	}

}


