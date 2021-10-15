package app;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ConnectDB.ConnectDB;
import DAO.KhachHangDAO;
import GUI.GioHang_GUI;
import GUI.Login_GUI;
import GUI.QuanLy2_GUI;
import GUI.Register_GUI;
import GUI.TrangChu_GUI;

public class Main extends JFrame{
	private Login_GUI loginGUI = new Login_GUI();
	private Register_GUI registerGUI = new Register_GUI();
	private TrangChu_GUI trangChuGUI = new TrangChu_GUI();
	private GioHang_GUI gioHangGUI = new GioHang_GUI();
	private QuanLy2_GUI quanLyGUI = new QuanLy2_GUI();
	
	private JPanel contentPane = new JPanel();

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
		}else if(tab.equals("dangky")) {
			handleRegister();
		}else if(tab.equals("trangchu")) {
			handleTrangChu();
		}else if(tab.equals("giohang")) {
			handleGioHang();
		}else if(tab.equals("quanly")) {
//			handleGioHang();
		}
		
	}
	
	public void handleTrangChu() {
		trangChuGUI.mntmGioHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				renderMain(gioHangGUI.getContentPane(), "giohang");
			}
		});
		trangChuGUI.mntmQuanLy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				renderMain(quanLyGUI.getContentPane(), "quanly");
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
				renderMain(registerGUI.getContentPane(), "dangky");
			}
		});
	}
	
	public void handleRegister() {
		registerGUI.btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				renderMain(loginGUI.getContentPane(), "login");
			}
		});
		
		registerGUI.btnDangKy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				renderMain(loginGUI.getContentPane(), "login");
			}
		});
	}
	
	
	
	public static void main(String[] args) {
		Main main = new Main();
		main.setVisible(true);
		main.renderGUI();
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
