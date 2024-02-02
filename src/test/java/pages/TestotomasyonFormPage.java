package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TestotomasyonFormPage {

    public TestotomasyonFormPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//select[@class='form-control'])[1]")
    public WebElement gunDropdownMenu;

    @FindBy(xpath = "(//select[@class='form-control'])[2]")
    public WebElement ayDropdownMenu;

    @FindBy(xpath = "(//select[@class='form-control'])[3]")
    public WebElement yilDropdownMenu;

}
