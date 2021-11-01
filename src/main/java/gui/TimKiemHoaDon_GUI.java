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

public class TimKiemHoaDon_GUI extends JFrame {


	private JTextField txtThongTin;
	JRadioButton rdbtnMaKH,rdbtnTenKH,rdbtnSDT;
	JButton btnTimKiem;
	private JRadioButton rdbtnMaHD;

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
	 */
	public TimKiemHoaDon_GUI() {
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
		pnTimKiem.add(rdbtnMaHD);
		
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
		btnTimKiem.setPreferredSize(new DimensionUIResource(150, 30));
		btnTimKiem.setIcon(new ImageIcon("data\\images\\search_16.png"));
		pnTimKiem.add(btnTimKiem);
		
		String[] cols = {"Mã khách hàng", "Họ tên", "Số điện thoại", "Địa chỉ"};
		DefaultTableModel dfmTblKhachHang = new DefaultTableModel(cols, 0);
		JTable tblDSHD = new JTable(dfmTblKhachHang);
		JScrollPane sctblDSHD = new JScrollPane(tblDSHD,
								JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
								JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.add(sctblDSHD, BorderLayout.CENTER);
	}

}
