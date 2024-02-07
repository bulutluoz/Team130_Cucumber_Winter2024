package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import pages.WebuniversityPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class WebuniversityStepdefinitions {
    WebuniversityPage webuniversityPage = new WebuniversityPage();

    @Then("Login Portal a  kadar asagi iner")
    public void login_portal_a_kadar_asagi_iner() {
        // Login portal gorundugu icin asagi inilmedi

        //JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        //jse.executeScript("arguments[0].scrollIntoView();",webuniversityPage.loginPortalElementi);

    }
    @Then("Login Portal a tiklar")
    public void login_portal_a_tiklar() {
        webuniversityPage.loginPortalElementi.click();
        ReusableMethods.bekle(1);
    }
    @Then("acilan ikinci window'a gecer")
    public void acilan_ikinci_window_a_gecer() {
        String ikinciTabTitle = "WebDriver | Login Portal";

        ReusableMethods.titleIleWindowDegistir(ikinciTabTitle,Driver.getDriver());
    }
    @Then("username ve password kutularina fake degerler yazdirir")
    public void username_ve_password_kutularina_fake_degerler_yazdirir() {
        Faker faker = new Faker();
        webuniversityPage.usernameKutusu.sendKeys(faker.name().username());
        webuniversityPage.passwordKutusu.sendKeys(faker.internet().password());
        ReusableMethods.bekle(3);
    }
    @Then("login butonuna basar")
    public void login_butonuna_basar() {
        webuniversityPage.loginButonu.click();
    }
    @Then("Popup ta cikan yazinin {string} oldugunu test eder")
    public void popup_ta_cikan_yazinin_oldugunu_test_eder(String expectedPopupYazi) {
        String actualPopupYazisi = Driver.getDriver().switchTo().alert().getText();
        Assert.assertEquals(expectedPopupYazi,actualPopupYazisi);
    }
    @Then("Ok diyerek Popup'i kapatir")
    public void ok_diyerek_popup_i_kapatir() {
        Driver.getDriver().switchTo().alert().accept();
    }
    @When("Ilk sayfaya geri doner")
    public void ilk_sayfaya_geri_doner() {
        String ilkSayfaTitle = "WebDriverUniversity.com";
        ReusableMethods.titleIleWindowDegistir(ilkSayfaTitle,Driver.getDriver());
    }
    @Then("Ilk sayfaya donuldugunu test eder")
    public void ilk_sayfaya_donuldugunu_test_eder() {
        String expectedUrl = ConfigReader.getProperty("webUniUrl");
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(expectedUrl,actualUrl);
    }
}
