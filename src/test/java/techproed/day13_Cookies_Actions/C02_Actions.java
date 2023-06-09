package techproed.day13_Cookies_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions extends TestBase {
    @Test
    public void actionTest() {
        // https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        // Kutuya sag tıklayın
        Actions actions =new Actions(driver);
        WebElement boxLocator = driver.findElement(By.id("hot-spot"));
        actions.contextClick(boxLocator).perform(); // contextClick() methodu sag tiklama methodudur!
        //actions'lari kullanabilmek icin methodlarin sonuna perform() methodunu kullaniriz!!!
        bekle(2);
        // Alert'te cikan yazinin "You selected a context menu"oldugunu test edin
        String actualText = driver.switchTo().alert().getText();
        String expectedText = "You selected a context menu";
        Assert.assertEquals(expectedText,actualText);

        // Tamam diyerek alert'i kapatın
        driver.switchTo().alert().accept();
        bekle(1);
    }
}
