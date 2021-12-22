package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[contains(@class, 'lk-link')]")
    private WebElement lkLink;

    @FindBy(xpath = "//*[contains(@name, 'p_login')]")
    private WebElement loginInput;

    @FindBy(xpath = "//*[contains(@name, 'p_pass')]")
    private WebElement pwInput;

    @FindBy(xpath = "//*[contains(@value, 'Отправить')]")
    private WebElement loginBtn;

    public void clickLkLink() {
        lkLink.click();
    }

    public void inputLogin(String login) {
        loginInput.sendKeys(login);
    }

    public void inputPasswd(String passwd) {
        pwInput.sendKeys(passwd);
    }

    public void clickLoginBtn() {
        loginBtn.click();
    }
}
