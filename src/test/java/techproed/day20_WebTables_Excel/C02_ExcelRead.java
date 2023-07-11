package techproed.day20_WebTables_Excel;
import org.apache.poi.ss.usermodel.*;
import org.junit.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ExcelRead {
    @Test
    public void excelReadTest1() throws IOException {
        //excel dosyasindan veri okuyabilmemiz icin ;

        //1- dosya yolunu aliriz
        String filePath = "src/test/java/resources/Capitals.xlsx";

        //2-Capital dosyasini bizim sistemimize getirmeliyiz.Dosyayi okuyabilmemiz icin akisa almaliyiz
        FileInputStream fis = new FileInputStream(filePath);

        //3- Dosyayi workbook'a atamaliyiz
        Workbook workbook = WorkbookFactory.create(fis);

        //4-sayfayi(sheet) secmeliyiz
        Sheet sheet = workbook.getSheet("sheet1");

        //5- satiri(row) secmeliyiz
        Row row = sheet.getRow(0); //excelde index 0 dan baslar

        //6- hucreyi(cell) semeliyiz
        Cell cell = row.getCell(0);
    }

    @Test
    public void readExcelTest2() throws IOException {
        //KISA YOL !!!!!!!
        //birinci satir birinci sutunu bilgiyi yazdir
        String filePath = "src/test/java/resources/Capitals.xlsx";
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fis);
       String satir1Sutun1 =  workbook.getSheet("sheet1").getRow(0).getCell(0).toString();//indexin 0dan basladigini unutma!
        System.out.println(satir1Sutun1);
    }

    @Test
    public void readExcelTest3() throws IOException {
        //1.satir 2.sutundaki hucreyi yazdir!
        String filePath = "src/test/java/resources/Capitals.xlsx";
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fis);
        String satir1Sutun2 =  workbook.getSheet("sheet1").getRow(0).getCell(1).toString();
        System.out.println(satir1Sutun2);
    }
}




