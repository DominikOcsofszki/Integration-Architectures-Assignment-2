package secondVersion.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import secondVersion.model.SalesMan;
import secondVersion.ManagePersonalImpl;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SalesManTest {

    private SalesMan salesMan;
    private ManagePersonalImpl managePersonal = new ManagePersonalImpl();

    @Test
    void roundTripTest() {
        SalesMan first = new SalesMan("Simon", "Biwer", 21);
        SalesMan firstChanged = new SalesMan("Simon", "Bier", 21);
        managePersonal.createSalesMan(first);
        assertEquals(first, managePersonal.readSalesMan(21));
        managePersonal.updateSalesMan(21, firstChanged);
        assertEquals(firstChanged, managePersonal.readSalesMan(21));
        managePersonal.deleteSalesMan(21);
        assertEquals(null, managePersonal.readSalesMan(21));
    }

    @BeforeEach
    void clearSalesMen() {
        managePersonal._dropAllSalesMan();
    }

}
