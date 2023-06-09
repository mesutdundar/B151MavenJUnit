package techproed.day16_Wait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.Wait;
import utilities.TestBase;

import java.time.Clock;
import java.time.Duration;

public class C03_FluentWait extends TestBase {
    // Fluent Wait ==> Belirli bir kosul gerceklesene kadar max sure boyunca,
// belittigimiz aralıklarla webelementi kontrol ederek bekler.
    /** explict wait 500ms araliklarla kontrol ediyordu , fluent waitte araligi kendimiz belirliyoruz */
    //==> https://the-internet.herokuapp.com/dynamic_loading/1 sayfasına gidin
//==> Start buttonuna tıklayın
//==> Hello World! yazısının görünürlügünü test edin
    @Test
    public void fluentWait() {
        //==> https://the-internet.herokuapp.com/dynamic_loading/1 sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        //==> Start buttonuna tıklayın
        driver.findElement(By.xpath("//button[text()='Start']")).click();
        //==> Hello World! yazısının görünürlügünü test edin
        WebElement helloWorldTextLocator=driver.findElement(By.xpath("//h4[text()='Hello World!']"));
        Wait<WebDriver> wait = new FluentWait<>(driver).
                withTimeout(Duration.ofSeconds(30)).//==> fluent wait icin max bekleme suresi
                pollingEvery(Duration.ofSeconds(3)).//==> kac saniyede bir kac saniyede bir kontrol edeccegini belirler
                withMessage("Ignore Exception");// ==> zorunlu degil , hata durumunda mesaj vermesi icin
        wait.until(ExpectedConditions.visibilityOf(helloWorldTextLocator));
        Assert.assertTrue(helloWorldTextLocator.isDisplayed());
    }
}
