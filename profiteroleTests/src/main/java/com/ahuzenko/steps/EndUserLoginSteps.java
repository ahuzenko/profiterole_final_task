package com.ahuzenko.steps;

import com.ahuzenko.pages.ProfiteroleHomePage;
import com.ahuzenko.pages.ProfiteroleLoginPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static com.thoughtworks.selenium.SeleneseTestBase.assertTrue;


public class EndUserLoginSteps extends ScenarioSteps {

    ProfiteroleLoginPage profiteroleLoginPage;

    @Step
    public ProfiteroleHomePage enterAsRegisteredUser(String log, String pwd) {

        return profiteroleLoginPage.enterAsRegisteredUser(log, pwd);
    }

    @Step
    public void isUserOnLoginPage() {

        profiteroleLoginPage.open();
    }


    @Step
    public void userIsLoggedIn() {
        assertTrue(profiteroleLoginPage.loginIsDone());
    }


}