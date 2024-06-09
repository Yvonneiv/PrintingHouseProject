import org.junit.jupiter.api.Test;
import org.printinghouse.models.*;
import org.printinghouse.utils.PrintingHouseUtils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PrintingHouseUtilsTest {

    @Test
    public void testCalculatePublicationPrice() {
        BigDecimal price = PrintingHouseUtils.calculatePublicationPrice(10, PaperSize.A4, PaperType.REGULAR, new BigDecimal("1.0"));
        BigDecimal expectedPrice = new BigDecimal("2.0"); // Example expected price
        assertEquals(expectedPrice, price);
    }

    @Test
    public void testCalculateTotalRevenue() {
        Publication publication1 = new Poster("Poster 1", 10, PaperSize.A4, PaperType.REGULAR, new BigDecimal("1.0"));
        Publication publication2 = new NewsPaper("NewsPaper 1", 20, PaperSize.A3, PaperType.NEWSPAPER, new BigDecimal("0.5"));
        List<Publication> publications = Arrays.asList(publication1, publication2);

        BigDecimal totalRevenue = PrintingHouseUtils.calculateTotalRevenue(publications);
        BigDecimal expectedRevenue = publication1.getPrice().add(publication2.getPrice());
        assertEquals(expectedRevenue, totalRevenue);
    }

    @Test
    public void testValidatePublication() {
        Publication publication = new Poster("Poster 1", 10, PaperSize.A4, PaperType.REGULAR, new BigDecimal("1.0"));
        assertTrue(PrintingHouseUtils.validatePublication(publication));
    }
}
