package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import entity.HoaDon;
import util.Currency;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import java.awt.Color;

public class XuatHoaDon_GUI extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel modelDSSP;
	private JTable tblDSSP;
	private HoaDon hd;
	private JLabel lblMaHD;
	private JLabel lblNhanVien;
	private JLabel lblTenKH;
	private JLabel lblSDT;
	private JLabel lblDiaChi;
	private JLabel lblNgayLap;
	private JLabel lblTongTien;
	private double tongTien;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					XuatHoaDon_GUI frame = new XuatHoaDon_GUI();
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
	public XuatHoaDon_GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 700);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Hóa đơn");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_3.add(panel_4);
		
		JLabel lbllMaHD = new JLabel("Mã hóa đơn: ");
		lbllMaHD.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbllMaHD.setPreferredSize(new Dimension(200, 25));
		panel_4.add(lbllMaHD);
		
		lblMaHD = new JLabel("1");
		lblMaHD.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(lblMaHD);
		
		JPanel panel_4_7 = new JPanel();
		FlowLayout flowLayout_6 = (FlowLayout) panel_4_7.getLayout();
		flowLayout_6.setAlignment(FlowLayout.LEFT);
		panel_3.add(panel_4_7);
		
		JLabel lblNhnVinBn = new JLabel("Nhân viên bán: ");
		lblNhnVinBn.setPreferredSize(new Dimension(200, 25));
		lblNhnVinBn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4_7.add(lblNhnVinBn);
		
		lblNhanVien = new JLabel("Trần Văn Nhân");
		lblNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4_7.add(lblNhanVien);
		
		JPanel panel_4_2 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_4_2.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panel_3.add(panel_4_2);
		
		JLabel lblTnKhchHng = new JLabel("Tên khách hàng:");
		lblTnKhchHng.setPreferredSize(new Dimension(200, 25));
		lblTnKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4_2.add(lblTnKhchHng);
		
		lblTenKH = new JLabel("Trần Văn Nhân");
		lblTenKH.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4_2.add(lblTenKH);
		
		JPanel panel_4_3 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_4_3.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		panel_3.add(panel_4_3);
		
		JLabel lblSinThoi = new JLabel("Số điện thoại: ");
		lblSinThoi.setPreferredSize(new Dimension(200, 25));
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4_3.add(lblSinThoi);
		
		lblSDT = new JLabel("0987654321");
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4_3.add(lblSDT);
		
		JPanel panel_4_4 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_4_4.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		panel_3.add(panel_4_4);
		
		JLabel lblaCh = new JLabel("Địa chỉ: ");
		lblaCh.setPreferredSize(new Dimension(200, 25));
		lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4_4.add(lblaCh);
		
		lblDiaChi = new JLabel("Bình chiểu");
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4_4.add(lblDiaChi);
		
		JPanel panel_4_5 = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panel_4_5.getLayout();
		flowLayout_5.setAlignment(FlowLayout.LEFT);
		panel_3.add(panel_4_5);
		
		JLabel lblNgyt = new JLabel("Ngày đặt");
		lblNgyt.setPreferredSize(new Dimension(200, 25));
		lblNgyt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4_5.add(lblNgyt);
		
		lblNgayLap = new JLabel("11/11/2021");
		lblNgayLap.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4_5.add(lblNgayLap);
		
		JPanel panel_6 = new JPanel();
		panel_2.add(panel_6);
		
		String[] cols = {"Tên sản phẩm", "Đơn giá", "Số lượng", "Thành tiền"};
		modelDSSP = new DefaultTableModel(cols, 0);
		panel_6.setLayout(new BorderLayout(0, 0));
		tblDSSP = new JTable(modelDSSP);
		JScrollPane scrollPane = new JScrollPane(tblDSSP);
		panel_6.add(scrollPane);
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5, BorderLayout.SOUTH);
		
		JPanel panel_4_6 = new JPanel();
		panel_5.add(panel_4_6);
		
		JLabel lbllMaHD_6 = new JLabel("Tổng tiền");
		lbllMaHD_6.setPreferredSize(new Dimension(200, 25));
		lbllMaHD_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4_6.add(lbllMaHD_6);
		
		lblTongTien = new JLabel("100.000 VNĐ");
		lblTongTien.setPreferredSize(new Dimension(120, 25));
		lblTongTien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4_6.add(lblTongTien);
		
		JButton btnInHoaDon = new JButton("In hóa đơn");
		btnInHoaDon.setBackground(Color.WHITE);
		panel_5.add(btnInHoaDon);
		
		btnInHoaDon.addActionListener(e -> {
			JOptionPane.showMessageDialog(contentPane, "In thành công");
			
		});
	}
	
	public void renderData() {
		lblMaHD.setText(String.valueOf(hd.getMaHD()));
		lblNhanVien.setText(hd.getNhanVien().getTenNv());
		lblTenKH.setText(hd.getKhachHang().getHoTen());
		lblSDT.setText(hd.getKhachHang().getSoDienThoai());
		lblDiaChi.setText(hd.getKhachHang().getDiaChi());
		lblNgayLap.setText(hd.getNgayMua().toString());
		
		tongTien = 0.0;
		modelDSSP.getDataVector().removeAllElements();
		hd.getChiTietHoaDons().forEach(cthd -> {
			modelDSSP.addRow(new Object[] {
				cthd.getSanPham().getTenSp(),
				Currency.format(cthd.getDonGia()),
				cthd.getSoLuong(),
				Currency.format(cthd.getDonGia() * cthd.getSoLuong()) 
				
			});
			tongTien += cthd.getDonGia() * cthd.getSoLuong();
		});
		
		lblTongTien.setText(Currency.format(tongTien));
	}
	
	public void setHoaDon(HoaDon hd) {
		this.hd = hd;
		renderData();
	}

}
