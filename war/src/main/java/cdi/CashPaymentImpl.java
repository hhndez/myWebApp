package cdi;

import javax.inject.Named;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created on 12/10/15.
 *
 * @author hhernandez
 */
//@Named("cash")
@CashPayment
public class CashPaymentImpl implements Payment {

    private static final Logger LOGGER  = Logger.getLogger(CashPaymentImpl.class.toString());


    @Override
    public void pay(BigDecimal amount) {
        LOGGER.log(Level.INFO, "payed {0} cash", amount.toString());
    }
}
