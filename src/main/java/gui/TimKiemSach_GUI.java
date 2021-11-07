package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.KhachHangDAO;
import entity.KhachHang;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class TimKiemSach_GUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtTenKh, txtSdt, txtdiaChi;
	private JCheckBox chkTenKh, chkSdt, chkDiaChi;
	private JButton btnTimKiem, btnRefresh;
	private DefaultTableModel modelKhachHang;
	private JTable tblKetQua;
	private ArrayList<KhachHang> dskh;
	private JTextField txtLoaiSach;
	private JCheckBox chkLoaiSach;
	private JTextField txtMaSach;
	private JCheckBox chkMaSach;
	private JTextField txtTieu;
	private JCheckBox chkTieu;
	private JTextField txtNXB;
	private JCheckBox chkNXB;

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
	public TimKiemSach_GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1300, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel pnTieuDe = new JPanel();
		contentPane.add(pnTieuDe, BorderLayout.NORTH);

		JLabel lblTieuDe = new JLabel("Tìm kiếm sách");
		lblTieuDe.setFont(new Font("Tahoma", Font.PLAIN, 30));
		pnTieuDe.add(lblTieuDe);

		JPanel pnLeft = new JPanel();
		pnLeft.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null),
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

		JPanel pnLoaiSach = new JPanel();
		FlowLayout fl_pnLoaiSach = (FlowLayout) pnLoaiSach.getLayout();
		fl_pnLoaiSach.setAlignment(FlowLayout.LEFT);
		pnThongTin.add(pnLoaiSach);

		JLabel lblLoaiSach = new JLabel("Loại sách: ");
		lblLoaiSach.setPreferredSize(new Dimension(80, 14));
		pnLoaiSach.add(lblLoaiSach);

		JComboBox comboBoxLoai = new JComboBox();
		comboBoxLoai.setPreferredSize(new Dimension(202, 20));
		pnLoaiSach.add(comboBoxLoai);
		chkLoaiSach = new JCheckBox("");
		pnLoaiSach.add(chkLoaiSach);

		JPanel pnMaSach = new JPanel();
		FlowLayout fl_pnMaSach = (FlowLayout) pnMaSach.getLayout();
		fl_pnMaSach.setAlignment(FlowLayout.LEFT);
		pnThongTin.add(pnMaSach);

		JLabel lblMaSach = new JLabel("Mã sách:");
		lblMaSach.setPreferredSize(new Dimension(80, 14));
		pnMaSach.add(lblMaSach);

		txtMaSach = new JTextField();
		txtMaSach.setPreferredSize(new Dimension(200, 20));
		txtMaSach.setColumns(20);
		pnMaSach.add(txtMaSach);
		chkMaSach = new JCheckBox("");
		pnMaSach.add(chkMaSach);

		JPanel pnTieu = new JPanel();
		FlowLayout fl_pnTieuDe = (FlowLayout) pnTieu.getLayout();
		pnThongTin.add(pnTieu);

		JLabel lblTieu = new JLabel("Tiêu đề");
		lblTieu.setPreferredSize(new Dimension(80, 14));
		pnTieu.add(lblTieu);

		txtTieu = new JTextField();
		txtTieu.setPreferredSize(new Dimension(200, 20));
		pnTieu.add(txtTieu);
		txtTieu.setColumns(20);

		chkTieu = new JCheckBox("");
		pnTieu.add(chkTieu);

		JPanel pnNXB = new JPanel();
		FlowLayout fl_pnNXB = (FlowLayout) pnNXB.getLayout();
		pnThongTin.add(pnNXB);

		JLabel lblNXB = new JLabel("Nhà xuất bản:");
		lblNXB.setPreferredSize(new Dimension(80, 14));
		pnNXB.add(lblNXB);

		txtNXB = new JTextField();
		txtNXB.setPreferredSize(new Dimension(200, 20));
		pnNXB.add(txtNXB);
		txtNXB.setColumns(20);

		chkNXB = new JCheckBox("");
		pnNXB.add(chkNXB);

		JPanel pnTim = new JPanel();
		pnTim.setLayout(new FlowLayout());
		pnThongTin.add(pnTim);

		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBackground(Color.WHITE);
		btnRefresh = new JButton("Làm mới");
		btnRefresh.setBackground(Color.WHITE);

		pnTim.add(btnTimKiem);
		pnTim.add(btnRefresh);

		JPanel pnRight = new JPanel();
		pnRight.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null),
				new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		contentPane.add(pnRight, BorderLayout.CENTER);
		pnRight.setLayout(new BorderLayout(0, 0));

		JPanel pnRightTop = new JPanel();
		pnRight.add(pnRightTop, BorderLayout.NORTH);

		JLabel lblKqTim = new JLabel("Kết quả tìm kiếm");
		lblKqTim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnRightTop.add(lblKqTim);

		JPanel pnRightBottom = new JPanel();
		pnRightBottom.setBorder(new LineBorder(SystemColor.activeCaption, 2));
		pnRight.add(pnRightBottom);

		String[] cols = { "Mã sách", "Tên sách", "Nhà xuất bản", "Số lượng", "Giá nhập", "Giá bán",
				"Loại Sách" };
		modelKhachHang = new DefaultTableModel(cols, 0);
		pnRightBottom.setLayout(new BorderLayout(0, 0));
		tblKetQua = new JTable(modelKhachHang);
		JScrollPane srcTblKetQua = new JScrollPane(tblKetQua);
		pnRightBottom.add(srcTblKetQua);

		addEvents();
	}

	private void addEvents() {
		// TODO Auto-generated method stub
		btnTimKiem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}	
		});
	}

	private void renderDataTimKiem(ArrayList<KhachHang> dskh) {
		// TODO Auto-generated method stub
	}

}
