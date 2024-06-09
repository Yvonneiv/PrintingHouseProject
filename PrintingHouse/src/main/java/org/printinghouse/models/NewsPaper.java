package org.printinghouse.models;


import java.math.BigDecimal;

public class NewsPaper extends Publication {
    public NewsPaper(String title, int numberOfPages, PaperSize paperSize, PaperType paperType, BigDecimal priceForNewspaper) {
        super(title, numberOfPages, paperSize, paperType, priceForNewspaper);
    }

    public BigDecimal getPrice() {
        BigDecimal sizePrice = this.getPaperSize().getPrice();
        BigDecimal typePrice = this.getPaperType().getPrice();
        BigDecimal numberOfPages = new BigDecimal(this.getNumberOfPages());
        BigDecimal printPrice = this.getPrintPrice();

        return numberOfPages.multiply(sizePrice.add(typePrice)).add(printPrice);
    }
}
