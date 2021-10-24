package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Popup;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class QuanLy_GUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private QuanLyHieuSach quanLyHieuSach = new QuanLyHieuSach();
//	private TrangChu_GUI trangChuGUI = new TrangChu_GUI();
	private TrangChaoMung_GUI TrangChaoMungGUI = new TrangChaoMung_GUI();
	private ThongKe_GUI thongKeGUI = new ThongKe_GUI();
	private SanPham_GUI sanPhamGUI = new SanPham_GUI();
	private HoaDon_GUI hoaDonGUI = new HoaDon_GUI();
	private KhachHang_GUI khachHangGUI = new KhachHang_GUI();
	private TaoTaiKhoan_GUI taoTaiKhoanGUI = new TaoTaiKhoan_GUI();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLy_GUI frame = new QuanLy_GUI();
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
	public QuanLy_GUI() {
		setTitle("Quản lý hiệu sách");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(0, 0, 1350, 700);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnTrangChu = new JMenu("Trang ch\u1EE7");
		menuBar.add(mnTrangChu);
		
		JMenu mnHoaDon = new JMenu("Hóa đơn");
		menuBar.add(mnHoaDon);
		
		JMenu mnDonDatHang = new JMenu("Đơn đặt hàng");
		menuBar.add(mnDonDatHang);
		
		JMenu mnSanPham = new JMenu("Sản phẩm");
		menuBar.add(mnSanPham);
		
		JMenu mnKhachHang = new JMenu("Khách hàng");
		menuBar.add(mnKhachHang);
		
		JMenuItem mntmQuanLyKH = new JMenuItem("Quản lý khách hàng");
		mnKhachHang.add(mntmQuanLyKH);
		
		JMenuItem mntmMuaHang = new JMenuItem("Mua hàng");
		mnKhachHang.add(mntmMuaHang);
		
		JMenu mnNhanVien = new JMenu("Nhân viên");
		menuBar.add(mnNhanVien);
		
		JMenuItem mntmQuanLyNhanVien = new JMenuItem("Quản lý nhân viên");
		mnNhanVien.add(mntmQuanLyNhanVien);
		
		JMenuItem mntmThongKe = new JMenuItem("Thống kê");
		mnNhanVien.add(mntmThongKe);
		
		JMenuItem mntmTaoTaiKhoan = new JMenuItem("Tạo tài khoản");
		mnNhanVien.add(mntmTaoTaiKhoan);
		
		
		mnTrangChu.addMenuListener(new MenuListener() {
			
			@Override
			public void menuSelected(MenuEvent e) {
				// TODO Auto-generated method stub
				renderMain(TrangChaoMungGUI.getContentPane(), "chaomung");
			}
			
			@Override
			public void menuDeselected(MenuEvent e) {}
			
			@Override
			public void menuCanceled(MenuEvent e) {}
		});
		
		mnHoaDon.addMenuListener(new MenuListener() {
			
			@Override
			public void menuSelected(MenuEvent e) {
				// TODO Auto-generated method stub
				renderMain(hoaDonGUI.getContentPane(), "hoadon");
			}
			
			@Override
			public void menuDeselected(MenuEvent e) {}
			
			@Override
			public void menuCanceled(MenuEvent e) {}
		});
		
		
		mnDonDatHang.addMenuListener(new MenuListener() {
			
			@Override
			public void menuSelected(MenuEvent e) {
				// TODO Auto-generated method stub
//				renderMain(hoaDonGUI.getContentPane(), "hoadon");
			}
			
			@Override
			public void menuDeselected(MenuEvent e) {}
			
			@Override
			public void menuCanceled(MenuEvent e) {}
		});
		
		mnSanPham.addMenuListener(new MenuListener() {
			
			@Override
			public void menuSelected(MenuEvent e) {
				// TODO Auto-generated method stub
				renderMain(sanPhamGUI.getContentPane(), "sanpham");
			}
			
			@Override
			public void menuDeselected(MenuEvent e) {}
			
			@Override
			public void menuCanceled(MenuEvent e) {}
		});
		
		mntmQuanLyKH.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				renderMain(khachHangGUI.getContentPane(), "khachhang");
			}
		});
		
		mntmMuaHang.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				renderMain(muaHang.getContentPane(), "muahang");
				quanLyHieuSach.setVisible(true);
//				trangChuGUI.setVisible(true);
			}
		});
		
		mntmQuanLyNhanVien.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				renderMain(muaHang.getContentPane(), "muahang");
				
			}
		});
		
		mntmThongKe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				renderMain(thongKeGUI.getContentPane(), "thongke");
			}
		});
		
		mntmTaoTaiKhoan.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
//				taoTaiKhoanGUI.main(null);
				taoTaiKhoanGUI.setVisible(true);
				taoTaiKhoanGUI.setLocationRelativeTo(mntmTaoTaiKhoan);
//				renderMain(muaHang.getContentPane(), "muahang");
			}
		});

		
		contentPane = TrangChaoMungGUI.getContentPane();
		renderMain(TrangChaoMungGUI.getContentPane(), "chao mung");
	}
	
	public void renderMain(JPanel contentPane, String tab) {
		this.remove(this.contentPane);
        this.revalidate();
        this.repaint();
        this.contentPane = contentPane;
        this.setContentPane(contentPane);
        this.revalidate();
        this.repaint();
        
        System.out.println("-> "+tab);
		if(tab.equals("thongke")) {
			
		}
		
	}
	
	public JPanel getContentPane() {
		return this.contentPane;
	}
}
