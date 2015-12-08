package excercises.excercise2.interfaces;

import excercises.excercise2.RandomInput;

import java.util.List;

/**
 * Created by jonathan on 1-12-15.
 */
public interface Heap {



    /**use for initialization
     * fills the heap with the items
     *
     */
    void fillHeap(Input input) throws OutOfInputException;


    /**sorts the heap
     * use after fill heap
     *
     */
    void buildHeap();


    /**removes and returns the first element of the heap
     * smallest int, (minheap)
     * largest int, (maxheap)
     *
     * @return
     */
    int removeFirstAndInsertToDeadspace(int input);


    /**writes the input to the heap
     *
     * @param input
     */
    int removeFirstAndInsertToHeap(int input);


    /**Use heapsort to sort the heap
     *
     */
    void sortHeap();








}
