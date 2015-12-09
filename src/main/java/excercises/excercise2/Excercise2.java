package excercises.excercise2;/**
 * Created by falco on 2-12-15.
 */

import com.sun.istack.internal.Nullable;
import excercises.applet.MeasurementGraph;
import excercises.excercise2.interfaces.Output;
import excercises.utilities.Measurement;
import excercises.utilities.XYMeasurement;
import javafx.util.Pair;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.util.IntSummaryStatistics;

public class Excercise2 {

    public static void main(String[] args) {

        XYSeriesCollection dataset = new XYSeriesCollection();

        new MeasurementGraph("opdracht 2", "Meting Nr","R(runlength)",  dataset).render();


        //meting voor Heapsize = 100, N = 1000
        dataset.addSeries(measureReplacementSelection(1000, 500, 100, new XYSeries("Heapsize 500, N 1000")));
        dataset.addSeries(measureReplacementSelection(1000, 200, 100, new XYSeries("Heapsize 200, N 1000")));
        dataset.addSeries(measureReplacementSelection(1000, 100, 100, new XYSeries("Heapsize 100, N 1000")));
        dataset.addSeries(measureReplacementSelection(1000, 100, 100, new XYSeries("Heapsize 100, N 300000000")));







    }


    private static void measure(){





    }


    /**doe een aantal metingen en zet average run length Y tegenover meting nr X
     *
     * @param n
     * @param h
     * @return
     */
    private static XYSeries measureReplacementSelection(final int n , final int h, final int times, XYSeries xySeries){

        if(times == 0){
            return xySeries;
        }


        RSHeap minHeap = new RSHeap(new RandomInput(n), h);
        HeapOutput output = minHeap.run();

        final int avgsize= (int) output.getAverageRunLength();

        System.out.println(avgsize);

        xySeries.add(times, avgsize);


        return measureReplacementSelection(n, h, times-1, xySeries);


    }





}
