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

import util.Placeholder;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
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

import javax.swing.BorderFactory;
import javax.swing.Box;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.border.CompoundBorder;
import javax.swing.ScrollPaneConstants;

public class Sach_GUI extends JFrame {

	private JPanel contentPane;
	private JPanel out;
	private JTextField txtNhapLieu;
	private JTable table;
	
	private JTextField txtMaSach;
	private JTextField txtTenSach;
	private JTextField txtNXB;
	private JTextField txtSoLuong;
	private JTextField txtGiaNhap;
	private JTextField txtGiaBan;
	private JTextField txtMaLoai;
	private JComboBox<String> cboListMaloai;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sach_GUI frame = new Sach_GUI();
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
	public Sach_GUI() {
		setTitle("Quản Lý Sách");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(0, 0, 1300, 700);
		
		out = new JPanel();
		out.setLayout(new BoxLayout(out,BoxLayout.Y_AXIS));
		setContentPane(out);
		
		
		JPanel top = new JPanel();
		top.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel title = new JLabel("QUẢN LÝ SÁCH");
		title.setFont(new Font("Tahoma", Font.BOLD, 20));
		top.add(title);
		//title.setHorizontalAlignment(ABORT);
		out.add(top);
		
		JPanel bottom = new JPanel();
		bottom.setLayout(new BorderLayout());
		out.add(bottom);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		bottom.add(contentPane,BorderLayout.CENTER);
		JPanel pnLeft = new JPanel();
		//pnLeft.setBorder();
		Border compound = BorderFactory.createCompoundBorder(
				BorderFactory.createBevelBorder(BevelBorder.RAISED),
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
		
		JLabel lblTieuDe = new JLabel("Thông tin sách");
		lblTieuDe.setFont(new Font("Tahoma", Font.PLAIN, 25));
		pnTieuDe.add(lblTieuDe);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		pnThongTin.add(verticalStrut_1);
		
		JPanel pnMaSach = new JPanel();
		FlowLayout fl_pnMaKh = (FlowLayout) pnMaSach.getLayout();
		fl_pnMaKh.setAlignment(FlowLayout.LEFT);
		pnThongTin.add(pnMaSach);
		
		JLabel lblMaSach = new JLabel("Mã Sách:             ");
		lblMaSach.setPreferredSize(new Dimension(100, 14));
		pnMaSach.add(lblMaSach);
		
		txtMaSach = new JTextField();
		txtMaSach.setEnabled(false);
		txtMaSach.setPreferredSize(new Dimension(7, 30));
		pnMaSach.add(txtMaSach);
		txtMaSach.setColumns(20);
		
		JPanel pnTenSach = new JPanel();
		FlowLayout fl_pnTenKh = (FlowLayout) pnTenSach.getLayout();
		fl_pnTenKh.setAlignment(FlowLayout.LEFT);
		pnThongTin.add(pnTenSach);
		
		JLabel lblTenSach = new JLabel("Tên Sách:");
		lblTenSach.setPreferredSize(new Dimension(100, 14));
		pnTenSach.add(lblTenSach);
		
		txtTenSach = new JTextField();
		txtTenSach.setPreferredSize(new Dimension(7, 30));
		txtTenSach.setColumns(20);
		//PromptSupport.setPrompt("tên khách hàng", txtTenKh);
//		new Placeholder().placeholder(txtTenKh, "tên khách hàng");
		pnTenSach.add(txtTenSach);
		
		JPanel pnNXB = new JPanel();
		FlowLayout fl_pnNXB = (FlowLayout) pnNXB.getLayout();
		fl_pnNXB.setAlignment(FlowLayout.LEFT);
		pnThongTin.add(pnNXB);
		
		JLabel lblNXB = new JLabel("Nhà xuất bản:");
		lblNXB.setPreferredSize(new Dimension(100, 14));
		pnNXB.add(lblNXB);
		
		txtNXB = new JTextField();
		txtNXB.setPreferredSize(new Dimension(7, 30));
		txtNXB.setColumns(20);
		//PromptSupport.setPrompt("Example@gmail.com", txtEmail);
		
		pnNXB.add(txtNXB);
		
		JPanel pnSoLuong = new JPanel();
		FlowLayout fl_pnSoLuong = (FlowLayout) pnSoLuong.getLayout();
		fl_pnSoLuong.setAlignment(FlowLayout.LEFT);
		pnThongTin.add(pnSoLuong);
		
		JLabel lblSoLuong = new JLabel("Số lượng:");
		lblSoLuong.setPreferredSize(new Dimension(100, 14));
		pnSoLuong.add(lblSoLuong);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setPreferredSize(new Dimension(7, 30));
		txtSoLuong.setColumns(20);
		//PromptSupport.setPrompt("09xx xxx xxx ", txtSdt);
//		new Placeholder().placeholder(txtSdt, "09xx xxx xxx");
		pnSoLuong.add(txtSoLuong);
		
		JPanel pnGiaNhap = new JPanel();
		FlowLayout fl_pnGiaNhap = (FlowLayout) pnGiaNhap.getLayout();
		fl_pnGiaNhap.setAlignment(FlowLayout.LEFT);
		pnThongTin.add(pnGiaNhap);
		
		JLabel lblGiaNhap = new JLabel("Giá nhập:");
		lblGiaNhap.setPreferredSize(new Dimension(100, 14));
		pnGiaNhap.add(lblGiaNhap);
		
		txtGiaNhap = new JTextField();
		txtGiaNhap.setPreferredSize(new Dimension(7, 30));
		txtGiaNhap.setColumns(20);
		//PromptSupport.setPrompt("Số nhà, tên đường, tỉnh thành", txtDiaChi);
		
		pnGiaNhap.add(txtGiaNhap);
		
		
		JPanel pnGiaBan = new JPanel();
		JLabel lblGiaBan = new JLabel("Giá bán:");
		lblGiaBan.setPreferredSize(new Dimension(100, 14));
		pnGiaBan.add(lblGiaBan);
		pnThongTin.add(pnGiaBan);
		txtGiaBan = new JTextField();
		txtGiaBan.setPreferredSize(new Dimension(7, 30));
		txtGiaBan.setColumns(20);
		//PromptSupport.setPrompt("Số nhà, tên đường, tỉnh thành", txtDiaChi);
		
		pnGiaBan.add(txtGiaBan);
		
		
		JPanel pnMaLoai = new JPanel();
		JLabel lblMaLoai = new JLabel("Mã Loại:");
		lblMaLoai.setPreferredSize(new Dimension(100, 14));
		pnMaLoai.add(lblMaLoai);
		pnThongTin.add(pnMaLoai);
		cboListMaloai = new JComboBox<String>();
		
		cboListMaloai.setPreferredSize(new Dimension(202,30));
//		cboListMaloai.setModel(new javax.swing.DefaultComboBoxModel<>());
		cboListMaloai.addItem("Name");
		//cboListMaloai.setSize(7, 30);
		//PromptSupport.setPrompt("Số nhà, tên đường, tỉnh thành", txtDiaChi);
	
		pnMaLoai.add(cboListMaloai);
		
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
		pnTimKiem.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		pnRight.add(pnTimKiem, BorderLayout.NORTH);

		DefaultComboBoxModel cboLoaiTimKiem = new DefaultComboBoxModel<String>();
		JComboBox cmbLoaiTimKiem = new JComboBox(cboLoaiTimKiem);
		cmbLoaiTimKiem.setToolTipText("tìm kiếm theo");
		cmbLoaiTimKiem.setBackground(Color.WHITE);
		cmbLoaiTimKiem.setPreferredSize(new Dimension(130, 22));
		pnTimKiem.add(cmbLoaiTimKiem);
		cboLoaiTimKiem.addElement((String) "Mã Sách");
		cboLoaiTimKiem.addElement((String) "Tên Sách");
		cboLoaiTimKiem.addElement((String) "Nhà Xuất Bản");
		cboLoaiTimKiem.addElement((String) "Loại Sách");
		
		
		
		txtNhapLieu = new JTextField();
		txtNhapLieu.setPreferredSize(new Dimension(7, 25));
		pnTimKiem.add(txtNhapLieu);
		//PromptSupport.setPrompt("nhập liệu tìm kiếm", txtNhapLieu);
//		new Placeholder().placeholder(txtNhapLieu, "nhập liệu tìm kiếm");
		txtNhapLieu.setColumns(30);
		
		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setPreferredSize(new Dimension(130, 25));
		btnTimKiem.setBackground(Color.WHITE);
		btnTimKiem.setIcon(new ImageIcon("data\\images\\search_16.png"));
		pnTimKiem.add(btnTimKiem);
		
		JPanel pnTableKh = new JPanel();
		pnRight.add(pnTableKh, BorderLayout.CENTER);
		pnTableKh.setLayout(new BorderLayout(0, 0));
		
		String[] cols_dssach = {"Mã sách", "Tên sách", "Nhà xuất bản", "Số lượng", "Giá nhập", "Giá bán", "Loại Sách"};
		DefaultTableModel modelDSSach = new DefaultTableModel(cols_dssach, 0);
		table = new JTable(modelDSSach);
		JScrollPane scrTableSach = new JScrollPane(table);
		scrTableSach.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrTableSach.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnTableKh.add(scrTableSach);
		
		//modelDSKH.addRow(new Object[]{"1", "Tran Van Nhan", "0987654321", "tranvannhan@gmail.com", "Thủ Đức, Hồ Chí Minh"});
		
		
	}

	public JPanel getContentPane() {
		 return this.contentPane;
	 }
}
