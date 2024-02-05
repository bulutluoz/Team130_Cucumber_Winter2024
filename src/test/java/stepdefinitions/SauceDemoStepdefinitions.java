package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.SauceDemoPage;

public class SauceDemoStepdefinitions {

    SauceDemoPage sauceDemoPage = new SauceDemoPage();
    String ilkUrunIsmi;

    @Then("saucedemo username kutusuna {string} yazar")
    public void saucedemo_username_kutusuna_yazar(String verilenUsername) {
        sauceDemoPage.usernameKutusu.sendKeys(verilenUsername);
    }
    @Then("saucedemo password kutusuna {string} yazar")
    public void saucedemo_password_kutusuna_yazar(String verilenPassword) {
        sauceDemoPage.passwordKutusu.sendKeys(verilenPassword);
    }
    @Then("saucedemo login tusuna basar")
    public void saucedemo_login_tusuna_basar() {
        sauceDemoPage.loginButonu.click();
    }
    @Then("ilk urunun ismini kaydeder ve bu urunun sayfasina gider")
    public void ilk_urunun_ismini_kaydeder_ve_bu_urunun_sayfasina_gider() {
        ilkUrunIsmi = sauceDemoPage.ilkUrunIsimElementi.getText();
        sauceDemoPage.ilkUrunIsimElementi.click();
    }
    @When("saucedemo add to Cart butonuna basar")
    public void saucedemo_add_to_cart_butonuna_basar() {
        sauceDemoPage.addToCartButonu.click();
    }
    @Then("saucedemo alisveris sepetine tiklar")
    public void saucedemo_alisveris_sepetine_tiklar() {
        sauceDemoPage.shoppingCartLinki.click();
    }
    @Then("sectigi urunun basarili olarak sepete eklendigini test eder")
    public void sectigi_urunun_basarili_olarak_sepete_eklendigini_test_eder() {

        String sepettekiUrunIsmi = sauceDemoPage.sepettekiUrunIsimElementi.getText();

        Assert.assertEquals(ilkUrunIsmi,sepettekiUrunIsmi);
    }
}
