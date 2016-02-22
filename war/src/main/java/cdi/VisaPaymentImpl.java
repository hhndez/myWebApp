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
//@Named("visa")
@VisaPayment
public class VisaPaymentImpl implements Payment {

    private static final Logger LOGGER  = Logger.getLogger(VisaPaymentImpl.class.toString());


    @Override
    public void pay(BigDecimal amount) {
        LOGGER.log(Level.INFO, "payed {0} with visa", amount.toString());
    }
}
