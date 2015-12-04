package excercises.excercise2;/**
 * Created by falco on 2-12-15.
 */

import excercises.utilities.Algorithms;
import javafx.application.Application;
import javafx.stage.Stage;

public class Excercise2 {

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);
        for(int i =5; i<20;i++){
            minHeap.processInput(i + Algorithms.randInt(80));
        }


    }


}
