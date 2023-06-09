package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions_DragDrop extends TestBase {
    @Test
    public void test01() {
//Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");
//And user moves the target element(Drag me to my target) in to  destination(Drop here
        //drag and drop elementleri iframe icinde oldugu icin once iframe gecis yapmamiz lazim
        driver.switchTo().frame(0);
        WebElement firstItemsLocator = driver.findElement(By.id("draggable"));
        WebElement secondItemsLocator = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(firstItemsLocator,secondItemsLocator).perform();
        bekle(3);
        /*
    Eğer bir hareketli webelementi tutup başka bir webelementin üzerine bırakmak istersek
    sürüklemek istediğimiz webelementin locate'ini alıp üzerine bırakacağımız webelementin
    lcoate'ini de alarak dragAndDrop(kaynak, hedef) methodu ile işlemi gerçekleştirebiliriz.
 */
    }

    @Test
    public void test02() {
        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");
        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
        /*
        drag ve drop webelementleri iframe içinde olduğu için iframe geçiş yapmalıyız
         */
        driver.switchTo().frame(0);
        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(drag).//-->Bu method ile webelemente mouse ile basılı tuttuk
                moveToElement(drop).//-->Bu method ile basılı tuttuğumuz we'ti diğer we'tin üzerine götürdük
                release().//-->Bu method ile basılı tuttuğumuz we'ti serbest bıraktık
                perform();//--> işlemi sonlandırdık


    }
    @Test
    public void test03() {
        //movetoofset() methodu ile koordinatlari yazip yukaridaki ayni islemleri yaabiliyoruz!
        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
    /*
    drag ve drop webelementleri iframe içinde olduğu için iframe geçiş yapmalıyız
     */
        driver.switchTo().frame(0);
        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(drag).
                moveByOffset(84,28).//-->Belirtmiş olduğumuz kordinatlara we'ti taşır
                release().perform();
        //        WebElement element = driver.findElement(By.xpath("//*[@id='droppable']"));
//        Rectangle rect = element.getRect();
//        int x = rect.getX();
//        int y = rect.getY();
//        System.out.println("X koordinatı: " + x);
//        System.out.println("Y koordinatı: " + y); webelementin yaklasik koordinatlari
    }
}
