package techproed.day18_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C01_TumSayfaResmi extends TestBase {
/*
SCREENSHOT
       Selenium'da tüm ekran görüntüsünü alabilmek için TakesScreenShot arayünden bir obje oluşturup
   driver'a eşitleriz. Arayüzler farklı olduğu için casting yaparız. Ve bu oluşturduğumuz obje ile
   getScreenshotAs methodu ile sayfanın resmini alırız. Almış olduğumuz resmi projemizde nereye kaydedeceksek
   oranın yolunu belirtiriz.
 */

    @Test
    public void test01() throws IOException {
        //Techproeducation sayfasine gidelim
        driver.get("https://www.techproeducation.com");
        bekle(1);

//Cikan reklami kapatalim
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
        bekle(1);

//Ve ekran goruntusunu alalim.
        /*
-İlk olarak SS aldığımızda nereye kaydetmek istiyorsak oranın yolunu belirtelim
-İkinci olarak TakesScreenShot arayüzünden obje oluştururuz
-Üçüncü olarak FileUtils class'ından copyFile() methodu ile ts objemizi kullanarak getScreenShotAs methodu ile
dosya yolunu belirteceğiz
 */
        String filePath = "src/test/java/techproed/TumSayfaResmi/screenShot1.png";
        TakesScreenshot tss = (TakesScreenshot) driver;
        FileUtils.copyFile(tss.getScreenshotAs(OutputType.FILE),new File(filePath));

    }
}
