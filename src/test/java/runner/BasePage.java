package runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    private WebDriver driver;

    private WebDriverWait wait;

    private WebDriverWait wait3;

    protected WebDriver getDriver() {
        return driver;
    }

    protected WebDriverWait getWait3(){
        return wait3 = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    protected WebDriverWait getWait(int duration){
        return wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
    }

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(getDriver(), this);
    }
}