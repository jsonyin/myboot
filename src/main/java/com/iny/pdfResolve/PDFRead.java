package com.iny.pdfResolve;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

import java.io.File;
import java.io.IOException;

/**
 * Created by zcy on 2018/3/8.
 */
public class PDFRead {
    public static void main(String args[]){

        File f = new File("/Users/zcy/Desktop/1.pdf");
        PDDocument document = null;

        try {
            document=PDDocument.load(f);
            int pages = document.getNumberOfPages();
            PDFTextStripper stripper = new PDFTextStripper();
            stripper.setSortByPosition(true);
            stripper.setStartPage(1);
            stripper.setEndPage(2);
            String content = stripper.getText(document);
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
