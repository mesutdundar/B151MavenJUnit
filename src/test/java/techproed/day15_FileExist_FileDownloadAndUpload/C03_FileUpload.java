package techproed.day15_FileExist_FileDownloadAndUpload;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_FileUpload extends TestBase {
    @Test
    public void fileUpload() {
        // masaustunde bir deneme dosyası olusturun
        //olusturduk
        // 'https://the-internet.herokuapp.com/upload' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/upload");
            //"C:\\Users\\Monster  \\Desktop\\text.txt"
        String differentPart =System.getProperty("user.home");
        String commonPart = "\\Desktop\\text.txt";
        String filePath = differentPart+commonPart;
        // 'Dosya Seç' kısmına deneme dosyasını yükleyiniz
        WebElement chooseFileButtonLocator = driver.findElement(By.id("file-upload"));
        chooseFileButtonLocator.sendKeys(filePath);// sendKeys() methodu ile dosyayi lcoate ettigimiz yere yukledik!

        // 'Upload' butonuna basın
        driver.findElement(By.id("file-submit")).click();
        bekle(2);
        // 'File Uploaded!' yazısının goruntulendigini test edin
        WebElement fileUploadedTextsLocator =driver.findElement(By.xpath("//h3[text()='File Uploaded!']"));
        Assert.assertTrue(fileUploadedTextsLocator.isDisplayed());
    }
}
