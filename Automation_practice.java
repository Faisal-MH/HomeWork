import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;


public class Automation_practice {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.chrome.driver" , "‪A:\\WebDriver\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver" , "A:\\WebDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
	
		// input Values 
		String Email = "klgf2@mailed.ro";
		String FirstName = "Crystal";
		String LastName = "Water";
		String Pass = FirstName+LastName+"2020";
		String Address = "1256 Queen St";
		String City = "Java";
		String PostCode = "12009";

		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		 
		  List<WebElement> ImageCount = driver.findElements(By.tagName("img"));
     		System.out.println(ImageCount.size());
     	
     		for (int h=0;h<ImageCount.size();h++) {
     			String Links = ImageCount.get(h).getAttribute("src");
     				System.out.println(Links); 
     		}
     			System.out.println("________________________");
     	
     			List<WebElement> LinkCount = driver.findElements(By.tagName("a"));
     			System.out.println("Total Link on the page is "+LinkCount.size());
     			
     			
     			int count = 0;
     			for (int j=0;j<LinkCount.size();j++) {
     				//System.out.println(LinkCount.get(i).getAttribute("src"));
     				if (LinkCount.get(j).isDisplayed()) {
     					count++;
     					if (LinkCount.get(j).getAttribute("type").trim().equalsIgnoreCase("hidden"));
     							System.out.println("Hidden Link text "+LinkCount.get(j).getText());
     						
     				}
     			}
     						System.out.println("Total Hidden Links on the page is" );
     						System.out.println(LinkCount.size()-count);
      						System.out.println("Total Hidden Links on the page is" );
      						System.out.println(LinkCount.size()-count);

		
		
		try { // Using try catch to avoid stoping the script because of have an account registered with 
			 	// Given email Address.
			
		//Creating a new Account	

		driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
		driver.findElement(By.id("email_create")).sendKeys(Email);
		driver.findElement(By.name("SubmitCreate")).click();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Thread.sleep(4000);
		
		driver.findElement(By.id("id_gender1")).click();
		driver.findElement(By.name("customer_firstname")).sendKeys(FirstName);
		driver.findElement(By.name("customer_lastname")).sendKeys(LastName);
		driver.findElement(By.id("passwd")).sendKeys(Pass);
		
		
		Select day = new Select (driver.findElement(By.id("days")));
		day.selectByValue("15");
		
		Select month = new Select(driver.findElement(By.name("months")));
		month.selectByValue("12");
		
		Select year = new Select(driver.findElement(By.id("years")));
		year.selectByValue("1900");
		
		driver.findElement(By.name("optin")).click();
		driver.findElement(By.name("firstname")).sendKeys(FirstName);
		driver.findElement(By.name("lastname")).sendKeys(LastName);
		driver.findElement(By.name("address1")).sendKeys(Address);
		driver.findElement(By.name("city")).sendKeys(City);
	
		Select State = new Select(driver.findElement(By.id("id_state")));
		State.selectByValue("20");
		
		driver.findElement(By.name("postcode")).sendKeys(PostCode);
		driver.findElement(By.name("phone_mobile")).sendKeys("123654789");
		driver.findElement(By.id("submitAccount")).click();
		
		
		// log out of the recently created account
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")).click();
		}
		catch (Exception s) {
			Exception ErrMsg =  s;
			 System.out.println("An account using this email address has already been registered. If you don't remember your password, you can request for a new one.");
			
		}
		
		// log in to Existing account
		driver.findElement(By.id("email")).sendKeys(Email);
		driver.findElement(By.name("passwd")).sendKeys(Pass);
		driver.findElement(By.id("SubmitLogin")).click();
		
		driver.findElement(By.name("search_query")).sendKeys("Full Sleev");
		driver.findElement(By.name("submit_search")).click();
		
		driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a")).click();
		
		
		try {
		Actions action = new Actions(driver);
		WebElement pic = driver.findElement(By.xpath("//*[@id=\"layered_price_slider\"]/a[2]"));
		action.dragAndDropBy(pic, -150, 0).build().perform();
		
		}
		catch (Exception y) {
			System.out.println("Mouse Action can't Perform"+ y);
		}
		
		
		
		// Taking ScreenShot
		File photo = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(photo, new File("H:\\Eclipc- Workplace\\ScreenShoot\\Search.png"));
		
		
		driver.close();
	}

}

