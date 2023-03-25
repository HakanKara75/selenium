package day04_XpathCssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C01_Xpath {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("chromeDriver", "src/source/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //   https://www.amazon.com/ sayfasına gidin.
        driver.get("https://www.amazon.com");

        //   “city bike” araması yapın
        //XPATH SYNTAX;
        //tag_name[@attributeName='atributeDegeri']
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@type='text']"));
        aramaKutusu.sendKeys("city bike");
        aramaKutusu.submit();
/* sitedeki tag:
<input type="text" id="twotabsearchtextbox" value="" name="field-keywords" autocomplete="off" placeholder="Search Amazon"
class="nav-input nav-progressive-attribute" dir="auto" tabindex="0" aria-label="Search Amazon" spellcheck="false">
 */
        //"Hybrid Bikes" bolumunu tiklayin
        //sitedeki tag: <span class="a-size-base a-color-base">Hybrid Bikes</span>

        WebElement aramaKutusu1 = driver.findElement(By.xpath("(//span[@class='a-size-base a-color-base'])[10]"));
        aramaKutusu1.click();

        //text var ise xpath alma
        //attribute arasinda text varsa "Hybrid Bikes" gibi onunla xpath alinir.
        WebElement hybridBike = driver.findElement(By.xpath("//*[text()='Hybrid Bikes']"));

        //"Hybrid Bikes" bolumunun gorunur, erisilebilir ve secilebilir olup olmadigini test edin
        System.out.println(hybridBike.isDisplayed());//WebElement goruntuleniyor mu TRUE
        System.out.println(hybridBike.isEnabled()); //WebElement erisilebiliyor mu  TRUE
        System.out.println(hybridBike.isSelected()); //WebElement secilebiliyor mu  FALSE (check box gibi secilen nesne degil)
        hybridBike.click();

        //sonuc sayisini yazdirin
        // WebElement sonucSayisi=driver.findElement(By.xpath("//*[text()='15 results for']"));
        WebElement sonucSayisi = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small'][1]"));
        /* yukaridaki [1] sayfada ctrl+f yapip ''icindeki metni aratiriz. aranan metin istenen yeri mavi yaptigi
        yani sectigi an kacinci sonuc olduguna bakariz oradan gelir.

         */
        String[] sonuc = sonucSayisi.getText().split(" ");
        System.out.println(sonuc[0]); //metni parcaladigindan 15 verir


        //sayfada cikan ilk resme tiklayin
        driver.findElement(By.xpath("(//*[@class='a-link-normal s-no-outline'])[1]")).click();


        //  driver.findElement(By.xpath("//span[@class= 'Under $200'] ")); //attribute kullanarak
        driver.close();


    }
}
