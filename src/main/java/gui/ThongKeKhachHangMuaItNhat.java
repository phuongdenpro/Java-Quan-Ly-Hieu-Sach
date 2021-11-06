package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.KhachHangDAO;
import entity.KhachHang;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import java.awt.Font;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

import java.awt.Color;

public class ThongKeKhachHangMuaItNhat extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel modelDSKH;
	private JTable tblDSKH;
	private DefaultComboBoxModel<Integer> modelLimit;
	private JComboBox cboLimit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThongKeKhachHangMuaItNhat frame = new ThongKeKhachHangMuaItNhat();
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
	public ThongKeKhachHangMuaItNhat() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(0, 0, 1300, 700);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Thống kê top khách hàng mua ít nhất");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_3.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		String[] cols = {"STT", "Mã khách hàng", "Tên khách hàng", "Số điện thoại", "Địa chỉ", "Số lần mua hàng", "Số tiền mua hàng"};
		modelDSKH = new DefaultTableModel(cols, 0);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.NORTH);
		
		JPanel panel_6 = new JPanel();
		panel_2.add(panel_6);
		
		JLabel lblSoLuongToiDa = new JLabel("Số lượng KH tối đa: ");
		panel_6.add(lblSoLuongToiDa);
		
		modelLimit = new DefaultComboBoxModel<Integer>();
		cboLimit = new JComboBox(modelLimit);
		cboLimit.setEditable(true);
		panel_6.add(cboLimit);
		modelLimit.addElement(10);
		modelLimit.addElement(25);
		modelLimit.addElement(50);
		modelLimit.addElement(100);
		modelLimit.addElement(500);
		
		JButton btnThongKe = new JButton("Thống kê", null);
		btnThongKe.setBackground(Color.WHITE);
		panel_2.add(btnThongKe);
		tblDSKH = new JTable(modelDSKH);
		JScrollPane scrollPane = new JScrollPane(tblDSKH);
		panel_1.add(scrollPane);
		
		renderData();
		
		btnThongKe.addActionListener((e) -> {
			if(!String.valueOf(cboLimit.getSelectedItem()).matches("^\\d+$")) {
				JOptionPane.showMessageDialog(contentPane, "Số lượng khách hàng tối đa không hợp lệ");
				return;
			}
//			
		    try {
				renderData();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}
	
	public void renderData() throws SQLException {
		int limit = Integer.parseInt(String.valueOf(cboLimit.getSelectedItem()));
		Map<KhachHang, Map<String, Integer>> dskh = new KhachHangDAO().thongKeKHMuaIt(limit);
		
		tblDSKH.clearSelection();
		modelDSKH.getDataVector().removeAllElements();
		
		AtomicInteger stt = new AtomicInteger(1);
		dskh.forEach((kh, mp) -> {
			modelDSKH.addRow(new Object[] {
				stt.get(),
				kh.getMaKh(),
				kh.getHoTen(),
				kh.getSoDienThoai(),
				kh.getDiaChi(),
				mp.get("soLanMuaHang"),
				mp.get("tongTien"),
			});
			stt.set(stt.get()+1);
		});
		
		tblDSKH.revalidate();
		tblDSKH.repaint();
	}

	public JPanel getContentPane() {
		return this.contentPane;
	}
}
