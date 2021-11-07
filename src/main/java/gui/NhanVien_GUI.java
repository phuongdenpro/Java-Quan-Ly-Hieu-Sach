package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import org.jdesktop.swingx.prompt.PromptSupport;

import dao.NhanVienDAO;
import entity.NhanVien;
import util.Placeholder;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.Box;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.border.CompoundBorder;
import javax.swing.ScrollPaneConstants;

public class NhanVien_GUI extends JFrame {

	private JPanel contentPane;
	private JPanel out;
	private JTextField txtNhapLieu;
	private JTable tblNhanVien;
	private JTextField txtMaNv,txtTenNv,txtSdt,txtDiaChi;
	private DefaultTableModel modelDSNV;
	private List<NhanVien> dsnv;
	private JButton btnSuaNv,btnXoaNv,btnLamMoi;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhanVien_GUI frame = new NhanVien_GUI();
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
	public NhanVien_GUI() throws SQLException {
		setTitle("Nhân viên");
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(0, 0, 1300, 700);
		
		out = new JPanel();
		out.setLayout(new BoxLayout(out,BoxLayout.Y_AXIS));
		setContentPane(out);
		
		
		JPanel top = new JPanel();
		top.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel title = new JLabel("QUẢN LÝ NHÂN VIÊN");
		title.setFont(new Font("Tahoma", Font.BOLD, 20));
		top.add(title);
		out.add(top);
		
		JPanel bottom = new JPanel();
		bottom.setLayout(new BorderLayout());
		out.add(bottom);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		bottom.add(contentPane,BorderLayout.CENTER);
		JPanel pnLeft = new JPanel();
		Border compound = BorderFactory.createCompoundBorder(
				BorderFactory.createBevelBorder(BevelBorder.RAISED),
				BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		pnLeft.setBorder(compound);
		contentPane.add(pnLeft);
		
		JPanel pnThongTinKh = new JPanel();
		pnLeft.add(pnThongTinKh);
		pnThongTinKh.setLayout(new BoxLayout(pnThongTinKh, BoxLayout.Y_AXIS));
		
		Component verticalStrut_2 = Box.createVerticalStrut(35);
		pnThongTinKh.add(verticalStrut_2);
		
		JPanel pnTieuDe = new JPanel();
		pnThongTinKh.add(pnTieuDe);
		
		JLabel lblTieuDe = new JLabel("Thông tin Nhân viên");
		lblTieuDe.setFont(new Font("Tahoma", Font.PLAIN, 25));
		pnTieuDe.add(lblTieuDe);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		pnThongTinKh.add(verticalStrut_1);
		
		JPanel pnMaKh = new JPanel();
		FlowLayout fl_pnMaKh = (FlowLayout) pnMaKh.getLayout();
		fl_pnMaKh.setAlignment(FlowLayout.LEFT);
		pnThongTinKh.add(pnMaKh);
		
		JLabel lblMaKh = new JLabel("Mã NV             ");
		lblMaKh.setPreferredSize(new Dimension(100, 14));
		pnMaKh.add(lblMaKh);
		
		txtMaNv = new JTextField();
		txtMaNv.setEnabled(false);
		txtMaNv.setPreferredSize(new Dimension(7, 30));
		pnMaKh.add(txtMaNv);
		txtMaNv.setColumns(20);
		
		JPanel pnTenKh = new JPanel();
		FlowLayout fl_pnTenKh = (FlowLayout) pnTenKh.getLayout();
		fl_pnTenKh.setAlignment(FlowLayout.LEFT);
		pnThongTinKh.add(pnTenKh);
		
		JLabel lblTenKh = new JLabel("Tên NV");
		lblTenKh.setPreferredSize(new Dimension(100, 14));
		pnTenKh.add(lblTenKh);
		
		txtTenNv = new JTextField();
		txtTenNv.setPreferredSize(new Dimension(7, 30));
		txtTenNv.setColumns(20);
		pnTenKh.add(txtTenNv);
		
		JPanel pnSoDienThoai = new JPanel();
		FlowLayout fl_pnSoDienThoai = (FlowLayout) pnSoDienThoai.getLayout();
		fl_pnSoDienThoai.setAlignment(FlowLayout.LEFT);
		pnThongTinKh.add(pnSoDienThoai);
		
		JLabel lblSdt = new JLabel("Số điện thoại");
		lblSdt.setPreferredSize(new Dimension(100, 14));
		pnSoDienThoai.add(lblSdt);
		
		txtSdt = new JTextField();
		txtSdt.setPreferredSize(new Dimension(7, 30));
		txtSdt.setColumns(20);
		pnSoDienThoai.add(txtSdt);
		
		JPanel pnDiaChi = new JPanel();
		FlowLayout fl_pnDiaChi = (FlowLayout) pnDiaChi.getLayout();
		fl_pnDiaChi.setAlignment(FlowLayout.LEFT);
		pnThongTinKh.add(pnDiaChi);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ");
		lblDiaChi.setPreferredSize(new Dimension(100, 14));
		pnDiaChi.add(lblDiaChi);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setPreferredSize(new Dimension(7, 30));
		txtDiaChi.setColumns(20);
		pnDiaChi.add(txtDiaChi);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		pnThongTinKh.add(verticalStrut);
		
		JPanel pnChucNang = new JPanel();
		pnThongTinKh.add(pnChucNang);
		pnChucNang.setLayout(new GridLayout(0, 1, 0, 5));
		
		btnSuaNv = new JButton("Sửa");
		btnSuaNv.setBackground(Color.WHITE);
		btnSuaNv.setIcon(new ImageIcon("data\\images\\repairing-service.png"));
		btnSuaNv.setIconTextGap(30);
		pnChucNang.add(btnSuaNv);
		
		btnXoaNv = new JButton("Xóa");
		btnXoaNv.setBackground(Color.WHITE);
		btnXoaNv.setIcon(new ImageIcon("data\\images\\trash.png"));
		btnXoaNv.setIconTextGap(10);
		pnChucNang.add(btnXoaNv);
		
		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setBackground(Color.WHITE);
		btnLamMoi.setIcon(new ImageIcon("data\\images\\refresh.png"));
		btnLamMoi.setIconTextGap(10);
		pnChucNang.add(btnLamMoi);
		
		JPanel pnRight = new JPanel();
		contentPane.add(pnRight);
		pnRight.setLayout(new BorderLayout(0, 0));
		
		JPanel pnTimKiem = new JPanel();
		pnTimKiem.setBorder(new CompoundBorder(
				new BevelBorder(BevelBorder.RAISED, null, null, null, null),
				new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		pnRight.add(pnTimKiem, BorderLayout.NORTH);

		DefaultComboBoxModel cboLoaiTimKiem = new DefaultComboBoxModel<String>();
		JComboBox cmbLoaiTimKiem = new JComboBox(cboLoaiTimKiem);
		cmbLoaiTimKiem.setToolTipText("tìm kiếm theo");
		cmbLoaiTimKiem.setBackground(Color.WHITE);
		cmbLoaiTimKiem.setPreferredSize(new Dimension(130, 22));
		pnTimKiem.add(cmbLoaiTimKiem);
		cboLoaiTimKiem.addElement((String) "Mã NV");
		cboLoaiTimKiem.addElement((String) "Tên NV");
		cboLoaiTimKiem.addElement((String) "Số điện thoại");
		
		
		
		txtNhapLieu = new JTextField();
		txtNhapLieu.setPreferredSize(new Dimension(7, 25));
		pnTimKiem.add(txtNhapLieu);
		//PromptSupport.setPrompt("nhập liệu tìm kiếm", txtNhapLieu);
		new Placeholder().placeholder(txtNhapLieu, "nhập liệu tìm kiếm");
		txtNhapLieu.setColumns(30);
		
		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setPreferredSize(new Dimension(130, 25));
		btnTimKiem.setBackground(Color.WHITE);
		btnTimKiem.setIcon(new ImageIcon("data\\images\\search_16.png"));
		pnTimKiem.add(btnTimKiem);
		
		JPanel pnTableKh = new JPanel();
		pnRight.add(pnTableKh, BorderLayout.CENTER);
		pnTableKh.setLayout(new BorderLayout(0, 0));
		
		String[] cols_dskh = {"Mã nhân viên", "Tên nhân viên", "Số điện thoại", "Địa chỉ"};
		modelDSNV = new DefaultTableModel(cols_dskh, 0);
		tblNhanVien = new JTable(modelDSNV);
		JScrollPane scrTableNhanVien = new JScrollPane(tblNhanVien);
		scrTableNhanVien.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrTableNhanVien.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnTableKh.add(scrTableNhanVien);
		
//		modelDSNV.addRow(new Object[]{"1", "Tran Van Nhan", "0987654321", "tranvannhan@gmail.com", "Thủ Đức, Hồ Chí Minh"});
		
		renderData();
		setDisable();
		
		addEvents();
	}

	private void addEvents() {
		// TODO Auto-generated method stub
		tblNhanVien.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int idx = tblNhanVien.getSelectedRow();
				if(idx == -1 && txtTenNv.getText().equals("")) {
					setDisable();
				}
				if(idx != -1) {
					setEnable();
					
					NhanVien nv = dsnv.get(idx);
					txtMaNv.setText(String.valueOf(nv.getMaNv()));
					txtTenNv.setText(nv.getTenNv());
					txtSdt.setText(nv.getSoDienThoai());
					txtDiaChi.setText(nv.getDiaChi());
				}
			}
		});
		
		btnSuaNv.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tblNhanVien.clearSelection();
				
				int maNV = Integer.parseInt(txtMaNv.getText());
				String tenNV = txtTenNv.getText();
				String sdt = txtSdt.getText();
				String diaChi = txtDiaChi.getText();
				
				boolean ktSdt  = sdt.matches("^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$");	
				if(ktSdt == false) {
					JOptionPane.showMessageDialog(contentPane, "Số điện thoại không hợp lệ");
					return;
				}
				
				NhanVien nv = new NhanVien(maNV, tenNV, sdt, diaChi);
				boolean kq;
				try {
					kq = new NhanVienDAO().suaNV(nv);
					if(kq) {
						JOptionPane.showMessageDialog(contentPane, "Sửa thành công");
						renderData();
					}else {
						JOptionPane.showMessageDialog(contentPane, "Có lỗi xảy ra");
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				lamMoi();
				setDisable();
			}
		});
		
