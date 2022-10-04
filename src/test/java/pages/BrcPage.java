package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BrcPage {
    public BrcPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[@role='button']")
    public WebElement ilkLoginButton;

    @FindBy(xpath = "//*[@id='formBasicEmail']")
    public WebElement emailTextBox;

    @FindBy(xpath = "//*[@id='formBasicPassword']")
    public WebElement passwordTestBox;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement ikinciLoginButton;
    @FindBy(id = "dropdown-basic-button")
    public WebElement kullaniciProfilIsmi;
    @FindBy(xpath = "//*[text()='Create new user']")
    public WebElement createNewUser;
}
