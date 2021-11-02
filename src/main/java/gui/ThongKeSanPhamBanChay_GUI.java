package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.SanPhamDAO;
import entity.SanPham;
import util.Placeholder;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Map;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

public class ThongKeSanPhamBanChay_GUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtTuNgay;
	private JTextField txtToiNgay;
	private Map<SanPham, Integer> dssp;
	private DefaultTableModel modelDSSP;
	private JTable tblDSSP;
	DialogDatePicker f = new DialogDatePicker();
	private kDatePicker dpTuNgay;
	private kDatePicker dpToiNgay;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThongKeSanPhamBanChay_GUI frame = new ThongKeSanPhamBanChay_GUI();
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
	public ThongKeSanPhamBanChay_GUI() throws SQLException {
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
		
		JLabel lblNewLabel_2 = new JLabel("Thống kê sản phẩm bán chạy");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_3.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JLabel lblTuNgay = new JLabel("Từ ngày:  ");
		panel_2.add(lblTuNgay);
		
		
		dpTuNgay = new kDatePicker();
		panel_2.add(dpTuNgay);
		
		JLabel lblToiNgay = new JLabel("Tới ngày");
		panel_2.add(lblToiNgay);
		
		dpToiNgay = new kDatePicker();
		panel_2.add(dpToiNgay);
		
		JButton btnThongKe = new JButton("Thống kê", new ImageIcon("data/images/statistics.png"));

		btnThongKe.setBackground(Color.WHITE);
		panel_2.add(btnThongKe);
		
		JButton btnLamMoi = new JButton("Làm mới dữ liệu", new ImageIcon("data/images/refresh.png"));
		btnLamMoi.setBackground(Color.WHITE);
		panel_2.add(btnLamMoi);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		panel_1.setLayout(new BorderLayout(0, 0));
		
		String[] cols = {"Mã sản phẩm", "Tên sản phẩm", "Nhà xuất bản", "Đơn giá", "Số lượng đã bán"};
		modelDSSP = new DefaultTableModel(cols, 0);
		tblDSSP = new JTable(modelDSSP);
		JScrollPane scrollPane = new JScrollPane(tblDSSP);
		panel_1.add(scrollPane);
		
		renderData();
	
		btnThongKe.addActionListener((e) -> {
			long ml=System.currentTimeMillis(); 
	        ml = ml/86400000*86400000;
	        Date now = new Date(ml);
			
			Date tuNgay = new Date(ml), toiNgay = new Date(ml);
            try {
                tuNgay = dpTuNgay.getFullDate();
                toiNgay = dpToiNgay.getFullDate(); 
            } catch (ParseException e1) {
                e1.printStackTrace();
            }
            
            if(tuNgay.after(now)){
                JOptionPane.showMessageDialog(contentPane, "Từ ngày không hợp lệ");
                return;
            }
            
            if(toiNgay.after(now)){
                JOptionPane.showMessageDialog(contentPane, "Tới ngày không hợp lệ");
                return;
            }
            
            if(tuNgay.after(toiNgay)){
                JOptionPane.showMessageDialog(contentPane, "Ngày không hợp lệ");
                return;
            }
            
            try {
				renderData(tuNgay, toiNgay);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		btnLamMoi.addActionListener((e) -> {
			try {
				renderData();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}
	
	public void renderData() throws SQLException {
		dssp = new SanPhamDAO().thongKeSPBanChay();
		tblDSSP.clearSelection();
		modelDSSP.getDataVector().removeAllElements();
		
		dssp.forEach((sp, soLuongDaBan) -> {
			modelDSSP.addRow(new Object[] {
				sp.getMaSp(),
				sp.getTenSp(),
				sp.getNhaCungCap().getTenNCC(),
				sp.getGiaSp(),
				soLuongDaBan
			});
		});
		tblDSSP.revalidate();
		tblDSSP.repaint();
	}
	
	public void renderData(Date tuNgay, Date toiNgay) throws SQLException {
		dssp = new SanPhamDAO().thongKeSPBanChay(tuNgay, toiNgay);
		tblDSSP.clearSelection();
		modelDSSP.getDataVector().removeAllElements();
		
		dssp.forEach((sp, soLuongDaBan) -> {
			modelDSSP.addRow(new Object[] {
				sp.getMaSp(),
				sp.getTenSp(),
				sp.getNhaCungCap().getTenNCC(),
				sp.getGiaSp(),
				soLuongDaBan
			});
		});
		tblDSSP.revalidate();
		tblDSSP.repaint();
	}

	public JPanel getContentPane() {
		return this.contentPane;
	}
}
