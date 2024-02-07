
  Feature: US1014 kullanici tablo olarak verilen degerlerle kayit olusturur
    @wip
    Scenario Outline: TC22 tablo olarak verilen bilgilerle kayit olusturulabilmeli

      When kullanici "editorUrl" anasayfaya gider
      Then new butonuna basar
      And "<firstname>" "<lastname>" "<position>" "<office>" "<extention>""<startdate>" ve "<salary>" girer
      And Create tusuna basar
      When kullanici "<firstname>" ile arama yapar
      Then listede ilk ismin "<firstname>" icerdigini test eder
      And sayfayi kapatir

      Examples:
      |firstname|lastname|position|office   |extention|startdate  |salary |
      |Alper    |Duman   |QA      |Munich   |junior   |2024-06-23 |55000  |
      |Orkong   |Bulut   |QA      |Florida  |junior   |2024-07-23 |95000  |


