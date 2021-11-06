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
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import java.awt.Font;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class ThongKeMucDoMuaHang_GUI extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel modelDSKH;
	private JTable tblDSKH;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThongKeMucDoMuaHang_GUI frame = new ThongKeMucDoMuaHang_GUI();
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
	public ThongKeMucDoMuaHang_GUI() throws SQLException {
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
		
		JLabel lblNewLabel_2 = new JLabel("Thống kê mức độ mua hàng");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_3.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		String[] cols = {"STT", "Mã khách hàng", "Tên khách hàng", "Số điện thoại", "Địa chỉ", "Số lần mua hàng", "Số tiền mua hàng"};
		modelDSKH = new DefaultTableModel(cols, 0);
		panel_1.setLayout(new BorderLayout(0, 0));
		tblDSKH = new JTable(modelDSKH);
		JScrollPane scrollPane = new JScrollPane(tblDSKH);
		panel_1.add(scrollPane);
		
		renderData();
	}
	
	public void renderData() throws SQLException {
		Map<KhachHang, Map<String, Integer>> dskh = new KhachHangDAO().thongKeKHTN(0);
		
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
