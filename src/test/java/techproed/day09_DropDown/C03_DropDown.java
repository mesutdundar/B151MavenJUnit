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

import java.time.Duration;
import java.util.List;

public class C03_DropDown {
    private WebDriver driver;

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
        // Programlama Dili Dropdown'undan "Java" seciniz
        WebElement programingLangLocator = driver.findElement(By.xpath("//*[@name='Languages']"));
        Select selectOptionFromPL = new Select(programingLangLocator);
        selectOptionFromPL.selectByVisibleText("Java");
        // Programlama Dili Dropdown'undan son secilen option'un "Java" oldugunu test ediniz
        String selectedOFPLString = selectOptionFromPL.getFirstSelectedOption().getText();
        Assert.assertEquals("Java",selectedOFPLString);
        // Programlama Dili Dropdown'undaki tum optionları konsolda yazdırınız
        List<WebElement> allOptionsOfPLDD = selectOptionFromPL.getOptions();
        allOptionsOfPLDD.forEach(t-> System.out.println(t.getText()));
    }
}
