package org.printinghouse.models;


import java.math.BigDecimal;

public class Poster extends Publication {
    public Poster(String title, int numberOfPages, PaperSize paperSize, PaperType paperType, BigDecimal priceForPoster) {
        super(title, numberOfPages, paperSize, paperType, priceForPoster);
    }

    public BigDecimal getPrice() {
        BigDecimal sizePrice = this.getPaperSize().getPrice();
        BigDecimal typePrice = this.getPaperType().getPrice();
        BigDecimal numberOfPages = new BigDecimal(this.getNumberOfPages());
        BigDecimal printPrice = this.getPrintPrice();

        return numberOfPages.multiply(sizePrice.add(typePrice)).add(printPrice);
    }

    public BigDecimal getPrintPrice() {
        return null;
    }
}
