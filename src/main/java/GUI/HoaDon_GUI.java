package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;


import entity.KhachHang;

import javax.swing.border.EtchedBorder;

public class HoaDon_GUI extends JFrame implements ActionListener, MouseListener {
	private DefaultTableModel modelHD, modelDV;
	String[] colsHD = { "Mã hoá đơn", "Mã khách hàng", "Ngày lập", "Tổng tiền", "Tình trạng" };
	String[] colsDV = { "Mã hóa đơn", "Mã khách hàng","Mã sản phẩm", "Số lượng", "Đơn giá", "Thời gian đặt"};
	public JPanel pnMain;
	private JTable tableHDDV;
	private JTable tableDV;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JTextField txtSoLuong;
	private JButton btnThem, btnXacNhan;
	private JComboBox<String> cboMaKH;
	private JComboBox<String> cboDV;
	private JPanel panel;
	private JPanel panel_1;
	private JTextField txtTimMaHDDV;

	
	private JTextField txtGia;
	private JTextField txtTen;
	
//	private JButton btnSua;
	private JButton btnTimMaHDDV;
	private JButton btnXem;
	private JButton btnBoChon;
	private JTextField txtTenSP;
	private JButton btnXoa;
	private JButton btnHuy;

	public HoaDon_GUI() {
		

		setTitle("Quản lý hóa đơn");
		setSize(1000, 670);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		pnMain = new JPanel();
		pnMain.setBounds(0, 0, 584, 411);
		setContentPane(pnMain);

		JLabel lbTitle = new JLabel("Hoá Đơn Thanh Toán");
		lbTitle.setBounds(335, 11, 348, 30);
		lbTitle.setFont(new Font("Tahoma", Font.BOLD, 25));
		pnMain.add(lbTitle);

		modelHD = new DefaultTableModel(colsHD, 0) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int i, int i1) {
				return false;
				// Không cho chỉnh sửa trên table
			}
		};

		modelDV = new DefaultTableModel(colsDV, 0) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int i, int i1) {
				return false;
				// Không cho chỉnh sửa trên table
			}
		};
		pnMain.setLayout(null);

		JPanel pn = new JPanel();
		pn.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Chi tiết", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pn.setBounds(10, 65, 342, 360);
		pnMain.add(pn);
		pn.setLayout(null);

		JLabel lbMaKH = new JLabel("Mã khách hàng:");
		lbMaKH.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbMaKH.setBounds(10, 22, 93, 22);
		pn.add(lbMaKH);

		cboMaKH = new JComboBox<String>();
		cboMaKH.setFont(new Font("Tahoma", Font.PLAIN, 11));
		cboMaKH.setBounds(122, 22, 205, 22);
		cboMaKH.addItem("");
		pn.add(cboMaKH);

		JLabel lbTen = new JLabel("Tên khách hàng");
		lbTen.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbTen.setBounds(10, 55, 93, 22);
		pn.add(lbTen);

		txtTen = new JTextField();
		txtTen.setEditable(false);
		txtTen.setColumns(10);
		txtTen.setBounds(122, 55, 205, 22);
		pn.add(txtTen);
		
		JLabel lbMaSP = new JLabel("Mã sản phẩm:");
		lbMaSP.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbMaSP.setBounds(10, 88, 93, 22);
		pn.add(lbMaSP);

		cboDV = new JComboBox<String>();
		cboDV.setFont(new Font("Tahoma", Font.PLAIN, 11));
		cboDV.setBounds(122, 88, 205, 22);
		cboDV.addItem("");
		pn.add(cboDV);
		JLabel lbts = new JLabel("Tên sản phẩm:");
		lbts.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbts.setBounds(10, 121, 93, 22);
		pn.add(lbts);
		txtTenSP = new JTextField();
		txtTenSP.setEditable(false);
		txtTenSP.setColumns(10);
		txtTenSP.setBounds(122, 121, 205, 22);
		pn.add(txtTenSP);
		
		JLabel lbGia = new JLabel("Đơn giá:");
		lbGia.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbGia.setBounds(10, 154, 93, 22);
		pn.add(lbGia);

		txtGia = new JTextField();
		txtGia.setEditable(false);
		txtGia.setBounds(122, 154, 205, 22);
		pn.add(txtGia);
		txtGia.setColumns(10);

		JLabel lbSoLuong = new JLabel("Số lượng:");
		lbSoLuong.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbSoLuong.setBounds(10, 187, 93, 22);
		pn.add(lbSoLuong);

		txtSoLuong = new JTextField();
		txtSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtSoLuong.setBounds(122, 187, 205, 22);
		pn.add(txtSoLuong);
		txtSoLuong.setColumns(10);

		btnThem = new JButton("Thêm đơn");
		btnThem.setIcon(new ImageIcon("data/images/blueAdd_16.png"));
		btnThem.setBounds(10, 233, 317, 33);
		pn.add(btnThem);

		btnHuy = new JButton("Hủy đơn");
		btnHuy.setIcon(new ImageIcon("data/images/cancel_16.png"));
		btnHuy.setBounds(10, 272, 317, 33);
		pn.add(btnHuy);

		btnXacNhan = new JButton("Tạo hoá đơn");
		btnXacNhan.setBounds(10, 311, 317, 33);
		pn.add(btnXacNhan);
		btnXacNhan.setIcon(new ImageIcon("data/images/check.png"));

		

		panel = new JPanel();
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Đơn khách hàng đã đặt", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(362, 64, 614, 251);
		pnMain.add(panel);
		panel.setLayout(null);

		tableDV = new JTable(modelDV);
		JScrollPane scDV = new JScrollPane(tableDV, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scDV.setBounds(10, 29, 594, 211);
		tableDV.getColumnModel().getColumn(1).setPreferredWidth(105);
		panel.add(scDV);

		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Danh sách hóa đơn", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_1.setBounds(362, 326, 614, 307);
		pnMain.add(panel_1);
		panel_1.setLayout(null);

		tableHDDV = new JTable(modelHD);
		JScrollPane scHD = new JScrollPane(tableHDDV, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scHD.setBounds(10, 57, 594, 239);
		panel_1.add(scHD);

		JLabel lbTimMaHDDV = new JLabel("Mã hoá đơn:");
		lbTimMaHDDV.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbTimMaHDDV.setBounds(10, 25, 110, 30);
		panel_1.add(lbTimMaHDDV);

		txtTimMaHDDV = new JTextField();
		txtTimMaHDDV.setBounds(90, 29, 110, 23);
		panel_1.add(txtTimMaHDDV);
		txtTimMaHDDV.setColumns(10);

		btnTimMaHDDV = new JButton("Tìm");
		btnTimMaHDDV.setIcon(new ImageIcon("data/images/search_16.png"));
		btnTimMaHDDV.setBounds(220, 28, 89, 23);
		panel_1.add(btnTimMaHDDV);

		btnXem = new JButton("Xem tất cả");
		btnXem.setIcon(null);
		btnXem.setBounds(315, 28, 106, 23);
		panel_1.add(btnXem);
		
		btnBoChon = new JButton("Bỏ chọn");
		btnBoChon.setBounds(427, 28, 89, 23);
		panel_1.add(btnBoChon);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setBounds(522, 28, 69, 23);
		panel_1.add(btnXoa);

		btnThem.addActionListener(this);
//		btnSua.addActionListener(this);
		btnXacNhan.addActionListener(this);
		btnTimMaHDDV.addActionListener(this);
		btnXem.addActionListener(this);
		btnBoChon.addActionListener(this);
		cboDV.addActionListener(this);
		cboMaKH.addActionListener(this);
		tableHDDV.addMouseListener(this);
		tableDV.addMouseListener(this);
		pnMain.addMouseListener(this);

		
	}

	public JPanel getContentPane() {
		return this.pnMain;
	}

	public static void main(String[] args) {
		new HoaDon_GUI().setVisible(true);
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}}