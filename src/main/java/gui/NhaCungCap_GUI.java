package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.jdesktop.swingx.prompt.PromptSupport;

import connectdb.ConnectDB;
import entity.DonDatHang;
import entity.KhachHang;
import entity.SanPham;
import entity.LoaiSanPham;
import entity.NhaCungCap;
import dao.DonDatHangDAO;
import dao.LoaiSanPhamDAO;
import dao.SanPhamDAO;
import util.Placeholder;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.Box;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.border.CompoundBorder;
import javax.swing.ScrollPaneConstants;

public class NhaCungCap_GUI extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private JPanel out;
	private JTextField txtNhapLieu;
	private JTable table;

	
	private JComboBox<String> cboListMaloai;
	private SanPhamDAO sach_DAO;
	private LoaiSanPhamDAO loaiDAO;

	private ArrayList<SanPham> dssach;
	private List<SanPham> dssachtim;
	private ArrayList<LoaiSanPham> dsLoai;
	private ArrayList<NhaCungCap> dsNCC;
	private JButton btnThem;

	private boolean isTimKiem = false;
	// private ArrayList<entity.SanPham> dsSanpham;
	private DefaultTableModel modelDSSach;
	private JTextField txtMaNCC;
	private JTextField txtTenNCC;
	private JTextField txtDiaChi;
	private JTextField txtSoDt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhaCungCap_GUI frame = new NhaCungCap_GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public NhaCungCap_GUI() throws SQLException {

//		try {
//			ConnectDB.getInstance().ConnectDB();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}

		sach_DAO = new SanPhamDAO();
		loaiDAO = new LoaiSanPhamDAO();
		setTitle("Quản Lý Nhà Cung Cấp");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(0, 0, 1300, 700);

		out = new JPanel();
		out.setLayout(new BoxLayout(out, BoxLayout.Y_AXIS));
		setContentPane(out);

		JPanel top = new JPanel();
		top.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel title = new JLabel("QUẢN LÝ NHÀ CUNG CẤP");
		title.setFont(new Font("Tahoma", Font.BOLD, 20));
		top.add(title);
		// title.setHorizontalAlignment(ABORT);
		out.add(top);

		JPanel bottom = new JPanel();
		bottom.setLayout(new BorderLayout());
		out.add(bottom);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		bottom.add(contentPane, BorderLayout.CENTER);
		JPanel pnLeft = new JPanel();
		// pnLeft.setBorder();
		Border compound = BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED),
				BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		pnLeft.setBorder(compound);
		contentPane.add(pnLeft);

		JPanel pnThongTin = new JPanel();
		pnLeft.add(pnThongTin);
		pnThongTin.setLayout(new BoxLayout(pnThongTin, BoxLayout.Y_AXIS));

		Component verticalStrut_2 = Box.createVerticalStrut(35);
		pnThongTin.add(verticalStrut_2);

		JPanel pnTieuDe = new JPanel();
		pnThongTin.add(pnTieuDe);

		JLabel lblTieuDe = new JLabel("Thông tin nhà cung câp");
		lblTieuDe.setFont(new Font("Tahoma", Font.PLAIN, 25));
		pnTieuDe.add(lblTieuDe);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		pnThongTin.add(verticalStrut_1);

		JPanel pnMaNCC = new JPanel();
		FlowLayout fl_pnMaNCC = (FlowLayout) pnMaNCC.getLayout();
		fl_pnMaNCC.setAlignment(FlowLayout.LEFT);
		pnThongTin.add(pnMaNCC);

		JLabel lblMaNCC = new JLabel("Mã NCC:             ");
		lblMaNCC.setPreferredSize(new Dimension(100, 14));
		pnMaNCC.add(lblMaNCC);

		txtMaNCC= new JTextField();
		txtMaNCC.setEnabled(false);
		txtMaNCC.setPreferredSize(new Dimension(7, 30));
		pnMaNCC.add(txtMaNCC);
		txtMaNCC.setColumns(20);

		JPanel pnTenNCC = new JPanel();
		FlowLayout fl_pnTenncc = (FlowLayout) pnTenNCC.getLayout();
		fl_pnTenncc.setAlignment(FlowLayout.LEFT);
		pnThongTin.add(pnTenNCC);

		JLabel lblTenncc = new JLabel("Tên NCC:");
		lblTenncc.setPreferredSize(new Dimension(100, 14));
		pnTenNCC.add(lblTenncc);

		txtTenNCC = new JTextField();
		txtTenNCC.setPreferredSize(new Dimension(7, 30));
		txtTenNCC.setColumns(20);
		// PromptSupport.setPrompt("tên khách hàng", txtTenKh);
