import org.codemanship.CD;
import org.codemanship.Chart;
import org.codemanship.CreditCard;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PurchaseCDTest {

    static Chart chart;

    @BeforeAll
    public static void setup(){
        chart = mock(Chart.class);
    }

    @Test
    public void testPurchaseSingleCDWhenPaymentSuccess() {

        CD cd = new CD("artist", "title", 10, chart);
        CreditCard creditCard = () -> true;
        cd.buy(creditCard,1);
        assertEquals(9, cd.getStock());
    }

    @Test
    public void testDoNotPurchaseSingleCDWhenPaymentUnsuccessful() {

        CD cd = new CD("artist", "title", 10, chart);
        CreditCard creditCard = () -> false;
        cd.buy(creditCard,1);
        assertEquals(10, cd.getStock());
    }
    @Test
    public void testPurchaseMultipleCDWhenPaymentSuccessful(){
        CD cd = new CD("artist", "title", 10, chart);
        CreditCard creditCard = () -> true;

        cd.buy(creditCard,3);
        assertEquals(7, cd.getStock());
    }

    @Test
    public void testChartNotifiedWhenCDPurchased(){


        CD cd = new CD("artist","title",10, chart);
        CreditCard creditCard = () ->true;
        cd.buy(creditCard,2);

        verify(chart).notify(cd.getArtist(),cd.getTitle(), 2);
    }
}
