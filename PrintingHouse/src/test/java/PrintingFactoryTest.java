import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.printinghouse.exceptions.InvalidMachineTypeException;
import org.printinghouse.exceptions.PaperLoadException;
import org.printinghouse.models.*;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PrintingFactoryTest {

    private PrintingFactory factory;

    @BeforeEach
    public void setUp() {
        factory = new PrintingFactory("Test Factory", new BigDecimal("10.0"), new BigDecimal("5.0"), new BigDecimal("1.0"), 100, new BigDecimal("0.1"));
    }

    @Test
    public void testAddMachine() {
        PrintingMachine machine = new ConcretePrintingMachine("Machine1", 500, 50, true);
        factory.addMachine(machine);

        List<PrintingMachine> machines = factory.getMachines();
        assertEquals(1, machines.size());
        assertEquals("Machine1", machines.get(0).getId());
    }

    @Test
    public void testAddPrintedPublication() {
        Publication poster = new Poster("Sample Poster", 10, PaperSize.A4, PaperType.GLOSSY, new BigDecimal("1.5"));
        factory.addPrintedPublication(poster);

        List<Publication> publications = factory.getPrintedPublications();
        assertEquals(1, publications.size());
        assertEquals("Sample Poster", publications.get(0).getTitle());
    }

    @Test
    public void testGetPriceForBook() {
        BigDecimal bookPrice = factory.getPriceForBook();
        assertEquals(new BigDecimal("10.0"), bookPrice);
    }

    @Test
    public void testGetPriceForPoster() {
        BigDecimal posterPrice = factory.getPriceForPoster();
        assertEquals(new BigDecimal("5.0"), posterPrice);
    }

    @Test
    public void testGetPriceForNewspaper() {
        BigDecimal newspaperPrice = factory.getPriceForNewspaper();
        assertEquals(new BigDecimal("1.0"), newspaperPrice);
    }

    // Mock class for a concrete implementation of PrintingMachine for testing purposes
    private static class ConcretePrintingMachine extends PrintingMachine {

        public ConcretePrintingMachine(String id, int maxPaperCapacity, int pagesPerMinute, boolean color) {
            super(id, maxPaperCapacity, pagesPerMinute, color);
        }

        @Override
        public BigDecimal loadPaper(int paperSize, int paperType, int quantity) throws PaperLoadException {
            return BigDecimal.ZERO; // Example implementation
        }

        @Override
        public void printPublication(Publication publication, int copies) throws InvalidMachineTypeException {
            // Example implementation
        }
    }
}

