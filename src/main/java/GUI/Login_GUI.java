package GUI;
import java.awt.Graphics;  
import java.awt.Image;  
import java.awt.Toolkit;  
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class Login_GUI extends JFrame {

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
					Login_GUI frame = new Login_GUI();
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
	public Login_GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = TrangChu_GUI.panelBackgroundImage("/images/bg3.jpg");
//		new JPanel() {  
//			public void paintComponent(Graphics g) {  
//				Image img = Toolkit.getDefaultToolkit().getImage(  
//						Login_GUI.class.getResource("/images/bg3.jpg"));  
//				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
//            }  
//		};
		
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(249, 126, 479, 276);
		panel.setBackground(new Color(0, 0, 0, 150));
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JLabel lblDangNhap = new JLabel("\u0110\u0103ng Nh\u1EADp");
		lblDangNhap.setBounds(144, 11, 198, 49);
		panel.add(lblDangNhap);
		lblDangNhap.setForeground(new Color(0, 206, 209));
		lblDangNhap.setBackground(new Color(255, 255, 255));
		lblDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 40));
		
		txtUserName = new JTextField();
		txtUserName.setBounds(41, 77, 398, 41);
		panel.add(txtUserName);
		txtUserName.setColumns(10);
		
		textPassword = new JTextField();
		textPassword.setBounds(41, 129, 398, 41);
		panel.add(textPassword);
		textPassword.setColumns(10);
		
		JCheckBox chckbxLaNhanVien = new JCheckBox("L\u00E0 nh\u00E2n vi\u00EAn");
		chckbxLaNhanVien.setForeground(new Color(255, 255, 255));
		chckbxLaNhanVien.setBackground(new Color(105, 105, 105));
		chckbxLaNhanVien.setBounds(41, 183, 97, 23);
		panel.add(chckbxLaNhanVien);
		
		JLabel lblChuaCoTaiKhoan = new JLabel("Ch\u01B0a c\u00F3 t\u00E0i kho\u1EA3n ?");
		lblChuaCoTaiKhoan.setForeground(new Color(255, 255, 255));
		lblChuaCoTaiKhoan.setBounds(238, 187, 117, 14);
		panel.add(lblChuaCoTaiKhoan);
		
		JLabel lblDangKyNgay = new JLabel(" \u0110\u0103ng k\u00FD ngay");
		lblDangKyNgay.setBounds(351, 187, 88, 14);
		panel.add(lblDangKyNgay);
		lblDangKyNgay.setForeground(new Color(0, 191, 255));
		
		JButton btnDangNhap = new JButton("\u0110\u0103ng nh\u1EADp");
		btnDangNhap.setBounds(180, 212, 130, 41);
		panel.add(btnDangNhap);
		btnDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 16));
	}
	
	
}
