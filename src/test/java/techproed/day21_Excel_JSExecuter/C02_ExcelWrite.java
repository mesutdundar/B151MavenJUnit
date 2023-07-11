package techproed.day21_Excel_JSExecuter;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_ExcelWrite extends TestBase {
    @Test
    public void excelWriteTest1() throws IOException {
        //bir nufus sutunu olusturun
        //EXCEL ILE ILGILENIYORSAK BU 3 ADIM STABILDIR
//------------------------------------------
//Excel dosyasindan veri okuyabilmemiz icin;
//1. Dosya yolunu aliriz
        String dosyaYolu = "src/test/java/resources/Capitals.xlsx";

//dosyayi okuyabilmek icin akisa aliriz yani stream kullanilir.
//2. Capitals dosyasini bizim sistemimize getirmeliyiz yani input etmeliyiz
        FileInputStream fis = new FileInputStream(dosyaYolu);

//3. Dosyayi Workbook'a atamaliyiz. Java ortaminda bir excel dosyaasi olusturmaliyiz
        Workbook workbook = WorkbookFactory.create(fis);


        workbook.getSheet("Sheet1").getRow(0).createCell(2).setCellValue("NUFUS");

        //nufus bilgileri gir :
        // Bir "Nüfus" sütunu olusturun
// baskent nufuslarını excel dosyasına yazınız.
// (D.C: 1000, Paris:1100, London:1200, Ankara:1300)
        workbook.getSheet("Sheet1").getRow(1).createCell(2).setCellValue("1100");
        workbook.getSheet("Sheet1").getRow(2).createCell(2).setCellValue(1300);
        workbook.getSheet("Sheet1").getRow(3).createCell(2).setCellValue(1500);
        workbook.getSheet("Sheet1").getRow(4).createCell(2).setCellValue(1200);

        //Excel'de bir hucre olusturmak icin "createCell()" methodu kullanilir.
        //Hucre icine yazdiracagimiz deger icin "setCellValue()" methodu kullanilir


        FileOutputStream fos = new FileOutputStream(dosyaYolu);
        //Datalari bizim class'imizdan Capitals dosyasina gonderecegiz bunun icin "FileOutputStream" objesi olusturmamiz gerekir
        workbook.write(fos);
        //workbook'ta yazdigiiz degisikligi fos'a yaz
    }
}
