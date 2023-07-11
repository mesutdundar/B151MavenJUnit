package techproed.day22_JSExecuter;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_JSExecuter_Type extends TestBase {
    @Test
    public void typeTest() {
        // https://techproeducation.com sayfasına gidin
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();//reklami kapattim
        bekle(3);
        // Arama kutusuna "QA" yazıp aratın
       WebElement searchBox =  driver.findElement(By.id("elementor-search-form-9f26725"));
    //    JavascriptExecutor js = (JavascriptExecutor) driver;
     //   js.executeScript("arguments[0].value='QA'",searchBox);
        sendKeysJS(searchBox,"QA");
        searchBox.submit();

        //********* 2. YOL ***********
        // WebElement aramaKutusu =driver.findElement(By.xpath("//input[@id='elementor-search-form-9f26725']"));
        //JavascriptExecutor js= (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].setAttribute('value','QA')",aramaKutusu);
       // sendAttributeJS(searchBox,"QA");//method olsuturup
        //searchBox.submit();
    }
}
