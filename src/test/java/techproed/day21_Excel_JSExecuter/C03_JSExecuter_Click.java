package techproed.day21_Excel_JSExecuter;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_JSExecuter_Click extends TestBase {
/*
Eger bir web sayfasinin HTML kodlari tamamen ya da kismen JavaScript kullanilarak olusturulduysa
o sayfayla etkilesimde bulunmak icin standart WebDriver komutlari yetersiz kalabilir

Bu durumda sayfayla etkilesime gecmek icin JavaScriptExecuter arayüzünü kullanmak gerekir
JavaScriptExecuter arayüzü sayfaya dogrudan erisebilir.

JavaScriptExecuter her durumda kullanabiliriz.
Her kapiyi acan anahtar gibidir. Ancak WebDriver'in sundugu standart yöntemleri kullanmak daha iyidir.
JavaScriptExecuter sayfanin gec yüklenmesine sebep olabilir.
 */

    @Test
    public void JavaScriptExecuterClick() {

        //https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/");

        //returns kismina tiklayin
        WebElement returns = driver.findElement(By.xpath("//a[@id='nav-orders']"));
        //returns.click();
        //JS ile HTML kodu yazilmis olsaydi click(); calismazdi.

     //   JavascriptExecutor js = (JavascriptExecutor) driver;
      //  js.executeScript("arguments[0].click();",returns);
        click(returns);

    }
}
