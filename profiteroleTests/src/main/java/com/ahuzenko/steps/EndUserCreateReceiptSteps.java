package com.ahuzenko.steps;

import com.ahuzenko.pages.ProfiteroleAddReceiptPage;
import com.ahuzenko.pages.ProfiteroleHomePage;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static com.thoughtworks.selenium.SeleneseTestBase.assertTrue;


public class EndUserCreateReceiptSteps extends ScenarioSteps {


    ProfiteroleAddReceiptPage addReciepePage;
    ProfiteroleHomePage homePage;

    @Step
    public void openAddReceipePageFromHomePage() {

            homePage.clickSubMenuCreateReciepe();
    }


    @Step
    public void openAddReceiptPage()
    {

        addReciepePage.openAddReceiptPage();
    }

    @Step
    public void openPage()
    {
        addReciepePage.openAddReceiptPage();
    }

    @Step
    public void pageIsOpened()
    {
        assertTrue(addReciepePage.pageIsOpened());

    }

    @Step
    public void fillMandatoryFields(String testRecieptName, String testReceiptDescription,String hours,
                                    String min, String weight,String kitchen, String type, String ingrid,
                                    String ingridWeight, String ingridMeasure,String grade,String steps){

            addReciepePage.fillreceiptTitle(testRecieptName);
            addReciepePage.fillreceiptDescription(testReceiptDescription);
            addReciepePage.fillreceiptcookingTimeHours(hours);
            addReciepePage.fillreceiptCookingTimeMinutes(min);
            addReciepePage.fillreceiptQuantityOfDish(weight);
            addReciepePage.selectreceiptCuisineId(kitchen);
            addReciepePage.selectreceiptCategoryId(type);
            addReciepePage.fillreceiptIngredientsNameList0(ingrid);
            addReciepePage.fillreceiptingredientsCountList0(ingridWeight);
            addReciepePage.fillIngredientsTypeList0(Integer.parseInt(ingridMeasure));
            addReciepePage.selectComplexity(grade);
            addReciepePage.fillreceiptStepsList0(steps);

            addReceipt();
   }

    @Step
    public void addReceipt(){
        addReciepePage.clickAdd();

    }

    @Step
    public void checkReceiptWasAdded()
    {
            assertTrue(addReciepePage.getDriver().getCurrentUrl().equals("http://gioia-profiterole.rhcloud.com/success"));

    }

    @Step
    public void checkAllValidationMessagesPositions()
    {
        assertTrue(addReciepePage.isTitleMessagePresent());
        assertTrue(addReciepePage.isCategoryIdMessagePresent());
        assertTrue(addReciepePage.isDescriptionMessagePresent());
        assertTrue(addReciepePage.isTimeMessagePresent());
        assertTrue(addReciepePage.isQuantityOfDishMessagePresent());
        assertTrue(addReciepePage.isIngridMessagePresent());
        assertTrue(addReciepePage.isCuisineIdMessagePresent());
        assertTrue(addReciepePage.isStepsListMessagePresent());
    }


}