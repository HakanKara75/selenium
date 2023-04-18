package day05_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

// 'https://the-internet.herokuapp.com/download' adresine gidiniz
// some-file.txt dosyasini indirelim
// dosyanin bilgisayarınızda Downloads(indirilenler)'a basariyla indirilip indirilmedigini test ediniz
public class C03 extends TestBase {

    @Test
    public void test() throws InterruptedException {
        // 'https://the-internet.herokuapp.com/download' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/download");

        // some-file.txt dosyasini indirelim
        driver.findElement(By.xpath("//a[@href='download/some-file.txt']")).click();
        Thread.sleep(2000);

          /*
        Dosyanın, bilgisayarımda downloads'a basrıyla indirilip indirilmedigini Java ile test edecegim.
        Cunku seleniumi web sayfasını test eder. Selenium, bunim bilgisayarımdaki downloads'a mudahale edemez.
         */

        // dosyanin bilgisayarınızda Downloads(indirilenler)'a basariyla indirilip indirilmedigini test ediniz
        //C:\Users\Hakan Batirhan.DESKTOP-KA8SOKR\Downloads\some-file.txt
        String farkliKisim= System.getProperty("user.home");
        String ortakKisim = "\\Desktop\\some-file.txt";

        String dosyaYolu = farkliKisim+ortakKisim;
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

  }
}


