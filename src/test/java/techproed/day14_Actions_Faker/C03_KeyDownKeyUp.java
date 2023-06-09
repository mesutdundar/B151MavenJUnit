package techproed.day14_Actions_Faker;

import org.checkerframework.checker.units.qual.K;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_KeyDownKeyUp extends TestBase {
    @Test
    public void test01() {
        //Google anasayfasına gidelim
        driver.get("https://www.google.com");
//arama kutusunda shift tusuna basılı olarak selenium yazdıralım ve shift tuşunu serbest bırakarak java yazdıralım
      WebElement searchBoxLocator =  driver.findElement(By.id("APjFqb"));
        Actions actions = new Actions(driver);
        actions.
                keyDown(searchBoxLocator, Keys.SHIFT).//ile shifte basili tuttuk
                sendKeys("selenium").//shift basili oldugundan yazi buyuk harflerle yazildi
                keyUp(Keys.SHIFT).//ile basili olan shift tusunu kaldirdik
                sendKeys(" java",Keys.ENTER).//shifti kaldirdigimiz icin oldugu gibi yazdi
                perform();
    }

    @Test
    public void test02() {
        //actione objesini kullanmadan aynisini yapiyoruz
        //Google anasayfasına gidelim
        driver.get("https://www.google.com");
        //arama kutusunda shift tusuna basılı olarak selenium yazdıralım ve shift tuşunu serbest bırakarak java yazdıralım
        WebElement searchBoxLocator =  driver.findElement(By.id("APjFqb"));
        searchBoxLocator.sendKeys(Keys.SHIFT,"selenium",Keys.SHIFT,"-java",Keys.ENTER);
         /*
        Mouse islemleri icin actions class' ini kullanmamiz gerekir. Fakat bir metin kutusundaki klavye islemleri icin
        actions class' ini kullanmadan sendKeys() methodu ile de istedigimiz bir metni buyuk yazdirabilir,
        hatta birden fazla klavye tuslarina bastirabiliriz.Yukaridaki ornekte sendKeys() methodu ile Keys.SHIFT diyerek
        sonrasinda yazdirmak istedigimiz metni kucuk harfle yazmamiza ragmen buyuk harflerle yazdirdi, tekrar Keys.SHIFT
        kullanarak shift tusunu serbest birakmis olduk

        */
    }

    @Test
    public void test03() {
        //google sayfasına gidelim
        driver.get("https://www.google.com");
// Arama kutusuna "Selenium" yazın ve Enter tuşuna basın
        WebElement searchBoxLocator =  driver.findElement(By.id("APjFqb"));
        searchBoxLocator.sendKeys("Selenium" + Keys.ENTER);
    // Sayfayı bekleyin
        bekle(4);
        // Arattığımız kelimeyi arama kutusundan ctrl+x ile keselim
        searchBoxLocator =  driver.findElement(By.id("APjFqb")); // sayfa yenilendigi icin tekrar locate aldik
        searchBoxLocator.sendKeys(Keys.CONTROL,"a",Keys.CONTROL,"x");
        //Tekrar google sayfasına gidip kestiğimiz kelimeyi ctrl+v ile yapıştırıp tekrar aratalım
        driver.navigate().to("www.google.com");
      searchBoxLocator =  driver.findElement(By.id("APjFqb"));
        bekle(3);
        searchBoxLocator.sendKeys(Keys.CONTROL,"v", Keys.ENTER);
        bekle(2);
    }
}
