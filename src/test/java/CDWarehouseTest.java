import jdk.nashorn.internal.objects.NativeString;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CDWarehouseTest {
    @Test
    public void testCustomerSearchReturnsNoResults(){

        CDWarehouse warehouse = new CDWarehouse();
        assertEquals("No Records Found", warehouse.search("artist"));
    }
}
