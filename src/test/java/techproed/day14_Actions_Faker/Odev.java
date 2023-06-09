package techproed.day14_Actions_Faker;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Odev extends TestBase {
    /*
    1- "http://webdriveruniversity.com/Actions" sayfasina gidin
    2- Hover over  Me First" kutusunun ustune gelin
    3- Link 1" e tiklayin
    4- Popup mesajini yazdirin
    5- Popup'i tamam diyerek kapatin
    6- “Click and hold" kutusuna basili tutun
    7-“Click and hold" kutusunda cikan yaziyi yazdirin  8- “Double click me" butonunu cift tiklayin. Tıklandığını test edin
     */

    @Test
    public void testOdev() {
//        1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
//        2- Hover over  Me First" kutusunun ustune gelin
        WebElement hoverOverMeFirstButtonLocator = driver.findElement(By.xpath("//button[text()='Hover Over Me First!']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverOverMeFirstButtonLocator).perform();

//        3- Link 1" e tiklayin
        driver.findElement(By.xpath("(//a[@class='list-alert'])[1]")).click();

//        4- Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());
//        5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
//        6- “Click and hold" kutusuna basili tutun
        WebElement clickAndHoldButtonLocator = driver.findElement(By.id("click-box"));
        actions.clickAndHold(clickAndHoldButtonLocator).perform();
        bekle(3);
//        7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickAndHoldButtonLocator.getText());
//        8- “Double click me" butonunu cift tiklayin. Tıklandığını test edin
        WebElement doubleClickMeButtonLocator = driver.findElement(By.xpath("//div[@id='double-click']"));
        String actual = doubleClickMeButtonLocator.getText();
        actions.doubleClick(doubleClickMeButtonLocator).perform();
        bekle(2);
        WebElement doubleClickMebuttonAfterLocator =driver.findElement(By.xpath("//div[@class='div-double-click double']"));
        String expected = doubleClickMebuttonAfterLocator.getText();
        Assert.assertEquals(expected,actual);


    }
}

