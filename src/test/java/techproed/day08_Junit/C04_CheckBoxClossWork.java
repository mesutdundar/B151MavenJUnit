package techproed.day08_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_CheckBoxClossWork {
     WebDriver driver;


    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void checkBox() throws InterruptedException {
        // https://the-internet.herokuapp.com/checkboxes sayfasına gidin
// Checkbox1 ve checkbox2 elementlerini locate edin.
// Checkbox1 seçili değilse secin
// Checkbox2 seçili değilse secin
        driver.get("https://the-internet.herokuapp.com/checkboxes");
       WebElement checkBox1= driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
       WebElement checkBox2= driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
       //checkbox1 secili degil ise
        if (!checkBox1.isSelected()){
            checkBox1.click();
        }
        Thread.sleep(2000);
        if (!checkBox2.isSelected()){
            checkBox2.click();
        }
        Thread.sleep(2000);

    }
/*
    @Test @Ignore("Gereksiz")
    public void ignore() {
        driver.get("https://amazon.com");
        }
 */
    }