//		new Placeholder().placeholder(txtTenKh, "tên khách hàng");
		pnTenNCC.add(txtTenNCC);

		JPanel pnDiaChi = new JPanel();
		FlowLayout fl_pnDiaChi = (FlowLayout) pnDiaChi.getLayout();
		fl_pnDiaChi.setAlignment(FlowLayout.LEFT);
		pnThongTin.add(pnDiaChi);

		JLabel lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi.setPreferredSize(new Dimension(100, 14));
		pnDiaChi.add(lblDiaChi);

		txtDiaChi = new JTextField();
		txtDiaChi.setPreferredSize(new Dimension(7, 30));
		txtDiaChi.setColumns(20);
		// PromptSupport.setPrompt("Example@gmail.com", txtEmail);

		pnDiaChi.add(txtDiaChi);

		JPanel pnSoDT = new JPanel();
		FlowLayout fl_pnSoDT = (FlowLayout) pnSoDT.getLayout();
		fl_pnSoDT.setAlignment(FlowLayout.LEFT);
		pnThongTin.add(pnSoDT);

		JLabel lblSoDT = new JLabel("Số điện thoại:");
		lblSoDT.setPreferredSize(new Dimension(100, 14));
		pnSoDT.add(lblSoDT);

		txtSoDt = new JTextField();
		txtSoDt.setPreferredSize(new Dimension(7, 30));
		txtSoDt.setColumns(20);
		// PromptSupport.setPrompt("09xx xxx xxx ", txtSdt);
//		new Placeholder().placeholder(txtSdt, "09xx xxx xxx");
		pnSoDT.add(txtSoDt);

		

		Component verticalStrut = Box.createVerticalStrut(20);
		pnThongTin.add(verticalStrut);

		JPanel pnChucNang = new JPanel();
		pnThongTin.add(pnChucNang);
		pnChucNang.setLayout(new GridLayout(2, 0, 5, 5));

		JButton btnThem = new JButton("Thêm");
		btnThem.setBackground(Color.WHITE);
		btnThem.setPreferredSize(new Dimension(70, 35));
		btnThem.setIcon(new ImageIcon("data\\images\\blueAdd_16.png"));
		btnThem.setIconTextGap(10);
		out.getRootPane().setDefaultButton(btnThem);
		pnChucNang.add(btnThem);

		JButton btnSua = new JButton("Sửa");
		btnSua.setBackground(Color.WHITE);
		btnSua.setIcon(new ImageIcon("data\\images\\repairing-service.png"));
		btnSua.setIconTextGap(30);
		pnChucNang.add(btnSua);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.setBackground(Color.WHITE);
		btnXoa.setIcon(new ImageIcon("data\\images\\trash.png"));
		btnXoa.setIconTextGap(10);
		pnChucNang.add(btnXoa);

		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setBackground(Color.WHITE);
		btnLamMoi.setIcon(new ImageIcon("data\\images\\refresh.png"));
		btnLamMoi.setIconTextGap(10);
		pnChucNang.add(btnLamMoi);

		JPanel pnRight = new JPanel();
		contentPane.add(pnRight);
		pnRight.setLayout(new BorderLayout(0, 0));

		JPanel pnTimKiem = new JPanel();
		pnTimKiem.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null),
				new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		pnRight.add(pnTimKiem, BorderLayout.NORTH);

		DefaultComboBoxModel cboLoaiTimKiem = new DefaultComboBoxModel<String>();
		JComboBox cmbLoaiTimKiem = new JComboBox(cboLoaiTimKiem);
		cmbLoaiTimKiem.setToolTipText("tìm kiếm theo");
		cmbLoaiTimKiem.setBackground(Color.WHITE);
		cmbLoaiTimKiem.setPreferredSize(new Dimension(130, 22));
		pnTimKiem.add(cmbLoaiTimKiem);
		cboLoaiTimKiem.addElement((String) "Mã NCC");
		cboLoaiTimKiem.addElement((String) "Tên NCC");
		cboLoaiTimKiem.addElement((String) "Số điện thoại");
	//	cboLoaiTimKiem.addElement((String) "Loại Sách");

		txtNhapLieu = new JTextField();
		txtNhapLieu.setPreferredSize(new Dimension(7, 25));
		pnTimKiem.add(txtNhapLieu);
		// PromptSupport.setPrompt("nhập liệu tìm kiếm", txtNhapLieu);
