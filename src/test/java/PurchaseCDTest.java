import org.codemanship.CD;
import org.codemanship.CreditCard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PurchaseCDTest {
    
    @Test
    public void testPurchaseSingleCDWhenPaymentSuccess(){


        CD cd = new CD(10);
        CreditCard creditCard = new CreditCard(){
            @Override
            public boolean payment() {
                return true;
            }
        };

        cd.buy(creditCard);
        assertEquals(9 , cd.getStock());
    }

}
