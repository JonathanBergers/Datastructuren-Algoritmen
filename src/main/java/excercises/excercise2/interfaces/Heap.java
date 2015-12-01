package excercises.excercise2.interfaces;

import java.util.List;

/**
 * Created by jonathan on 1-12-15.
 */
public interface Heap {


    /**use for initialization
     * fills the heap with the items
     *
     *
     *
     * @param items
     */
    void fillHeap(int[] items);

    /**Processes the input and writes to the output.
     *
     * Psuedocode
     *
     * @param input
     */
    void processInput(int input);


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
    int removeFirst();


    /**writes the input to the dead space
     *
     * @param input
     */
    void insertToDeadspace(int input);


    /**writes the input to the heap
     *
     * @param input
     */
    void insertToHeap(int input);


    /**Use heapsort to sort the heap
     *
     */
    void sortHeap();








}
