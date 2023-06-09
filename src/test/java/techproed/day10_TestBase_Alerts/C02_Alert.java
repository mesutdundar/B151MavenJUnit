package techproed.day10_TestBase_Alerts;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_Alert extends TestBase {
    /*
    https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.


    Bir metod olusturun: acceptAlert
    1. butona tıklayın,
    uyarıdaki OK butonuna tıklayın
    ve result mesajının "You successfully clicked an alert" oldugunu test edin.



    Bir metod olusturun: dismissAlert
    2. butona tıklayın,
    uyarıdaki Cancel butonuna tıklayın
    ve result mesajının "successfuly" icermedigini test edin.



    Bir metod olusturun: sendKeysAlert
    3. butona tıklayın,
    uyarıdaki mesajı konsolda yazdırın,
    uyarıdaki metin kutusuna isminizi yazin,
    OK butonuna tıklayın
    ve result mesajında isminizin görüntülendiğini doğrulayın.

     */

    @Test
    public void acceptAlert() throws InterruptedException {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

//        Bir metod olusturun: acceptAlert
//        1. butona tıklayın,
        driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[1]")).click();
        bekle(3000);//        uyarıdaki OK butonuna tıklayın
        driver.switchTo().alert().accept(); //switchto ==> Alert'e gecis yaptik ve cikan uyariyi kabul ettik
        bekle(3000);
//        ve result mesajının "You successfully clicked an alert" oldugunu test edin.
        WebElement result = driver.findElement(By.id("result"));
        Assert.assertEquals("You successfully clicked an alert", result.getText());
    }

    @Test
    public void dismissAlert() {
//        Bir metod olusturun: dismissAlert
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
//        2. butona tıklayın,
        driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[2]")).click();
//        uyarıdaki Cancel butonuna tıklayın
        driver.switchTo().alert().dismiss();
//        ve result mesajının "successfully" icermedigini test edin.
        WebElement result1 = driver.findElement(By.id("result"));
        Assert.assertFalse(result1.getText().contains("successfully"));
        // String actualResult1 = driver.findElement(By.id("result")).getText();
        // String expectedResult1 = "successfully";
        //Assert.assertFalse(actualResult1.contains(expectedResult1));   ==> bu da hocanin yaptigi ve olmasi gereken de bence bu !

    }

    @Test
    public void sendKeysAlert() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
//        Bir metod olusturun: sendKeysAlert
//        3. butona tıklayın,
        driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[3]")).click();
        bekle(3);
//        uyarıdaki mesajı konsolda yazdırın,
        System.out.println(driver.switchTo().alert().getText());
//        uyarıdaki metin kutusuna isminizi yazin,
        driver.switchTo().alert().sendKeys("Mesut");
//                OK butonuna tıklayın
        driver.switchTo().alert().accept();
//        ve result mesajında isminizin görüntülendiğini doğrulayın.
        String actualResult2 = driver.findElement(By.id("result")).getText();
        String expectedResult2 = "Mesut";
        Assert.assertTrue(actualResult2.contains(expectedResult2));
    }
}
