package pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends HeaderPage {
    @FindBy(xpath = "//button[@ng-click='customer()']")
    private WebElement btnCustomerLogin;

    @FindBy(xpath = "//button[@ng-click='manager()']")
    private WebElement btnBankManagerLogin;



    public HomePage(WebDriver driver){
        super(driver);
    }
    public BankManagerPage clickBankManagerLogin(){
        getWait3().until(ExpectedConditions.visibilityOf(btnBankManagerLogin));
        btnBankManagerLogin.click();

        return new BankManagerPage(getDriver());
    }

    public CustomerPage clickCustomerLogin(){
        getWait3().until(ExpectedConditions.visibilityOf(btnCustomerLogin));
        btnCustomerLogin.click();

        return new CustomerPage(getDriver());
    }

    public Boolean isBtnBankManagerLoginDisplayed(){
        getWait3().until(ExpectedConditions.visibilityOf(btnBankManagerLogin));

        return btnBankManagerLogin.isDisplayed();
    }

    public Boolean isBtnCustomerLoginDisplayed(){
        getWait3().until(ExpectedConditions.visibilityOf(btnCustomerLogin));

        return btnCustomerLogin.isDisplayed();
    }
}
