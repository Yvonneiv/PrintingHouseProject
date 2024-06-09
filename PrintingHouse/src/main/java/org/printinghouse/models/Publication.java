package org.printinghouse.models;

import java.math.BigDecimal;

public abstract class Publication {
    private String title;
    private String type;
    private int numberOfPages;
    private PaperType paperType;
    private PaperSize paperSize;
    private BigDecimal printPrice;

    public Publication(String title, int numberOfPages, PaperSize paperSize, PaperType paperType, BigDecimal price) {
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.paperSize = paperSize;
        this.paperType = paperType;
        this.printPrice = price;
    }

    public String getTitle() {
        return this.title;
    }

    public int getNumberOfPages() {
        return this.numberOfPages;
    }

    public PaperSize getPaperSize() {
        return this.paperSize;
    }

    public PaperType getPaperType() {
        return this.paperType;
    }

    public BigDecimal getPrintPrice() {
        return this.printPrice;
    }

    public abstract BigDecimal getPrice();

    public String toString() {
        return "Publication{title='" + this.title + '\'' + ", numberOfPages=" + this.numberOfPages + ", paperSize=" + this.paperSize + ", paperType=" + this.paperType + '}';
    }
}

