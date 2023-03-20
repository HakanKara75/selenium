package day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class C04_Manage_Method {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resorcues/drivers/MicrosoftEdgeSetupBeta.exe");
        WebDriver driver=new EdgeDriver(); //bos browser acar

//techproeducation sayfasina gidelim
        driver.get("https://www.techproeducation.com");

//sayfanin konumu ve boyutlarini yazdirin
 System.out.println("sayfanin konumu: "+driver.manage().window().getPosition()); //sayfanin konumu: (9, 9)
 System.out.println(driver.manage().window().getSize()); //(1051, 805)

 //sayfayi minimize yapalim
        Thread.sleep(2000);
   driver.manage().window().minimize();

        //sayfayi maximize yapalim
        Thread.sleep(2000);
        driver.manage().window().maximize();
        System.out.println("sayfanin konumu: "+driver.manage().window().getPosition()); //sayfanin konumu: (-8, -8)
        System.out.println(driver.manage().window().getSize()); //(1552, 840)

//sayfayi full screen yapalim
driver.manage().window().fullscreen();
        System.out.println("sayfanin konumu: "+driver.manage().window().getPosition()); //sayfanin konumu: (0, 0)
        System.out.println(driver.manage().window().getSize()); //(1536, 864)


        Thread.sleep(2000);// milisaniye bekle
        driver.close(); //kapat
    }
}
