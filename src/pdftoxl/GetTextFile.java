/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdftoxl;

import au.com.bytecode.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
/**
 *
 * @author Prasanth
 */
public class GetTextFile {
     /**
     * @param args the command line arguments
     */
  public static String CSVFILEPATH = "C:\\Users\\Prasanth\\Downloads\\SampleLinks.csv";
    public static String OUTPUTFOLDERPATH = "C:\\Users\\Prasanth\\Desktop\\files/\\";
    public static void main(String[] args) throws MalformedURLException, Exception {
     
            
        ReadCSVFile();

     
    }
     public static void downloadFile(URL url, String fileName) throws Exception {
        try (InputStream in = url.openStream()) {
            Files.copy(in, Paths.get(fileName));
        }
    }
     
     public static void ReadCSVFile()
     {
          CSVReader reader = null;
        try
        {
            //Get the CSVReader instance with specifying the delimiter to be used
            reader = new CSVReader(new FileReader(CSVFILEPATH), ',');
 
            String [] nextLine;
 
            //Read one line at a time
            while ((nextLine = reader.readNext()) != null) 
            {
                for(String token : nextLine)
                {
                    //Print all tokens
                    System.out.println(token);
                    if(token.contains("http"))
                    {
                        findLinks(token);
                    }
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
     }
     
    private static void findLinks(String url) throws IOException, Exception 
    {
        
          Document doc = Jsoup.parse(new URL(url), 5000);

    Elements resultLinks = doc.select("a");
    System.out.println("number of links: " + resultLinks.size());
    for (Element link : resultLinks) {
        System.out.println();
        String href = link.attr("href");
       
        if(link.text().contains(".txt"))
        {
             System.out.println("Title: " + link.text());
             System.out.println("Url: " + href);
            downloadFile(new URL(href),OUTPUTFOLDERPATH+link.text().toString());
        }
    }


    }

     
     
}
