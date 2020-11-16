package src;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;


public class MortgageCalculator {


    public static <WebEliment> void main(String[] args) throws InterruptedException, IOException {
        // nest two line to run test in FireFox
    	
    	System.setProperty("webdriver.gecko.driver "," ‪A:\\WebDriver\\geckodriver.exe" );
		WebDriver driver = new FirefoxDriver();

		 JavascriptExecutor js = (JavascriptExecutor) driver; // Import java Script Executor
		 
		 // next two line is for testing in chrome 
		//System.setProperty("webdriver.chrome.driver","G:\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();



    	
        String Website = "https://www.mortgagecalculator.org/";
        int homePrice[]= {253698,45698752,1236547,1236541,12355412,1356987};
        String LoneType[]= {"Conventional","FHA", "VA","USDA","FHA", "VA"};
        String BuyType []= {"Refi","Buy","Refi","Buy","Refi","Buy"};
        double IntRate[]= {3.5,3.9,4.2,4.5,5.0,3.8};
        int DownPay[]= {15,10,18,20,25,22};
        int LoanTerm[]= {20,25,30,35,20,35,30};
        String StartMonth[]= {"Jan","Feb","Aug","Sep","Nov","Dec"};

        
        
        for (int i=0;i<Website.length();i++) {
        	
        driver.get(Website); // to visit an Website
        
        driver.manage().window().maximize();// to maximize the browser
        
        Actions Entry = new Actions(driver);
        WebElement HomePrice = driver.findElement(By.id("homeval"));
        Entry.doubleClick(HomePrice).sendKeys(""+homePrice[i]).build().perform();
        
       //     driver.findElement(By.id("homeval")).sendKeys(""+homePrice[i]);
        driver.findElement(By.id("downpayment")).sendKeys(""+DownPay[i]);
        driver.findElement(By.xpath("/html/body/section/div/form/section/section[2]/div/div/div[1]/div/div/div[4]/div[1]/div[1]/div[2]/span/label[2]/input")).click();
        driver.findElement(By.id("intrstsrate")).sendKeys(""+IntRate[i]);
        driver.findElement(By.id("loanterm")).sendKeys(""+LoanTerm[i]);
        Select dropDown = new Select(driver.findElement(By.name("param[start_month]")));
        dropDown.selectByVisibleText(StartMonth[i]);
        driver.findElement(By.id("pptytax")).sendKeys(""+homePrice[i]*.015+homePrice[i]);
        driver.findElement(By.id("hoi")).sendKeys(""+3560);
        driver.findElement(By.id("hoa")).sendKeys(""+350);
        
        
        Select dropdown1 = new Select (driver.findElement(By.name("param[milserve]")));
        dropdown1.selectByVisibleText(LoneType[i]);
        
        
        
        Select dropdown2 = new Select (driver.findElement(By.name("param[refiorbuy]")));
        dropdown2.selectByVisibleText(BuyType[i]);
        Select dropdown3 = new Select(driver.findElement(By.name("param[credit_rating]")));
        dropdown3.selectByVisibleText("Good (620 - 719)");
        driver.findElement(By.name("cal")).click();
    
        Thread.sleep(8000);
        
       // driver.findElement(By.xpath("/html/body/section/div/form/section/section[2]/div/div/div[1]/div/div/div[4]/div[2]/div/div[1]/div[1]/h3")).getText();
        WebElement Copytext = driver.findElement(By.xpath("/html/body/section/div/form/section/section[2]/div/div/div[1]/div/div/div[4]/div[2]/div/div[1]/div[1]/h3"));
        
        String MonthlyPayment = Copytext.getText();
        System.out.println(i+1 +" " +MonthlyPayment);
        
        
        js.executeScript("window.scrollBy(0,1000)"); //Scroll down by 1000 pixle
        
        /* Scroll Down by the visibility of an Element 
        WebElement Element = driver.findElement(By.xpath("/html/body/section/div/form/section/section[2]/div/div/div[1]/div/div/div[4]/div[2]/div/div[1]/div[1]/h3"));
        js.executeScript("arguments[0].scrollIntoView();", Element);
        */
        
        
        File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); // taking a Screenshot 
        // save the Screenshot in local hard drive
		FileHandler.copy(srcfile,new File ("H:\\Eclipc- Workplace\\ScreenShoot\\CalculatedPrice"+(i+1)+".png"));
		
		
		//File photo = driver.findElement(By.name("cal")).getScreenshotAs(OutputType.FILE);
		//FileHandler.copy (photo, new File("H:\\Eclipc- Workplace\\ScreenShoot\\CalculatedPrice.png"));
        }
        //close Fire fo
        driver.close();
          
    }

}