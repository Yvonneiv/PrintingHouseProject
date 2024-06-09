package org.printinghouse.models;


import org.printinghouse.exceptions.InvalidMachineTypeException;
import org.printinghouse.exceptions.PaperLoadException;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ColorPrintingMachine extends PrintingMachine {
    public ColorPrintingMachine(String id, int maxPaperCapacity, int pagesPerMinute) {
        super(id, maxPaperCapacity, pagesPerMinute, true);
    }

    public BigDecimal loadPaper(int sheets, int size, int type) throws PaperLoadException {
        if (sheets > this.getMaxPaperCapacity()) {
            throw new PaperLoadException("Exceeded max paper capacity");
        } else {
            if (size == 1 && type == 1) {
                this.paperRegularA1 += sheets;
            } else if (size == 1 && type == 2) {
                this.paperGlossyA1 += sheets;
            } else if (size == 1 && type == 3) {
                this.paperNewsPaperA1 += sheets;
            } else if (size == 2 && type == 1) {
                this.paperRegularA2 += sheets;
            } else if (size == 2 && type == 2) {
                this.paperGlossyA2 += sheets;
            } else if (size == 2 && type == 3) {
                this.paperNewsPaperA2 += sheets;
            } else if (size == 3 && type == 1) {
                this.paperRegularA3 += sheets;
            } else if (size == 3 && type == 2) {
                this.paperGlossyA3 += sheets;
            } else if (size == 3 && type == 3) {
                this.paperNewsPaperA3 += sheets;
            } else if (size == 4 && type == 1) {
                this.paperRegularA4 += sheets;
            } else if (size == 4 && type == 2) {
                this.paperGlossyA4 += sheets;
            } else if (size == 4 && type == 3) {
                this.paperNewsPaperA4 += sheets;
            } else if (size == 5 && type == 1) {
                this.paperRegularA5 += sheets;
            } else if (size == 5 && type == 2) {
                this.paperGlossyA5 += sheets;
            } else if (size == 5 && type == 3) {
                this.paperNewsPaperA5 += sheets;
            }

            BigDecimal sizePrice = BigDecimal.ZERO;
            BigDecimal typePrice = BigDecimal.ZERO;
            switch (size) {
                case 1:
                    sizePrice = PaperSize.A1.getPrice();
                    break;
                case 2:
                    sizePrice = PaperSize.A2.getPrice();
                    break;
                case 3:
                    sizePrice = PaperSize.A3.getPrice();
                    break;
                case 4:
                    sizePrice = PaperSize.A4.getPrice();
                    break;
                case 5:
                    sizePrice = PaperSize.A5.getPrice();
                    break;
                default:
                    throw new PaperLoadException("Invalid paper size");
            }

            switch (type) {
                case 1:
                    typePrice = PaperType.REGULAR.getPrice();
                    break;
                case 2:
                    typePrice = PaperType.GLOSSY.getPrice();
                    break;
                case 3:
                    typePrice = PaperType.NEWSPAPER.getPrice();
                    break;
                default:
                    throw new PaperLoadException("Invalid paper type");
            }

            return sizePrice.add(typePrice).multiply(BigDecimal.valueOf(sheets)).setScale(2, RoundingMode.HALF_UP);
        }
    }

    public void printPublication(Publication publication, int copies) throws InvalidMachineTypeException {
        if (!this.isColor()) {
            throw new InvalidMachineTypeException("This machine cannot print in color");
        } else {
            this.addPrintedPublication(publication, copies);
        }
    }
}

