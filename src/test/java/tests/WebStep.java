package tests;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.WebPages;

public class WebStep {

    WebPages webPages;

    public WebStep () {
        this.webPages = new WebPages();
    }

    @Given("open web login page")
    public void openWebLoginPage() {
        webPages.openbrowser();
    }

    @And("user input username {string}")
    public void userInputUsername(String username) {
        webPages.inputUsername(username);
    }

    @And("user input password {string}")
    public void userInputPassword(String password) {
        webPages.inputPassword(password);
    }

    @And("user click button login")
    public void userClickButtonLogin() {
        webPages.loginButton();
    }

    @And("user will see icon cart")
    public void userWillSeeIconCart() {
        webPages.asserticoncart();
}

    @And("user will see error message {string}")
    public void userWillSeeErrorMessage(String errMsg) {
        webPages.asserterrormsg(errMsg);
    }

    @And("user add item to cart")
    public void userAddItemToCart() {
        webPages.clickAddToCart();
    }

    @Then("verify cart item is match {string}")
    public void verifyCartItemIsMatch(String cartItem) {
        webPages.assertCartItem(cartItem);
    }

    @And("user remove item")
    public void userRemoveItem() {
        webPages.clickRemoveItem();
    }

    @Then("user click icon cart")
    public void userClickIconCart() {
        webPages.clickIconCart();
    }

    @And("user click checkout")
    public void userClickCheckout() {
        webPages.clickCheckout();
    }

    @And("user input FirstName {string}")
    public void userInputFirstName(String firstName) {
        webPages.inputFirstName(firstName);
    }

    @And("user input LastName {string}")
    public void userInputLastName(String lastName) {
        webPages.inputLastName(lastName);
    }


    @And("user input Zip atau PostalCode {int}")
    public void userInputZipAtauPostalCode(Integer Zip) {
        webPages.inputZip(Zip);
    }

    @And("user click continue button")
    public void userClickContinueButton() {
        webPages.clickcontinue();
    }

    @Then("verify cart item will shown")
    public void verifyCartItemWillShown() {
        webPages.showCartItem();
    }

    @And("user click finish button")
    public void userClickFinishButton() {
        webPages.clickFinish();
    }

    @Then("user will see message {string}")
    public void userWillSeeMessage(String mssg) {
        webPages.message(mssg);
    }

    @And("user click menu icon on the left")
    public void userClickMenuIconOnTheLeft() {
        webPages.clickHumbergerIcon();
    }

    @Then("verify the sidebar will shown")
    public void verifyTheSidebarWillShown() {
        webPages.verifysidebar();
    }

    @And("user click logout menu")
    public void userClickLogoutMenu() {
        webPages.clickLogoutMenu();
    }
}
