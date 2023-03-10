package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OpenAccountPage extends HeaderPage {

    @FindBy(name = "userSelect")
    private WebElement selectCustomerName;

    @FindBy(name = "currency")
    private WebElement selectCurrency;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnProcess;

    @FindBy(xpath = "//option[@value='Pound']")
    private WebElement selectPound;

    @FindBy(xpath = "//option[@value='Dollar']")
    private WebElement selectDollar;

    @FindBy(xpath = "//option[@value='Rupee']")
    private WebElement selectRupee;

    public OpenAccountPage(WebDriver driver){
        super(driver);
    }

    public Boolean isSelectCustomerNameDisplayed(){
        return getWait3().until(ExpectedConditions.visibilityOf(selectCustomerName)).isDisplayed();
    }

    public Boolean isSelectCurrencyDisplayed(){
        return getWait3().until(ExpectedConditions.visibilityOf(selectCurrency)).isDisplayed();
    }

    public Boolean isBtnProcessDisplayed(){
        return getWait3().until(ExpectedConditions.visibilityOf(btnProcess)).isDisplayed();
    }

    public OpenAccountPage selectCustomerName(String name){
        getWait3().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//option[text()='" + name + "']")))
                .click();
        return this;
    }

    public OpenAccountPage selectCurrencyPound(){
        getWait3().until(ExpectedConditions.visibilityOf(selectPound)).click();
        return this;
    }

    public OpenAccountPage selectCurrencyDollar(){
        getWait3().until(ExpectedConditions.visibilityOf(selectDollar)).click();
        return this;
    }

    public OpenAccountPage selectCurrencyRupee(){
        getWait3().until(ExpectedConditions.visibilityOf(selectRupee)).click();
        return this;
    }

    public OpenAccountPage clickBtnProcess(){
        getWait3().until(ExpectedConditions.visibilityOf(btnProcess)).click();

        return this;
    }

    public BankManagerPage clickBtnProcessWithoutField(){
        getWait3().until(ExpectedConditions.visibilityOf(btnProcess)).click();

        return new BankManagerPage(getDriver());
    }

    public BankManagerPage acceptAlertNewAccount(){
        getDriver().switchTo().alert().accept();

        return new BankManagerPage(getDriver());
    }

    public String textAlertNewAccount(){
        return getDriver().switchTo().alert().getText();
    }

    public String textAlertNumberNewAccount(){
        String number = textAlertNewAccount();

        return number.substring(number.indexOf(':') + 1);
    }
}
