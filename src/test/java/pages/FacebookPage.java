package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {

    public FacebookPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//button[@data-cookiebanner='accept_button']")
    public WebElement cookiesKabulButonu;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailKutusu;

    @FindBy(xpath = "//input[@id='pass']")
    public WebElement passwordKutusu;

    @FindBy(xpath = "//button[@name='login']")
    public WebElement loginButonu;

    @FindBy(xpath = "//*[text()='Find your account and log in.']")
    public WebElement girisYapilamadiYaziElementi;


}
