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

public class TimKiemSanPhamKhac_GUI extends JFrame {

	private JPanel contentPane;
	private JButton btnTimKiem, btnRefresh;
	private JTable tblKetQua;
	private ArrayList<KhachHang> dskh;
	private JCheckBox chkNCC;
	private JCheckBox chkLoaiSP;
	private JTextField txtMaSP;
	private JCheckBox chkMaSP;
	private JTextField txtTen;
	private JCheckBox chkTen;
	private DefaultTableModel modelSanPhamKhac;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimKiemSanPhamKhac_GUI frame = new TimKiemSanPhamKhac_GUI();
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
	public TimKiemSanPhamKhac_GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1300, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel pnTieuDe = new JPanel();
		contentPane.add(pnTieuDe, BorderLayout.NORTH);

		JLabel lblTieuDe = new JLabel("Tìm kiếm sản phẩm");
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

		JPanel pnLoaiSP = new JPanel();
		FlowLayout fl_pnLoaiSP = (FlowLayout) pnLoaiSP.getLayout();
		fl_pnLoaiSP.setAlignment(FlowLayout.LEFT);
		pnThongTin.add(pnLoaiSP);

		JLabel lblLoaiSP = new JLabel("Loại sản phẩm: ");
		lblLoaiSP.setPreferredSize(new Dimension(90, 14));
		pnLoaiSP.add(lblLoaiSP);

		JComboBox comboBoxLoai = new JComboBox();
		comboBoxLoai.setPreferredSize(new Dimension(204, 20));
		pnLoaiSP.add(comboBoxLoai);
		chkLoaiSP = new JCheckBox("");
		pnLoaiSP.add(chkLoaiSP);

		JPanel pnMaSP = new JPanel();
		FlowLayout fl_pnMaSP = (FlowLayout) pnMaSP.getLayout();
		fl_pnMaSP.setAlignment(FlowLayout.LEFT);
		pnThongTin.add(pnMaSP);

		JLabel lblMaSach = new JLabel("Mã sản phẩm:");
		lblMaSach.setPreferredSize(new Dimension(90, 14));
		pnMaSP.add(lblMaSach);

		txtMaSP = new JTextField();
		txtMaSP.setPreferredSize(new Dimension(190, 20));
		txtMaSP.setColumns(20);
		pnMaSP.add(txtMaSP);
		chkMaSP = new JCheckBox("");
		pnMaSP.add(chkMaSP);

		JPanel pnTen = new JPanel();
		FlowLayout fl_pnTen = (FlowLayout) pnTen.getLayout();
		fl_pnTen.setAlignment(FlowLayout.LEFT);
		pnThongTin.add(pnTen);

		JLabel lblTen = new JLabel("Tên sản phẩm:");
		lblTen.setPreferredSize(new Dimension(90, 14));
		pnTen.add(lblTen);

		txtTen = new JTextField();
		txtTen.setPreferredSize(new Dimension(200, 20));
		pnTen.add(txtTen);
		txtTen.setColumns(20);

		chkTen = new JCheckBox("");
		pnTen.add(chkTen);

		JPanel pnNCC = new JPanel();
		FlowLayout fl_pnCC = (FlowLayout) pnNCC.getLayout();
		fl_pnCC.setAlignment(FlowLayout.LEFT);
		pnThongTin.add(pnNCC);

		JLabel lblNCC= new JLabel("Nhà cung cấp:");
		lblNCC.setPreferredSize(new Dimension(90, 14));
		pnNCC.add(lblNCC);

		JComboBox comboBoxNCC= new JComboBox();
		comboBoxNCC.setPreferredSize(new Dimension(204, 20));
		pnNCC.add(comboBoxNCC);
		chkNCC = new JCheckBox("");
		pnNCC.add(chkNCC);
		

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

		String[] cols = { "Mã sản phẩm", "Tên sản phẩm", "Nhà cung cấp", "Số lượng", "Giá nhập", "Giá bán",
				"Loại sản phẩm" };
		modelSanPhamKhac = new DefaultTableModel(cols, 0);
		pnRightBottom.setLayout(new BorderLayout(0, 0));
		tblKetQua = new JTable(modelSanPhamKhac);
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
