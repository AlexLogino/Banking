package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import runner.BasePage;

public class HeaderPage extends BasePage {

    @FindBy(css = "[ng-click='home()']")
    private WebElement btnHome;

    public HeaderPage(WebDriver driver){
        super(driver);
    }

    public HomePage clickHome(){
        getWait3().until(ExpectedConditions.visibilityOf(btnHome));
        btnHome.click();

        return new HomePage(getDriver());
    }
}
