package day01_practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class C02 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/resorcues/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));

        // Pencereyi maximize yapiniz
        driver.manage().window().maximize();

        // "https://teknosa.com/" adresine gidiniz
        driver.get("https://teknosa.com/");
        Thread.sleep(2000);

        // Sayfanin Title'ini ve URL'ini aliniz ve yazdiriniz
        String teknosaTitle = driver.getTitle();
        System.out.println("Teknosa title: " + teknosaTitle);
        String teknosaUrl = driver.getCurrentUrl();
        System.out.println(teknosaUrl);

        // Title'in "Teknoloji" kelimesini icerip icermedigini kontrol ediniz
        if (teknosaTitle.contains("Teknoloji"))
            System.out.println("Teknoloji kelimesini iceriyor");
        else
            System.out.println("Teknoloji kelimesini icermiyor");

        // URL'in "teknosa" kelimesini icerip icermedigini kontrol ediniz
        if (teknosaUrl.contains("teknosa"))
            System.out.println("teknosa kelimesini iceriyor");
        else
            System.out.println("teknosa kelimesini icermiyor");

        // "https://medunna.com/" adresine gidiniz
        driver.get("https://medunna.com/");
        Thread.sleep(2000);

        // Sayfanin Title'ini ve URL'ini aliniz ve yazdiriniz
        String medunnaTitle = driver.getTitle();
        System.out.println("Medunna title: " + medunnaTitle);
        String medunnaUrl = driver.getCurrentUrl();
        System.out.println(medunnaUrl);

        // Title'in "MEDUNNA" kelimesini icerip icermedigini kontrol ediniz.
        if (medunnaTitle.contains("MEDUNNA"))
            System.out.println("Title MEDUNNA iceriyor");
        else
            System.out.println("Title MEDUNNA icermiyor");

// URL'in "medunna" kelimesini icerip icermedigini kontrol ediniz
        if (medunnaUrl.contains("medunna"))
        System.out.println("Url medunna iceriyor");
        else
        System.out.println("Url medunna icermiyor");

        // teknosa adresine geri donunuz
        driver.navigate().back();
        Thread.sleep(2000);

        // Sayfayı yenileyiniz
        driver.navigate().refresh();

        // medunna adresine ilerleyiniz
        driver.navigate().forward();

        // Sayfayı yenileyiniz
        driver.navigate().refresh();

        // pencereyi kapat
        driver.close();
    }

}
