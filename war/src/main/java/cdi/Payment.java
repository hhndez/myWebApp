package cdi;

import java.math.BigDecimal;

/**
 * Created on 12/10/15.
 *
 * @author hhernandez
 */
public interface Payment {

    void pay(BigDecimal amount);
}
