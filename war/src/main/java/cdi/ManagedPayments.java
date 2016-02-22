package cdi;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created on 12/10/15.
 *
 * @author hhernandez
 */
public class ManagedPayments {

//    @Inject private @Named("visa") Payment payment;

    /**
     * en lugar de usar @Named, es mejor usar.
     */
    @Inject private @VisaPayment Payment payment;

}
