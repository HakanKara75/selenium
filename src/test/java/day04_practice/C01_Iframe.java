package day04_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class C01_Iframe extends TestBase {
    /*
         https://html.com/tags/iframe sayfasına gidiniz
     Videoyu görecek kadar asagiya ininiz
     Videoyu izlemek icin Play tusuna basiniz
     Videoyu calistirdiginizi test ediniz
     'Powerful,but easy to misuse' yazısının gorunur oldugunu test ediniz
     */
    @Test
    public void test() throws InterruptedException {
        // https://html.com/tags/iframe sayfasına gidiniz
        driver.get("https://html.com/tags/iframe");

        // Videoyu görecek kadar asagiya ininiz
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN).perform();

        // Videoyu izlemek icin Play tusuna basiniz

        WebElement iframe = driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(iframe);
        WebElement video = driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        video.click();
        Thread.sleep(3000);

        // Videoyu calistirdiginizi test ediniz
        WebElement youtubeYazisi = driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        assertTrue(youtubeYazisi.isDisplayed());

        // 'Powerful,but easy to misuse' yazısının gorunur oldugunu test ediniz
        driver.switchTo().defaultContent(); //iframe den cikar ana sayfaya gider
        //2.yol
        //driver.switchTo().parentFrame();
        WebElement powerful = driver.findElement(By.xpath("//span[@id='Powerful_but_easy_to_misuse']"));
        Assert.assertTrue(powerful.isDisplayed());


    }
}
