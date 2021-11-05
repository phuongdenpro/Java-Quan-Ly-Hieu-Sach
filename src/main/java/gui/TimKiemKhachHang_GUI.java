package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;

public class TimKiemKhachHang_GUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtTenKh,txtSdt,txtDiaChi;
	private JCheckBox chkTenKh, chkSdt,chkDiaChi;
	private JButton btnTimKiem;
	private DefaultTableModel modelKhachHang;
	private JTable tblKetQua;
	private JTextField txtdiaChi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimKiemKhachHang_GUI frame = new TimKiemKhachHang_GUI();
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1300, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnTieuDe = new JPanel();
		contentPane.add(pnTieuDe, BorderLayout.NORTH);
		
		JLabel lblTieuDe = new JLabel("Tìm kiếm khách hàng");
		lblTieuDe.setFont(new Font("Tahoma", Font.PLAIN, 30));
		pnTieuDe.add(lblTieuDe);
		
		JPanel pnLeft = new JPanel();
		pnLeft.setBorder(new CompoundBorder(
				new BevelBorder(BevelBorder.RAISED, null, null, null, null), 
				new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		contentPane.add(pnLeft, BorderLayout.WEST);
		pnLeft.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel pnThongTin = new JPanel();
		pnLeft.add(pnThongTin);
		pnThongTin.setLayout(new BoxLayout(pnThongTin, BoxLayout.Y_AXIS));
		
		JPanel pnLblThongTin = new JPanel();
		pnLblThongTin.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnThongTin.add(pnLblThongTin);
		
		JLabel lblThongTin = new JLabel("Thông tin tìm kiếm");
		lblThongTin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnLblThongTin.add(lblThongTin);
		
		JPanel pnChuThich = new JPanel();
		FlowLayout fl_pnChuThich = (FlowLayout) pnChuThich.getLayout();
		fl_pnChuThich.setAlignment(FlowLayout.RIGHT);
		pnThongTin.add(pnChuThich);
		
		JLabel lblChuThich = new JLabel("Tìm kiếm chính xác");
		pnChuThich.add(lblChuThich);
		
		JPanel pnTenKh = new JPanel();
		FlowLayout fl_pnTenKh = (FlowLayout) pnTenKh.getLayout();
		fl_pnTenKh.setAlignment(FlowLayout.LEFT);
		pnThongTin.add(pnTenKh);
		
		JLabel lblTenKh = new JLabel("Tên KH");
		lblTenKh.setPreferredSize(new Dimension(80, 14));
		pnTenKh.add(lblTenKh);
		
		txtTenKh = new JTextField();
		txtTenKh.setPreferredSize(new Dimension(200, 20));
		pnTenKh.add(txtTenKh);
		txtTenKh.setColumns(20);
		chkTenKh = new JCheckBox("");
		pnTenKh.add(chkTenKh);
		
		JPanel pnSdt = new JPanel();
		FlowLayout fl_pnSdt = (FlowLayout) pnSdt.getLayout();
		fl_pnSdt.setAlignment(FlowLayout.LEFT);
		pnThongTin.add(pnSdt);
		
		JLabel lblSdt = new JLabel("Số Đt");
		lblSdt.setPreferredSize(new Dimension(80, 14));
		pnSdt.add(lblSdt);
		
		txtSdt = new JTextField();
		txtSdt.setPreferredSize(new Dimension(200, 20));
		txtSdt.setColumns(20);
		pnSdt.add(txtSdt);
		
		chkSdt = new JCheckBox("");
		pnSdt.add(chkSdt);
		
		JPanel pnDiaChi = new JPanel();
		FlowLayout fl_pnDiaChi = (FlowLayout) pnDiaChi.getLayout();
		pnThongTin.add(pnDiaChi);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ");
		lblDiaChi.setPreferredSize(new Dimension(80, 14));
		pnDiaChi.add(lblDiaChi);
		
		txtdiaChi = new JTextField();
		txtdiaChi.setPreferredSize(new Dimension(200, 20));
		pnDiaChi.add(txtdiaChi);
		txtdiaChi.setColumns(20);
		
		chkDiaChi = new JCheckBox("");
		pnDiaChi.add(chkDiaChi);
		
		JPanel pnTim = new JPanel();
		pnThongTin.add(pnTim);
		
		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBackground(Color.WHITE);
		pnTim.add(btnTimKiem);
		
		
		JPanel pnRight = new JPanel();
		pnRight.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		contentPane.add(pnRight, BorderLayout.CENTER);
		pnRight.setLayout(new BorderLayout(0, 0));
		
		JPanel pnRightTop = new JPanel();
		pnRight.add(pnRightTop, BorderLayout.NORTH);
		
		JLabel lblKqTim = new JLabel("kết quả tìm kiếm");
		lblKqTim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnRightTop.add(lblKqTim);
		
		JPanel pnRightBottom = new JPanel();
		pnRightBottom.setBorder(new LineBorder(SystemColor.activeCaption, 2));
		pnRight.add(pnRightBottom);
		
		String[] cols = {"Mã khách hàng", "Tên Khách hàng", "Số điện thoại", "Địa chỉ"};
		modelKhachHang = new DefaultTableModel(cols, 0);
		pnRightBottom.setLayout(new BorderLayout(0, 0));
		tblKetQua = new JTable(modelKhachHang);
		JScrollPane srcTblKetQua = new JScrollPane(tblKetQua);
		pnRightBottom.add(srcTblKetQua);
		

	}

}
