import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class Mortgage_MouseAction {

	public static void main(String[] args) throws IOException, InterruptedException  {
		// TODO Auto-generated method stub
		File drive = new File("A:\\WebDriver\\geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", drive.getAbsolutePath());
		WebDriver driver = new FirefoxDriver();
		JavascriptExecutor Scroll = (JavascriptExecutor)driver;

				String Website = "https://www.mortgagecalculator.org/";
				int homePrice[]= {459862,398625,350000,506325,650000,664523};
				String LoneType[]= {"Conventional","FHA", "VA","USDA","FHA", "VA"};
				String BuyType []= {"Refi","Buy","Refi","Buy","Refi","Buy"};
				double IntRate[]= {3.5,3.9,4.2,4.5,5.0,3.8};
				int DownPay[]= {15,10,18,20,25,22};
				int LoanTerm[]= {20,25,30,35,20,35};
				String StartMonth[]= {"Jan","Feb","Aug","Sep","Nov","Dec"};
				String CreditRating[]= {"1","2","3","4","2","3"};
				 String CalculatedPrice = "/html/body/section/div/form/section/section[2]/div/div/div[1]/div/div/div[4]/div[2]/div/div[1]/div[1]/h3";
				       
       
		       
			    driver.get(Website);
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

        for (int i=0;i<homePrice.length;i++) {
        	
				Actions Entry = new Actions(driver);
				WebElement Homeprice = driver.findElement(By.id("homeval"));
				WebElement Downpayment = driver.findElement(By.name("param[downpayment]"));
				WebElement Rate = driver.findElement(By.name("param[interest_rate]"));
				WebElement Term = driver.findElement(By.name("param[term]"));
				WebElement Startyear = driver.findElement(By.name("param[start_year]"));
				WebElement Tax = driver.findElement(By.name("param[property_tax]"));
				WebElement StartDate = driver.findElement(By.name("param[start_month]"));
		
				Entry.doubleClick(Homeprice).sendKeys(""+homePrice[i]).build().perform();
				Entry.doubleClick(Downpayment).sendKeys(""+DownPay[i]).build().perform();
				Entry.doubleClick(Rate).sendKeys(""+IntRate[i]).build().perform();
				Entry.doubleClick(Term).sendKeys(""+LoanTerm[i]).build().perform();
				Entry.doubleClick(Startyear).sendKeys("2021").build().perform();
				Entry.doubleClick(Tax).sendKeys(""+homePrice[i]*.015+homePrice[i]).build().perform();
				Entry.doubleClick(driver.findElement(By.xpath("//*[@id=\"calc\"]/form/section/section[2]/div/div/div[1]/div/div/div[4]/div[1]/div[1]/div[2]/span/label[2]/input"))).build().perform();
				
				Entry.moveToElement(StartDate).perform();
				Select Pick = new Select(StartDate);
				Pick.selectByVisibleText(StartMonth[i]);
		
				// Selecting Loan type Using Mouse Action without creating a Runtime Object
				
				Entry.moveToElement(driver.findElement(By.name("param[milserve]"))).perform();
				Select Pick1 = new Select(driver.findElement(By.name("param[milserve]")));
				Pick1.selectByVisibleText(LoneType[i]);
				
				
				Select Pick2 = new Select(driver.findElement(By.name("param[refiorbuy]")));
				Pick2.selectByVisibleText(BuyType[i]);
				
				Select Pick3 = new Select(driver.findElement(By.name("param[credit_rating]")));
		        Pick3.selectByValue(CreditRating[i]);
		        
		        Entry.doubleClick(driver.findElement(By.name("cal"))).build().perform();
		        
		        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		        
		        Scroll.executeScript("window.scrollBy(0,800)");
		        
		        WebElement MonthlyPayment = driver.findElement(By.xpath(CalculatedPrice));
		        
		        //Scroll.executeScript("arguments[0].scrollIntoView();", MonthlyPayment);
		        
		        String Payment = MonthlyPayment.getText();
		        Thread.sleep(3000);
		        System.out.println((i+1)+" "+Payment);
		        
		        File photo = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		        FileHandler.copy(photo,new File ("H:\\ScreenShoot\\MonthlyPayment"+i+".png"));

		        
        
        } 
		driver.close();
	}

}

