import org.codemanship.CD;
import org.codemanship.CreditCard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PurchaseCDTest {
    
    @Test
    public void testPurchaseSingleCDWhenPaymentSuccess(){


        CD cd = new CD(10);
        CreditCard creditCard = () -> true;

        cd.buy(creditCard);
        assertEquals(9 , cd.getStock());
    }

    @Test
    public void testDoNotPurchaseSingleCDWhenPaymentUnsuccessful(){

        CD cd = new CD(10);
        CreditCard creditCard = () -> false;
        cd.buy(creditCard);
        assertEquals(10, cd.getStock());
    }
}
