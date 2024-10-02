package com.nextgen.pages;

import com.nextgen.utils.basePage.BasePage;
import org.openqa.selenium.WebDriver;

public class UserMainPage extends BasePage {
    public UserMainPage(WebDriver driver) {
        super(driver);
    }

    public void untilImgIsDisplayed(){
        waitElementIsDisplayed(avatarImg);

    }

    public boolean isAvatarDisplayed(){
        return avatarImg.isDisplayed();
    }
}
