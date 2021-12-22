package org.example;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginTest {
    @BeforeClass
    public static void setup() {
        Configuration.headless = true;
        open(ConfProperties.getProperty("loginpage"));
    }

    @Before
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    @Test
    public void  Login(){
        $(By.xpath("//*[@id=\"top-panel\"]/div[1]/div[1]/a")).should(exist).click();
        $(By.xpath("//*[@id=\"eu_enter\"]/input[1]")).should(exist).setValue(ConfProperties.getProperty("login")).click();
        $(By.xpath("//*[@id=\"eu_enter\"]/input[2]")).should(exist).setValue(ConfProperties.getProperty("password")).click();
        $(By.xpath("//*[@id=\"eu_enter\"]/input[3]")).should(exist).click();
        $(By.xpath("//*[@id=\"main-blocks\"]/div[1]/div[6]/a")).should(exist).click();
        $(By.xpath("//*[@id=\"under-slider-menu\"]/div/a[1]/i")).should(exist).click();
    }
}