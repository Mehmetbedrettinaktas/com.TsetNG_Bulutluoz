package day16_notations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.TestBaseBeforeAfterMethod;

public class C02_BeforeClass_AfterClass extends TestBaseBeforeAfterMethod {
    // JUnit'te @BeforeClass ve @AfterClass notasyonuna sahip methodlar static olmak zorundaydi
    // TestNG bu ZORUNLULUK 'tan bizi kurtari

    /*
    TestNG bize daha fazla before ve after  notasyonlari sunar diger
    before/after notasyonlari tanimlayacagimiz grup, test veya
    sut'den once ve sonra calisirlar ileride xml dosyalari ile birlikte bunu gorecegiz.
     */
    @BeforeClass
    public void beforeClassMethod(){
        System.out.println("before class");
    }
    @AfterClass
    public void afterClassMethod(){
        System.out.println("After class");
    }
    @Test
    public void amazonTest() {
        driver.get("https://www.amazon.com");

        System.out.println(driver.getCurrentUrl());
    }

    @Test
    public void test02() {
        driver.get("https://www.bestbuy.com");
        System.out.println(driver.getCurrentUrl());
    }

    @Test
    public void techprotesti() {
        driver.get("https://www.techproeducation.com");
        System.out.println(driver.getCurrentUrl());
    }
}
