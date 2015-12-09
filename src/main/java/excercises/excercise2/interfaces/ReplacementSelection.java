package excercises.excercise2.interfaces;

/**
 * Created by jonathan on 8-12-15.
 */
public interface ReplacementSelection<I extends Input, O extends Output> {


    /**Processes the input and writes to the output.
     *
     * Psuedocode
     *
     */
    void processInput(I input) throws OutOfInputException;


    O run();

}
