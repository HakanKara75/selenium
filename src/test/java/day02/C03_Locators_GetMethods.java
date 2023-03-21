package day02;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C03_Locators_GetMethods {
    public static void main(String[] args) {
        System.setProperty("webdriver.google.driver", "src/resorcues/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//Amazon sayfasına gidin
        driver.get("https://www.amazon.com");

//Search bölümünü locate edip, "Tablet" aratalım
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
aramaKutusu.sendKeys("Tablet"+ Keys.ENTER);
aramaKutusu.submit(); //enter a bas

        //Arama sonuç yazısında Tablet yazısını locate edip konsola yazdırın
WebElement aramaSonucu=driver.findElement(By.className("sg-col-inner"));
        System.out.println("Arama sonucu: "+aramaSonucu.getText()); //getText olmazsa hash kodu yazilir

//Sayfayı kapatın
driver.close();

    }
}
