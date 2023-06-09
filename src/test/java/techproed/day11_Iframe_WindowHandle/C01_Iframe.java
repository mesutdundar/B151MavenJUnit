package techproed.day11_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_Iframe extends TestBase {



    //==>   https://testcenter.techproeducation.com/index.php?page=iframe
//==>  Ana sayfadaki 'An iframe with a thin black border:' yazısının 'black border' icerdigini test edin
//==>  icteki web sayfasında 'Applications lists' yazisinin görünür oldugunu test edelim
//==>   Ana sayfadaki'Povered By' yazisinin "Povered" icerdigini test edin
    @Test
    public void iframe() {
        //==>   https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");
//==>  Ana sayfadaki 'An iframe with a thin black border:' yazısının 'black border' icerdigini test edin
       WebElement locatorOfText = driver.findElement(By.xpath("//p[text()='An iframe with a thin black border:']"));
        Assert.assertTrue(locatorOfText.getText().contains("black border"));
//==>  icteki web sayfasında 'Applications lists' yazisinin görünür oldugunu test edelim
        /**
         Applications lists yazisini dogru locate edip, dogru sekilde görünür oldugunu test etmemize ragmen
         ilk basta Test FAILD oldu. Bunun üzerine; HTML kodlarini inceleyince Applications lists yazisinin
         aslinda bir "iframe" icerisinde oldugunu gördük. Bu durumda önce iframe'i locate edip switchTo() ile
         iframe'e gecis yapmaliyiz.
         */
        WebElement iframeLocator = driver.findElement(By.xpath("//iframe[@src='/index.php']"));
       driver.switchTo().frame(iframeLocator);
        WebElement applicationsText = driver.findElement(By.xpath("//h1[text()='Applications lists']"));

        Assert.assertTrue(applicationsText.isDisplayed());
//==>   Ana sayfadaki'Povered By' yazisinin "Povered" icerdigini test edin
        driver.switchTo().parentFrame();
        //parentFrame()==>  bir ust seviyedeki Ifram'e cikmak icin kullanilir
        //defaultContent() ==> en ustteki Iframe'e cikmak icin kullanilir!
        //veya en ust sayfaya cikmamizi saglayan ==> driver.switchTo().defaultContent(); methodunu kullanabiliriz!
       WebElement poveredText = driver.findElement(By.xpath("//p[text()='Povered By']"));
        Assert.assertTrue(poveredText.getText().contains("Povered"));

    }
}
