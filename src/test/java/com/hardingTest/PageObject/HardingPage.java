package com.hardingTest.PageObject;

import com.hardingTest.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HardingPage {


    public HardingPage(){

        PageFactory.initElements(Driver.getDriver(),this);
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

    @FindBy(xpath = "(//input[@class='form-control'])[1]")
    public WebElement firstNameInputBox;

    @FindBy(xpath = "(//input[@class='form-control'])[2]")
    public WebElement surNameInputBox;

    @FindBy(xpath = "(//input[@class='form-control'])[3]")
    public WebElement emailAddressBox;

    @FindBy(xpath = "(//input[@class='form-control'])[4]")
    public WebElement mobileInputBox;

    @FindBy(xpath = "(//input[@class='form-control'])[5]")
    public WebElement townInputBox;

    @FindBy (xpath = "(//input[@class='dz-hidden-input'])[1]")
    public WebElement uploadBtn;

    @FindBy (id ="btnCreateApplication")
    public WebElement nextBtn;















}
