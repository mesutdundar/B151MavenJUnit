package techproed.day07_Maven_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_JunitIlkTest {

    //right click + generate den hazir test methodu . setup, teardown methodu, before class ,after class methodlarini generate edebbiliriz
    //hangi testi once calistirmak istiyorsak test methodunun ismine gore siralama yapiyor.
    //yani once test01 sonra test02. ornegn once mesut01 sonra test02 yapsaydik mesut01 once calistirilirdi( classin tumu calistirilinca)
    @Test
    public void test01() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://techproeducation.com");
        driver.close();

    }

    @Test
    public void test02() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");
        driver.close();
    }

}
