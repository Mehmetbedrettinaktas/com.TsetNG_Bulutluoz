package tests.day16_notations;

import org.testng.annotations.Test;
import utilities.TestBaseBeforeAfterMethod;

public class C03_Priority extends TestBaseBeforeAfterMethod {
    /*
    TestNG test methodlarini isim sirasina gore calistirir
    Eger isim siralamasinin disinda bir siralama ile calismasini isterseniz
    o zaman test method'larina oncelik(priority) tanimlayabiliriz

    priority kucukten buyuye gore calisir eger bir test method'una priority
    degeri atanamamissa default olarak priority=0 kabul edilir.
     */
    @Test(priority = -5)
    public void amazonTest() {
        driver.get("https://www.amazon.com");

    }

    @Test(groups = "grup1")
    public void test02() {
        driver.get("https://www.bestbuy.com");
    }

    @Test
    public void techprotesti() {
        driver.get("https://www.techproeducation.com");
    }
}
