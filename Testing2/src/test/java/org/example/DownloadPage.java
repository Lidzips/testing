package org.example;

import io.qameta.allure.Step;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class DownloadPage {
    @Step("Заменяем фото в личном кабинете")
    @Test
    public void uploadPhoto(){
        $(byXpath("//*[@id=\"under-slider-menu\"]/div/a[2]")).should(exist).click();
        $(byXpath("//*[@id=\"info\"]/div/div[1]/div[1]/div[2]/div[2]")).should(exist).click();
        $(byXpath("//*[@id=\"answer\"]/a[1]")).should(exist).click();
        $(byXpath("//*[@id=\"info\"]/div/div[1]/div[1]/div[1]/form/div[1]/input")).should(exist).uploadFile(new File("C:\\Users\\igori\\Downloads\\image.jpg"));
        $(byXpath("//*[@id=\"info\"]/div/div[1]/div[1]/div[1]/form/div[2]/input")).should(exist).click();
        $(byXpath("//*[@id=\"under-slider-menu\"]/div/a[1]")).click();
    }
    @Step("Скачиваем образец заявления")
    @Test
    public void download(){
        $(byXpath("//*[@id=\"main-blocks\"]/div[2]/div[9]/a")).should(exist).click();
        $(byText("Документы")).should(exist).click();
        $(byText("Заселение в общежития КФУ")).should(exist).click();
        $(byId("doc-templates")).shouldHave(text("Заявление на заселение в общежития КФУ"));
        try {
            File report = $(byXpath("//*[@id=\"tab1\"]/p[3]/a")).download();
            System.out.println("FILE Path: " + report.getPath());

            } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
