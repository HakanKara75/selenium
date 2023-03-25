package day04_XpathCssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C02_CssSelector {
    public static void main(String[] args) {
        System.setProperty("chromeDriver", "src/source/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
       // 2- Add Element butonuna basin
        WebElement sec= driver.findElement(By.cssSelector("input[onclick='addElement()']"));
        sec.click();
        driver.close();
        /*
Delete butonu’nun gorunur oldugunu test edin
Delete tusuna basin
“Add/Remove Elements” yazisinin gorunur oldugunu test edin
         */








    }
}
