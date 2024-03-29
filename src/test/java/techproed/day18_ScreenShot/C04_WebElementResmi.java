package techproed.day18_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C04_WebElementResmi extends TestBase {
/*
 Bir webelementin resmini almak için önce Webelementi locate edip bir webelemente assing ederiz.
ve bu webelementi direk getScreenShotAs() methodunu kullanarak resmini belirttimiz dosyaya kaydederiz.
 */
@Test
public void name() throws IOException {
    //amazon sayfasına gidelim
    driver.get("https://amazon.com");

    bekle(2);
    //iphone aratalım
    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);


    //çıkan sonucun resmini alalım
    WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
    String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
    String dosyaYolu = "src/test/java/techproed/ElementResmi/WEscreenShot" + tarih + ".jpeg";
    FileUtils.copyFile(sonucYazisi.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));


}
}
