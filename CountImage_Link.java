import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CountImage_Link {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","A:\\WebDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://www.mortgagecalculator.org/");
		
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
		
	}

}
