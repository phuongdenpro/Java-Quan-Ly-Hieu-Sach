package GUI;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class QuanLyHieuSach extends JFrame{
	private DangNhap_GUI loginGUI = new DangNhap_GUI();
	private DangKy_GUI dangKyGUI = new DangKy_GUI();
	private TrangChu_GUI trangChuGUI = new TrangChu_GUI();
	private GioHang_GUI gioHangGUI = new GioHang_GUI();
	private QuanLy2_GUI quanLyGUI = new QuanLy2_GUI();
	
	private JPanel contentPane = new JPanel();

	public QuanLyHieuSach() {
		renderGUI();
		setVisible(true);
	}
	
	public void renderGUI() {
		
		this.setTitle("Hiệu sách");
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width, screenSize.height);
		this.setLocationRelativeTo(null);
			
		//		
		this.renderMain(loginGUI.getContentPane(), "dangnhap");
//		contentPane
		
	}
	
	public void renderMain(JPanel contentPane, String tab) {
		this.remove(this.contentPane);
        this.revalidate();
        this.repaint();
        this.contentPane = contentPane;
        this.add(this.contentPane);
        this.revalidate();
        this.repaint();
        
        System.out.print("-> "+tab);
		if(tab.equals("dangnhap")) {
			handleLogin();
			loginGUI.requestFocus();
		}else if(tab.equals("dangky")) {
			handleRegister();
		}else if(tab.equals("trangchu")) {
			handleMenu();
		}else if(tab.equals("giohang")) {
			handleGioHang();
		}else if(tab.equals("quanly")) {
//			handleGioHang();
		}
		
	}
	
	public void handleMenu() {
		trangChuGUI.mntmGioHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				renderMain(gioHangGUI.getContentPane(), "giohang");
			}
		});
		trangChuGUI.mntmQuanLy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quanLyGUI.main(null);
//				setV
//				renderMain(quanLyGUI.getContentPane(), "quanly");
			}
		});
	}
	
	public void handleGioHang() {
		gioHangGUI.btnTroVe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				renderMain(trangChuGUI.getContentPane(), "trangchu");
			}
		});
	}
	
	public void handleLogin() {
		loginGUI.btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("hi");
				renderMain(trangChuGUI.getContentPane(), "trangchu");
			}
		});
		
		loginGUI.btnDangKy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				System.out.println("hi");
				renderMain(dangKyGUI.getContentPane(), "dangky");
			}
		});
	}
	
	public void handleRegister() {
		dangKyGUI.btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				renderMain(loginGUI.getContentPane(), "login");
			}
		});
		
		dangKyGUI.btnDangKy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				renderMain(loginGUI.getContentPane(), "login");
			}
		});
	}
	
	
	
	public static void main(String[] args) {
		QuanLyHieuSach quanLyHieuSach = new QuanLyHieuSach();
//		try{
//            ConnectDB.getInstance().connect();
//        }catch(SQLException e){
//            e.printStackTrace();
//        }
//		KhachHangDAO khachHangDao = new KhachHangDAO();
//		System.out.println("hello world");
//		khachHangDao.getListKhachHang();
		
	}
}
