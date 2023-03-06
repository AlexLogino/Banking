package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebDriver;

public class BankManagerPage extends HeaderPage {
    @FindBy(css = "[ng-class='btnClass1']")
    private WebElement tabAddCustomer;

    @FindBy(css = "[ng-class='btnClass2']")
    private WebElement tabOpenAccount;

    @FindBy(css = "[ng-class='btnClass3']")
    private WebElement tabCustomers;

    public BankManagerPage(WebDriver driver) {
        super(driver);
    }

    public String getTabAddCustomer(){
        return tabAddCustomer.getText();
    }

    public String getTabOpenAccount(){
        return tabOpenAccount.getText();
    }

    public String getTabCustomers(){
        return tabCustomers.getText();
    }

    public Boolean isTabAddCustomerDisplayed(){
        getWait3().until(ExpectedConditions.visibilityOf(tabAddCustomer));

        return tabAddCustomer.isDisplayed();
    }

    public Boolean isTabOpenAccountDisplayed(){
        getWait3().until(ExpectedConditions.visibilityOf(tabOpenAccount));

        return tabOpenAccount.isDisplayed();
    }

    public Boolean isTabCustomersDisplayed(){
        getWait3().until(ExpectedConditions.visibilityOf(tabCustomers));

        return tabCustomers.isDisplayed();
    }

    public AddCustomerPage clickTabAddCustomer(){
        getWait3().until(ExpectedConditions.visibilityOf(tabAddCustomer));
        tabAddCustomer.click();

        return new AddCustomerPage(getDriver());
    }

    public OpenAccountPage clickTabOpenAccount(){
        getWait3().until(ExpectedConditions.visibilityOf(tabOpenAccount));
        tabOpenAccount.click();

        return new OpenAccountPage(getDriver());
    }

    public CustomersPage clickTabCustomers(){
        getWait3().until(ExpectedConditions.visibilityOf(tabCustomers));
        tabCustomers.click();

        return new CustomersPage(getDriver());
    }
}
