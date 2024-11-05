package pages;
import static helper.Utility.driver;

import org.openqa.selenium.By;

import static org.junit.Assert.assertTrue;
import  org.assertj.core.api.Assertions;
import java.util.concurrent.TimeUnit;



public class WebPages {

    By input_username = By.id("user-name");

    By input_password = By.id("password");

    By lgn_btn        = By.id("login-button");

    By icon_cart      = By.xpath("//div[@id='shopping_cart_container']/a[1]");

    By icon_cart_item = By.xpath("//span[@class='shopping_cart_badge']");

    By addtocart      = By.xpath("(//*[text()='Add to cart'])[1]");

    By remove_cart    = By.xpath("(//*[text()='Remove'])[1]");

    By checkout       = By.xpath("//button[@id='checkout']");

    By firstname      = By.xpath("//input[@id='first-name']");

    By lastname       = By.xpath("//input[@id='last-name']");

    By zipcode        = By.xpath("//input[@id='postal-code']");

    By continuebutton = By.xpath("//input[@id='continue']");

    By show_cart_item = By.xpath("//div[@class='cart_list']");

    By finish_button  = By.xpath("//button[@id='finish']");

    By mssg_checkout  = By.xpath("//h2[@class='complete-header']");

    By hamburger_icon = By.xpath("//button[@id='react-burger-menu-btn']");

    By logout_menu    = By.xpath("//a[@id='logout_sidebar_link']");

    By sidebar        = By.xpath("//div[@class='bm-menu']");

    By error_msg(String msg){
        return By.xpath("//*[contains(text (), '"+ msg +"')]");
    }


    public void openbrowser(){
        driver.get("https://www.saucedemo.com/");
    }
    public void inputUsername(String username){
        driver.findElement(input_username).sendKeys(username);
        System.out.println("username : " + username);
    }
    public void inputPassword(String password){
        driver.findElement(input_password).sendKeys(password);
        System.out.println("password : " + password);
    }
    public void loginButton(){

        driver.findElement(lgn_btn).click();
    }

    public void asserticoncart(){
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(icon_cart).isDisplayed();
    }

    //verify error message
    public void  asserterrormsg(String errMsg){

        Boolean displayed = driver.findElement(error_msg(errMsg)).isDisplayed();
        System.out.println("isDisplayed: " + displayed); // Mencetak nilai boolean

        assertTrue("Element not shown", displayed);
        System.out.println(driver.findElement(error_msg(errMsg)).getText());
    }

    //Test login web and add item to cart
    public void clickAddToCart(){
        driver.findElement(addtocart).click();
    }

    //assert item cart
    public void assertCartItem(String cartItem){
        String expectedItem = cartItem;
        String actualItem   = driver.findElement(icon_cart_item).getText();

        Assertions.assertThat(actualItem).isEqualTo(expectedItem);

        System.out.println("expected item : " + expectedItem);
        System.out.println("actual item : " + actualItem);
    }

    //remove item
    public void clickRemoveItem(){
        driver.findElement(remove_cart).click();
    }

    public void clickIconCart(){
        driver.findElement(icon_cart).click();
    }
    //checkout
    public void clickCheckout(){
        driver.findElement(checkout).click();
    }
    //input information
    public void inputFirstName(String firstName){
        driver.findElement(firstname).sendKeys(firstName);

        System.out.println("First name : " + firstName);
    }

    public void inputLastName(String lastName){
        driver.findElement(lastname).sendKeys(lastName);

        System.out.println("Last name : " + lastName);
    }
    public void inputZip(Integer Zip){
        driver.findElement(zipcode).sendKeys(Zip.toString());

        System.out.println("Zip or postalcode : " + Zip);
    }
    //continue button
    public void clickcontinue(){
        driver.findElement(continuebutton).click();
    }
    //Show cart list
    public void showCartItem(){
        driver.findElement(show_cart_item).isDisplayed();
    }
    //finish button
    public void clickFinish(){
        driver.findElement(finish_button).click();
    }

    public void message(String mssg){
        String expectedmssg = mssg;
        String actualmssg  = driver.findElement(mssg_checkout).getText();

        Assertions.assertThat(actualmssg).isEqualTo(expectedmssg);

        System.out.println("expected item : " + expectedmssg);
        System.out.println("actual item : " + actualmssg);
    }
    //logout
    public void clickHumbergerIcon(){
        driver.findElement(hamburger_icon).click();
    }
    //verify sidebar
    public void verifysidebar(){
        driver.findElement(sidebar).isDisplayed();
    }
    //click logout
    public void clickLogoutMenu(){
        driver.findElement(logout_menu).click();
    }
}
