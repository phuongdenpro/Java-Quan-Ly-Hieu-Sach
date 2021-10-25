package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;

public class GioHang_GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private int numberOfItem = 5;
	public JButton btnDatHang;
	public JButton btnTroVe;
	public JMenuItem mntmQuanLy;
	public JMenuItem mntmGioHang;
	public JMenuItem mntmDangXuat;
	public JLabel lblHelp;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GioHang_GUI frame = new GioHang_GUI();
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
	public GioHang_GUI() {
		setTitle("Giá»� hÃ ng");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(0, 0, 1300, 700);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width, screenSize.height);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
//		header
		contentPane.add(this.headerGUI(), BorderLayout.NORTH);
		
//		content
		JPanel panelContent = new JPanel();
		
		panelContent.setLayout(new BoxLayout(panelContent, BoxLayout.X_AXIS));
		
		JScrollPane pane = new JScrollPane(panelContent);
		
		Component horizontalStrut = Box.createHorizontalStrut(200);
		panelContent.add(horizontalStrut);
		
		JPanel panel = new JPanel();
		panelContent.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
//<<<<<<< HEAD
		JLabel lblNewLabel = new JLabel("Giá»� hÃ ng");
//=======
		JLabel lblNewLabel1 = new JLabel("Giỏ hàng");
		lblNewLabel1.setBorder(new EmptyBorder(10, 0, 0, 0));
//>>>>>>> 9185ea9f2bd990b1e162d2b82c6db4b6cd1e03b3
		lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel1.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel1.setForeground(new Color(0, 206, 209));
		panel.add(lblNewLabel1, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(10, -500 + numberOfItem*200));
		panel_1.add(panel_2);
		
		JPanel pnItems = new JPanel();
		panel_2.add(pnItems);
		pnItems.setLayout(new GridLayout(0, 1, 0, 5));
		
		pnItems.add(this.itemGUI());
		pnItems.add(this.itemGUI());
		pnItems.add(this.itemGUI());
		pnItems.add(this.itemGUI());
		pnItems.add(this.itemGUI());
		
		JPanel pnThongTin = new JPanel();
		panel_1.add(pnThongTin);
		pnThongTin.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
//<<<<<<< HEAD
		btnDatHang = new JButton("Ä�áº·t hÃ ng");
		btnDatHang.setPreferredSize(new Dimension(150, 23));
//=======
		ImageIcon icon_dathang = new ImageIcon("data/images/shopping-cart32.png");
		btnDatHang = new JButton("Đặt hàng", icon_dathang);
		btnDatHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDatHang.setIconTextGap(8);
		btnDatHang.setBackground(Color.WHITE);
		btnDatHang.setPreferredSize(new Dimension(200, 40));
//>>>>>>> 9185ea9f2bd990b1e162d2b82c6db4b6cd1e03b3
		pnThongTin.add(btnDatHang);
		btnDatHang.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(null, "XÃ¡c nháº­n Ä‘áº·t hÃ ng ?");
			}
		});
		
//<<<<<<< HEAD
		btnTroVe = new JButton("Tiáº¿p tá»¥c mua hÃ ng");
		btnTroVe.setPreferredSize(new Dimension(150, 23));
//=======
		ImageIcon icon_tieptucmuahang = new ImageIcon("data/images/cart.png");
		btnTroVe = new JButton("Tiếp tục mua hàng", icon_tieptucmuahang);
		btnTroVe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTroVe.setIconTextGap(8);
		btnTroVe.setBackground(Color.WHITE);
		btnTroVe.setPreferredSize(new Dimension(250, 40));
