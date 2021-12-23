package org.example.steps;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class MyStepdefs {
    @Given("open kpfu.ru")
    public void open_kpfu_ru() {
        Configuration.reportsFolder = "target/surefire-reports";
        Configuration.headless = false;
        open("https://kpfu.ru/");
        sleep(500);
    }

    @When("press element with title {string}")
    public void pressElementByXPath(String link) {
        $(byAttribute("title", link)).should(exist).click();
    }

    @And("type to input with name {string} text: {string}")
    public void typeToInputWithNameText(String fieldName, String login) {
        $(By.name(fieldName)).should(exist).setValue(login);
    }

    @And("type to input with name {string} text: {string} and press enter")
    public void typeToInputWithNameTextAndPressEnter(String fieldName, String login) {
        $(By.name(fieldName)).should(exist).setValue(login).pressEnter();;
    }

    @And("press element with name {string}")
    public void pressElementWithName(String elementName) {
        $(By.name(elementName)).should(exist).click();
    }

    @And("press element with text {string}")
    public void pressElementByText(String text){
        $(byText(text)).should(exist).click();
    }

    @Then("element with id {string} should have text {string}")
    public void elementWithIdShouldHaveText(String controlId, String text){
        $(byId(controlId)).shouldHave(text(text));
    }

    @And("try to download from link near it")
    public void downloadFile(){
        try {
            File report = $(byXpath("//*[@id=\"tab1\"]/p[3]/a")).download();
            System.out.println("FILE Path: " + report.getPath());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Then("wait until element with text {string} disappears")
    public void waitUntilElementWithNameDisappears(String elementName) {
        $(By.name(elementName)).should(disappear);
    }
}
