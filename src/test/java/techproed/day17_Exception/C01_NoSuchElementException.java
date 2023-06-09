package techproed.day17_Exception;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_NoSuchElementException extends TestBase {
    @Test
    public void noSuchElementException() {
         /*
        NoSuchElementException:
         Sayfada bulunmayan bir elemenente erisim saglanmaya calisildiginde
        NoSuchElementException hatasi aliriz.
         */
        //techproEducation sayfasina gidiniz.
        driver.get("https://www.techproeducation.com");
        //reklami kapatiniz
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        //searchBox'a java yazip aratalim
        WebElement searchBoxLocator= driver.findElement(By.id("element-search-form-9f26725"));//noSuchElementException locate hatali oldugu icin
        searchBoxLocator.sendKeys("Java");
        searchBoxLocator.submit();
    }
}
