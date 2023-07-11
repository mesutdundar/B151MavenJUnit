package techproed.day19_ExtentReport_WebTables;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_ExtentReport extends TestBase {
    /*
    EXTENTREPORT:
    1- ExtentReport(aventstack) kullanabilmek için öncelikle mvn adresinden 4.0.9 versiyon numaralı
dependency'i pom.xml dosyamıza ekleriz.
   2- ExtentReports class'ından class seviyeninde obje oluştururuz
   3- ExtentHtmlReporter class'ından class seviyeninde obje oluştururuz
   4- ExtentTest class'ından class seviyeninde obje oluştururuz
            */
    ExtentReports extentReports; // ==> ExtentReports ==> raporlamayi baslatmak icin kullanilan class
    ExtentHtmlReporter extentHtmlReporter; // ==> ExtentHtml ==> raporlamayi HTML formatinda duzenler
    ExtentTest extentTest ; // ==> ExtentTest ==> Test adimlarina eklemek istedigimiz bilgileri bu class ile duzenleriz
    @Test
    public void test01() {
    extentReports = new ExtentReports();
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "testOutput/extentReports/extentReport"+tarih+".html";
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extentReports.attachReporter(extentHtmlReporter);// HTML formatinda raporu baslatacak

        // raporda gozukmesini istediginiz bilgiler icin
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Tester","Mesut");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName("Smoke Test Report");
/*
    Testlerimiz bittiginde bizden bir rapor istenebilir. Karsimizdaki teknik terimleri bilmeyebilir ama Extent Class' larini kullanrak
    testle ilgili bilgileri rapora ekleyebiliriz
     */
        extentTest =extentReports.createTest("Extent Report","Test Raporu");
        //amazon sayfasina gidelim
        driver.get("https://www.amazon.com");
        extentTest.info("Amazon sayfasina gidildi");
    //başlığın Amazon içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("Amazon"));
       extentTest.info("basligin Amazon icerdigi test edildi");
        //arama kutusunda iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone" + Keys.ENTER);
       extentTest.info("arama kutusunda iphone aratildi");
//sonuc yazını konsola yazdıralım
        System.out.println(driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).getText());
       extentTest.pass("sonuc yazisi konsola yazdirildi");
       extentTest.pass("sayfa kapatildi");
       //pass methodu en son kullanilir!
        extentReports.flush(); // en son raporu sonlandirmak icin bu method kullanilir !!!!!!bu methodsuz rapor olusmaz!!


        /*
    extentTest objesi ile info() methodunu kullanarak her step'de ne yaptığımızla alakalı bilgi yazabiliriz
testimizin en sonunda testin bittiğini ifade eden pass() methodu ile testimiz ile alakalı son bilgiyi
ekleyebiliriz.
    Ve son olarak actions daki perform methodu gibi extentReport objesi ile flush() methodu kullanarak
raporu sonlandırırız
 */
    }
}
