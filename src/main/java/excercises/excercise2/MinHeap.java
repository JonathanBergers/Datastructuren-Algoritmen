package excercises.excercise2;

import excercises.excercise2.interfaces.Heap;

/**
 * Created by jonathan on 1-12-15.
 */
public class MinHeap implements Heap {


    private int heapSize;
    private int[] buffer;


    public MinHeap(int bufferSize) {

        buffer = new int[bufferSize];
    }


    @Override
    public void fillHeap(int[] items) {

    }

    @Override
    public void processInput(int input) {

    }

    @Override
    public void buildHeap() {

    }

    @Override
    public int removeFirst() {
        return 0;
    }

    @Override
    public void insertToDeadspace(int input) {

    }

    @Override
    public void insertToHeap(int input) {

    }

    @Override
    public void sortHeap() {

    }
}
