package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.HoaDonDAO;
import dao.KhachHangDAO;
import dao.SanPhamDAO;
import entity.KhachHang;
import entity.SanPham;
import util.Ngay;
import util.Placeholder;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import javax.swing.border.MatteBorder;

public class ThongKe extends JFrame {

	private int soLuongSP = 0;
	
	private JPanel contentPane;
	private JTextField txtTuNgay;
	private JTextField txtToiNgay;
	private Map<SanPham, Integer> dssp;
	private DefaultTableModel model;
	DialogDatePicker f = new DialogDatePicker();
	private kDatePicker dpTuNgay;
	private kDatePicker dpToiNgay;
	private JComboBox comboBox;
	private JComboBox cboLoaiTK;

	private int tongSoLanMua;

	private int tongSoTien;

	private DefaultComboBoxModel<Integer> modelLimit;

	private JLabel lblTongSo;

	private JLabel lblKH;

	private JLabel lblSP;

	private JLabel lblDoanhThu;

	private JLabel lblVon;

	private JLabel lblLoiNhuan;

	private int tongSo;

	private int doanhThu;

	private List<Map<String, String>> ls;

	private JLabel lblSach;

	private JLabel lblDungCu;

	private int soVon;

	private int soLuongSach;

	private int soLuongDungCu;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThongKe frame = new ThongKe();
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
	public ThongKe() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(0, 0, 1300, 700);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Thống kê báo cáo");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_3.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JLabel lblThongKeTheo = new JLabel("Thống kê theo: ");
		panel_2.add(lblThongKeTheo);
		
		
		DefaultComboBoxModel<String> modelLoai = new DefaultComboBoxModel<String>();
		cboLoaiTK = new JComboBox(modelLoai);
		panel_2.add(cboLoaiTK);
		modelLoai.addElement("Tùy chỉnh");
		modelLoai.addElement("Ngày hôm nay");
		modelLoai.addElement("Ngày hôm qua");
		modelLoai.addElement("7 ngày qua");
		modelLoai.addElement("1 tháng qua");
		modelLoai.addElement("1 năm qua");
		
		JLabel lblTuNgay = new JLabel("Từ ngày:  ");
		panel_2.add(lblTuNgay);
		
		
		dpTuNgay = new kDatePicker();
		panel_2.add(dpTuNgay);
		
		JLabel lblToiNgay = new JLabel("Tới ngày");
		panel_2.add(lblToiNgay);
		
		dpToiNgay = new kDatePicker();
		panel_2.add(dpToiNgay);
		
		modelLimit = new DefaultComboBoxModel<Integer>();
		modelLimit.addElement(10);
		modelLimit.addElement(25);
		modelLimit.addElement(50);
		modelLimit.addElement(100);
		modelLimit.addElement(500);
		
		JButton btnThongKe = new JButton("Thống kê", new ImageIcon("data/images/statistics.png"));

		btnThongKe.setBackground(Color.WHITE);
		panel_2.add(btnThongKe);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		panel_1.setLayout(new BorderLayout(0, 0));
		
		String[] cols = {"STT", "Mã khách hàng", "Tên khách hàng", "Số điện thoại", "Địa chỉ", "Số lần mua hàng", "Số tiền mua hàng"};
		model = new DefaultTableModel(cols, 0);
		
