package techproed.day15_FileExist_FileDownloadAndUpload;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FileExist {

    @Test
    public void fileExist() {
        System.out.println(System.getProperty("user.dir"));
        //icinde oldugumuz projenin dosya yolunu(path) verir ==> C :\javademos\B151MavenJUnit

        System.out.println(System.getProperty("user.home"));
        //Bilgisayarin ismini verir ==> C:\Users\Monster

        //Soru:
        // Desttop da bir text dosyasi olusturun
        //ve desktop da text dosyasinin olup olmadigini test edin

        /*
Selenium ile herhangi bir dosyanin inip inmedigini kontrol edemeyiz.
Selenium sadece web sayfasini kontrol eder windows uygulamalarini test edemez, bu sebeple java kullaniriz.
dosya mevcutlugunu java kontrol edebilir.
Selenium web sayfasina gidebilir, linke tiklayabilir, dosyayi indirebilir.
Dosya indigi anda Java dosyaya müdahale edebilir. Selenium edemez.
 */
        //"C:\Users\Monster\Desktop\text.txt"  ==> dosyanin dosya yolu= sag click + yol olarak kopyala
        Assert.assertTrue(Files.exists(Paths.get("C:\\Users\\Monster\\Desktop\\text.txt")));

        //bunu daha dinamik hale getirelim
        //C:\Users\Monster       \Desktop\text.txt
        String farkliKisim = System.getProperty("user.home");//bu kullanici ismini verir
        String ortakKisim = "\\Desktop\\text.txt";//herkesin pcde ortak olan kisim
        String dosyaYolu = farkliKisim+ortakKisim;//buda ikisinin birlesimi yani biz dosya yolunu bulup stringe assign ettigimizde bu kodu dinamik hale getirebiliriz babe

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        /*
dosanin,bilgisayarimda desktop'da olup olmadigini
Java ile test edecegim
Cunku selenium, web sayfalarini test eder.
Selenium,benim bilgisayarimdaki desktop'a mudahele edemez
 */


    }
}
