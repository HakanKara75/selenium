package day06_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

// https://the-internet.herokuapp.com/dynamic_controls adresine gidiniz
// Textbox'in etkin olmadıgını(enable) test edin
// Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
// It's enable! mesajının goruntulendigini test edin
// Textbox'in etkin oldugunu(enable) test edin
public class C01_Waits extends TestBase {
    @Test
    public void name() {
        // https://the-internet.herokuapp.com/dynamic_controls adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

       // Textbox'in etkin olmadıgını(enable) test edin
        WebElement textbox=driver.findElement(By.xpath("//input[@style='width: 30%;']"));
       assertFalse(textbox.isEnabled());

        // Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        WebElement enableButton= driver.findElement(By.xpath("//button[text()='Enable']"));
        enableButton.click();

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(textbox));

        // It's enable! mesajının goruntulendigini test edin
WebElement message=driver.findElement(By.id("message"));
assertTrue(message.isDisplayed());

        // Textbox'in etkin oldugunu(enable) test edin
        assertTrue(textbox.isEnabled());


    }
}
