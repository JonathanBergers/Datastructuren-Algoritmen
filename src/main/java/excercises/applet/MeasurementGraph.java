package excercises.applet;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.Dataset;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeTableXYDataset;
import org.jfree.data.xy.*;
import org.jfree.ui.RefineryUtilities;

import javax.swing.*;

/**
 * Created by jonathan on 18-11-15.
 */
public class MeasurementGraph extends JFrame{

    XYSeriesCollection dataset;
    private final String title, xLabel, yLabel;

    public void render(){




        // based on the dataset we create the chart
        JFreeChart chart = ChartFactory.createXYLineChart(title, xLabel, yLabel, dataset);
        // we put the chart into a panel
        ChartPanel chartPanel = new ChartPanel(chart);
        // default size
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        // add it to our application

        setContentPane(chartPanel);

        //show
        pack();
        RefineryUtilities.centerFrameOnScreen(this);
        setVisible(true);
    }



    public void addXYSeries(XYSeries series){


        dataset.addSeries(series);
    }

    public MeasurementGraph(String title, String xLabel, String yLabel, XYSeriesCollection dataset) {
        this.title = title;
        this.xLabel = xLabel;
        this.yLabel = yLabel;
        this.dataset = dataset;




    }
    public MeasurementGraph(String title, String xLabel, String yLabel) {
        this.title = title;
        this.xLabel = xLabel;
        this.yLabel = yLabel;
        this.dataset = new XYSeriesCollection();

    }




    private XYDataset generateRandomDataset(){


        final XYSeries series1 = new XYSeries("First");
        series1.add(1.0, 1.0);
        series1.add(2.0, 4.0);

        return new XYSeriesCollection(series1);
    }
}
