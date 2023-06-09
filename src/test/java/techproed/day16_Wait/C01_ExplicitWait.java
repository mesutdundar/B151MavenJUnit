package techproed.day16_Wait;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C01_ExplicitWait extends TestBase {


    @Test
    public void explicitWait() {
        //==> https://the-internet.herokuapp.com/dynamic_loading/1 sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        //==> Start buttonuna tıklayın
        driver.findElement(By.xpath("//button[text()='Start']")).click();

//==> Hello World! yazısının görünürlügünü test edin
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
       WebElement element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Hello World!']")));
        Assert.assertTrue(element.isDisplayed());



    }
}
