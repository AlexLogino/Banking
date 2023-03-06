package runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;


public abstract class BaseTest {
    private WebDriver driver;

    private WebDriverWait wait;

    protected WebDriver getDriver(){
        return driver;
    }

    protected WebDriverWait getWait(int duration){
        return wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
    }

    protected void startDriver(){
        driver = BaseUtils.createDriver();
    }

    protected void getWeb(){
        driver.get(BaseUtils.getUrl());
    }

    @BeforeMethod
    protected void beforeMethod(){
        startDriver();
        getWeb();
    }

    @AfterMethod
    protected void afterMethod(ITestResult testResult){
        try {
            if (!testResult.isSuccess()) {
            }
        } catch (Exception ignore) {
        } finally {
            driver.quit();
        }
    }
}
