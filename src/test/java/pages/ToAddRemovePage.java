package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ToAddRemovePage {

    public ToAddRemovePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(tagName = "h2")
    public WebElement addRemoveYaziElementi;

    @FindBy(xpath = "//*[text()='Electronics Products']")
    public WebElement electronicsLinki;

    @FindBy(xpath = "//li[@class = 'current']")
    public WebElement electronicsSayfasiDogrulama;

    @FindBy(xpath = "//*[@*='product-box mb-2 pb-1']")
    public List<WebElement> bulunanUrunElementleriList;


}
