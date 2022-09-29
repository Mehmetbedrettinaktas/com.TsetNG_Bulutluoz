package tests.day16_notations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TastBaseBeforeClassAfterClass;
import utilities.TestBaseBeforeAfterMethod;

import java.nio.file.WatchEvent;

import static org.testng.TestRunner.PriorityWeight.dependsOnMethods;

public class C04_DependsOnMethods extends TastBaseBeforeClassAfterClass {

// dependsOnMethods bagli demek asagidaki test02 test01 baglidir, test03 de test02 baglidir
    // yani test01 calismazsa hicbiri calismaz. dependsOnMethods siralamaya karismaz
    /*
    DependsOnMethods test methodlarin calisma siralamasina hic karismaz
    sadece bagli olan test, baglandig testin sonucuna bakar
    baglandigi test PASSED olamzsa, baglanan test hic calismaz(ignore) .
     */
    @Test
    public void test01() {
        driver.get("https://www.amazon.com");
    }

    @Test(dependsOnMethods = "test01",priority = 0) // test02 test01'e bagli
    public void test02() {
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
    }
    @Test(dependsOnMethods="test02") // test03 test02'e baglidir
    public void test03() {
        // sonuc yazisinin Nutella icerdigini test edelim
        WebElement sonucyaziElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(sonucyaziElementi.getText().contains("Nutella"));
    }
}
