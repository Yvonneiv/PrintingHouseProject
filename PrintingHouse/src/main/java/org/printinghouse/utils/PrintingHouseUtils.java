package org.printinghouse.utils;

import java.math.BigDecimal;
import java.util.List;
import org.printinghouse.models.Publication;
import org.printinghouse.models.PrintingMachine;
import org.printinghouse.models.PaperSize;
import org.printinghouse.models.PaperType;

public class PrintingHouseUtils {

    // Method to calculate the total price of a publication
    public static BigDecimal calculatePublicationPrice(int numberOfPages, PaperSize paperSize, PaperType paperType, BigDecimal printPrice) {
        BigDecimal sizePrice = paperSize.getPrice();
        BigDecimal typePrice = paperType.getPrice();
        BigDecimal pages = BigDecimal.valueOf(numberOfPages);

        return pages.multiply(sizePrice.add(typePrice)).add(printPrice);
    }

    // Method to calculate total revenue from a list of publications
    public static BigDecimal calculateTotalRevenue(List<Publication> publications) {
        BigDecimal total = BigDecimal.ZERO;

        for (Publication pub : publications) {
            total = total.add(pub.getPrice());
        }

        return total;
    }

    // Method to print inventory of a printing machine
    public static String printInventory(PrintingMachine machine) {
        return machine.printInventory();
    }

    // Method to validate a publication
    public static boolean validatePublication(Publication publication) {
        return publication.getTitle() != null && !publication.getTitle().isEmpty()
                && publication.getNumberOfPages() > 0
                && publication.getPaperSize() != null
                && publication.getPaperType() != null
                && publication.getPrintPrice() != null;
    }

    // Method to format a BigDecimal price
    public static String formatPrice(BigDecimal price) {
        return "$" + price.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
    }
}
