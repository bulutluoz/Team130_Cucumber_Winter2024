Feature: US1008 kullanici add ve remove butonlarini test eder

  @wip
  Scenario: TC16 Kullanici add ve remove butonlarini kullanabilmeli

    Given kullanici "heroUrl" anasayfaya gider
    When kullanici Add Element butonuna basar
    And 2 saniye bekler
    And Delete butonu’nun gorunur oldugunu test eder
    Then Delete tusuna basar
    And Delete butonunun gorunmedigini test eder
    And Add Remove Elements yazisinin gorunur oldugunu test eder
    And 2 saniye bekler
    And sayfayi kapatir
