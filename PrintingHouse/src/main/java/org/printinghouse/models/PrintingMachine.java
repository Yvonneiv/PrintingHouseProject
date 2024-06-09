package org.printinghouse.models;

import org.printinghouse.exceptions.InvalidMachineTypeException;
import org.printinghouse.exceptions.PaperLoadException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class PrintingMachine {
    private String id;
    private int maxPaperCapacity;
    private int pagesPerMinute;
    private boolean color;
    private List<Publication> printedPublications;
    private List<Integer> copies;
    public int paperRegularA1 = 0;
    public int paperRegularA2 = 0;
    public int paperRegularA3 = 0;
    public int paperRegularA4 = 0;
    public int paperRegularA5 = 0;
    public int paperGlossyA1 = 0;
    public int paperGlossyA2 = 0;
    public int paperGlossyA3 = 0;
    public int paperGlossyA4 = 0;
    public int paperGlossyA5 = 0;
    public int paperNewsPaperA1 = 0;
    public int paperNewsPaperA2 = 0;
    public int paperNewsPaperA3 = 0;
    public int paperNewsPaperA4 = 0;
    public int paperNewsPaperA5 = 0;

    public PrintingMachine(String id, int maxPaperCapacity, int pagesPerMinute, boolean color) {
        this.id = id;
        this.maxPaperCapacity = maxPaperCapacity;
        this.pagesPerMinute = pagesPerMinute;
        this.color = color;
        this.printedPublications = new ArrayList<>();
        this.copies = new ArrayList<>();
    }

    public String getId() {
        return this.id;
    }

    public int getMaxPaperCapacity() {
        return this.maxPaperCapacity;
    }

    public int getPagesPerMinute() {
        return this.pagesPerMinute;
    }

    public boolean isColor() {
        return this.color;
    }

    public List<Publication> getPrintedPublications() {
        return this.printedPublications;
    }

    public void addPrintedPublication(Publication publication, int copies) {
        this.printedPublications.add(publication);
        this.copies.add(copies);
    }

    public abstract BigDecimal loadPaper(int paperSize, int paperType, int quantity) throws PaperLoadException;

    public abstract void printPublication(Publication publication, int copies) throws InvalidMachineTypeException;

    public int getTotalPrintedPages() {
        int total = 0;

        for (Publication pub : this.printedPublications) {
            total += pub.getNumberOfPages();
        }

        return total;
    }

    public String printInventory() {
        return "Paper Inventory:\nRegular Paper:\nA1: " + this.paperRegularA1 + "\nA2: " + this.paperRegularA2 + "\nA3: " + this.paperRegularA3 + "\nA4: " + this.paperRegularA4 + "\nA5: " + this.paperRegularA5 + "\nGlossy Paper:\nA1: " + this.paperGlossyA1 + "\nA2: " + this.paperGlossyA2 + "\nA3: " + this.paperGlossyA3 + "\nA4: " + this.paperGlossyA4 + "\nA5: " + this.paperGlossyA5 + "\nNews Paper:\nA1: " + this.paperNewsPaperA1 + "\nA2: " + this.paperNewsPaperA2 + "\nA3: " + this.paperNewsPaperA3 + "\nA4: " + this.paperNewsPaperA4 + "\nA5: " + this.paperNewsPaperA5 + "\n";
    }

    @Override
    public String toString() {
        return "PrintingMachine{id='" + this.id + '\'' + ", maxPaperCapacity=" + this.maxPaperCapacity + ", pagesPerMinute=" + this.pagesPerMinute + ", color=" + this.color + ", loaded paper = " + this.printInventory() + '}';
    }
}
