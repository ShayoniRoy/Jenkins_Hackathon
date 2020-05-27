package hackathon.team3;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class Collection_gift extends Urbanladder
{
	
	@Test(priority=7)
	void printCollections() throws Exception
	{
		
		driver.navigate().to(pb.URL());
	
		 action = new Actions(driver);
		 WebElement collectionHover = driver.findElement(By.xpath(pb.get_Collections()));
		 action.moveToElement(collectionHover).click().build().perform();
		 
		 List<WebElement> list = driver.findElements(By.xpath(pb.get_CollectionList()));
		 Thread.sleep(2000);
	        ss.takeSnapShot(driver, "./Screenshot/Being at home Items.jpg") ;
		 System.out.println("Total being at home collections :"+list.size());
		 
		 for(WebElement we : list)
		 {
			 String items = we.getText();
			 System.out.println(items);
		 }
	
	}
	
	@Test(priority=8)
	void select_GiftsCards() throws Exception
	{
		driver.findElement(By.xpath(pb.get_GiftCards())).click();
		
		if(driver.getTitle().equals("Gift Card - Buy Gift Cards & Vouchers Online for Wedding, Birthday | Urban Ladder"))
		{
				test.log(LogStatus.PASS, "Navigated to Gift Cards page");
		}
		else
		{
			test.log(LogStatus.FAIL, "Navigation to Gift Cards failed failed");
		}
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		 jse.executeScript("window.scrollBy(0,600)");
		 Thread.sleep(2000);
	        ss.takeSnapShot(driver, "./Screenshot/Giftcards.jpg") ;
		 
		 driver.findElement(By.xpath(pb.get_Occassion())).click();
		 
	}
	
	@Test(priority=9)
	void fill_GiftsCards() throws Exception
	{
		 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);  
		 driver.findElement(By.xpath(pb.get_Amount())).click();
		 
		 Select date = new Select(driver.findElement(By.xpath(pb.get_Date())));
		 date.selectByVisibleText("June (2020)");
		 
		 driver.findElement(By.xpath(pb.get_Next())).click();
		
		 WebElement name1=driver.findElement(By.xpath(pb.get_RecipientName()));
		 name1.sendKeys("Eshani Roy");
		 
		 WebElement email1=driver.findElement(By.xpath(pb.get_RecipientEmail()));
		 email1.sendKeys("royeshani@gmail.com");
		 
		 WebElement name2=driver.findElement(By.xpath(pb.get_Custname()));
		 name2.sendKeys("Shayoni Roy");
		 
		 WebElement email2=driver.findElement(By.xpath(pb.get_Custemail()));
		 email2.sendKeys("shayoni@gailcom");
		 
		 WebElement mobile=driver.findElement(By.xpath(pb.get_Mobile()));
		 mobile.sendKeys("8789782180");
		 
		 WebElement message=driver.findElement(By.xpath(pb.get_Msg()));
		 message.sendKeys("Happy Birthday");
		
	        ss.takeSnapShot(driver, "./Screenshot/Filled form.jpg") ;
		 
		 driver.findElement(By.xpath(pb.get_Confirmation())).click();
		 
		 Thread.sleep(2000);
		 driver.findElement(By.xpath(pb.get_Payment())).click();
	//	 Thread.sleep(2000);
	     ss.takeSnapShot(driver, "./Screenshot/Error message.jpg") ;
		 
		String errorMessage=driver.findElement(By.xpath(pb.get_Error())).getText();
		
		
		System.out.println("Error Message :"+errorMessage);
		
		}

}
