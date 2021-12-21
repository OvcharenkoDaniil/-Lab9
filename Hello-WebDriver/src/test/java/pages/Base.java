package pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public abstract class Base {

    protected WebDriver driver;

    protected Base(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    protected static WebElement waitForElementToBeClickable(WebDriver driver, WebElement element) {
        return new WebDriverWait(driver, 30)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    protected static WebElement waitForVisibilityOfElement(WebDriver driver, WebElement element) {
        return new WebDriverWait(driver, 30)
                .until(ExpectedConditions.visibilityOf(element));
    }

    protected static Object scrollToObject(WebDriver driver, WebElement element) {
        int yScrollPosition2 = element.getLocation().getY() - 200;
        return ((JavascriptExecutor) driver).executeScript("window.scroll(0," + yScrollPosition2 + ") ;" ) ;
    }

    protected static boolean hasTheOperationBeenPerformed(WebElement element) {
        return element.isDisplayed();
    }

}
