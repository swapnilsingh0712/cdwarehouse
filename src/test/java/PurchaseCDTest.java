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
<<<<<<< HEAD
        CreditCard creditCard = () -> false;
=======
        CreditCard creditCard = new CreditCard() {
            @Override
            public boolean payment() {
                return false;
            }
        };
>>>>>>> da3362ed208e33323641d24f5075b9752f5fae9e
        cd.buy(creditCard);
        assertEquals(10, cd.getStock());
    }
}
