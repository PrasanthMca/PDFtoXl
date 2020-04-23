/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdftoxl;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import technology.tabula.Line;
import technology.tabula.ObjectExtractor;
import technology.tabula.Page;
import technology.tabula.RectangularTextContainer;
import technology.tabula.Ruling;
import technology.tabula.Table;
import technology.tabula.TextChunk;
import technology.tabula.TextElement;
import technology.tabula.extractors.BasicExtractionAlgorithm;
import technology.tabula.extractors.SpreadsheetExtractionAlgorithm;
/**
 *
 * @author prashanth_mani
 */
public class tableExtract {
    public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		final String FILENAME="/Users/prashanth_mani/Desktop/Temp3/Error/500264886_1707S01W_NW_NW_NW_NE_085211820000__8__2__2013.pdf";
		
		PDDocument pd = PDDocument.load(new File(FILENAME));
		
		int totalPages = pd.getNumberOfPages();
		System.out.println("Total Pages in Document: "+totalPages);
		
		ObjectExtractor oe = new ObjectExtractor(pd);
		//SpreadsheetExtractionAlgorithm sea = new SpreadsheetExtractionAlgorithm();
                
                BasicExtractionAlgorithm sea = new BasicExtractionAlgorithm();
		Page page = oe.extract(2);
		
		// extract text from the table after detecting
		List<Table> table = sea.extract(page);
		for(Table tables: table) {
			List<List<RectangularTextContainer>> rows = tables.getRows();
			
			for(int i=0; i<rows.size(); i++) {
				
				List<RectangularTextContainer> cells = rows.get(i);
				
				for(int j=0; j<cells.size(); j++) {
					System.out.print(cells.get(j).getText()+"|");
				}

				System.out.println();
			}
		}
		
	}

    
}
