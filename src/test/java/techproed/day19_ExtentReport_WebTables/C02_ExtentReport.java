package techproed.day19_ExtentReport_WebTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class C02_ExtentReport extends TestBase {
    @Test
    public void test01() {
        extentReport("Chrome","Amazon Test","Mesut DUNDAR");
        extentTest = extentReports.createTest("Extent Report","Test Raporu");
        //amazon sayfasina gidiniz
        driver.get("https://www.amazon.com/");
        extentTest.info("Amazon sayfasina gidildi");
        //sayfanin resmini aliniz
        fullScreenScreenShot();
        extentTest.info("Sayfanin ekran resmi alindi");
        //arama kutusunda iphone aratiniz
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone" + Keys.ENTER);
        extentTest.info("Arama kutusunda iphone aratildi");
        extentTest.pass("Sayfa kapatildi");

    }
}
