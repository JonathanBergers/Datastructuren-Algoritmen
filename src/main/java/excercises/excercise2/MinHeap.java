package excercises.excercise2;

import excercises.excercise2.interfaces.Heap;
import excercises.utilities.Algorithms;

/**
 * Created by jonathan on 1-12-15.
 */
public class MinHeap implements Heap {

    private final static int EMPTY_SPACE_VALUE = -69;

    private int heapSize;

    private int[] buffer;

    private HeapOutput heapOutput = new HeapOutput();


    public MinHeap(int bufferSize) {
        buffer = new int[bufferSize];
        fillHeap(bufferSize);
    }


    @Override
    public void fillHeap(int itemsSize) {
        for(int i = 0; i<itemsSize; i++){
            buffer[i] = Algorithms.randInt(100);
        }
        buildHeap();
        printHeap();

    }

    @Override
    public void processInput(int input) {
        if(buffer[0]>input){
            heapOutput.write(removeFirstAndInsertToDeadspace(input));
        } else {
            heapOutput.write(removeFirstAndInsertToHeap(input));
        }
        if(heapSize==0){
            buildHeap();
        }
    }

    @Override
    public void buildHeap() {
        heapSize = buffer.length;
        heapOutput.newRun();
        System.out.println("New Run");
        //all the parents
        for(int i = ((heapSize/2)); i>-1; i--){
            if(isParent(i)){
                perculateDown(i);
                perculateDown(i);
            }
        }
    }

    @Override
    public int removeFirstAndInsertToDeadspace(int input) {
        System.out.println("Insert into deadspace " + input);
        heapSize--;
        int first = buffer[0];
        buffer[0] = buffer[heapSize];
        buffer[heapSize] = input;
        sortHeap();
        return first;
    }

    @Override
    public int removeFirstAndInsertToHeap(int input) {
        System.out.println("Insert into heap " + input);
        int first = buffer[0];
        buffer[0] = input;
        sortHeap();
        printHeap();
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
        buffer[(index+1)*2-1] = value;
        return temp;
    }

    private int setRightChild(int index, int value){

        int temp = getRightChild(index);
        buffer[(index+1)*2] = value;
        return temp;
    }



    private void perculateUp(int index){

    }
    private void perculateDown(int index){
        int parentValue = buffer[index];
        if(getRightChild(index) == EMPTY_SPACE_VALUE && getLeftChild(index) == EMPTY_SPACE_VALUE){
            return;
        }
        if(getRightChild(index) == EMPTY_SPACE_VALUE && parentValue>getLeftChild(index)){
            buffer[index] = setLeftChild(index, parentValue);
        }
        if(parentValue>getLeftChild(index) || parentValue > getRightChild(index)){
            if(getLeftChild(index)>=getRightChild(index) && getRightChild(index) != EMPTY_SPACE_VALUE){
                //right must go up and parent to the right
                buffer[index] = setRightChild(index, parentValue);
                if(isParent((index+1)*2)){
                    perculateDown((index+1)*2);
                    perculateDown(index);
                }
            } else {
                //left must go up and parent to the left
                buffer[index] = setLeftChild(index, parentValue);
                if(isParent((index+1)*2-1)){
                    perculateDown(((index+1)*2-1));
                    perculateDown(index);
                }
            }
        }
    }
    private boolean isParent(int index){
        return(((index+1)*2)<=heapSize);
    }
    private void printHeap(){
        System.out.print("Heap = ");
        for(int i =0 ; i<heapSize ; i++){
            System.out.print(buffer[i] + " ");
        }
        System.out.println();
    }
}
