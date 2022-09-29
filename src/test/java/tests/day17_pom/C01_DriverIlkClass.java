package tests.day17_pom;

import org.testng.annotations.Test;
import utilities.Driver;

public class C01_DriverIlkClass {
    @Test
    public void test01() {
        Driver.getDriver().get("https://www.amazon.com");

        /*
        Bugune kadar TastBase class'ina extends ederek kullandigimiz driver yerine
        bundan sonra Driver class'indan Kullanacagimiz getDriver static method'unu kullanacagiz.

        Driver.getDriver()  in
        driver              out
        */
        Driver.getDriver().get("https://www.bestbuy.com");
        Driver.getDriver().get("https://www.facebook.com");

        Driver.closeDriver();
    }
}
