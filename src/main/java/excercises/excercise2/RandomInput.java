package excercises.excercise2;

import excercises.excercise2.interfaces.Input;
import excercises.excercise2.interfaces.OutOfInputException;

/**
 * Created by jonathan on 8-12-15.
 */
public class RandomInput implements Input {

    private int n;


    public RandomInput(int n) {
        this.n = n;
    }


    @Override
    public int getInput() throws OutOfInputException {
        if(n == 0){
            throw new OutOfInputException();
        }
        n --;

        return (int) (Math.random() * 1000 * Math.random());
    }


}
