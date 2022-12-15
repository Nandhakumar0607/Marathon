package marathon1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForce {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://login.salesforce.com");
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Testleaf$321");
		driver.findElement(By.xpath("//*[@id=\"Login\"]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//p[@class='slds-truncate'])[7]")).click();
		Thread.sleep(8000);
		WebElement Oppertunities = driver.findElement(By.xpath("(//a[@class='slds-context-bar__label-action dndItem'])[2]"));
		driver.executeScript("arguments[0].click();",Oppertunities);
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[@title='New']")).click();
		driver.findElement(By.xpath("(//input[@class='slds-input'])[4]")).sendKeys("SalesForce Automation Nandhakumar");
		driver.findElement(By.xpath("(//input[@class='slds-input'])[4]")).getText();
		driver.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys("12/14/2022");
		Thread.sleep(3000);
		WebElement Stage = driver.findElement(By.xpath("//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value']"));
		Thread.sleep(3000);
		driver.executeScript("arguments[0].click();",Stage);
		driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		String text2 = driver.findElement(By.xpath("//lightning-formatted-text[@slot='primaryField']")).getText();
		if(text2.equals("SalesForce Automation Nandhakumar"))
		{
			System.out.println("The Both Fiedls has Same value");
		}
		else
		{
			System.out.println("The Both Fields dosent have same value");
		}


	}

}
