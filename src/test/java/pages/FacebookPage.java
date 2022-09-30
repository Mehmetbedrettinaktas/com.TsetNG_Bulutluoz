package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {

  public   FacebookPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(xpath = "//*[text()='Allow essential and optional cookies']")
    public WebElement cookieButton;

    @FindBy(id = "email")
    public WebElement mailKutusu;


    @FindBy(id = "pass")
    public WebElement passwordBox;

    @FindBy(name = "login")
    public WebElement loginTusu;

    @FindBy(className = "_9ay7")
    public WebElement girilmadiYaziElementi;

}
