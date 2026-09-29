package tests;

import base.BaseTest;
import pages.InternetPageActions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TheInternet extends BaseTest {

    InternetPageActions internetPageActions;

    @BeforeMethod(alwaysRun = true)
    public void setUpPageActions() {
        internetPageActions = new InternetPageActions(driver);
    }

    //01
    @Test(groups = "regression")
    public void splitTest(){
        // Fetch Page Title and compare using Assertion
        internetPageActions.splitTestCompareAssertion();
    }

    //02
    @Test(groups = {"smoke", "regression"})
    public void addRemoveElements(){
        internetPageActions.addRemoveElements();
    }

    //03
    @Test(groups = {"smoke", "regression"})
    public void verifyCheckboxes(){
        internetPageActions.verifyCheckboxes();
    }

    //04
    @Test(groups = "regression")
    public void verifyContextMenu(){
        internetPageActions.verifyContextMenu();
    }

    //05
    @Test(groups = "regression")
    public void dragAndDrop(){
        internetPageActions.dragAndDrop();
    }

    //06
    @Test(groups = "regression")
    public void dropDown(){
        internetPageActions.dropDown();
    }

    //07
    @Test(groups = "regression")
    public void verifyDynamicControls(){
        internetPageActions.verifyDynamicControls();
    }

    //08
    @Test(groups = "regression")
    public void verifyEntryAd(){
        internetPageActions.verifyEntryAd();
    }

    //09
    @Test(groups = "regression")
    public void verifyFileDownloader(){
        internetPageActions.verifyFileDownloader();
    }

    //10
    @Test(groups = "regression")
    public void verifyFileUpload(){
        internetPageActions.verifyFileUpload();
    }

    //11
    @Test(groups = {"smoke", "regression"})
    public void login(){
        internetPageActions.login();
    }

    //12
    @Test(groups = "regression")
    public void handleHover(){
        internetPageActions.handleHover();
    }

    //13
    @Test(groups = "regression")
    public void inputNumber(){
        internetPageActions.inputNumber();
    }
}
