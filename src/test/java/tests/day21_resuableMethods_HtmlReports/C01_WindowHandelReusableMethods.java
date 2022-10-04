package tests.day21_resuableMethods_HtmlReports;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ResuableMethods;

import java.util.Set;

public class C01_WindowHandelReusableMethods {

    @Test
    public void test01() {
      //● https://the-internet.herokuapp.com/windows adresine gidin.
      Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
      String ilksayfaWH=Driver.getDriver().getWindowHandle();
        //● Click Here butonuna basın.
      Driver.getDriver().findElement(By.linkText("Click Here")).click();
      Set<String> windowHandeleSeti= Driver.getDriver().getWindowHandles();

      String ikinciSayfaWH="";
        for (String each:windowHandeleSeti
             ) {
            if (!each.equals(ilksayfaWH)){
                ikinciSayfaWH=each;
            }
        }
        Driver.getDriver().switchTo().window(ikinciSayfaWH);
        System.out.println(Driver.getDriver().getTitle());
        // acilan yeni tab'in title'nin "New Window" oldugunu test edin
        String expectedtitle="New Window";
        String actualTitle=Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle, expectedtitle);
        Driver.closeDriver();
    }

    @Test
    public void test02() {
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        String ilksayfaWH=Driver.getDriver().getWindowHandle();
        //● Click Here butonuna basın.
        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        // acilan yeni tab'in title'nin "New Window" oldugunu test edin
        ResuableMethods.switchToWindow("New Window");

        String expectedtitle="New Window";
        String actualTitle=Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle, expectedtitle);
        Driver.closeDriver();

    }
}
