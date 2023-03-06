package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class CustomersPage extends HeaderPage {

    @FindBy(css = "[type='text']")
    private WebElement textSearch;

    @FindBy(xpath = "//table")
    private WebElement table;

    @FindBy(xpath = "//tbody/tr[6]")
    private WebElement tableNewLine;

    @FindBy(xpath = "//tbody/tr[6]/td[1]")
    private WebElement tableFirstName;

    @FindBy(xpath = "//tbody/tr[6]/td[2]")
    private WebElement tableLastName;

    @FindBy(xpath = "//tbody/tr[6]/td[3]")
    private WebElement tablePostCode;

    public CustomersPage(WebDriver driver){
        super(driver);
    }

    public Boolean isTextSearchDisplayed(){
        return getWait3().until(ExpectedConditions.visibilityOf(textSearch)).isDisplayed();
    }

    public Boolean isTableDisplayed(){
        return getWait3().until(ExpectedConditions.visibilityOf(table)).isDisplayed();
    }

    public Boolean isTableNewLineNotDisplayed(){
        return getWait3().until(ExpectedConditions.invisibilityOf(tableNewLine));
    }

    public List<String> isTableNewCustomerDisplayed(){
        List<String> list = new ArrayList<>();
        list.add(getWait3().until(ExpectedConditions.visibilityOf(tableFirstName)).getText());
        list.add(getWait3().until(ExpectedConditions.visibilityOf(tableLastName)).getText());
        list.add(getWait3().until(ExpectedConditions.visibilityOf(tablePostCode)).getText());

        return list;
    }
}
