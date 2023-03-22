package day01_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class C03 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/resorcues/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();

// "https://testpages.herokuapp.com/styled/calculator" adresine gidin
        driver.get("https://testpages.herokuapp.com/styled/calculator");

// ilk kutucuga 20 giriniz
        WebElement ilkKutu = driver.findElement(By.id("number1"));
        ilkKutu.sendKeys("20");
        Thread.sleep(2000);

        // ikinci kutucuga 30 giriniz
        WebElement ikinciKutu = driver.findElement(By.id("number2"));
        ikinciKutu.sendKeys("30");
        Thread.sleep(2000);

// calculate'e tıklayınız
        WebElement calculateKutusu = driver.findElement(By.id("calculate"));
        calculateKutusu.click();

        // sonucu yazdırınız
        WebElement sonuc = driver.findElement(By.id("answer"));
        System.out.println("Islemin sonucu: " + sonuc.getText());
        // sayfayi kapatiniz
        driver.close();
    }
}
