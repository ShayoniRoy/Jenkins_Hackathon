package hackathon.team3;



import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class Urbanladder {
	
	Excel_Xpath ex;
	Excel_Write ew;
	 static Property_bookshelf  pb = new Property_bookshelf();
	 
	 public static final Logger logger = LogManager.getLogger(Urbanladder.class);
	 
	 static ExtentTest test;
	 static ExtentReports report;
	 
	 static Screenshots ss = new Screenshots();
	 
	public static boolean isAlertPresent(WebDriver driver)
    {
        try
        {
            driver.switchTo().alert();
            return true;
        }   // try
        catch (NoAlertPresentException Ex)
        {
            return false;
        }   // catch
		
    }
	
	static WebDriver driver;
   
		@SuppressWarnings("deprecation")
		@BeforeTest
		 @Parameters("browser")
		void setupDriver(String browser) throws Exception
		{
			pb.properties();
			
			  		
			if(browser.equalsIgnoreCase("firefox"))
			{
				//create firefox instance
				System.setProperty(pb.gecko_Driver(),System.getProperty("user.dir")+"//Drivers//geckodriver.exe" );
			    FirefoxOptions options = new FirefoxOptions();
			    driver = new FirefoxDriver(options);
			    logger.info("Firefox is opened");
				
			}
			//Check if parameter passed as 'chrome'
			else if(browser.equalsIgnoreCase("chrome")){
				//set path to chromedriver.exe
				ChromeOptions chromeOptions= new ChromeOptions();
				chromeOptions.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
				
				System.setProperty(pb.chrome_Driver(),System.getProperty("user.dir")+"//Drivers//chromedriver.exe" );
				//create chrome instance
				 driver = new ChromeDriver(chromeOptions);
				//display the appropriate functioning 
				 logger.info("Google Chrome is opened");
			}
			
				else{
					//If no browser passed throw exception
					throw new Exception("Browser is not correct");//handling exceptions
				}
			
			
			 report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
			 test = report.startTest("Urbanladder");
			 
			
			freemarker.log.Logger.selectLoggerLibrary(freemarker.log.Logger.LIBRARY_NONE); // to disable all logs from freemarker
			
		}
		
		static Actions action;
        @BeforeClass
       void openBrowser() throws Exception
        {
        	  		
    		
        	driver.get(pb.URL());
        	        	      	
        	if(driver.getTitle().equals("Furniture Online: Buy Home Wooden Furniture Online In India At Best Price - Urban Ladder - Urban Ladder"))
			{
        			test.log(LogStatus.PASS, "Navigated to the home page of Urban Ladder successful");
			}
			else
			{
				test.log(LogStatus.FAIL, "Navigated to the home page of Urban Ladder failed");
			}
        	
  
        	driver.manage().window().maximize();
        	ss.takeSnapShot(driver, "./Screenshot/Home Page.jpg");
    		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
       	Thread.sleep(10000);
    		driver.findElement(By.xpath(pb.get_Popup())).click();
    		
        }
		@Test(priority=0)
		void operationSearch() throws Exception
		{
			 logger.info("UrbanLadder Website  is opened");
			WebElement ele1 = driver.findElement(By.xpath(pb.get_Search()));
			ele1.sendKeys("bookshelves");
			driver.findElement(By.xpath(pb.get_Submit())).submit();
			ss.takeSnapShot(driver, "./Screenshot/BookShelves.jpg") ;
			
		}
		
		@Test(priority=1)
		void operationCategory() throws InterruptedException
		{
			Thread.sleep(2000);
			 logger.info("BookShelf page is opened");
           action = new Actions(driver);
				 WebElement hover1 = driver.findElement(By.xpath(pb.get_Category()));
				 action.moveToElement(hover1).click().build().perform();
			
				 WebElement w1 = driver.findElement(By.xpath(pb.get_Category_select()));
				
				 if(w1.getText().equals("Bookshelves"))
					{
		        			test.log(LogStatus.PASS, "Category selected as Bookshelves is successful");
					}
					else
					{
						test.log(LogStatus.FAIL, "Category selected as Bookshelves failed");
					}
				 
				 w1.click();
				 
				 
				 
				 logger.info("Category drop down is selected as bookshelves");
			
		}
		
		@Test(priority=3)
		void operationStorage() throws InterruptedException
		{
				 
				 WebElement hover2 = driver.findElement(By.xpath(pb.get_Storagetype()));
				 action.moveToElement(hover2).click().build().perform();
				 Thread.sleep(2000);
				 WebElement w2 = driver.findElement(By.xpath(pb.get_Storage_select()));
								 
				 if(w2.getText().equals("Open"))
					{
		        			test.log(LogStatus.PASS, "Storage selected as Open succesful");
					}
					else
					{
						test.log(LogStatus.FAIL, "Storage selected as Open failed");
					}
				 w2.click();
				 
				 logger.info("Storage drop down is selected as open");
				
		}		
		
		@Test(priority=2)
		void operationPrice() throws InterruptedException
		{
				 WebElement hover3 = driver.findElement(By.xpath(pb.get_Price()));
				 action.moveToElement(hover3).click().build().perform();
				 Thread.sleep(2000);
				 WebElement slider = driver.findElement(By.xpath(pb.get_Price_select()));
				 Actions move = new Actions(driver);
			      //Thread.sleep(3000);
				 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);   
				 Action action1 = (Action) move.dragAndDropBy(slider, -207, 0).build();
			     action1.perform();
			     
			     WebElement exPrice= driver.findElement(By.xpath("//span[contains(@class,'range-max')]"));
			     
			     
			     if(exPrice.getText().substring(1).equals("14,967"))
					{
		        			test.log(LogStatus.PASS, "Price selected as maximum Rs 15,000");
					}
					else
					{
						test.log(LogStatus.FAIL, "Price selection failed");
					}
			     
			     
			     logger.info("Price slider set to maximum Rs 15,000");
		}	 
			@Test(priority=4)
			void operationstock()
			{
				WebElement stock=driver.findElement(By.xpath(pb.get_Exclude_outofstock()));
				
				 if(stock.getText().equals("Exclude Out Of Stock"))
					{
		        			test.log(LogStatus.PASS, "Exclude out of stock selection successful");
					}
					else
					{
						test.log(LogStatus.FAIL, "Exclude out of stock selection failed");
					}
			     
				
				stock.click();
			}
		
		@Test(priority=5)
		void closePopUp() throws InterruptedException
		{
			Thread.sleep(2000);
		if(isAlertPresent(driver))
				 {
					 driver.findElement(By.xpath(pb.get_Popup())).click();
				 }
		}
		
		
		@Test(priority=6)
		void printBookShelves() throws Exception
		{
			ex=new Excel_Xpath();
			String strItems[]=ex.readFromExcel();
			
			Thread.sleep(2000);
	        ss.takeSnapShot(driver, "./Screenshot/Filtered Items.jpg") ;
		
	        
	        ew=new Excel_Write();
	       
		System.out.println("\n\n");
	    System.out.println(" _________________________________________");
	    System.out.println("|                                         |");
		WebElement shelf1_name = driver.findElement(By.xpath(strItems[0]));
		System.out.println("|BookShelf Name : "+shelf1_name.getText()+"    |"); 
		WebElement shelf1_price = driver.findElement(By.xpath(strItems[1]));
		System.out.println("|BookShelf Price : Rs "+shelf1_price.getText().substring(1)+"               |"); 
		System.out.println("|                                         |");
		System.out.println("|_________________________________________|");
		
		ew.writeIntoExcel(shelf1_name.getText(),shelf1_price.getText(),1);
		
//		web.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("\n");
		System.out.println(" _________________________________________");
		System.out.println("|                                         |");
		WebElement shelf2_name = driver.findElement(By.xpath(strItems[2]));
		System.out.println("|BookShelf Name  : "+shelf2_name.getText()+"      |"); 
		WebElement shelf2_price = driver.findElement(By.xpath(strItems[3]));
		System.out.println("|BookShelf Price : Rs "+shelf2_price.getText().substring(1)+"              |");
		System.out.println("|                                         |");
		System.out.println("|_________________________________________|");
//		web.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		ew.writeIntoExcel(shelf2_name.getText(),shelf2_price.getText(),2);
		
		
		System.out.println("\n");
		System.out.println(" ______________________________________________");
		System.out.println("|                                              |");
		WebElement shelf3_name = driver.findElement(By.xpath(strItems[4]));
		System.out.println("|BookShelf Name : "+shelf3_name.getText()+"|"); 
		WebElement shelf3_price = driver.findElement(By.xpath(strItems[5]));
		System.out.println("|BookShelf Price : Rs "+shelf3_price.getText().substring(1)+"                   |");
		System.out.println("|                                              |");
		System.out.println("|______________________________________________|");
		
		ew.writeIntoExcel(shelf3_name.getText(),shelf3_price.getText(),3);
		
		System.out.println("\n\n");
		}
		
        
		@AfterTest
		void closeBrowser() throws Exception
        {   
			driver.close();
			report.endTest(test);
			report.flush();
		}
		
		 

}
