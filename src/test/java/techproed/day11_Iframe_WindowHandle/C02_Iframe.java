package techproed.day11_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_Iframe extends TestBase {

    @Test
    public void Iframe() {
        //==>  https://the-internet.herokuapp.com/iframe sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

        //==>  Kalın yazının "Editor" kelimesini içerdiğini test ediniz
        WebElement kalinYazi = driver.findElement(By.xpath("//h3[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        Assert.assertTrue(kalinYazi.getText().contains("Editor"));

        //==>  textBox içindeki yazıyı siliniz.
        //burada bir Iframe var  dolayisiyla once oraya switch etmemiz gerekiyor!
        WebElement iframeLocator = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframeLocator);

        /*
        Iframe'e gecmenin 2.yolu index ile;
        driver.switchTo().frame(0);

        Eger 2 tane Iframe olsaydı ve 2. Iframe'e gecmek isteseydim index'i 1 almam gerekecekti
        */

        /*
         Iframe'e gecmenin 3. yolu id veya name value ile;
         iframe HTML kod blogunda id veya name attribute'u varsa

         driver.switchTo().frame("mce_0_ifr");

          bu sekilde de gecis yapabiliriz
        */


        WebElement textsLocator = driver.findElement(By.xpath("//p[text()='Your content goes here.']"));
        textsLocator.clear();

        //==>  Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
        textsLocator.sendKeys("Bu textbox iFrame içinde yer almaktadır");
        bekle(3);

        //==>  Sayfadaki "Elemental Selenium" yazısının görünür olduğunu doğrulayınız.
        //burada parent ifram'e geri donmemiz gerekiyor oncelikle
        driver.switchTo().defaultContent();
        WebElement elementalSeleniumText = driver.findElement(By.xpath("//a[text()='Elemental Selenium']"));
        Assert.assertTrue(elementalSeleniumText.isDisplayed());


        /*
        //Birden fazla iframe oldugu zaman onlarin kac tane oldugu nasil anlariz
        ve kac adet oldugu ile ilgil sonuc yazdirabilir miyiz?
        herhanbgi bir dongu icine mi almamiz gerekir?

        web sayfasina gideriz, sag click incele deriz, html kodlari gelir, alttaki cubuga //iframe yazariz
        sagdaki kisimda 1 of 1 oldugunda 1 tane iframe oldugunu görürüz.
        iframe yazarsak bu sayfada bulunan iframe taglarini getirir
        kodlarda anlöamak icin bu yöntemi kullaniriz. iframe olup olmadigini bu sekilde anlariz

         */
    }

}
