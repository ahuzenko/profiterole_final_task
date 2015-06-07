package com.ahuzenko.jbehave;


import com.ahuzenko.pages.ProfiteroleHomePage;
import com.ahuzenko.steps.EndUserCreateReceiptSteps;
import com.ahuzenko.steps.EndUserLoginSteps;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static com.thoughtworks.selenium.SeleneseTestBase.assertTrue;


public class CreateReceiptSteps {



    @Steps
    EndUserLoginSteps userLoginSteps;
    @Steps
    EndUserCreateReceiptSteps userCreateReceiptSteps;

    ProfiteroleHomePage home;

    private String login;
    private String password;

    public void checkIfTheUserIsLoggedInAndLogInIfNOT(){

        home.open();
        if(!home.userIsLoggedIn()){
            login = "HSunny";
            password = "qwerty";
            userLoginSteps.isUserOnLoginPage();
            userLoginSteps.enterAsRegisteredUser(login,password);
        }

    }

    @Given("registered user is on the Home Page")
    public void givenTheUserIsOnTheLoginPage() {

        checkIfTheUserIsLoggedInAndLogInIfNOT();
        userLoginSteps.userIsLoggedIn();
    }

    @When("selects Рецепты->Создать Рецепт from main menu")
    public void whenUserUserSelectsReceiptCreateReceiptFromMainMenu() {
       userCreateReceiptSteps.openAddReceipePageFromHomePage();
    }

    @Then("create receipt page is opened")
    public void thenCreateReceiptPageIsOpened() {
            userCreateReceiptSteps.pageIsOpened();
    }

    @Given("registered user is on add receipt page")
    public void givenRegisteredUserIsOnAddRecieptPage()
    {
        checkIfTheUserIsLoggedInAndLogInIfNOT();
        userCreateReceiptSteps.openPage();
        userCreateReceiptSteps.pageIsOpened();
    }

    @When("fills all the mandatory fields with '$testReceiptName','$testReceiptDescription','$hours','$min','$weight'," +
            "'$kitchen','$type','$ingrid','$ingridWeight','$ingridMeasure','$grade','$steps'")
    public void whenUserFillsAllTheMandatoryFields(String testRecieptName, String testReceiptDescription,String hours,
                                                   String min, String weight,String kitchen, String type, String ingrid,
                                                   String ingridWeight, String ingridMeasure,String grade,String steps){


        userCreateReceiptSteps.fillMandatoryFields(testRecieptName, testReceiptDescription, hours, min, weight, kitchen,
                                                   type,  ingrid, ingridWeight,  ingridMeasure, grade, steps);


    }

    @Then("reciept is added successfuly")
    public void thenReceiptIsAddedSuccessfuly(){

        userCreateReceiptSteps.checkReceiptWasAdded();
    }

    @When("leave all the fields empty and click add")
    public void whenClickonAddWithEmptyFields(){

        userCreateReceiptSteps.addReceipt();
    }

    @Then("reciept is not added, validation messages are displayed")
    public void thenValidationMessagesAreDisplayed(){

        userCreateReceiptSteps.checkAllValidationMessagesPositions();
    }


}
