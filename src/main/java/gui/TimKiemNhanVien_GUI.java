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

public class TimKiemNhanVien_GUI extends JFrame {


	JTextField txtThongTin;
	JRadioButton rdbtnMaKH,rdbtnTenKH,rdbtnSDT;
	JButton btnTimKiem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimKiemNhanVien_GUI frame = new TimKiemNhanVien_GUI();
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
	public TimKiemNhanVien_GUI() {
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
		JLabel lblTitle = new JLabel("Tìm Kiếm Nhân Viên");
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
		
		rdbtnMaKH = new JRadioButton("Mã NV");
		pnTimKiem.add(rdbtnMaKH);
		
		rdbtnTenKH = new JRadioButton("Tên NV");
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
		
		JButton btnLamMoiDuLieu = new JButton("Làm mới dữ liệu");
		btnLamMoiDuLieu.setPreferredSize(new Dimension(150, 30));
		btnLamMoiDuLieu.setBackground(Color.WHITE);
		btnLamMoiDuLieu.setIcon(new ImageIcon("data\\images\\refresh.png"));
		pnTimKiem.add(btnLamMoiDuLieu);
		
		String[] cols = {"Mã nhân viên", "Họ và tên", "Số điện thoại", "Địa chỉ"};
		DefaultTableModel dfmTblNhanVien = new DefaultTableModel(cols, 0);
		JTable tblDSNhanVien = new JTable(dfmTblNhanVien);
		JScrollPane sctblDSNhanVien= new JScrollPane(tblDSNhanVien,
								JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
								JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.add(sctblDSNhanVien, BorderLayout.CENTER);
	}

}
