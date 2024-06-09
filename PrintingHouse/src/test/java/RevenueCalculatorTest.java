import org.junit.jupiter.api.Test;
import org.printinghouse.models.NewsPaper;
import org.printinghouse.models.PaperSize;
import org.printinghouse.models.PaperType;
import org.printinghouse.models.Poster;
import org.printinghouse.models.Publication;
import org.printinghouse.models.RevenueCalculator;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RevenueCalculatorTest {

    @Test
    public void testCalculateRevenues() {
        Publication publication1 = new Poster("Poster 1", 10, PaperSize.A4, PaperType.REGULAR, new BigDecimal("1.0"));
        Publication publication2 = new NewsPaper("NewsPaper 1", 20, PaperSize.A3, PaperType.NEWSPAPER, new BigDecimal("0.5"));
        List<Publication> publications = Arrays.asList(publication1, publication2);

        BigDecimal totalRevenue = RevenueCalculator.calculateRevenues(publications);
        BigDecimal expectedRevenue = publication1.getPrice().add(publication2.getPrice());
        assertEquals(expectedRevenue, totalRevenue);
    }
}

