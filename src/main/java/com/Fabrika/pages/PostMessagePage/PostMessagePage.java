package com.Fabrika.pages.PostMessagePage;

import com.Fabrika.pages.HomePage.PostTable;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Configuration.*;


public class PostMessagePage {

    public final String page_url = baseUrl + "/default/entry_post";
    public String newPostText = "Hello Savva!";
    public String userId = "Savva Genchevskiy (101)";


    public SelenideElement postField = $(byId("post_new_post")),
            submitButton = $(byXpath("//*/input[@type='submit']")),
            idField = $(byId("post_user_id__row")).$(byClassName("w2p_fw"));


    public PostMessagePage openPage(){
        open(page_url);
        return this;
    }

    public PostTable createPost(String text){
        postField.setValue(text);
        submitButton.click();
        return new PostTable();
    }

}




