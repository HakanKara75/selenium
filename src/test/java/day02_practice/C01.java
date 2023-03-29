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

public class C01 {
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
    public void test01() {
        // https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

        // arama kutusunun, tagName'inin 'input' oldugunu test ediniz
        WebElement arama = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        String actualTagName = arama.getTagName();
        String expectedTagName="input";
        if (expectedTagName.equals(actualTagName))
            System.out.println("TagName input");
        else
            System.out.println("TagName input degil");

        // arama kutusunun, name attribute'nun degerinin 'field-keywords' oldugunu test edin
        String actualAtribute=arama.getAttribute("name");
        String expectedAtribute="field-keywords";
        if (expectedAtribute.equals(actualAtribute))
            System.out.println("name field-keywords");
        else
            System.out.println("name field-keywords degil");


    }
}
