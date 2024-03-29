package techproed.day17_Exception;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_StaleElementReferanceException extends TestBase {
    /*
StaleElementReferanceException:

bir web sayfasındaki bir webelementin gecerliliginin kayboldugu durumlarda olusur.

Yani bir webelementi locate ettikten sonra sayfada refresh yada back-forward kullanıyorsak
yeniden o elemente ulasmak istedigimizde StaleElementReferanceException hatasını alırız.

Bunu handle edebilmek icin webelemente yeniden aynı locate'ı atamalıyız.
(webelementin locate'ını hatırlatma gibi diyebiliriz.)


 */
    @Test
    public void StaleElementReferanceExceptionTest1() {


        // techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");


        // reklamı kapatalım
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();



        // sayfayı yenileyelim
        driver.navigate().refresh();


        // LMS LOGIN butonuna tıklayalım
        WebElement login = driver.findElement(By.xpath("(//*[text()='LMS LOGIN'])[1]"));
        login.click();



    }


    @Test
    public void StaleElementReferanceExceptionTest2() {


        // techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");


        // reklamı kapatalım
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();



        // LMS LOGIN butonunun locate'ını alalım
        WebElement login = driver.findElement(By.xpath("(//*[text()='LMS LOGIN'])[1]"));




        // sayfayı yenileyelim
        driver.navigate().refresh();



        // LMS LOGIN butonuna tıklayalım

        login.click();  // StaleElementReferenceException


        /*
        LMS LOGIN webelementini locate ettikten sonra sayfayı yeniledigimiz icin LMS LOGIN webelementi eskidi(bayatladı).
        sanrasında bayatlayan webelement'e click yaptıgımız icin StaleElementReferenceException hatası aldık.

        Bu exception'ı handle edebilmek icin refresh yaptıktan sonra tekrar aynı lacate'ı webelemente atamamız gerekiyor.
         */

    }


    @Test
    public void StaleElementReferanceExceptionTest3() {


        // techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");


        // reklamı kapatalım
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();



        // LMS LOGIN butonunun locate'ını alalım
        WebElement login = driver.findElement(By.xpath("(//*[text()='LMS LOGIN'])[1]"));




        // sayfayı yenileyelim
        driver.navigate().refresh();



        // LMS LOGIN butonuna tıklayalım
        login = driver.findElement(By.xpath("(//*[text()='LMS LOGIN'])[1]"));
        login.click();




    }






}
