package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

import dao.HoaDonDAO;
import dao.KhachHangDAO;
import dao.SanPhamDAO;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.util.Random;

public class ThongKe_GUI extends JFrame {
	Day today = new Day();
	Date now = new Date(new java.util.Date().getTime());
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThongKe_GUI frame = new ThongKe_GUI();
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
	public ThongKe_GUI() throws SQLException {
		setTitle("Thống kê");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(0, 0, 1300, 700);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width, screenSize.height);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		JPanel pnContent = new JPanel();
		JScrollPane pane = new JScrollPane(pnContent);
		pane.getVerticalScrollBar().setUnitIncrement(20);
		pane.setPreferredSize(new Dimension(1400, 700));
		pane.setBorder(null);
		contentPane.add(pane);
		pnContent.setLayout(new BoxLayout(pnContent, BoxLayout.Y_AXIS));

		JPanel pnThongTinChung = new JPanel();
		pnContent.add(pnThongTinChung);
		pnThongTinChung.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel pnGridThongTinChung = new JPanel();
		pnGridThongTinChung.setPreferredSize(new Dimension(1300, 150));
		pnThongTinChung.add(pnGridThongTinChung);
		pnGridThongTinChung.setLayout(new GridLayout(0, 4, 20, 0));
		
		ImageIcon icon_sold = new ImageIcon("data/images/sold.png");
		int spDaBanHomNay = new SanPhamDAO().soLuongDaBanHomNay();
		pnGridThongTinChung.add(this.dashboardGeneralGUI("Đã bán hôm nay", spDaBanHomNay+" sản phẩm", icon_sold, new Color(32, 178, 170)));
		
		ImageIcon icon_customer = new ImageIcon("data/images/customer.png");
		int soLuongKH = new KhachHangDAO().soLuongKhachHang();
		pnGridThongTinChung.add(this.dashboardGeneralGUI("Khách hàng", soLuongKH+" khách hàng", icon_customer, new Color(0, 255, 127)));
		
		ImageIcon icon_profit = new ImageIcon("data/images/financial-profit.png");
		
		double loiNhuanHomNay = new HoaDonDAO().thongKeLoiNhuan(now);
		pnGridThongTinChung.add(this.dashboardGeneralGUI("Lợi nhuận hôm nay", String.valueOf(loiNhuanHomNay)+"đ", icon_profit, new Color(0, 191, 255)));
		
		ImageIcon icon_traffic = new ImageIcon("data/images/web-traffic.png");
		pnGridThongTinChung.add(this.dashboardGeneralGUI("Lượt truy cập", "123 lượt", icon_traffic, new Color(255, 255, 0)));
		
		JPanel pnBieuDo = new JPanel();
		pnContent.add(pnBieuDo);
		pnBieuDo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel pbGridBieuDo = new JPanel();
		pbGridBieuDo.setBorder(null);
		pbGridBieuDo.setPreferredSize(new Dimension(1300, 1000));
//		panel_2.add(panel_3);
//		JScrollPane scrollPane = new JScrollPane(panel_3);
//		scrollPane.setBorder(null);
		pnBieuDo.add(pbGridBieuDo);
		
		
		
		// chart
        GridBagLayout gbl_pbGridBieuDo = new GridBagLayout();
        gbl_pbGridBieuDo.columnWidths = new int[] {1000, 400};
        gbl_pbGridBieuDo.rowHeights = new int[] {0};
        gbl_pbGridBieuDo.columnWeights = new double[]{1.0, 1.0};
        gbl_pbGridBieuDo.rowWeights = new double[]{1.0};
        pbGridBieuDo.setLayout(gbl_pbGridBieuDo);
        
        JPanel pnLeft = new JPanel();
        pnLeft.setPreferredSize(new Dimension(10, 1000));
        GridBagConstraints gbc_pnLeft = new GridBagConstraints();
        gbc_pnLeft.insets = new Insets(0, 0, 5, 5);
        gbc_pnLeft.fill = GridBagConstraints.BOTH;
        gbc_pnLeft.gridx = 0;
        gbc_pnLeft.gridy = 0;
        pbGridBieuDo.add(pnLeft, gbc_pnLeft);
        
        // lợi nhuận
        JFreeChart jfreechart = createProfitChart();
        pnLeft.setLayout(new GridLayout(0, 1, 0, 20));
        ChartPanel pnChartLoiNhuan = new ChartPanel(jfreechart, true, true, true, false, true);
        pnLeft.add(pnChartLoiNhuan);
        
