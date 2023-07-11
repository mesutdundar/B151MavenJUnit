package techproed.day22_JSExecuter;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_JSExecuter_Scroll extends TestBase {
    //  https://techproeducation.com sayfasına gidin
// "We Offer" elementi görünür olacak şekilde scroll et (sayfayı kaydır)
// Aynı sayfada "Enroll Free" elementi görünür olacak sekilde scroll et (sayfayı kaydır)
// Aynı sayfada "WHY US?" elementi görünür olacak şekilde scroll et (sayfayı kaydır)
// Aynı sayfada tekrar "Enroll Free" elementi görünür olacak şekilde scroll et (sayfayı kaydır)
// Sayfayi en üste scroll et (sayfayı kaydır)
// Sayfayı en alta scroll et (sayfayı kaydır)
    @Test
    public void test01 (){
        //  https://techproeducation.com sayfasına gidin
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();//reklami kapattim
        // "We Offer" elementi görünür olacak şekilde scroll et (sayfayı kaydır)
        WebElement weOffer = driver.findElement(By.xpath("//span[text()='we offer']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",weOffer);
        // Aynı sayfada "Enroll Free" elementi görünür olacak sekilde scroll et (sayfayı kaydır)
        WebElement enrollFree = driver.findElement(By.xpath("//span[text()='Enroll Free Course']"));

        //js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].scrollIntoView(true);",enrollFree);
        scroll(enrollFree);
// Aynı sayfada "WHY US?" elementi görünür olacak şekilde scroll et (sayfayı kaydır)
        WebElement whyUs = driver.findElement(By.xpath("//h3[text()='WHY US?']"));

        //js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].scrollIntoView(true);",whyUs);

        scroll(whyUs);
        // Aynı sayfada tekrar "Enroll Free" elementi görünür olacak şekilde scroll et (sayfayı kaydır)
//        js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true);",enrollFree);
        scroll(enrollFree);


        // Sayfayi en üste scroll et (sayfayı kaydır)
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");

        // Sayfayı en alta scroll et (sayfayı kaydır)
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
}
