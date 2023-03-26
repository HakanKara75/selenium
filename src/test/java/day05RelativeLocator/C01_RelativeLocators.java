package day05RelativeLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class C01_RelativeLocators {
    public static void main(String[] args) {
        /*
RELATIVE LOCATOR
     - Bir web sayfasında benzer özelliklere sahip webelementlerin olduğu durumlarda kullanılabilir
    - above --> Belirtilen elementin üstünde olan elementi seçer
    - below --> Belirtilen elementin altında olan elementi seçer
    - to_left_of --> Belirtilen elementin solunda olan elementi seçer
    - to_right_of --> Belirtilen elementin sağında olan elementi seçer
    - near --> Belirtilen elementin yanında/yakınında olan elementi seçer
 */
        System.setProperty("chromeDriver", "src/source/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //amazon sitesine gidelim
        driver.get("https://amazon.com");

        //city bike aratalim
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@type='text']"));
        aramaKutusu.sendKeys("city bike");
        aramaKutusu.submit();

        //Hybrid Bikes bolumunden locate alalim
        WebElement hybridBike = driver.findElement(By.xpath("//*[text()='Hybrid Bikes']"));

        //Relative Locator kullanarak Hybrid Bikes altindaki web elemente tiklayalim
        WebElement roadBikes= driver.findElement(with(By.tagName("a")).below(hybridBike));
        roadBikes.click();



    }
}
