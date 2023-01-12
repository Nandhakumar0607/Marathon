package marathon2;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.sukgu.Shadow;

public class ServiceNowOrderingMobile {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://dev144491.service-now.com/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("Banu@2812");
		driver.findElement(By.id("sysverb_login")).click();
		Thread.sleep(9000);
		Shadow dom = new Shadow(driver);
		dom.findElementByXPath("//div[text()='All']").click();
		dom.findElementByXPath("//input[@id='filter']").sendKeys("Service Catalog");
		Thread.sleep(5000);
		dom.findElementByXPath("//mark[text()='Service Catalog']").click();
		Thread.sleep(5000);
		WebElement frame = dom.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frame);
		WebElement Mobiles = driver.findElement(By.xpath("//img[@alt='Mobiles']"));
		driver.executeScript("arguments[0].click();",Mobiles);
		driver.findElement(By.xpath("(//img[@alt='Request for Apple iPhone 13'])[2]")).click();
		driver.findElement(By.xpath("(//label[@class='radio-label'])[2]")).click();
		driver.findElement(By.xpath("(//label[text()='Blue'])")).click();
		WebElement dd1 = driver.findElement(By.xpath("//select[@name='IO:33494b069747011021983d1e6253af45']"));
		Select s = new Select(dd1);
		s.selectByValue("Unlimited");
		driver.findElement(By.xpath("//button[@name='oi_order_now_button']")).click();
		String RequestNum = driver.findElement(By.xpath("//a[@id='requesturl']")).getText();
		System.out.println("The Request Number id is: " +RequestNum);
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
        File dest = new File("./snap/ServicenowOrder.jpg");
        FileUtils.copyFile(screenshotAs, dest);
        driver.quit();
	}

}
