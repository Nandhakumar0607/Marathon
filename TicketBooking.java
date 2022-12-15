package marathon1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TicketBooking {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.redbus.in/");
		driver.findElement(By.xpath("(//input[@class='db'])[1]")).sendKeys("Chennai");
		driver.findElement(By.xpath("//li[@data-id='123']")).click();
		driver.findElement(By.xpath("(//input[@class='db'])[2]")).sendKeys("Bangalore");
		driver.findElement(By.xpath("//li[@data-id='122']")).click();
		driver.findElement(By.xpath("//span[@class=\"fl icon-calendar_icon-new icon-onward-calendar icon\"]")).click();
		driver.findElement(By.xpath("//td[@class='current day']")).click();
		driver.findElement(By.xpath("//button[@id='search_btn']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//i[@class='icon icon-close']")).click();
		String BusCount = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
		System.out.println("The Bus Count is : " +BusCount);
		Thread.sleep(10000);
		
		WebElement sleeper = driver.findElement(By.xpath("//label[@for='bt_SLEEPER']"));
//		Java Command for Click
		driver.executeScript("arguments[0].click();",sleeper);
		
		String BusName = driver.findElement(By.xpath("(//div[@Class='travels lh-24 f-bold d-color'])[2]")).getText();
		System.out.println("The Name of the Bus is :" +BusName);
		driver.findElement(By.xpath("(//div[@Class='button view-seats fr'])[2]")).click();
	
		
		
		

	}

}
