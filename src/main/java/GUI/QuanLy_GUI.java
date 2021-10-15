package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.Component;
import javax.swing.Box;
import java.awt.Insets;
import java.awt.FlowLayout;

public class QuanLy_GUI extends JFrame {

	private JPanel contentPane;
	public ImageIcon icon_manage_product = new ImageIcon("data/images/book.png");
	public ImageIcon icon_manage_order = new ImageIcon("data/images/checklist.png");
	public ImageIcon icon_manage_user = new ImageIcon("data/images/boy.png");
	public ImageIcon icon_manage_staff = new ImageIcon("data/images/staff.png");
	public ImageIcon icon_manage_chart = new ImageIcon("data/images/bar-chart.png");
	public ImageIcon icon_manage_back = new ImageIcon("data/images/back-arrow.png");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLy_GUI frame = new QuanLy_GUI();
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
	public QuanLy_GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setUndecorated(true);
		setBounds(0, 0, 1400, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_2);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		
		JLabel lblNewLabel = new JLabel("Xin ch\u00E0o: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tr\u1EA7n V\u0103n Nh\u00E2n");
		lblNewLabel_1.setForeground(new Color(0, 206, 209));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		panel_2.add(lblNewLabel_1);
		
		JPanel panel_9 = new JPanel();
		contentPane.add(panel_9, BorderLayout.CENTER);
		panel_9.setLayout(new BoxLayout(panel_9, BoxLayout.Y_AXIS));
		
		Component verticalStrut = Box.createVerticalStrut(40);
		panel_9.add(verticalStrut);
		
		JPanel panel_8 = new JPanel();
		panel_9.add(panel_8);
		panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.X_AXIS));
		
		Component horizontalStrut = Box.createHorizontalStrut(200);
		panel_8.add(horizontalStrut);
		
		JPanel panel = new JPanel();
		panel_8.add(panel);
		panel.setLayout(new GridLayout(0, 2, 50, 20));
		
		JPanel pnItem1 = new JPanel();
		pnItem1.setBackground(new Color(255, 255, 0));
		panel.add(pnItem1);
		pnItem1.setLayout(null);
		
		JLabel lbIcon1 = new JLabel();
		lbIcon1.setBounds(10, 11, 120, 139);
		pnItem1.add(lbIcon1);
		icon_manage_product = TrangChu_GUI.resizeIcon(icon_manage_product, lbIcon1);
		lbIcon1.setIcon(icon_manage_product);
		
		JLabel lblSanPham = new JLabel("S\u1EA3n ph\u1EA9m");
		lblSanPham.setBounds(136, 54, 134, 37);
		lblSanPham.setFont(new Font("Tahoma", Font.PLAIN, 30));
		pnItem1.add(lblSanPham);
		
		JPanel pnItem2 = new JPanel();
		pnItem2.setBackground(new Color(0, 255, 255));
		panel.add(pnItem2);
		pnItem2.setLayout(null);
		
		JLabel lbIcon2 = new JLabel();
		lbIcon2.setBounds(10, 11, 120, 139);
		pnItem2.add(lbIcon2);
		icon_manage_order = TrangChu_GUI.resizeIcon(icon_manage_order, lbIcon2);
		lbIcon2.setIcon(icon_manage_order);
		
		JLabel lblQLHD = new JLabel("H\u00F3a \u0111\u01A1n");
		lblQLHD.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblQLHD.setBounds(134, 22, 190, 92);
		pnItem2.add(lblQLHD);
		
		
		JPanel pnItem3 = new JPanel();
		pnItem3.setBackground(new Color(0, 139, 139));
		panel.add(pnItem3);
		pnItem3.setLayout(null);
		
		JLabel lbIcon3 = new JLabel("New label");
		lbIcon3.setBounds(10, 11, 120, 139);
		pnItem3.add(lbIcon3);
		icon_manage_user = TrangChu_GUI.resizeIcon(icon_manage_user, lbIcon3);
		lbIcon3.setIcon(icon_manage_user);
		
		JLabel lblQLKH = new JLabel("Kh\u00E1ch h\u00E0ng");
		lblQLKH.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblQLKH.setBounds(134, 26, 190, 92);
		pnItem3.add(lblQLKH);
		
		
		JPanel pnItem4 = new JPanel();
		pnItem4.setBackground(new Color(144, 238, 144));
		panel.add(pnItem4);
		pnItem4.setLayout(null);
		
		JLabel lbIcon4 = new JLabel("New label");
		lbIcon4.setBounds(10, 11, 120, 139);
		pnItem4.add(lbIcon4);
		icon_manage_staff = TrangChu_GUI.resizeIcon(icon_manage_staff, lbIcon4);
		lbIcon4.setIcon(icon_manage_staff);
		
		JLabel lblNewLabel_2_3 = new JLabel("Nh\u00E2n vi\u00EAn");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_2_3.setBounds(134, 26, 190, 92);
		pnItem4.add(lblNewLabel_2_3);
		
		JPanel pnItem5 = new JPanel();
		pnItem5.setBackground(new Color(135, 206, 250));
		panel.add(pnItem5);
		pnItem5.setLayout(null);
		
		JLabel lbIcon5 = new JLabel("New label");
		lbIcon5.setBounds(10, 11, 120, 139);
		pnItem5.add(lbIcon5);
		icon_manage_chart = TrangChu_GUI.resizeIcon(icon_manage_chart, lbIcon5);
		lbIcon5.setIcon(icon_manage_chart);
		
		JLabel lblThongKe = new JLabel("Th\u1ED1ng k\u00EA");
		lblThongKe.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblThongKe.setBounds(134, 26, 190, 92);
		pnItem5.add(lblThongKe);
		
		JPanel pnItem6 = new JPanel();
		pnItem6.setBackground(new Color(240, 255, 255));
		panel.add(pnItem6);
		pnItem6.setLayout(null);
		
		JLabel lbIcon6 = new JLabel("New label");
		lbIcon6.setBounds(10, 11, 120, 139);
		pnItem6.add(lbIcon6);
		icon_manage_back = TrangChu_GUI.resizeIcon(icon_manage_back, lbIcon6);
		lbIcon6.setIcon(icon_manage_back);
		
		JLabel lblTroVe = new JLabel("Tr\u1EDF v\u1EC1");
		lblTroVe.setForeground(new Color(255, 0, 0));
		lblTroVe.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTroVe.setBounds(134, 26, 190, 92);
		pnItem6.add(lblTroVe);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(200);
		panel_8.add(horizontalStrut_1);
		
		Component verticalStrut_1 = Box.createVerticalStrut(100);
		panel_9.add(verticalStrut_1);
	}

}
