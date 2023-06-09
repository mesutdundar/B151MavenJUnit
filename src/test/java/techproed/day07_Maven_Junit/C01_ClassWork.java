package techproed.day07_Maven_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_ClassWork {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//        1.http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");
//        2.Signin buttonuna tiklayin
        driver.findElement(By.id("signin_button")).click();
        Thread.sleep(2000);
//        3.Login alanine “username” yazdirin
        driver.findElement(By.xpath("//*[@id='user_login']")).sendKeys("username");
        Thread.sleep(2000);
//        4.Password alanine “password” yazdirin
        driver.findElement(By.id("user_password")).sendKeys("password");
        Thread.sleep(2000);
//        5.Sign in buttonuna tiklayin
        driver.findElement(By.xpath("(//*[@name='submit'])[1]")).click();
        driver.navigate().back();
        Thread.sleep(2000);
//        6.Online Banking sayfasi altindaki Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//*[text()='Online Banking']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("pay_bills_link")).click();
        Thread.sleep(2000);
//        7.amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.id("sp_amount")).sendKeys("10000");
        Thread.sleep(2000);
//        8.tarih kismina “2020-09-10” yazdirin
        driver.findElement(By.id("sp_date")).sendKeys("2020-09-10");
        Thread.sleep(2000);
//        9.Pay buttonuna tiklayin
        driver.findElement(By.id("pay_saved_payees")).click();
        Thread.sleep(2000);

//        10.“The payment was successfully submitted.” mesajinin ciktigini control edin
        String sonucYazisi =driver.findElement(By.id("alert_content")).getText();
        if (sonucYazisi.equals("The payment was successfully submitted.")){
            System.out.println("Test PASSED");
        }else System.out.println("Test Failed");
        Thread.sleep(2000);
        //  11. "Sayfayi kapat"
driver.close();
    }

}
