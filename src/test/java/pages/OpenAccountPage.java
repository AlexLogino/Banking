package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OpenAccountPage extends HeaderPage {

    @FindBy(name = "userSelect")
    private WebElement selectCustomerName;

    @FindBy(name = "currency")
    private WebElement selectCurrency;

    public OpenAccountPage(WebDriver driver){
        super(driver);
    }

    public Boolean isSelectCustomerNameDisplayed(){
        getWait3().until(ExpectedConditions.visibilityOf(selectCustomerName));

        return selectCustomerName.isDisplayed();
    }

    public Boolean isSelectCurrencyDisplayed(){
        getWait3().until(ExpectedConditions.visibilityOf(selectCurrency));

        return selectCurrency.isDisplayed();
    }
}
