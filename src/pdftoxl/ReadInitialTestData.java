/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdftoxl;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import technology.tabula.ObjectExtractor;
import technology.tabula.Page;
import technology.tabula.extractors.SpreadsheetExtractionAlgorithm;

/**
 *
 * @author prashanth_mani
 */
public class ReadInitialTestData {
    
     	private static String PDF_PATH;

    public void main(String args[])
    {
    
        PDF_PATH = "";
                
        	 File  location= new File(PDF_PATH);
                 String type = ".pdf"; // replace what ever type of file you need to search

         if (location.isDirectory() && location != null) 
         {
             int PDFCount = 0;
            for (File f : location.listFiles()) 
            {
               if (f.isFile() && f.getName().endsWith(".pdf")) 
               {
            
               /// System.out.println("==================================PDF Name "+f.getName()+"==============================");
                  ReadInitilaTestData(PDF_PATH+"/"+f.getName(),f.getName());
                  
                    PDFCount++;
                }
           }
            System.out.println("PDF Count = "+PDFCount);
            }
    
    }
    
     private  void ReadInitilaTestData( String aPDFfile,String PdfName) 
    {
                 try {
                     PDDocument pd = PDDocument.load(new File(aPDFfile));
                     int totalPages = pd.getNumberOfPages();
                      if (totalPages > 1) {
                        ObjectExtractor oe = new ObjectExtractor(pd);
                        SpreadsheetExtractionAlgorithm sea = new SpreadsheetExtractionAlgorithm();
                        SpreadsheetExtractionAlgorithm PageTWoAlgorithm = new SpreadsheetExtractionAlgorithm();
                        Page PageOne = oe.extract(1);
                        Page PageTwo = oe.extract(2);
                      
                      
                      }
                     
                     
                 } catch (IOException ex) {
                     Logger.getLogger(ReadInitialTestData.class.getName()).log(Level.SEVERE, null, ex);
                 }
    
    
    }
    
}
