package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SauceDemoPage {

   public SauceDemoPage(){
       PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "user-name")
    public WebElement usernameKutusu;

    @FindBy(id = "password")
    public WebElement passwordKutusu;

    @FindBy(id = "login-button")
    public WebElement loginButonu;

    @FindBy(id = "item_4_title_link")
    public WebElement ilkUrunIsimElementi;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    public WebElement addToCartButonu;

    @FindBy(className = "shopping_cart_link")
    public WebElement shoppingCartLinki;

    @FindBy(id = "item_4_title_link")
    public WebElement sepettekiUrunIsimElementi;
}
