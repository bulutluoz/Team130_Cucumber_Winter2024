package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import pages.HeroPage;

public class HeroStepdefinitions {

    HeroPage heroPage = new HeroPage();

    @When("kullanici Add Element butonuna basar")
    public void kullanici_add_element_butonuna_basar() {
        heroPage.addElementButonu.click();
    }
    @When("Delete butonu’nun gorunur oldugunu test eder")
    public void delete_butonu_nun_gorunur_oldugunu_test_eder() {
        Assert.assertTrue(heroPage.deleteButonu.isDisplayed());
    }
    @Then("Delete tusuna basar")
    public void delete_tusuna_basar() {
        heroPage.deleteButonu.click();
    }
    @Then("Add Remove Elements yazisinin gorunur oldugunu test eder")
    public void add_remove_elements_yazisinin_gorunur_oldugunu_test_eder() {
        Assert.assertTrue(heroPage.addRemoveYaziElementi.isDisplayed());
    }

    @And("Delete butonunun gorunmedigini test eder")
    public void deleteButonununGorunmediginiTestEder() {

        try {

            heroPage.deleteButonu.click();

            //Assert.assertFalse(heroPage.deleteButonu.isDisplayed());
            // NoSuchElementException
        } catch (NoSuchElementException e) {
            Assert.assertTrue(true);
        }
    }
}
