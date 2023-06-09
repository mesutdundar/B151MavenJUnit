package techproed.day06_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_MavenIlkTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
       // https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");
//        arama kutusunu locate edelim
        WebElement searchBox =driver.findElement(By.cssSelector("input#twotabsearchtextbox"));

//        “Samsung headphones” ile arama yapalim
        searchBox.sendKeys("Samsung headphoes");
        searchBox.submit();
//        Bulunan sonuc sayisini yazdiralim
        WebElement sonucYazisi = driver.findElement(By.xpath("//span[text()='1-16 of 201 results for']"));//ama bu basligi kullanaraklocate almak mantikli degil cunu urun sayisi degistigi icin bulamaz 202 olunca mesela!
        String sonucSayisi[]=sonucYazisi.getText().split(" ");
        System.out.println("sonucSayisi = " + sonucSayisi[2]);


//        Ilk urunu tiklayalim
    //bu benim yaptigi
       // driver.findElement(By.xpath("(//*[@class='s-image'])[1]")).click();
        driver.findElement(By.xpath("(//h2//a)[1]")).click(); ; //==> bu da hocanin yaptigi

//        Sayfadaki tum basliklari yazdiralim
// birden fazla tag secmek istiyorsak   |   bunu kullaniriz(bir tane , javadaki veyanin tek kullanilani )
     List<WebElement> sayfaBasliklari = driver.findElements(By.xpath("//h1|//h2"));
     sayfaBasliklari.forEach(t-> System.out.println(t.getText()));
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&");

//     //ana sayfadaki todays deal customer service registy gift cars sell basliklarini alalim
       //once ana sayfaya geri donmemiz gerekiyor
       driver.findElement(By.id("nav-logo-sprites")).click();
       List<WebElement>homePageHeaders = driver.findElements(By.xpath("(//*[@class='nav-a  '])[1] | (//*[@class='nav-a  '])[2] |  (//*[@class='nav-a  '])[3] | (//*[@class='nav-a  '])[4] |(//*[@class='nav-a  '])[5]"));
        homePageHeaders.forEach(t-> System.out.println(t.getText()));
  }
}
