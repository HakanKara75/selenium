package day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class C02_DriverMethods {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resorcues/drivers/MicrosoftEdgeSetupBeta.exe");
        WebDriver driver=new EdgeDriver(); //bos browser acar
        driver.get("https://www.google.com"); // gitmek istedigimiz sayfayi acar
        System.out.println("Sayfa basligi: "+driver.getTitle()); //Google
        System.out.println("URL adresi: "+ driver.getCurrentUrl()); //https://www.google.com/
        driver.getPageSource();
        System.out.println(driver.getWindowHandle()); //sayfanin hash degeri 6F576EBEAC187ADCBFA35DB1B572ACB2
//sayfalar arasi hash degeri ile gecis saglar.



    }
}
