package statistics;


import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;


public class StudentGraph extends JFrame {

    private static final long serialVersionUID = 1L;

    public StudentGraph(String applicationTitle, String chartTitle) {
        super(applicationTitle);
        // This will create the dataset
        PieDataset dataset = createStuset();
        // based on the dataset we create the chart
        JFreeChart chart = createChart(dataset, chartTitle);
        // we put the chart into a panel
        ChartPanel chartPanel = new ChartPanel(chart);
        // default size
        chartPanel.setPreferredSize(new java.awt.Dimension(700, 500));
        // add it to our application
        setContentPane(chartPanel);

    }

    /**
     * Creates a sample dataset
     */
    
    private  PieDataset createStuset() {
    	ResultSet rs = null;
    	StatConnection viewStatCon = new StatConnection();
		rs = viewStatCon.studentLevel();
		 
	
        DefaultPieDataset result = new DefaultPieDataset();
        try {
			while( rs.next( ) ) {
			     result.setValue( 
			     rs.getString( "programme" ) ,
			     Double.parseDouble( rs.getString( "count" )));     
			  }
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return result;
    } 

    /**
     * Creates a chart
     */
    private JFreeChart createChart(PieDataset dataset, String title) {

        JFreeChart chart = ChartFactory.createPieChart3D(
            title,                  // chart title
            dataset,                // data
            true,                   // include legend
            true,
            false
        );

        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setStartAngle(290);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);
        return chart;

    }
}

