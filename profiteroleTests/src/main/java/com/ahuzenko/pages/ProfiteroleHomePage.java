package com.ahuzenko.pages;

/**
 * Created by Sunny on 06.06.2015.
 */


import ch.lambdaj.function.convert.Converter;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.thoughtworks.selenium.SeleneseTestBase.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;


@DefaultUrl("http://gioia-profiterole.rhcloud.com")
public class ProfiteroleHomePage extends PageObject{

    @FindBy(partialLinkText ="Создать меню")
    private WebElementFacade createMenuItem;

    @FindBy(partialLinkText = "Меню на день")
    private WebElementFacade menu;
    public void clickSubMenuMenuForDay()
    {
        createMenuItem.click();
        menu.click();
    }

    @FindBy(partialLinkText = "Меню на неделю")
    private WebElementFacade menuForWeek;
    public void clickSubMenuMenuForWeek()
    {
        createMenuItem.click();
        menuForWeek.click();
    }


    @FindBy(partialLinkText="Рецепты")
    private WebElementFacade reciepes;
    @FindBy(partialLinkText = "Все рецепты")

    private WebElementFacade allReciepes;
    public void clickSubMenuAllReciepes() {

        reciepes.click();
        allReciepes.click();
    }

    @FindBy(partialLinkText = "Создать рецепт")
    private WebElementFacade createReciepe;
    public void clickSubMenuCreateReciepe() {

        if(find(By.partialLinkText("Выход")).isVisible()) {
            reciepes.click();
            createReciepe.click();
        }
    }

    public boolean userIsLoggedIn()
    {
        try{

            find(By.partialLinkText("Выход"));
        }catch(Exception e)
        {
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
