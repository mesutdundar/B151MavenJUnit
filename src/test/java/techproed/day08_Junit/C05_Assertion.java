package techproed.day08_Junit;

import com.beust.ah.A;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_Assertion {
    // 4 tane test methodu olusturun
WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com"); //hepsinde amazon sayfasina gitmemizi istedigi icin buraya aldim :)
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }




    @Test
    public void test01() {
        // test01
// https://amazon.com sayfasına gidin ==> Before annotationi ile gidiyor
// sayfa baslıgının "Amazon" kelimesini icerdigini test edin
        String actuelTitle =driver.getTitle();
        String expectedTitle ="Amazon";
        Assert.assertTrue(actuelTitle.contains(expectedTitle));

    }


    @Test
    public void test02() {
        // test02
// https://amazon.com sayfasına gidin==> Before annotationi ile gidiyor
// Amazon resminin görüntülendiğini (isDisplayed()) test edin
    WebElement amazonLogo = driver.findElement(By.id("nav-logo-sprites"));
    Assert.assertTrue(amazonLogo.isDisplayed());
    }

    @Test
    public void test03() {
        // test03
// https://amazon.com sayfasına gidin
// arama kutusunun erisilebilir oldugunu test edin
   WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
   Assert.assertTrue(searchBox.isEnabled());

    }

    @Test
    public void test04() {
        // test04
// https://amazon.com sayfasına gidin
// sayfa baslıgının "kitap" icermedigini test edin
        String actuelTitle =driver.getTitle();
        Assert.assertFalse(actuelTitle.contains("kitap"));


    }
}
