package tests.day16_notations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseBeforeAfterMethod;

public class C05_Assertions extends TestBaseBeforeAfterMethod {
    @Test(groups = "grup2")
    public void test1() {
        //1. amazon ana sayfasina gidelim
        driver.get("https://www.amazon.com");
        // 2. title'nin Amazon icerdigini test edin
        String expectedtitle="Amazon";
        String actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedtitle));
        // Arama kutusunun erisilebilir oldugunu testt edin
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue(aramaKutusu.isEnabled());
        // Arama kutusuna nutella yazip aratin ve ara yapildini test edin
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        WebElement sonucYaziElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
      Assert.assertTrue(sonucYaziElementi.isDisplayed());
        // arama sonucunun Nutella icerdigini test edin
      Assert.assertTrue(sonucYaziElementi.getText().contains("Nutella"));
    }
}
