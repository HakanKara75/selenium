package day02_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02 {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
    // https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

    // sayfa baslıgının "Google" kelimesini icerdigini test edin
        String sayfaBasligi=driver.getTitle();
        if (sayfaBasligi.contains("Google"))
            System.out.println("Title Google kelimesini iceriyor");
        else
            System.out.println("Title Google kelimesini icermiyor");
    Thread.sleep(2000);

    // arama cubuguna "Nutella" yazıp aratın
        driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys("Nutella"+ Keys.ENTER);

    // bulunan sonuc sayısını yazdırın
        WebElement sonuc=driver.findElement(By.xpath("//div[@id='result-stats']"));
        String arr[] = sonuc.getText().split(" ");
        String sonucSayisi = arr[1];
        System.out.println(sonuc);


        // sonuc sayısının 100000000  fazla oldugunu test edin
        String sonucc=sonucSayisi.replaceAll("\\D", "");
        if (Integer.parseInt(sonucc)>100000000)
            System.out.println("Sonuc sayisi 100000000'den buyuk");
        else
            System.out.println("Sonuc sayisi 100000000'den kucuk");

}
}