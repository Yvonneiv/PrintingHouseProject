package org.printinghouse.models;

import java.math.BigDecimal;

public class Book extends Publication {
    public Book(String title, int numberOfPages, PaperSize paperSize, PaperType paperType, BigDecimal priceForBook) {
        super(title, numberOfPages, paperSize, paperType, priceForBook);
    }

    public BigDecimal getPrice() {
        BigDecimal sizePrice = this.getPaperSize().getPrice();
        BigDecimal typePrice = this.getPaperType().getPrice();
        return sizePrice.add(typePrice).multiply(BigDecimal.valueOf(this.getNumberOfPages())).add(this.getPrintPrice());
    }
}
