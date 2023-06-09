package techproed.day09_DropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.time.Duration;

public class C01_DropDown extends TestBase {
     WebDriver driver;
    /*

    DropDown: Alt baslıkların oldugu acılır menu listesidir.

    DropDown 3 adımda handle edilir

    1-) DropDown locate edilmelidir

    2-) Select objesi olusturulmalıdır
    Select select = new Select(ddm)

   3-) Opsiyonlardan bir tanesi secilir
   -selectByVisibleText() ==> option'a görünür metin ile ulasmak icin kullanılır ==> genelde bu kullanilir!
   -selectByIndex() ==> optin'a ındex ile ulasmak icin kullanılır. (index 0 baslar)
   -selectByValue() ==> option'a value ile ulasmak icin kullanılır

     */

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        
    }

   // @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void test01() {
        // https://testcenter.techproeducation.com/index.php?page=dropdown sayfasına gidiniz
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        // Yıl Drodown'undan "2020" seciniz
        WebElement year = driver.findElement(By.id("year"));
        Select yearDropDown = new Select(year);
        ddmVisibleText(year,"2020"); // ==> reusubel method kullanarak yaptik Test Base classindaki !
//        yearDropDown.selectByVisibleText("2020");
//        yearDropDown.selectByIndex(3);
//        yearDropDown.selectByValue("2020");

        // Ay Dropdown'undan "August" seciniz
        WebElement month = driver.findElement(By.id("month"));
        Select monthDropDrown = new Select(month);
        monthDropDrown.selectByVisibleText("August");
        // Gün Dropdown'undan "5" seciniz
        WebElement day = driver.findElement(By.id("day"));
        Select dayDropDown = new Select(day);
        dayDropDown.selectByVisibleText("5");

    }
}
