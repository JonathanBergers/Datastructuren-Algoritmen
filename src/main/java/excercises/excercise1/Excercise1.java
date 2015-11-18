package excercises.excercise1;

import excercises.applet.MeasurementGraph;
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
        plotEx1();
    }

    private static void plotEx1(){


        XYSeriesCollection dataset = new XYSeriesCollection();

        XYSeries series = new XYSeries("algorithm1");

        Function<Integer, Object> algorithm1 = new Function<Integer, Object>() {
            public Object apply(Integer integer) {
                Algorithms.algorithm1(integer, 0, integer);
                return null;
            }
        };

        series.add(measureAlgorithm(1000,algorithm1));
        series.add(measureAlgorithm(10000,algorithm1));
        series.add(measureAlgorithm(20000,algorithm1));
        series.add(measureAlgorithm(50000,algorithm1));
        series.add(measureAlgorithm(100000,algorithm1));
        dataset.addSeries(series);

        new MeasurementGraph("opdracht 1", "T", "N", dataset).render();

    }

    private static XYDataItem measureAlgorithm(int n, Function<Integer, Object> algorithmCall){

        long startTime = System.currentTimeMillis();
        algorithmCall.apply(n);
        long endTime = System.currentTimeMillis();
        return new XYDataItem(endTime-startTime, n);
    }



    static class Algorithms{


        /**Generates an array of length n
         * with a random permutation of the numbers between the left and rightbound
         *
         * @param n
         * @param leftBound the left number for the range of the random numbers
         * @param rightBound right bound for the range for random numbers
         * @return
         */
        public static int[] algorithm1(int n, int leftBound, int rightBound){
            assert leftBound < rightBound: "choose a leftbound smaller than the rightbound";
            assert rightBound - leftBound > n: "not enough random numbers possible";


            int[] permutations = new int[n];

            for(int k=0; k<n; k++){
                int randomNumber = randInt(leftBound, rightBound);
                while(isInArray(randomNumber, permutations)){
                    randomNumber = randInt(leftBound, rightBound);
                }
                permutations[k]=randomNumber;
            }

            return permutations;
        }
        private static boolean isInArray(int i, int[] array){
            for(int j : array){
                if(j==i){
                    return true;
                }
            }
            return false;
        }

        //TODO Javadoc
        public static int[] algorithm2(int n, int leftBound, int rightBound){
            int[] a = new int[n];
            boolean[] used = new boolean[rightBound];
            for(int k=0; k<n; k++){
                int number = randInt(leftBound, rightBound);
                while(used[number]){
                    number = randInt(leftBound, rightBound);
                }
                used[number]=true;
                a[k]=number;
            }
            return a;
        }

        //opdracht 3 shit
        public static int[] algorithm3(int n){
            int[] a = new int[n];
            for(int k=0; k<n; k++){
                a[k]=k;
                swap(a, k, randInt(0, k));
            }
            return a;
        }

        private static int[] swap(int[] a, int index1, int index2){
            int i = a[index1];
            a[index1] = a[index2];
            a[index2] = i;
            return a;
        }






        private static int randInt(int i, int j){
            return (int) (Math.random() * (j-i)) +i;
        }
        private static String arrayToString(int[] a){
            String s = "|";
            for(int i : a){
                s+=i;
                s+="|";
            }
            return s;
        }

    }



}
