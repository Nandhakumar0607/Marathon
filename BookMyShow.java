package marathon1;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BookMyShow {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://in.bookmyshow.com/");
		driver.findElement(By.xpath("(//span[@Class='sc-dRCTWM JQbba'])[4]")).click();
		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.contains("hyderabad"))
		{
			System.out.println("Bwloe are the theaters of Hyderabad");
		}
		else
		{
			System.out.println("Hyderbad URL is not loaded");
		}
		driver.findElement(By.xpath("//img[@alt='Avatar: The Way of Water']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@class='sc-1vmod7e-2 iBonLL']")).click();
		driver.findElement(By.xpath("(//div[@class='sc-vhz3gb-3 dRokFO'])[8]")).click();
		Thread.sleep(5000);
		String NameOfTheater = driver.findElement(By.xpath("//a[@class='__venue-name']")).getText();
		System.out.println("The Name of Theater is :" +NameOfTheater );
		driver.findElement(By.xpath("//img[@class='venue-info-icon lazy']")).click();
		String Facility = driver.findElement(By.xpath("(//div[@class='facility-text'])[5]")).getText();
		if(Facility.contains("Parking"))
		{
			System.out.println("The Theater is having Parking");
		}
		else
		{
			System.out.println("The Theater is having Parking");
		}
		driver.findElement(By.xpath("//div[@class='cross-container']")).click();
		driver.findElement(By.xpath("(//a[@class='showtime-pill'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='btnPopupAccept']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@id='pop_1']")).click();
		driver.findElement(By.xpath("//div[@id='proceed-Qty']")).click();
		driver.findElement(By.xpath("(//a[@class='_available'])[24]")).click();
		driver.findElement(By.xpath("//a[@class='bar-btn _primary']")).click();
		Thread.sleep(2000);
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
        File dest = new File("./snap/bookMyShow.jpg");
        FileUtils.copyFile(screenshotAs, dest);
        String SubTotal = driver.findElement(By.xpath("//span[@class='__sub-total']")).getText();
        System.out.println("The Total amount is" + SubTotal);
		
	}

}
