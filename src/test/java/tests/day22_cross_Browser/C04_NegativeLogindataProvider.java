package tests.day22_cross_Browser;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_NegativeLogindataProvider  {

    BrcPage brcPage;

    @DataProvider
    public static Object[][] kullaniciListesi() {
        Object [][] kullaniciBilgileri={{"firuze@nehaber.com","54678"},{"murat@benbuisibilirim.com","65483"},
                {"ilyas@hollandadanselam.com","7645398"}};
        return kullaniciBilgileri;
    }
    // 2) Bir Class olustur : PositiveTest
    // 3) Bir test method olustur positiveLoginTest()
    // https://www.bluerentalcars.com/ adresine git


    @Test(dataProvider="kullaniciListesi")
    public void yanlisSifre(String userEmail, String password) throws InterruptedException {
        brcPage= new BrcPage();
        // 2) Bir Class olustur : PositiveTest
        // 3) Bir test method olustur positiveLoginTest()
        // https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        Thread.sleep(3000);
        // login butonuna bas
        brcPage.ilkLoginButton.click();

        // test data user email: dataprovider 'dan alalim,
        brcPage.emailTextBox.sendKeys(userEmail);

        // test data password : dataprovider'dan alalim
        brcPage.passwordTestBox.sendKeys(password);

        // Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        brcPage.ikinciLoginButton.click();

        //Degerleri girildiginde sayfaya basarli sekilde girilemedigi test et

        Assert.assertTrue(brcPage.ikinciLoginButton.isDisplayed());
        Driver.closeDriver();
    }

}
