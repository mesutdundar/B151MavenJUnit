package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class TestBase {
    //testbase class'indan obje olusturulmasinin onune gecilmesi icin abstract YAPABILIRIZ!(zorunluluk degil , secenek)
    //Bu class'a extends ettigimiz test classlarindan ulasabiliriz
    ////Testbase clasına extdends ettiğimiz test classlarından ulaşabiliriz.
   protected WebDriver driver;
   protected ExtentReports extentReports; // ==> ExtentReports ==> raporlamayi baslatmak icin kullanilan class
   protected ExtentHtmlReporter extentHtmlReporter; // ==> ExtentHtml ==> raporlamayi HTML formatinda duzenler
   protected ExtentTest extentTest ; // ==> ExtentTest ==> Test adimlarina eklemek istedigimiz bilgileri bu class ile duzenleriz
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

      @After
    public void tearDown() throws Exception {
        extentReports =new ExtentReports();//(asagidakiyle berabaer kullanilir!!!!!!)
        extentReports.flush(); // extent report sonlandirma methodu. unutmayayim diye buraya koydum
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
    //SwitchTo Window-1
    public void switchToWindow(int index){
        List<String> pencereler = new  ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(pencereler.get(index));
    }
    //SwitchTo Window-2
    public void switchToWindow2(int index){
        driver.switchTo().window(driver.getWindowHandles().toArray()[index].toString());
    }

    /** FullScreen ScreenShot methodu ; */
    public void fullScreenScreenShot(){
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "src/test/java/techproed/TumSayfaResmi/screenShot" + tarih + ".jpeg";
        TakesScreenshot ts = (TakesScreenshot) driver;
        try {
            FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**WebElement Resmi (Webelement ScreenShot) */
    //WebElement Resmi (Webelement ScreenShot)
    public void webElementScreenShot(WebElement element){
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "src/test/java/techproed/ElementResmi/WEscreenShot" + tarih + ".jpeg";
        try {
            FileUtils.copyFile(element.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /**  UploadFile Robot Class  */
    public void uploadFilePath(String filePath) {
        try {
            bekle(3);
            StringSelection stringSelection = new StringSelection(filePath);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            bekle(3);
            robot.keyPress(KeyEvent.VK_V);
            bekle(3);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            bekle(3);
            robot.keyRelease(KeyEvent.VK_V);
            bekle(3);
            robot.keyPress(KeyEvent.VK_ENTER);
            bekle(3);
            robot.keyRelease(KeyEvent.VK_ENTER);
            bekle(3);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }
    /**  Extent Report methodu */
    public void extentReport(String browser,String reportName,String testerName){
        extentReports = new ExtentReports();
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "testOutput/extentReports/extentReport"+tarih+".html";
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extentReports.attachReporter(extentHtmlReporter);

        extentReports.setSystemInfo("Browser",browser);
        extentReports.setSystemInfo("Tester",testerName);
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName(reportName);
    }
    /** JavaScriptExecuter click*/
    public void click (WebElement element){
        try {
            element.click();
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();",element);
        }
    }
    /** JavaScriptExecuter scroll*/
    public void scroll(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",element);    }

    public void scrollHome (){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }
    public void scrollEnd(){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

    }
    public void sendKeysJS(WebElement element, String text){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='"+text+"'",element);

    }
    public void sendAttributeJS(WebElement element,String text){

        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value','"+text+"')",element);
    }
}
