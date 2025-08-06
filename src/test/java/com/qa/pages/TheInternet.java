package com.qa.pages;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.time.*;
import java.util.List;

import javax.swing.Action;

public class TheInternet {

    WebDriver driver = new ChromeDriver();
    WebDriverWait wait;
    String URL = "https://the-internet.herokuapp.com/";
    String TitleName = "The Internet";
    String link_abtest = "//a[@href=\"/abtest\"]";
    String text_abtest = "//*[@id='content']/div/h3";
    String link_addRemove = "//a[@href=\"/add_remove_elements/\"]";
    String link_checkBoxes = "//a[@href=\"/checkboxes\"]";
    String link_contextMenu = "//a[@href=\"/context_menu\"]";
    String link_dragDrop = "//a[@href=\"/drag_and_drop\"]";
    String link_dropDown = "//a[@href=\"/dropdown\"]";
    String link_dynamicContent = "//a[@href=\"/dynamic_content\"]";
    String link_dynamicControls = "//a[@href=\"/dynamic_controls\"]";
    String link_dynamicLoading = "//a[@href=\"/dynamic_loading\"]";
    String link_entryAd = "//a[@href=\"/entry_ad\"]";
    String link_exitIntent = "//a[@href=\"/exit_intent\"]";
    String link_fileDownload = "//a[@href=\"/download\"]";
    String link_fileUpload = "//a[@href=\"/upload\"]";
    String link_floatingMenu = "//a[@href=\"/floating_menu\"]";
    String link_forgotPassword = "//a[@href=\"/forgot_password\"]";
    String link_formAuth = "//a[@href=\"/login\"]";
    String link_iframes = "//a[@href=\"/frames\"]";
    String link_geoLoc = "//a[@href=\"/geolocation\"]";
    String link_horizontalSlider = "//a[@href=\"/horizontal_slider\"]";
    String link_hovers = "//a[@href=\"/hovers\"]";
    String link_infiniteScroll = "//a[@href=\"/infinite_scroll\"]";
    String link_inputs = "//a[@href=\"/inputs\"]";
    String link_jQueryUIMenu = "//a[@href=\"/jqueryui/menu\"]";
    String link_jsAlerts = "//a[@href=\"/javascript_alerts\"]";
    String link_jsError = "//a[@href=\"/javascript_error\"]";
    String link_keyPresses = "//a[@href=\"/key_presses\"]";
    String link_deepDOM = "//a[@href=\"/large\"]";
    String link_multipleWindows = "//a[@href=\"/windows\"]";
    String link_nestedFrames = "//a[@href=\"/nested_frames\"]";
    String link_notificationMsgs = "//a[@href=\"/notification_message\"]";
    String link_redirector = "//a[@href=\"/redirector\"]";
    String link_secureFileDownload = "//a[@href=\"/download_secure\"]";
    String link_shadowDOM = "//a[@href=\"/shadowdom\"]";
    String link_shiftingContent = "//a[@href=\"/shifting_content\"]";
    String link_slowResources = "//a[@href=\"/slow\"]";
    String link_sortableTables = "//a[@href=\"/tables\"]";
    String btn_delete = "//button[@class=\"added-manually\"]";
    String btn_addElement = "//button[@onclick=\"addElement()\"]";

