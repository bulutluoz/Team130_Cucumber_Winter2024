
  Feature: US1012 kullanici excel olarak verilen listedeki urunleri aratir

    Scenario Outline: TC19 excelden sececegimiz satirdaki urunlerin min urun sayisi test edilir

      Given kullanici "toUrl" anasayfaya gider
      Then urun excelindeki "<istenenSatir>" daki urunun min. miktarini ve urun ismini kaydeder
      And urun ismini testotomasyonu sayfasinda aratir ve sonuc sayisini kaydeder
      And bulunan urun sayisinin "<istenenSatir>" da verilen min. miktardan fazla oldugunu test eder
      And sayfayi kapatir

      Examples:
      |istenenSatir|
      |2           |
      |3           |
      |4           |
      |5           |
      |8           |
      |9           |
      |10          |