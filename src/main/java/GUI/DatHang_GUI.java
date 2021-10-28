package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import DAO.DonDatHangDAO;
import entity.DonDatHang;

import javax.swing.border.EtchedBorder;

@SuppressWarnings("serial")
public class DatHang_GUI extends JFrame implements ActionListener, MouseListener {
	private DefaultTableModel modelDonDat;
	String[] colsDonDat = { "Mã đơn đặt hàng", "Mã khách hàng", "Tên khách hàng", "Số điện thoại", "Địa chỉ", "Tổng tiền", "Tình trạng", "Thời gian đặt" };
	public JPanel pnMain;
	private JTable tableDonDat;
	private JPanel panel_1;
	private JButton btnThanhToan;
	private JButton btnXoa;
	private JTextField txtTimMaDon;
	private JButton btnTimMaDon;
	private List<DonDatHang> dsddh;
	private DefaultTableModel modelDSSP;
	private JTable tblDSSP;
	

	public DatHang_GUI() {
		

		setTitle("Quản lý đơn đặt hàng");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(0, 0, 1300, 700);
		
		pnMain = new JPanel();
		pnMain.setBounds(0, 0, 584, 411);
		setContentPane(pnMain);

		JLabel lbTitle = new JLabel("Quản Lý Đơn Đặt Hàng");
		lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitle.setBounds(434, 11, 348, 30);
		lbTitle.setFont(new Font("Tahoma", Font.BOLD, 25));
		pnMain.add(lbTitle);

		modelDonDat = new DefaultTableModel(colsDonDat, 0) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int i, int i1) {
				return false;
				// Không cho chỉnh sửa trên table
			}
		};

		pnMain.setLayout(null);


		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Danh sách đơn đặt hàng", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_1.setBounds(10, 65, 1274, 575);
		pnMain.add(panel_1);
		panel_1.setLayout(null);

		tableDonDat = new JTable(modelDonDat);
		JScrollPane scDonDat = new JScrollPane(tableDonDat, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scDonDat.setBounds(10, 67, 1254, 300);
		panel_1.add(scDonDat);
		
		String[] colsDSSP = { "Mã sản phẩm", "Tên sản phẩm", "Đơn giá", "Số lượng", "Thành tiền" };
		modelDSSP = new DefaultTableModel(colsDSSP, 0);
		tblDSSP = new JTable(modelDSSP);
		JScrollPane scrollPane = new JScrollPane(tblDSSP);
		scrollPane.setBounds(10, 367, 1254, 200);
		panel_1.add(scrollPane);

		JLabel lbTimMaDon = new JLabel("Mã đơn:");
		lbTimMaDon.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbTimMaDon.setBounds(20, 25, 110, 30);
		panel_1.add(lbTimMaDon);

		txtTimMaDon = new JTextField();
		txtTimMaDon.setBounds(100, 29, 120, 25);
		panel_1.add(txtTimMaDon);
		txtTimMaDon.setColumns(10);

		btnTimMaDon = new JButton("Tìm");
		btnTimMaDon.setBackground(Color.WHITE);
		btnTimMaDon.setIcon(new ImageIcon("data/images/search_16.png"));
		btnTimMaDon.setBounds(235, 28, 115, 25);
		panel_1.add(btnTimMaDon);

		btnThanhToan = new JButton("Thanh toán");
		btnThanhToan.setBackground(Color.WHITE);
		btnThanhToan.setIcon(new ImageIcon("data/images/blueAdd_16.png"));
		btnThanhToan.setBounds(360, 28, 145, 25);
		panel_1.add(btnThanhToan);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setBackground(Color.WHITE);
		btnXoa.setBounds(515, 28, 115, 25);
		btnXoa.setIcon(new ImageIcon("data/images/cancel_16.png"));
		panel_1.add(btnXoa);
		btnTimMaDon.addActionListener(this);
		
		pnMain.addMouseListener(this);

		try {
			renderData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tableDonDat.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				System.out.println(tableDonDat.getSelectedRow());
				renderSSSP(tableDonDat.getSelectedRow());
			}
		});
		
		btnThanhToan.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int id = tableDonDat.getSelectedRow();
				try {
					if(new DonDatHangDAO().thanhToan(dsddh.get(id).getMaDDH())) {
						JOptionPane.showMessageDialog(pnMain, "Thanh toán thành công");
//						làm tiếp
					}else {
						JOptionPane.showMessageDialog(pnMain, "Có lỗi xảy ra");
					}
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnXoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				int id = tableDonDat.getSelectedRow();
//				if(id == -1) return;
//				try {
//					if(new DonDatHangDAO().xoaDonDatHang(dsddh.get(id).getMaDDH())) {
//						tableDonDat.clearSelection();
//						System.out.println("a" + id);
//						modelDonDat.removeRow(id);
//						dsddh.remove(id);
//						
//					}else {
//						JOptionPane.showMessageDialog(pnMain, "Có lỗi xảy ra");
//					}
//					
//					
//				} catch (HeadlessException | SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
			}
		});
	}
	
	public void renderData() throws SQLException {
		modelDonDat.getDataVector().removeAllElements();
		dsddh = new DonDatHangDAO().getDSDonDatHang();
		
		dsddh.forEach(ddh -> {
			String tinhTrang = "Chưa thanh toán";
			if(ddh.getTinhTrang() == 2)
				tinhTrang = "Đã thanh toán";
			
			modelDonDat.addRow(new Object[] {
					ddh.getMaDDH(), 
					ddh.getKhachHang().getMaKh(), 
					ddh.getKhachHang().getHoTen(), 
					ddh.getKhachHang().getSoDienThoai(),
					ddh.getKhachHang().getDiaChi(),
					ddh.getTongTien(), 
					tinhTrang, 
					ddh.getNgayDat()});
		});
	}

	public void renderSSSP(int i) {
		modelDSSP.getDataVector().removeAllElements();
		dsddh.get(i).getChiTietDonDatHangs().forEach(ctddh -> {
			modelDSSP.addRow(new Object[] {
					ctddh.getSanPham().getMaSp(), 
					ctddh.getSanPham().getTenSp(), 
					ctddh.getSanPham().getGiaSp(),
					ctddh.getSoLuong(),
					ctddh.tinhThanhTien()
				});
		});
	}
	

	public static void main(String[] args) {
		new DatHang_GUI().setVisible(true);
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public JPanel getContentPane() {
		return this.pnMain;
	}
}