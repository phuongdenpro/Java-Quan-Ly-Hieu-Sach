package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Register_GUI extends JFrame {
	private JPanel contentPane;
	private JTextField txtUserName;
	private JTextField textPassword;


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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
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
		panel.setBounds(249, 126, 479, 276);
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
		
		textPassword = new JTextField();
		textPassword.setBounds(41, 129, 398, 41);
		panel.add(textPassword);
		textPassword.setColumns(10);
		
		JLabel lblCoTaiKhoan = new JLabel("\u0110\u00E3 c\u00F3 t\u00E0i kho\u1EA3n ?");
		lblCoTaiKhoan.setForeground(new Color(255, 255, 255));
		lblCoTaiKhoan.setBounds(238, 187, 117, 14);
		panel.add(lblCoTaiKhoan);
		
		JLabel lblDangNhapNgay = new JLabel(" \u0110\u0103ng nh\u1EADp ngay");
		lblDangNhapNgay.setBounds(335, 187, 104, 14);
		panel.add(lblDangNhapNgay);
		lblDangNhapNgay.setForeground(new Color(0, 191, 255));
		
		JButton btnDangKy = new JButton("\u0110\u0103ng k\u00FD");
		btnDangKy.setBounds(180, 212, 130, 41);
		panel.add(btnDangKy);
		btnDangKy.setFont(new Font("Tahoma", Font.PLAIN, 16));
	}

}
