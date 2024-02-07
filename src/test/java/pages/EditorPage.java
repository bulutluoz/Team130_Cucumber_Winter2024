package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class EditorPage {

    public EditorPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@*='dt-button buttons-create']")
    public WebElement newButonu;

    @FindBy(xpath = "//*[@*='DTE_Form_Buttons']")
    public WebElement createButonu;

    @FindBy(xpath = "//*[@*='search']")
    public WebElement searchKutusu;

    @FindBy(xpath = "//*[@*='sorting_1']")
    public WebElement ilkIsimElementi;

}
