package techproed.day16_Wait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;



public class C02_ExplicitWait extends TestBase {
    @Test
    public void name() {

    //==> https://the-internet.herokuapp.com/dynamic_loading/1 sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
    //==> Start buttonuna tıklayın
        driver.findElement(By.xpath("//button[text()='Start']")).click();
bekle(2);
    //==> Hello World! yazısının görünürlügünü test edin
        WebElement helloWorldTextLocator=driver.findElement(By.xpath("//h4[text()='Hello World!']"));
      WebDriverWaitWithVisibility(helloWorldTextLocator,10);
        Assert.assertTrue(helloWorldTextLocator.isDisplayed());

}
}
