package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class TopMenuTest extends Utility {
    String baseUrl = " http://tutorialsninja.com/demo/index.php?";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    //1.1 create method with name "selectMenu" it has one parameter name "menu" of type string
    //1.2 This method should click on the menu whatever name is passed as parameter.
    public void selectMenu(String menu, By by){
        List<WebElement> names = driver.findElements(by);
        for (WebElement name : names){
            if(name.getText().equalsIgnoreCase(menu)){
                name.click();
                break;
            }
        }
    }
    @Test
    public void  verifyUserShouldNavigateToDesktopsPageSuccessfully(){
        //1.1 Mouse hover on “Desktops” Tab and click
        mouseHoverToElementAndClick(By.xpath("//a[normalize-space()='Desktops']));"));
        //1.2 call selectMenu method and pass the menu = “Show All Desktops”
        selectMenu("Show All Desktops", By.xpath("//a[contains(text(),'Show All Desktops')]"));
        //1.3 Verify the text ‘Desktops’
        verifyExpectedAndActual(By.xpath("//h2[contains(text(),'Desktops')]"),"Desktops");
    }
    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){
        //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        mouseHoverToElementAndClick(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        //2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        selectMenu("Show AllLaptops & Notebooks",By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]"));
        //2.3 Verify the text ‘Laptops & Notebooks’
        verifyExpectedAndActual(By.xpath("//h2[contains(text(),'Laptops & Notebooks')]"),"Laptops & Notebooks");
    }
    @Test
    public void  verifyUserShouldNavigateToComponentsPageSuccessfully(){
        //3.1 Mouse hover on “Components” Tab and click
        mouseHoverToElementAndClick(By.xpath("//a[normalize-space()='Components']"));
        //3.2 call selectMenu method and pass the menu = “Show All Components”
        selectMenu("Show All Components", By.xpath("//a[contains(text(),'Show All Components')]"));
        //3.3 Verify the text ‘Components’
        verifyExpectedAndActual(By.xpath("//h2[contains(text(),'Components')]"),"Components");
    }
    @After
    public void tearDown(){
       // closeBrowser();
    }
}
