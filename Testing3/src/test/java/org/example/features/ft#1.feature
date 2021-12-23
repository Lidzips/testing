Feature: log in test

  Scenario: login in service
    Given open kpfu.ru
    When press element with text "Личный кабинет"
    And type to input with name "p_login" text: "IgSKalugin"
    And type to input with name "p_pass" text: "71nngy0i" and press enter
    Then wait until element with text "Вход в личный кабинет" disappears

  Scenario: transitions to various sections
    Given open kpfu.ru
    When press element with text "Личный кабинет"
    And type to input with name "p_login" text: "IgSKalugin"
    And type to input with name "p_pass" text: "71nngy0i" and press enter
    And press element with title "Портфолио"
    And press element with title "Вернуться на главную страницу личного кабинета"
    And press element with text "Успеваемость"
    And press element with text "за семестр"

  Scenario: download file
    Given open kpfu.ru
    When press element with text "Личный кабинет"
    And type to input with name "p_login" text: "IgSKalugin"
    And type to input with name "p_pass" text: "71nngy0i" and press enter
    And press element with text "Общежитие"
    And press element with text "Документы"
    And press element with text "Заселение в общежития КФУ"
    Then element with id "doc-templates" should have text "Заявление на заселение в общежития КФУ"
    And try to download from link near it


