package excercises.excercise2;

import excercises.excercise2.interfaces.Output;

import java.util.ArrayList;

/**
 * Created by falco on 2-12-15.
 */
public class HeapOutput implements Output {
    private ArrayList<Integer> output = new ArrayList<>();
    private ArrayList<Integer> runIndices = new ArrayList<>();

    @Override
    public void write(int number) {
        output.add(number);
        if(!isListSorted()){
            System.out.println("not sorted");

        }
        //System.out.println(isListSorted());

    }

    private boolean isListSorted(){
        if(output.size()==1){
            return true;
        }
        for(int i = 1; i<output.size();i++){
            if(output.get(i-1)>output.get(i)){
                return false;
            }
        }

        return true;
    }

    public void newRun(){

        runIndices.add(output.size());

        //System.out.println("New Run, SIZE: " + output.size());
        output.clear();
    }

    public double getAverageRunLength(){
        return runIndices.stream().mapToInt(i -> i).average().orElse(0);

    }


}
