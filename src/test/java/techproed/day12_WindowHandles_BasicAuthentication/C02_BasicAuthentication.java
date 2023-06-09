package techproed.day12_WindowHandles_BasicAuthentication;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C02_BasicAuthentication extends TestBase {
    /*
-Authentication kimlik dogrulama yöntemidir
- söz konusu sisteme dahil olup olunamayacagını belirleyen formu ifade eder
- Authentication üzerinde sag click yapıp locate alınamaz
- Authentication bir alert degildir
- Authentication yapabilmek icin uygulamanın kullanıcılara,
Authentication'ı nasıl yapacagına dair bilgilendirme yapmıs olması gerekir
- https://username:password@URL gibi

 */

    @Test
    public void basicAuthentication() {
// Aşağıdaki bilgileri kullanarak authentication yapınız:

// Url: https://the-internet.herokuapp.com/basic_auth
// Username: admin
// Password: admin
//- https://username:password@URL bu formata uygun kimlik dogrulamasi yapilacaktir ( Bunu bize sirket verir!)
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
//Paragrafın "Congratulations" kelimesini içerdiğini doğrulayınız
       String  actualTheTextContainsCong = driver.findElement(By.xpath("//p")).getText();
        String expectedTheTextContainsCong = "Congratulations";
        Assert.assertTrue(actualTheTextContainsCong.contains(expectedTheTextContainsCong));
    }
}
