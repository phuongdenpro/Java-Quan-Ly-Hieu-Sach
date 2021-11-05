package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import entity.LoaiSanPham;

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

public class TimKiemDanhMucSanPham_GUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private JTextComponent lblTimKiem;
	private JTextField textFieldTim;
	private JLabel lbltieude;
	private ArrayList<LoaiSanPham> dsloai;
	private List<LoaiSanPham> dsloaitim;
	private DefaultTableModel modelDSLoai;
	private JTable tblDSLoai;
	private boolean isTimKiem;
	private LoaiSanPhamDAO loaiDAO;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimKiemDanhMucSanPham_GUI frame = new TimKiemDanhMucSanPham_GUI();
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
	public TimKiemDanhMucSanPham_GUI() throws SQLException {
		loaiDAO = new LoaiSanPhamDAO();
		setResizable(false);
		setTitle("Tìm kiếm loại sản phẩm");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(0, 0, 1300, 700);

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
		lbltieude = new JLabel("TÌM KIẾM DANH MỤC SẢN PHẨM");
		lbltieude.setFont(new Font("Tahoma", Font.BOLD, 20));
		pannel_2.add(lbltieude);
		JPanel panel_1 = new JPanel();
		panel.add(pannel_2);
		panel.add(panel_1);
//		JPanel panel_1 = new JPanel();
//		panel.add(panel_1);
		JLabel lblTimKiem = new JLabel();
		lblTimKiem.setText("Search: ");
		lblTimKiem.setIcon(icon1);
		panel_1.add(lblTimKiem);

		textFieldTim = new JTextField();
		panel_1.add(textFieldTim);
		textFieldTim.setColumns(25);

		JRadioButton rdbtnMaLoai = new JRadioButton("Mã Loại");
		panel_1.add(rdbtnMaLoai);

		JRadioButton rdbtnTenLoai = new JRadioButton("Tên Loại");
		panel_1.add(rdbtnTenLoai);

		;

		ButtonGroup rdbtnGroup = new ButtonGroup();
		rdbtnGroup.add(rdbtnMaLoai);
		rdbtnGroup.add(rdbtnTenLoai);

		rdbtnMaLoai.setSelected(true);
		JButton btnNewButton = new JButton("Tìm kiếm");
		btnNewButton.setIcon(icon2);
		btnNewButton.setBackground(Color.WHITE);
		panel_1.add(btnNewButton);

		JButton btnLamMoiDuLieu = new JButton("Làm mới dữ liệu");
		btnLamMoiDuLieu.setPreferredSize(new Dimension(150, 25));
		btnLamMoiDuLieu.setBackground(Color.WHITE);
		btnLamMoiDuLieu.setIcon(new ImageIcon("data\\images\\refresh.png"));
		panel_1.add(btnLamMoiDuLieu);
		
		String[] cols = {"Mã Loại", "Tên Loại" };
		 modelDSLoai = new DefaultTableModel(cols, 0);
		 tblDSLoai = new JTable(modelDSLoai);
		JScrollPane scrollPane = new JScrollPane(tblDSLoai);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (textFieldTim.getText().equals("")) {
					JOptionPane.showMessageDialog(contentPane, "Cần nhập dữ liệu danh mục cần tìm", "Cảnh báo",
							JOptionPane.WARNING_MESSAGE);
					textFieldTim.requestFocus();
				} else {
					try {
						String key = "";
						if (rdbtnMaLoai.isSelected()) {
							key = "MaLoai";
						} else if (rdbtnTenLoai.isSelected()) {
							key = "TenLoai";
						}
						dsloaitim = loaiDAO.timKiem(key, textFieldTim.getText());
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
					tblDSLoai.clearSelection();

					modelDSLoai.getDataVector().removeAllElements();
					renderData();
					isTimKiem = false;
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		try {
			renderData();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void renderData() throws SQLException {
		// modelDSSach.getDataVector().removeAllElements();
		dsloai = new LoaiSanPhamDAO().getDanhSachLoaiSanPham();

//		String stt = table.getValueAt(1, 0).toString();

		dsloai.forEach(loai -> {
			modelDSLoai.addRow(new Object[] { loai.getMaLoai(), loai.getTenLoai() });
		});

	}
	public void renderDataTimKiem() throws SQLException {
		tblDSLoai.clearSelection();

		modelDSLoai.getDataVector().removeAllElements();

		dsloaitim.forEach(loai -> {
			modelDSLoai.addRow(new Object[] { loai.getMaLoai(), loai.getTenLoai() });
		});

		tblDSLoai.revalidate();
		tblDSLoai.repaint();
	}




		
	}