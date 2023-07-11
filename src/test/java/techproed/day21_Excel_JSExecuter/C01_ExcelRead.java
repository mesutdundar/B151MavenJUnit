package techproed.day21_Excel_JSExecuter;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C01_ExcelRead extends TestBase {
    @Test
    public void readExcelTest1() throws IOException {
        //3.satir 1.sutun degerini yazdirin
        String filePath = "src/test/java/resources/Capitals.xlsx";
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fis);
        String satir3Sutun1 = String.valueOf(workbook.getSheet("Sheet1").getRow(2).getCell(0));
        //String satir3Sutun1 =workbook.getSheet("Sheet1").getRow(2).getCell(0).toString(); bu sekilde de stringe cevirebiliriz
        System.out.println("satir3Sutun1 = " + satir3Sutun1);
        Assert.assertEquals("France", satir3Sutun1);

        //son satir sayisini bulunuz
        int sonSatirSayisi = workbook.getSheet("Sheet1").getLastRowNum();
        System.out.println("sonSatirSayisi = " + sonSatirSayisi);//index verdigi icin 10 aldik
        // Excel tablosundaki kullanılan satır sayısını getPhysicalNumberOfRows() methodu ile alabiliriz.

        //kullanilan satir sayisini bulunuz
        int kullanilanSatirSayisi = workbook.getSheet("Sheet1").getPhysicalNumberOfRows();//index olarak vermez
        System.out.println("kullanilanSatirSayisi = " + kullanilanSatirSayisi);
    }

    @Test
    public void readExcelTest2() throws IOException {
        //capitals dosyasindaki tum verileri yazdiriniz

        Map<String, String> capitalMap = new HashMap<>();
        //Capitals dosyasındaki tüm verileri koyabilecegimiz en uygun java objesi map'dir.

        String filePath = "src/test/java/resources/Capitals.xlsx";
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fis);
        int sonSatirSayisi = workbook.getSheet("Sheet1").getLastRowNum();
        for (int i = 0; i < sonSatirSayisi; i++) {
            String key = workbook.getSheet("Sheet1").getRow(i).getCell(0).toString();
            String value = workbook.getSheet("Sheet1").getRow(i).getCell(1).toString();
            capitalMap.put(key, value);
        }
        System.out.println(capitalMap);
        //{Greece=Athens, Canada=Ottowa, USA=D.C, Turkey=Ankara, COUNTRY=CAPITAL, Japan=Tokya, England=London, Italy=Rome, France=Paris, Germany=Berlin}
    }
}
