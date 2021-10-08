package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;

public class SanPhamChoKH_GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelHeader = new JPanel();
		panelHeader.setBackground(new Color(255, 255, 255));
		panelHeader.setBounds(0, 0, 984, 38);
		contentPane.add(panelHeader);
		panelHeader.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Xin ch\u00E0o");
		lblNewLabel.setBounds(817, 11, 54, 14);
		panelHeader.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tr\u1EA7n V\u0103n Nh\u00E2n");
		lblNewLabel_1.setForeground(new Color(0, 139, 139));
		lblNewLabel_1.setBounds(881, 11, 93, 14);
		panelHeader.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Hi\u1EC7u S\u00E1ch NPB");
		lblNewLabel_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(10, 8, 130, 17);
		panelHeader.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(184, 0, 315, 38);
		panelHeader.add(panel_1);
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 11, 200, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("T\u00ECm ki\u1EBFm");
		btnNewButton.setBounds(220, 11, 89, 19);
		panel_1.add(btnNewButton);
		
		JPanel panelContent = new JPanel();
		panelContent.setBounds(0, 38, 984, 523);
		contentPane.add(panelContent);
		panelContent.setLayout(null);
		
		
		
		JPanel pnCategory = new JPanel();
		pnCategory.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnCategory.setBounds(25, 25, 928, 444);
		panelContent.add(pnCategory);
		pnCategory.setLayout(null);
		
		JLabel lblTruyen = new JLabel("Truy\u1EC7n", SwingConstants.CENTER);
		lblTruyen.setForeground(new Color(0, 206, 209));
		lblTruyen.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 206, 209)));
		lblTruyen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTruyen.setBounds(425, 3, 70, 31);
		pnCategory.add(lblTruyen);
		
		
		
		JPanel pnItem = new JPanel();
		pnItem.setBounds(37, 47, 202, 238);
		pnCategory.add(pnItem);
		pnItem.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnItem.setLayout(null);
		
		JPanel pnImage = TrangChu_GUI.panelBackgroundImage("/images/product/conan_tap_1.jpg");;
		pnImage.setBounds(0, 0, 217, 127);
		pnImage.setLayout(null);
		pnItem.add(pnImage);
		
		JPanel pnTitle = new JPanel();
		pnTitle.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnTitle.setBounds(0, 124, 202, 115);
		pnItem.add(pnTitle);
		pnTitle.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Truy\u1EC7n conan");
		lblNewLabel_3.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 11, 183, 25);
		pnTitle.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("16.000\u0111");
		lblNewLabel_4.setBounds(10, 34, 46, 14);
		pnTitle.add(lblNewLabel_4);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 47, 183, 35);
		pnTitle.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("-");
		btnNewButton_1.setBounds(33, 8, 37, 22);
		panel.add(btnNewButton_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(78, 8, 37, 23);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_1_1 = new JButton("+");
		btnNewButton_1_1.setBounds(122, 8, 37, 22);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_2 = new JButton("Th\u00EAm v\u00E0o gi\u1ECF");
		btnNewButton_2.setBounds(10, 85, 183, 23);
		pnTitle.add(btnNewButton_2);
		
		
		
		JPanel pnItem_1 = new JPanel();
		pnItem_1.setLayout(null);
		pnItem_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnItem_1.setBounds(254, 47, 202, 238);
		pnCategory.add(pnItem_1);
		
		JPanel pnImage2 = TrangChu_GUI.panelBackgroundImage("/images/product/doraemon.jpg");;
		pnImage2.setBounds(0, 0, 217, 127);
		pnImage2.setLayout(null);
		pnItem_1.add(pnImage2);
		
		JPanel pnTitle_1 = new JPanel();
		pnTitle_1.setLayout(null);
		pnTitle_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnTitle_1.setBounds(0, 124, 202, 115);
		pnItem_1.add(pnTitle_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Truy\u1EC7n doraemon");
		lblNewLabel_3_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblNewLabel_3_1.setBounds(10, 11, 183, 25);
		pnTitle_1.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("16.000\u0111");
		lblNewLabel_4_1.setBounds(10, 34, 46, 14);
		pnTitle_1.add(lblNewLabel_4_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(10, 47, 183, 35);
		pnTitle_1.add(panel_2);
		
		JButton btnNewButton_1_2 = new JButton("-");
		btnNewButton_1_2.setBounds(33, 8, 37, 22);
		panel_2.add(btnNewButton_1_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(78, 8, 37, 23);
		panel_2.add(textField_2);
		
		JButton btnNewButton_1_1_1 = new JButton("+");
		btnNewButton_1_1_1.setBounds(122, 8, 37, 22);
		panel_2.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_2_1 = new JButton("Th\u00EAm v\u00E0o gi\u1ECF");
		btnNewButton_2_1.setBounds(10, 85, 183, 23);
		pnTitle_1.add(btnNewButton_2_1);
		
		
	}

	
}
