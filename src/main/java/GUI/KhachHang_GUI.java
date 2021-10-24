package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Font;
import javax.swing.JComboBox;

public class KhachHang_GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KhachHang_GUI frame = new KhachHang_GUI();
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
	public KhachHang_GUI() {
		setTitle("Khách hàng");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(0, 0, 1300, 700);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.Y_AXIS));
		
		Component verticalStrut_2 = Box.createVerticalStrut(35);
		panel_4.add(verticalStrut_2);
		
		JPanel panel_7 = new JPanel();
		panel_4.add(panel_7);
		
		JLabel lblNewLabel_1 = new JLabel("Thông tin khách hàng");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_7.add(lblNewLabel_1);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panel_4.add(verticalStrut_1);
		
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_5.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		panel_4.add(panel_5);
		
		JLabel lblNewLabel = new JLabel("Mã KH             ");
		lblNewLabel.setPreferredSize(new Dimension(100, 14));
		panel_5.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setPreferredSize(new Dimension(7, 30));
		panel_5.add(textField_1);
		textField_1.setColumns(20);
		
		JPanel panel_5_1 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_5_1.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		panel_4.add(panel_5_1);
		
		JLabel lblTnKh = new JLabel("Tên KH");
		lblTnKh.setPreferredSize(new Dimension(100, 14));
		panel_5_1.add(lblTnKh);
		
		textField_2 = new JTextField();
		textField_2.setPreferredSize(new Dimension(7, 30));
		textField_2.setColumns(20);
		panel_5_1.add(textField_2);
		
		JPanel panel_5_1_1 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_5_1_1.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panel_4.add(panel_5_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Email");
		lblNewLabel_1_1.setPreferredSize(new Dimension(100, 14));
		panel_5_1_1.add(lblNewLabel_1_1);
		
		textField_3 = new JTextField();
		textField_3.setPreferredSize(new Dimension(7, 30));
		textField_3.setColumns(20);
		panel_5_1_1.add(textField_3);
		
		JPanel panel_5_1_1_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_5_1_1_1.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_4.add(panel_5_1_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Số điện thoại");
		lblNewLabel_1_1_1.setPreferredSize(new Dimension(100, 14));
		panel_5_1_1_1.add(lblNewLabel_1_1_1);
		
		textField_4 = new JTextField();
		textField_4.setPreferredSize(new Dimension(7, 30));
		textField_4.setColumns(20);
		panel_5_1_1_1.add(textField_4);
		
		JPanel panel_5_1_1_1_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_5_1_1_1_1.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_4.add(panel_5_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Địa chỉ");
		lblNewLabel_1_1_1_1.setPreferredSize(new Dimension(100, 14));
		panel_5_1_1_1_1.add(lblNewLabel_1_1_1_1);
		
		textField_5 = new JTextField();
		textField_5.setPreferredSize(new Dimension(7, 30));
		textField_5.setColumns(20);
		panel_5_1_1_1_1.add(textField_5);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		panel_4.add(verticalStrut);
		
		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6);
		panel_6.setLayout(new GridLayout(2, 0, 5, 5));
		
		JButton btnNewButton_2 = new JButton("Thêm");
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setPreferredSize(new Dimension(70, 35));
		panel_6.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Sửa");
		btnNewButton_1.setBackground(Color.WHITE);
		panel_6.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("Xóa");
		btnNewButton_3.setBackground(Color.WHITE);
		panel_6.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Làm mới");
		btnNewButton_4.setBackground(Color.WHITE);
		panel_6.add(btnNewButton_4);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.NORTH);

		DefaultComboBoxModel cboLoaiTimKiem = new DefaultComboBoxModel<String>();
		JComboBox comboBox = new JComboBox(cboLoaiTimKiem);
		comboBox.setBackground(Color.WHITE);
		comboBox.setPreferredSize(new Dimension(100, 22));
		panel_2.add(comboBox);
		cboLoaiTimKiem.addElement((String) "Mã KH");
		cboLoaiTimKiem.addElement((String) "Tên KH");
		cboLoaiTimKiem.addElement((String) "Số điện thoại");
		
		
		textField = new JTextField();
		textField.setPreferredSize(new Dimension(7, 25));
		panel_2.add(textField);
		textField.setColumns(30);
		
		JButton btnNewButton = new JButton("Tìm kiếm");
		btnNewButton.setPreferredSize(new Dimension(100, 25));
		btnNewButton.setBackground(Color.WHITE);
		panel_2.add(btnNewButton);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		String[] cols_dskh = {"Mã khách hàng", "Tên khách hàng", "Số điện thoại", "Email", "Địa chỉ"};
		DefaultTableModel modelDSKH = new DefaultTableModel(cols_dskh, 0);
		table = new JTable(modelDSKH);
		JScrollPane scrollPane = new JScrollPane(table);
		panel_3.add(scrollPane);
		
		modelDSKH.addRow(new Object[]{"1", "Tran Van Nhan", "0987654321", "tranvannhan@gmail.com", "Thủ Đức, Hồ Chí Minh"});
		
		
	}

	public JPanel getContentPane() {
		 return this.contentPane;
	 }
}
