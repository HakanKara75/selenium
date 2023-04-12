package day04_practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class C02_WindowHandle extends TestBase {

    // 1- https://www.amazon.com sayfasina gidelim
    // 2- url'in 'amazon' icerdigini test edelim
    // 3- yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim
    // 4- title'in 'Best Buy' icerdigini test edelim
    // 5- ilk sayfaya(amazon) donup sayfada java aratalım
    // 6- arama sonuclarının 'Java' icerdigini test edelim
    // 7- ikinci sayfaya(bestbuy) donelim
    // 8- logonun gorundugunu test edelim
    @Test
    public void test() throws InterruptedException {
        // 1- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");
        String amazonHandle = driver.getWindowHandle();

        // 2- url'in 'amazon' icerdigini test edelim
        String url = driver.getCurrentUrl();
        assertTrue(url.contains("amazon"));
        Thread.sleep(2000);

        // 3- yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim
        driver.switchTo().newWindow(WindowType.WINDOW); //yeni pencere acar
        driver.get("https://www.bestbuy.com");
        String bestBuyHandle= driver.getWindowHandle();

        // 4- title'in 'Best Buy' icerdigini test edelim
        String title = driver.getTitle();
        assertTrue(title.contains("Best Buy"));
        Thread.sleep(2000);

        // 5- ilk sayfaya(amazon) donup sayfada java aratalım
        driver.switchTo().window(amazonHandle);
        WebElement amazonSearchBar = driver.findElement(By.xpath("//input[@placeholder='Search Amazon']"));
        amazonSearchBar.sendKeys("java" + Keys.ENTER);

        // 6- arama sonuclarının 'Java' icerdigini test edelim
        WebElement results = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));
        assertTrue(results.getText().contains("java"));
        Thread.sleep(2000);

        // 7- ikinci sayfaya(bestbuy) donelim
        driver.switchTo().window(bestBuyHandle);

        // 8- logonun gorundugunu test edelim
        WebElement bestBuyLogo= driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));
        assertTrue(bestBuyLogo.isDisplayed());


    }
}
