package techproed.day17_Exception;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;



public class C03_NullPointerException  {

    /*
    NullPointerException
    Degisken ya da obje olusturup bu degiskene atama yapmadigimizda ya da esitlemedigimizda
    NullPointerException hatasi aliriz.

     */
    WebDriver driver;
    Faker faker;
    Actions actions;
    Integer sayi;
    String isim;

    @Test
    public void NullPointerException1() {
        //driver = new ChromeDriver(); atamasini yapmadigimiz icin NullPointerException hatasini aldik
        //TestBase'den de alabilirdi ancak extends yapmadik
        driver.get("https://amazon.com");

    }

    @Test
    public void NullPointerException2() {
        System.out.println(faker.name().firstName());
        //faker= new Faker(); atamasini yapmadigimiz icin NullPointerException hatasini aldik

    }

    @Test
    public void NullPointerException3() {
        System.out.println(sayi + 5);
    }

    @Test
    public void NullPointerExceptionTest4() {
        // sayi=6; sayi degiskenine atama yapmadıgımız icin NullPointerException hatası aldık.
        System.out.println(sayi+5);

    }

    @Test
    public void NullPointerException5() {

        //isim="Esma"; isim degiskenine atama yapilmadigi icin NullPointerException hatasini aldik
        System.out.println(isim.charAt(0));
    }
}