    @BeforeTest
    public void setUp(){
        driver.navigate().to(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    //01
    @Test
    @Ignore
    public void splitTest(){
        // Fetch Page Title and compare using Assertion
        String title = driver.getTitle();
        System.out.println("Page title is "+title);
        assertEquals(TitleName,title);
        driver.findElement(By.xpath(link_abtest)).click();
        String text = driver.findElement(By.xpath(text_abtest)).getText();
        System.out.println(text);
    }

    //02
    @Test
    @Ignore
    public void addRemoveElements(){
        driver.findElement(By.xpath(link_addRemove)).click();
        // Verify delete button is not displayed by default
        boolean buttonDisplayed = driver.findElements(By.xpath(btn_delete)).size() > 0;
        assertFalse(buttonDisplayed,"Delete button is not displayed as expected");

        // Add and Remove elements
        for(int i = 0; i < 3; i++){
            driver.findElement(By.xpath(btn_addElement)).click();
        }
        int count = driver.findElements(By.xpath(btn_delete)).size();
        System.out.println("Delete button is added "+count+ " times");
        
        //Remove added buttons
        for(int i = 0; i < 2; i++){
            String deletebtn = "//button[@class=\"added-manually\"][" + (i + 1) + "]";
            driver.findElement(By.xpath(deletebtn)).click();
        }
    }

    //03
    @Test
    @Ignore
    public void verifyCheckboxes(){
        driver.findElement(By.xpath(link_checkBoxes)).click();

        //verify checkbox 2 is selected by default
        boolean checkboxSelected = driver.findElement(By.xpath("//input[@type=\"checkbox\"][2]")).isSelected();
        assertTrue(checkboxSelected,"Checkbox 2 is selected as expected");

        //select checkbox 1
        driver.findElement(By.xpath("//input[@type=\"checkbox\"][1]")).click();

        //verify checkbox 1 is selected
        boolean checkboxSelected2 = driver.findElement(By.xpath("//input[@type=\"checkbox\"][1]")).isSelected();
        assertTrue(checkboxSelected2,"Checkbox 1 is selected as expected");
    }

    //04
    @Test
    @Ignore
    public void verifyContextMenu(){
        driver.findElement(By.xpath(link_contextMenu)).click();

        //Rightclick
        Actions action = new Actions(driver);
        action.contextClick(driver.findElement(By.xpath("//div[@id=\"hot-spot\"]"))).perform();

        //Handle Alert box with ok button
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    //05
    @Test
    @Ignore
    public void dragAndDrop(){
        driver.findElement(By.xpath(link_dragDrop)).click();
        
        //Drag and drop
        WebElement drag = driver.findElement(By.xpath("//div[@id=\"column-a\"]"));
        WebElement drop = driver.findElement(By.xpath("//div[@id=\"column-b\"]"));
        Actions action = new Actions(driver);
        action.dragAndDrop(drag, drop).perform();
    }

    //06
    @Test
    @Ignore
    public void dropDown(){
        driver.findElement(By.xpath(link_dropDown)).click();

        //select one option from drop down
        Select select = new Select(driver.findElement(By.id("dropdown")));
        select.selectByVisibleText("Option 1");

        WebElement selectedOpt = select.getFirstSelectedOption();
        System.out.println(selectedOpt);
    }

    //07
    @Test
    @Ignore
    public void verifyDynamicControls(){
        driver.findElement(By.xpath(link_dynamicControls)).click();

        //select checkbox, click remove button and verify checkbox is not present
        driver.findElement(By.xpath("//input[@type=\"checkbox\"]")).click();

        driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/button")).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> driver.findElement(By.xpath("//*[@id=\"message\"]")).isDisplayed());
        String text = driver.findElement(By.xpath("//*[@id=\"message\"]")).getText();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        assertEquals("It's gone!",text);

        //verify textfield is disbaled, Enable textfield and verify
        Boolean textField = driver.findElement(By.xpath("//input[@type=\"text\"]")).isEnabled();
        if(textField==false){
            driver.findElement(By.xpath("//*[@id=\"input-example\"]/button")).click();
        }
        wait.until(driver -> driver.findElement(By.xpath("//input[@type=\"text\"]")).isEnabled());
        driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("Tejaswi");
    }

    //08
    @Test
    @Ignore
    public void verifyEntryAd(){
        driver.findElement(By.xpath(link_entryAd)).click();

        driver.findElement(By.xpath("//a[@id=\"restart-ad\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"modal\"]")).isDisplayed();
        //handle modal by clicking on modal
        driver.findElement(By.xpath("//*[@id=\"modal\"]/div[2]/div[3]/p")).click();
    }

    //09
    @Test
    @Ignore
    public void verifyFileDownloader(){
        driver.findElement(By.xpath(link_fileDownload)).click();
        List<WebElement> links = driver.findElements(By.xpath("//div[@class='example']//a"));
        assertTrue(links.size() > 0, "No files found for download.");

        // Print all file names
        for (WebElement link : links) {
            System.out.println("Download link: " + link.getText());
        }

        // click the first file to download
        links.get(0).click();
    }

    //10
    @Test
    @Ignore
    public void verifyFileUpload(){
        driver.findElement(By.xpath(link_fileUpload)).click();
        String userHome = System.getProperty("user.home");
        String filePath = userHome + "\\Documents\\UI_Automation\\UI_Automation\\src\\test\\resources\\File.txt";
        driver.findElement(By.xpath("//input[@id=\"file-upload\"]")).sendKeys(filePath);
        driver.findElement(By.xpath("//input[@id=\"file-submit\"]")).click();
    }

    //11
    @Test
    @Ignore
    public void login(){
        driver.findElement(By.xpath(link_formAuth)).click();
        //verify wrong credentials error message
        driver.findElement(By.xpath("//input[@id=\"username\"]")).sendKeys("WrongUserName");
        driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("WrongPasword");
        driver.findElement(By.xpath("//*[@id=\"login\"]/button/i")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//div[@class=\"flash error\"]")).isDisplayed();

        //Login positive scenerio
        driver.findElement(By.xpath("//input[@id=\"username\"]")).sendKeys("tomsmith");
        driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//*[@id=\"login\"]/button/i")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//div[@class=\"flash success\"]")).isDisplayed();
    }

    //12
    @Test
    @Ignore
    public void handleHover(){
        driver.findElement(By.xpath(link_hovers)).click();
        Actions actions = new Actions(driver);
        //Hover to display the user profile link
        actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/img"))).perform();
        driver.findElement(By.xpath("//a[@href=\"/users/1\"]")).click();
    }

    //13
    @Test
    public void inputNumber(){
        driver.findElement(By.xpath(link_inputs)).click();

        //Verify only numbers are able to input
        WebElement inputField = driver.findElement(By.xpath("//input[@type=\"number\"]"));
        inputField.sendKeys("Teju");
        String enteredValue = inputField.getAttribute("value");
        if (enteredValue.isEmpty()) {
            System.out.println("PASS: Field accepts only numbers.");
        } else {
            System.out.println("FAIL: Field accepts non-numeric characters: " + enteredValue);
        }
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
