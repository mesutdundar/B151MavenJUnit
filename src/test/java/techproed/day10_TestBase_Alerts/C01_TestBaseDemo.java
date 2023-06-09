package techproed.day10_TestBase_Alerts;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C01_TestBaseDemo extends TestBase {


    @Test
    public void test01() {
        //techproeducation sayfasına gidiniz
        driver.get("https://www.techproeducation.com");
        // Baslıgın "Bootcamp" icerdigini test ediniz
        String actualTitle=driver.getTitle();
        String expectedTitle = "Bootcamp";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    //==> Bu benim yaptigim    Assert.assertTrue(driver.getTitle().contains("Bootcamp"));

    }
}
