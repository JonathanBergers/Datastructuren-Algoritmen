package excercises.utilities;

import com.sun.istack.internal.Nullable;
import org.jfree.data.xy.XYDataItem;

/**
 * Created by jonathan on 9-12-15.
 */
public interface XYMeasurement<T> {


    default XYDataItem measure(final int xPosition, T input){
        return new XYDataItem(xPosition, doSomeWork(input));
    }

    /**DO some work and return the y value
     *
     * @param input
     * @return Y VALUE
     */
    int doSomeWork(T input);
}
