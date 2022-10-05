package tests.day22_cross_Browser;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_DataProvider {



    @Test
    public void test01() {
        AmazonPage amazonPage= new AmazonPage();
        // amazon anasayfasina gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        // nutella icin arama yapalim
        amazonPage.aramaKutusu.sendKeys("Nutella", Keys.ENTER);
        // sonuclarin nutella icerdigini test edin
        String expectedKelime="Nutella";
        String actualSonucYazisi=amazonPage.aramaSonucuElementi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));

        // sayfayi kapatin
        Driver.closeDriver();
    }

    @DataProvider
    public static Object[][] AranacakKelimeler() {

        Object[][] arananKelimeArrayi={{"Nutella"},{"Java"},{"Cidem"},{"Netherlands"}};
        return arananKelimeArrayi;

    }


    @Test(dataProvider = "AranacakKelimeler")
    //arayacagiz kelimeleri bir liste gibi tutup bana yollayacak bir veri saglayicisi olusturacagiz
    public void dataProviderTest(String arananKelime) {
        AmazonPage amazonPage= new AmazonPage();
        // amazon anasayfasina gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        // Nutella, Java, cidem ve Netherlands icin arama yapalim
        amazonPage.aramaKutusu.sendKeys(arananKelime, Keys.ENTER);

        // sonuclarin aradigimiz kelime icerdigini test edelim
        String expectedKelime=arananKelime;
        String actualSonucYazisi=amazonPage.aramaSonucuElementi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));
        // sayfayi kapatin
        Driver.closeDriver();

    }
}
