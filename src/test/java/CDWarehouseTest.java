import jdk.nashorn.internal.objects.NativeString;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CDWarehouseTest {
    @Test
    public void testCustomerSearchByArtistReturnsNoResults(){
        CDWarehouse warehouse = new CDWarehouse();
        assertEquals("No Records Found", warehouse.search("artist",null));
    }
    @Test
    public void testCustomerSearchByTitleReturnsNoResult(){
        CDWarehouse warehouse = new CDWarehouse();
        assertEquals("No Records Found", warehouse.search(null,"title"));
    }
     @Test
    public void testCustomerSearchByArtistAndTitleReturnsNoResults(){
         CDWarehouse warehouse = new CDWarehouse();
         assertEquals("No Records Found", warehouse.search("artist","title"));
     }


}
