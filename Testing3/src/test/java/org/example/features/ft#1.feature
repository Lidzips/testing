Feature: log in test

  Scenario: login in service
    Given open kpfu.ru
    When press element with xPath "//*[@id=\"top-panel\"]/div[1]/div[1]/a"
    And type to input with name "p_login" text: "IgSKalugin"
    And type to input with name "p_pass" text: "71nngy0i"
    And press element with xPath "//*[@id=\"eu_enter\"]/input[3]"
    Then wait until element with xPath "//*[@id=\"eu_enter\"]/input[3]" disappears

  Scenario: transitions to various sections
    Given open kpfu.ru
    When press element with xPath "//*[@id=\"top-panel\"]/div[1]/div[1]/a"
    And type to input with name "p_login" text: "IgSKalugin"
    And type to input with name "p_pass" text: "71nngy0i"
    And press element with xPath "//*[@id=\"eu_enter\"]/input[3]"
    And press element with xPath "//*[@id=\"main-blocks\"]/div[1]/div[6]/a"
    And press element with xPath "//*[@id=\"under-slider-menu\"]/div/a[2]"
    Then element with xPath "//*[@id=\"info\"]/div/div[1]/div[2]/div[2]/span[2]" should have text "Калугин Игорь Сергеевич"

  Scenario: download file
    Given open kpfu.ru
    When press element with xPath "//*[@id=\"top-panel\"]/div[1]/div[1]/a"
    And type to input with name "p_login" text: "IgSKalugin"
    And type to input with name "p_pass" text: "71nngy0i"
    And press element with xPath "//*[@id=\"eu_enter\"]/input[3]"
    And press element with xPath "//*[@id=\"main-blocks\"]/div[2]/div[9]/a"
    And press element with text "Документы"
    And press element with text "Заселение в общежития КФУ"
    Then element with id "doc-templates" should have text "Заявление на заселение в общежития КФУ"
    And try to download from link with xPath "//*[@id=\"tab1\"]/p[3]/a"


