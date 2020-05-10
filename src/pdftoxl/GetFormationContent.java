/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdftoxl;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import technology.tabula.ObjectExtractor;
import technology.tabula.Page;
import technology.tabula.RectangularTextContainer;
import technology.tabula.Table;
import technology.tabula.extractors.SpreadsheetExtractionAlgorithm;

/**
 *
 * @author prashanth_mani
 */
public class GetFormationContent {
    
    	private static String PDF_PATH;
        private static ArrayList<Formation> FormationsArray =  new ArrayList<>();
        private static String[] FormationColumns = {"Well ID", "Formation","Top MD","PDFName"};

    public static void main(String args[])
    {
    
       PDF_PATH = "/Users/prashanth_mani/Downloads/Formation_Missing";
                
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
                  ReadFormationData(PDF_PATH+"/"+f.getName(),f.getName());
                  
                    PDFCount++;
                }
           }
            System.out.println("PDF Count = "+PDFCount);
             FormationSheet();
            }
    
    }
    
     private static void ReadFormationData( String aPDFfile,String PdfName) 
    {
       
                 try {
                     
                     PdfReader reader;
                     reader = new PdfReader(aPDFfile);
                     int NumberOfPages =   reader.getNumberOfPages();
                      String textFromPageone = PdfTextExtractor.getTextFromPage(reader, 1);
                       String lines[] = textFromPageone.split("\\r?\\n");  
                       String WellID= "";
                       boolean FormationFounde =false;
                       
                       for (String s:lines) {
	            	
            	           if( s.startsWith("API No.:") ) 
                            {
	        	   String APINo = s;
	        	  // System.out.println("***************** API No *********");
	        	   String[] splited = s.split(" ");	        	   
	        	   WellID = splited[2].trim();
	        	  break;
                                                  
                            }
                       }
                     
                     PDDocument pd = PDDocument.load(new File(aPDFfile));
                     int totalPages = pd.getNumberOfPages();
                      if (totalPages > 3) {
                        ObjectExtractor oe = new ObjectExtractor(pd);
                        SpreadsheetExtractionAlgorithm sea = new SpreadsheetExtractionAlgorithm();
                        SpreadsheetExtractionAlgorithm PageTWoAlgorithm = new SpreadsheetExtractionAlgorithm();
                        Page PageOne = oe.extract(3);
                        Page PageTwo = oe.extract(4);
                      
                               List<Table> Pagethree = sea.extract(PageOne);
                List<Table> PageFour = PageTWoAlgorithm.extract(PageTwo);
                      
                  boolean ReadFormation = false;
 for (Table tables : Pagethree) {
                    List<List<RectangularTextContainer>> rows = tables.getRows();
           
                    for (int i = 0; i < rows.size(); i++) {
                        
                          List<RectangularTextContainer> cells = rows.get(i);
                        
                         if(cells.get(0).getText().equals("Formation"))
                        {
                            FormationFounde = true;
                            ReadFormation =true ;
                        }
                        if(cells.get(0).getText().equals("Other Remarks"))
                        {
                            ReadFormation =false ;
                        }
                         if(ReadFormation)
                        {                     
                             String Formation="@";
                             String Top="";                       
                            if(cells.size()>1)
                                {
                            if(!cells.get(0).getText().equals("Formation") && !cells.get(0).getText().equals(" "))
                            {
                               //  System.out.print(cells.get(0).getText() + "|");  
                                 Formation = cells.get(0).getText();
                                 Top = cells.get(1).getText();
                                 
                            }
                             if(!Formation.equals("@"))
                            FormationsArray.add(new Formation(WellID,Formation,Top,PdfName));
                              
                        }
                            
                        }
                        }
              }
 
                if(!FormationFounde)
                {
                    boolean ReadFormationFourthPage = false;
 for (Table tables : PageFour) {
                    List<List<RectangularTextContainer>> rows = tables.getRows();
           
                    for (int i = 0; i < rows.size(); i++) {
                        
                          List<RectangularTextContainer> cells = rows.get(i);
                        
                         if(cells.get(0).getText().equals("Formation"))
                        {
                            ReadFormationFourthPage =true ;
                        }
                        if(cells.get(0).getText().equals("Other Remarks"))
                        {
                            ReadFormationFourthPage =false ;
                        }
                         if(ReadFormationFourthPage)
                        {                     
                             String Formation="@";
                             String Top="";                       
                            if(cells.size()>1)
                                {
                            if(!cells.get(0).getText().equals("Formation") && !cells.get(0).getText().equals(" "))
                            {
                               //  System.out.print(cells.get(0).getText() + "|");  
                                 Formation = cells.get(0).getText();
                                 Top = cells.get(1).getText();
                                 
                            }
                             if(!Formation.equals("@"))
                            FormationsArray.add(new Formation(WellID,Formation,Top,PdfName));
                              
                        }
                            
                        }
                        }
              }
                
                }
 
 
 
 
 
 
 
 
 
 
            }
                        
                        
                        
                        
                        
                        
                      
                      
                     
                     
                 } catch (IOException ex) {
                     System.out.println("exception"+ex);
                    // Logger.getLogger(ReadInitialTestData.class.getName()).log(Level.SEVERE, null, ex);
                 }
    
    
    }

    private static void FormationSheet() {
    
              Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

        /* CreationHelper helps us create instances of various things like DataFormat, 
           Hyperlink, RichTextString etc, in a format (HSSF, XSSF) independent way */
        CreationHelper createHelper = workbook.getCreationHelper();
               // ******************** Formation Content ***********************
         Sheet FormationSheet = workbook.createSheet("Formation");
         Row FormationHeader = FormationSheet.createRow(0);
         CellStyle headerCellStyle = workbook.createCellStyle();
         
        for(int i = 0; i < FormationColumns.length; i++) {
            Cell cell = FormationHeader.createCell(i);
            cell.setCellValue(FormationColumns[i]);
            cell.setCellStyle(headerCellStyle);
        }
        
        int FormationRow = 1 ;
         for(Formation formation :FormationsArray)
         {
             Row row = FormationSheet.createRow(FormationRow++);
             row.createCell(0)
                    .setCellValue(formation.getWell_ID());
             row.createCell(1)
                    .setCellValue(formation.getFormation());
              row.createCell(2)
                    .setCellValue(formation.getTop());
              row.createCell(3)
                    .setCellValue(formation.getPDFName());
         }
         
      // ******************************************************************
      
      
          
         String currentDate = null;
        String fileName = "FormationDetails";
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");           
        Date date = new Date();  
        currentDate = formatter.format(date);
        fileName = fileName+"("+currentDate+")";
       
           try {
        	 FileOutputStream fileOut = new FileOutputStream(fileName+".xlsx");
                 workbook.write(fileOut);
		fileOut.close();
	        // Closing the workbook
	        workbook.close();
                
                // ---- Clear all Array list
            
               FormationsArray .clear();
             
                
                JOptionPane.showMessageDialog(null, "Completed");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
                         System.out.println("IOException while adding Xl file "+e);
		}  
           catch (Exception ex) {
			// TODO Auto-generated catch block
			//ex.printStackTrace(); 
                        System.out.println("Exception while adding Xl file "+ex);
		}
    }
    
}
