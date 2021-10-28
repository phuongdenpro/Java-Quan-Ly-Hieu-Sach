package GUI;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import entity.KhachHang;


public class MuaHang extends JFrame{
	private KhachHang khachHang;
	
	private TrangChu_GUI trangChuGUI;
	private GioHang_GUI gioHangGUI;
//	private QuanLy_GUI quanLyGUI = new QuanLy_GUI();
	private TroGiup_GUI troGiupGUI = new TroGiup_GUI();
	
	private JPanel contentPane = new JPanel();
	
	public MuaHang() throws SQLException {
		
		trangChuGUI = new TrangChu_GUI();
		renderGUI();
	}
	
	public MuaHang(KhachHang khachHang) throws SQLException {
		this.khachHang = khachHang;
		trangChuGUI = new TrangChu_GUI(khachHang);
		gioHangGUI = new GioHang_GUI(khachHang);
		renderGUI();
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
        
        
        System.out.println("-> "+tab);
//		if(tab.equals("dangnhap")) {
//			handleLogin();
//			loginGUI.requestFocus();
//		}else if(tab.equals("dangky")) {
//			handleRegister();
//		}else 
		if(tab.equals("trangchu")) {
			
		}else if(tab.equals("giohang")) {
			gioHangGUI.renderData();
		}
//		else if(tab.equals("quanly")) {
//			handleQuanLy();
//		}
		else if(tab.equals("trogiup")) {
			handleTroGiup();
		}
		
		this.setContentPane(contentPane);
        this.revalidate();
        this.repaint();
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
		
		gioHangGUI.btnDatHang.addActionListener(new ActionListener() {
			
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int choose = JOptionPane.showConfirmDialog(contentPane, "Xác nhận đặt hàng ?");
				if(choose != 0) {
					return;
				}
				
				try {
					if(khachHang.xacNhanDatHang()) {
						JOptionPane.showMessageDialog(contentPane, "Đặt hàng thành công");
						renderMain(trangChuGUI.getContentPane(), "trangchu");
					}else {
						JOptionPane.showMessageDialog(contentPane, "Có lỗi xảy ra");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
//		gioHangGUI.mntmGioHang.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				renderMain(gioHangGUI.getContentPane(), "giohang");
//			}
//		});
		
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
	
	
	public static void main(String[] args) throws SQLException {
		MuaHang quanLyHieuSach = new MuaHang();
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