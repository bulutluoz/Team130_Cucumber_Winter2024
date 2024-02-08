package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AutomationPage {

    public AutomationPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@*='fa fa-lock']")
    public WebElement signUpLinki;

    @FindBy(xpath = "(//input[@placeholder='Email Address'])[2]")
    public WebElement signUpEmailKutusu;

    @FindBy(xpath = "//*[text()='Signup']")
    public WebElement signUpButonu;

    @FindBy(xpath = "//*[@name='name']")
    public WebElement isimKutusu;

    @FindBy(id = "id_gender1")
    public WebElement mrRadioButton;

    @FindBy(id = "last_name")
    public WebElement formSoyisimKutusu;

    @FindBy(xpath = "//*[text()='Create Account']")
    public WebElement createAccountButonu;

    @FindBy(xpath = "//*[text()='Account Created!']")
    public WebElement accountCreatedYazisi;
}