//>>>>>>> 9185ea9f2bd990b1e162d2b82c6db4b6cd1e03b3
		pnThongTin.add(btnTroVe);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(200);
		panelContent.add(horizontalStrut_1);
		contentPane.add(pane);
	}
	
	public JPanel headerGUI() {
		JPanel panelHeader = new JPanel();
		panelHeader.setBackground(new Color(255, 255, 255));
		panelHeader.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panelHeader.add(panel);
		
		JLabel lblNewLabel_2 = new JLabel("Hiệu Sách NPB");
		lblNewLabel_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblNewLabel_2.setAlignmentX(1.0f);
		panel.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBackground(new Color(255, 255, 255));
		panelHeader.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(20);
		
		JButton btnNewButton = new JButton("T\u00ECm ki\u1EBFm");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setPreferredSize(new Dimension(100, 19));
		panel_1.add(btnNewButton);
		
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel_3.setBackground(Color.WHITE);
		panelHeader.add(panel_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_3.add(panel_2);
		
		ImageIcon icon_help = new ImageIcon("data/images/question.png");
		lblHelp = new JLabel("trợ giúp        ");
		lblHelp.setIcon(icon_help);
		panel_2.add(lblHelp);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		menuBar.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel_3.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Xin chào: Trần Văn Nhân");
		menuBar.add(mnNewMenu);
		
		ImageIcon icon_quanly = new ImageIcon("data/image/businessman.png");
		mntmQuanLy = new JMenuItem("Đi tới trang quản lý");
		mntmQuanLy.setIcon(icon_quanly);
		mnNewMenu.add(mntmQuanLy);
		
		mntmGioHang = new JMenuItem("Giỏ hàng");
		mntmGioHang.setIcon(icon_quanly);
		mnNewMenu.add(mntmGioHang);
		
		mntmDangXuat = new JMenuItem("Đăng xuất");
		mntmDangXuat.setIcon(icon_quanly);
		mnNewMenu.add(mntmDangXuat);
		
		return panelHeader;
	}
	
	public JPanel itemGUI() {
		JPanel pnItem = new JPanel();
		pnItem.setPreferredSize(new Dimension(700, 100));
		pnItem.setBackground(Color.WHITE);
		pnItem.setLayout(new GridLayout(0, 4, 0, 0));
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(Color.WHITE);
		pnItem.add(panel_2_1);
		panel_2_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lbIcon = new JLabel();
		lbIcon.setAlignmentX(0.5f);
		panel_2_1.add(lbIcon);
		ImageIcon imageProduct = new ImageIcon("data/product/conan_tap_1.jpg");
		imageProduct = TrangChu_GUI.resizeIcon(imageProduct, new Dimension(150, 90));
		lbIcon.setIcon(imageProduct);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		pnItem.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Conan - táº­p 1");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		panel_3.add(lblNewLabel_1);
		
		JPanel pnDonGia = new JPanel();
		pnDonGia.setBackground(Color.WHITE);
		panel_3.add(pnDonGia);
		pnDonGia.setLayout(new BoxLayout(pnDonGia, BoxLayout.X_AXIS));
		
		JLabel lblDonGia = new JLabel("Ä�Æ¡n giÃ¡:    ");
		lblDonGia.setBackground(Color.WHITE);
		pnDonGia.add(lblDonGia);
		
		JLabel donGia = new JLabel("14.000Ä‘");
//		lblTongTien.setForeground(new Color(0, 206, 209));
		donGia.setBackground(Color.WHITE);
		pnDonGia.add(donGia);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.WHITE);
		panel_3.add(panel_1_1);
		panel_1_1.setLayout(new BoxLayout(panel_1_1, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel_3 = new JLabel("Sá»‘ lÆ°á»£ng:  ");
		panel_1_1.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setText("1");
		textField.setColumns(10);
		panel_1_1.add(textField);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_3.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel_4 = new JLabel("Tá»•ng tiá»�n:  ");
		lblNewLabel_4.setBackground(Color.WHITE);
		panel_4.add(lblNewLabel_4);
		
		JLabel lblTongTien = new JLabel("14.000Ä‘");
		lblTongTien.setForeground(new Color(0, 206, 209));
		lblTongTien.setBackground(Color.WHITE);
		panel_4.add(lblTongTien);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		pnItem.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		pnItem.add(panel_6);
		
//<<<<<<< HEAD
		JButton btnNewButton = new JButton("XÃ³a");
//=======
		ImageIcon icon_delete = new ImageIcon("data/images/trash.png");
		JButton btnNewButton1 = new JButton("Xóa", icon_delete);
		btnNewButton1.setBackground(Color.WHITE);
//>>>>>>> 9185ea9f2bd990b1e162d2b82c6db4b6cd1e03b3
		btnNewButton1.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		btnNewButton1.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_6.add(btnNewButton1);
		
		return pnItem;
	}
	
	public JPanel getContentPane() {
		return this.contentPane;
	}
}
