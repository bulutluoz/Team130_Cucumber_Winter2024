package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class EditorPage {

    public EditorPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


}
