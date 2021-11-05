package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Color;

public class TimKiem_GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimKiem_GUI frame = new TimKiem_GUI();
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
	public TimKiem_GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1300, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		
		JPanel panel_8 = new JPanel();
		panel_2.add(panel_8);
		
		JLabel lblNewLabel_4 = new JLabel("Thông tin tìm kiếm");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_8.add(lblNewLabel_4);
		
		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_7.getLayout();
		flowLayout_2.setAlignment(FlowLayout.RIGHT);
		panel_2.add(panel_7);
		
		JLabel lblNewLabel_3 = new JLabel("Tìm kiếm chính xác");
		panel_7.add(lblNewLabel_3);
		
		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_6.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_2.add(panel_6);
		
		JLabel lblNewLabel_2 = new JLabel("Loại sách");
		lblNewLabel_2.setPreferredSize(new Dimension(100, 14));
		panel_6.add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setPreferredSize(new Dimension(222, 22));
		panel_6.add(comboBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("");
		panel_6.add(chckbxNewCheckBox_1);
		
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_5.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_2.add(panel_5);
		
		JLabel lblNewLabel_1 = new JLabel("Mã sách");
		lblNewLabel_1.setPreferredSize(new Dimension(100, 14));
		panel_5.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setPreferredSize(new Dimension(200, 20));
		panel_5.add(textField);
		textField.setColumns(20);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		panel_5.add(chckbxNewCheckBox);
		
		JPanel panel_5_1 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_5_1.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		panel_2.add(panel_5_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tiêu đề");
		lblNewLabel_1_1.setPreferredSize(new Dimension(100, 14));
		panel_5_1.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setPreferredSize(new Dimension(200, 20));
		textField_1.setColumns(20);
		panel_5_1.add(textField_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("");
		panel_5_1.add(chckbxNewCheckBox_2);
		
		JPanel panel_5_1_1 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_5_1_1.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		panel_2.add(panel_5_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Nhà xuất bản");
		lblNewLabel_1_1_1.setPreferredSize(new Dimension(100, 14));
		panel_5_1_1.add(lblNewLabel_1_1_1);
		
		textField_2 = new JTextField();
		textField_2.setPreferredSize(new Dimension(200, 20));
		textField_2.setColumns(20);
		panel_5_1_1.add(textField_2);
		
		JCheckBox chckbxNewCheckBox_2_1 = new JCheckBox("");
		panel_5_1_1.add(chckbxNewCheckBox_2_1);
		
		JPanel panel_9 = new JPanel();
		panel_2.add(panel_9);
		
		JButton btnNewButton = new JButton("Tìm kiếm");
		btnNewButton.setBackground(Color.WHITE);
		panel_9.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Tìm kiếm sách");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel_3.add(lblNewLabel);
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);
		
		String[] cols = {"Mã sách", "Tên sách", "Nhà xuất bản", "Đơn giá", "Số lượng"};
		DefaultTableModel modelKq = new DefaultTableModel(cols, 0);
		panel_4.setLayout(new BorderLayout(0, 0));
		JTable tblKetQua = new JTable(modelKq);
		JScrollPane scrollPane = new JScrollPane(tblKetQua);
		panel_4.add(scrollPane);
	}

}
