import org.junit.jupiter.api.Test;
import org.printinghouse.models.PaperSize;
import org.printinghouse.models.PaperType;
import org.printinghouse.models.Poster;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PosterTest {

    @Test
    public void testGetPrice() {
        Poster poster = new Poster("Sample Poster", 10, PaperSize.A4, PaperType.GLOSSY, new BigDecimal("1.5"));
        BigDecimal expectedPrice = new BigDecimal("10.15"); // Calculated expected price
        assertEquals(expectedPrice, poster.getPrice());
    }
}
