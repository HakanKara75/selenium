package day02;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.time.Duration;

public class C01_Examples {

public static void main(String[] args) {
//    Browser'ı açıp maximize yapın
    System.setProperty("webdriver.google.driver","src/resorcues/drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));

    driver.manage().window().maximize();
//Tüm sayfa için maksimum bekleme süresi olarak 5 saniye belirleyin
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); /* saniye cinsinden bekleme suresi
   sayfa yuklenemiyorsa bekleme suresidir. daha erken acilirsa acar, beklmez. bekleme suresi bitiminde hala
    acilmadiysa exception atar */

 //   Sırasıyla Amazon, Facebook ve Youtube sayfalarına gidin

    driver.get("https://www.amazon.com");
    driver.get("https://www.facebook.com");
    driver.get("https://www.youtube.com");

// Amazon sayfasına geri donun
driver.navigate().back(); //facebook a doner
driver.navigate().back(); //amazona doner

//Amazon sayfasının adresinin(Url) https://www.amazon.com/ adresine eşit olduğunu test edin
String actualtUrl= driver.getCurrentUrl();  //asil url
String expectedUrl= "https://www.amazon.com/";  //beklenen url

if (actualtUrl.equals(expectedUrl)){
    System.out.println("URL Testi PASSED");
}else {
    System.out.println("URL Testi FAILED");
}

//Sayfanın konumunu ve boyutunu yazdırın
    System.out.println(driver.manage().window().getPosition());     //sayfa konumu
    System.out.println(driver.manage().window().getSize()); //sayfa boyutu
//Sayfanın konumunu ve boyutunu istediğimiz şekilde ayarlıyın
driver.manage().window().setPosition(new Point(50,50)); //point objesi onceden olusturulup eklenebilirdi, asagidaki gibi
    Dimension dim= new Dimension(600, 600);
    driver.manage().window().setSize(dim);
//İstediğiniz şekilde olup olmadığını test edin
    Point actualPosition=driver.manage().window().getPosition(); /*konum bilgilerini getposition metodu ile
    bir point containeri icine koyduk*/

    if (actualPosition.getX() == 50 && actualPosition.getY()==50)
        System.out.println("Konum testi PASSED");
        else
        System.out.println("Konum testi FAILED");


     Dimension actualDimension=driver.manage().window().getSize(); //dimension data tipi ile en boy aliniyor.
    if (actualDimension.getWidth()==600 && actualDimension.getHeight()==600)
    System.out.println("Konum testi PASSED");
        else
    System.out.println("Konum testi FAILED");

 //   Sayfayı kapatın
 driver.close();

}
}
