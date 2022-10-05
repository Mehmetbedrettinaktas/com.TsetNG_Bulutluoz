package tests.day21_resuableMethods_HtmlReports;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRepor;

public class C03_PozitiveLoginTestiRaporlu extends TestBaseRepor {
    BrcPage brcPage= new BrcPage();
    @Test
    public void test01() {
        extentTest=extentReports.createTest("Pozitif Login","Gecerli username ve sifre ile giris yapilabilmeli");
      /* bunu kullanamiyoruz Singleton Pattern den dolayi

        Driver obj= new Driver();
        obj.getDriver().get(ConfigReader.getProperty("amazonUrl"));
       */

        // 2) Bir Class olustur : PositiveTest
        // 3) Bir test method olustur positiveLoginTest()
        // https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        extentTest.info("Brc anasayfasina gidildi");
        // login butonuna bas
        brcPage.ilkLoginButton.click();
        extentTest.info("login buttonuna tiklandi");
        // test data username:customer@bluerentalcars.com ,
        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcValidEmail"));
        extentTest.info("Gecerli email yazildi");
        // test data password : 12345
        brcPage.passwordTestBox.sendKeys(ConfigReader.getProperty("brcValidPassword"));
        extentTest.info("Gecerli password yazildi");
        // Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        brcPage.ikinciLoginButton.click();
        extentTest.info("login buttonuna basildi");
        //Degerleri girildiginde sayfaya basarli sekilde girilebildigini test et

        String actualUserName=brcPage.kullaniciProfilIsmi.getText();
        String expectedUserName= ConfigReader.getProperty("brcValidUserName");
        Assert.assertEquals(actualUserName,expectedUserName);
        extentTest.pass("Kullanici basarli sekilde giris yapildi");
        Driver.closeDriver();


    }
}
