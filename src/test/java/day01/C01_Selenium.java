package day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class C01_Selenium {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resorcues/drivers/MicrosoftEdgeSetupBeta.exe");
/*
en temel haliyle otomosyon yapmak icin classimiza gerekli olan web driver
yerini belirtiyoruz. java kutuphanesindeki " System.setProperty" methoduyla
driverimizin yolunu belirtiyoruz.
        System.setProperty java uygulamalarında sistem özelliklerini ayarlamak için kullanılır.
         Bu method ile class'mıza web driver'in fiziki yerini belirtiniz.
         Key,value olarak önce isim sonra driver'imizin yolunu belirtiriz.
       getProperty methodu ile "Key değerini girerek "value"'ya ulaşabilirim
         */
     //   System.setProperty("webdriver.http.factory", "jdk-http-client");
       // WebDriver driver=new GoogleDriver();
WebDriver driver=new EdgeDriver();  //WebDriver google, ie, edge, opera vs. üst klasidir. Daha fazla metot icin bunu yaptik.
        driver.get("https://www.google.com");

    }
}