//		new Placeholder().placeholder(txtNhapLieu, "nhập liệu tìm kiếm");
		txtNhapLieu.setColumns(30);

		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setPreferredSize(new Dimension(130, 25));
		btnTimKiem.setBackground(Color.WHITE);
		btnTimKiem.setIcon(new ImageIcon("data\\images\\search_16.png"));
		pnTimKiem.add(btnTimKiem);

		JButton btnLamMoiDuLieu = new JButton("Làm mới dữ liệu");
		btnLamMoiDuLieu.setPreferredSize(new Dimension(150, 25));
		btnLamMoiDuLieu.setBackground(Color.WHITE);
		btnLamMoiDuLieu.setIcon(new ImageIcon("data\\images\\refresh.png"));
		pnTimKiem.add(btnLamMoiDuLieu);

		JPanel pnTableKh = new JPanel();
		pnRight.add(pnTableKh, BorderLayout.CENTER);
		pnTableKh.setLayout(new BorderLayout(0, 0));

		String[] cols_dssach = { "Mã nhà cung cấp", "Tên nhà cung cấp", "Địa chỉ", "Số điện thoại"};

		modelDSSach = new DefaultTableModel(cols_dssach, 0) {
			// khóa không cho người dùng nhập trên table
			@Override
			public boolean isCellEditable(int i, int i1) {
				return false;
			}
		};
		table = new JTable(modelDSSach);
		JScrollPane scrTableSach = new JScrollPane(table);
		scrTableSach.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrTableSach.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnTableKh.add(scrTableSach);

		btnThem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				if (txtTenSach.getText().equals("") || txtNXB.getText().equals("") || txtSoLuong.getText().equals("")
//						|| txtGiaNhap.getText().equals("") || txtGiaBan.getText().equals("")) {
//					JOptionPane.showMessageDialog(out, "Thiếu dữ liệu đầu vào");
//				} else if (ktdulieu()) {
//					int masp = sach_DAO.getSanPhamCuoiCung().getMaSp() + 1;
//					String tensp = txtTenSach.getText().trim();
//					String nxb = txtNXB.getText().trim();
//					NhaCungCap ncc = new NhaCungCap();
//					ncc = null;
//					dsNCC = sach_DAO.getListNhaCungCap();
//					for (NhaCungCap ncc1 : dsNCC) {
//						if (nxb.equals(ncc1.getTenNCC())) {
//							ncc = ncc1;
//							break;
//						}
//					}
//					if (ncc == null) {
//						sach_DAO.createNCC(nxb);
//						ncc = sach_DAO.getNCCByTenNCC(nxb);
//					}
//					String soluong = txtSoLuong.getText().trim();
//					String giaNhap = txtGiaNhap.getText().trim();
//					String giasp = txtGiaBan.getText().trim();
//					String loaiSach = cboListMaloai.getSelectedItem().toString();
//					LoaiSanPham loaisp = new LoaiSanPham();
//					try {
//						dsLoai = loaiDAO.getDanhSachLoaiSach();
//						for (LoaiSanPham loai : dsLoai) {
//							if (loaiSach.equals(loai.getTenLoai())) {
//								loaisp = loai;
//								break;
//							}
//
//						}
//					} catch (SQLException e2) {
//						// TODO Auto-generated catch block
//						e2.printStackTrace();
//					}
//
//					SanPham sp = new SanPham(masp, tensp, Integer.parseInt(soluong), Double.parseDouble(giaNhap),
//							Double.parseDouble(giasp), loaisp, ncc);
//					if (timma(sp.getMaSp())) {
//						JOptionPane.showMessageDialog(out, "Mã đã tồn tại");
//					} else
//						try {
//							sach_DAO.create(sp);
//							modelDSSach.addRow(new Object[] { sp.getMaSp(), sp.getTenSp(),
//									sp.getNhaCungCap().getTenNCC(), sp.getSoLuong(), sp.getGiaNhap(), sp.getGiaSp(),
//									sp.getLoaiSanPham().getTenLoai() });
//						} catch (Exception e1) {
//							e1.printStackTrace();
//						}
//				}
			}

		});
		btnSua.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				if (txtTenSach.getText().equals("") || txtNXB.getText().equals("") || txtSoLuong.getText().equals("")
//						|| txtGiaNhap.getText().equals("") || txtGiaBan.getText().equals("")) {
//					JOptionPane.showMessageDialog(out, "Thiếu dữ liệu đầu vào");
//				} else if (ktdulieu()) {
//					SanPham sp = getSelectedDataTable();
//					int row = table.getSelectedRow();
//					if (row == -1) {
//						JOptionPane.showMessageDialog(out, "Bạn chưa chọn dòng cần sửa", "Cảnh báo",
//								JOptionPane.WARNING_MESSAGE);
//					} else {
//						boolean result = sach_DAO.capNhat(sp);
//						if (result == true) {
//
//							modelDSSach.setValueAt(sp.getMaSp(), row, 0);
//							modelDSSach.setValueAt(sp.getTenSp(), row, 1);
//							modelDSSach.setValueAt(sp.getNhaCungCap().getTenNCC(), row, 2);
//							modelDSSach.setValueAt(sp.getSoLuong(), row, 3);
//							modelDSSach.setValueAt(sp.getGiaNhap(), row, 4);
//							modelDSSach.setValueAt(sp.getGiaSp(), row, 5);
//							modelDSSach.setValueAt(sp.getLoaiSanPham().getTenLoai(), row, 6);
//							JOptionPane.showMessageDialog(out, "Cập nhập sản phẩm thành công");
//							modelDSSach.fireTableDataChanged();
//							sach_DAO.getListSach();
//						} else {
//							JOptionPane.showMessageDialog(out, "Lỗi: Cập nhật sản phẩm thất bại");
//						}
//					}
//
//				}
			}

		});
		btnXoa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				SanPham sp = getSelectedDataTable();
