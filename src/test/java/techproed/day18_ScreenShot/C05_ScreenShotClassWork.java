package techproed.day18_ScreenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C05_ScreenShotClassWork extends TestBase {
    //Techproeducation sayfasına gidelim
//sayfanın resmini alalım
//Arama bölümünde java aratalım
//ve sonuc yazısının resmini alalım
//Yeni bir sekmede amazona gidelim
//sayfanın resmini alalım
//arama bölümde iphone aratalım
//ve sonuc yazısının resmini alalım
//tekrar tecpro sayfasına geçelim ve sayfa resmini alalım

    @Test
    public void screenShot() {
        //Techproeducation sayfasına gidelim
        driver.get("https://www.techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();//reklami kapattim
bekle(2);
        //sayfanın resmini alalım
        fullScreenScreenShot();

        //Arama bölümünde java aratalım
        driver.findElement(By.id("elementor-search-form-9f26725")).sendKeys("java" + Keys.ENTER);

        //ve sonuc yazısının resmini alalım
        WebElement resultTextLocator= driver.findElement(By.xpath("(//*[@class='elementor-heading-title elementor-size-default'])[1]"));
        webElementScreenShot(resultTextLocator);
        //Yeni bir sekmede amazona gidelim
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");
        bekle(2);

        //sayfanın resmini alalım
        fullScreenScreenShot();
        //arama bölümde iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone" + Keys.ENTER);

        //ve sonuc yazısının resmini alalım
        WebElement resultText1 = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        webElementScreenShot(resultText1);
        //tekrar tecpro sayfasına geçelim ve sayfa resmini alalım
        switchToWindow(0);//switchtoWindow methodunu kullandim utilitiesdeki
        bekle(2);
        fullScreenScreenShot();

    }
}
