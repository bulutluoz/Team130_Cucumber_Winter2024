package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;


public class Hooks {

    /*
        Cucumber'da @Before ve @After notasyonlarini kullanmak cok verimli degildir
        Cunku hangi stepdefinitions class'in altina koyarsak koyalim
        @Before notasyonuna sahip method her Scenario'dan once calisir
        ayni sekilde @After notasyonu da her Scenario'dan sonra calisir

        Bu sebeplerle baslangic ayarlarini yapmak veya driver'i kapatmak icin
        setup methodu veya teardown kullanmak yerine
        bunlari bir step olarak hazirlayip
        istedigimizde kullanabiliriz

        Ama yine de baska bir amacla
        framework'umuzde @Before veya @After kullanilacaksa
        rahat bulunabilmesi ve yonetilebilmesi icin
        Hooks class'ina konulmasi genel kabul gormustur


     */

    @After
    public void tearDown(Scenario scenario){
        final byte[] screenshot=((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        if (scenario.isFailed()) {
            scenario.attach(screenshot, "image/png","screenshots");
        }
        Driver.quitDriver();
    }


}
