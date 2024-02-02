package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ZeroWebPage {

    public ZeroWebPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//button[@id='signin_button']")
    public WebElement signInLinki;

    @FindBy(xpath = "//input[@id='user_login']")
    public WebElement usernameKutusu;

    @FindBy(xpath = "//input[@id='user_password']")
    public WebElement passwordKutusu;

    @FindBy(xpath = "//input[@name='submit']")
    public WebElement signInButonu;

    @FindBy(xpath = "(//a[@class='dropdown-toggle'])[2]")
    public WebElement loginDogrulama;

    @FindBy(xpath = "//strong[text()='Online Banking']")
    public WebElement onlineBankingLinki;

    @FindBy(id = "pay_bills_link")
    public WebElement payBillsLinki;

    @FindBy(xpath = "//a[text()='Purchase Foreign Currency']")
    public WebElement purchaseForeignCurrencyTab;

    @FindBy(id = "pc_currency")
    public WebElement pcCurrencyDropdown;

}
