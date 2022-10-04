package tests.day21_resuableMethods_HtmlReports;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_PozitiveLoginTestiRaporlu {
    BrcPage brcPage= new BrcPage();
    @Test
    public void test01() {
      /* bunu kullanamiyoruz Singleton Pattern den dolayi

        Driver obj= new Driver();
        obj.getDriver().get(ConfigReader.getProperty("amazonUrl"));
       */

        // 2) Bir Class olustur : PositiveTest
        // 3) Bir test method olustur positiveLoginTest()
        // https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        // login butonuna bas
        brcPage.ilkLoginButton.click();

        // test data username:customer@bluerentalcars.com ,
        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcValidEmail"));

        // test data password : 12345
        brcPage.passwordTestBox.sendKeys(ConfigReader.getProperty("brcValidPassword"));

        // Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        brcPage.ikinciLoginButton.click();

        //Degerleri girildiginde sayfaya basarli sekilde girilebildigini test et

        String actualUserName=brcPage.kullaniciProfilIsmi.getText();
        String expectedUserName= ConfigReader.getProperty("brcValidUserName");
        Assert.assertEquals(actualUserName,expectedUserName);
        Driver.closeDriver();


    }
}