//				int row = table.getSelectedRow();
//				try {
//					if (row == -1) {
//						JOptionPane.showMessageDialog(out, "Bạn chưa chọn sẩn phẩm cần xoá !!!");
//					} else {
//						int select;
//						select = JOptionPane.showConfirmDialog(out, "Bạn có muốn xoá sản phẩm đã chọn ?", "Cảnh báo",
//								JOptionPane.YES_NO_OPTION);
//						if (select == JOptionPane.YES_OPTION) {
//							sach_DAO.delete(sp);
//							modelDSSach.removeRow(row);
//							JOptionPane.showMessageDialog(out, "Xóa thành công");
//						}
//					}
//				} catch (Exception e2) {
//					JOptionPane.showMessageDialog(out, "Xóa thất bại");
//				}
			}
		});
		btnLamMoi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				txtMaSach.setText("");
//				txtTenSach.setText("");
//				txtNXB.setText("");
//				txtSoLuong.setText("");
//				txtGiaNhap.setText("");
//				txtGiaBan.setText("");
//				cboListMaloai.setSelectedItem("Sách");
			}
		});
		btnTimKiem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				if (txtNhapLieu.getText().equals("")) {
//					JOptionPane.showMessageDialog(out, "Cần nhập dữ liệu sản phẩm cần tìm", "Cảnh báo",
//							JOptionPane.WARNING_MESSAGE);
//				} else {
//					try {
//						String key = "maSP";
//						if (cboLoaiTimKiem.getSelectedItem().toString().equals("Mã Sách")) {
//							key = "SanPham.MaSP";
//						} else if (cboLoaiTimKiem.getSelectedItem().toString().equals("Tên Sách")) {
//							key = "SanPham.TenSP";
//						} else if (cboLoaiTimKiem.getSelectedItem().toString().equals("Nhà Xuất Bản")) {
//							key = "NhaCungCap.TenNCC";
//
//						} else if (cboLoaiTimKiem.getSelectedItem().toString().equals("Loại Sách")) {
//							key = "LoaiSanPham.TenLoai";
//						}
//						dssachtim = sach_DAO.timKiemSach(key, txtNhapLieu.getText());
//						renderDataTimKiem();
//						isTimKiem = true;
//					} catch (SQLException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//				}
			}
		});
		btnLamMoiDuLieu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				try {
//					table.clearSelection();
//
//					modelDSSach.getDataVector().removeAllElements();
//					renderData();
//					isTimKiem = false;
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
			}
		});
		table.addMouseListener(this);
		// DocDuLieuVaoModel(sach_DAO.getListSach());
