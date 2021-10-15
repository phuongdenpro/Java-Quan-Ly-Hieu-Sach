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
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import java.awt.Component;
import javax.swing.Box;

public class SanPhamChoKH_GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

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
		GridBagLayout gbl_panelHeader = new GridBagLayout();
		gbl_panelHeader.columnWidths = new int[] {200, 200, 200};
		gbl_panelHeader.rowHeights = new int[]{33, 0, 0};
		gbl_panelHeader.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0};
		gbl_panelHeader.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panelHeader.setLayout(gbl_panelHeader);
		
		JLabel lblNewLabel_2 = new JLabel("Hi\u1EC7u S\u00E1ch NPB");
		lblNewLabel_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 0;
		panelHeader.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 0;
		panelHeader.add(panel_1, gbc_panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("T\u00ECm ki\u1EBFm");
		panel_1.add(btnNewButton);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 3;
		gbc_panel_3.gridy = 0;
		panelHeader.add(panel_3, gbc_panel_3);
		
		JLabel lblNewLabel = new JLabel("Xin ch\u00E0o");
		lblNewLabel.setAlignmentY(Component.TOP_ALIGNMENT);
		panel_3.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tr\u1EA7n V\u0103n Nh\u00E2n");
		lblNewLabel_1.setForeground(new Color(0, 139, 139));
		panel_3.add(lblNewLabel_1);
		
		JPanel panelContent = new JPanel();
		contentPane.add(panelContent);
		panelContent.setLayout(new BoxLayout(panelContent, BoxLayout.Y_AXIS));
		
		
		
		JPanel pnCategory = new JPanel();
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
		
		JPanel panel_9 = new JPanel();
		pnCategory.add(panel_9, BorderLayout.CENTER);
		panel_9.setLayout(new GridLayout(0, 1, 0, 10));
		
		JPanel panel_4 = new JPanel();
		panel_9.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 4, 10, 10));
		
		JPanel pnItem = new JPanel();
		pnItem.setPreferredSize(new Dimension(5, 5));
		pnItem.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_4.add(pnItem);
		pnItem.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(10, 2, 315, 174);
		pnItem.add(panel_6);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		panel_6.add(lblNewLabel_5);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(12, 178, 313, 77);
		pnItem.add(panel_7);
		panel_7.setLayout(null);
		
		JPanel pnTitle = new JPanel();
		pnTitle.setBounds(0, 0, 313, 37);
		pnTitle.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		pnTitle.setBorder(null);
		pnTitle.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel_7.add(pnTitle);
		pnTitle.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Truy\u1EC7n conan");
		lblNewLabel_3.setBounds(0, 0, 313, 20);
		lblNewLabel_3.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblNewLabel_3.setAlignmentX(1.0f);
		pnTitle.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("16.000\u0111");
		lblNewLabel_4.setBounds(0, 23, 313, 14);
		lblNewLabel_4.setAlignmentY(0.0f);
		lblNewLabel_4.setAlignmentX(1.0f);
		pnTitle.add(lblNewLabel_4);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 37, 313, 29);
		panel_7.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		Component horizontalStrut = Box.createHorizontalStrut(70);
		panel.add(horizontalStrut);
		
		JPanel panel_11 = new JPanel();
		panel.add(panel_11);
		panel_11.setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton btnNewButton_1 = new JButton("-");
		panel_11.add(btnNewButton_1);
		
		textField_1 = new JTextField();
		textField_1.setPreferredSize(new Dimension(8, 20));
		textField_1.setColumns(2);
		panel_11.add(textField_1);
		
		JButton btnNewButton_1_1 = new JButton("+");
		panel_11.add(btnNewButton_1_1);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(70);
		panel.add(horizontalStrut_1);
		
		JButton btnNewButton_2 = new JButton("Th\u00EAm v\u00E0o gi\u1ECF");
		btnNewButton_2.setBounds(10, 258, 315, 23);
		btnNewButton_2.setAlignmentX(Component.RIGHT_ALIGNMENT);
		pnItem.add(btnNewButton_2);
		
		JPanel panel_4_1 = new JPanel();
		panel_9.add(panel_4_1);
		panel_4_1.setLayout(new GridLayout(0, 4, 10, 10));
		
		JPanel pnImage = TrangChu_GUI.panelBackgroundImage("/images/product/conan_tap_1.jpg");;
		pnImage.setBounds(0, 0, 217, 127);
		pnImage.setLayout(null);
		
		JPanel pnImage2 = TrangChu_GUI.panelBackgroundImage("/images/product/doraemon.jpg");;
		pnImage2.setBounds(0, 0, 217, 127);
		pnImage2.setLayout(null);
		
		
	}

	
}
