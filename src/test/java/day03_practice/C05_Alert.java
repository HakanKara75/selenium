package day03_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C05_Alert {
    //http://demo.guru99.com/test/delete_customer.php adresine gidin
    //customer id kısmına 53920 yazın
    //submit butonuna tıklayın
    //cıkan alert mesajını yazdırın
    //alerti kabul edin
    //cıkan 2. alert mesajını yazdırın
    //cıkan 2. alerti kabul edin
    WebDriver driver;
    @Before
    public void setup() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void name() throws InterruptedException {
        Thread.sleep(2000);
        //http://demo.guru99.com/test/delete_customer.php adresine gidin
        driver.get("http://demo.guru99.com/test/delete_customer.php");



        //customer id kısmına 53920 yazın
WebElement customer=driver.findElement(By.xpath("//input[@type='text']"));
customer.sendKeys("53920");
        Thread.sleep(2000);

        //submit butonuna tıklayın
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(2000);

        //cıkan alert mesajını yazdırın
        String message= driver.switchTo().alert().getText();
        System.out.println(message);
        Thread.sleep(2000);

        //alerti kabul edin
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        //cıkan 2. alert mesajını yazdırın
        String alertMessage= driver.switchTo().alert().getText();
        System.out.println(alertMessage);
        Thread.sleep(2000);

        //cıkan 2. alerti kabul edin
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
    }
}
