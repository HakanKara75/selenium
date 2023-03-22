package day01_practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class C04 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/resorcues/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        // https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

        // Kaynak Kodlarini konsola yazdiriniz
        String kaynakKodu = driver.getPageSource();
        System.out.println(kaynakKodu);

        // Kaynak Kodlarinda "Gateway" yazdigini test edin
        if (kaynakKodu.contains("Gateway"))
            System.out.println("Kaynak kodalarinda Gateway yaziyor");
        else
            System.out.println("Kaynak kodalarinda Gateway yazmiyor");

        // sayfayi kapatiniz
        driver.close();


    }
}
