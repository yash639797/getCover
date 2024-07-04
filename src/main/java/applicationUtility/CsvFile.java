package applicationUtility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.opencsv.CSVWriter;

import baseLibrary.BaseClass;

public class CsvFile extends BaseClass
{

	 
	
	
public static String regularPriceingCsv(int numRows) {
	
    String filePath = "D:\\CsvFile\\csv"+ApplicationUtility.genrateRondomNumber(3)+".csv";
	File file = new File(filePath) ;
	
	

    try { 
        FileWriter outputfile = new FileWriter(file); 
        CSVWriter writer = new CSVWriter(outputfile); 

        String[] header = {"Brand","Model","Serial","Condition","RetailValue","Parts Warranty","Labour Warranty","Purchase Date"};

        writer.writeNext(header); 
        for(int i=1;i<=numRows;i++)
        {
        	String productBrandList[]= {"Apple","Jio","Adani","Tata","Hero"};
        	int	randonProductBrandListIndex=ApplicationUtility.getRandomIndexInArray(productBrandList.length);
        	String productBrandName=productBrandList[randonProductBrandListIndex];
        	
        	String modelList[]= {"pro","pro+","Simple"};
        	int randomModelListIndex=ApplicationUtility.getRandomIndexInArray(modelList.length);
        	String modelName=modelList[randomModelListIndex];
        	
        	String serialNumber=ApplicationUtility.generateRandomString(6)+i;
        	
        	String conditionList[]= {"old","new"};
        	int conditionListIndex=ApplicationUtility.getRandomIndexInArray(conditionList.length);
        	String condition=conditionList[conditionListIndex];
        	
        	int retailPrice=ApplicationUtility.genrateRondomNumber(4);
        	int partsWarranty=ApplicationUtility.genrateRondomNumber(1);
        	int labourWarranty=ApplicationUtility.genrateRondomNumber(1);
        	LocalDate currentDate = LocalDate.now();
        	
       	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            
            String formattedDate = currentDate.format(formatter);
        	
        	
        	String[] data = { productBrandName,modelName,serialNumber,condition,String.valueOf(retailPrice),String.valueOf(partsWarranty),String.valueOf(labourWarranty),formattedDate}; 

            writer.writeNext(data); 
        	
        }
        writer.close(); 
    } 

    catch (IOException e) { 
        e.printStackTrace(); 

    }
	return filePath; 
} 
	

public static String flatPriceingCsv(int numRows,int startRange,int endRange) {
	
	String filePath = "D:\\CsvFile\\csv"+ApplicationUtility.genrateRondomNumber(3)+".csv";
	File file = new File(filePath) ;
	
	

    try { 
        FileWriter outputfile = new FileWriter(file); 
        CSVWriter writer = new CSVWriter(outputfile); 

        String[] header = {"Brand","Model","Serial","Condition","RetailValue","Parts Warranty","Labour Warranty","Purchase Date"};
        writer.writeNext(header); 
        for(int i=1;i<=numRows;i++)
        {
        	String productBrandList[]= {"Apple","Jio","Adani","Tata","Hero"};
        	int	randonProductBrandListIndex=ApplicationUtility.getRandomIndexInArray(productBrandList.length);
        	String productBrandName=productBrandList[randonProductBrandListIndex];
        	
        	String modelList[]= {"pro","pro+","Simple"};
        	int randomModelListIndex=ApplicationUtility.getRandomIndexInArray(modelList.length);
        	String modelName=modelList[randomModelListIndex];
        	
        	String serialNumber=ApplicationUtility.generateRandomString(6)+i;
        	
        	String conditionList[]= {"old","new"};
        	int conditionListIndex=ApplicationUtility.getRandomIndexInArray(conditionList.length);
        	String condition=conditionList[conditionListIndex];
        	
        	 Random random = new Random();
        	 
             int retailPrice = (random.nextInt(endRange - startRange) + startRange);
             int partsWarranty=ApplicationUtility.genrateRondomNumber(1);
         	int labourWarranty=ApplicationUtility.genrateRondomNumber(1);
         	LocalDate currentDate = LocalDate.now();
         	
        	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
             
             String formattedDate = currentDate.format(formatter);
         	
    
         	String[] data = { productBrandName,modelName,serialNumber,condition,String.valueOf(retailPrice),String.valueOf(partsWarranty),String.valueOf(labourWarranty),formattedDate}; 

            writer.writeNext(data); 
        	
        }
        writer.close(); 

    } 

    catch (IOException e) { 

        e.printStackTrace(); 

    } 
    return filePath;
} 
 
public static String  QuantityPriceingCsv() {
	
	String filePath = "D:\\CsvFile\\csv"+ApplicationUtility.genrateRondomNumber(3)+".csv";
	File file = new File(filePath) ;
	
	int totalProduct=0;
try {
	List<WebElement> Product=driver.findElements(By.xpath("//label[text()='# of Quantity']/preceding-sibling::input"));
	for(WebElement dd:Product)
	{
		int randomnum=ApplicationUtility.genrateRondomNumber(4);
		dd.click();
		dd.sendKeys(String.valueOf(randomnum));
		totalProduct=totalProduct+randomnum;
	}
	 
} catch (Exception e) {
	System.out.println(e);	
}
    try { 
        FileWriter outputfile = new FileWriter(file); 
        CSVWriter writer = new CSVWriter(outputfile); 

        String[] header = {"Brand","Model","Serial","Condition","RetailValue","Parts Warranty","Labour Warranty","Purchase Date"};
        writer.writeNext(header); 
        for(int i=1;i<=totalProduct;i++)
        {
        	String productBrandList[]= {"Apple","Jio","Adani","Tata","Hero"};
        	int	randonProductBrandListIndex=ApplicationUtility.getRandomIndexInArray(productBrandList.length);
        	String productBrandName=productBrandList[randonProductBrandListIndex];
        	
        	String modelList[]= {"pro","pro+","Simple"};
        	int randomModelListIndex=ApplicationUtility.getRandomIndexInArray(modelList.length);
        	String modelName=modelList[randomModelListIndex];
        	
        	String serialNumber=ApplicationUtility.generateRandomString(6)+i;
        	
        	String conditionList[]= {"old","new"};
        	int conditionListIndex=ApplicationUtility.getRandomIndexInArray(conditionList.length);
        	String condition=conditionList[conditionListIndex];
        	
        	int retailPrice=ApplicationUtility.genrateRondomNumber(4);
        	int partsWarranty=ApplicationUtility.genrateRondomNumber(1);
        	int labourWarranty=ApplicationUtility.genrateRondomNumber(1);
        	LocalDate currentDate = LocalDate.now();
        	
       	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            
            String formattedDate = currentDate.format(formatter);
        	
   
        	String[] data = { productBrandName,modelName,serialNumber,condition,String.valueOf(retailPrice),String.valueOf(partsWarranty),String.valueOf(labourWarranty),formattedDate}; 

            writer.writeNext(data); 
        	
        }
        writer.close(); 

    } 

    catch (IOException e) { 

        e.printStackTrace(); 

    } 
    return filePath;
} 
	
public static String  claimCsv(ArrayList<String> contractId)
{
	String filePath = "D:\\CsvFile\\csv"+ApplicationUtility.genrateRondomNumber(3)+".csv";
	File file = new File(filePath) ;

    try { 
        FileWriter outputfile = new FileWriter(file); 
        CSVWriter writer = new CSVWriter(outputfile); 
        
        String[] header = {"Contract Id","servicer name","date","Dignosis"};

        writer.writeNext(header); 
        for(String dd:contractId)
        {
        	LocalDate currentDate = LocalDate.now();
        	
        	 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
             
             String formattedDate = currentDate.format(formatter);
         
        	
        	String[] data = { dd," ",formattedDate,"testing"}; 

            writer.writeNext(data); 
        	
        }
        writer.close(); 
        
    } 

    catch (IOException e) { 

        e.printStackTrace(); 

    } 

    return filePath;
}
  
}