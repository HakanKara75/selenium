package day05RelativeLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class C02_RelativeLocators {
    public static void main(String[] args) {
        System.setProperty("chromeDriver", "src/source/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //https://www.diemol.com/selenium-4-demo/relative-locators-demo.html    adresine gidin
       driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");

        //Berlin’i 3 farkli relative locator ile locate edin
        WebElement nyc=driver.findElement(By.id("pid3_thumb"));
        WebElement bayArea=driver.findElement(By.id("pid8_thumb"));
        WebElement berlin= driver.findElement(with(By.tagName("img")).below(nyc).toLeftOf(bayArea));
        berlin.click();

        //Relative locator’larin dogru calistigini test edin
        String actualIdDegeri=berlin.getAttribute("id");
        String expectedIdDegeri= "pid7_thumb";
        if (actualIdDegeri.equals(expectedIdDegeri))
            System.out.println("Test PASSED");
        else
            System.out.println("Test FAILED");

        driver.close();
    }
}
