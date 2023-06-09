package techproed.day11_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C03_WindowHandle extends TestBase {




    @Test
    public void windowHandle() {
        //  https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        /*
        tecproeducation websayfasinin handle degerini getWindowHandle() methodu ile elde edebiliriz.
         */
       String techproWindowHandle =  driver.getWindowHandle();
        System.out.println("TECPRO HANDLE = "+techproWindowHandle);
        //  Title'ın "Techpro Education | Online It Courses & Bootcamps" olduğunu test edin
       String actualTitle = driver.getTitle();
       String expectedTitle = "Techpro Education | Online It Courses & Bootcamps";
        Assert.assertEquals(expectedTitle,actualTitle);

        //  Yeni bir pencere acıp,  https://www.youtube.com sayfasına gidiniz
        driver.switchTo().newWindow(WindowType.WINDOW); // yeni bir pencereye driver'i tasir.
        driver.get("htpps://www.youtube.com");
       String youtubeWindowHandle =  driver.getWindowHandle();

        //  Yeni bir pencere acıp, https://www.linkedin.com sayfasına gidiniz
        driver.switchTo().newWindow(WindowType.WINDOW);
        //WindowType.TAB ==> yeni sekmeler (tablar) acar .
        driver.get("https://www.linkedin.com");
       String linkedInWindowHandle = driver.getWindowHandle();

        //  techproeducation sayfasına geçiniz
        driver.switchTo().window(techproWindowHandle);
        bekle(3);

        //  youtube sayfasına geçiniz
        driver.switchTo().window(youtubeWindowHandle);
        bekle(3);

        //  linkedIn sayfasına geçiniz:
        driver.switchTo().window(linkedInWindowHandle);
        bekle(2);


    }
}
