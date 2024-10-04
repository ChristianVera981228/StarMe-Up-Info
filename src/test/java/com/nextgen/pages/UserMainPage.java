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

    public void untilSentStarsIsDisplayed(){
        waitElementIsDisplayed(metricSentStars);
    }

    public boolean isAvatarDisplayed(){
        return avatarImg.isDisplayed();
    }

    public Integer getSentStars(){

        System.out.println(metricSentStars.toString());
        try{
            Thread.sleep(10000);
        }catch (Exception e) {
            System.out.println(e);
        }
        
        String metricValue = metricSentStars.getText();
        System.out.println("Estrellas enviadas: " + metricValue);
        return Integer.parseInt(metricValue);

    }

    public Integer getRecievedStars(){

        System.out.println(metricRecievedStars.toString());
        try{
            Thread.sleep(10000);
        }catch (Exception e) {
            System.out.println(e);
        }
        
        String metricValue = metricRecievedStars.getText();
        System.out.println("Estrellas recibidas: " + metricValue);
            
        return Integer.parseInt(metricValue);

    }
}
