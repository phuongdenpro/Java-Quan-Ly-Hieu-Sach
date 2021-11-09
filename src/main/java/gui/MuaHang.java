package gui;

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

import dao.DonDatHangDAO;
import dao.KhachHangDAO;
import entity.KhachHang;


public class MuaHang extends JFrame{
	private KhachHang khachHang;
	private boolean isPrimary = false;
	private TrangChu_GUI trangChuGUI = new TrangChu_GUI();;
	private GioHang_GUI gioHangGUI = new GioHang_GUI();
	private TimKiemTrangMuaHang_GUI timKiemGUI = new TimKiemTrangMuaHang_GUI();
//	private QuanLy_GUI quanLyGUI = new QuanLy_GUI();
	private TroGiup_GUI troGiupGUI = new TroGiup_GUI();
	
	private JPanel contentPane = new JPanel();
	
	public MuaHang() throws SQLException {
		
		trangChuGUI.setKhachHang(new KhachHangDAO().getKhachHang(1));
		renderGUI();
	}
	
	public MuaHang(KhachHang khachHang) throws SQLException {
		this.khachHang = khachHang;
		trangChuGUI = new TrangChu_GUI(khachHang);
		gioHangGUI = new GioHang_GUI(khachHang);
		timKiemGUI.setKhachHang(khachHang);
		renderGUI();
	}
	
	public MuaHang(KhachHang khachHang, boolean isPrimary) throws SQLException {
		this.khachHang = khachHang;
		trangChuGUI = new TrangChu_GUI(khachHang);
		gioHangGUI = new GioHang_GUI(khachHang);
		timKiemGUI.setKhachHang(khachHang);
		renderGUI();
		this.isPrimary = isPrimary;
		if(isPrimary) {
			setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
	}
	
	public void renderGUI() throws SQLException {
		
		this.setTitle("Hiệu sách");
		
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width, screenSize.height);
		this.setLocationRelativeTo(null);
			
		//		
		this.renderMain(trangChuGUI.getContentPane(), "trangchu");
		trangChuGUI.renderData();
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
		trangChuGUI.mntmDangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isPrimary == false)
					setVisible(false);
				else
					System.exit(0);
			}
		});
		trangChuGUI.btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					timKiemGUI.renderData(trangChuGUI.txtTimKiem.getText());
					if(timKiemGUI.dssp.size() == 0) {
						JOptionPane.showMessageDialog(contentPane, "Không tìm thấy sản phẩm phù hợp");
						return;
					}
					timKiemGUI.setVisible(true);
					timKiemGUI.setLocationRelativeTo(contentPane);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
		gioHangGUI.mntmDangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isPrimary == false)
					setVisible(false);
				else
					System.exit(0);
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
					DonDatHangDAO donDatHangDao = new DonDatHangDAO();
					if(donDatHangDao.xacNhanDatHang(khachHang.getMaKh())) {
						JOptionPane.showMessageDialog(contentPane, "Đặt hàng thành công");
						renderMain(trangChuGUI.getContentPane(), "trangchu");
					}else {
						JOptionPane.showMessageDialog(contentPane, donDatHangDao.getError());
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
	
	public JPanel getContentPane() {
		return contentPane;
	}
	
	public static void main(String[] args) throws SQLException {
		MuaHang quanLyHieuSach = new MuaHang();
	}
}