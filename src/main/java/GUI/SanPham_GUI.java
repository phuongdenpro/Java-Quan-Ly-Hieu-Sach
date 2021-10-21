package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Locale.Category;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

public class SanPham_GUI extends JFrame implements ActionListener, MouseListener{
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private static JList lstTheloai;

	private JTable tblProduct;

	private DefaultTableModel dtmProduct;
	
	DefaultListModel<String> listmodeTheloai;

	private JButton btnCateRemove, btnCateNew, btnCateUpdate, btnNew, btnSave, btnRemove;

	private JTextField txtId, txtName, txtUnitprice, txtQuantity;

	private JTextArea txtDescription;

	private static JComboBox cboList;


	//public static Category selectedCate;

	public SanPham_GUI() {
		setTitle("Quản lý sản phẩm");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 550);
		setLocationRelativeTo(null);
	
		//pn chính
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JPanel pnBorder=new JPanel();
		contentPane.add(pnBorder);
		pnBorder.setLayout(new BorderLayout());
	
		JPanel pnNorth=new JPanel();
	
		JLabel lblTitle=new JLabel("Quản lý sản phẩm");
	
		Font ftTitle=new Font("arial", Font.BOLD, 32);
	
		lblTitle.setFont(ftTitle);
	
		lblTitle.setForeground(Color.BLUE);
	
		pnNorth.add(lblTitle);
	
		pnBorder.add(pnNorth,BorderLayout.NORTH);
	
		//Khai báo pn chứa list thể loại và list sản phẩm
		JPanel pnListTheloai=new JPanel();
	
		JPanel pnListProduct=new JPanel();
	
