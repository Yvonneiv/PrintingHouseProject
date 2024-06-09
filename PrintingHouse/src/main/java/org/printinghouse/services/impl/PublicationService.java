package org.printinghouse.services.impl;

import org.printinghouse.models.NewsPaper;
import org.printinghouse.models.Poster;
import org.printinghouse.models.PrintingMachine;
import org.printinghouse.models.Publication;

import java.math.BigDecimal;
import java.util.List;

public interface PublicationService {
    Publication createPublication(String title, int numberOfPages, String paperSize, String paperType, BigDecimal price);

    Poster createPoster(String title, int numberOfPages, String paperSize, String paperType, BigDecimal price);

    NewsPaper createNewsPaper(String title, int numberOfPages, String paperSize, String paperType, BigDecimal price);

    List<Publication> getAllPublications();

    BigDecimal calculateTotalRevenue();

    void addPrintingMachine(PrintingMachine machine);

    List<PrintingMachine> getAllPrintingMachines();

    void printPublication(PrintingMachine machine, Publication publication, int copies) throws Exception;

    String getInventory(PrintingMachine machine);

    BigDecimal getPriceForBook();

    BigDecimal getPriceForPoster();

    BigDecimal getPriceForNewspaper();
}
