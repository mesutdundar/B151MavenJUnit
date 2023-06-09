package techproed.day09_DropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.sql.DriverManager;
import java.time.Duration;
import java.util.List;

public class C02_DropDown {
     WebDriver driver;

    /*
    -getFirstSelectedOption() ==> Dropdown`daki en son sectigimiz option`u bize dondurur.

    -getOptions() ==> Dropdown`daki tum optionlari bize dondurur.
     */
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() {
        // https://testcenter.techproeducation.com/index.php?page=dropdown sayfasına gidiniz
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        // Select a State Dropdown'undan "Arizona" seciniz
        WebElement state =driver.findElement(By.xpath("//select[@id='state']"));
        Select stateDDM = new Select(state);
        stateDDM.selectByValue("AZ");

        // Select a State Dropdown'undan son secilen option'un "Arizona" oldugunu test ediniz
WebElement lastChosenOption =stateDDM.getFirstSelectedOption();
    String lastChosenOptionString =lastChosenOption.getText();
    Assert.assertEquals("Arizona",lastChosenOptionString);
        // Select a State Dropdown'undaki tum optionları konsolda yazdırınız
        List<WebElement> optionsList = stateDDM.getOptions();
        for (WebElement w:optionsList) {
            System.out.println(w.getText());
        }

        //lambda kullanarak yapalim ;
  //      optionsList.forEach(t-> System.out.println(t.getText()));

        //BU DA SORUNUN IKINCI YOLU
//        List<WebElement> allOptions= driver.findElements(By.xpath("//select[@id='state']//option"));
//        allOptions.forEach(t-> System.out.println(t.getText()));
    }
}
