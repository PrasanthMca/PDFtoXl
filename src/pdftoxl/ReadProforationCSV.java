/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdftoxl;

import au.com.bytecode.opencsv.CSVReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
public class ReadProforationCSV {
private static ArrayList<Perforation> PerforationArray = new ArrayList<>();
 private static ArrayList<ProductionZoneDetails> productionZone = new ArrayList<>();
 
       private static String[] PerforationColumns = {"Well ID", "Formation Name", "Code","Class", "Top Depth", "Base Depth", "Spacing Order", "Unit Size", "Fracture Treatments", "Acid Volumes", "PDFName"};
       private static String[] productionZoneColumns = {"Well ID", "OTC Production Unit No","Formation Name","PDFName"};

    public static void main(String[] args) throws IOException {

        //final String FILENAME="/Users/prashanth_mani/Desktop/Merged_CSV.csv";
        final String FILENAME = "/Users/prashanth_mani/Desktop/Merged_CSV_Updated.csv";
        readDataLineByLine(FILENAME);
           
            WellHeaderSheet();
        //  ReadWithSeperator(FILENAME);

    }

    public static void readDataLineByLine(String file) {

        try {

            // Create an object of filereader 
            // class with CSV file as a parameter. 
            FileReader filereader = new FileReader(file);

            // create csvReader object passing 
            // file reader as a parameter 
            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;

            boolean StartReadorder = false;
            boolean StartReadAcideValues = false;
             boolean StartFormationNameValues = false;
            int Current_Row = 1;
            int OrderItemRow = 0;
            int AcideItemRow = 0;
            
            int FractureNameVAL = 0;

            int AcideRowPosition = 0;
            int FracturePosition = 0;

            String Formation = "";
            String Class = "";
            String Code = "";

            String Order_No = "";
            String Unit_Size = "";
            String From = "";
            String To = "";
            String CSVName = "";

            String AcideVAL = "";
            String FractureVAL = "";
            int RecordCount = 1;

            // we are going to read data line by line 
            while ((nextRecord = csvReader.readNext()) != null) {

                int recordNextStep =0;
                for (String cell : nextRecord) {
                        recordNextStep =recordNextStep+1;
                    if (cell.startsWith("Formation Name:")) {
                        String[] splited = cell.split("Formation Name:");
                        if (splited.length > 1) {
                            if (!splited[1].trim().equalsIgnoreCase("")) {
                                Formation = splited[1].trim();
                                try{
                                if (Formation.contains("Code:")) {
                                    String[] Formoverall = Formation.split("Code:");
                                    Formation = Formoverall[0].trim();
                                    Class = Formoverall[1].trim();
                                    String[] Splicode = Class.split("Class:");
                                    //Code = Splicode[0].trim();
                                     Code = !Splicode[0].equals("")?Splicode[0].trim():Splicode[0];
                                    Class = !Splicode[1].equals("")?Splicode[1].trim():Splicode[1];

                                }
                                }catch(Exception ex)
                                {
                                    ex.printStackTrace();
                                }
                                
                            }
                        }
                        //System.out.print(cell + "\t"); 
                    }
                    if (cell.startsWith("Order No")) {
                        StartReadorder = true;
                        OrderItemRow = Current_Row + 1;

                    }
                    if (StartReadorder) {

                        if (Current_Row == OrderItemRow) {
                            System.out.print(cell + "\t");
                            if (cell.length() > 5) {
                                Order_No = nextRecord[0];
//                         if(Order_No.equals("There are no Spacing Order records to display."))
//                         {
//                         
//                         }

                                Unit_Size = nextRecord[1];
                                if (nextRecord[2].equals("") || nextRecord[2].equals(" ")) {
                                    From = nextRecord[3];
                                    To = nextRecord[4];
                                } else {
                                    From = nextRecord[2];
                                    To = nextRecord[3];
                                }
                                CSVName = nextRecord[5].trim();

                            }

                        }
                    }

                    if (cell.startsWith("Acid Volumes")) {
                        StartReadorder = false;
                        
                        AcideItemRow = Current_Row + 1;
                        List<String> wordList = Arrays.asList(nextRecord);

                        AcideRowPosition = wordList.indexOf("Acid Volumes");
                        FracturePosition = wordList.indexOf("Fracture Treatments");
                        //System.out.print(wordList.indexOf("Acid Volumes"));
                       // System.out.print(wordList.indexOf("Fracture Treatments"));

                    }
                    if (AcideItemRow == Current_Row) {
                        AcideVAL = nextRecord[AcideRowPosition];
                       
                        FractureVAL = nextRecord[FracturePosition];
                        if(FractureVAL.equals("") && (!nextRecord[FracturePosition+1].equals("")))
                        {
                            FractureVAL=nextRecord[FracturePosition+1];
                        }
                         StartReadAcideValues = true;
                      
                    }
                    if (StartReadAcideValues && recordNextStep ==6 ) {
                          
//                            System.out.println(Formation);
//                             System.out.println(Code);
//                              System.out.println(Class);
//                              System.out.println(From);
//                           System.out.println(To);
//                            System.out.println(Unit_Size);
//                             System.out.println(Order_No);
                             
//                        System.out.println(AcideVAL);
//                        System.out.println(FractureVAL);
                      StartReadAcideValues = false;
                       System.out.println(RecordCount);
                       RecordCount=RecordCount+1;
                      String well_id ="";
                      String PdfName = nextRecord[5];
//                      System.out.println(PdfName);
               PerforationArray.add(new Perforation(well_id, Formation, Code, Class, From, To, Order_No, Unit_Size, FractureVAL, AcideVAL, PdfName));

                    }
                    if (cell.startsWith("Formation")&& cell.equals("Formation")) {
                        StartFormationNameValues =true;
                        FractureNameVAL = Current_Row+1;
                        }

                    if(StartFormationNameValues  && recordNextStep ==6 )
                    {
                        if(FractureNameVAL == Current_Row){
                            String PdfName = nextRecord[5];
//                        System.out.println(nextRecord[0]);
                      productionZone.add(new ProductionZoneDetails("", "",nextRecord[0],PdfName));     

                        
                        }
                        else if(!nextRecord[0].equals("") && !nextRecord[0].equals("Formation")){
                            
                           if((nextRecord[0].startsWith("Completion and Test Data by Producing Formation")) || (nextRecord[0].startsWith("Formation Name:") ))
                           {
                               StartFormationNameValues =false;
                                System.out.println(nextRecord[0]);
                           }
                           else{
                               
//                               System.out.println(nextRecord[0]);
                                String PdfName = nextRecord[5];
//                        System.out.println(nextRecord[0]);
                      productionZone.add(new ProductionZoneDetails("", "",nextRecord[0],PdfName));     
                                //FractureNameVAL = Current_Row+1;
                           }
                           
                               }
                    }
                }
                
                
                
                
                Current_Row = Current_Row + 1;
               
            }
         
            
        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }
    
    
    
      public static void WellHeaderSheet()
	{// Create a Workbook
               Workbook workbook = new XSSFWorkbook(); 
               
             Sheet PerforationSheet = workbook.createSheet("Perforation");
             Sheet ProductionZoneSheet = workbook.createSheet("ProductionZone");
             
             
             
               // ******************************************************************
      
      
      
       Row PerforationHeader = PerforationSheet.createRow(0);
          CellStyle headerCellStyle = workbook.createCellStyle();
        for(int i = 0; i < PerforationColumns.length; i++) {
            Cell cell = PerforationHeader.createCell(i);
            cell.setCellValue(PerforationColumns[i]);
            cell.setCellStyle(headerCellStyle);
        }
       int PerforationRow = 1 ;
        for (Perforation aPerforation : PerforationArray) {
            Row row = PerforationSheet.createRow(PerforationRow++);
            row.createCell(0)
                    .setCellValue(aPerforation.getWell_ID());
            row.createCell(1)
                    .setCellValue(aPerforation.getFormationName());
            row.createCell(2)
                    .setCellValue(aPerforation.getCode());
            row.createCell(3)
                    .setCellValue(aPerforation.getWellType());
            row.createCell(4)
                    .setCellValue(aPerforation.getFrom());
            row.createCell(5)
                    .setCellValue(aPerforation.getTo());
            row.createCell(6)
                    .setCellValue(aPerforation.getOrderNo());
            row.createCell(7)
                    .setCellValue(aPerforation.getUnitSize());
            row.createCell(8)
                    .setCellValue(aPerforation.getFractureTreatments());
            row.createCell(9)
                    .setCellValue(aPerforation.getAcidVolumes());
            row.createCell(10)
                    .setCellValue(aPerforation.getPDFName());
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
             row.createCell(2)
                    .setCellValue(produZone.getFormationName());
              row.createCell(3)
                    .setCellValue(produZone.getPDFname());
             
         }
        
        
         String currentDate = null;
        String fileName = "PerforationDetailsNew";
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
            
               productionZone.clear();
              
               PerforationArray.clear();
             
                
//                JOptionPane.showMessageDialog(null, "Completed");
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

    public static void ReadWithSeperator(String file) throws FileNotFoundException, IOException {
        CSVReader reader = new CSVReader(new FileReader(file), ';', '"', 1);

        //Read all rows at once
        List<String[]> allRows = reader.readAll();

        //Read CSV line by line and use the string array as you want
        for (String[] row : allRows) {
            System.out.println(Arrays.toString(row));
        }
    }

}
