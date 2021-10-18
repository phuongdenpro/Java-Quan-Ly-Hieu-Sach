package GUI;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.DefaultCategoryItemRenderer;
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultValueDataset;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities; 

public class BarChart_AWT extends ApplicationFrame {
   
   public BarChart_AWT( String applicationTitle , String chartTitle ) {
      super( applicationTitle );        
      JFreeChart barChart = ChartFactory.createBarChart(
         chartTitle,           
         "Category",            
         "Score",            
         createDataset(),          
         PlotOrientation.VERTICAL,           
         true, true, false);
         
      ChartPanel chartPanel = new ChartPanel( barChart );        
      chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
      setContentPane( chartPanel ); 
   }
   
   private CategoryDataset createDataset( ) {
      final String conLai = "Còn lại";
      final String daBan = "Đã bán";
      final String ford = "FORD";
      final DefaultCategoryDataset dataset = 
      new DefaultCategoryDataset( ); 

      dataset.addValue( 120 , conLai , "Truyện conan" );        
      dataset.addValue( 50 , conLai , "Giáo trình tư tưởng" );        
      dataset.addValue( 80 , conLai , "Bút bi" ); 
      dataset.addValue( 20 , conLai , "Vở viết" );           

      dataset.addValue( 12 , daBan , "Truyện conan" );        
      dataset.addValue( 131 , daBan , "Giáo trình tư tưởng" );       
      dataset.addValue( 30 , daBan , "Bút bi" );        
      dataset.addValue( 1 , daBan , "Vở viết" );             

      return dataset; 
   }
   
   public static void main( String[ ] args ) {
      BarChart_AWT chart = new BarChart_AWT("Car Usage Statistics", 
         "Which car do you like?");
      chart.pack( );        
      RefineryUtilities.centerFrameOnScreen( chart );        
      chart.setVisible( true ); 
   }
}
