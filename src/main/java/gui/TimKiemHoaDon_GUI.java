package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.table.DefaultTableModel;

import dao.HoaDonDAO;
import entity.HoaDon;
import util.Placeholder;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;

public class TimKiemHoaDon_GUI extends JFrame {


	private JTextField txtThongTin;
	JRadioButton rdbtnMaKH,rdbtnTenKH,rdbtnSDT;
	JButton btnTimKiem;
	private JRadioButton rdbtnMaHD;
	private ArrayList<HoaDon> dshd;
	private DefaultTableModel modelDSHD;
	private JTable tblDSHD;
	private ButtonGroup rdbtnGroup;
	private JButton btnLamMoi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimKiemHoaDon_GUI frame = new TimKiemHoaDon_GUI();
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
	public TimKiemHoaDon_GUI() throws SQLException {
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(0, 0, 1300, 700);
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createBevelBorder(BevelBorder.RAISED),
				BorderFactory.createBevelBorder(BevelBorder.LOWERED)));
		
		JPanel pnOut = new JPanel();
		pnOut.setLayout(new BoxLayout(pnOut, BoxLayout.Y_AXIS));
		setContentPane(pnOut);
		
		JPanel pnTitle = new JPanel();
		pnTitle.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel lblTitle = new JLabel("Tìm Kiếm Hóa Đơn");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 25));
		pnTitle.add(lblTitle);
		
		pnOut.add(pnTitle);
		pnOut.add(contentPane);
		
		
		JPanel pnTop = new JPanel();
		pnTop.setPreferredSize(new Dimension(10, 50));
		contentPane.add(pnTop, BorderLayout.NORTH);
		
		JPanel pnTimKiem = new JPanel();
		pnTop.add(pnTimKiem);
		
		JPanel pnThongTin = new JPanel();
		pnThongTin.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		pnTimKiem.add(pnThongTin);
				
		JLabel lblThongtin = new JLabel("nhập thông tin");
		pnThongTin.add(lblThongtin);
		
		txtThongTin = new JTextField();
		new Placeholder().placeholder(txtThongTin, "nhập liệu tìm kiếm");
		txtThongTin.requestFocus();
		txtThongTin.setPreferredSize(new DimensionUIResource(25, 30));
		txtThongTin.setColumns(25);
		pnThongTin.add(txtThongTin);
		
		rdbtnMaHD = new JRadioButton("Mã HĐ");
		rdbtnMaHD.setSelected(true);
		pnTimKiem.add(rdbtnMaHD);
		
		rdbtnMaKH = new JRadioButton("Mã KH");
		pnTimKiem.add(rdbtnMaKH);
		
		rdbtnTenKH = new JRadioButton("Tên KH");
		pnTimKiem.add(rdbtnTenKH);
		
		rdbtnSDT = new JRadioButton("Số điện thoại");
		pnTimKiem.add(rdbtnSDT);
		
		rdbtnGroup = new ButtonGroup();
		rdbtnGroup.add(rdbtnMaHD);
		rdbtnGroup.add(rdbtnSDT);
		rdbtnGroup.add(rdbtnTenKH);
		rdbtnGroup.add(rdbtnMaKH);
		
		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBackground(Color.WHITE);
		btnTimKiem.setPreferredSize(new DimensionUIResource(150, 30));
		btnTimKiem.setIcon(new ImageIcon("data\\images\\search_16.png"));
		pnTimKiem.add(btnTimKiem);
		
		btnLamMoi = new JButton("Làm mới dữ liệu");
		btnLamMoi.setPreferredSize(new Dimension(150, 30));
		btnLamMoi.setBackground(Color.WHITE);
		btnLamMoi.setIcon(new ImageIcon("data/images/refresh.png"));
		pnTimKiem.add(btnLamMoi);
		
		String[] cols = {"Mã hóa đơn", "Mã khách hàng", "Họ tên", "Số điện thoại", "Địa chỉ", "Tổng tiền", "Ngày lập"};
		modelDSHD = new DefaultTableModel(cols, 0);
		tblDSHD = new JTable(modelDSHD);
		JScrollPane sctblDSHD = new JScrollPane(tblDSHD,
								JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
								JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.add(sctblDSHD, BorderLayout.CENTER);
		
		renderData();
		
		btnTimKiem.addActionListener((e) -> {
			
			try {
				String key = "maHD";
				if(rdbtnMaKH.isSelected()) {
					key = "KhachHang.maKH";
				}else if(rdbtnTenKH.isSelected()) {
					key = "KhachHang.HoTen";
				}else if(rdbtnSDT.isSelected()) {
					key = "KhachHang.soDienThoai";
				}
				
				dshd = (ArrayList<HoaDon>) new HoaDonDAO().timKiem(key, txtThongTin.getText());
				renderDataTimKiem();
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

	}
	
	public void renderData() throws SQLException {
		dshd = new HoaDonDAO().getDSHD();
		
		tblDSHD.clearSelection();
		modelDSHD.getDataVector().removeAllElements();
		dshd.forEach(hd -> {
			modelDSHD.addRow(new Object[] {
				hd.getMaHD(), 
				hd.getKhachHang().getMaKh(), 
				hd.getKhachHang().getHoTen(), 
				hd.getKhachHang().getSoDienThoai(),
				hd.getKhachHang().getDiaChi(),
				hd.tinhTongTien(),
				hd.getNgayMua()
			});
		});
		tblDSHD.revalidate();
		tblDSHD.repaint();
	}
	
	public void renderDataTimKiem() throws SQLException {
		tblDSHD.clearSelection();
		
		modelDSHD.getDataVector().removeAllElements();
		
		dshd.forEach(hd -> {
			modelDSHD.addRow(new Object[] {
					hd.getMaHD(), 
					hd.getKhachHang().getMaKh(), 
					hd.getKhachHang().getHoTen(), 
					hd.getKhachHang().getSoDienThoai(),
					hd.getKhachHang().getDiaChi(),
					hd.tinhTongTien(),
					hd.getNgayMua()
				});
		});
		
		tblDSHD.revalidate();
		tblDSHD.repaint();
	}

}
