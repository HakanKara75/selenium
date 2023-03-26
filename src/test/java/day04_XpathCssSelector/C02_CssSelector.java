package day04_XpathCssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C02_CssSelector {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("chromeDriver", "src/source/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        Thread.sleep(3000);
        // 2- Add Element butonuna basin
        //tag_name[@attributeName='atributeDegeri']

//xpath== >   //WebElement sec=driver.findElement(By.xpath("//*[@id='content']/div/button")).click();
//css== >    //WebElement sec=driver.findElement(By.cssSelector("button[onclick='addElement()']"));

        WebElement sec = driver.findElement(By.xpath("//button[text()='Add Element']"));
        sec.click();
        //Delete butonu’nun gorunur oldugunu test edin
        System.out.println("Is delete button displayed:" +sec.isDisplayed());

        //Delete tusuna basin
        WebElement del = sec.findElement(By.xpath("//*[@id='elements']/button"));
        //WebElement del =driver.findElement(By.cssSelector("button[class='added-manually']"));
        del.click();
        Thread.sleep(2000);


        //Add/Remove Elements” yazisinin gorunur oldugunu test edin
        System.out.println("Is add/remove button displayed:" +sec.isDisplayed());

        driver.close();

    }
}
