/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdftoxl;

import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author prashanth_mani
 */
public class HomePage extends javax.swing.JFrame {

 	private static String PDF_PATH;
        private static final String XL_FILE_NAME ="/Users/prashanth_mani/eclipse-workspace/XLfile/Template.xlsx";

	private static String[] columns = {"Well ID", "Operator_Name", "Operator_Number","Well_Name", "Well_Number",
                                            "Well_Type","Status","Datum_Elevation","Ground_Elevation",
                                            "Plugback_Depth","Spud_Date","Completion_Date",
                                            "FirstProDate","Total_Depth","Drill_Type","Drill_Started","Drill_Finished"};
        
        private static String[] CasingColumns = {"Well ID", "Casing Size", "Nominal Weight","Grade", "Top of Cement","Feet","PSI","SAX"};
        private static String[] CompletionColumns = {"Well ID", "Completion Type"};
   
        private static ArrayList<WellDetails> WellArray =  new ArrayList<>();

        private static String[] productionZoneColumns = {"Well ID", "OTC Production Unit No"};
            private static ArrayList<ProductionZoneDetails> productionZone = new ArrayList<>();
    /**
     * Creates new form HomePage
     */
    public HomePage() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Select PDF Folder");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Start Convert");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14))
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(113, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(138, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        showFileBrowser();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
             try {
                 // TODO add your handling code here:
                 PDFFolder();
             } catch (IOException ex) {
                 Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
             }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    private void showFileBrowser() {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
             fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
             System.out.println("Selected file: " + selectedFile.getAbsolutePath());
             PDF_PATH = selectedFile.getAbsolutePath();
              jLabel1.setText("PDF Location :"+PDF_PATH);
                //JOptionPane.showMessageDialog(rootPane, result);
                jButton2.setEnabled(true);
            }
    }
    
    
    	public static void PDFFolder() throws IOException
	{
		//String PDFPAth ="/Users/prashanth_mani/eclipse-workspace/PDF/SampleData";
		 File  location= new File(PDF_PATH);
                 String type = ".pdf"; // replace what ever type of file you need to search

         if (location.isDirectory() && location != null) 
         {
             int PDFCount = 0;
            for (File f : location.listFiles()) 
            {
               if (f.isFile() && f.getName().endsWith(".pdf")) 
               {
            
                System.out.println("==================================PDF Name "+f.getName()+"==============================");
                 PDTtoTextContent(PDF_PATH+"/"+f.getName());
                PDFCount++;
                }
           }
            System.out.println("PDF Count = "+PDFCount);
          WellHeaderSheet();
            }
	

       }
        
        
    private static void PDTtoTextContent( String aPDFfile) 
    {

        PdfReader reader;
	 
          String well_id = "";
	  String operator_name = "";
	  String operator_number = "";
	  String well_name = "";
	  String well_number = "";
	  String well_type = "";
	  String status = "";
	  String datum_elevation = "";
	  String ground_elevation = "";
	  String plugback_depth = "";
	  String total_depth = "";
	  String spud_date = "";
	  String completion_date = "";
	  String firstprodate = "";
	  String drill_type = "";
	  String drill_started = "";
	  String drill_finished = "";		 	 
	  int Casing_and_Cement_Line = 0;
          int Liner_line = 0;
	  String OTCProductionUnitNo = "";
		 
		 //WellArray =  new ArrayList<>();
		 
	        try {

	            reader = new PdfReader(aPDFfile);
                 int NumberOfPages =   reader.getNumberOfPages();
	            PdfDocument pdfDoc = new PdfDocument();
                    String OverAllpage ;
                     String textFromPage2="";
	            // pageNumber = 1
	            String textFromPageone = PdfTextExtractor.getTextFromPage(reader, 1);
	              if(NumberOfPages >1)
                    {
                    textFromPage2 = PdfTextExtractor.getTextFromPage(reader, 2);
                   // System.out.println(textFromPage2);
                    }
	          
                    OverAllpage = textFromPageone + textFromPage2;
	            String lines[] = OverAllpage.split("\\r?\\n");
	            System.out.println(OverAllpage);
                    
                   
	 
         
	            int i = 0 ;
	            for (String s:lines) {
	            	
	           if( s.startsWith("API No.:") ) 
	           {
	        	   String APINo = s;
	        	   System.out.println("***************** API No *********");
	        	   String[] splited = s.split(" ");	        	   
	        	   well_id = splited[2].trim();
	        	   String[] Spud_Date =APINo.split("Spud Date:");
	        	   spud_date = Spud_Date[1].trim();	
                                                  
	           }
	           if( s.startsWith("OTC Prod.") ) 
	           {
                       String LAST = "";
                       int count =0;
	        	   try {
	        	   System.out.println("***************** Finished Date*********");
	        	   String[] splited = s.split("Finished Date:");
                           if(count ==0)
                           {
                           for(String s1 : splited)
                           {
                               if(s1.startsWith("OTC Prod."))
                               {
                                LAST = s1.replaceAll("OTC Prod. Unit No.:", " ");  
                               }
                               String[] split = LAST.split("Drilling");    
                              OTCProductionUnitNo = split[0].trim();
                              count++;
                           }
                           }
	        	   completion_date = splited[1].trim();
	        	   }catch(ArrayIndexOutOfBoundsException ex)
	        	   {
	        		   
	        	   }
	        	   
	           }
	           if( s.startsWith("1st Prod Date:") ) 
	           {
	        	   System.out.println("***************** 1st Prod Date:  *********");
	        	 
	        	   String FirstProdDate = s.replaceAll("1st Prod Date:", "");
	        	  firstprodate = FirstProdDate.trim();
	        	   
	           }
	           if( s.startsWith("Completion Date: ") ) 
	           {
	        	   System.out.println("***************** Completion Date:  *********");
	        	 
	        	   String CompletionDate = s.replaceAll("Completion Date: ", ""); 
	        	   drill_finished =  CompletionDate.trim();
	        	   
	           }
	           if( s.startsWith("Drill Type:") ) 
	           {
	        	   System.out.println("***************** Drill Type: *********");
	        	 
	        	   String DrillType = s.replaceAll("Drill Type:", "");
	        	  drill_type = DrillType.trim();
	        	   
	           }
	           
	           if( s.startsWith("Well Name:") ) 
	           {
	        	   System.out.println("***************** Well Name *********");
	        	   String WellData = s;
	        	  String WellNameOnly =   WellData.replaceAll("Well Name:", " ");
	        	   String[] splited = WellNameOnly.split("Purchaser/Measurer:");
	        
	        	   well_name = splited[0].trim();
	        	   well_number = splited[0].trim();
	        	   
	           }
	           if( s.startsWith("Location:") ) 
	           {
                       try{
	        	   System.out.println("***************** Well Name *********");
	        	   String FirstSalesDate = s;
                           if(FirstSalesDate.contains("First Sales Date:")){
	        	   String[] splited = FirstSalesDate.split("First Sales Date:");
                           drill_started = splited[1].trim();
                           }
	        	   
                       }catch(ArrayIndexOutOfBoundsException ex)
	        	   {
	        		 System.out.println("Error in First Sales Date");  
                                 ex.printStackTrace();
	        	   }
	        	   
	           }
	           
	           
	           if( s.startsWith("Derrick")) 
	           {
	        	   System.out.println("***************** Derrick *********");
	        	   String DerrickData = s;
	        	 String WellNameOnly =   DerrickData.replaceAll("Derrick Elevation:", " ");
	        	   String[] splited = WellNameOnly.split("Ground Elevation:");
	        
	        	   datum_elevation = splited[0].trim();
	        	   ground_elevation = splited[1].trim();
	           }
	           
	           
	           if( s.startsWith("Operator:") ) 
	           {
	        	   System.out.println("***************** Operatore *********");
	        	   s.replaceAll("Operator:", " ");
	        	   String[] part = s.split("(?<=\\D)(?=\\d)");
	        	
	        	   String[] OperatorName =  part[0].split("Operator:");
	        	   System.out.println(OperatorName[1].trim());
	        	   operator_name = OperatorName[1].trim();
	        	   operator_number = part[1].trim();
	           }
	           
	           
	           if( s.startsWith("Total Depth:") ) 
	           {
	        	   System.out.println("***************** Total Depth: *********");
	        	   String DerrickData = s;
	        	 String WellNameOnly =   DerrickData.replaceAll("Total Depth:", " ");	        
	        	   total_depth = WellNameOnly.trim();
	        	   
	           }
	           if( s.startsWith("Depth Brand") ) 
	           {
	        	 
	        	   System.out.println("***************** Depth Brand *********"+i);
	        	   String GetDepth = lines[i+1];
	        	   String DepthVal = "NA";
	        	   
	        	   System.out.println("***************** Depth Brand *********"+GetDepth);
	        	   if(!GetDepth.contains("There are no Plug records to display.") )
	        	   {
	        		   if(!GetDepth.contains("There are no Packer records to display.") )
	        		   {
	        			   String[] Allval = GetDepth.split(" ");
	        			   DepthVal= Allval[Allval.length-2];
	        		   }
	        		   else {
	        			 String temp =  GetDepth.replaceAll("There are no Packer records to display. ", " ");
	        			 temp.trim();
	        			  String[] let = temp.split(" ");
	        			  DepthVal= let[1];
	        			   
	        		   }
	        		   plugback_depth = DepthVal;
	        	   }
	        	   
	           }
//                   if( s.startsWith("Formation Name:") ) 
//	           {
//                           String FirstSalesDate = s;
//	        	   String[] splited = FirstSalesDate.split("Class:");
//	        	   well_type = splited[1].trim();
//                           System.out.println("***************** Class Type *********"+well_type);
//
//	           }
                   
                    if( s.startsWith("Casing and Cement") ) 
	           {
	        	 
                           Casing_and_Cement_Line = i;	  
                             System.out.println("***************** Completion Type *********"+Casing_and_Cement_Line);
	           }
                     if( s.startsWith("Liner") ) 
	           {
	        	   
                           Liner_line = i;	
                          int GetColumns =  Liner_line - Casing_and_Cement_Line;
                          if(GetColumns == 4)
                          {
                              System.out.println("***************** Two Colums *********"+Liner_line);
                             // for ( int index =0; Liner_line-1;  )
                              
                              
                          }
                          else if(GetColumns == 5){
                           System.out.println("***************** ThreeColums *********"+Liner_line);
                          }
                           
                           
	           }
                    if( s.startsWith("X") ) 
	           {
	        	   System.out.println("***************** Completion Type *********");
	        	 
	        	   
	           }
                    
                    // Second Page content
                     if( s.startsWith("Formation Name:") ) 
                         {
                           String FormationName = s;
	        	   String[] splited = FormationName.split("Class:");
	        	   well_type = splited[1].trim();
                           System.out.println("***************** Class Type *********"+well_type);

                          }
                      if( s.startsWith("Status:") ) 
                         {
                           String Status = s;
	        	   String getStatus = Status.replaceAll("Status:", "");
	        	   status = getStatus.trim();
                           System.out.println("***************** Status *********"+status);
                          }
                    
                    
                    
	           
	           i++;

	            }
	            WellArray.add(new WellDetails(well_id,operator_name,operator_number,well_name,well_number,status,well_type,datum_elevation,ground_elevation,plugback_depth,spud_date,completion_date,firstprodate,total_depth,drill_type,drill_started,drill_finished));
                    productionZone.add(new ProductionZoneDetails(well_id, OTCProductionUnitNo));
                    reader.close();
            
	        } 
                catch (IOException e) {
	            e.printStackTrace();
	        }
	        catch (ArrayIndexOutOfBoundsException ex)
	        {
	        	 ex.printStackTrace();
	        }
	    }
    
    public static void WellHeaderSheet()
	{// Create a Workbook
            
        Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

        /* CreationHelper helps us create instances of various things like DataFormat, 
           Hyperlink, RichTextString etc, in a format (HSSF, XSSF) independent way */
        CreationHelper createHelper = workbook.getCreationHelper();

        // Create a Sheet
        Sheet sheet = workbook.createSheet("WellHeader");
        Sheet ProductionZoneSheet = workbook.createSheet("ProductionZone");

//           Create a Font for styling header cells
//           Font headerFont = workbook.createFont();
//           headerFont.setBold(true);
//           headerFont.setFontHeightInPoints((short) 14);
//           headerFont.setColor(IndexedColors.RED.getIndex());

        // Create a CellStyle with the font
        CellStyle headerCellStyle = workbook.createCellStyle();
     //   headerCellStyle.setFont(headerFont);

        // Create a Row
        Row headerRow = sheet.createRow(0);
        
        for(int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }
        
        Row productionHeaderRow = ProductionZoneSheet.createRow(0);

         for(int i = 0; i < productionZoneColumns.length; i++) {
            Cell cell = productionHeaderRow.createCell(i);
            cell.setCellValue(productionZoneColumns[i]);
            cell.setCellStyle(headerCellStyle);
        }
        
         int rowNum = 1;

         for(ProductionZoneDetails produZone :productionZone)
         {
             Row row = ProductionZoneSheet.createRow(rowNum++);
             row.createCell(0)
                    .setCellValue(produZone.getWell_ID());
             row.createCell(1)
                    .setCellValue(produZone.getOTCProductionUnitNo());
             
         }
         
        rowNum =1;
        
        for(WellDetails well: WellArray) {
            Row row = sheet.createRow(rowNum++);

            row.createCell(0)
                    .setCellValue(well.getWell_ID());

            row.createCell(1)
                    .setCellValue(well.getOperator_Name());

            row.createCell(2)
                    .setCellValue(well.getOperator_Number());
            row.createCell(3)
            .setCellValue(well.getWell_Name());
            row.createCell(4)
            .setCellValue(well.getWell_Number());
            row.createCell(5)
            .setCellValue(well.getWell_Type());
            row.createCell(6)
            .setCellValue(well.getStatus());
            row.createCell(7)
            .setCellValue(well.getDatum_Elevation());
            row.createCell(8)
            .setCellValue(well.getGround_Elevation());
            row.createCell(9)
            .setCellValue(well.getPlugback_Depth());
            row.createCell(10)
            .setCellValue(well.getSpud_Date());
            row.createCell(11)
            .setCellValue(well.getCompletion_Date());
            row.createCell(12)
            .setCellValue(well.getFirstProDate());
            row.createCell(13)
            .setCellValue(well.getTotal_Depth());
            row.createCell(14)
            .setCellValue(well.getDrill_Type());
            row.createCell(15)
            .setCellValue(well.getDrill_Started());
            row.createCell(16)
            .setCellValue(well.getDrill_Finished());
            
        }
        
        sheet = workbook.createSheet("Casing");
        Row CasingheaderRow = sheet.createRow(0);
        
        for(int i = 0; i < CasingColumns.length; i++) {
            Cell cell = CasingheaderRow.createCell(i);
            cell.setCellValue(CasingColumns[i]);
            cell.setCellStyle(headerCellStyle);
        }
        
        sheet = workbook.createSheet("Completion");
        Row CompletionheaderRow = sheet.createRow(0);
        
        for(int i = 0; i < CompletionColumns.length; i++) {
            Cell cell = CompletionheaderRow.createCell(i);
            cell.setCellValue(CompletionColumns[i]);
            cell.setCellStyle(headerCellStyle);
        }
       
           try {
        	 FileOutputStream fileOut = new FileOutputStream("WellDetailsNew.xlsx");
                 workbook.write(fileOut);
		fileOut.close();
	        // Closing the workbook
	        workbook.close();
                JOptionPane.showMessageDialog(null, "Completed");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
           
           
           
	}
    
    
    
    
}
