package desktops;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class DesktopsTest extends Utility {
    String baseUrl = " http://tutorialsninja.com/demo/index.php?";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {
        //1.1 Mouse hover on Desktops Tab.and click
        mouseHoverToElementAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));
        //1.2 Click on “Show All Desktops”
        clickOnElement(By.xpath("//a[contains(text(),'Show AllDesktops')]"));
        //1.3 Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"),"Name (Z - A)");
        //1.4 Verify the Product will arrange in Descending order
        verifyExpectedAndActual(By.xpath("//option[contains(text(),'Name (Z - A)')]"),"Name (Z - A)");
    }
    @Test
    public void  verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException{
        Thread.sleep(2000);
        //2.1 Mouse hover on Desktops Tab. and click
        mouseHoverToElementAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));
        //2.2 Click on “Show All Desktops”
        clickOnElement(By.linkText("Show AllDesktops"));
        Thread.sleep(2000);
        //2.3 Select Sort By position "Name: A to Z"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"),"Name (A - Z)");
        //2.4 Select product “HP LP3065”
        clickOnElement(By.xpath("//a[contains(text(),'HP LP3065')]"));
        //2.5 Verify the Text "HP LP3065"
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'HP LP3065')]"),"HP LP3065");
        //2.6 Select Delivery Date "2022-11-30"
        //selectByVisibleTextFromDropDown(By.xpath("//input[@id='input-option225']"),"2022-11-30");
        String year = "2022";
        String month = "November";
        String date = "30";
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@class = 'btn btn-default']/i[@class='fa fa-calendar']"));
        while(true){
            String monthYear = driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[2]")).getText();
            String arr[] = monthYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if(mon.equalsIgnoreCase(month)&& yer.equalsIgnoreCase(year)){
                break;
            }else{
                clickOnElement(By.xpath("//body[1]/div[4]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[3]"));
            }
        }
        //select Date
        List<WebElement> allDates = driver.findElements(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/table[1]/tbody[1]/tr[5]/td[3]"));
        for(WebElement dt : allDates){
            if(dt.getText().equalsIgnoreCase(date)){
                dt.click();
                break;
            }
        }
        //2.7.Enter Qty "1” using Select class.
        clearText(By.xpath("//input[@id='input-quantity']"));
        sendTextToElement(By.xpath("//input[@id='input-quantity']"),"1");
        Thread.sleep(2000);
        //2.8 Click on “Add to Cart” button
        clickOnElement(By.xpath("//button[@id='button-cart']"));
        //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        verifyExpectedAndActual(By.xpath("//div[@class='alert alert-success alert-dismissible']"),"Success: You have added HP LP3065 to your shopping cart!\n" +
                "×");
        //2.10 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//span[contains(text(),'Shopping Cart')]"));
        Thread.sleep(2000);
        //2.11 Verify the text "Shopping Cart"
        verifyExpectedAndActual(By.xpath("//a[contains(text(),'Shopping Cart')]"),"Shopping Cart");
        Thread.sleep(2000);
        //2.12 Verify the Product name "HP LP3065"
        verifyExpectedAndActual(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"),"HP LP3065");
        //2.13 Verify the Delivery Date "2022-11-30"
        verifyExpectedAndActual(By.xpath("//small[contains(text(),'Delivery Date:2022-11-30')]"),"Delivery Date:2022-11-30");
        //2.14 Verify the Model "Product21"
        verifyExpectedAndActual(By.xpath("//td[contains(text(),'Product 21')]"),"Product 21");
        //2.15 Verify the Todat "£74.73"
        verifyExpectedAndActual(By.xpath("//tbody/tr[1]/td[6]"),"$122.00");
    }
    @After
    public void tearDown(){
        //closeBrowser();
    }
}
