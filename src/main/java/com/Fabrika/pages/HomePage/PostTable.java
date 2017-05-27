package com.Fabrika.pages.HomePage;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class PostTable {


    public ElementsCollection posts = $$("div.web2py_htmltable table tbody tr");
    public SelenideElement postTable = $("div.web2py_htmltable table tbody");

    By messageLoc = byXpath("//td[1]");
    By userNameLoc = byXpath("//td[2]");




    public PostTable shouldHaveSize(int size){
        posts.shouldHaveSize(size);
        return this;
    }

    public PostTable shouldHaveMessage(int index, String mesage){
        posts.get(index).find(messageLoc).shouldHave(text(mesage));
        return this;
    }

    public PostTable firstShouldHaveMessage(String mesage){
        posts.first().find(messageLoc).shouldHave(text(mesage));
        return this;
    }

    public PostTable lastShouldHaveMessage(String mesage){
        posts.last().find(messageLoc).shouldHave(text(mesage));
        return this;
    }

    public PostTable lastShouldHaveUserId(String id){
        posts.last().find(userNameLoc).shouldHave(text(id));
        return this;
    }




}
