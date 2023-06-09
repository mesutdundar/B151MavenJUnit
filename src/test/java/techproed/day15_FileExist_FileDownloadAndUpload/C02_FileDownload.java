package techproed.day15_FileExist_FileDownloadAndUpload;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDownload extends TestBase {
    @Test
    public void fileDownload() {
        //"https://testcenter.techproeducation.com/index.php?page=file-download"   adresine gidin
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");

        File silinecekDosya = new File("C:\\Users\\Monster\\Downloads\\b10 all test cases, code.docx");// ilk adimda sayet bu dosya varsa
        silinecekDosya.delete();
        //"b10 all test cases" dosyasını indirin
        driver.findElement(By.xpath("//a[text()='b10 all test cases, code.docx']")).click();
        bekle(3);
        // Dosyanın başarıyla indirilip indirilmediğini test edin.
        String filePath = "C:\\Users\\Monster\\Downloads\\b10 all test cases, code.docx";//bastaki ve sondaki ekstra slashlari sil yoksa fil veriyor!
        Assert.assertTrue(Files.exists(Paths.get(filePath)));

        /*
 File silinecekDosya=new File("/Users/Monster/Downloads/b10 all test cases, code.docx") ;
silinecekDosya.delete();

Eğer  localinizden otomasyon ile dosya silmek için File class ından obje oluşturup dosya yolunu içine yerleştiririz.
 Ve oluşturduğumuz obje ile delete() methodunu kullanarak silebiliriz.
 Bunu yapma sebebimiz test classımızı çalıştırmada yeni bir dosya indireceği için oradaki dosya kalabalığını önlemiş oluruz
 Aynı zamananda doğrulama yaparken işimizi garantiye almış oluyoruz
 Aynı isimde birden fazla dosya indirmiş olsakta her indirilenin yanına index vereceği için ve bizim ilk indirdiğimiz
 o klasörün içinde bulamayacağı için her zaman ilk dosyanın varlığını böylelikle test etmiş oluruz

 */
    }
}
