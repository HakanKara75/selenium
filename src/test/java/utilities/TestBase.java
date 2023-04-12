package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public abstract class TestBase {
        //TestBase class'indan obje olusturmanin onune gecilmesi icin abstract yapilabilir
//Orn: TestBase base=new TestBase();
//Bu class'a extend ettigimiz test classlarinda ulasabiliriz.
        protected static WebDriver driver;
        @Before
        public void setUp() throws Exception {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        @After
        public void tearDown() throws Exception {
            Thread.sleep(3000);
            driver.quit();
        }

        //hard wait method
        public static void bekle(int saniye) {
            try {
                Thread.sleep(saniye*1000);
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }

        //Allert accept
        public static void alertAccept(){
            driver.switchTo().alert().accept();
        }

        //Allert dismiss
        public static void alertDismiss(){
            driver.switchTo().alert().dismiss();
        }
        //Allert text
        public static void alertGetText(){
            driver.switchTo().alert().getText();
        }

        //Allert promptBox
        public static void alertPromtBox(String text){
            driver.switchTo().alert().sendKeys(text);
        }

        //Dropdown menu
        public static void ddmVisibleText(WebElement ddm, String secenek){
            Select select=new Select(ddm);
            select.selectByVisibleText(secenek);
        }

        //Dropdown index
        public static void ddmIndex(WebElement ddm, int index){
            Select select=new Select(ddm);
            select.selectByIndex(index);
        }

        //Dropdown value
        public static void ddmValue(WebElement ddm, String secenek){
            Select select=new Select(ddm);
            select.selectByValue(secenek);
        }

        //SwitchTo: Sayfalar arası geçiş methodu:
        //Indeks 0'dan başlar
        //Girilen indeksteki windowHandle değerini alarak o sayfaya geçiş yapar.
        public static void switchTab(int sayfaIndeksi){
            List<String> windowHandleList= new ArrayList<>(driver.getWindowHandles());
            bekle(3);
            driver.switchTo().window(windowHandleList.get(sayfaIndeksi));
        }


    }
