package day02;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class C02_WebElement_Locators {
    public static void main(String[] args) {
        System.setProperty("webdriver.google.driver","src/resorcues/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//   Amazon sayfasına gidin
        driver.get("https://www.amazon.com");

        //Search kutusunu locate edin
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));

        // Search kutusunda iphone aratın
aramaKutusu.sendKeys("iphone"+ Keys.ENTER);

//Sayfadaki <input> ve <a> tag'larinin sayısını yazdırın
List<WebElement> inputList=driver.findElements(By.tagName("input")); //input lari sayacak
        System.out.println("input tag sayisi: "+inputList.size());

        List<WebElement> aTagList=driver.findElements(By.tagName("a")); //anchor lari bulacak <a tag leri
        System.out.println(aTagList);


//Sayfadaki <input> ve <a> tag'larinin sayısını yazdırın
//driver.close();
    }
}