//		try {
//			renderData();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			loadCboMaLoai();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

	public JPanel getContentPane() {
		return this.contentPane;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
//		int row = table.getSelectedRow();
//		txtMaSach.setText(modelDSSach.getValueAt(row, 0).toString());
//		txtTenSach.setText(modelDSSach.getValueAt(row, 1).toString());
//		txtNXB.setText(modelDSSach.getValueAt(row, 2).toString());
//		txtSoLuong.setText(modelDSSach.getValueAt(row, 3).toString());
//		txtGiaNhap.setText(modelDSSach.getValueAt(row, 4).toString());
//		txtGiaBan.setText(modelDSSach.getValueAt(row, 5).toString());
//		cboListMaloai.setSelectedItem(modelDSSach.getValueAt(row, 6).toString());

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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public void renderData() throws SQLException {

		dssach = sach_DAO.getListSach();

		dssach.forEach(sach -> {
			modelDSSach.addRow(new Object[] { sach.getMaSp(), sach.getTenSp(), sach.getNhaCungCap().getTenNCC(),
					sach.getSoLuong(), sach.getGiaNhap(), sach.getGiaSp(), sach.getLoaiSanPham().getTenLoai() });
		});
	}

//	private void loadCboMaLoai() throws SQLException {
//		dsLoai = loaiDAO.getDanhSachLoaiSach();
//		for (LoaiSanPham loai : dsLoai) {
//			String ma = loai.getTenLoai();
//			cboListMaloai.addItem(String.valueOf(ma));
//		}
//	}

//	private SanPham getSelectedDataTable() {
//		String masp = txtMaSach.getText().trim();
//		String tensp = txtTenSach.getText().trim();
//		String nxb = txtNXB.getText().trim();
//		NhaCungCap ncc = new NhaCungCap();
//		ncc = null;
//		dsNCC = sach_DAO.getListNhaCungCap();
//		for (NhaCungCap ncc1 : dsNCC) {
//			if (nxb.equalsIgnoreCase(ncc1.getTenNCC())) {
//				ncc = ncc1;
//				break;
//			}
//		}
//		if (ncc == null) {
//			sach_DAO.createNCC(nxb);
//			ncc = sach_DAO.getNCCByTenNCC(nxb);
//		}
//
//		String soluong = txtSoLuong.getText().trim();
//		String giaNhap = txtGiaNhap.getText().trim();
//		String giasp = txtGiaBan.getText().trim();
//		String loaiSach = cboListMaloai.getSelectedItem().toString();
//		LoaiSanPham loaisp = new LoaiSanPham();
//		try {
//			dsLoai = loaiDAO.getDanhSachLoaiSach();
//			for (LoaiSanPham loai : dsLoai) {
//				if (loaiSach.equals(loai.getTenLoai())) {
//					loaisp = loai;
//				} else
//					loaiDAO.createLoaiSp(loaiSach);
//
//			}
//		} catch (SQLException e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		}
//
//		SanPham sp = new SanPham(Integer.parseInt(masp), tensp, Integer.parseInt(soluong), Double.parseDouble(giaNhap),
//				Double.parseDouble(giasp), loaisp, ncc);
//		return sp;
//	}
//
//	private boolean ktdulieu() {
//
//		return true;
//
//	}
//
//	public boolean timma(int ma) {
//		int temp;
//		for (int i = 0; i < table.getRowCount(); i++) {
//			temp = (int) table.getValueAt(i, 0);
//			if (temp == ma) {
//				table.setRowSelectionInterval(i, i);
//				// scroll đến dòng được chọn
//				Rectangle cellRect = table.getCellRect(i, 0, true);
//				table.scrollRectToVisible(cellRect);
//				return true;
//			}
//		}
//		return false;
//	}
//
//	public void renderDataTimKiem() throws SQLException {
//		table.clearSelection();
//
//		modelDSSach.getDataVector().removeAllElements();
//
//		dssachtim.forEach(sach -> {
//			modelDSSach.addRow(new Object[] { sach.getMaSp(), sach.getTenSp(), sach.getNhaCungCap().getTenNCC(),
//					sach.getSoLuong(), sach.getGiaNhap(), sach.getGiaSp(), sach.getLoaiSanPham().getTenLoai() });
//		});
//
//		table.revalidate();
//		table.repaint();
//	}
}
