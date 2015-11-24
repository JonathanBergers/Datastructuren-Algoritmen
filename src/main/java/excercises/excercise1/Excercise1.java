package excercises.excercise1;

import com.sun.istack.internal.Nullable;
import excercises.applet.MeasurementGraph;
import excercises.utilities.Algorithms;
import excercises.utilities.Measurement;
import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.util.function.Function;

/**
 * Created by jonathan on 18-11-15.
 *
 *
 * Schrijf afzonderlijke programma’s om elk algoritme 10 keer uit te voeren voor elk van de
 volgende waarden van N, en meet de gemiddelde running time in de volgende situaties:
 Algoritme 1 met N = 5.000, 10.000, 20.000, 50.000, 100.000;
 Algoritme 2 met N = 100.000, 500.000, 1.000.000, 5.000.000, 10.000.000;
 Algoritme 3 met N = 5.000.000, 10.000.000, 20.000.000, 40.000.000, 80.000.000.
 *
 */
public class Excercise1 {


    public static void main(String[] args) {


        XYSeriesCollection dataset = measureAlgorithm1("Algorithm1", new XYSeriesCollection(), 10);


        new MeasurementGraph("opdracht 1", "N", "T(ms)", dataset).render();
    }


    /**
     * Measures the algorithm an amount of times and returns the dataset
     */
    private static XYSeriesCollection measureAlgorithm1(final String label, XYSeriesCollection dataset, final int times) {


        if (times == 0) {
            return dataset;
        }

        XYSeries series = new XYSeries(label + " nr " + times);


        Measurement<Integer> measureAlgorithm1 = Algorithms::generatePermutations1;


        System.out.println("Measuring " + label + " nr " +  times);
        series.add(measureAlgorithm1.measure(10000, 10000));
        series.add(measureAlgorithm1.measure(20000, 20000));
        series.add(measureAlgorithm1.measure(50000, 50000));
        series.add(measureAlgorithm1.measure(100000, 100000));
        System.out.println("Measurement done");

        dataset.addSeries(series);

        return measureAlgorithm1(label, dataset, times - 1);

    }


}