package hackathon.team3;
import java.io.FileInputStream;

import java.util.Properties;
public class Property_bookshelf {
	
	static Properties pro;
	public void properties() throws Exception 
	{
	
		pro = new Properties();
		//creating object of FileInputStream class to extract the XPath properties
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "//Property_Class.properties");
		pro.load(file);
	}
	

	public String URL()
	{
		return pro.getProperty("websiteURL");
	}
	
	public String chrome_Driver()
	{
		return pro.getProperty("getChromeDriver");
	}
	
	public String get_Popup()
	{
		return pro.getProperty("popup");
		
	}

	public String get_Search()
	{
		return pro.getProperty("search");
	}
	

	public String get_Submit()
	{
		return pro.getProperty("submit");
	}
	
	public String get_Category()
	{
		return pro.getProperty("category");
	}
	
	public String get_Price()
	{
		return pro.getProperty("price");
		
	}
	
	public String get_Storagetype()
	{
		return pro.getProperty("storage");
	}
	
	
	public String get_Storage_select()
	{
		return pro.getProperty("storage_select");
	}
	public String get_Category_select()
	{
		return pro.getProperty("category_select");
	}
	public String get_Price_select()
	{
		return pro.getProperty("price_select");
	}
	
	public String get_Exclude_outofstock()
	{
		return pro.getProperty("outofstock");
	}

	public String gecko_Driver() 
	{
		return pro.getProperty("getGeckoDriver");
	}
	
	public String get_Collections() 
	{
		return pro.getProperty("collections");
	}
	
	public String get_CollectionList() 
	{
		return pro.getProperty("collectionList");
	}
	
	public String get_GiftCards() 
	{
		return pro.getProperty("giftCards");
	}
	public String get_Occassion() 
	{
		return pro.getProperty("ocassion");
	}
	public String get_Amount() 
	{
		return pro.getProperty("amount");
	}
	public String get_Date() 
	{
		return pro.getProperty("date");
	}
	public String get_Next() 
	{
		return pro.getProperty("next");
	}
	public String get_RecipientName() 
	{
		return pro.getProperty("recipientName");
	}
	public String get_RecipientEmail() 
	{
		return pro.getProperty("recipientEmail");
	}
	public String get_Custname() 
	{
		return pro.getProperty("customerName");
	}
	public String get_Custemail() 
	{
		return pro.getProperty("customerEmail");
	}
	public String get_Mobile() 
	{
		return pro.getProperty("mobileNum");
	}
	public String get_Msg() 
	{
		return pro.getProperty("msg");
	}
	public String get_Confirmation() 
	{
		return pro.getProperty("confirm");
	}
	public String get_Payment() 
	{
		return pro.getProperty("payment");
	}
	public String get_Error() 
	{
		return pro.getProperty("error");
	}
}
