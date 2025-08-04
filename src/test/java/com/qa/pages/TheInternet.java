package com.qa.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import java.time.*;

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
    String link_dynamicCOntrols = "//a[@href=\"/dynamic_controls\"]";
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

    @Test
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

    @AfterTest
    public void tearDown(){
        //driver.quit();
    }
}
