package tests.day17_pom;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;

public class C03_PageClassKullanimi {
    @Test
    public void test01() {
        FacebookPage facebookPage= new FacebookPage();
        // facebook anasayfasina gidin
        Driver.getDriver().get("https://www.facebook.com");

        // cikarsa cookies kabul edin
        facebookPage.cookieButton.click();

        // kullanici mail kutusunua  rastgele bir isim yazdirin
        Faker faker= new Faker();
        facebookPage.mailKutusu.sendKeys(faker.internet().emailAddress());

        // kullanici sifre kutusuna rastgele bir password yazdirin
        facebookPage.passwordBox.sendKeys(faker.internet().password());

        // login butonuna basin
        facebookPage.loginBox.click();

        // giris yapilamadigini test edin.
        Assert.assertTrue(facebookPage.girilmadiYaziElementi.isDisplayed());
        Driver.closeDriver();
    }
}
