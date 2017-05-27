package com.Fabrika.pages.LoginPage;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Configuration.*;

public class LoginPage {

    public final String page_url = baseUrl + "/default/user/login";
    public String userEmail = "savva.genchevskiy@gmail.com";
    public String userPassword = "19021992qa";

    public SelenideElement emailField = $(byName("email")),
            passwordField = $(byName("password")),
            submitButton = $(byXpath("//*/input[@value='Login']"));

    public LoginPage openPage() {
        open(page_url);
        return this;
    }

    public LoginPage login(String email, String password) {
        emailField.shouldBe(Condition.visible).setValue(email);
        passwordField.setValue(password).pressEnter();
        //submitButton.click();
        return this;
    }

    public LoginPage login(){
        emailField.shouldBe(Condition.visible).setValue(userEmail);
        passwordField.setValue(userPassword);
        submitButton.click();
        return this;
    }
}



