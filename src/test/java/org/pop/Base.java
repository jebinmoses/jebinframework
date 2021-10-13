package org.pop;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public static WebDriver driver;	
	public static Actions a;
    public static Robot r;
    public static Alert al;
    public static TakesScreenshot tk;
    public static JavascriptExecutor j;
    public static Select s;
    public static File f;
    public static FileInputStream fin;
    public static Workbook w;
    public static Sheet s1;
     public static Row r1;
    
		 public static void launchChrome() {
			 WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		 }
		 public static void loadUrl(String url) {
			 driver.get(url);
			}
		 public static void winMax() {
			driver.manage().window().maximize();

		}
		 public static void printTitle() {
			System.out.println(driver.getTitle());

		}
		 public static void printUrl() {
		System.out.println(	driver.getCurrentUrl());

		}
		public static  void fill(WebElement ele, String value) {
			ele.sendKeys(value);
			
			}
		public static void fills(WebElement ele,String value) {
			ele.sendKeys(value);
			
		}
		public static  void btnClick(WebElement ele) {
			ele.click();
		}
		public static void closeChrome() {
			driver.close();

		}
		public static void quit() {
			driver.quit();
		}
		
		public static void printStartTime() {
			Date d = new Date();
			System.out.println(d);

		}
		public static void printEndTime() {
			Date d = new Date();
			System.out.println(d);

		}
		
		public static void pageRefresh() {
              driver.navigate().refresh();
		}
		
		public static String  getData(int rowNumber,int cellNumber) throws IOException {
			
	           File f = new File ("C:\\Users\\jebin\\eclipse-workspace\\MavenWorks\\target\\File\\Book1.xlsx");
	           
	           FileInputStream fin = new FileInputStream(f);
	           
	           Workbook w = new XSSFWorkbook(fin);
	           
	           Sheet s = w.getSheet("Work");
	           
	           Row row = s.getRow(rowNumber);
	           
	           Cell cell = row.getCell(cellNumber);
	           
	           int cellType = cell.getCellType();
	           
	           String value = " ";
	           
	           if (cellType==1) {
	        	    value = cell.getStringCellValue();
				
			}else if (cellType==0) {
				if (DateUtil.isCellDateFormatted(cell)) {
					Date d = cell.getDateCellValue();
					SimpleDateFormat sim = new SimpleDateFormat("MM-dd-yyyy");
					sim.format(d);
				}
				else {
					double d = cell.getNumericCellValue();
					long l =(long)d;
					String valueOf = String.valueOf(l);
					System.out.println(value);
				}
				
			}
	           return value;	       	           
	           
	     }
		public static  void getSleep(long value) {
			driver.manage().timeouts().implicitlyWait(value,TimeUnit.SECONDS);

		}
		public static void getMoveToElement(WebElement ele) {
			a= new Actions(driver);
			a.moveToElement(ele).perform();

		}
		public static void getDragAndDrop(WebElement src,WebElement Target) {
			a=new Actions(driver);
			a.dragAndDrop(src, Target).perform();

		}
		public static void rightClick() {
			a=new Actions(driver);
			a.contextClick().perform();

		}
		public static void getDoubleClick() {
			a=new Actions(driver);
			a.doubleClick().perform();

		}
		public static void pressEnter() throws AWTException {
			r= new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			}
		
		public static void pressTab() throws AWTException {
			r= new Robot();
        r.keyPress(KeyEvent.VK_TAB);
        r.keyRelease(KeyEvent.VK_TAB);

		}
		
		public static void keyDown(int value) throws AWTException {
			
			 r = new Robot();
			
			for (int i = 0; i < value; i++) {
				r.keyPress(KeyEvent.VK_DOWN);
				r.keyRelease(KeyEvent.VK_DOWN);
				
				
			}
			
		}
		public static void copy() {
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_C);
			
			r.keyRelease(KeyEvent.VK_C);
			r.keyRelease(KeyEvent.VK_CONTROL);

			}
		public static void paste() {
			r.keyPress(KeyEvent.VK_PASTE);
			r.keyRelease(KeyEvent.VK_PASTE);
		}
		
		public static void alertacc() {
			al = driver.switchTo().alert();
			al.accept();
		}
	    public static void alertDismiss() {
	    	al = driver.switchTo().alert();
            al.dismiss();
		}
	    public static void passKeys(String value) {
	    	al= driver.switchTo().alert();
           al.sendKeys(value);
		}
	    public static void printText() {
	    	al = driver.switchTo().alert();
            String text = al.getText();
            System.out.println(text);
            
}
	    public static void takeScreenShot() throws IOException {
               tk= (TakesScreenshot)driver;
               File src = tk.getScreenshotAs(OutputType.FILE);
               File des = new File("C:\\Jebin\\pic.jpg");
               FileUtils.copyFile(src, des);
		}
	    public static void javaexeclick(WebElement ele) {
	    	 j = (JavascriptExecutor)driver;
	    	 j.executeScript("arguments[0].click()",ele);

		}
	    public static void getAttribute(WebElement ele) {
			Object o = j.executeScript("return arguments[0].getAttribute('value')", ele);
			String user= (String)o;
			System.out.println(user);
	    }
	    public static void scrollTop() {
	    	j=(JavascriptExecutor)driver;
			j.executeScript("arguments[0].scrollIntoView(True)");
		}
	    public static void scrollBottom() {
	    	j=(JavascriptExecutor)driver;
	    	j.executeScript("arguments[0].scrollIntoView(False)");
		}
	    public static void toHighlight(WebElement ref) {
	    	j=(JavascriptExecutor)driver;
            j.executeScript("arguments[0].setAttribute('style','background:yellow;border:10px solidgreen';)",ref);
            
		}
	    public static void selectByVal(WebElement ref,String value) {
			s=  new Select (ref);
			s.selectByValue(value);
			
		}
	    
	    public static void selectByVisible(WebElement ref,String value) {
	    	s=  new Select (ref);
	    	s.selectByVisibleText(value);
		}
	    public static void selectByInd(WebElement ref,int value) {
	    	s=  new Select (ref);
	    	s.selectByIndex(value);
		}
	    public static void isMulti(WebElement ref) {
	    	s=  new Select (ref);
             boolean m = s.isMultiple();
             System.out.println(m);
             
		}
	    public static void getingOption(WebElement ref) {
	    	s=  new Select (ref);
	    	List<WebElement> li = s.getOptions();
	    	for (WebElement x : li) {
				String text = x.getText();
				System.out.println(text);
			}
		}
	    public static void getingAllSelection(WebElement ref) {
	    	s=  new Select (ref);
	    	List<WebElement> a = s.getAllSelectedOptions();
	    	for (WebElement x : a) {
				String text = x.getText();
				System.out.println(text);
			}
	    	
	   	}
	    public static	void getingFirstSelectedOption(WebElement ref) {
			s=  new Select (ref);
			WebElement s1 = s.getFirstSelectedOption();
			String text = s1.getText();
			System.out.println(text);
		}
	    public static  void getDeSelectByIndex(WebElement ref,int value) {
	    	s=  new Select (ref);
            s.deselectByIndex(value);
		}
	    public static   void getDeselectByValue(WebElement ref,String value) {
	    	s=  new Select (ref);
	    	s.deselectByValue(value);

		}
	    public static  void getDeSelectByVisibleText(WebElement ref,String value) {
	    	s=  new Select (ref);
	    	s.deselectByVisibleText(value);
		}
	    public static void getDeSelectAll(WebElement ref) {
	    	s=  new Select (ref);
	    	s.deselectAll();
		}
	    
	    public static void switchToFrameeId(String name) {
			driver.switchTo().frame(name);

		}
	    public  static void getWinHandle() {
			String parentId = driver.getWindowHandle();
			System.out.println(parentId);
		}
	    
	    public static void getWinHandles(String value) {
	    	String parentId = driver.getWindowHandle();
	    	Set<String> allId = driver.getWindowHandles();
			for (String eachid : allId) {
				if (!parentId.equals(allId)) {
				driver.switchTo().window(eachid);	
				}
			}
	    	
	    }
	    
	    public static void switchToMultiWin(int Value) {
			Set<String> allWinId = driver.getWindowHandles();
                  int count = 0;
                  for (String childWindow : allWinId) {
					if (count==Value) {
						driver.switchTo().window(childWindow);
					}
					count++;
				}
		}
	    
	    public static void switchToParFramee() {
			
           driver.switchTo().parentFrame();
		}
	    public static    void defaultFrame() {
			driver.switchTo().defaultContent();

		}
	    public static  void waits (long value) throws InterruptedException {
			Thread.sleep(value);
		}
	    
	    public static void locateThePath(String Path) {
			 f=new File(Path);
		}
	    public static void readTheData() throws FileNotFoundException {
			fin= new FileInputStream (f);

		}
	    public static void typeOfWorkbok() throws IOException {
			w=new XSSFWorkbook(fin);

		}
	    public static void getSheet(String value) {
			 s1 = w.getSheet(value);
		}
        public static void getRow(int value) {
		        Row r1 = s1.getRow(value);
		}
        public static void getCell(int value) {
	             Cell cell = r1.getCell(value);
	             
}
         public static void getSheet() {
	
}
	    
} 
	    
	    
	    
	    
	    
	    
    	    
	    
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