		JPanel panel_7 = new JPanel();
		panel_1.add(panel_7, BorderLayout.NORTH);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EmptyBorder(20, 0, 0, 0));
		panel_7.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.Y_AXIS));
		
		JPanel pnItem1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnItem1.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_4.add(pnItem1);
		
		JLabel lblTong = new JLabel("Tổng số lần mua hàng: ");
		lblTong.setPreferredSize(new Dimension(300, 30));
		lblTong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnItem1.add(lblTong);
		
		lblTongSo = new JLabel("0");
		lblTongSo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnItem1.add(lblTongSo);
		
		JPanel pnItem2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) pnItem2.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_4.add(pnItem2);
		
		JLabel lblSKhchHng = new JLabel("Số khách hàng đã mua:");
		lblSKhchHng.setPreferredSize(new Dimension(300, 30));
		lblSKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnItem2.add(lblSKhchHng);
		
		lblKH = new JLabel("0");
		lblKH.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnItem2.add(lblKH);
		
		JPanel pnItem3 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) pnItem3.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panel_4.add(pnItem3);
		
		JLabel lblSSnPhm = new JLabel("Số lượng sách bán được:");
		lblSSnPhm.setPreferredSize(new Dimension(300, 30));
		lblSSnPhm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnItem3.add(lblSSnPhm);
		
		lblSach = new JLabel("0");
		lblSach.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnItem3.add(lblSach);
		
		JPanel pnItem3_1 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) pnItem3_1.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		panel_4.add(pnItem3_1);
		
		JLabel lblSLngDng = new JLabel("Số lượng dụng cụ bán được:");
		lblSLngDng.setPreferredSize(new Dimension(300, 30));
		lblSLngDng.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnItem3_1.add(lblSLngDng);
		
		lblDungCu = new JLabel("0");
		lblDungCu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnItem3_1.add(lblDungCu);
		
		JPanel pnItem4 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) pnItem4.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		panel_4.add(pnItem4);
		
		JLabel lblDoanhThuNhn = new JLabel("Doanh thu nhận được:");
		lblDoanhThuNhn.setPreferredSize(new Dimension(300, 30));
		lblDoanhThuNhn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnItem4.add(lblDoanhThuNhn);
		
		lblDoanhThu = new JLabel("0");
		lblDoanhThu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnItem4.add(lblDoanhThu);
		
		JPanel pnItem5 = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) pnItem5.getLayout();
		flowLayout_5.setAlignment(FlowLayout.LEFT);
		panel_4.add(pnItem5);
		
		JLabel lblSVnB = new JLabel("Số vốn bỏ ra:");
		lblSVnB.setPreferredSize(new Dimension(300, 30));
		lblSVnB.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnItem5.add(lblSVnB);
		
		lblVon = new JLabel("0");
		lblVon.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnItem5.add(lblVon);
		
		JPanel pnItem6 = new JPanel();
		FlowLayout flowLayout_6 = (FlowLayout) pnItem6.getLayout();
		flowLayout_6.setAlignment(FlowLayout.LEFT);
		panel_4.add(pnItem6);
		
		JLabel lblLiNhunNhn = new JLabel("Lợi nhuận nhận được:");
		lblLiNhunNhn.setPreferredSize(new Dimension(300, 30));
		lblLiNhunNhn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnItem6.add(lblLiNhunNhn);
		
		lblLoiNhuan = new JLabel("0");
		lblLoiNhuan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnItem6.add(lblLoiNhuan);
		
		renderData();
	
		btnThongKe.addActionListener((e) -> {
			long ml=System.currentTimeMillis(); 
	        ml = ml/86400000*86400000;
	        Date now = new Date(ml);
	        
			Date tuNgay = new Date(ml), toiNgay = new Date(ml); // hom nay
			
			if(cboLoaiTK.getSelectedIndex() == 0) { // tuy chinh
	            try {
	                tuNgay = dpTuNgay.getFullDate();
	                toiNgay = dpToiNgay.getFullDate(); 
	            } catch (ParseException e1) {
	                e1.printStackTrace();
	            }
	            
	            if(tuNgay.after(now)){
	                JOptionPane.showMessageDialog(contentPane, "Từ ngày không hợp lệ");
	                return;
	            }
	            
	            if(toiNgay.after(now)){
	                JOptionPane.showMessageDialog(contentPane, "Tới ngày không hợp lệ");
	                return;
	            }
	            
	            if(tuNgay.after(toiNgay)){
	                JOptionPane.showMessageDialog(contentPane, "Ngày không hợp lệ");
	                return;
	            } 
			}else if(cboLoaiTK.getSelectedIndex() == 2){ // hom qua
				tuNgay = Ngay.homQua();
				toiNgay = Ngay.homQua();
			}else if(cboLoaiTK.getSelectedIndex() == 3) { // 7 ngay qua
				tuNgay = Ngay._7NgayQua();
			}else if(cboLoaiTK.getSelectedIndex() == 4) { // 1 thang qua
				tuNgay = Ngay._1ThangQua();
			}else if(cboLoaiTK.getSelectedIndex() == 5) { // 1 nam qua
				tuNgay = Ngay._1NamQua();
			}
			
//			
		    try {
				renderData(tuNgay, toiNgay);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		
		cboLoaiTK.addActionListener((e) -> {
			if(cboLoaiTK.getSelectedIndex() == 0) {
				dpTuNgay.btn.setEnabled(true);
				dpToiNgay.btn.setEnabled(true);
			}else {
				dpTuNgay.btn.setEnabled(false);
				dpToiNgay.btn.setEnabled(false);
			}
		});
	}
	
	public void renderData() throws SQLException {
		ls = new HoaDonDAO().chiTiet();
		
		Map<String, Integer> mpHD = new HashMap<String, Integer>();
		Map<String, Integer> mpKH = new HashMap<String, Integer>();
		soLuongSach = 0;
		soLuongDungCu = 0;
		doanhThu = 0;
		soVon = 0;
		
		ls.forEach(rs -> {
			int donGia = Integer.parseInt(rs.get("donGia"));
			int giaNhap = Integer.parseInt(rs.get("giaNhap"));
			int soLuong = Integer.parseInt(rs.get("soLuong"));
			
			mpHD.put(rs.get("maHD"), 1);
			mpKH.put(rs.get("maKH"), 1);
			if(rs.get("tenLoai").matches("Sách") || rs.get("tenLoai").matches("Truyện"))
				soLuongSach += soLuong;
			else 
				soLuongDungCu += soLuong;
			
			
			doanhThu += donGia * soLuong;
			soVon += giaNhap * soLuong;
		});
		
		lblTongSo.setText(String.valueOf(mpHD.size()));
		lblKH.setText(String.valueOf(mpKH.size()));
		lblSach.setText(String.valueOf(soLuongSach));
		lblDungCu.setText(String.valueOf(soLuongDungCu));
		lblDoanhThu.setText(String.valueOf(doanhThu));
		lblVon.setText(String.valueOf(soVon));
		lblLoiNhuan.setText(String.valueOf(doanhThu - soVon));
		
	}
	
	public void renderData(Date tuNgay, Date toiNgay) throws SQLException {
		ls = new HoaDonDAO().chiTiet(tuNgay, toiNgay);
		
		Map<String, Integer> mpHD = new HashMap<String, Integer>();
		Map<String, Integer> mpKH = new HashMap<String, Integer>();
		soLuongSach = 0;
		soLuongDungCu = 0;
		doanhThu = 0;
		soVon = 0;
		
		ls.forEach(rs -> {
			int donGia = Integer.parseInt(rs.get("donGia"));
			int giaNhap = Integer.parseInt(rs.get("giaNhap"));
			int soLuong = Integer.parseInt(rs.get("soLuong"));
			
			mpHD.put(rs.get("maHD"), 1);
			mpKH.put(rs.get("maKH"), 1);
			if(rs.get("tenLoai").matches("Sách") || rs.get("tenLoai").matches("Truyện"))
				soLuongSach += soLuong;
			else 
				soLuongDungCu += soLuong;
			
			
			doanhThu += donGia * soLuong;
			soVon += giaNhap * soLuong;
		});
		
		lblTongSo.setText(String.valueOf(mpHD.size()));
		lblKH.setText(String.valueOf(mpKH.size()));
		lblSach.setText(String.valueOf(soLuongSach));
		lblDungCu.setText(String.valueOf(soLuongDungCu));
		lblDoanhThu.setText(String.valueOf(doanhThu));
		lblVon.setText(String.valueOf(soVon));
		lblLoiNhuan.setText(String.valueOf(doanhThu - soVon));
	}
	

	public JPanel getContentPane() {
		return this.contentPane;
	}
}
