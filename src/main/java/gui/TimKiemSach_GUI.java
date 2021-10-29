package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

public class TimKiemSach_GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimKiemSach_GUI frame = new TimKiemSach_GUI();
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
	public TimKiemSach_GUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(0, 0, 1300, 700);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 50));
		contentPane.add(panel, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(25);
		
		JRadioButton rdbtnMaSach = new JRadioButton("Mã sách");
		panel_1.add(rdbtnMaSach);
		
		JRadioButton rdbtnTenSach = new JRadioButton("Tên sách");
		panel_1.add(rdbtnTenSach);
		
		JRadioButton rdbtnNXB = new JRadioButton("Nhà xuất bản");
		panel_1.add(rdbtnNXB);
		
		JButton btnNewButton = new JButton("Tìm kiếm");
		btnNewButton.setBackground(Color.WHITE);
		panel_1.add(btnNewButton);
		
		String[] cols = {"Mã sách", "Tên sách", "Nhà xuất bản", "Đơn giá", "Số lượng"};
		DefaultTableModel modelDSSach = new DefaultTableModel(cols, 0);
		JTable tblDSSach = new JTable(modelDSSach);
		JScrollPane scrollPane = new JScrollPane(tblDSSach);
		contentPane.add(scrollPane, BorderLayout.CENTER);
	}

}
