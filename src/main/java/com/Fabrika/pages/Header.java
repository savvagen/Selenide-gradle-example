package com.Fabrika.pages;

import com.Fabrika.pages.HomePage.HomePage;
import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;


public class Header {

    public SelenideElement logoutButton = $(byLinkText("Logout")),
            loginButton = $(byText("Login"));


    public HomePage logOut(){
        logoutButton.shouldBe(visible).click();
        loginButton.shouldBe(visible);
        return new HomePage();

    }


}
