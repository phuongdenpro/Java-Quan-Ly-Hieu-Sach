package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.KhachHangDAO;
import dao.SanPhamDAO;
import entity.KhachHang;
import entity.SanPham;
import util.Currency;
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
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

public class ThongKeKHMuaNhieuNhat extends JFrame {

	private int soLuongSP = 0;
	
	private JPanel contentPane;
	private JTextField txtTuNgay;
	private JTextField txtToiNgay;
	private Map<SanPham, Integer> dssp;
	private DefaultTableModel model;
	private JTable table;
	DialogDatePicker f = new DialogDatePicker();
	private kDatePicker dpTuNgay;
	private kDatePicker dpToiNgay;
	private JComboBox comboBox;
	private JComboBox cboLoaiTK;

	private JLabel lblTongSo;

	private JLabel lblTongSoTien;

	private int tongSoLanMua;

	private int tongSoTien;

	private DefaultComboBoxModel<Integer> modelLimit;

	private JComboBox cboLimit;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThongKeKHMuaNhieuNhat frame = new ThongKeKHMuaNhieuNhat();
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
	public ThongKeKHMuaNhieuNhat() throws SQLException {
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
		
		JLabel lblNewLabel_2 = new JLabel("Thống kê khách hàng mua nhiều nhất");
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
		
		JPanel panel_6 = new JPanel();
		panel_2.add(panel_6);
		
		JLabel lblSoLuongToiDa = new JLabel("Số lượng KH tối đa: ");
		panel_6.add(lblSoLuongToiDa);
		
		modelLimit = new DefaultComboBoxModel<Integer>();
		cboLimit = new JComboBox(modelLimit);
		cboLimit.setEditable(true);
		panel_6.add(cboLimit);
		modelLimit.addElement(10);
		modelLimit.addElement(25);
		modelLimit.addElement(50);
		modelLimit.addElement(100);
		modelLimit.addElement(500);
		
		JButton btnThongKe = new JButton("Thống kê", new ImageIcon("data/images/statistics.png"));

		btnThongKe.setBackground(Color.WHITE);
		panel_2.add(btnThongKe);
		
		JButton btnLamMoi = new JButton("Làm mới dữ liệu", new ImageIcon("data/images/refresh.png"));
		btnLamMoi.setBackground(Color.WHITE);
		panel_2.add(btnLamMoi);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		panel_1.setLayout(new BorderLayout(0, 0));
		
		String[] cols = {"STT", "Mã khách hàng", "Tên khách hàng", "Số điện thoại", "Địa chỉ", "Số lần mua hàng", "Số tiền mua hàng"};
		model = new DefaultTableModel(cols, 0);
		table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		panel_1.add(scrollPane);
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4, BorderLayout.SOUTH);
		
		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5);
		
		JLabel lblTong = new JLabel("Tổng số lần mua hàng: ");
		lblTong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_5.add(lblTong);
		
		lblTongSo = new JLabel("0");
		lblTongSo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_5.add(lblTongSo);
		
		JPanel panel_5_1 = new JPanel();
		panel_4.add(panel_5_1);
		
		JLabel lblTngSTin = new JLabel("Tổng số tiền mua hàng: ");
		lblTngSTin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_5_1.add(lblTngSTin);
		
		lblTongSoTien = new JLabel("0");
		lblTongSoTien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_5_1.add(lblTongSoTien);
		
		renderData();
	
		btnThongKe.addActionListener((e) -> {
			long ml=System.currentTimeMillis(); 
//	        ml = ml/86400000*86400000;
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
			
			if(!String.valueOf(cboLimit.getSelectedItem()).matches("^\\d+$")) {
				JOptionPane.showMessageDialog(contentPane, "Số lượng khách hàng tối đa không hợp lệ");
				return;
			}
//			
		    try {
				renderData(tuNgay, toiNgay);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		btnLamMoi.addActionListener((e) -> {
			try {
				renderData();
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
		int limit = Integer.parseInt(String.valueOf(cboLimit.getSelectedItem()));
		
		Map<KhachHang, Map<String, Integer>> dskh = new KhachHangDAO().thongKeKHTN(Ngay.homNay(), Ngay.homNay(), limit, 50000);
		
		table.clearSelection();
		model.getDataVector().removeAllElements();
		
		tongSoLanMua = 0;
		tongSoTien = 0;
		AtomicInteger stt = new AtomicInteger(1);
		dskh.forEach((kh, mp) -> {
			model.addRow(new Object[] {
				stt.get(),
				kh.getMaKh(),
				kh.getHoTen(),
				kh.getSoDienThoai(),
				kh.getDiaChi(),
				mp.get("soLanMuaHang"),
				new Currency(mp.get("tongTien")).toString(),
			});
			stt.set(stt.get()+1);
			tongSoLanMua += mp.get("soLanMuaHang");
			tongSoTien += mp.get("tongTien");
		});
		lblTongSo.setText(String.valueOf(tongSoLanMua));
		lblTongSoTien.setText(new Currency(tongSoTien).toString());
		table.revalidate();
		table.repaint();
	}
	
	public void renderData(Date tuNgay, Date toiNgay) throws SQLException {
		int limit = Integer.parseInt(String.valueOf(cboLimit.getSelectedItem()));
		long soNgay = Ngay.tinhKhoangNgay(tuNgay, toiNgay);
		int minTongTien = 0;
		if(soNgay <= 3) {
			minTongTien = 100000; 
		}else if(soNgay <= 7)
			minTongTien = 200000;
		else if(soNgay <= 15)
			minTongTien = 500000;
		else if(soNgay <= 30)
			minTongTien = 1000000;
		else if(soNgay <= 100)
			minTongTien = 1500000;
		else
			minTongTien = 2000000;
		
		System.out.println(tuNgay + " "+ toiNgay);
		Map<KhachHang, Map<String, Integer>> dskh = new KhachHangDAO().thongKeKHTN(tuNgay, toiNgay, limit, minTongTien);
		
		table.clearSelection();
		model.getDataVector().removeAllElements();
		
		tongSoLanMua = 0;
		tongSoTien = 0;
		AtomicInteger stt = new AtomicInteger(1);
		dskh.forEach((kh, mp) -> {
			model.addRow(new Object[] {
				stt.get(),
				kh.getMaKh(),
				kh.getHoTen(),
				kh.getSoDienThoai(),
				kh.getDiaChi(),
				mp.get("soLanMuaHang"),
				new Currency(mp.get("tongTien")).toString(),
			});
			stt.set(stt.get()+1);
			tongSoLanMua += mp.get("soLanMuaHang");
			tongSoTien += mp.get("tongTien");
		});
		lblTongSo.setText(String.valueOf(tongSoLanMua));
		lblTongSoTien.setText(new Currency(tongSoTien).toString());
		table.revalidate();
		table.repaint();
	}
	

	public JPanel getContentPane() {
		return this.contentPane;
	}
}
