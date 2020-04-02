/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdftoxl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import technology.tabula.ObjectExtractor;
import technology.tabula.Page;
import technology.tabula.RectangularTextContainer;
import technology.tabula.Table;
import technology.tabula.extractors.SpreadsheetExtractionAlgorithm;
/**
 *
 * @author prashanth_mani
 */
public class PDFParserMaster {
    public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		final String FILENAME="/Users/prashanth_mani/PDFSamples/Old/871961_0104N05W_05122856__7__18__2000.pdf";
		
             File myFile = new File(FILENAME);

        try (PDDocument doc = PDDocument.load(myFile)) {

            PDFTextStripper stripper = new PDFTextStripper();
            String text = stripper.getText(doc);

            System.out.println("Text size: " + text.length() + " characters:");
            System.out.println(text);
        }
		
	}

}
