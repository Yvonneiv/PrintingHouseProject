package org.printinghouse.services;


import java.math.BigDecimal;
import java.util.List;

import org.printinghouse.models.Publication;
import org.printinghouse.models.Poster;
import org.printinghouse.models.NewsPaper;
import org.printinghouse.models.PrintingMachine;

public interface PublicationService {

    // Publication related methods
    Publication createPublication(String title, int numberOfPages, String paperSize, String paperType, BigDecimal price);
    Poster createPoster(String title, int numberOfPages, String paperSize, String paperType, BigDecimal price);
    NewsPaper createNewsPaper(String title, int numberOfPages, String paperSize, String paperType, BigDecimal price);
    List<Publication> getAllPublications();
    BigDecimal calculateTotalRevenue();

    // Printing machine related methods
    void addPrintingMachine(PrintingMachine machine);
    List<PrintingMachine> getAllPrintingMachines();
    void printPublication(PrintingMachine machine, Publication publication, int copies) throws Exception;

    // Inventory and pricing
    String getInventory(PrintingMachine machine);
    BigDecimal getPriceForBook();
    BigDecimal getPriceForPoster();
    BigDecimal getPriceForNewspaper();
}
