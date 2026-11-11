package Framework.Browser;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Waits {

    private static final Duration TIMEOUT = Duration.ofSeconds(30);

    private final WebDriver driver;

    public Waits (WebDriver driver){

        this.driver = driver;
    }

    private WebDriverWait espera(){

        return new WebDriverWait(driver, TIMEOUT);
    }


    public WebElement visibilityOfElement(By by){

        return espera().until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement presenceOfElement(By by){

        return espera().until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public List<WebElement> visibilityOfAllElements(By by){

        return espera().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }


    public WebElement loadElement(WebElement element){

        return espera().until(ExpectedConditions.visibilityOf(element));
    }

    public void invisibilityOfElement(By by){

        espera().until(ExpectedConditions.invisibilityOfElementLocated(by));
    }


    public void clickJs(WebElement element){

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
}
