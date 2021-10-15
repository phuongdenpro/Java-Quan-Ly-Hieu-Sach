package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Register_GUI extends JFrame {
	private JPanel contentPane;
	private JTextField txtUserName;
	private JTextField textPassword;
	public JButton btnDangKy;
	public JButton btnDangNhap;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register_GUI frame = new Register_GUI();
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
	public Register_GUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(0, 0, 1000, 600);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width, screenSize.height);
		contentPane = new JPanel() {  
			public void paintComponent(Graphics g) {  
				Image img = Toolkit.getDefaultToolkit().getImage(  
						Login_GUI.class.getResource("/images/bg3.jpg"));  
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
            }  
		};
		
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(438, 197, 479, 276);
		panel.setBackground(new Color(0, 0, 0, 150));
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JLabel lblDangKy = new JLabel("\u0110\u0103ng K\u00FD");
		lblDangKy.setBounds(166, 11, 155, 49);
		panel.add(lblDangKy);
		lblDangKy.setForeground(new Color(0, 206, 209));
		lblDangKy.setBackground(new Color(255, 255, 255));
		lblDangKy.setFont(new Font("Tahoma", Font.PLAIN, 40));
		
		txtUserName = new JTextField();
		txtUserName.setBounds(41, 77, 398, 41);
		panel.add(txtUserName);
		txtUserName.setColumns(10);
		
		textPassword = new JPasswordField();
		textPassword.setBounds(41, 129, 398, 41);
		panel.add(textPassword);
		textPassword.setColumns(10);
		
		btnDangKy = new JButton("\u0110\u0103ng k\u00FD");
		btnDangKy.setBounds(103, 181, 130, 41);
		panel.add(btnDangKy);
		btnDangKy.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDangNhap.setBounds(260, 181, 130, 41);
		panel.add(btnDangNhap);
	}
	
	public JPanel getContentPane() {
		return this.contentPane;
	}
}
