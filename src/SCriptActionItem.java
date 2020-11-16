package src;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SCriptActionItem {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "A:\\WebDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		String[] city = {"Dhaka","Toronto","Ottawa"};
		Actions click1 = new Actions(driver);
		driver.get("https://www.timeanddate.com/worldclock/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		for (int i= 0;i<=city.length;i++) {
					
			click1.doubleClick(driver.findElement(By.xpath("//input[@id='sb_wc_q']"))).sendKeys(city[i]).perform();
			
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"po1\"]"))));
			WebElement CityLink = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/ul/li[1]/a"));
			CityLink.click();
			String Time = driver.findElement(By.xpath("//span[@id='ct']")).getText();
			String date = driver.findElement(By.xpath("//span[@id='ctdat']")).getText();
			System.out.println(Time);
			System.out.println(date);
			driver.navigate().back();
			Thread.sleep(3000);
		}
		
			
		
	
		
		
		
	}

}
