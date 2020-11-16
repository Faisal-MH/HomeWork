import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Q3_AmazonWebsite {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver" , "A:\\WebDriver\\chromedriver.exe");
		
		//System.setProperty("webdriver.gecko.driver "," ‪A:\\WebDriver\\geckodriver.exe" );
		
		//WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		
		String productList[] ={"Water bottle", "pocket knife", "Galaxy S 10+ case","Galaxy S 10+ Screen Protector"};
		String Website = "https://www.amazon.com/";
		
		for (int i = 0;i<productList.length;i++) {
	
			driver.get(Website);
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys(productList[i]);
			driver.findElement(By.className("nav-input")).click();
			Thread.sleep(5000);
		
			}
		driver.close();
			
			
				

		
	}
}
