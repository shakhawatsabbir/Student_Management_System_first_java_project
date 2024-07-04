package resources;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
import java.io.FileNotFoundException;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

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
	private JTable table_1;
	private JTextField textField_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		if(Admin_Login.AdminLoginStatus == 1) {
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
		StudentRegistaionPanel.setVisible(false);
		StudentRegistaionPanel(StudentRegistaionPanel);
		

		JPanel StudentManagmentPanel = new JPanel();
		StudentManagmentPanel.setBounds(268, 63, 772, 657);
		contentPane.add(StudentManagmentPanel);
		StudentManagmentPanel.setVisible(false);
		StudentManagmentPanel.setLayout(null);
		StudentManagment(StudentManagmentPanel);
		
		
		
		
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
		SidebarPanel(sidebarPanel, DashboardPanel, homeLabel, coursesPanel,StudentRegistaionPanel,StudentManagmentPanel);
		
		
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
	public void StudentRegistaionPanel(JPanel StudentRegistaionPanel) throws Exception
	{
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 128, 128));
		panel.setBounds(0, 0, 772, 657);
		StudentRegistaionPanel.add(panel);
		panel.setLayout(null);
		
		JTextField textField_name = new JTextField();
		textField_name.setBounds(115, 97, 241, 30);
		panel.add(textField_name);
		textField_name.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Student Management ");
		lblNewLabel_6.setBounds(10, 23, 752, 49);
		panel.add(lblNewLabel_6);
		lblNewLabel_6.setBackground(new Color(128, 128, 128));
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setFont(new Font("Kalpurush", Font.BOLD, 35));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(10, 93, 79, 34);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Maiandra GD", Font.BOLD, 18));
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setBounds(379, 93, 89, 34);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Maiandra GD", Font.BOLD, 18));
		
		JTextField textField_email = new JTextField();
		textField_email.setBounds(527, 97, 235, 30);
		panel.add(textField_email);
		textField_email.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setBounds(10, 208, 96, 34);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Maiandra GD", Font.BOLD, 18));
		
		JTextField textField_password = new JTextField();
		textField_password.setBounds(115, 212, 241, 30);
		panel.add(textField_password);
		textField_password.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Re - Password");
		lblNewLabel_5.setBounds(376, 208, 141, 34);
		panel.add(lblNewLabel_5);
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Maiandra GD", Font.BOLD, 18));
		
		JTextField textField_rePass = new JTextField();
		textField_rePass.setBounds(527, 212, 235, 30);
		panel.add(textField_rePass);
		textField_rePass.setColumns(10);
		
		
		JLabel lblNewLabel_5_1 = new JLabel("Gender ");
		lblNewLabel_5_1.setForeground(Color.WHITE);
		lblNewLabel_5_1.setFont(new Font("Maiandra GD", Font.BOLD, 18));
		lblNewLabel_5_1.setBounds(376, 147, 141, 34);
		panel.add(lblNewLabel_5_1);
		
		JTextField textField_mobile = new JTextField();
		textField_mobile.setColumns(10);
		textField_mobile.setBounds(115, 151, 241, 30);
		panel.add(textField_mobile);
		
		JLabel lblNewLabel_mobile = new JLabel("Mobile");
		lblNewLabel_mobile.setForeground(Color.WHITE);
		lblNewLabel_mobile.setFont(new Font("Maiandra GD", Font.BOLD, 18));
		lblNewLabel_mobile.setBounds(10, 147, 96, 34);
		panel.add(lblNewLabel_mobile);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		comboBox.setBounds(527, 152, 235, 32);
		panel.add(comboBox);
		
		
		JScrollPane studentListScrollPane = new JScrollPane();
		studentListScrollPane.setBounds(10, 334, 752, 301);
		panel.add(studentListScrollPane);
		
		StudentTable = new JTable();
		DefaultTableModel model= (DefaultTableModel) StudentTable.getModel();
		studentTable(model);
		StudentTable.getColumnModel().getColumn(0).setPreferredWidth(16);
		StudentTable.getColumnModel().getColumn(1).setPreferredWidth(120);
		StudentTable.getColumnModel().getColumn(2).setPreferredWidth(120);
		StudentTable.getColumnModel().getColumn(3).setPreferredWidth(120);
		studentListScrollPane.setViewportView(StudentTable);
		
		JButton btnNewButton_2 = new JButton("Create");
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBounds(642, 268, 120, 29);
		panel.add(btnNewButton_2);
		btnNewButton_2.setBackground(new Color(49, 100, 100));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = textField_name.getText();
				String email = textField_email.getText();
				String mobile = textField_mobile.getText();
				String gendar = (String) comboBox.getSelectedItem();
				String password = textField_password.getText();
				String re_pass = textField_rePass.getText();
				if(password.equals(re_pass)) {
					try {
						password = Password.passwordHash(password);
						StudentDataInsart(name,email,password,mobile,gendar);
						JOptionPane.showMessageDialog(rootPane, "Student Create Success");
						model.setRowCount(0);
						studentTable(model);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					

				}
				else
				{
					JOptionPane.showMessageDialog(rootPane, "Password dos't match");
				}
				
			}
		});
		btnNewButton_2.setFont(new Font("Maiandra GD", Font.BOLD, 15));
		
			 
		
		
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
	
	public void SidebarPanel(JPanel sidebarPanel , JPanel DashboardPanel, JLabel homeLabel, JPanel coursesPanel, JPanel StudentRegistaionPanel, JPanel StudentManagmentPanel ) {
		
		JMenu refrashMenuBtn = new JMenu("Refresh ");
		refrashMenuBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				Dashboard.main(null);
			}
		});
		refrashMenuBtn.setFont(new Font("Segoe UI", Font.BOLD, 12));
		refrashMenuBtn.setForeground(Color.WHITE);
		refrashMenuBtn.setOpaque(true);
		refrashMenuBtn.setBackground(new Color(143, 181, 184));
		refrashMenuBtn.setBounds(40, 58, 187, 30);
		sidebarPanel.add(refrashMenuBtn);
		
		ImageIcon menuIconRefresh = new ImageIcon(Dashboard.class.getResource("/main/icon/pngwing.png"));
		Image menuIconRefreshImage = menuIconRefresh.getImage();
		Image resizeMenuIconRefreshImage = menuIconRefreshImage.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		refrashMenuBtn.setIcon(new ImageIcon(resizeMenuIconRefreshImage));
		
		
		
		JMenu homeMenuBtn = new JMenu("Home");
		homeMenuBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DashboardPanel.setVisible(true);
				coursesPanel.setVisible(false);
				StudentManagmentPanel.setVisible(false);
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
		
		JMenu studentRegistationMenuBtn = new JMenu("Student Managment");
		studentRegistationMenuBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DashboardPanel.setVisible(false);
				coursesPanel.setVisible(false);
				StudentManagmentPanel.setVisible(false);
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
		

		JMenu coursesAddMenuBtn = new JMenu("Courses Manage");
		coursesAddMenuBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DashboardPanel.setVisible(false);
				coursesPanel.setVisible(true);
				StudentRegistaionPanel.setVisible(false);
				StudentManagmentPanel.setVisible(false);
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
		LogoutBtn.setBounds(40, 333, 187, 30);
		sidebarPanel.add(LogoutBtn);
		
		ImageIcon menuIconLogout = new ImageIcon(Dashboard.class.getResource("/main/icon/logout.png"));
		Image menuIconLogoutImage = menuIconLogout.getImage();
		Image resizeMenuIconLogoutImage = menuIconLogoutImage.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		LogoutBtn.setIcon(new ImageIcon(resizeMenuIconLogoutImage));
		
	
		JMenu mnStudentManage = new JMenu("Enroll Manage");
		mnStudentManage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DashboardPanel.setVisible(false);
				coursesPanel.setVisible(false);
				StudentRegistaionPanel.setVisible(false);
				StudentManagmentPanel.setVisible(true);
				homeLabel.setText("Courses Insart");
			}
		});
		mnStudentManage.setOpaque(true);
		mnStudentManage.setForeground(Color.WHITE);
		mnStudentManage.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnStudentManage.setBackground(new Color(143, 181, 184));
		mnStudentManage.setBounds(40, 278, 187, 30);
		sidebarPanel.add(mnStudentManage);
		
		ImageIcon menuIconmnStudentManage = new ImageIcon(Dashboard.class.getResource("/main/icon/courses.png"));
		Image menuIconStudentManageImage = menuIconmnStudentManage.getImage();
		Image resizeMenuIconStudentManageImage = menuIconStudentManageImage.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		mnStudentManage.setIcon(new ImageIcon(resizeMenuIconStudentManageImage));
	
	}
	
	public void DashboardPanel(JPanel DashboardPanel) throws Exception {
		
		
		JPanel studentListPanel = new JPanel();
		studentListPanel.setBounds(36, 340, 322, 243);
		DashboardPanel.add(studentListPanel);
		studentListPanel.setBackground(new Color(255, 255, 255));
		studentListPanel.setLayout(null);
		
			JLabel studentListTitle = new JLabel("Student List");
			studentListTitle.setForeground(new Color(64, 128, 128));
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
		courseListPanel.setBounds(411, 340, 322, 243);
		DashboardPanel.add(courseListPanel);
		courseListPanel.setLayout(null);
		courseListPanel.setBackground(new Color(255, 255, 255));
		
			JLabel courseListTitle = new JLabel("Course List");
			courseListTitle.setHorizontalAlignment(SwingConstants.CENTER);
			courseListTitle.setForeground(new Color(64, 128, 128));
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
			
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 772, 657);
		panel.setBackground(new Color(64, 128, 128));
		DashboardPanel.add(panel);
		panel.setLayout(null);	
		JPanel studentCountPanel = new JPanel();
		studentCountPanel.setBounds(255, 135, 233, 161);
		panel.add(studentCountPanel);
		studentCountPanel.setBackground(new Color(90, 173, 173));
		studentCountPanel.setLayout(null);
		
			
				JLabel totalStudentTitle = new JLabel("Total Student");
				totalStudentTitle.setBackground(new Color(255, 255, 255));
				totalStudentTitle.setForeground(new Color(255, 255, 255));
				totalStudentTitle.setHorizontalAlignment(SwingConstants.CENTER);
				totalStudentTitle.setFont(new Font("Raleway SemiBold", Font.PLAIN, 25));
				totalStudentTitle.setBounds(10, 11, 213, 44);
				studentCountPanel.add(totalStudentTitle);
				
				JLabel totalStudentCount = new JLabel();
				totalStudentCount.setHorizontalAlignment(SwingConstants.CENTER);
				totalStudentCount.setForeground(Color.WHITE);
				totalStudentCount.setFont(new Font("Raleway ExtraBold", Font.PLAIN, 30));
				totalStudentCount.setBounds(57, 66, 118, 51);
				studentCountPanel.add(totalStudentCount);
			
		totalStudentCount.setText(String.valueOf(totalStudent));
		
		
		
		
		JPanel courseCountPanel = new JPanel();
		courseCountPanel.setBounds(498, 135, 233, 161);
		panel.add(courseCountPanel);
		courseCountPanel.setLayout(null);
		courseCountPanel.setBackground(new Color(90, 173, 173));
		
			JLabel totalCourseTitle = new JLabel("Total Course");
			totalCourseTitle.setHorizontalAlignment(SwingConstants.CENTER);
			totalCourseTitle.setForeground(Color.WHITE);
			totalCourseTitle.setFont(new Font("Raleway SemiBold", Font.PLAIN, 25));
			totalCourseTitle.setBounds(10, 11, 213, 44);
			courseCountPanel.add(totalCourseTitle);
			
			JLabel totalCourseCount = new JLabel();
			totalCourseCount.setHorizontalAlignment(SwingConstants.CENTER);
			totalCourseCount.setForeground(Color.WHITE);
			totalCourseCount.setFont(new Font("Raleway ExtraBold", Font.PLAIN, 30));
			totalCourseCount.setBounds(53, 66, 118, 51);
			courseCountPanel.add(totalCourseCount);
		totalCourseCount.setText(String.valueOf(totalCourse));
		
		JButton btnNewButton_1 = new JButton("Export Student");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					 GeneratedPDF.makePdf(getStudent());
	
				} catch (FileNotFoundException e1) {
					
					e1.printStackTrace();
				} catch (DocumentException e1) {
					
					e1.printStackTrace();
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBackground(new Color(53, 106, 106));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Raleway SemiBold", Font.PLAIN, 18));
		btnNewButton_1.setBounds(42, 135, 192, 76);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Export Courses");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					 GeneratedPDF.makePdf2(getCourse());
	
				} catch (FileNotFoundException e1) {
					
					e1.printStackTrace();
				} catch (DocumentException e1) {
					
					e1.printStackTrace();
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		});
		btnNewButton_1_1.setBackground(new Color(53, 106, 106));
		btnNewButton_1_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1_1.setFont(new Font("Raleway SemiBold", Font.PLAIN, 18));
		btnNewButton_1_1.setBounds(42, 220, 192, 76);
		panel.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_7 = new JLabel("Student Management System");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Raleway SemiBold", Font.PLAIN, 28));
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setBounds(10, 27, 752, 53);
		panel.add(lblNewLabel_7);
		
	}
	
	public  void CoursesPanel(JPanel CoursesPanel) throws Exception {
		
		
		JPanel coursesCourseListPanel = new JPanel();
		coursesCourseListPanel.setBounds(0, 0, 772, 657);
		CoursesPanel.add(coursesCourseListPanel);
		coursesCourseListPanel.setLayout(null);
		coursesCourseListPanel.setBackground(new Color(64, 128, 128));
		
			JLabel courseCourseListTitle = new JLabel("Course List Manage");
			courseCourseListTitle.setHorizontalAlignment(SwingConstants.CENTER);
			courseCourseListTitle.setForeground(Color.WHITE);
			courseCourseListTitle.setFont(new Font("Raleway SemiBold", Font.PLAIN, 28));
			courseCourseListTitle.setBounds(10, 16, 752, 44);
			coursesCourseListPanel.add(courseCourseListTitle);
			
			JScrollPane courseCourseListScrollPane = new JScrollPane();
			courseCourseListScrollPane.setBounds(10, 244, 752, 304);
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
			coursesTable(model);
			table.getColumnModel().getColumn(0).setPreferredWidth(27);  
			table.getColumnModel().getColumn(1).setPreferredWidth(220); 
			table.getColumnModel().getColumn(2).setPreferredWidth(100); 
			table.getColumnModel().getColumn(3).setPreferredWidth(100); 
			table.getColumnModel().getColumn(4).setPreferredWidth(100);
			courseCourseListScrollPane.setViewportView(table);
			
			JLabel lblError = new JLabel("");
			lblError.setBounds(10, 71, 752, 20);
			coursesCourseListPanel.add(lblError);
			lblError.setForeground(new Color(255, 0, 0));
			lblError.setHorizontalAlignment(SwingConstants.CENTER);
			lblError.setFont(new Font("Raleway SemiBold", Font.BOLD, 15));
			
			JButton coursesEdit = new JButton("Edit");
			coursesEdit.setBackground(new Color(49, 100, 100));
			coursesEdit.setForeground(new Color(255, 255, 255));
			coursesEdit.setBounds(452, 581, 123, 29);
			coursesCourseListPanel.add(coursesEdit);
			coursesEdit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						int row =table.getSelectedRow();
						if(row>0) {
							DefaultTableModel model = (DefaultTableModel) table.getModel();
							int id = Integer.parseInt(model.getValueAt(row, 0).toString());	
							String name = titleTextField.getText();
							String code = codeTextField.getText();
							int price = Integer.parseInt(priceTextField.getText());
							int credit_hours = Integer.parseInt(crTextField.getText());
							courseDataUpdate(name,code, price,credit_hours, id);
							model.setRowCount(0);
							coursesTable(model);
							titleTextField.setText( " ");
							codeTextField.setText(" ");
							priceTextField.setText(" ");
							crTextField.setText(" ");
							JOptionPane.showMessageDialog(rootPane, "Course Edit Success");

							
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
			
			
			
			JButton coursesDelete = new JButton("Delete");
			coursesDelete.setBackground(new Color(49, 100, 100));
			coursesDelete.setForeground(new Color(255, 255, 255));
			coursesDelete.setBounds(619, 581, 143, 29);
			coursesCourseListPanel.add(coursesDelete);
			coursesDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						int row =table.getSelectedRow();
						if(row >0) {
							DefaultTableModel model = (DefaultTableModel) table.getModel();
							int id = Integer.parseInt(model.getValueAt(row, 0).toString());
							int dialogResult = JOptionPane.showConfirmDialog(null, "Do you went to delete this data","Warning", JOptionPane.YES_NO_CANCEL_OPTION);
							
							if(dialogResult == JOptionPane.YES_OPTION)
							{
								try {
									courseDataDelete(id);
									model.setRowCount(0);
									coursesTable(model);
									titleTextField.setText( " ");
									codeTextField.setText(" ");
									priceTextField.setText(" ");
									crTextField.setText(" "); 
									JOptionPane.showMessageDialog(rootPane, "Course Delete Success");

								} catch (ClassNotFoundException | SQLException e1) {
							
									e1.printStackTrace();
								}
							}
							
							
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
			
			JButton coursesSubmit = new JButton("Submit");
			coursesSubmit.setForeground(new Color(255, 255, 255));
			coursesSubmit.setBackground(new Color(49, 100, 100));
			coursesSubmit.setBounds(288, 581, 123, 29);
			coursesCourseListPanel.add(coursesSubmit);
			coursesSubmit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						int row =table.getSelectedRow();
						String name = titleTextField.getText();
						String code = codeTextField.getText();
						int price = Integer.parseInt(priceTextField.getText());
						int credit_hours = Integer.parseInt(crTextField.getText());
						if(row >0) {
							DefaultTableModel model = (DefaultTableModel) table.getModel();
							int id = Integer.parseInt(model.getValueAt(row, 0).toString());
							courseDataUpdate(name,code, price,credit_hours, id);
							model.setRowCount(0);
							coursesTable(model);
							titleTextField.setText( " ");
							codeTextField.setText(" ");
							priceTextField.setText(" ");
							crTextField.setText(" ");
							JOptionPane.showMessageDialog(rootPane, "Course Edit Success");

						}
						else {
							DefaultTableModel model = (DefaultTableModel) table.getModel();
							courseDataInsart(name,code, price,credit_hours);
							model.setRowCount(0);
							coursesTable(model);
							titleTextField.setText( " ");
							codeTextField.setText(" ");
							priceTextField.setText(" ");
							crTextField.setText(" ");
							JOptionPane.showMessageDialog(rootPane, "Course Create Success");

						}
						
						
						
						
					}
					catch(Exception e1){
						e1.printStackTrace();
					}
					
					
				}
			});
			coursesSubmit.setFont(new Font("Raleway Black", Font.PLAIN, 16));
			
			
			JLabel inputCreditHours = new JLabel("Credit Hours");
			inputCreditHours.setBounds(371, 175, 123, 29);
			coursesCourseListPanel.add(inputCreditHours);
			inputCreditHours.setForeground(new Color(255, 255, 255));
			inputCreditHours.setFont(new Font("Raleway SemiBold", Font.PLAIN, 18));
			
			
			JLabel inputPrice = new JLabel("Price");
			inputPrice.setBounds(10, 178, 52, 20);
			coursesCourseListPanel.add(inputPrice);
			inputPrice.setForeground(new Color(255, 255, 255));
			inputPrice.setFont(new Font("Raleway SemiBold", Font.PLAIN, 18));
			
			priceTextField = new JTextField();
			priceTextField.setBounds(88, 171, 236, 32);
			coursesCourseListPanel.add(priceTextField);
			priceTextField.setColumns(10);
			
			crTextField = new JTextField();
			crTextField.setBounds(526, 172, 236, 32);
			coursesCourseListPanel.add(crTextField);
			crTextField.setColumns(10);
			
			codeTextField = new JTextField();
			codeTextField.setBounds(526, 120, 236, 32);
			coursesCourseListPanel.add(codeTextField);
			codeTextField.setColumns(10);
			
			
			JLabel inputCode = new JLabel("Code");
			inputCode.setBounds(371, 124, 64, 20);
			coursesCourseListPanel.add(inputCode);
			inputCode.setForeground(new Color(255, 255, 255));
			inputCode.setFont(new Font("Raleway SemiBold", Font.PLAIN, 18));
			
			titleTextField = new JTextField();
			titleTextField.setBounds(88, 120, 236, 32);
			coursesCourseListPanel.add(titleTextField);
			titleTextField.setColumns(10);
			
			JLabel inputTitle = new JLabel("Title"); 
			inputTitle.setBounds(10, 123, 52, 20);
			coursesCourseListPanel.add(inputTitle);
			inputTitle.setForeground(new Color(255, 255, 255));
			inputTitle.setFont(new Font("Raleway SemiBold", Font.PLAIN, 18));
			
			

			JLabel lblNewLabel_3 = new JLabel("");
			lblNewLabel_3.setBackground(new Color(0, 255, 255));
			lblNewLabel_3.setBounds(0, 0, 772, 657);
			CoursesPanel.add(lblNewLabel_3); 
			ImageIcon backgroudImage = new ImageIcon(Dashboard.class.getResource("/main/icon/background5.jpeg"));
			Image newBackgroudImage = backgroudImage.getImage();
			Image resizeNewBackgroudImage = newBackgroudImage.getScaledInstance(900, 700, java.awt.Image.SCALE_SMOOTH);
			lblNewLabel_3.setIcon(new ImageIcon(resizeNewBackgroudImage));
	}
	
	public void StudentManagment(JPanel StudentManagmentPanel ) throws Exception {
		
		JPanel Spanel = new JPanel();
		Spanel.setBackground(new Color(64, 128, 128));
		Spanel.setBounds(0, 0, 772, 657);
		StudentManagmentPanel.add(Spanel);
		Spanel.setLayout(null);
		
		JTextField textField_title = new JTextField();
		textField_title.setBounds(532, 145, 230, 33);
		Spanel.add(textField_title);
		textField_title.setColumns(10);
		
		
		JTextField textField_name = new JTextField();
		textField_name.setBounds(145, 145, 230, 33);
		Spanel.add(textField_name);
		textField_name.setColumns(10);
		
		
		JScrollPane scrollPanes = new JScrollPane();
		scrollPanes.setBounds(10, 240, 752, 311);
		Spanel.add(scrollPanes);
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row =table_1.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) table_1.getModel();
				textField_name.setText( model.getValueAt(row, 1).toString());
				textField_title.setText(model.getValueAt(row, 2).toString());
			}
		});
		DefaultTableModel model = (DefaultTableModel) table_1.getModel();
		enrollTable(model);
		table_1.getColumnModel().getColumn(0).setPreferredWidth(27);  
		table_1.getColumnModel().getColumn(1).setPreferredWidth(220); 
		table_1.getColumnModel().getColumn(2).setPreferredWidth(100);
		scrollPanes.setViewportView(table_1);
		
		
		
		JLabel lblNewLabel_4 = new JLabel("Courses Title");
		lblNewLabel_4.setBounds(395, 145, 115, 27);
		Spanel.add(lblNewLabel_4);
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Maiandra GD", Font.BOLD, 18));
		
		
		JLabel lblNewLabel_1 = new JLabel("Student Name");
		lblNewLabel_1.setBounds(10, 145, 125, 27);
		Spanel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Maiandra GD", Font.BOLD, 18));
		
		
		
		JLabel lblTitle_1 = new JLabel("Student Enroll Courses Manage");
		lblTitle_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle_1.setForeground(new Color(255, 255, 255));
		lblTitle_1.setFont(new Font("Raleway SemiBold", Font.BOLD, 30));
		lblTitle_1.setBounds(10, 38, 752, 45);
		Spanel.add(lblTitle_1);
		
		JButton btnNewButton = new JButton("Update Status ");
		btnNewButton.setFont(new Font("Raleway SemiBold", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row =table_1.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) table_1.getModel();
				int enrollId = Integer.parseInt(model.getValueAt(row, 0).toString());
				String enrollStatus = model.getValueAt(row, 3).toString();
				int enrollStatusU;
				if(enrollStatus == "Not Approved") {
					enrollStatusU = 1;
				}
				else
				{
					enrollStatusU = 0;
				}
				try {
					updateEnroll(enrollId,enrollStatusU);
					model.setRowCount(0);
					enrollTable(model);
					JOptionPane.showMessageDialog(rootPane, "Enroll Status Update Success");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(47, 94, 94));
		btnNewButton.setBounds(593, 580, 169, 33);
		Spanel.add(btnNewButton);
		
		
		JLabel lblNewLabel_s = new JLabel("");
		lblNewLabel_s.setBackground(new Color(0, 255, 255));
		lblNewLabel_s.setBounds(0, 0, 772, 657);
		StudentManagmentPanel.add(lblNewLabel_s); 
		ImageIcon backgroudImage = new ImageIcon(Dashboard.class.getResource("/main/icon/background5.jpeg"));
		Image newBackgroudImage = backgroudImage.getImage();
		Image resizeNewBackgroudImage = newBackgroudImage.getScaledInstance(900, 700, java.awt.Image.SCALE_SMOOTH);
		lblNewLabel_s.setIcon(new ImageIcon(resizeNewBackgroudImage));
	}
	
	public static void studentTable(DefaultTableModel model) throws Exception {
		String colName[] = {"id", "Name","Email","Mobile","Gendar"};
		model.setColumnIdentifiers(colName);
		
		String id,name,email,gendar,mobile;
		ResultSet rs= getStudent();
		while(rs.next())
		{
			id= rs.getString("id");
			name = rs.getString("name");
			email = rs.getString("email");
			gendar = rs.getString("gendar");
			mobile = rs.getString("mobile");
			
			
			String row[]= {id,name,email,mobile,gendar};
			model.addRow(row);
		}
	}
	
	public static void enrollTable(DefaultTableModel model) throws Exception
	{
		String colNames[]= {"id", "Student Name","Course","Status"};
		model.setColumnIdentifiers(colNames);
		ResultSet courseRsEnroll = getEnroll();
		String cId, studentName,coursesTitle,status;
		while(courseRsEnroll.next()) { 
			cId = courseRsEnroll.getString("id"); 
			status = courseRsEnroll.getString("status");
			
			if(Integer.parseInt(status) == 0) {
				status = "Not Approved";
			}
			else
			{
				status = "Approved";
			}
			coursesTitle = getCoursesTitle(courseRsEnroll.getString("courses_id"));
			studentName = getStudentName(courseRsEnroll.getString("student_id"));
			String colRow[] = {cId, studentName,coursesTitle,status};
			model.addRow(colRow);
		} 
	}
	
	public static void coursesTable(DefaultTableModel model) throws Exception {
		String colNames[]= {"id", "Title","Code","Price", "Credit Hours"};
		model.setColumnIdentifiers(colNames);
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
	}
	
	public static ResultSet getStudent() throws Exception {
		Connection con = DBconnection.connection();
		PreparedStatement pr = con.prepareStatement("select *from students");
		ResultSet rs = pr.executeQuery();		
		return rs;
	}
	
	public static String getStudentName(String Id) throws Exception {
		Connection con = DBconnection.connection();
		PreparedStatement pr = con.prepareStatement("select name from students where id = ?");
		pr.setString(1,Id);
		ResultSet rs = pr.executeQuery();
		String value = null;
		while(rs.next()) {
			value = rs.getString("name");
		}
		return value;
		
	}
	
	public static String getCoursesTitle(String Id) throws Exception {
		Connection con = DBconnection.connection();
		PreparedStatement pr = con.prepareStatement("select title from courses where id = ?");
		pr.setString(1,Id);
		ResultSet rs = pr.executeQuery();
		String value = null;
		while(rs.next()) {
			value = rs.getString("title");
		}
		return value;
		
	}
	
	public static void updateEnroll(int id, int status) throws Exception {
		Connection con = DBconnection.connection();
		PreparedStatement pr = con.prepareStatement("update enrolls set status = ? where id=?");
		pr.setInt(1,status);
		pr.setInt(2,id);
		pr.executeUpdate();
		
	}
	
	public static ResultSet getCourse() throws Exception {
		Connection con = DBconnection.connection();
		PreparedStatement pr = con.prepareStatement("select *from courses");
		ResultSet rs = pr.executeQuery();		
		return rs;
	}
	
	public static ResultSet getEnroll() throws Exception {
		Connection con = DBconnection.connection();
		PreparedStatement pr = con.prepareStatement("select *from enrolls");
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
	
	public static  void StudentDataInsart(String name, String email, String password,String mobile, String gendar) throws  Exception  {
		
		PreparedStatement 	student = DBconnection.studentInsartDetail();
							student.setString(1, name);
							student.setString(2, mobile);
							student.setString(3, gendar);
							student.setString(4, email);
							student.setString(5, password);
							student.executeUpdate();
	}
}


