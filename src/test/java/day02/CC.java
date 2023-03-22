package day02;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.security.Key;
import java.time.Duration;

public class CC {
    public static void main(String[] args) throws InterruptedException {
//        Browser'ı açıp maximize yapın
        System.setProperty("webdriver.google.driver", "src/resorcues/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
// Tüm sayfa için maksimum bekleme süresi olarak 15 saniye belirleyin
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//Sırasıyla Amazon, Facebook ve Youtube sayfalarına gidin


//        driver.navigate().to("https://www.Youtube.com");
//        WebElement ytb =driver.findElement(By.name("search_query"));
//        Thread.sleep(3000);
//        ytb.sendKeys("Simge - Aşkın Olayım");
//        ytb.submit();
//        Thread.sleep(3000);
//        WebElement videoLink = driver.findElement(By.cssSelector("#video-title"));
//        videoLink.click();

        driver.navigate().to("https://www.amazon.com");
        WebElement atb =driver.findElement(By.id("twotabsearchtextbox"));
        Thread.sleep(3000);

        atb.sendKeys("Beats Fit Pro - True Wireless Noise Cancelling Earbuds - Apple H1 Headphone Chip, Compatible with Apple & Android, Class 1 Bluetooth®, Built-in Microphone, 6 Hours of Listening Time – Beats Black");
        atb.submit();
        Thread.sleep(3000);
       WebElement link = driver.findElement(By.cssSelector("a-popover-sp-info-popover-B09WMJCQRM"));
       link.click();
      driver.close();
        /*

Amazon sayfasına geri dönün
Amazon sayfasının adresinin(Url) https://www.amazon.com/ adresine eşit olduğunu test edin
Sayfanın konumunu ve boyutunu yazdırın
Sayfanın konumunu ve boyutunu istediğimiz şekilde ayarlıyın
İstediğiniz şekilde olup olmadığını test edin
Sayfayı kapatın

 */




    }
}
