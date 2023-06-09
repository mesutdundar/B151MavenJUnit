package techproed.day12_WindowHandles_BasicAuthentication;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C01_WindowHandles extends TestBase {

    @Test
    public void test01() {
        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        //  ilk sayfasının Handle degerini alın yazdırın
      String firstPageWindowHandle =  driver.getWindowHandle();
        System.out.println("firstPageWindowHandle = " + firstPageWindowHandle);
        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
WebElement theText = driver.findElement(By.xpath("//h3[text()='Opening a new window']"));
        Assert.assertEquals("Opening a new window",theText.getText());

        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        Assert.assertEquals("The Internet",driver.getTitle());
        //  "Click Here" butonuna tıklayın.
        WebElement clickButtonLocator =driver.findElement(By.xpath("//*[text()='Click Here']"));
        clickButtonLocator.click();
        bekle(3);
        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        /*
        Burada oncelikle kendiliginden acilan yeni sayfanin handle degerini almamiz gerekecek.
        ama driver.getWindowHandle() methodunu kullaninca ilk sayfanin degerini bize getiriyor
        Bu yuzden ==> driver.getWindowHandles() methodu kullanip bunu Stringlerden olusan bir Set'e assign ediyoruz
        sonra bir foreach bloku icinde if conditionunda sayfa birin handle degeri olmayan ikincinin handle degeridir diyoruz
         */
       Set<String> windowHandleSet =  driver.getWindowHandles();
       // System.out.println(windowHandleSet);
        String secondPageWindowHandle ="";
        for (String w:windowHandleSet) {
            if (!w.equals(firstPageWindowHandle)){
                 secondPageWindowHandle = w;
            }
        }
        driver.switchTo().window(secondPageWindowHandle); //==> bu sekilde artik driverimiz yeni sayfaya gecirdik
        Assert.assertEquals("New Window" ,driver.getTitle());
        bekle(2);
        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        driver.switchTo().window(firstPageWindowHandle);
            Assert.assertEquals("The Internet",driver.getTitle());
            bekle(2);
        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(secondPageWindowHandle);
        bekle(2);
        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(firstPageWindowHandle);
        bekle(2);
    }
}
