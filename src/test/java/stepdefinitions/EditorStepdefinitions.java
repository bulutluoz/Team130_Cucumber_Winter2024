package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.EditorPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class EditorStepdefinitions {

    EditorPage editorPage = new EditorPage();
    String firstname ;

    @Then("new butonuna basar")
    public void new_butonuna_basar() {

        editorPage.newButonu.click();
    }
    @Then("tum bilgileri girer")
    public void tum_bilgileri_girer() {
        Actions actions = new Actions(Driver.getDriver());
        Faker faker = new Faker();
        firstname = faker.name().firstName();
        ReusableMethods.bekle(1);
        actions.sendKeys(firstname)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().title())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().city())
                .sendKeys(Keys.TAB)
                .sendKeys("-")
                .sendKeys(Keys.TAB)
                .sendKeys("2024-02-10")
                .sendKeys(Keys.TAB)
                .sendKeys("40000")
                .perform();
        ReusableMethods.bekle(1);

    }
    @Then("Create tusuna basar")
    public void create_tusuna_basar() {
        editorPage.createButonu.click();
    }
    @When("kullanici ilk isim ile arama yapar")
    public void kullanici_ilk_isim_ile_arama_yapar() {
        editorPage.searchKutusu.sendKeys(firstname);
    }
    @Then("isim bolumunde isminin oldugunu dogrular")
    public void isim_bolumunde_isminin_oldugunu_dogrular() {
        String tablodakiIlkIsimSoyisim = editorPage.ilkIsimElementi.getText();
        Assert.assertTrue(tablodakiIlkIsimSoyisim.contains(firstname));
    }

    @Then("{string} {string} {string} {string} {string}{string} ve {string} girer")
    public void ve_girer(String firstname, String lastname, String position, String office, String extension, String date, String salary) {

        Actions actions = new Actions(Driver.getDriver());
        ReusableMethods.bekle(1);
        actions.sendKeys(firstname)
                .sendKeys(Keys.TAB)
                .sendKeys(lastname)
                .sendKeys(Keys.TAB)
                .sendKeys(position)
                .sendKeys(Keys.TAB)
                .sendKeys(office)
                .sendKeys(Keys.TAB)
                .sendKeys(extension)
                .sendKeys(Keys.TAB)
                .sendKeys(date)
                .sendKeys(Keys.TAB)
                .sendKeys(salary)
                .perform();
        ReusableMethods.bekle(1);


    }
    @When("kullanici {string} ile arama yapar")
    public void kullanici_ile_arama_yapar(String firstname) {
        editorPage.searchKutusu.sendKeys(firstname);
    }
    @Then("listede ilk ismin {string} icerdigini test eder")
    public void listede_ilk_ismin_icerdigini_test_eder(String firstname) {

        String actualIlkIsim = editorPage.ilkIsimElementi.getText();

        Assert.assertTrue(actualIlkIsim.contains(firstname));
    }
}
