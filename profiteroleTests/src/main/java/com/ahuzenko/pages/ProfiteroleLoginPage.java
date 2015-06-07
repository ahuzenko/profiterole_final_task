package com.ahuzenko.pages;

/**
 * Created by Sunny on 06.06.2015.
 */


import ch.lambdaj.function.convert.Converter;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;

import net.thucydides.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;


@DefaultUrl("http://gioia-profiterole.rhcloud.com/login")
public class ProfiteroleLoginPage extends PageObject{

    @FindBy(id="j_username")
    private WebElementFacade login;

    @FindBy(id="j_password")
    private WebElementFacade password;

    @FindBy(tagName = "button")
    private WebElementFacade enter;


    public void enterLogin(String keyword) {
        login.type(keyword);
    }
    public void enterPassword(String keyword) {

        password.type(keyword);
    }

    public ProfiteroleHomePage enterAsRegisteredUser(String log, String pwd) {

        enterLogin(log);
        enterPassword(pwd);
        enter.click();
        return new ProfiteroleHomePage();
    }

    public boolean loginIsDone()
    {
        try {
            find(By.partialLinkText("Выход"));
        }catch(ElementNotFoundException e){
            return false;
        }
        return true;

    }

    private Converter<WebElement, String> toStrings() {
        return new Converter<WebElement, String>() {
            public String convert(WebElement from) {
                return from.getText();
            }
        };
    }
}
