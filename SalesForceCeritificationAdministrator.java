package marathon2;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class SalesForceCeritificationAdministrator {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://login.salesforce.com");
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Testleaf$321");
		driver.findElement(By.xpath("//*[@id=\"Login\"]")).click();
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		String MainWindow = driver.getWindowHandle();
		Set<String> FromWindow = driver.getWindowHandles();
		List<String> Fromlistofhandle = new ArrayList<String>(FromWindow);
		String FromSecondWindow = Fromlistofhandle.get(1);
		driver.switchTo().window(FromSecondWindow);
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		Shadow dom=new Shadow(driver);
		dom.findElementByXPath("//span[text()='Learning']").click();
	    WebElement Trialhead = dom.findElementByXPath("//span[text()='Learning on Trailhead']");
	    Actions action = new Actions(driver);
	    action.moveToElement(Trialhead).perform();
	    
	    
        Thread.sleep(5000);
        
        WebElement Salesforce = dom.findElementByXPath("//a[text()='Salesforce Certification']");
        driver.executeScript("arguments[0].click();", Salesforce);
        driver.findElement(By.xpath("//a[text()='Administrator']")).click();
        
        
        String title = driver.getTitle();
        if
        (title.contains("Administrator"))
        {
        	System.out.println("It is there");
        }

        List<WebElement> certificate = driver.findElements(By.xpath("//div[@class='credentials-card_title']"));
        for (int i = 0; i <=3 ; i++) {
			System.out.println(certificate.get(i).getText());
		}
        
        
        WebElement scrollTO = driver.findElement(By.xpath("//a[text()='Security Specialist Superbadge']"));
        action.scrollToElement(scrollTO).perform();
        
        
        File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File obj=new File("./snap/Salesforcecertificates.jpg");
		FileUtils.copyFile(screenshotAs, obj);
		driver.quit();

	        
	}

}
