package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

import dao.SanPhamDAO;
import entity.SanPham;

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

public class TimKiemSach_GUI extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private JTextField textField;
	private JTextComponent lblTimKiem;
	private JTextField textFieldTim;
	private ArrayList<SanPham> dssach;
	private DefaultTableModel modelDSSach;
	private BoxLayout boxLayout;
	private JLabel lbltieude;
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
		setTitle("Tìm kiếm sách");
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
		lbltieude = new JLabel("TÌM KIẾM SÁCH");
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
		
		JRadioButton rdbtnMaSach = new JRadioButton("Mã sách");
		panel_1.add(rdbtnMaSach);
		
		JRadioButton rdbtnTenSach = new JRadioButton("Tên sách");
		panel_1.add(rdbtnTenSach);
		
		JRadioButton rdbtnNXB = new JRadioButton("Nhà xuất bản");
		panel_1.add(rdbtnNXB);
		
		JRadioButton rdbtnLoai = new JRadioButton("Loại sách");
		panel_1.add(rdbtnLoai);
		
		ButtonGroup rdbtnGroup = new ButtonGroup();
		rdbtnGroup.add(rdbtnMaSach);
		rdbtnGroup.add(rdbtnTenSach);
		rdbtnGroup.add(rdbtnNXB);
		rdbtnGroup.add(rdbtnLoai);
		
		rdbtnMaSach.setSelected(true);
		JButton btnNewButton = new JButton("Tìm kiếm");
		btnNewButton.setIcon(icon2);
		btnNewButton.setBackground(Color.WHITE);
		panel_1.add(btnNewButton);
		JButton btnLamMoiDuLieu = new JButton("Làm mới dữ liệu");
		btnLamMoiDuLieu.setPreferredSize(new Dimension(150, 25));
		btnLamMoiDuLieu.setBackground(Color.WHITE);
		btnLamMoiDuLieu.setIcon(new ImageIcon("data\\images\\refresh.png"));
		panel_1.add(btnLamMoiDuLieu);
		
		String[] cols = {"Mã sách", "Tên sách", "Nhà xuất bản", "Số lượng", "Giá nhập", "Giá bán", "Loại Sách"};
	
		modelDSSach = new DefaultTableModel(cols, 0) {
			// khóa không cho người dùng nhập trên table
			@Override
			public boolean isCellEditable(int i, int i1) {
				return false;
			}
		};
		JTable tblDSSach = new JTable(modelDSSach);
		JScrollPane scrollPane = new JScrollPane(tblDSSach);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		try {
			renderData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btnNewButton.addActionListener(this);
		tblDSSach.addMouseListener(this);
	}
	
	public void renderData() throws SQLException {
		//modelDSSach.getDataVector().removeAllElements();
		dssach = new SanPhamDAO().getListSach();
		
		dssach.forEach(sach -> {		
			modelDSSach.addRow(new Object[] {
					sach.getMaSp(), 
					sach.getTenSp(), 
					sach.getNhaCungCap().getTenNCC(), 
					sach.getSoLuong(),
					sach.getGiaNhap(),
					sach.getGiaSp(), 
					sach.getLoaiSanPham().getTenLoai()});
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

