package Project360;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JCheckBox;
import javax.swing.JList;

public class EnrollCourses extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the frame.
	 */
	public EnrollCourses() {
		setTitle("Student Managment System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1040, 720);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1024, 681);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enroll Courses");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Raleway SemiBold", Font.BOLD, 35));
		lblNewLabel.setBounds(10, 69, 1004, 68);
		panel.add(lblNewLabel);
		
		  String trees[] = {"Maple", "Larch", "Spruce", "Balsam"};
		  String trees2[] = {"Maple", "Larch", "Spruce", "Balsam"};
		JList list = new JList(trees);
		list.setBounds(375, 307, 84, 166);
		panel.add(list);
		
		
		for(int i=0; i<=5; i++) {
			JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
			chckbxNewCheckBox.setBounds(209, 242, 97, 23);
			panel.add(chckbxNewCheckBox);
		}
		
		
		
	}
}
