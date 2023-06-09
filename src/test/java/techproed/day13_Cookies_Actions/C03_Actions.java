package techproed.day13_Cookies_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_Actions extends TestBase {
    @Test
    public void actionTest() {
        //Amazon a gidelim https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        //Sag ust bolumde bulunan "Account & Lists" menüsüne git  "Account" secenegine tikla
        WebElement accountListsElemetLocator = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        Actions actions = new Actions(driver);
        actions.moveToElement(accountListsElemetLocator).perform(); // moveToElement() methodu ile fareyi istedigimiz webelementin uzerine goturebiliriz
        driver.findElement(By.xpath("(//span[@class='nav-text'])[3]")).click();


        //Acilan sayfanin Title in "Your Account" icerdigini dogrula
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("Your Account"));
    }
}
