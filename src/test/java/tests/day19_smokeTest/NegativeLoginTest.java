package tests.day19_smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class NegativeLoginTest {
    BrcPage brcPage;
    // 2) Bir Class olustur : PositiveTest
    // 3) Bir test method olustur positiveLoginTest()
    // https://www.bluerentalcars.com/ adresine git


    @Test
    public void test01() {
         brcPage= new BrcPage();
        // 2) Bir Class olustur : PositiveTest
        // 3) Bir test method olustur positiveLoginTest()
        // https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        // login butonuna bas
        brcPage.ilkLoginButton.click();

        // test data username:customer@bluerentalcars.com ,
        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcValidEmail"));

        // test data password : 12345
        brcPage.passwordTestBox.sendKeys(ConfigReader.getProperty("brcWrongPassword"));

        // Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        brcPage.ikinciLoginButton.click();

        //Degerleri girildiginde sayfaya basarli sekilde girilemedigi test et

        Assert.assertTrue(brcPage.ikinciLoginButton.isDisplayed());
        Driver.closeDriver();
    }
}
