package day03;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class C01_ClassWork {
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

//   Arama sonuç metnini yazdırın
        List<WebElement> aramaSonucu = driver.findElements(By.className("sg-col-inner"));
        System.out.println(aramaSonucu.get(0).getText());
//   Sonuç sayısını yazdırın
        String []sonucSayisi=aramaSonucu.get(0).getText().split(" ");
        System.out.println(sonucSayisi);

//   Sonuc sayısını LAMBDA ile yazdırın
        Arrays.stream(aramaSonucu.get(0).getText().split(" ")).skip(2).limit(1).
                forEach(System.out::println);
//   Çıkan ilk sonucun resmine tıklayın.
List<WebElement> urunResimleri=driver.findElements(By.className("s-image"));
urunResimleri.get(0).click();

//   Sayfayı kapatın
        //driver.quit();
    }
}
