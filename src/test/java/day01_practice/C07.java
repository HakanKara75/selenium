package day01_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class C07 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/resorcues/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); //site 15 saniyede yuklenmezse hata verecek

        // https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

        // arama motorunda nutella yazip aratınız
        WebElement aramaMotoru= driver.findElement(By.id("twotabsearchtextbox"));
        aramaMotoru.sendKeys("nutella"+ Keys.ENTER);
        //2.yol
        //driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nutella"+ Keys.ENTER);

        // sayfada kac tane link oldugunu bulunur
               List<WebElement> list= driver.findElements(By.tagName("a")); //linklerin tag'i a dir.
        System.out.println(list.size());

        // linkleri yazdiriniz
        int sayi=1;
        for (WebElement each:list) {
            System.out.println(sayi+". link: "+each.getText());
            sayi++;
        }


        // pencereyi kapatiniz
        driver.close();
    }
}
