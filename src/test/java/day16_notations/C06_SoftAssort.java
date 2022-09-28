package day16_notations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBaseBeforeAfterMethod;

public class C06_SoftAssort extends TestBaseBeforeAfterMethod {
    /*
    softassertion baslangic ve bitis satirlari arasindaki tum assertionleri yapip
    bitis satirina geldiginde bize buldugu tum hatalari rapor eder
     */


    @Test
    public void test1() {
        //softassert baslangici obje olusturmaktir
        SoftAssert softAssert= new SoftAssert();
        //1. amazon ana sayfasina gidelim
        driver.get("https://www.amazon.com");
        // 2. title'nin Amazon icerdigini test edin
        String expectedtitle="amazon";
        String actualTitle=driver.getTitle();
        softAssert.assertTrue(actualTitle.contains(expectedtitle),"title amazon icermiyor");
        // Arama kutusunun erisilebilir oldugunu testt edin
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        softAssert.assertTrue(aramaKutusu.isEnabled(),"arama kutusuna erisilemiyor");
        // Arama kutusuna nutella yazip aratin ve ara yapildini test edin
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        WebElement sonucYaziElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        softAssert.assertTrue(sonucYaziElementi.isDisplayed());
        // arama sonucunun Nutella icerdigini test edin
        softAssert.assertTrue(sonucYaziElementi.getText().contains("Kutella"),"sonuc yazisi Kutella icermiyor");

        // softAssert'e bitis satirirni soylemek icin assertAll() kullanilir
        // bu satir yazilamzsa assertion gorevi yapilmamis olur.
        softAssert.assertAll();
        /*
        SoftAssert'un hata bulsa bile calismaya devam etme ozelligi
        assertAll()'a kadardir.
        eger assertAll()'da failed rapor edilirse calisma durur ve class'in kalan kismi calistirilmaz
        (Yani asserAll hardAsserdeki her bir assert gibidir, hatayi yakalarsa calisma durur.)
         */
        System.out.println("assertionlarda hata varsa burasi calismaz");
    }
}
