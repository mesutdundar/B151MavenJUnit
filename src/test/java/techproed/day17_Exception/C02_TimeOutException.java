package techproed.day17_Exception;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_TimeOutException extends TestBase {


    @Test
    public void TimeOutException() {

        /*
        TimeOutException:

        sayfada aradıgımız elementi wait ile belirttigimiz max. sürede
        bulamadıgı durumda TimeOutException hatası alırız.

         */

        // techproeducation sayfasına gidiniz
        driver.get("https://techproeducation.com");
        bekle(3);

        // reklamı kapatınız
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();



        // searchBox gorunur oluncaya kadar bekleyiniz
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='YANLISelementor-search-form-9f26725']")));

       /*
       TimeOutException alabilmek icin visibilityOfElementLocated methodunu kullanarak yanlıs bir locate aldık.

       webelement'i beklerken o webelementin locate'ını bulamadıgı icin max. belirttigimiz süre kadar bekledi ve
       TimeOutException hatasını verdi.
        */


    }


    @Test
    public void TimeOutExceptionTest2() {


        // https://the-internet.herokuapp.com/dynamic_loading/1 sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");




        // Start butonuna tıklayınız
        driver.findElement(By.xpath("//button[text()='Start']")).click();



        // Hello World! yazısının görünürlügünü test ediniz
        WebElement helloWorldYazisi = driver.findElement(By.xpath("//h4[text()='Hello World!']"));


        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOf(helloWorldYazisi));


        Assert.assertTrue(helloWorldYazisi.isDisplayed());

        /*
        gercekte Hello World! yazısı ortalama 6 saniyede gözüküyor
        TimeOutException alabilmek icin Explicit Wait'e max. bekleme süresini 1 saniye verdik.
        Bu sebeple TimeOutException hatası aldık.
         */



    }
}