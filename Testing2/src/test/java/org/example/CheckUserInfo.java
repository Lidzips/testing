package org.example;

import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CheckUserInfo {
    @Test
    public void checkUserInfo() {
        $(By.xpath("//*[@id=\"under-slider-menu\"]/div/a[2]/i")).should(exist).click();
        $(By.xpath("//*[@id=\"info\"]/div/div[1]/div[2]/div[2]/span[2]")).shouldHave(text(ConfProperties.getProperty("name")));
        $(By.xpath("//*[@id=\"info\"]/div/div[1]/div[2]/div[3]/span[2]")).should(exist);
        $x("//*[@id=\"info\"]/div/div[1]/div[2]/div[6]/span[2]").shouldBe(visible);
    }
}

