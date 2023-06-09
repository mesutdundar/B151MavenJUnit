package techproed.day18_ScreenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C01_TumSayfaResmi extends TestBase {
/*
SCREENSHOT
       Selenium'da tüm ekran görüntüsünü alabilmek için TakesScreenShot arayünden bir obje oluşturup
   driver'a eşitleriz. Arayüzler farklı olduğu için casting yaparız. Ve bu oluşturduğumuz obje ile
   getScreenshotAs methodu ile sayfanın resmini alırız. Almış olduğumuz resmi projemizde nereye kaydedeceksek
   oranın yolunu belirtiriz.
 */

    @Test
    public void test01() {
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


    }
}
