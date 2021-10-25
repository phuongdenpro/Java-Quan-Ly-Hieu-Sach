package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class TaoTaiKhoan_GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaoTaiKhoan_GUI frame = new TaoTaiKhoan_GUI();
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
	public TaoTaiKhoan_GUI() {
		setTitle("Tạo tài khoản");
		setResizable(false);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(0, 0, 400, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Tạo tài khoản nhân viên");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblNewLabel_1 = new JLabel("Họ tên NV");
		lblNewLabel_1.setPreferredSize(new Dimension(100, 14));
		panel_2.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setPreferredSize(new Dimension(7, 25));
		panel_2.add(textField);
		textField.setColumns(20);
		
		JPanel panel_2_2 = new JPanel();
		panel.add(panel_2_2);
		panel_2_2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblNewLabel_1_2 = new JLabel("Số điện thoại");
		lblNewLabel_1_2.setPreferredSize(new Dimension(100, 14));
		panel_2_2.add(lblNewLabel_1_2);
		
		textField_3 = new JTextField();
		textField_3.setPreferredSize(new Dimension(7, 25));
		textField_3.setColumns(20);
		panel_2_2.add(textField_3);
		
		JPanel panel_2_1 = new JPanel();
		panel.add(panel_2_1);
		panel_2_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên tài khoản");
		lblNewLabel_1_1.setPreferredSize(new Dimension(100, 14));
		panel_2_1.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setPreferredSize(new Dimension(7, 25));
		textField_1.setColumns(20);
		panel_2_1.add(textField_1);
		
		JPanel panel_2_1_1 = new JPanel();
		panel.add(panel_2_1_1);
		panel_2_1_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Mật khẩu");
		lblNewLabel_1_1_1.setPreferredSize(new Dimension(100, 14));
		panel_2_1_1.add(lblNewLabel_1_1_1);
		
		textField_2 = new JTextField();
		textField_2.setPreferredSize(new Dimension(7, 25));
		textField_2.setColumns(20);
		panel_2_1_1.add(textField_2);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		
		JButton btnToTiKhon = new JButton("Tạo tài khoản");
		btnToTiKhon.setPreferredSize(new Dimension(150, 30));
		btnToTiKhon.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnToTiKhon.setBackground(new Color(0, 250, 154));
		panel_3.add(btnToTiKhon);
		
		JButton btnNewButton = new JButton("Hủy");
		btnNewButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnNewButton.setPreferredSize(new Dimension(70, 30));
		btnNewButton.setBackground(new Color(255, 99, 71));
		panel_3.add(btnNewButton);
	}

	public JPanel getContentPane() {
		 return this.contentPane;
	 }
}
