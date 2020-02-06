/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdftoxl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.pdfbox.pdmodel.PDDocument;
import technology.tabula.ObjectExtractor;
import technology.tabula.Page;
import technology.tabula.RectangularTextContainer;
import technology.tabula.Table;
import technology.tabula.extractors.SpreadsheetExtractionAlgorithm;

/**
 *
 * @author prashanth_mani
 */
public class PdfTableExtract {

    public PdfTableExtract() {

    }

    public static String GetTableExtract(String FileName) {
        try {
            // TODO Auto-generated method stub
            //final String FILENAME="/Users/prashanth_mani/PDFSamples/1DD99645.pdf";

            PDDocument pd = PDDocument.load(new File(FileName));
            boolean Start_read = false  ;
            int totalPages = pd.getNumberOfPages();
            System.out.println("Total Pages in Document: " + totalPages);
            if (totalPages > 1) {
                ObjectExtractor oe = new ObjectExtractor(pd);
                SpreadsheetExtractionAlgorithm sea = new SpreadsheetExtractionAlgorithm();
                Page PageOne = oe.extract(1);
                Page PageTwo = oe.extract(2);
                boolean fasle;

                // extract text from the table after detecting
                List<Table> FirstPagetables = sea.extract(PageOne);
                List<Table> SecondPagetables = sea.extract(PageTwo);

                for (Table tables : FirstPagetables) {
                    List<List<RectangularTextContainer>> rows = tables.getRows();

                    for (int i = 0; i < rows.size(); i++) {

                        List<RectangularTextContainer> cells = rows.get(i);

                        if(cells.get(0).getText().equals("Casing and Cement"))
                        {
                            Start_read =true ;
                        }
                        if(cells.get(0).getText().equals("Liner"))
                        {
                            Start_read =false ;
                        }
                        
                        if(Start_read)
                        {
                        for (int j = 0; j < cells.size(); j++) {
           
                            System.out.print(cells.get(j).getText() + "|");
                            cells.listIterator();
                        }
                        }
                        

                        System.out.println();
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(PdfTableExtract.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
}
