package tests.day18_pom;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_ConfigRedearKullanimi {
    @Test
    public void test01() throws InterruptedException {
        FacebookPage facebookPage= new FacebookPage();
        // facebook anasayfasina gidin
       Driver.getDriver().get(ConfigReader.getProperty("facebookUrl"));

        // cikarsa cookies kabul edin
        facebookPage.cookieButton.click();
        Thread.sleep(3000);
        // kullanici mail kutusunua  yanlis kullanici isim yazdirin
        facebookPage.mailKutusu.sendKeys(ConfigReader.getProperty("fcWrongUserName"));
        // kullanici sifre kutusuna yanlis  password yazdirin
        facebookPage.passwordBox.sendKeys(ConfigReader.getProperty("fcWrongPassword"));

        Thread.sleep(3000);
        // login butonuna basin
        facebookPage.loginTusu.click();
        // giris yapilmadigini test edin
        Assert.assertTrue(facebookPage.girilmadiYaziElementi.isDisplayed());
        // sayfayi kapatin
        Driver.closeDriver();

    }
}
