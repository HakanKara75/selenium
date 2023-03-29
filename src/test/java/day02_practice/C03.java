package day02_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C03 {
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
        //- ebay sayfasına gidiniz
        driver.get("https://www.ebay.com");

        // electronics bölümüne tıklayınız
        WebElement elektronics = driver.findElement(By.xpath("(//a[text()='Electronics'])[2]"));
        elektronics.click();
        Thread.sleep(2000);

        //- Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım
        String url=driver.getCurrentUrl();
        System.out.println(url);

        List<WebElement> images = driver.findElements(By.xpath("//img[@width='225' and @height='225']"));
        for (int i = 0; i < images.size(); i++) {
            List<WebElement> mgs = driver.findElements(By.xpath("//img[@width='225' and @height='225']"));
            mgs.get(i).click();
            System.out.println(driver.getTitle());
            driver.navigate().back();
        }
//        for(WebElement w:images){
//            w.click();
//            System.out.println(driver.getTitle());
//            driver.navigate().back();
//        }
    }
}
