package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

import dao.LoaiSanPhamDAO;
import dao.SanPhamDAO;
import entity.SanPham;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JRadioButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

public class TimKiemSanPhamKhac_GUI extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private JTextField textField;
	private JTextComponent lblTimKiem;
	private JTextField textFieldTim;
	private JLabel lbltieude;
	private DefaultTableModel modelDSSanPham;
	private JTable tblDSSanPham;
	private ArrayList<SanPham> dsssp;
	private List<SanPham> dssptim;
	private boolean isTimKiem = false;
	private SanPhamDAO sanphamDAO;
	private LoaiSanPhamDAO loaiDAO;

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
	 * @throws SQLException 
	 */
	public TimKiemSanPhamKhac_GUI() throws SQLException {
		setResizable(false);
		setTitle("Tìm kiếm sản phẩm khác");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(0, 0, 1300, 700);

		sanphamDAO = new SanPhamDAO();
		loaiDAO = new LoaiSanPhamDAO();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		ImageIcon icon1 = new ImageIcon("data/images/timkiem.png");
		ImageIcon icon2 = new ImageIcon("data/images/search_16.png");

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 80));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JPanel pannel_2 = new JPanel();
		lbltieude = new JLabel("TÌM KIẾM SẢN PHẨM");
		lbltieude.setFont(new Font("Tahoma", Font.BOLD, 20));
		pannel_2.add(lbltieude);
		JPanel panel_1 = new JPanel();
		panel.add(pannel_2);
		panel.add(panel_1);

		JLabel lblTimKiem = new JLabel();
		lblTimKiem.setText("Search: ");
		lblTimKiem.setIcon(icon1);
		panel_1.add(lblTimKiem);

		textFieldTim = new JTextField();
		panel_1.add(textFieldTim);
		textFieldTim.setColumns(25);

		JRadioButton rdbtnMaSanPham = new JRadioButton("Mã sản phẩm");
		panel_1.add(rdbtnMaSanPham);

		JRadioButton rdbtnTenSanPham = new JRadioButton("Tên sản phẩm");
		panel_1.add(rdbtnTenSanPham);

		JRadioButton rdbtnLoaiSanPham = new JRadioButton("Loại sản phẩm");
		panel_1.add(rdbtnLoaiSanPham);
		
		JRadioButton rdbtnNhaCC = new JRadioButton("Nhà cung cấp");
		panel_1.add(rdbtnNhaCC);

		ButtonGroup rdbtnGroup = new ButtonGroup();
		rdbtnGroup.add(rdbtnMaSanPham);
		rdbtnGroup.add(rdbtnTenSanPham);
		rdbtnGroup.add(rdbtnLoaiSanPham);
		rdbtnGroup.add(rdbtnNhaCC);

		rdbtnMaSanPham.setSelected(true);
		JButton btnNewButton = new JButton("Tìm kiếm");
		btnNewButton.setIcon(icon2);
		btnNewButton.setBackground(Color.WHITE);
		panel_1.add(btnNewButton);

		JButton btnLamMoiDuLieu = new JButton("Làm mới dữ liệu");
		btnLamMoiDuLieu.setPreferredSize(new Dimension(150, 25));
		btnLamMoiDuLieu.setBackground(Color.WHITE);
		btnLamMoiDuLieu.setIcon(new ImageIcon("data\\images\\refresh.png"));
		panel_1.add(btnLamMoiDuLieu);

		String[] cols = { "Mã sản phẩm", "Tên sản phẩm", "Nhà cung cấp", "Số lượng", "Giá nhập", "Giá bán",
				"Loại sản phẩm" };
		modelDSSanPham = new DefaultTableModel(cols, 0);
		tblDSSanPham = new JTable(modelDSSanPham);
		JScrollPane scrollPane = new JScrollPane(tblDSSanPham);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		try {
			renderData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (textFieldTim.getText().equals("")) {
					JOptionPane.showMessageDialog(contentPane, "Cần nhập dữ liệu sản phẩm cần tìm", "Cảnh báo",
							JOptionPane.WARNING_MESSAGE);
					textFieldTim.requestFocus();
				} else {
					try {
						String key = "";
						if (rdbtnMaSanPham.isSelected()) {
							key = "SanPham.MaSP";
						} else if (rdbtnTenSanPham.isSelected()) {
							key = "SanPham.TenSP";
						} else if (rdbtnNhaCC.isSelected()) {
							key = "NhaCungCap.TenNCC";
						} else if (rdbtnLoaiSanPham.isSelected()) {
							key = "LoaiSanPham.TenLoai";
						}
						dssptim = sanphamDAO.timKiemSanPhamKhac(key, textFieldTim.getText());
						renderDataTimKiem();
						isTimKiem = true;
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}

		});
		btnLamMoiDuLieu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					tblDSSanPham.clearSelection();

					modelDSSanPham.getDataVector().removeAllElements();
					renderData();
					isTimKiem = false;
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		tblDSSanPham.addMouseListener(this);
	}

	public void renderData() throws SQLException {
		// modelDSSach.getDataVector().removeAllElements();
		dsssp = new SanPhamDAO().getListSanPhamKhac();

		dsssp.forEach(sp -> {
			modelDSSanPham.addRow(new Object[] { sp.getMaSp(), sp.getTenSp(), sp.getNhaCungCap().getTenNCC(),
					sp.getSoLuong(), sp.getGiaNhap(), sp.getGiaSp(), sp.getLoaiSanPham().getTenLoai() });
		});
	}

	public void renderDataTimKiem() throws SQLException {
		tblDSSanPham.clearSelection();

		modelDSSanPham.getDataVector().removeAllElements();

		dssptim.forEach(sp -> {
			modelDSSanPham.addRow(new Object[] { sp.getMaSp(), sp.getTenSp(), sp.getNhaCungCap().getTenNCC(),
					sp.getSoLuong(), sp.getGiaNhap(), sp.getGiaSp(), sp.getLoaiSanPham().getTenLoai() });
		});

		tblDSSanPham.revalidate();
		tblDSSanPham.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
