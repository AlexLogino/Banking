package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CustomerPage extends HeaderPage {

    @FindBy(name = "userSelect")
    private WebElement selectYourName;
    public CustomerPage(WebDriver driver){
        super(driver);
    }

    public Boolean isSelectYourNameDisplayed(){
        return getWait3().until(ExpectedConditions.visibilityOf(selectYourName)).isDisplayed();
    }

    public void clickSelectYourName(){
        getWait3().until(ExpectedConditions.visibilityOf(selectYourName)).click();
    }
}
