package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.FlowLayout;

public class TrangChaoMung_GUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrangChaoMung_GUI frame = new TrangChaoMung_GUI();
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
	public TrangChaoMung_GUI() {
		setTitle("Trang quản lý");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(0, 0, 1300, 700);
		
		contentPane = new TrangChu_GUI().panelBackgroundImage("/images/bg2.jpg");
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnThoat = new JButton("Thoát chương trình");
		btnThoat.setBounds(613, 270, 152, 37);
//		btnNewButton.setIcon(new ImageIcon("/data/images/shut-down.png"));
//		btnNewButton.setForeground(new Color(0, 191, 255));
		btnThoat.setBackground(Color.WHITE);
		contentPane.add(btnThoat);
		
		btnThoat.addActionListener((e) -> {
			System.exit(0);
		});
	}
	
	public JPanel getContentPane() {
		return this.contentPane;
	}
}
