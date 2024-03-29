package techproed.day08_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeClassAfterClass {
    WebDriver driver;
    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Amazon Testi Baslatildi.");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Amazon Testi Sonuclandi");
    }

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void test01() {
      //  driver.get("https://www.amazon.com");her iki testtede kullanndigimiz icin before annotationina koyduk
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("samsung"+ Keys.ENTER);
    }

    @Test
    public void test02() {
       // driver.navigate().to("https://www.amazon.com");her iki testtede kullanndigimiz icin before annotationina koyduk
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone"+ Keys.ENTER);
    }
}
