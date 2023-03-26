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
        Thread.sleep(2000);

        //Delete tusuna basin
        // WebElement del = sec.findElement(By.xpath("//*[@id='elements']/button"));
       WebElement del =driver.findElement(By.cssSelector("button[onclick='deleteElement()']"));
        del.click();
        Thread.sleep(2000);


        //Add/Remove Elements” yazisinin gorunur oldugunu test edin
        WebElement addRemove=driver.findElement(By.cssSelector("h3"));
        System.out.println("Is add/remove button displayed:" +addRemove.isDisplayed());

        driver.close();

    }
    /*
    XPATH SYNTAX;
        //tag_name[@attributeName='atributeDegeri']
       // *[text()='metin ne varsa o buraya gelir']"));


    CSSSELECTOR SYNTAX;
        //tag_name[attributeName='metin ne varsa o buraya gelir'

     RELATIVE XPATH SYNTAX;
     with(By.tagName("buraya atribute degeri gelir")).below(locate aldigimiz xpath degiskeni buraya)


    - Bir web sayfasında benzer özelliklere sahip webelementlerin olduğu durumlarda kullanılabilir
    - above --> Belirtilen elementin üstünde olan elementi seçer
    - below --> Belirtilen elementin altında olan elementi seçer
    - to_left_of --> Belirtilen elementin solunda olan elementi seçer
    - to_right_of --> Belirtilen elementin sağında olan elementi seçer
    - near --> Belirtilen elementin yanında/yakınında olan elementi seçer


 Xpath ve cssSelector arasindaki farklar;
 1)Xpath metin ile calisabilir, cssSelector calisamaz.
 2)Xpath daha fazla kombinasyona sahiptir ve index'e gore arama yapabilir.
 3)cssSelector index'e gore arama yapamaz ancak daha hizli calisir.
 */
}
