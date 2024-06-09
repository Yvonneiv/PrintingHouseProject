//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.printinghouse.exceptions;

import org.printinghouse.models.Publication;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class FileHandler {
    public FileHandler() {
    }

    public static void writePublicationsToFile(List<Publication> publications, String filePath) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        Throwable var3 = null;

        try {
            Iterator var4 = publications.iterator();

            while(var4.hasNext()) {
                Publication pub = (Publication)var4.next();
                writer.write(pub.getTitle() + "," + pub.getNumberOfPages() + "," + pub.getPaperSize());
                writer.newLine();
            }
        } catch (Throwable var13) {
            var3 = var13;
            throw var13;
        } finally {
            if (writer != null) {
                if (var3 != null) {
                    try {
                        writer.close();
                    } catch (Throwable var12) {
                        var3.addSuppressed(var12);
                    }
                } else {
                    writer.close();
                }
            }

        }

    }

    public static void writeReportToFile(String report, String filePath) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        Throwable var3 = null;

        try {
            writer.write(report);
        } catch (Throwable var12) {
            var3 = var12;
            throw var12;
        } finally {
            if (writer != null) {
                if (var3 != null) {
                    try {
                        writer.close();
                    } catch (Throwable var11) {
                        var3.addSuppressed(var11);
                    }
                } else {
                    writer.close();
                }
            }

        }

    }
}
