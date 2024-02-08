Feature: US1004 Kullanici gecerli bilgilerle sisteme giris yapabilmeli

  @smoke @resim
  Scenario: TC10 gecerli username ve password ile sisteme giris yapilabilmeli

    Given kullanici "toUrl" anasayfaya gider
    Then account butonuna basar
    And email olarak "toGecerliEmail" girer
    And password olarak "toGecerliPassword" girer
    Then signIn butonuna basar
    And basarili giris yapilabildigini test eder
    And 3 saniye bekler
    And sayfayi kapatir
