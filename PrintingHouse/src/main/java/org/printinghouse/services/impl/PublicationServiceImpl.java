package org.printinghouse.services.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.printinghouse.models.*;


public class PublicationServiceImpl implements PublicationService {

    private List<Publication> publications = new ArrayList<>();
    private List<PrintingMachine> machines = new ArrayList<>();
    private PrintingFactory printingFactory;

    public PublicationServiceImpl(PrintingFactory printingFactory) {
        this.printingFactory = printingFactory;
    }

    @Override
    public Publication createPublication(String title, int numberOfPages, String paperSize, String paperType, BigDecimal price) {
        Publication publication = new Publication(title, numberOfPages, PaperSize.valueOf(paperSize), PaperType.valueOf(paperType), price) {
            @Override
            public BigDecimal getPrice() {
                return getPrintPrice();
            }
        };
        publications.add(publication);
        return publication;
    }

    @Override
    public Poster createPoster(String title, int numberOfPages, String paperSize, String paperType, BigDecimal price) {
        Poster poster = new Poster(title, numberOfPages, PaperSize.valueOf(paperSize), PaperType.valueOf(paperType), price);
        publications.add(poster);
        return poster;
    }

    @Override
    public NewsPaper createNewsPaper(String title, int numberOfPages, String paperSize, String paperType, BigDecimal price) {
        NewsPaper newsPaper = new NewsPaper(title, numberOfPages, PaperSize.valueOf(paperSize), PaperType.valueOf(paperType), price);
        publications.add(newsPaper);
        return newsPaper;
    }

    @Override
    public List<Publication> getAllPublications() {
        return new ArrayList<>(publications);
    }

    @Override
    public BigDecimal calculateTotalRevenue() {
        return RevenueCalculator.calculateRevenues(publications);
    }

    @Override
    public void addPrintingMachine(PrintingMachine machine) {
        machines.add(machine);
    }

    @Override
    public List<PrintingMachine> getAllPrintingMachines() {
        return new ArrayList<>(machines);
    }

    @Override
    public void printPublication(PrintingMachine machine, Publication publication, int copies) throws Exception {
        machine.printPublication(publication, copies);
        machine.addPrintedPublication(publication, copies);
    }

    @Override
    public String getInventory(PrintingMachine machine) {
        return machine.printInventory();
    }

    @Override
    public BigDecimal getPriceForBook() {
        return printingFactory.getPriceForBook();
    }

    @Override
    public BigDecimal getPriceForPoster() {
        return printingFactory.getPriceForPoster();
    }

    @Override
    public BigDecimal getPriceForNewspaper() {
        return printingFactory.getPriceForNewspaper();
    }
}

