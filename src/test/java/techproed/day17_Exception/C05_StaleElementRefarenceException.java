package techproed.day17_Exception;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C05_StaleElementRefarenceException extends TestBase {



    @Test
    public void StaleElementRefarenceException() {

        // Amazon sayfasına gidelim
        driver.get("https://amazon.com");


        // arama motoruna iphone yazıp aratalım
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone" + Keys.ENTER);


        // cıkan sonuclardan ilk 5'ine tıklayıp sayfa baslıklarını alalım konsola yazdıralım
        List<WebElement> urunlerList =  driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        int sayac = 1;
        for (int i = 0; i <urunlerList.size() ; i++) {
            urunlerList =  driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
            urunlerList.get(i).click();
            System.out.println(sayac+". Sayfa Basligi = "+driver.getWindowHandle());
       sayac ++;
       driver.navigate().back();
       if (sayac==6){
           break;
       }
        }
    }
}