package myaccount;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class MyAccountTest extends Utility {
    String baseUrl = " http://tutorialsninja.com/demo/index.php?";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    public void selectMyAccountOptions(String option, By by){
        //1.1 create method with name "selectMyAccountOptions" it has one parameter name option" of type string
        //1.2 This method should click on the options whatever name is passed as parameter.
        //(Hint: Handle List of Element and Select options)
        List<WebElement> options = driver.findElements(by);
        for (WebElement name : options) {
            if (name.getText().equalsIgnoreCase(option)) {
                name.click();
                break;
            }
        }
    }
    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully(){
        //1.1 Clickr on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter "Register"
        selectMyAccountOptions("Register",By.xpath("//a[contains(text(),'Register')]"));
        //1.3 Verify the text “Register Account”
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Register Account')]"),"Register Account");

    }
    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully(){
        //2.1 Clickr on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //2.2 Call the method “selectMyAccountOptions” method and pass the parameter //“Login”
        selectMyAccountOptions("Login",By.xpath("//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
        //2.3 Verify the text “Returning Customer
        verifyExpectedAndActual(By.xpath("//h2[contains(text(),'Returning Customer')]"),"Returning Customer");
    }
    @Test
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
        //3.1 Clickr on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register",By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']"));
        //3.3 Enter First Name
        sendTextToElement(By.xpath("//input[@id='input-firstname']"),"Gautam");
        //3.4 Enter Last Name
        sendTextToElement(By.xpath("//input[@id='input-lastname']"),"Patel");
        //3.5 Enter Email
        sendTextToElement(By.xpath("//input[@id='input-email']"),"gautampatel1@gmail.com");
        //3.6 Enter Telephone
        sendTextToElement(By.xpath("//input[@id='input-telephone']"),"020546353564");
        //3.7 Enter Password
        sendTextToElement(By.xpath("//input[@name = 'password']"),"Password1");
        //3.8 Enter Password Confirm
        sendTextToElement(By.xpath("//input[@name = 'confirm']"),"Password1");
        //3.9 Select Subscribe Yes radio button
        clickOnElement(By.xpath("//label[normalize-space()='Yes']"));
        //3.10 Click on Privacy Policy check box
        clickOnElement(By.xpath("//input[@name='agree']"));
        Thread.sleep(2000);
        //3.11 Click on Continue button
        clickOnElement(By.xpath("//input[@value='Continue']"));
        //3.12 Verify the message “Your Account Has Been Created!”
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]"),"Your Account Has Been Created!");
        //3.13 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
        //3.14 Clickr on My Account Link.
        clickOnElement(By.xpath("//body/div[@id='account-account']/div[1]/aside[1]/div[1]/a[1]"));
        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter
        //“Logout”
        selectMyAccountOptions("Logout",By.xpath("//body/div[@id='account-account']/div[1]/aside[1]/div[1]/a[13]"));
        //3.16 Verify the text “Account Logout”
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Account Logout')]"),"Account Logout");
        //3.17 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
    }
    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException{
        //4.1 Clickr on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter
        //“Login”
        selectMyAccountOptions("Login",By.xpath("//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
        //4.3 Enter Email address
        sendTextToElement(By.xpath("//input[@id='input-email']"),"gautampatel1@gmail.com");
        //4.5 Enter Password
        sendTextToElement(By.xpath("//input[@id='input-password']"),"Password1");
        //4.6 Click on Login button
        clickOnElement(By.xpath("//input[@class = 'btn btn-primary']"));
        //4.7 Verify text “My Account”
        verifyExpectedAndActual(By.xpath("//body/div[@id='account-account']/div[1]/aside[1]/div[1]/a[1]"),"My Account");
        Thread.sleep(3000);
        //4.8 Clickr on My Account Link.
        clickOnElement(By.xpath("//body/div[@id='account-account']/div[1]/aside[1]/div[1]/a[1]"));
        //4.9 Call the method “selectMyAccountOptions” method and pass the parameter
        //“Logout”
        selectMyAccountOptions("Logout",By.xpath("//body/div[@id='account-account']/div[1]/aside[1]/div[1]/a[13]"));
        //4.10 Verify the text “Account Logout”
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Account Logout')]"),"Account Logout");
        //4.11 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

    }
    @After
    public void tearDown(){
       // closeBrowser();
    }

}
