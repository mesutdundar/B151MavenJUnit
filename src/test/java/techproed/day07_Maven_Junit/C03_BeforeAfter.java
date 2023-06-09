package techproed.day07_Maven_Junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C03_BeforeAfter {
    @Before
    public void setUp() throws Exception {
        System.out.println("Her test methodu oncesi 1 kez calisir");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Her test methodundan sonra bir kere calisir!");
    }

    @Test
    public void test01() {
        System.out.println("ilk test");
    }

    @Test
    public void test02() {
        System.out.println("ikinci test");
    }
}
