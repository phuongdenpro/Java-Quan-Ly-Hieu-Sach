package GUI;
import java.awt.Graphics;  
import java.awt.Image;  
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.border.LineBorder;

public class DangKy_GUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtUserName;
	private JPasswordField textPassword;
	public JButton btnDangKy;
	public JButton btnDangNhap;
	private JPasswordField textRePassword;
	private JCheckBox chckbxNewCheckBox;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangKy_GUI frame = new DangKy_GUI();
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
	public DangKy_GUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLocationRelativeTo(null);
		setBounds(0, 0, 1300, 700);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width, screenSize.height);
		
		contentPane = 
//				new JPanel(); 
				TrangChu_GUI.panelBackgroundImage("/images/bg3.jpg");
		
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(424, 176, 479, 323);
		panel.setBackground(new Color(0, 0, 0, 150));
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JLabel lblDangKy = new JLabel("Đăng ký");
		lblDangKy.setBounds(159, 11, 159, 49);
		panel.add(lblDangKy);
		lblDangKy.setForeground(new Color(0, 206, 209));
		lblDangKy.setBackground(new Color(255, 255, 255));
		lblDangKy.setFont(new Font("Tahoma", Font.PLAIN, 40));
		
		txtUserName = new JTextField("Tài khoản");
		txtUserName.setBorder(new LineBorder(new Color(171, 173, 179)));
		txtUserName.setBounds(41, 77, 398, 41);
		panel.add(txtUserName);
		txtUserName.setColumns(10);
		txtUserName.setForeground(Color.GRAY);
		txtUserName.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        if (txtUserName.getText().equals("Tài khoản")) {
		        	txtUserName.setText("");
		        	txtUserName.setForeground(Color.BLACK);
		        }
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (txtUserName.getText().isEmpty()) {
		        	txtUserName.setForeground(Color.GRAY);
		        	txtUserName.setText("Tài khoản");
		        }
		    }
	    });
		
		textPassword = new JPasswordField("Mật khẩu");
		textPassword.setBorder(new LineBorder(new Color(171, 173, 179)));
		textPassword.setEchoChar((char)0);
		textPassword.setBounds(41, 129, 398, 41);
		panel.add(textPassword);
		textPassword.setColumns(10);
		textPassword.setForeground(Color.GRAY);
		textPassword.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        if (textPassword.getText().equals("Mật khẩu")) {
		        	textPassword.setText("");
		        	textPassword.setEchoChar('*');
		        	textPassword.setForeground(Color.BLACK);
		        }
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (textPassword.getText().isEmpty()) {
		        	textPassword.setForeground(Color.GRAY);
		        	textPassword.setEchoChar((char)0);
		        	textPassword.setText("Mật khẩu");
		        }
		    }
	    });
		
		textRePassword = new JPasswordField("Nhập lại mật khẩu");
		textRePassword.setBorder(new LineBorder(new Color(171, 173, 179)));
		textRePassword.setEchoChar((char)0);
		textRePassword.setBounds(41, 181, 398, 41);
		panel.add(textRePassword);
		textRePassword.setColumns(10);
		textRePassword.setForeground(Color.GRAY);
		textRePassword.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        if (textRePassword.getText().equals("Nhập lại mật khẩu")) {
		        	textRePassword.setText("");
		        	textRePassword.setEchoChar('*');
		        	textRePassword.setForeground(Color.BLACK);
		        }
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (textRePassword.getText().isEmpty()) {
		        	textRePassword.setForeground(Color.GRAY);
		        	textRePassword.setEchoChar((char)0);
		        	textRePassword.setText("Nhập lại mật khẩu");
		        }
		    }
	    });
		
		btnDangKy = new JButton("Đăng ký");
		btnDangKy.setBackground(Color.WHITE);
		btnDangKy.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDangKy.setBounds(105, 259, 130, 41);
		panel.add(btnDangKy);
		
		btnDangNhap = new JButton("\u0110\u0103ng nh\u1EADp");
		btnDangNhap.setBackground(Color.WHITE);
		btnDangNhap.setBounds(261, 259, 130, 41);
		panel.add(btnDangNhap);
		btnDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		chckbxNewCheckBox = new JCheckBox("Hiển thị mật khẩu");
		chckbxNewCheckBox.setBounds(300, 229, 139, 23);
		panel.add(chckbxNewCheckBox);


	}
	
	public JPanel getContentPane() {
		return this.contentPane;
	}
	
	public void requestFocus() {
		this.txtUserName.requestFocus();
	}
}
