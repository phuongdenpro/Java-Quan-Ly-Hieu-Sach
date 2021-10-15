package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class TrangChu_GUI extends JFrame {

	private JPanel contentPane;
	public ImageIcon icon_shopping_cart = new ImageIcon("data/images/shopping-cart.png");
	public ImageIcon icon_manage_order = new ImageIcon("data/images/checklist.png");
	public ImageIcon icon_manage_user = new ImageIcon("data/images/boy.png");
	public ImageIcon icon_manage_staff = new ImageIcon("data/images/staff.png");
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrangChu_GUI frame = new TrangChu_GUI();
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
	public TrangChu_GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnMain = new JPanel();
		pnMain.setBounds(86, 90, 813, 424);
		contentPane.add(pnMain);
		pnMain.setLayout(new GridLayout(2, 1, 0, 10));
		
		JPanel pnRow = new JPanel();
		pnMain.add(pnRow);
		pnRow.setLayout(new GridLayout(1, 2, 10, 0));
		
		JPanel pnItem = new JPanel();
		pnItem.setBackground(Color.ORANGE);
		pnRow.add(pnItem);
		pnItem.setLayout(null);
		
		
		
		
		JLabel lblMuaHang = new JLabel("Mua h\u00E0ng");
		lblMuaHang.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblMuaHang.setBounds(141, 59, 250, 81);
		pnItem.add(lblMuaHang);
		
		JLabel lblIcon1 = new JLabel();
		lblIcon1.setBounds(10, 39, 109, 132);
		pnItem.add(lblIcon1);
		icon_shopping_cart = resizeIcon(icon_shopping_cart, lblIcon1);
		lblIcon1.setIcon(icon_shopping_cart);
		
		JPanel pnItem2 = new JPanel();
		pnItem2.setBackground(new Color(0, 255, 127));
		pnRow.add(pnItem2);
		pnItem2.setLayout(null);
		
		JLabel lblQLHD = new JLabel("QL H\u00F3a \u0111\u01A1n");
		lblQLHD.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblQLHD.setBounds(141, 58, 250, 81);
		pnItem2.add(lblQLHD);
		
		JLabel lblIcon2 = new JLabel();
		lblIcon2.setBounds(10, 41, 109, 132);
		pnItem2.add(lblIcon2);
		icon_manage_order = resizeIcon(icon_manage_order, lblIcon2);
		lblIcon2.setIcon(icon_manage_order);
		
		JPanel pnRow2 = new JPanel();
		pnMain.add(pnRow2);
		pnRow2.setLayout(new GridLayout(1, 2, 10, 0));
		
		JPanel pnItem3 = new JPanel();
		pnItem3.setLayout(null);
		pnItem3.setBackground(new Color(0, 255, 255));
		pnRow2.add(pnItem3);
		
		
		JLabel lblQLKH = new JLabel("QL Kh\u00E1ch h\u00E0ng");
		lblQLKH.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblQLKH.setBounds(141, 59, 250, 81);
		pnItem3.add(lblQLKH);
		
		JLabel lblIcon3 = new JLabel();
		lblIcon3.setBounds(10, 39, 109, 132);
		pnItem3.add(lblIcon3);
		icon_manage_user = resizeIcon(icon_manage_user, lblIcon3);
		lblIcon3.setIcon(icon_manage_user);
		
		JPanel pnItem4 = new JPanel();
		pnItem4.setLayout(null);
		pnItem4.setBackground(new Color(0, 139, 139));
		pnRow2.add(pnItem4);
		
		JLabel lblQLNV = new JLabel("QL Nh\u00E2n vi\u00EAn");
		lblQLNV.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblQLNV.setBounds(141, 58, 250, 81);
		pnItem4.add(lblQLNV);
		
		JLabel lblIcon4 = new JLabel();
		lblIcon4.setBounds(10, 41, 109, 132);
		pnItem4.add(lblIcon4);
		icon_manage_staff = resizeIcon(icon_manage_staff, lblIcon4);
		lblIcon4.setIcon(icon_manage_staff);
		
		JPanel panel = new JPanel();
		panel.setBounds(83, 11, 816, 68);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Xin ch\u00E0o: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tr\u1EA7n V\u0103n Nh\u00E2n");
		lblNewLabel_1.setForeground(new Color(0, 191, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		panel.add(lblNewLabel_1);
	}
	
	public static JPanel panelBackgroundImage(final String filepath) {
		return new JPanel() {  
			public void paintComponent(Graphics g) {  
				Image img = Toolkit.getDefaultToolkit().getImage(  
						Login_GUI.class.getResource(filepath));  
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
            }  
		};
	}
	
	public static ImageIcon resizeIcon(ImageIcon icon, JLabel lbl) {
		Image image = icon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(lbl.getWidth(), lbl.getHeight(),  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		icon = new ImageIcon(newimg);  // transform it back
		return icon;
	}
}
