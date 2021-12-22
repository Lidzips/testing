package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {

    public WebDriver driver;
    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[contains(@class, 'mobile-menu-toggler')]")
    private WebElement userMenu;

    @FindBy(xpath = "//*[contains(@class, 'student-menu-close fa fa-times')]")
    private WebElement userMenuClose;

    @FindBy(xpath = "//*[contains(@class, 'login fancybox')]")
    private WebElement logoutBtn;

    public String getMenuText() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'mobile-menu-toggler')]")));
        String menuText = userMenu.getText();
        return menuText;
    }

    public void entryMenu() {
        userMenu.click();
    }

    public void closeMenu() {
        userMenuClose.click();
    }

    public void userLogout() {
        logoutBtn.click();
    }
}
