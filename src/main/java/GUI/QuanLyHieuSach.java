package GUI;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class QuanLyHieuSach extends JFrame{
//	private DangNhap_GUI loginGUI = new DangNhap_GUI();
//	private DangKy_GUI dangKyGUI = new DangKy_GUI();
	private TrangChu_GUI trangChuGUI = new TrangChu_GUI();
	private GioHang_GUI gioHangGUI = new GioHang_GUI();
//	private QuanLy_GUI quanLyGUI = new QuanLy_GUI();
	private TroGiup_GUI troGiupGUI = new TroGiup_GUI();
	
	private JPanel contentPane = new JPanel();
	
	public QuanLyHieuSach() {
		renderGUI();
//		setVisible(true);
		
//		addWindowListener(new WindowAdapter() {
//	        @Override
//	        public void windowClosing(WindowEvent e) {
//	        	if(quanLyGUI.isVisible() == false) {
//	        		System.exit(0);
//	        	}else
//	        		setVisible(false);
//	        }
//	        
//	        @Override
//	        public void windowClosed(WindowEvent e) {
//	        }
//	    });
	}
	
	public void renderGUI() {
		
		this.setTitle("Hiệu sách");
		
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width, screenSize.height);
		this.setLocationRelativeTo(null);
			
		//		
		this.renderMain(trangChuGUI.getContentPane(), "trangchu");
//		contentPane
		handleMenu();
		handleGioHang();
	}
	
	public void renderMain(JPanel contentPane, String tab) {
//		this.remove(this.contentPane);
        this.revalidate();
        this.repaint();
//        this.contentPane = contentPane;
//        this.add(this.contentPane);
        this.setContentPane(contentPane);
        this.revalidate();
        this.repaint();
        
        System.out.println("-> "+tab);
//		if(tab.equals("dangnhap")) {
//			handleLogin();
//			loginGUI.requestFocus();
//		}else if(tab.equals("dangky")) {
//			handleRegister();
//		}else 
		if(tab.equals("trangchu")) {
			
		}else if(tab.equals("giohang")) {
//			handleMenu();
			
		}
//		else if(tab.equals("quanly")) {
//			handleQuanLy();
//		}
		else if(tab.equals("trogiup")) {
			handleTroGiup();
		}
		
	}
	
	public void handleMenu() {
		trangChuGUI.mntmGioHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				renderMain(gioHangGUI.getContentPane(), "giohang");
			}
		});
		trangChuGUI.lblHelp.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				renderMain(troGiupGUI.getContenPane(), "trogiup");
//				System.out.println(quanLyGUI.get());
			}

			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}
			
		});
	}

	
	public void handleTroGiup() {
		troGiupGUI.btnTroVe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				renderMain(trangChuGUI.getContentPane(), "trangchu");
			}
		});
	}
	
	public void handleGioHang() {
		gioHangGUI.btnTroVe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				renderMain(trangChuGUI.getContentPane(), "trangchu");
			}
		});
		
		gioHangGUI.mntmGioHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				renderMain(gioHangGUI.getContentPane(), "giohang");
			}
		});
		
		gioHangGUI.lblHelp.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				renderMain(troGiupGUI.getContenPane(), "trogiup");
			}

			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}
			
		});
	}
	
//	public void handleLogin() {
//		loginGUI.btnDangNhap.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("hi");
//				renderMain(trangChuGUI.getContentPane(), "trangchu");
//			}
//		});
//		
//		loginGUI.btnDangKy.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
////				System.out.println("hi");
//				renderMain(dangKyGUI.getContentPane(), "dangky");
//			}
//		});
//	}
//	
//	public void handleRegister() {
//		dangKyGUI.btnDangNhap.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//				renderMain(loginGUI.getContentPane(), "login");
//			}
//		});
//		
//		dangKyGUI.btnDangKy.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//				renderMain(loginGUI.getContentPane(), "login");
//			}
//		});
//	}
//	
//	public void handleQuanLy() {
//		quanLyGUI.addWindowListener(new WindowAdapter() {
//	        //for closing
//	        @Override
//	        public void windowClosing(WindowEvent e) {
//	            if(isVisible() == false) {
//	            	System.exit(0);
//	            }
//	        }
//	        //for closed
//
//	        @Override
//	        public void windowClosed(WindowEvent e) {
//	        }
//	    });
//	}
	
	
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