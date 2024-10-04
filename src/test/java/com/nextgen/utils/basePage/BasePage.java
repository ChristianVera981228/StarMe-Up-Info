package com.nextgen.utils.basePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    // Navbar Elements (WARN: Not Available in Landing Page)
    @FindBy(css = ".ui-header__logo-image")
    protected WebElement logoImg;
    @FindBy(css = ".main-search__input")
    protected WebElement searchInput;
    // Exists only after of search
    @FindBy(css = ".main-search__results")
    protected WebElement resultsContainer;
    @FindBy(css = "main-search-list__title")
    protected WebElement resultsListTitle;
    @FindBy(css = ".main-search-list__users > .main-search-list-item")
    protected List<WebElement> userResultsList;
    @FindBy(css = ".ui-user-profile-user-avatar__avatar")
    protected WebElement avatarImg;
    //".suite-segment__children a:nth-child(2) .profile-metric-content__value
    @FindBy(css = ".suite-segment__children a:nth-child(2) .profile-metric-content__value")
    protected WebElement metricSentStars;

    @FindBy(css = ".suite-segment__children a:nth-child(1) .profile-metric-content__value")
    protected WebElement metricRecievedStars;

    public BasePage(WebDriver pageDriver) {
        driver = pageDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    protected void waitElementIsDisplayed(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    protected void waitElementsAreDisplayed(List<WebElement> webElementsList) {
        wait.until(ExpectedConditions.visibilityOfAllElements(webElementsList));
    }

    protected void waitElementBeClickable(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    protected void manualLoginWait() {
        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(120))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(RuntimeException.class);

        fluentWait.until(ExpectedConditions.visibilityOfAllElements(Arrays.asList(logoImg, searchInput)));
    }

    protected boolean verifyUrlContains(String txt) {
        return driver.getCurrentUrl().toLowerCase().contains(txt);
    }

    public boolean isLogoDisplayed() {
        return logoImg.isDisplayed();
    }

    public boolean isSearchInputEnabled() {
        return searchInput.isDisplayed() && searchInput.isEnabled();
    }

}