		btnXoaNv.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = tblNhanVien.getSelectedRow();
				if(index != -1) {
					
					int choose = JOptionPane.showConfirmDialog(contentPane, "Chắc chắn xóa!","Xác nhận", JOptionPane.YES_NO_OPTION);
					if(choose == 0) {
						tblNhanVien.clearSelection();
						try {
							boolean kq = new NhanVienDAO().xoaNV(dsnv.get(index));
							if(kq) {
								JOptionPane.showMessageDialog(contentPane, "Xóa thành công");
								renderData();
								lamMoi();
								setDisable();
							}else {
								JOptionPane.showMessageDialog(contentPane, "Có lỗi xảy ra");
							}
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				
			}
		});
		btnLamMoi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtMaNv.setText("");
				txtTenNv.setText("");
				txtSdt.setText("");
				txtDiaChi.setText("");
				try {
					renderData();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}});
	}

	public void renderData() throws SQLException {
		//modelDSNV.getDataVector().removeAllElements();
		modelDSNV.setRowCount(0);
		dsnv = new NhanVienDAO().getDSNV();
		dsnv.forEach(nv -> {
			modelDSNV.addRow
				(new Object[] {nv.getMaNv(), nv.getTenNv(), nv.getSoDienThoai(), nv.getDiaChi()});
		});
		
		tblNhanVien.revalidate();
		tblNhanVien.repaint();
		
	}
	public void lamMoi() {
		txtMaNv.setText("");
		txtTenNv.setText("");
		txtSdt.setText("");
		txtDiaChi.setText("");
	}
	public void setDisable() {
		btnSuaNv.setEnabled(false);
		btnXoaNv.setEnabled(false);
	}
	public void setEnable() {
		btnSuaNv.setEnabled(true);
		btnXoaNv.setEnabled(true);
	}
	
	public JPanel getContentPane() {
		 return this.out;
	 }
}
