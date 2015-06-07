package com.ahuzenko.jbehave;


import com.ahuzenko.pages.ProfiteroleHomePage;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.ahuzenko.steps.EndUserLoginSteps;

import static junit.framework.Assert.assertTrue;

public class LoginSteps {



    @Steps
    EndUserLoginSteps userLoginSteps;

    @Given("user is on the login page")
    public void givenTheUserIsOnTheLoginPage() {

        userLoginSteps.isUserOnLoginPage();
    }

    @When("the user enters '$login' and '$password' and press Вход button" )
    public void whenUserEntersLoaginAndPasswordAndPressesEnter(String login, String password) {
       userLoginSteps.enterAsRegisteredUser(login, password);
    }

    @Then("user is logged in")
    public void thenUserIsLoggedIn() {
        userLoginSteps.userIsLoggedIn();
    }

}
