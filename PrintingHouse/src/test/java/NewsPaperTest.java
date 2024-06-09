import org.junit.jupiter.api.Test;
import org.printinghouse.models.PaperSize;
import org.printinghouse.models.PaperType;
import org.printinghouse.models.NewsPaper;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NewsPaperTest {

    @Test
    public void testGetPrice() {
        NewsPaper newsPaper = new NewsPaper("Sample NewsPaper", 20, PaperSize.A3, PaperType.NEWSPAPER, new BigDecimal("0.5"));
        BigDecimal expectedPrice = new BigDecimal("4.50"); // Calculated expected price
        assertEquals(expectedPrice, newsPaper.getPrice());
    }
}

