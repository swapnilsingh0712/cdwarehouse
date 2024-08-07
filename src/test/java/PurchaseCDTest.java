import org.codemanship.CD;
import org.codemanship.Chart;
import org.codemanship.Competitor;
import org.codemanship.CreditCard;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PurchaseCDTest {

    static Chart chart;

    @BeforeAll
    public static void setup(){
        chart = mock(Chart.class);
    }

    @Test
    public void testPurchaseSingleCDWhenPaymentSuccess() {

        CD cd = new CD("artist", "title", 10, chart, 10.0);
        CreditCard creditCard = () -> true;
        cd.buy(creditCard,1);
        assertEquals(9, cd.getStock());
    }

    @Test
    public void testDoNotPurchaseSingleCDWhenPaymentUnsuccessful() {

        CD cd = new CD("artist", "title", 10, chart, 10.0);
        CreditCard creditCard = () -> false;
        cd.buy(creditCard,1);
        assertEquals(10, cd.getStock());
    }
    @Test
    public void testPurchaseMultipleCDWhenPaymentSuccessful(){
        CD cd = new CD("artist", "title", 10, chart, 10.0);
        CreditCard creditCard = () -> true;

        cd.buy(creditCard,3);
        assertEquals(7, cd.getStock());
    }

    @Test
    public void testChartNotifiedWhenCDPurchased(){


        CD cd = new CD("artist","title",10, chart, 10.0);
        CreditCard creditCard = () ->true;
        cd.buy(creditCard,2);

        verify(chart).notify(cd.getArtist(),cd.getTitle(), 2);
    }

    @Test
    public void testLowestPriceGuaranteeWhenChartInTopHundred(){

        CD cd = new CD("artist","title",10,chart,50.0);
        when(chart.getPosition("artist", "title")).thenReturn(30);
        Competitor competitor = mock(Competitor.class);
        when(competitor.getPrice()).thenReturn(40.0);
        cd.checkLowestPriceGurantee(competitor);
        assertEquals(cd.getPrice(),competitor.getPrice()-1);
    }

    @Test
    public void testLowestPriceGuaranteeWhenChartNotinTop100(){

        CD cd = new CD("artist","title",10,chart,50.0);
        when(chart.getPosition("artist", "title")).thenReturn(110);
        Competitor competitor = mock(Competitor.class);
        when(competitor.getPrice()).thenReturn(33.0);
        cd.checkLowestPriceGurantee(competitor);
        assertEquals(cd.getPrice(), 50.0);

    }
}