		JSplitPane slitPane=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pnListTheloai, pnListProduct);
	
		pnBorder.add(slitPane,BorderLayout.CENTER);
	
		pnListTheloai.setLayout(new BorderLayout());
		listmodeTheloai = new DefaultListModel<String>();
		listmodeTheloai.addElement("Truyện conan");
		listmodeTheloai.addElement("Truyện doraemon");
		listmodeTheloai.addElement("Sách giáo khoa");
		listmodeTheloai.addElement("Sách khoa học");
		listmodeTheloai.addElement("Truyện 7 viên ngọc rồng");
		listmodeTheloai.addElement("Sách bài tập");
		listmodeTheloai.addElement("Truyện cổ tích");
		
	
		lstTheloai=new JList(listmodeTheloai);
	
		TitledBorder cateborder=new TitledBorder(BorderFactory.createLineBorder(Color.RED), "Danh mục sản phẩm");
	
		lstTheloai.setBorder(cateborder);
		
	
		pnListTheloai.setPreferredSize(new Dimension(300, 0));
	
		pnListTheloai.add(lstTheloai,BorderLayout.CENTER);
	
		JPanel pnListCateSouth=new JPanel();
	
		btnCateNew =new JButton("Tạo");
	
		pnListCateSouth.add(btnCateNew);
	
		btnCateUpdate =new JButton("Sửa");
	
		pnListCateSouth.add(btnCateUpdate);
	
		btnCateRemove =new JButton("Xóa");
	
		pnListCateSouth.add(btnCateRemove);
	
		pnListTheloai.add(pnListCateSouth,BorderLayout.SOUTH);
	
		
		//pn sản phẩm
		pnListProduct.setLayout(new BorderLayout());
	
		JPanel pnProductTitle=new JPanel();
	
		JLabel lblProductTitle=new JLabel("Thông tin chi tiết");
	
		pnProductTitle.add(lblProductTitle);
	
		pnListProduct.add(pnProductTitle,BorderLayout.NORTH);
	
		
		JPanel pnProductTable=new JPanel(); //Khai báo pn chưa table
	
		pnProductTable.setLayout(new BorderLayout());
	
		pnListProduct.add(pnProductTable,BorderLayout.CENTER);
	
		//Bảng thông tin 
		dtmProduct =new DefaultTableModel();
	
		dtmProduct.addColumn("Mã sản phẩm");
	
		dtmProduct.addColumn("Tên sản phẩm");
	
		dtmProduct.addColumn("Đơn giá");
	
		dtmProduct.addColumn("Số lượng");
	
		dtmProduct.addColumn("Mô tả");
	
		tblProduct=new JTable(dtmProduct);
	
		JScrollPane sctblproduct=new JScrollPane(tblProduct );
	
		pnProductTable.add(sctblproduct,BorderLayout.CENTER);
		
		//pn chi tiết sản phẩm
		JPanel pnProductDetail=new JPanel();
	
		pnListProduct.add(pnProductDetail,BorderLayout.SOUTH);
	
		pnProductDetail.setLayout(new BoxLayout(pnProductDetail, BoxLayout.Y_AXIS ));
	
		JPanel pnCateList=new JPanel();
	
		JLabel lblCateId=new JLabel("Thể loại:");
		cboList=new JComboBox();
	
		pnCateList.add(lblCateId);
	
		pnCateList.add(cboList);
	
		pnProductDetail.add(pnCateList);
	
		JPanel pnProductId=new JPanel();
	
		JLabel lblProId=new JLabel("Mã sản phẩm:");
	
		txtId=new JTextField(20);
	
		pnProductId.add(lblProId);
	
		pnProductId.add(txtId);
	
		pnProductDetail.add(pnProductId);
	
		JPanel pnProductName=new JPanel();
	
		JLabel lblProName=new JLabel("Tên sản phẩm:");
	
		txtName=new JTextField(20);
	
		pnProductName.add(lblProName);
	
		pnProductName.add(txtName);
	
		pnProductDetail.add(pnProductName);
	
		JPanel pnProductUnitPrice=new JPanel();
	
		JLabel lblUnitPrice=new JLabel("Đơn giá:");
	
		txtUnitprice=new JTextField(20);
	
		pnProductUnitPrice.add(lblUnitPrice);
	
		pnProductUnitPrice.add(txtUnitprice);
	
		pnProductDetail.add(pnProductUnitPrice);
	
		JPanel pnProductQuantity=new JPanel();
	
		JLabel lblQuantity=new JLabel("Số lượng:");
	
		txtQuantity=new JTextField(20);
	
		pnProductQuantity.add(lblQuantity);
	
		pnProductQuantity.add(txtQuantity);
	
		pnProductDetail.add(pnProductQuantity);
	
		JPanel pnProductDescription=new JPanel();
	
		JLabel lblDescription=new JLabel("Mô tả:");
	
		txtDescription=new JTextArea(4, 22);
	
		JScrollPane scare=new JScrollPane(txtDescription);
	
		pnProductDescription.add(lblDescription);
	
		pnProductDescription.add(scare);
	
		pnProductDetail.add(pnProductDescription);
	
		JPanel pnButton=new JPanel();
	
		btnNew=new JButton("Tạo mới");
	
		btnSave=new JButton("Lưu");
	
		btnRemove=new JButton("Xóa");
	
		pnButton.add(btnNew);
	
		pnButton.add(btnSave);
	
		pnButton.add(btnRemove);
	
		pnProductDetail.add(pnButton);
	
		cboList.setPreferredSize(txtName.getPreferredSize());
		cboList.setPreferredSize(txtId.getPreferredSize());
		cboList.setPreferredSize(txtUnitprice.getPreferredSize());
		cboList.setPreferredSize(txtQuantity.getPreferredSize());
	
	
		lblCateId.setPreferredSize(lblProName.getPreferredSize());
	
		lblDescription.setPreferredSize(lblProName.getPreferredSize());
	
		lblQuantity.setPreferredSize(lblProName.getPreferredSize());
	
		lblUnitPrice.setPreferredSize(lblProName.getPreferredSize());
	
		lblProId.setPreferredSize(lblProName.getPreferredSize());
	
		Container con=getContentPane();
	
		con.add(pnBorder);


	}
//	
	public JPanel getContentPane() {
		return this.contentPane;
	}
			
	public static void main(String[] args) {
		new SanPham_GUI().setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
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

}
