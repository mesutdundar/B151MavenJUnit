package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public abstract class TestBase {
    //testbase class'indan obje olusturulmasinin onune gecilmesi icin abstract YAPABILIRIZ!(zorunluluk degil , secenek)
    //Bu class'a extends ettigimiz test classlarindan ulasabiliriz
    ////Testbase clasına extdends ettiğimiz test classlarından ulaşabiliriz.
   protected WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

      @After
    public void tearDown() throws Exception {
        driver.quit();
    }


/** Thread.sleep methodu */
    public void bekle (int saniye) {
        try {
            Thread.sleep(saniye *1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    /** Alert methodlari */
    public void alertAccept(){
        driver.switchTo().alert().accept();
    }
    public void alertDismiss(){
        driver.switchTo().alert().dismiss();
    }
    public void alertPrompt(String text){
        driver.switchTo().alert().sendKeys(text);
    }
    public void alertText(){
        System.out.println(driver.switchTo().alert().getText());
    }


    /** DropDownMenu methodlari */
    public void ddmVisibleText(WebElement ddm,String option){
        Select select = new Select(ddm);
         select.selectByVisibleText(option);
    }
    public void ddmIndex(WebElement ddm,int index){
        Select select =new Select(ddm);
        select.deselectByIndex(index);
    }
    public void ddmValue(WebElement ddm, String  option){
        Select select = new Select(ddm);
        select.selectByValue(option);
    }

    /** Explicit WebDriverWait  methodu */
    public void WebDriverWaitWithVisibility (WebElement locator , int beklemeSuresi){
        WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(beklemeSuresi));
        wait.until(ExpectedConditions.visibilityOf(locator));
    }

    /** Explicit Fluent Wait methoduyla bekletme (kontrol etme sikligini belirle!) */
    public void fluentWaitWithVisibility (int maxBekleme, int kontrolEtmeSikliigi,WebElement locator){
        Wait<WebDriver> wait = new FluentWait<>(driver).
                withTimeout(Duration.ofSeconds(maxBekleme)).//==> fluent wait icin max bekleme suresi
                        pollingEvery(Duration.ofSeconds(kontrolEtmeSikliigi)).//==> kac saniyede bir kac saniyede bir kontrol edeccegini belirler
                        withMessage("Ignore Exception");// ==> zorunlu degil , hata durumunda mesaj vermesi icin
        wait.until(ExpectedConditions.visibilityOf(locator));
    }
}
