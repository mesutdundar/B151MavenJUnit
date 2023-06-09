package techproed.day14_Actions_Faker;

import com.github.javafaker.Faker;
import org.junit.Test;
import utilities.TestBase;

public class C04_Faker  {
        /*
        Faker class'indan sahte verileri kullanabilmek icin obje olusturmamiz gerekir
         */
    @Test
    public void faker() {
        Faker faker = new Faker();

        //faker objesini kullanarak bir isim yazdiriniz
        System.out.println(faker.name().firstName());
        //faker objesini kullanarak bir lastName yazdiralim
        System.out.println(faker.name().lastName());
        //faker objesini kullanarak bir fullName yazdiralim
        System.out.println(faker.name().fullName());
        //faker objesini kullanarak bir adress yazdiralim
        System.out.println(faker.address().fullAddress());
        //faker objesini kullanarak bir tel_no yazdiralim
        System.out.println(faker.phoneNumber().cellPhone());
        //harrypotter characteri yazdir
        System.out.println(faker.harryPotter().character());
        //rastgele 15 haneli bir numara yazdiralim
        System.out.println(faker.number().digits(15));


    }
}
