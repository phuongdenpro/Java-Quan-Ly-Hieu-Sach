package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.CardLayout;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dialog;

import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;

public class SanPhamChoKH_GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private Container panelContent;

	public ImageIcon icon_book = new ImageIcon("data/images/book.png");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SanPhamChoKH_GUI frame = new SanPhamChoKH_GUI();
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
	public SanPhamChoKH_GUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(0, 0, 1300, 700);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width, screenSize.height);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelHeader = new JPanel();
		panelHeader.setBackground(new Color(255, 255, 255));
		contentPane.add(panelHeader, BorderLayout.NORTH);
		panelHeader.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panelHeader.add(panel);
		
		JLabel lblNewLabel_2 = new JLabel("Hiệu Sách NPB");
		lblNewLabel_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblNewLabel_2.setAlignmentX(1.0f);
		panel.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBackground(new Color(255, 255, 255));
		panelHeader.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(20);
		
		JButton btnNewButton = new JButton("T\u00ECm ki\u1EBFm");
		btnNewButton.setPreferredSize(new Dimension(100, 19));
		panel_1.add(btnNewButton);
		
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel_3.setBackground(Color.WHITE);
		panelHeader.add(panel_3);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel_3.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Xin chào: Trần Văn Nhân");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmQuanLy = new JMenuItem("Đi tới trang quản lý");
		mnNewMenu.add(mntmQuanLy);
		
		JMenuItem mntmGioHang = new JMenuItem("Giỏ hàng");
		mnNewMenu.add(mntmGioHang);
		
		JMenuItem mntmDangXuat = new JMenuItem("Đăng xuất");
		mnNewMenu.add(mntmDangXuat);
		
//		JLabel lblNewLabel = new JLabel("Xin ch\u00E0o");
//		lblNewLabel.setAlignmentY(Component.TOP_ALIGNMENT);
//		panel_3.add(lblNewLabel);
//		
//		JLabel lblNewLabel_1 = new JLabel("Tr\u1EA7n V\u0103n Nh\u00E2n");
//		lblNewLabel_1.setForeground(new Color(0, 139, 139));
		
//		DefaultComboBoxModel<String> modelMenu = new DefaultComboBoxModel<String>();
//		JComboBox comboBox = new JComboBox(modelMenu);
//		GridBagConstraints gbc_comboBox = new GridBagConstraints();
//		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
//		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
//		gbc_comboBox.gridx = 2;
//		gbc_comboBox.gridy = 0;
//		panel_3.add(comboBox);
//		
//        modelMenu.addElement("Xin chào: Trần Văn Nhân");
//        modelMenu.addElement("Quản lý");
		
		panelContent = new JPanel();
		
		panelContent.setLayout(new BoxLayout(panelContent, BoxLayout.Y_AXIS));
		
		JScrollPane pane = new JScrollPane(panelContent);
		contentPane.add(pane);
//		panelContent.add(pane);
		
		this.category();
		this.category();
		this.category();
//		
//		JPanel pnImage = TrangChu_GUI.panelBackgroundImage("/images/product/conan_tap_1.jpg");;
//		pnImage.setBounds(0, 0, 217, 127);
//		pnImage.setLayout(null);
//		
//		JPanel pnImage2 = TrangChu_GUI.panelBackgroundImage("/images/product/doraemon.jpg");;
//		pnImage2.setBounds(0, 0, 217, 127);
//		pnImage2.setLayout(null);
		
		
	}

	public void category() {
		JPanel pnCategory = new JPanel();
		
//		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//		pnCategory.setSize(screenSize);
		
		pnCategory.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelContent.add(pnCategory);
		pnCategory.setLayout(new BorderLayout(0, 0));
		
		
		
		
		JPanel panel_5 = new JPanel();
		pnCategory.add(panel_5, BorderLayout.NORTH);
		
		JLabel lblTruyen = new JLabel("Truy\u1EC7n", SwingConstants.CENTER);
		lblTruyen.setForeground(new Color(0, 206, 209));
		lblTruyen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTruyen.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 206, 209)));
		panel_5.add(lblTruyen);
		
		JPanel panel_10 = new JPanel(new FlowLayout());
		pnCategory.add(panel_10, BorderLayout.CENTER);
		
		JPanel panel_9 = new JPanel();
		GridLayout gridLayout = new GridLayout(0, 5); 
		gridLayout.setHgap(10);
		panel_9.setLayout(gridLayout);
		panel_10.add(panel_9);
		
//		panel_9.setLayout(new GridLayout(0, 4));
		
		panel_9.add(this.item());
		
		panel_9.add(this.item());
		panel_9.add(this.item());
		panel_9.add(this.item());
		panel_9.add(this.item());
		panel_9.add(this.item());
		panel_9.add(this.item());
		panel_9.add(this.item());
//		panel_9.add(this.item(Color.YELLOW));
	}
	
	public JPanel item() {
		JPanel pnItem = new JPanel();
//		pnItem.setBackground(color);
//		pnItem.setSize(new Dimension(200, 300));
		pnItem.setPreferredSize(new Dimension(200, 200));
		pnItem.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null) );
		
		JLabel lbIcon = new JLabel();
		lbIcon.setAlignmentX(CENTER_ALIGNMENT);
		lbIcon.setPreferredSize(new Dimension(200, 100));
		ImageIcon imageProduct = new ImageIcon("data/product/conan_tap_1.jpg");
		imageProduct = TrangChu_GUI.resizeIcon(imageProduct, lbIcon);
		lbIcon.setIcon(imageProduct);
		pnItem.add(lbIcon);
		
		JPanel pnInfo = new JPanel();
//		pnInfo.setLayout(new BoxLayout(pnInfo, BoxLayout.Y_AXIS));
		pnInfo.setPreferredSize(new Dimension(190, 80));
		pnInfo.setLayout(new GridLayout(3, 0));
		pnItem.add(pnInfo);
		
		JLabel lbTenSanPham = new JLabel("Truyện conan");
		
//		lbTenSanPham.setPreferredSize(new Dimension(200, 20));
		lbTenSanPham.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		pnInfo.add(lbTenSanPham);
		
		JLabel lbGia = new JLabel("15.000đ");
		pnInfo.add(lbGia);
		
		JButton btnThemVaoGio = new JButton("Thêm vào giỏ");
		pnInfo.add(btnThemVaoGio);
		
		btnThemVaoGio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showThemVaoGio();
			}
		});
		
		return pnItem;
	}
	
	public void showThemVaoGio() {
		String soLuong = JOptionPane.showInputDialog(this, "Số lượng", 1);
		System.out.println(soLuong);
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
		Image newimg = image.getScaledInstance(199, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		icon = new ImageIcon(newimg);  // transform it back
		return icon;
	}
}
