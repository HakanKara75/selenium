package day03_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class C02_DropDownOptions {
    // https://www.amazon.com/ sayfasina gidin
    // dropdown'dan "Baby" secenegini secin
    // sectiginiz option'i yazdirin
    // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin
    // dropdown'daki optionların tamamını yazdırın
    WebDriver driver;

    @Before
    public void setup() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void test() {
        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/");

        // dropdown'dan "Baby" secenegini secin
        //DropDown 3 adımda handle edilir
        //1-)DropDown Locate Edilmelidir
        WebElement dropDown = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        //2-)Select Objesi Olusturulur
        Select select = new Select(dropDown);

        //3-)Opsiyonlardan Bir Tanesi Secilir
        select.selectByVisibleText("Baby");

        // sectiginiz option'i yazdirin
        String secilenOpsiyon= select.getFirstSelectedOption().getText();
        System.out.println(secilenOpsiyon);

        // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin
      List<WebElement> options= select.getOptions();
      assertTrue(options.size()==28);

      //2.yol
        int expectedOptionSayisi = 28;
        int actuelOptionSayisi = options.size();
        Assert.assertEquals(expectedOptionSayisi,actuelOptionSayisi);

        // dropdown'daki optionların tamamını yazdırın
       int sayac=1;
        for (WebElement w:options){
            System.out.println(sayac+ ". option: "+w.getText());
            sayac++;
        }
        //2.yol
        options.forEach(t-> System.out.println(t.getText()));

    }
}
