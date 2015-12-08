package excercises.excercise2;/**
 * Created by falco on 2-12-15.
 */

import com.sun.istack.internal.Nullable;
import excercises.applet.MeasurementGraph;
import excercises.excercise2.interfaces.Output;
import excercises.utilities.Measurement;
import javafx.util.Pair;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Excercise2 {

    public static void main(String[] args) {

        XYSeriesCollection dataset = new XYSeriesCollection();
        new MeasurementGraph("opdracht 2", "N", "H", dataset).render();



        Measurement<Pair<Integer, Integer>> measurement = input -> {
            RSHeap minHeap = new RSHeap(new RandomInput(input.getKey()), input.getValue());
            Output output = minHeap.run();
        };

        int times = 10;

        XYSeries series = new XYSeries("Measurement ");
        for (int i = 1; i <times ; i++) {

            for (int j = 1; j < times; j++) {

                series.add(measurement.measure(i*100, new Pair<>(i*200, j*100)));

            }


        }

        dataset.addSeries(series);






    }


}
