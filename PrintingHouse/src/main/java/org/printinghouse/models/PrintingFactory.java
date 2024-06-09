package org.printinghouse.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PrintingFactory {
    private String name;
    private List<PrintingMachine> machines = new ArrayList<>();
    private List<Publication> printedPublications = new ArrayList<>();
    private BigDecimal bookPrice;
    private BigDecimal posterPrice;
    private BigDecimal newspaperPrice;
    private int amount;
    private BigDecimal deduction;

    public PrintingFactory(String name, BigDecimal bookPrice, BigDecimal posterPrice, BigDecimal newspaperPrice, int amount, BigDecimal deduction) {
        this.name = name;
        this.bookPrice = bookPrice;
        this.posterPrice = posterPrice;
        this.newspaperPrice = newspaperPrice;
        this.amount = amount;
        this.deduction = deduction;
    }

    public void addMachine(PrintingMachine machine) {
        this.machines.add(machine);
    }

    public List<PrintingMachine> getMachines() {
        return this.machines;
    }

    public String getName() {
        return this.name;
    }

    public void addPrintedPublication(Publication publication) {
        this.printedPublications.add(publication);
    }

    public List<Publication> getPrintedPublications() {
        return this.printedPublications;
    }

    public String toString() {
        return "PrintingFactory{name='" + this.name + '\'' + ", bookPrice=" + this.bookPrice + ", posterPrice=" + this.posterPrice + ", newspaperPrice=" + this.newspaperPrice + '}';
    }

    public BigDecimal getPriceForBook() {
        return this.bookPrice;
    }

    public BigDecimal getPriceForPoster() {
        return this.posterPrice;
    }

    public BigDecimal getPriceForNewspaper() {
        return this.newspaperPrice;
    }

    public BigDecimal getPriceForNewsPaper() {
        return null;
    }
}

