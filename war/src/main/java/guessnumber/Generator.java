package guessnumber;

import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
/**
 * Created on 12/10/15.
 *
 * @author hhernandez
 */
@ApplicationScoped
public class Generator implements Serializable {
    private static final long serialVersionUID = -732343243243413243L;

    private java.util.Random random =
            new java.util.Random(System.currentTimeMillis());

    private int maxNumber = 100;

    java.util.Random getRandom() {
        return random;
    }

    @Produces @Random int next() {
        return getRandom().nextInt(maxNumber);
    }

    @Produces @MaxNumber int getMaxNumber() {
        return maxNumber;
    }
}
