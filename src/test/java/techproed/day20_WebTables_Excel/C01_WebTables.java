package techproed.day20_WebTables_Excel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C01_WebTables extends TestBase {
   /* <table> tagı ile başlar
    <thead> başlıklar için bu tag ile devam eder
    <tr> başlıkların satırı
    <th> table head sütun
    <td> başlıktaki veriler
    <tbody> başlıklar altındaki verileri temsil eder
    <tr> table row(satır)
    <td> table data (tablodaki veri) */

    @Test
    public void webTablesTest1() {
        //    https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");
//    Task 1 : Table1’i yazdırın
        WebElement table1 = driver.findElement(By.xpath("//table[1]"));
        System.out.println(table1.getText());
        System.out.printf("%-10s %-10s %-25s %-10s %-30s %s%n", "Last Name", "First Name", "Email", "Due", "Web Site", "Action");
        System.out.printf("---------- ---------- ------------------------- ---------- ------------------------------ -------%n");
        System.out.printf("%-10s %-10s %-25s $%-9.2f %-30s %s%n", "Smith", "John", "jsmith@gmail.com", 50.0, "http://www.jsmith.com", "edit delete");
        System.out.printf("%-10s %-10s %-25s $%-9.2f %-30s %s%n", "Bach", "Frank", "fbach@yahoo.com", 51.0, "http://www.frank.com", "edit delete");
        System.out.printf("%-10s %-10s %-25s $%-9.2f %-30s %s%n", "Doe", "Jason", "jdoe@hotmail.com", 100.0, "http://www.jdoe.com", "edit delete");
        System.out.printf("%-10s %-10s %-25s $%-9.2f %-30s %s%n", "Conway", "Tim", "tconway@earthlink.net", 50.0, "http://www.timconway.com", "edit delete");

    }


    @Test
    public void webTablesTest2() {
        //    https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");
        //    Task 2 : 3. Satır verilerini yazdırın
       List<WebElement> webElementList = driver.findElements(By.xpath("//table[1]//tbody//tr[3]//td"));
        webElementList.forEach(t-> System.out.print(t.getText() + "-"));
    }

    @Test
    public void webTablesTest3() {
        //    https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");
        //    Task 3 : Son satırın verilerini yazdırın
       List<WebElement> webElementList1 = driver.findElements(By.xpath("//table[1]//tbody//tr[last()]//td"));
       webElementList1.forEach(t-> System.out.print(t.getText()+"-"));
    }

    @Test
    public void webTablesTest4() {
        //    https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");
        //    Task 4 : 5. Sütun basligini yazdırın
        WebElement besinciSutunBasligi = driver.findElement(By.xpath("//table[1]//thead//tr[1]//th[5]"));
        System.out.println(besinciSutunBasligi.getText());
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");

        // 5.Sütun verilerini yazdırın
        List<WebElement> besinciSutunVerileri = driver.findElements(By.xpath("//table[1]//tbody//tr//td[5]"));
        besinciSutunVerileri.forEach(t-> System.out.println(t.getText()));
    }

    @Test
    public void webTablesTest5() {

        //  https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");

        // iki parametreli bir java methodu olusturalım
        // Parametre 1 => satır numarasını
        // Parametre 2 => sutun numarası

        // prinData(2,3) ==> 2. satır, 3. sutundaki veriyi yazdırın​

        printData(2,3);
        printData(2,5);
        printData(3,2);
        // printData(1,7); 7. sutun olmadıgı icin NoSuchElementException hatası alırız


    }


    public void printData(int satir, int sutun) {

        WebElement satirSutun = driver.findElement(By.xpath("//table[1]//tbody//tr["+satir+"]//td["+sutun+"]"));

        System.out.println(satirSutun.getText());

    }
}

