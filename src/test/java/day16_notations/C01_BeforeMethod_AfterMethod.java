package day16_notations;

import org.testng.annotations.Test;

import utilities.TestBaseBeforeAfterMethod;


public class C01_BeforeMethod_AfterMethod extends TestBaseBeforeAfterMethod {
    //@BeforeMethod ve @AfterMetyhod notasyonlari  JUnit'deki @Before ve @After gibidir
    // her test method'undan once ve sonra calisirlar.
    @Test
    public void amazonTest() {
        driver.get("https://www.amazon.com");

    }

    @Test
    public void test02() {
        driver.get("https://www.bestbuy.com");
    }

    @Test
    public void techprotesti() {
        driver.get("https://www.techproeducation.com");
    }
}
