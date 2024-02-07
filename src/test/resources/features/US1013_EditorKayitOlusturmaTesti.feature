
  Feature: US1013 Kullanicilar kayit olusturabilmeli
    @wip
    Scenario: : TC21 kullanici verilen listeden kayit olusturabilmeli
      When kullanici "editorUrl" anasayfaya gider
      Then new butonuna basar
      And tum bilgileri girer
      And Create tusuna basar
      When kullanici ilk isim ile arama yapar
      Then isim bolumunde isminin oldugunu dogrular
      And sayfayi kapatir



