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

public class CoursesInsert extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private int totalCourse=0, totalStudent =0;
	private JTextField titleTextField;
	private JTextField priceTextField;
	private JTextField crTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		if(Admin_Login.AdminLoginStatus == 0) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						CoursesInsert frame = new CoursesInsert();
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
	public CoursesInsert() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setTitle("Student Management System");
		setBounds(100, 100, 1040, 720);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel sidebarPanel = new JPanel();
		sidebarPanel.setBackground(new Color(0, 64, 128));
		sidebarPanel.setBounds(0, 0, 268, 681);
		contentPane.add(sidebarPanel);
		sidebarPanel.setLayout(null);
		
			JLabel title = new JLabel("Admin Dashboard");
			title.setForeground(new Color(255, 255, 255));
			title.setHorizontalAlignment(SwingConstants.CENTER);
			title.setFont(new Font("Montserrat", Font.BOLD, 22));
			title.setBounds(26, 33, 210, 34);
			sidebarPanel.add(title);
			
			JButton homeButton = new JButton("Home");
			homeButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					Dashboard.main(null);
				}
			});
			homeButton.setBounds(40, 99, 187, 23);
			sidebarPanel.add(homeButton);
			
			JButton registationBtn = new JButton("Student Registation");
			registationBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Registation.main(null);
					setVisible(false);
				}
			});
			registationBtn.setBounds(40, 145, 187, 23);
			sidebarPanel.add(registationBtn);
			
			JButton CourseAddBtn = new JButton("New Course Add");
			CourseAddBtn.setBounds(40, 194, 187, 23);
			sidebarPanel.add(CourseAddBtn);
			
			JButton btnLogout = new JButton("Logout");
			btnLogout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Admin_Login.main(null);
					setVisible(false);
				}
			});
			btnLogout.setBounds(40, 242, 187, 23);
			sidebarPanel.add(btnLogout);
			
			
			
			
			
			
		JPanel CoursesPanel = new JPanel();
		CoursesPanel.setBounds(268, 0, 756, 681);
		contentPane.add(CoursesPanel);
		CoursesPanel.setLayout(null);
		
			JLabel lblTitle = new JLabel("Courses Insart");
			lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitle.setFont(new Font("Kalpurush", Font.BOLD, 20));
			lblTitle.setBounds(240, 121, 283, 25);
			CoursesPanel.add(lblTitle);
			
			JLabel inputTitle = new JLabel("Title");
			inputTitle.setFont(new Font("Maiandra GD", Font.BOLD, 16));
			inputTitle.setBounds(182, 183, 98, 27);
			CoursesPanel.add(inputTitle);
			
			titleTextField = new JTextField();
			titleTextField.setColumns(10);
			titleTextField.setBounds(305, 183, 254, 27);
			CoursesPanel.add(titleTextField);
			
			JLabel inputPrice = new JLabel("Price");
			inputPrice.setFont(new Font("Maiandra GD", Font.BOLD, 16));
			inputPrice.setBounds(182, 233, 98, 27);
			CoursesPanel.add(inputPrice);
			
			priceTextField = new JTextField();
			priceTextField.setColumns(10);
			priceTextField.setBounds(305, 233, 254, 27);
			CoursesPanel.add(priceTextField);
			
			
			
			JLabel inputCreditHours = new JLabel("Credit Hours");
			inputCreditHours.setFont(new Font("Maiandra GD", Font.BOLD, 16));
			inputCreditHours.setBounds(182, 285, 98, 27);
			CoursesPanel.add(inputCreditHours);
			
			crTextField = new JTextField();
			crTextField.setColumns(10);
			crTextField.setBounds(305, 285, 254, 27);
			CoursesPanel.add(crTextField);
			
			JButton coursesSubmit = new JButton("Submit");
			coursesSubmit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						String name = titleTextField.getText();
						int price = Integer.parseInt(priceTextField.getText());
						int credit_hours = Integer.parseInt(crTextField.getText());
						courseDataInsart(name, price,credit_hours);
						
						Dashboard.main(null);
						setVisible(false);
						
						JOptionPane.showMessageDialog(rootPane, "Course Create Success");
					}
					catch(Exception e1){
						e1.printStackTrace();
					}
					
				}
			});
			coursesSubmit.setFont(new Font("Maiandra GD", Font.BOLD, 16));
			coursesSubmit.setBounds(460, 337, 98, 27);
			CoursesPanel.add(coursesSubmit);
			
			
			
			JPanel coursesCourseListPanel = new JPanel();
			coursesCourseListPanel.setBounds(65, 394, 634, 243);
			CoursesPanel.add(coursesCourseListPanel);
			coursesCourseListPanel.setLayout(null);
			coursesCourseListPanel.setBackground(new Color(49, 186, 215));
			
				JLabel courseCourseListTitle = new JLabel("Course List");
				courseCourseListTitle.setHorizontalAlignment(SwingConstants.CENTER);
				courseCourseListTitle.setForeground(Color.WHITE);
				courseCourseListTitle.setFont(new Font("Raleway SemiBold", Font.PLAIN, 25));
				courseCourseListTitle.setBounds(10, 0, 614, 44);
				coursesCourseListPanel.add(courseCourseListTitle);
				
				JScrollPane courseCourseListScrollPane = new JScrollPane();
				courseCourseListScrollPane.setBounds(10, 51, 614, 181);
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
			
		
	}
	

	public static ResultSet getCourse() throws Exception {
		Connection con = DBconnection.connection();
		PreparedStatement pr = con.prepareStatement("select *from courses");
		ResultSet rs = pr.executeQuery();		
		return rs;
	}

	public static void courseDataInsart(String name,int price,int credit_hours) throws Exception {
		
		PreparedStatement course = DBconnection.courseInsert();
						  course.setString(1, name);
						  course.setInt(2, price);
						  course.setInt(3, credit_hours);
						  course.executeUpdate();
	}

}
