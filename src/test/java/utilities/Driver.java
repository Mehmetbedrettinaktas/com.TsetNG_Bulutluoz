package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {
    /*
    POM'de Driver icin TastBase class'ina extends etmek yerine Driver
    class'indan static method'lar kullanarak driver olusturup,
    ilgili ayarlarin yapilmasi ve en sonunda driver'in
    kapatilmasi tercih edilmistir.

    POM'de Driver class'indaki getDriver()'nin obje olusturularak kullanilmasini
    engellemek icin Singleton pattern kullanimi benimsenmistir.

    Singleton Pattern : tekil kullanim, bir class'in farkli class'lardan obje
    olusturularak kullanimini engellemek icin kullanilir.

    Bunu saglamak icin yapmamiz gereken sey oldukca basit obje olusturmak icin
    kullanilan constractor'i private yaptigimizda baska classlarda
    Driver class'indan obje olusturlmasi mumkun olmaz.
    */
    private Driver(){

    }
    static WebDriver driver;

    public static WebDriver getDriver() {

        if (driver==null) {
            switch (ConfigReader.getProperty("browser")){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "opera":
                    WebDriverManager.safaridriver().setup();
                    driver=new SafariDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                case "headless-chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();

            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;
    }

    public static void closeDriver() { // driver'a deger atanmissa
        if (driver!=null) {
            driver.close();
            driver = null;
        }

    }
}
