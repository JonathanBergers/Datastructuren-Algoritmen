package excercises.excercise2;

import excercises.excercise2.interfaces.*;
import excercises.utilities.Algorithms;

/**
 * Created by jonathan on 1-12-15.
 */
public class RSHeap implements Heap, ReplacementSelection {

    private final static int EMPTY_SPACE_VALUE = -69;
    private int heapSize;
    private final int[] buffer;
    private HeapOutput heapOutput = new HeapOutput();
    private Input input;

    public RSHeap(RandomInput input, int bufferSize) {
        heapSize = bufferSize;
        this.buffer = new int[heapSize +1];
        this.input = input;



    }

    /**Sorts the input and writes the runs to the output.
     *
     * @return
     */
    public Output run(){
        fillHeap(input);

        while (true){
            try {
                processInput(input);
            } catch (OutOfInputException e) {

                //TODO NOT WORKING, RUN OF LENGTH 0
                clearHeapToOutput();
                return heapOutput;
            }
        }


    }


    @Override
    public void fillHeap(Input input){

        for(int i = 0; i<heapSize; i++){
            try {
                buffer[i] = input.getInput();
            } catch (OutOfInputException e) {
                heapSize = i;
                break;
            }
            // for smaller input

        }

        buildHeap();

    }

    @Override
    public void processInput(Input input) throws OutOfInputException {
        int inputNumber;
        inputNumber = input.getInput();



        if(buffer[0]>inputNumber){
            heapOutput.write(removeFirstAndInsertToDeadspace(inputNumber));
        } else {
            heapOutput.write(removeFirstAndInsertToHeap(inputNumber));
        }
        // when heap is empty
        if(heapSize==0){
            buildHeap();
        }



    }

    public void clearHeapToOutput(){


        //take deadspace
        heapSize = buffer.length;




        //TODO BUG
        // sort the heap
        //all the parents

        heapOutput.newRun();
        for(int i = heapSize-1; i>=0; i--){
            perculateDown(i);
        }

        // write all sorted elements to the output
        for(int i = heapSize; i>0 ; i--){
            heapOutput.write(removeFirstAndInsertToDeadspace(EMPTY_SPACE_VALUE));
        }

    }

    @Override
    public void buildHeap() {

        //when fillheap cant complete cuz input, then heapsize = input. so
        // only when size = deadspace  then reset heapsize
        if(heapSize == 0){
            heapSize = buffer.length;

        }

        heapOutput.newRun();
        //all the parents
        for(int i = heapSize-1; i>=0; i--){
            perculateDown(i);
        }

    }

    @Override
    public int removeFirstAndInsertToDeadspace(int input) {
        //System.out.println("Insert into deadspace " + input);
        heapSize--;
        int first = buffer[0];
        buffer[0] = buffer[heapSize];
        buffer[heapSize] = input;
        sortHeap();

        //printHeap();
        return first;
    }

    @Override
    public int removeFirstAndInsertToHeap(int input) {
        //System.out.println("Insert into heap " + input);
        int first = buffer[0];
        buffer[0] = input;
        sortHeap();
        //printHeap();
        return first;
    }



    @Override
    public void sortHeap() {
        perculateDown(0);
    }




    private int getLeftChild(int index){
        if(heapSize-1 < ((index+1)*2-1)){
            return EMPTY_SPACE_VALUE;
        }
        return buffer[(index+1)*2-1];
    }

    private int getRightChild(int index){
        if(heapSize-1 < (index+1)*2){
            return EMPTY_SPACE_VALUE;
        }
        return buffer[(index+1)*2];
    }

    private int setLeftChild(int index, int value){
        int temp = getLeftChild(index);
        buffer[((index+1)*2)-1] = value;
        return temp;
    }

    private int setRightChild(int index, int value){

        int temp = getRightChild(index);
        buffer[(index+1)*2] = value;
        return temp;
    }

    private void perculateDown(int index){
        int parentValue = buffer[index];
        if(!isParent(index)){
            return;
        } else if(getLeftChild(index)>getRightChild(index) && getRightChild(index) != EMPTY_SPACE_VALUE){
            //right down
            if(parentValue>getRightChild(index)){
                buffer[index] = setRightChild(index, buffer[index]);
                perculateDown((index+1)* 2);
            }
        } else {
            //left down
            if(parentValue>getLeftChild(index)){
                buffer[index] = setLeftChild(index, buffer[index]);
                perculateDown(((index+1)*2-1));
            }
        }




    }
    private boolean isParent(int index){
        return (getLeftChild(index) != EMPTY_SPACE_VALUE);
    }


    private void printHeap(){
        System.out.print("Heap = [");
        for(int i =0 ; i<heapSize ; i++){
            System.out.print(buffer[i] + ", ");
        }
        System.out.println("]");
    }
}
