package com.ahuzenko.pages;

/**
 * Created by Sunny on 06.06.2015.
 */


import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.webelements.Checkbox;
import org.openqa.selenium.By;


import static com.thoughtworks.selenium.SeleneseTestBase.assertTrue;


@DefaultUrl("http://gioia-profiterole.rhcloud.com/addRecipes")
public class ProfiteroleAddReceiptPage extends PageObject{


    String URL ="http://gioia-profiterole.rhcloud.com/addRecipes";
    private boolean checkValidationMessage(WebElementFacade source) {



        try {

            source.find(By.xpath("following-sibling::div[@class='error-div'][1]"));

        }catch(Exception e){
            return false;
        }

        return true;

    }

    @FindBy(name = "title")
    private WebElementFacade receiptTitle;
    public void fillreceiptTitle(String keyword)
    {
            receiptTitle.type(keyword);
    }
    public boolean isTitleMessagePresent()
    {
        return checkValidationMessage(receiptTitle);
    }



    @FindBy(name = "description")
    private WebElementFacade receiptDescription;
    public void fillreceiptDescription(String keyword)
    {
        receiptDescription.type(keyword);
    }
    public boolean isDescriptionMessagePresent()
    {
        return checkValidationMessage(receiptDescription);
    }



    @FindBy(name = "cookingTimeHours")
    private WebElementFacade receiptCookingTimeHours;
    public void fillreceiptcookingTimeHours(String keyword)
    {
        receiptCookingTimeHours.type(keyword);
    }
    @FindBy(name = "cookingTimeMinutes")
    private WebElementFacade receiptCookingTimeMinutes;
    public void fillreceiptCookingTimeMinutes(String keyword)
    {
        receiptCookingTimeMinutes.type(keyword);
    }
    public boolean isTimeMessagePresent()
    {
        return checkValidationMessage(find(By.id("cookingTime")));
    }




    @FindBy(name = "quantityOfDish")
    private WebElementFacade receiptQuantityOfDish;
    public void fillreceiptQuantityOfDish(String keyword)
    {
        receiptQuantityOfDish.type(keyword);
    }
    public boolean isQuantityOfDishMessagePresent()
    {
        return checkValidationMessage(find(By.id("quantityOfDish")));
    }




    @FindBy(name = "cuisineId")
    private WebElementFacade receiptCuisineId;
    public void selectreceiptCuisineId(String keyword)
    {
        receiptCuisineId.selectByValue(keyword);
    }
    public boolean isCuisineIdMessagePresent()
    {
        return checkValidationMessage(receiptCuisineId);
    }



    @FindBy(name = "categoryId")
    private WebElementFacade receiptCategoryId;
    public void selectreceiptCategoryId(String keyword)
    {
        receiptCategoryId.selectByValue(keyword);
    }
    public boolean isCategoryIdMessagePresent()
    {
        return checkValidationMessage(receiptCategoryId);
    }







    @FindBy(name = "markersNames[0]")
    private Checkbox receiptMarker0;
    public void checkreceiptMarker0()
    {
        receiptMarker0.setChecked(!receiptMarker0.isChecked());
    }
    @FindBy(name = "markersNames[1]")
    private Checkbox receiptMarker1;
    public void checkreceiptMarker1()
    {
        receiptMarker1.setChecked(!receiptMarker1.isChecked());
    }
    @FindBy(name = "markersNames[2]")
    private Checkbox receiptMarker2;
    public void checkreceiptMarker2()
    {
        receiptMarker2.setChecked(!receiptMarker2.isChecked());
    }




    @FindBy(id = "ingredientsNameList[0]")
    private WebElementFacade receiptIngredientsNameList0;
    public void fillreceiptIngredientsNameList0(String keyword)
    {
        receiptIngredientsNameList0.type(keyword);
    }
    @FindBy(id = "ingredientsCountList[0]")
    private WebElementFacade receiptIngredientsCountList0;
    public void fillreceiptingredientsCountList0(String keyword)
    {
        receiptIngredientsCountList0.click();
        receiptIngredientsCountList0.click();

        receiptIngredientsCountList0.type(keyword);
    }
    @FindBy(id = "ingredientsTypeList[0]")
    private WebElementFacade receiptIngredientsTypeList0;
    public void fillIngredientsTypeList0(int index)
    {
        receiptIngredientsTypeList0.selectByIndex(index);
    }
    public boolean isIngridMessagePresent()
    {
        return checkValidationMessage(receiptIngredientsTypeList0);
    }




    @FindBy(name = "complexity")
    private WebElementFacade receiptComplexity;
    public void selectComplexity(String keyword)
    {
        receiptComplexity.selectByVisibleText(keyword);
    }
    public boolean isComplexityMessagePresent()
    {
        return checkValidationMessage(receiptComplexity);
    }




    @FindBy(name = "stepsList[0]")
    private WebElementFacade receiptStepsList0;
    public void fillreceiptStepsList0(String keyword)
    {

        receiptStepsList0.type(keyword);
    }
    public boolean isStepsListMessagePresent()
    {
        return checkValidationMessage(receiptStepsList0);
    }




    @FindBy(id = "OK")
    private WebElementFacade receiptAdd;
    public void clickAdd()
    {
        receiptAdd.click();
    }




    public boolean pageIsOpened(){

        if(getDriver().getCurrentUrl().equals(URL)) return true;

        return false;
    }

    public void openAddReceiptPage()
    {
        this.open();

    }


}