        // Số lượng sản phẩm còn lại
        JFreeChart productChart = createProductChart();
        ChartPanel pnChartSanPhamDaBan = new ChartPanel(productChart, true, true, true, false, true);
        pnLeft.add(pnChartSanPhamDaBan);
        
        
        JPanel pnRight = new JPanel();
        GridBagConstraints gbc_pnRight = new GridBagConstraints();
        gbc_pnRight.insets = new Insets(0, 0, 0, 5);
        gbc_pnRight.fill = GridBagConstraints.BOTH;
        gbc_pnRight.gridx = 1;
        gbc_pnRight.gridy = 0;
        pbGridBieuDo.add(pnRight, gbc_pnRight);
        
        // tỷ lệ sản phẩm bán ra
        JFreeChart pieChart = createRatioProductSoldChart(createRatioProductSoldDataset());
        pnRight.setLayout(new BoxLayout(pnRight, BoxLayout.Y_AXIS));
        ChartPanel pnChartTyLeBanSP = new ChartPanel(pieChart);
        pnRight.add(pnChartTyLeBanSP);
        
        ChartPanel pnChart = new ChartPanel((JFreeChart) null);
        pnRight.add(pnChart);
	}
	
	private JPanel dashboardGeneralGUI(String title, String content, ImageIcon icon, Color color) {
		JPanel pnThongTin = new JPanel();
		pnThongTin.setBackground(color);
		GridBagLayout gbl_pnThongTin = new GridBagLayout();
		gbl_pnThongTin.columnWidths = new int[] {60, 0};
		gbl_pnThongTin.rowHeights = new int[] {150, 0};
		gbl_pnThongTin.columnWeights = new double[]{1.0, 1.0};
		gbl_pnThongTin.rowWeights = new double[]{0.0, 1.0};
		pnThongTin.setLayout(gbl_pnThongTin);
		
		
		
		JPanel pnIcon = new JPanel();
		GridBagConstraints gbc_pnIcon = new GridBagConstraints();
		gbc_pnIcon.insets = new Insets(0, 0, 5, 5);
		gbc_pnIcon.fill = GridBagConstraints.BOTH;
		gbc_pnIcon.gridx = 0;
		gbc_pnIcon.gridy = 0;
		pnThongTin.add(pnIcon, gbc_pnIcon);
		pnIcon.setLayout(new GridLayout(0, 1, 0, 0));
		pnIcon.setBackground(new Color(0, 0, 0, 0));
		
		
		JLabel lblIcon = new JLabel(icon);
		lblIcon.setHorizontalAlignment(SwingConstants.CENTER);
		pnIcon.add(lblIcon);
		
		JPanel pnTieuDe = new JPanel();
		GridBagConstraints gbc_pnTieuDe = new GridBagConstraints();
		gbc_pnTieuDe.insets = new Insets(0, 0, 5, 0);
		gbc_pnTieuDe.fill = GridBagConstraints.BOTH;
		gbc_pnTieuDe.gridx = 1;
		gbc_pnTieuDe.gridy = 0;
		pnThongTin.add(pnTieuDe, gbc_pnTieuDe);
		pnTieuDe.setLayout(new GridLayout(0, 1, 0, 0));
		pnTieuDe.setBackground(new Color(0, 0, 0, 0));
		
		JLabel lblTieuDe = new JLabel(title);
		lblTieuDe.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTieuDe.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblTieuDe.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTieuDe.setAlignmentY(0.0f);
		pnTieuDe.add(lblTieuDe);
		
		JLabel lblNoiDung = new JLabel(content);
		lblNoiDung.setVerticalAlignment(SwingConstants.TOP);
		lblNoiDung.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnTieuDe.add(lblNoiDung);
		
		return pnThongTin;
	}
	

	private JFreeChart createRatioProductSoldChart(PieDataset dataset) {
        JFreeChart chart = ChartFactory.createPieChart(
                "Tỷ lệ sản phẩm bán ra", dataset, true, true, true);
//        chart.setAntiAlias(true);
        chart.setBorderVisible(false);
        chart.setBackgroundPaint(Color.WHITE);
        chart.getPlot().setBackgroundPaint(new Color(0, 0, 0, 0));
//        chart.setBackgroundImage(null);
        return chart;
    }
	
    private PieDataset createRatioProductSoldDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Truyện conan", new Double(25.0));
        dataset.setValue("Giáo trình tư tưởng Hồ Chí Minh", new Double(66.0));
        dataset.setValue("Bút bi", new Double(9.0));
        return dataset;
    }
	
	private JFreeChart createProfitChart() throws SQLException {
		XYDataset xydataset = createProfitDataset();
		String s = "Lợi nhuận";
		JFreeChart jfreechart = ChartFactory.createTimeSeriesChart(s, "Ngày", "Lợi nhuận theo ngày (ngàn đồng)", xydataset, true, true, false);
		XYPlot xyplot = (XYPlot)jfreechart.getPlot();
		NumberAxis numberaxis = (NumberAxis)xyplot.getRangeAxis();
		numberaxis.setLowerMargin(0.40000000000000002D);
		DecimalFormat decimalformat = new DecimalFormat("00.00");
		numberaxis.setNumberFormatOverride(decimalformat);
		XYItemRenderer xyitemrenderer = xyplot.getRenderer();
		xyitemrenderer.setBaseToolTipGenerator(new StandardXYToolTipGenerator("{0}: ({1}, {2})", new SimpleDateFormat("d-MMM-yyyy"), new DecimalFormat("0.00")));
		jfreechart.getPlot().setBackgroundPaint(new Color(0, 0, 0, 0));
		return jfreechart;
	 }

	 private XYDataset createProfitDataset() throws SQLException {
		TimeSeries timeseries = new TimeSeries("Lợi nhuận", org.jfree.data.time.Day.class);
		Random rand = new Random();
		Day tuNgay = getNgay30();
		int d = tuNgay.getDayOfMonth();
		int m = tuNgay.getMonth();
		int y = tuNgay.getYear();
		
//		System.out.println(tuNgay);
//		Date it = now;
//		it.setDate(it.getDate());
		for(int i=0; i<30; i++) {
			System.out.println(d +" "+ m +" "+ y);
			timeseries.add(new Day(d, m, y), new HoaDonDAO().thongKeLoiNhuan(new Date(2021, m, d)));
			d++;
			if(d > getSoNgay(m)) {
				d = 1;
				m++;
				if(m > 12) {
					m = 1;
					y++;
				}
			}
		}
		
		return new TimeSeriesCollection(timeseries);
	 }
	 
	 private Day getNgay30() {
		 int d = getSoNgay(today.getMonth()-1) - (30-today.getDayOfMonth());
		 return new Day(d, today.getMonth()-1, today.getYear());
	 }
	 
	 private int getSoNgay(int m) {
		 if(m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12)
			 return 31;
		 else if(m == 4 || m == 6 || m == 9 || m == 11)
			 return 30;
		 else
			 return 28;
	 }
	
	 private JFreeChart createProductChart() {
		 JFreeChart barChart = ChartFactory.createBarChart(
		     "Số lượng sản phẩm đã bán và còn lại",
		     "Sản phẩm",
		     "Số lượng",
		     createProductDataset(),
		     PlotOrientation.VERTICAL,
		     true, true, false);
		 barChart.getPlot().setBackgroundPaint(new Color(0, 0, 0, 0));
		 return barChart;
	 }
	 
	 private CategoryDataset createProductDataset( ) {
	      final String conLai = "Còn lại";
	      final String daBan = "Đã bán";
	      final DefaultCategoryDataset dataset = 
	      new DefaultCategoryDataset( ); 

	      dataset.addValue( 120 , conLai , "Truyện conan" );        
	      dataset.addValue( 50 , conLai , "Giáo trình tư tưởng" );        
	      dataset.addValue( 80 , conLai , "Bút bi" ); 
	      dataset.addValue( 20 , conLai , "Vở viết" );
	      dataset.addValue( 20 , conLai , "Mực" );        

	      dataset.addValue( 12 , daBan , "Truyện conan" );        
	      dataset.addValue( 131 , daBan , "Giáo trình tư tưởng" );       
	      dataset.addValue( 30 , daBan , "Bút bi" );        
	      dataset.addValue( 1 , daBan , "Vở viết" );             
	      dataset.addValue( 13 , daBan , "Mực" );  
	      
	      return dataset; 
	 }
	 
	 
	 public JPanel getContentPane() {
		 return this.contentPane;
	 }
}
