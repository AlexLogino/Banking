package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddCustomerPage extends HeaderPage {

    @FindBy(css = "[ng-model='fName']")
    private WebElement textFirstName;
    @FindBy(css = "[ng-model='lName']")
    private WebElement textLastName;
    @FindBy(css = "[ng-model='postCd']")
    private WebElement textPostCode;
    @FindBy(xpath = "//button[@class='btn btn-default']")
    private WebElement btnAddCustomer;
    public AddCustomerPage(WebDriver driver){
        super(driver);
    }

    public Boolean isTextFirstNameDisplayed(){
        return getWait3().until(ExpectedConditions.visibilityOf(textFirstName)).isDisplayed();
    }

    public Boolean isTextLastNameDisplayed(){
        return getWait3().until(ExpectedConditions.visibilityOf(textLastName)).isDisplayed();
    }

    public Boolean isTextPostCodeDisplayed(){
        return getWait3().until(ExpectedConditions.visibilityOf(textPostCode)).isDisplayed();
    }

    public Boolean isBtnAddCustomerDisplayed(){
        return getWait3().until(ExpectedConditions.visibilityOf(btnAddCustomer)).isDisplayed();
    }

    public AddCustomerPage setFirstName(String name){
        getWait3().until(ExpectedConditions.visibilityOf(textFirstName)).sendKeys(name);

        return this;
    }

    public AddCustomerPage setLastName(String name){
        getWait3().until(ExpectedConditions.visibilityOf(textLastName))
                .sendKeys(name);

        return this;
    }

    public AddCustomerPage setPostCode(String name){
        getWait3().until(ExpectedConditions.visibilityOf(textPostCode))
                .sendKeys(name);

        return this;
    }

    public AddCustomerPage clickAddCustomer(){
        getWait3().until(ExpectedConditions.visibilityOf(btnAddCustomer))
                .click();

        return this;
    }

    public BankManagerPage clickAddCustomerWithEmptyField(){
        getWait3().until(ExpectedConditions.visibilityOf(btnAddCustomer))
                .click();

        return new BankManagerPage(getDriver());
    }

    public String textAlertNewCustomer(){
        return getDriver().switchTo().alert().getText();
    }

    public BankManagerPage acceptAlertNewCustomer(){
        getDriver().switchTo().alert().accept();

        return new BankManagerPage(getDriver());
    }

    public AddCustomerPage acceptAlertReCustomer(){
        getDriver().switchTo().alert().accept();

        return this;
    }
}
