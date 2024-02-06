package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.TestOtomasyonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestotomasyonStepdefinitions {

    TestOtomasyonPage testOtomasyonPage = new TestOtomasyonPage();
    String satirdakiUrunIsmi;
    int satirdakiMinUrunSayisi;
    int actualBulunanUrunSayisi;

    @Given("kullanici Testotomasyon sayfasina gider")
    public void kullanici_testotomasyon_sayfasina_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
    }
    @Given("phone icin arama yapar")
    public void phone_icin_arama_yapar() {
        testOtomasyonPage.aramaKutusu.sendKeys("phone" + Keys.ENTER);
    }
    @Then("aradigi urunun bulundugunu test eder")
    public void aradigi_urunun_bulundugunu_test_eder() {

        Assert.assertTrue(testOtomasyonPage.bulunanUrunElementleriList.size()>0);
    }

    @And("sayfayi kapatir")
    public void sayfayiKapatir() {
        Driver.quitDriver();
    }

    @And("dress icin arama yapar")
    public void dressIcinAramaYapar() {
        testOtomasyonPage.aramaKutusu.sendKeys("dress" + Keys.ENTER);
    }

    @And("java icin arama yapar")
    public void javaIcinAramaYapar() {
        testOtomasyonPage.aramaKutusu.sendKeys("java" + Keys.ENTER);
    }

    @Then("aradigi urunun bulunmadigini test eder")
    public void aradigiUrununBulunmadiginiTestEder() {

        String expectedSonucYazisi = ConfigReader.getProperty("toUrunBulunamadiYazisi");
        String actualSonucYazisi = testOtomasyonPage.bulunanUrunSayisiElementi.getText();

        Assert.assertEquals(expectedSonucYazisi,actualSonucYazisi);
    }

    @And("{string} icin arama yapar")
    public void icinAramaYapar(String aranacakUrun) {

        testOtomasyonPage.aramaKutusu.sendKeys(aranacakUrun + Keys.ENTER);
    }

    @And("{int} saniye bekler")
    public void saniyeBekler(int beklenecekSure) {

        try {
            Thread.sleep(beklenecekSure*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Given("kullanici {string} anasayfaya gider")
    public void kullanici_anasayfaya_gider(String configdenIstenenUrl) {
        Driver.getDriver().get(ConfigReader.getProperty(configdenIstenenUrl));
    }
    @Then("account butonuna basar")
    public void account_butonuna_basar() {
        testOtomasyonPage.accountLinki.click();
    }
    @Then("email olarak {string} girer")
    public void email_olarak_girer(String configdenIstenenEmail) {
        testOtomasyonPage.emailKutusu.sendKeys(ConfigReader.getProperty(configdenIstenenEmail));
    }
    @Then("password olarak {string} girer")
    public void password_olarak_girer(String configdenIstenenPassword) {
        testOtomasyonPage.passwordKutusu.sendKeys(ConfigReader.getProperty(configdenIstenenPassword));
    }
    @Then("signIn butonuna basar")
    public void sign_in_butonuna_basar() {
        testOtomasyonPage.loginButonu.click();
    }
    @Then("basarili giris yapilabildigini test eder")
    public void basarili_giris_yapilabildigini_test_eder() {
        Assert.assertTrue(testOtomasyonPage.logoutButonu.isDisplayed());
    }

    @Then("sisteme giris yapamadigini test eder")
    public void sisteme_giris_yapamadigini_test_eder() {
        Assert.assertTrue(testOtomasyonPage.emailKutusu.isDisplayed());
    }

    @When("email olarak listeden {string} girer")
    public void emailOlarakListedenGirer(String siradakiEmail) {

        testOtomasyonPage.emailKutusu.sendKeys(siradakiEmail);
    }

    @And("password olarak listeden {string} girer")
    public void passwordOlarakListedenGirer(String siradakiPassword) {
        testOtomasyonPage.passwordKutusu.sendKeys(siradakiPassword);
    }

    @Then("urun excelindeki {string} daki urunun min. miktarini ve urun ismini kaydeder")
    public void urunExcelindekiDakiUrununMinMiktariniVeUrunIsminiKaydeder(String istenenSatir) throws IOException {

        String dosyaYolu = "src/test/resources/stok.xlsx";
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sayfa2 = workbook.getSheet("Sayfa2");


        satirdakiUrunIsmi = sayfa2.getRow(Integer.parseInt(istenenSatir)-1).getCell(0).toString();
        String satirdakiMinUrunSayisiStr = sayfa2.getRow(Integer.parseInt(istenenSatir)-1).getCell(1).toString();

        double satirdakiMinUrunSayisiDouble = Double.parseDouble(satirdakiMinUrunSayisiStr);

        satirdakiMinUrunSayisi = (int) satirdakiMinUrunSayisiDouble;
    }

    @And("urun ismini testotomasyonu sayfasinda aratir ve sonuc sayisini kaydeder")
    public void urunIsminiTestotomasyonuSayfasindaAratirVeSonucSayisiniKaydeder() {

        testOtomasyonPage.aramaKutusu.sendKeys(satirdakiUrunIsmi + Keys.ENTER);

        String aramaSonucYazisi = testOtomasyonPage.bulunanUrunSayisiElementi.getText();
        // 10 products found

        aramaSonucYazisi = aramaSonucYazisi.replaceAll("\\D",""); // "10"
        actualBulunanUrunSayisi = Integer.parseInt(aramaSonucYazisi);
    }

    @And("bulunan urun sayisinin kaydedilen min. miktardan fazla oldugunu test eder")
    public void bulunanUrunSayisininKaydedilenMinMiktardanFazlaOldugunuTestEder() {

        Assert.assertTrue(actualBulunanUrunSayisi >= satirdakiMinUrunSayisi);
    }

    @Then("urun excelindeki tum urunler icin arama yapip min miktarda urun oldugunu test eder")
    public void urunExcelindekiTumUrunlerIcinAramaYapipMinMiktardaUrunOldugunuTestEder() throws IOException {

        // adimlari takip ederek excel'deki sayfaya ulas
        String dosyaYolu = "src/test/resources/stok.xlsx";
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sayfa2 = workbook.getSheet("Sayfa2");

        // exceldeki son satir sayisini bulup
        int sonSatirIndex = sayfa2.getLastRowNum();
        // bir loop ile urunu aratip min sayida urun bulundugunu test et

        boolean stoktaOlmayanVarMi = false;
        // bunu flag olarak kullanacagiz
        // eger stok miktarini tutturamayan olursa bunu true yapalim

        for (int i = 1; i <=sonSatirIndex ; i++) {
            // once i.index'deki urun ismini ve min urun sayisini excel'den okuyup kaydedelim
            String satirdakiUrunIsmi = sayfa2.getRow(i).getCell(0).toString();
            String satirdakiMinUrunMiktariStr = sayfa2.getRow(i).getCell(1).toString();
            double satirdakiMinUrunMiktariDbl = Double.parseDouble(satirdakiMinUrunMiktariStr);
            int satirdakiMinUrunSayisi = (int)satirdakiMinUrunMiktariDbl;
            // testotomasyon anasayfaya gidelim
            Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
            // kaydettigimiz urun icin arama yapalim

            testOtomasyonPage.aramaKutusu.sendKeys(satirdakiUrunIsmi + Keys.ENTER);
            // bulunan urun sayisini kaydedelim
            ReusableMethods.bekle(1);
            String actualUrunSayisiStr = testOtomasyonPage.bulunanUrunSayisiElementi.getText();
            actualUrunSayisiStr = actualUrunSayisiStr.replaceAll("\\D","");

            int actualUrunSayisi = Integer.parseInt(actualUrunSayisiStr);

            // bulunan urun sayisi >= min urun sayisi oldugunu test edelim

            try {
                Assert.assertTrue(actualUrunSayisi >= satirdakiMinUrunSayisi);
            } catch (AssertionError e) {
                stoktaOlmayanVarMi = true;
                System.out.println("aranan "+satirdakiUrunIsmi+" min stok sayisi : "
                                  + satirdakiMinUrunSayisi+ ", bulunan urun sayisi : " +
                                    actualUrunSayisi);
            }

        }
        // butun urunler icin assert yapildiktan sonra
        // eger failed olan assertion varsa
        // testimizin AssertionError vermesi icin
        // olusturdugumuz flag'i kullanarak bir assertion yaziyorum

        Assert.assertFalse(stoktaOlmayanVarMi);

        // sayfayi kapatalim
        Driver.quitDriver();
    }
}
