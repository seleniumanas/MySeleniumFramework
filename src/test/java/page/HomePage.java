package page;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver;
	By imFeelingLuckyBtn=By.name("btnIx");
	FileInputStream fis;
	XSSFWorkbook wb;
	
	
	public HomePage(WebDriver driver){
		this.driver=driver;
	}
	public void verifyClick() {
		try {
			fis = new FileInputStream(new File("C://Users//manas.goswami//workspace//MyTest//src//test//resources//testData//testData.xlsx"));
		}
		catch(FileNotFoundException e){
			System.out.println("File not found"+e.getStackTrace());
		}
		
		
		try {
			wb = new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet s1=wb.getSheet("Sheet1");
		driver.get(s1.getRow(1).getCell(0).getStringCellValue());
		driver.findElement(imFeelingLuckyBtn).click();
	}

}
