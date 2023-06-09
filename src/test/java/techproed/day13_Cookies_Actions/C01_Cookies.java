package techproed.day13_Cookies_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;


import java.util.Set;

public class C01_Cookies extends TestBase {
    @Test
    public void cookiesTest() {
        //1-Amazon anasayfaya gidin
        driver.get("https://www.amazon.com/");

        //2-tum cookie’leri listeleyin
        /*
    Cookie'leri listelemek istersek
            driver.manage().getCookies() methodu ile bir Set ya da ArraList'e atarak listeyebiliriz
 */

        Set<Cookie> cookiesSet = driver.manage().getCookies();
      //==> lambda ile bu sekilde yazdirabiliriz ==>   Arrays.stream(driver.manage().getCookies().toArray()).forEach(System.out::println);
        int sayac =1 ;
        for (Cookie w:cookiesSet) {
            System.out.println(sayac+". cookie ="+ w);
            sayac++;
        }
        //3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        Assert.assertTrue(cookiesSet.size()>5);

        //4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
     Cookie i118nPrefsCookie= driver.manage().getCookieNamed("i18n-prefs");
     Assert.assertEquals("USD",i118nPrefsCookie.getValue());//getValue() methoduyla cookienin degerini aldik.


        // 5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
        Cookie cookie = new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(cookie);
        //6-eklediginiz cookie’nin sayfaya eklendigini test edin
        cookiesSet=driver.manage().getCookies();

        for (Cookie each:cookiesSet) {
            System.out.println(each);
        }
        //7-ismi skin olan cookie’yi silin ve silindigini test edin
        //Silindikten sonra cookieSet'e yine atama yapiyoruz aksi taktirde fail aliriz
        driver.manage().deleteCookieNamed("skin");
        cookiesSet=driver.manage().getCookies();
        Assert.assertEquals(7,cookiesSet.size());

        //8-tum cookie’leri silin ve silindigini test edin
        //Silindikten sonra cookieSet'e yine atama yapiyoruz aksi taktirde fail aliriz
        driver.manage().deleteAllCookies();
        cookiesSet=driver.manage().getCookies();
        Assert.assertTrue(cookiesSet.isEmpty());
    }
}
