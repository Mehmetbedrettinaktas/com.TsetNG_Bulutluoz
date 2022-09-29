package tests.day17_pom;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C02_PageClassKullanimi {
    AmazonPage amazonPage= new AmazonPage();
    @Test
    public void test01() {

        // amazona gidelim
        Driver.getDriver().get("https://www.amazon.com");
        // nutella aratalim
        amazonPage.aramaKutusu.sendKeys("Nutella", Keys.ENTER);
        // sonuc yazisinin nutella icerdigini test edelim
        String actualSonuc=amazonPage.aramaSonucuElementi.getText();
        String arananKelime="Nutella";
        Assert.assertTrue(actualSonuc.contains(arananKelime));
        Driver.closeDriver();

    }
}
