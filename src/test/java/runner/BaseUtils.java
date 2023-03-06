package runner;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public final class BaseUtils {
    static WebDriver createDriver(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    static String getUrl(){
        String url = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";

        return url;
    }
}
