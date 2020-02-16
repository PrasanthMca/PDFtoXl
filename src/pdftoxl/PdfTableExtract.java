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
import technology.tabula.extractors.BasicExtractionAlgorithm;
import technology.tabula.extractors.SpreadsheetExtractionAlgorithm;

/**
 *
 * @author prashanth_mani
 */
public class PdfTableExtract {

  

    public static void main(String args[]) {
        try 
        {
            // TODO Auto-generated method stub

           // String FileName ="/Users/prashanth_mani/PDFSamples/1DDA834C.pdf";
            
             String FileName ="/Users/prashanth_mani/PDFSamples/1DD99645.pdf";
            PDDocument pd = PDDocument.load(new File(FileName));
            boolean Start_read = false  ;
            int totalPages = pd.getNumberOfPages();
            System.out.println("Total Pages in Document: " + totalPages);
            if (totalPages > 1) {
                ObjectExtractor oe = new ObjectExtractor(pd);
                SpreadsheetExtractionAlgorithm sea = new SpreadsheetExtractionAlgorithm();
                SpreadsheetExtractionAlgorithm PageTWoAlgorithm = new SpreadsheetExtractionAlgorithm();
                Page PageOne = oe.extract(1);
                Page PageTwo = oe.extract(2);
                
                boolean Start_perforationInt =  false;
                boolean StartReadAcidval = false;

                // extract text from the table after detecting
                List<Table> FirstPagetables = sea.extract(PageOne);
                
                 BasicExtractionAlgorithm bea = new BasicExtractionAlgorithm();
                
                
                List<Table> SecondPagetablesForPerforation = bea.extract(PageTwo);

                for (Table tables : SecondPagetablesForPerforation) {
                    List<List<RectangularTextContainer>> rows = tables.getRows();

                    for (int i = 0; i < rows.size(); i++) {

                        List<RectangularTextContainer> cells = rows.get(i);

                        if(cells.get(0).getText().equals("Order No Unit Size"))
                        {
                            Start_perforationInt =true ;
                        }   
                        if(cells.get(0).getText().startsWith("Acid Volumes"))
                        {
                            Start_perforationInt =false ;
                            StartReadAcidval =true;
                        } 
                        String Ft = cells.get(0).getText().trim();
                         if(cells.get(0).getText().startsWith("Formation Name:"))
                        {
                            StartReadAcidval =false;
                        } 
                        
                          String OrderNo ="";
                            String From ="";
                             String To ="";
                            String FractureTreatments ="";
                             String AcidVolumes ="";     
                     
                      if(Start_perforationInt)  
                      { 
                        if((!cells.get(0).getText().startsWith("Order No Unit Size") ) && (!cells.get(0).getText().startsWith("Acid Volumes") ) )
                     if(cells.size()>5) 
                      {
                            
                      if((cells.get(0).getText().equalsIgnoreCase("There are no Spacing Order records to display."))){
                            OrderNo  = cells.get(0).getText();
                            From     =  cells.get(2).getText();
                            To       =    cells.get(4).getText();
                    
                        }
                         else{
                          String ORdernum = cells.get(0).getText();
                          String[] getOrderNumberOnly = ORdernum.split(" ");
                            OrderNo  = getOrderNumberOnly[0];
                            From     =  cells.get(2).getText();
                            To       =  cells.get(4).getText();
                          }
                         
                       }
                        }
                       if(StartReadAcidval)  
                      { 
                      if((!cells.get(0).getText().startsWith("Acid Volumes") ) && (!cells.get(0).getText().startsWith("Formation Name:") ) )
                        if (  cells.size()>3) {   
                            
                            AcidVolumes =cells.get(0).getText();
                            FractureTreatments = cells.get(3).getText();
              
                          }
                        }
                         System.out.println(OrderNo+":"+From+":"+To+":"+AcidVolumes+":"+FractureTreatments);
           
                    }
                    if(StartReadAcidval || Start_perforationInt)
                    {
                        
                    }
                    
   
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(PdfTableExtract.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }
}
