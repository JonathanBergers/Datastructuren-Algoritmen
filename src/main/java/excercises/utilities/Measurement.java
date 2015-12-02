package excercises.utilities;

import com.sun.istack.internal.Nullable;
import org.jfree.data.xy.XYDataItem;

/**
 * Created by jonathan on 22-11-15.
 */
public interface Measurement<T> {


    default  XYDataItem measure(final int xPosition, @Nullable T input){

        long startTime = System.currentTimeMillis();
        doSomeWork(input);
        long endTime = System.currentTimeMillis();
        return new XYDataItem(xPosition, endTime-startTime);

    }

    void doSomeWork(@Nullable T input);


}
