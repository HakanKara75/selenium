package day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class C03_Navigate_Method {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resorcues/drivers/MicrosoftEdgeSetupBeta.exe");
        WebDriver driver=new EdgeDriver(); //bos browser acar



        //amazon sayfasina gidelim
           driver.get("https://www.amazon.com"); // gitmek istedigimiz sayfayi acar
      //  driver.navigate().to("https://www.amazon.com"); //bir sayfadan baska sayfaya gecislerde kullanilir.

//techproeducation sayfasina gidelim
        Thread.sleep(3000); //3000 milisaniye bekleyip asagidaki siteyi acar.
        driver.navigate().to("https://www.techproeducation.com");

//amazon sayfasina geri donelim.
        Thread.sleep(3000);
        driver.navigate().back(); //ilk amazonu actigimiz icin back olur

//techproeducation sayfasina tekrar geri gidelim
        Thread.sleep(3000);
        driver.navigate().forward(); // amazondan sonra tech acildigi icin forward olur.

        //sayfa yenileyelim
        driver.navigate().refresh();

        //sayfayi kapatalim
        driver.close();
 }
}

