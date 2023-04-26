package laptopsandnotebooks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LaptopsAndNotebooksTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully(){
       //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        mouseHoverToElementAndClick(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        //1.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]"));
        //1.3 Select Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"),"Price (High > Low)");
        //1.4 Verify the Product price will arrange in High to Low order.
        verifyExpectedAndActual(By.xpath("//option[contains(text(),'Price (High > Low)')]"), "Price (High > Low)");
    }
    @Test
    public void  verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        //2.1 Mouse hover on Laptops & Notebooks Tab and click
        mouseHoverToElementAndClick(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        //2.2 Click on “Show All Laptops & Notebooks”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]"));
        //2.3 Select Sort By "Price (High > Low)"
        clickOnElement(By.xpath("//select[@id='input-sort']"));
        //Select sortBy = new Select(driver.findElement(By.xpath("//select[@id='input-sort']")));
        //sortBy.selectByValue("http://tutorialsninja.com/demo/index.php?route=product/category&path=18&sort=p.price&order=DESC");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"),"Price (High > Low)");
        //2.4 Select Product “MacBook”
        clickOnElement(By.xpath("//body/div[@id='product-category']/div[1]/div[1]/div[4]/div[4]/div[1]/div[2]/div[1]/h4[1]/a[1]"));
        //2.5 Verify the text “MacBook”
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'MacBook')]"), "MacBook");
        //2.6 Click on ‘Add To Cart’ button
        clickOnElement(By.xpath("//button[@id='button-cart']"));
        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        verifyExpectedAndActual(By.xpath("//div[@class = 'alert alert-success alert-dismissible']"), "Success: You have added MacBook to your shopping cart!\n" +
                "×");
        Thread.sleep(2000);
        //2.8 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
        //2.9 Verify the text "Shopping Cart"
        verifyExpectedAndActual(By.xpath("//a[contains(text(),'Shopping Cart')]"), "Shopping Cart");
        //2.10 Verify the Product name "MacBook"
        verifyExpectedAndActual(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"), "MacBook");
        Thread.sleep(2000);
        //2.11 Change Quantity "2"
        clearText(By.xpath("//input[@value = '1']"));
        sendTextToElement(By.xpath("//input[@value = '1']"), "2");
        //2.12 Click on “Update” Tab
        clickOnElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/span[1]/button[1]/i[1]"));
        //2.13 Verify the message “Success: You have modified your shopping cart!”
        verifyExpectedAndActual(By.xpath("//div[@class = 'alert alert-success alert-dismissible']"), "Success: You have modified your shopping cart!\n" +
                "×");
        //2.14 Verify the Total £737.45
        verifyExpectedAndActual(By.xpath("//tbody//tr//td[6]"), "$1,204.00");
        //2.15 Click on “Checkout” button
        clickOnElement(By.xpath("//a[contains(text(),'Checkout')]"));
        Thread.sleep(2000);
        //2.16 Verify the text “Checkout”
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Checkout')]"), "Checkout");
        //2.17 Verify the Text “New Customer”
        verifyExpectedAndActual(By.xpath("//h2[contains(text(),'New Customer')]"), "New Customer");
        //2.18 Click on “Guest Checkout” radio button
        clickOnElement(By.xpath("//input[@value = 'guest']"));
        //2.19 Click on “Continue” tab
        clickOnElement(By.xpath("//input[@id='button-account']"));
        //2.20 Fill the mandatory fields
        sendTextToElement(By.xpath("//input[@id = 'input-payment-firstname']"), "Manan");
        sendTextToElement(By.xpath("//input[@id = 'input-payment-lastname']"), "Shah");
        sendTextToElement(By.xpath("//input[@id = 'input-payment-email']"), "test123@gmail.com");
        sendTextToElement(By.xpath("//input[@id = 'input-payment-telephone']"), "0203456789");
        sendTextToElement(By.xpath("//input[@id = 'input-payment-address-1']"), "21 Luton Road");
        sendTextToElement(By.xpath("//input[@id = 'input-payment-city']"), "Luton");
        sendTextToElement(By.xpath("//input[@id = 'input-payment-postcode']"), "HA8 9HU");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-payment-country']"), "United Kingdom");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-payment-zone']"), "Kent");
        Thread.sleep(2000);
        //2.21 Click on “Continue” Button
        clickOnElement(By.xpath("//input[@id='button-guest']"));
        //2.22 Add Comments About your order into text area
        sendTextToElement(By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/p[2]/textarea[1]"),
                "Please Confirm Delivery date.");
        //2.23 Check the Terms & Conditions check box
        clickOnElement(By.xpath("//input[@name= 'agree']"));
        //2.24 Click on “Continue” button
        clickOnElement(By.xpath("//input[@id='button-payment-method']"));
        //2.25 Verify the message “Warning: Payment method required!”
        verifyExpectedAndActual(By.xpath("//div[@class= 'alert alert-danger alert-dismissible']"),
                "Warning: Payment method required!\n" +
                        "×");
    }
    @After
    public void tearDown(){
       // closeBrowser();
    }
}
