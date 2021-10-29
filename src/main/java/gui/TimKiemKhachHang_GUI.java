package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.table.DefaultTableModel;

import util.Placeholder;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

public class TimKiemKhachHang_GUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtThongTin;
	JRadioButton rdbtnMaKH,rdbtnTenKH,rdbtnSDT;
	JButton btnTimKiem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimKiemSach_GUI frame = new TimKiemSach_GUI();
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
	public TimKiemKhachHang_GUI() {
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(0, 0, 1300, 700);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createBevelBorder(BevelBorder.RAISED),
				BorderFactory.createBevelBorder(BevelBorder.LOWERED)));
		
		JPanel pnTop = new JPanel();
		pnTop.setPreferredSize(new Dimension(10, 50));
		contentPane.add(pnTop, BorderLayout.NORTH);
		
		JPanel pnTimKiem = new JPanel();
		pnTop.add(pnTimKiem);
		
		txtThongTin = new JTextField();
		new Placeholder().placeholder(txtThongTin, "nhập liệu tìm kiếm");
		txtThongTin.requestFocus();
		txtThongTin.setPreferredSize(new DimensionUIResource(25, 30));
		pnTimKiem.add(txtThongTin);
		txtThongTin.setColumns(25);
		
		rdbtnMaKH = new JRadioButton("Mã KH");
		pnTimKiem.add(rdbtnMaKH);
		
		rdbtnTenKH = new JRadioButton("Tên KH");
		pnTimKiem.add(rdbtnTenKH);
		
		rdbtnSDT = new JRadioButton("Số điện thoại");
		pnTimKiem.add(rdbtnSDT);
		
		ButtonGroup rdbtnGroup = new ButtonGroup();
		rdbtnGroup.add(rdbtnSDT);
		rdbtnGroup.add(rdbtnTenKH);
		rdbtnGroup.add(rdbtnMaKH);
		
		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBackground(Color.WHITE);
		btnTimKiem.setPreferredSize(new DimensionUIResource(100, 30));
		btnTimKiem.setIcon(new ImageIcon("data\\images\\search_16.png"));
		pnTimKiem.add(btnTimKiem);
		
		String[] cols = {"Mã khách hàng", "Họ tên", "Số điện thoại", "Địa chỉ"};
		DefaultTableModel dfmTblKhachHang = new DefaultTableModel(cols, 0);
		JTable tblDSKhachHang = new JTable(dfmTblKhachHang);
		JScrollPane sctblDSKhachHang = new JScrollPane(tblDSKhachHang,
								JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
								JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.add(sctblDSKhachHang, BorderLayout.CENTER);
	}

}
