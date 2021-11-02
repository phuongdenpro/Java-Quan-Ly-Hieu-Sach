package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

public class TimKiemSanPhamKhac_GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextComponent lblTimKiem;
	private JTextField textFieldTim;
	private JLabel lbltieude;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimKiemSanPhamKhac_GUI frame = new TimKiemSanPhamKhac_GUI();
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
	public TimKiemSanPhamKhac_GUI() {
		setResizable(false);
		setTitle("Tìm kiếm sản phẩm khác");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(0, 0, 1300, 700);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		ImageIcon icon1 = new ImageIcon("data/images/timkiem.png");
		ImageIcon icon2 = new ImageIcon("data/images/search_16.png");
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 80));
		contentPane.add(panel, BorderLayout.NORTH);
panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel pannel_2 = new JPanel();
		lbltieude = new JLabel("TÌM KIẾM SẢN PHẨM");
		lbltieude.setFont(new Font("Tahoma", Font.BOLD, 20));
		pannel_2.add(lbltieude);
		JPanel panel_1 = new JPanel();
		panel.add(pannel_2);
		panel.add(panel_1);
		
		JLabel lblTimKiem = new JLabel();
		lblTimKiem.setText("Search: ");
		lblTimKiem.setIcon(icon1);
		panel_1.add(lblTimKiem);
		
		textFieldTim = new JTextField();
		panel_1.add(textFieldTim);
		textFieldTim.setColumns(25);
		
		JRadioButton rdbtnMaSanPham = new JRadioButton("Mã sản phẩm");
		panel_1.add(rdbtnMaSanPham);
		
		JRadioButton rdbtnTenSanPham = new JRadioButton("Tên sản phẩm");
		panel_1.add(rdbtnTenSanPham);
		
		JRadioButton rdbtnLoaiSanPham = new JRadioButton("Loại sản phẩm");
		panel_1.add(rdbtnLoaiSanPham);
		
		
		ButtonGroup rdbtnGroup = new ButtonGroup();
		rdbtnGroup.add(rdbtnMaSanPham);
		rdbtnGroup.add(rdbtnTenSanPham);
		rdbtnGroup.add(rdbtnLoaiSanPham);
	
		
		rdbtnMaSanPham.setSelected(true);
		JButton btnNewButton = new JButton("Tìm kiếm");
		btnNewButton.setIcon(icon2);
		btnNewButton.setBackground(Color.WHITE);
		panel_1.add(btnNewButton);
		
		JButton btnLamMoiDuLieu = new JButton("Làm mới dữ liệu");
		btnLamMoiDuLieu.setPreferredSize(new Dimension(150, 25));
		btnLamMoiDuLieu.setBackground(Color.WHITE);
		btnLamMoiDuLieu.setIcon(new ImageIcon("data\\images\\refresh.png"));
		panel_1.add(btnLamMoiDuLieu);
		
		String[] cols = {"Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Giá nhập", "Giá bán", "Loại sản phẩm"};
		DefaultTableModel modelDSSanPham = new DefaultTableModel(cols, 0);
		JTable tblDSSanPham = new JTable(modelDSSanPham);
		JScrollPane scrollPane = new JScrollPane(tblDSSanPham);
		contentPane.add(scrollPane, BorderLayout.CENTER);
	}

}
