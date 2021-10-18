package GUI;
import java.awt.Graphics;  
import java.awt.Image;  
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
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
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

public class DangNhap_GUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtUserName;
	private JPasswordField textPassword;
	public JButton btnDangNhap;
	public JButton btnDangKy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangNhap_GUI frame = new DangNhap_GUI();
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
	public DangNhap_GUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLocationRelativeTo(null);
		setBounds(0, 0, 1300, 700);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width, screenSize.height);
		
		contentPane = 
//				new JPanel(); 
				TrangChu_GUI.panelBackgroundImage("/images/bg3.jpg");
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
		panel.setBounds(424, 176, 479, 282);
		panel.setBackground(new Color(0, 0, 0, 150));
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JLabel lblDangNhap = new JLabel("\u0110\u0103ng Nh\u1EADp");
		lblDangNhap.setBounds(144, 11, 198, 49);
		panel.add(lblDangNhap);
		lblDangNhap.setForeground(new Color(0, 206, 209));
		lblDangNhap.setBackground(new Color(255, 255, 255));
		lblDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 40));
		
		txtUserName = new JTextField("Tài khoản");
		txtUserName.setBorder(new LineBorder(Color.LIGHT_GRAY));
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
		textPassword.setBorder(new LineBorder(Color.LIGHT_GRAY));
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
		
		btnDangNhap = new JButton("\u0110\u0103ng nh\u1EADp");
		btnDangNhap.setBackground(Color.WHITE);
		btnDangNhap.setBounds(104, 215, 130, 41);
		panel.add(btnDangNhap);
		btnDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		btnDangKy = new JButton("Đăng ký");
		btnDangKy.setBackground(Color.WHITE);
		btnDangKy.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDangKy.setBounds(259, 215, 130, 41);
		panel.add(btnDangKy);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Hiển thị mật khẩu");
		chckbxNewCheckBox.setBounds(315, 177, 124, 23);
		panel.add(chckbxNewCheckBox);
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(txtUserName.getText());
//				contentPane = new TrangChu_GUI().getContentPane();
			}
		});
	}
	
	public JPanel getContentPane() {
		return this.contentPane;
	}
	
	public void requestFocus() {
		this.txtUserName.requestFocus();
	}
}
