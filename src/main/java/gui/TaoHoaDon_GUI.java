package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;

import java.awt.Dimension;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import dao.HoaDonDAO;
import dao.KhachHangDAO;
import dao.NhanVienDAO;
import dao.SanPhamDAO;
import entity.ChiTietHoaDon;
import entity.DonDatHang;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.SanPham;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.ScrollPaneConstants;

public class TaoHoaDon_GUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaKH;
	private JTextField txtSDT;
	private JTextField txtDiaChi;
	private JTextField textField_4;
	private JButton btnThemSP;
	private JButton btnBoSP;
	

	private DefaultComboBoxModel<String> modelKH;
	private JComboBox cboKH;
	
	private DefaultTableModel modelSPCTM;
	private JTable tblSPCTM;
	private DefaultTableModel modelSPTGH;
	private JTable tblSPTGH;
	
	private NhanVien nhanVien = new NhanVienDAO().getNhanVienByMaNV(1);
	private ArrayList<KhachHang> dskh;
	private ArrayList<SanPham> dssp;
	private ArrayList<ChiTietHoaDon> dscthd = new ArrayList<ChiTietHoaDon>();
	private JTextField txtSoLuong;
	private JButton btnThemHD; 
	private JTextField txtTongTien;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaoHoaDon_GUI frame = new TaoHoaDon_GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public TaoHoaDon_GUI() throws SQLException {
		setTitle("Tạo hóa đơn");
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(0, 0, 1300, 700);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel pnThongTinKH = new JPanel();
		contentPane.add(pnThongTinKH, BorderLayout.WEST);
		
		JPanel pnThongTinKH2 = new JPanel();
		pnThongTinKH.add(pnThongTinKH2);
		pnThongTinKH2.setLayout(new BorderLayout(0, 0));
		
		JPanel pnTTKH = new JPanel();
		pnTTKH.setBorder(new EmptyBorder(40, 0, 0, 0));
		pnThongTinKH2.add(pnTTKH, BorderLayout.NORTH);
		
		JLabel lblTTKH = new JLabel("Thông tin khách hàng");
		lblTTKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnTTKH.add(lblTTKH);
		
		JPanel pnThongTin = new JPanel();
		pnThongTinKH2.add(pnThongTin, BorderLayout.CENTER);
		pnThongTin.setLayout(new BoxLayout(pnThongTin, BoxLayout.Y_AXIS));
		
		JPanel pnMaKH = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnMaKH.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		pnThongTin.add(pnMaKH);
		
		JLabel lblMaKH = new JLabel("Mã khách hàng");
		lblMaKH.setPreferredSize(new Dimension(100, 20));
		pnMaKH.add(lblMaKH);
		
		txtMaKH = new JTextField();
		txtMaKH.setEditable(false);
		txtMaKH.setPreferredSize(new Dimension(7, 30));
		pnMaKH.add(txtMaKH);
		txtMaKH.setColumns(20);
		
		JPanel pnTenKH = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) pnTenKH.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		pnThongTin.add(pnTenKH);
		
		JLabel lblTenKH = new JLabel("Tên khách hàng");
		lblTenKH.setPreferredSize(new Dimension(100, 20));
		pnTenKH.add(lblTenKH);
		
		modelKH = new DefaultComboBoxModel<String>();
		cboKH = new JComboBox(modelKH);
		cboKH.setPreferredSize(new Dimension(170, 30));
		pnTenKH.add(cboKH);
		
		JPanel pnSoDienThoai = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) pnSoDienThoai.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		pnThongTin.add(pnSoDienThoai);
		
		JLabel lblSDT = new JLabel("Số điện thoại");
		lblSDT.setPreferredSize(new Dimension(100, 20));
		pnSoDienThoai.add(lblSDT);
		
		txtSDT = new JTextField();
		txtSDT.setEditable(false);
		txtSDT.setPreferredSize(new Dimension(7, 30));
		txtSDT.setColumns(20);
		pnSoDienThoai.add(txtSDT);
		
		JPanel pnDiaChi = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) pnDiaChi.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		pnThongTin.add(pnDiaChi);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ");
		lblDiaChi.setPreferredSize(new Dimension(100, 20));
		pnDiaChi.add(lblDiaChi);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setEditable(false);
		txtDiaChi.setPreferredSize(new Dimension(7, 30));
		txtDiaChi.setColumns(20);
		pnDiaChi.add(txtDiaChi);
		
		JPanel pnTongTien = new JPanel();
		pnThongTin.add(pnTongTien);
		
		JLabel lblTongTien = new JLabel("Tổng tiền");
		lblTongTien.setPreferredSize(new Dimension(100, 20));
		pnTongTien.add(lblTongTien);
		
		txtTongTien = new JTextField("0");
		txtTongTien.setPreferredSize(new Dimension(7, 30));
		txtTongTien.setEditable(false);
		txtTongTien.setColumns(20);
		pnTongTien.add(txtTongTien);
		
		JPanel pnBtn = new JPanel();
		pnThongTin.add(pnBtn);
		
		btnThemHD = new JButton("Thêm hóa đơn");
		btnThemHD.setBackground(Color.WHITE);
		pnBtn.add(btnThemHD);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		panel_1.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Danh sách sản phẩm");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(lblNewLabel);
		
		String[] cols = {"Mã sản phẩm", "Tên sản phẩm", "Đơn giá"};
		modelSPCTM = new DefaultTableModel(cols, 0);
		tblSPCTM = new JTable(modelSPCTM);
		
		JScrollPane scrollPane = new JScrollPane(tblSPCTM);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel.add(scrollPane, BorderLayout.CENTER);
		
		modelSPCTM.addRow(new Object[] {"1", "Sach giao khoa", 123.456});
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.Y_AXIS));
		
		Component verticalStrut = Box.createVerticalStrut(250);
		panel_5.add(verticalStrut);
		
		JPanel panel_8 = new JPanel();
		panel_5.add(panel_8);
		panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.Y_AXIS));
		
		JPanel panel_9 = new JPanel();
		panel_8.add(panel_9);
		panel_9.setLayout(new BoxLayout(panel_9, BoxLayout.Y_AXIS));
		
		btnThemSP = new JButton(">>");
		btnThemSP.setBackground(Color.WHITE);
		btnThemSP.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_9.add(btnThemSP);
		
		JPanel panel_10 = new JPanel();
		panel_8.add(panel_10);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setHorizontalAlignment(SwingConstants.CENTER);
		txtSoLuong.setText("1");
		txtSoLuong.setPreferredSize(new Dimension(49, 30));
		txtSoLuong.setColumns(4);
		panel_10.add(txtSoLuong);
		
		JPanel panel_11 = new JPanel();
		panel_8.add(panel_11);
		
		btnBoSP = new JButton("<<");
		btnBoSP.setBackground(Color.WHITE);
		btnBoSP.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_11.add(btnBoSP);
		
		
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_3.add(panel_6, BorderLayout.NORTH);
		panel_6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_1 = new JLabel("Danh sách sản phẩm trong giỏ hàng");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_6.add(lblNewLabel_1);
		
		String[] cols2 = {"Mã sản phẩm", "Tên sản phẩm", "Đơn giá", "Số lượng", "Thành tiền"};
		modelSPTGH = new DefaultTableModel(cols2, 0);
		tblSPTGH = new JTable(modelSPTGH);
		JScrollPane scrollPane_1 = new JScrollPane(tblSPTGH);
		scrollPane_1.setPreferredSize(new Dimension(450, 500));
		panel_3.add(scrollPane_1, BorderLayout.CENTER);
		
		renderKhachHang();
		renderData();
		
		cboKH.addActionListener((e) -> {
			int idx = cboKH.getSelectedIndex();
			if(idx != -1) {
				idx--;
				if(idx == -1) {
					txtMaKH.setText("");
					txtSDT.setText("");
					txtDiaChi.setText("");
					return;
				}
				txtMaKH.setText(String.valueOf(dskh.get(idx).getMaKh()));
				txtSDT.setText(dskh.get(idx).getSoDienThoai());
				txtDiaChi.setText(dskh.get(idx).getDiaChi());
			}
		});
		
		btnThemSP.addActionListener((e) -> {
			int idx = tblSPCTM.getSelectedRow();
			if(idx != -1) {
				ChiTietHoaDon cthd = new ChiTietHoaDon(dssp.get(idx), Integer.parseInt(txtSoLuong.getText()), dssp.get(idx).getGiaSp());
				dscthd.add(cthd);
				tinhTongTien();
				try {
					renderData();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		btnBoSP.addActionListener((e) -> {
			int idx = tblSPTGH.getSelectedRow();
			if(idx != -1) {
				dscthd.remove(idx);
				tinhTongTien();
				try {
					renderData();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnThemHD.addActionListener((e) -> {
			int idx = cboKH.getSelectedIndex(); 
			if(idx <= 0) {
				JOptionPane.showMessageDialog(contentPane, "Vui lòng chọn khách hàng");
				return;
			}
			
			if(dscthd.size() == 0) {
				JOptionPane.showMessageDialog(contentPane, "Vui lòng thêm hàng vào giỏ");
				return;
			}
			
			int choose = JOptionPane.showConfirmDialog(contentPane, "Chắc chắn tạo hóa đơn");
			if(choose == 0) {
				System.out.println(this.nhanVien);
				HoaDon hd = new HoaDon(this.nhanVien, dskh.get(idx-1), dscthd);
				System.out.println(hd.getNhanVien());
				try {
					HoaDonDAO hoaDonDao = new HoaDonDAO();
					if(hoaDonDao.themHoaDon(hd)) {
						JOptionPane.showMessageDialog(contentPane, "Đã thêm hóa đơn thành công");
					}else {
						JOptionPane.showMessageDialog(contentPane, hoaDonDao.getError());
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
	
	public void renderKhachHang() throws SQLException {
//		khach hang
		dskh = new KhachHangDAO().getListKhachHang();
		modelKH.removeAllElements();
		modelKH.addElement("");
		cboKH.setSelectedIndex(0);
		
		dskh.forEach(kh -> {
			System.out.println(kh.getHoTen());
			modelKH.addElement(kh.getHoTen());
		});
		cboKH.revalidate();
		cboKH.repaint();
	}
	
	public void renderData() throws SQLException {
//		san pham
		tblSPCTM.clearSelection();
		dssp = new SanPhamDAO().getListSanPham();
		modelSPCTM.getDataVector().removeAllElements();
		for(int i=0; i<dssp.size(); i++) {
			boolean flag = true;
			for(int j=0; j<dscthd.size(); j++) {
				if(dscthd.get(j).getSanPham().getMaSp() == dssp.get(i).getMaSp()) {
					flag = false;
				}
			}
			if(flag)
				modelSPCTM.addRow(new Object[] {dssp.get(i).getMaSp(), dssp.get(i).getTenSp(), dssp.get(i).getGiaSp()});
			else {
				dssp.remove(i);
				i--;
			}
		}
		
		tblSPCTM.revalidate();
		tblSPCTM.repaint();
		
//		san pham trong don hang
		tblSPTGH.clearSelection();
		modelSPTGH.getDataVector().removeAllElements();
		dscthd.forEach(cthd -> {
			modelSPTGH.addRow(new Object[] {cthd.getSanPham().getMaSp(), cthd.getSanPham().getTenSp(), cthd.getDonGia(), cthd.getSoLuong(), cthd.tinhThanhTien()});
		});
		tblSPTGH.revalidate();
		tblSPTGH.repaint();
	}
	
	public void tinhTongTien() {
		double tongTien = 0;
		for(int i=0; i<dscthd.size(); i++) {
			tongTien += dscthd.get(i).tinhThanhTien();
		}
		txtTongTien.setText(String.valueOf(tongTien));
	}
	
	public JPanel getContentPane() {
		return this.contentPane;
	}

}
