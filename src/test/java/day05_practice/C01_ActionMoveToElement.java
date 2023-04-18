package day05_practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.Set;

import static org.junit.Assert.assertTrue;

public class C01_ActionMoveToElement extends TestBase {
    /*
        https://amazon.com adresine gidiniz
     sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
     Change country/region butonuna basiniz
     United States dropdown'undan 'Turkey (Türkiye)' seciniz
     Go to website butonuna tiklayiniz
     acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz
     */

    @Test
    public void name() throws InterruptedException {
        // https://amazon.com adresine gidiniz
        driver.get("https://amazon.com");
        String firstPageHandle=driver.getWindowHandle();

        // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
        Actions actions=new Actions(driver);
        WebElement language= driver.findElement(By.xpath("//div[text()='EN']"));
        actions.moveToElement(language).perform();
        Thread.sleep(2000);

        // Change country/region butonuna basiniz
driver.findElement(By.xpath("(//div[text()='Change country/region.'])[1]")).click();

        // United States dropdown'undan 'Turkey (Türkiye)' seciniz
        Thread.sleep(2000);
WebElement unitedStates= driver.findElement(By.xpath("//select[@id='icp-dropdown']"));

        Select select=new Select(unitedStates);
        select.selectByVisibleText("Turkey (Türkiye)");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text()='Turkey (Türkiye)']")).click();
        Thread.sleep(2000);

        // Go to website butonuna tiklayiniz
driver.findElement(By.xpath("//input[@aria-labelledby='icp-save-button-announce']")).click();
        Thread.sleep(2000);

        // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz
                Thread.sleep(2000);


        Set<String> windowHandlesSet=driver.getWindowHandles();
        String secondPageHandle="";
        for (String each:windowHandlesSet){
            if (!each.equals(firstPageHandle)){
                secondPageHandle=each;
            }
        }

        driver.switchTo().window(secondPageHandle);
        String secondPageTitle=driver.getTitle();
        assertTrue(secondPageTitle.contains("Elektronik"));

    }
}
