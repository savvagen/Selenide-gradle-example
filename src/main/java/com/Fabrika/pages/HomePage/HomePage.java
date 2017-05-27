package com.Fabrika.pages.HomePage;


import com.codeborne.selenide.*;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Configuration.*;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;



public class HomePage {

    public final String page_url = baseUrl + "/default/index";
    public String logged_in_flash_message = "Welcome to Selenium course, Savva!" + "\n" + "×";
    public String not_logged_in_flash_message = "Welcome to Selenium course!" + "\n" + "×";


    public ElementsCollection posts = $$("div.web2py_htmltable table tbody tr");
    public SelenideElement postTable = $("div.web2py_htmltable table tbody");

    By messageLoc = byXpath("//td[1]");
    By userNameLoc = byXpath("//td[2]");


    public SelenideElement flash = $(byClassName("flash")),
            profileButton = $(byLinkText("Profile")),
            registerButton = $(byLinkText("Register")),
            aboutLink = $(byXpath("//*/a[@href='/test_1/default/about']")),
            termsLink = $(byXpath("//*/a[@href='/test_1/default/terms']")),
            contactsLink = $(byXpath("//*/a[@href='/test_1/default/contact']")),
            descriptionButton = $(byLinkText("Description"));


    By viewButtonLoc = byCssSelector("td.row_buttons a");
    By deleteButtonLoc = byCssSelector("td.row_buttons a[data-w2p_remove^='tr']");



    public HomePage openPage(){
        open(page_url);
        return this;
    }

    public SelenideElement getPostById(String id){
        return posts.findBy(Condition.attribute("id", id));
    }

    public SelenideElement getPostByIndex(int index){
        return posts.get(index);
    }


    public HomePage viewMessage(String id){
        getPostById(id).$(viewButtonLoc).click();
        return this;
    }

    public HomePage viewMessageWithNumber(int index){
        int number = index - 1;
        getPostByIndex(number).$(viewButtonLoc).click();
        return this;
    }

    public HomePage deleteLastPost(){
        posts.last().$(deleteButtonLoc).click();
        confirm();
        //switchTo().alert().accept();
        return this;
    }




}
