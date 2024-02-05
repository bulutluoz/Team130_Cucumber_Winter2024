


Feature: US1002 Kullanici Background ozelligini kullanir

  Background: anasayfaya gitme
    Given kullanici Testotomasyon sayfasina gider

    @wip
  Scenario:TC04 kullanici phone icin arama yapabilmeli
    And phone icin arama yapar
    Then aradigi urunun bulundugunu test eder
    And sayfayi kapatir

  Scenario: TC05 kullanici dress icin arama yapabilmeli
    And dress icin arama yapar
    Then aradigi urunun bulundugunu test eder
    And sayfayi kapatir

  Scenario: TC06 kullanici java icin sonuc bulamamali
    And java icin arama yapar
    Then aradigi urunun bulunmadigini test eder
    And sayfayi kapatir