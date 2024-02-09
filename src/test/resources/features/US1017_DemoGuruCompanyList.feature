Feature: US1017 Kullanici listedeki sirketleri yazdirir

  @wip
  Scenario: TC25 Kullanici istenen sirketlerin listede oldugunu test eder
    
    Given kullanici "demoGuruUrl" anasayfaya gider
    Then Company listesini consola yazdirir
    And listede 20'den fazla sirket oldugunu test eder
    And  "Jet Airways" %Change oraninin pozitif oldugunu test eder
    Then 3 saniye bekler


