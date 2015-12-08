package excercises.excercise2.interfaces;

/**
 * Created by jonathan on 8-12-15.
 */
public interface ReplacementSelection {


    /**Processes the input and writes to the output.
     *
     * Psuedocode
     *
     */
    void processInput(Input input) throws OutOfInputException;


    Output run();

}
