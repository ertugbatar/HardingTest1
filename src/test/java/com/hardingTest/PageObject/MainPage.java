package com.hardingTest.PageObject;

import com.hardingTest.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MainPage {


    public MainPage() {
        PageFactory.initElements(getDriver(), this);


    }

    private WebDriver getDriver() {
        return null;
    }



    @FindBy(id="cookie_action_close_header")
    public WebElement cookieAcceptHarding;

    @FindBy( xpath = "//a[@class='dropdown-toggle nav-link']")
    public WebElement careerButton;

    @FindBy(xpath = "//a[.='Landside']")
    public WebElement landSideButton;

    @FindBy(xpath = "//a[@class='btn btn-outline-primary btn-lg']")
    public WebElement seeVacanciesBtn;

    @FindBy(id = "txtSearchField")
    public WebElement searchInputBox;

    @FindBy (xpath = "//input[@class ='btn-widget']")
    public WebElement searchBtn;

    @FindBy(xpath = "//a[.='Apply']")
    public WebElement applyBtn;

    public WebElement button(String word){


        WebElement button = Driver.getDriver().findElement(By.xpath("//a[.='"+word+"']"));

        return button;
    }





}

