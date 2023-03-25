package day03;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C02_Xpath {
    public static void main(String[] args) {


        System.setProperty("webdriver.google.driver", "src/resorcues/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//acilan tum sayfalar icin tek kod yeter. hepsine bu calisir

        //   https://www.amazon.com/ sayfasına gidin.
        driver.get("https://www.amazon.com");
//   “city bike” araması yapın
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("city bike" + Keys.ENTER);

        //"Under 200" olani tiklayin
        driver.findElement(By.xpath("//span[.= 'Under $200'] ")); //attribute yok ise . koy
      //  driver.findElement(By.xpath("//span[@class= 'Under $200'] ")); //attribute kullanarak
    driver.close();
    }
}