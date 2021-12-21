package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NominexSignInPage extends Base{
    private static final String nominexHomePageURL = "https://nominex.io/";

    @FindBy(xpath = "//sl-button[@href='/signin/']")
    private WebElement loginBtn;

    @FindBy(name = "email")
    private WebElement loginInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//sl-button[@class='w-full mt-20']")
    private WebElement confirmLoginBtn;

    public NominexSignInPage(WebDriver driver){
        super(driver);
    }

    public NominexSignInPage openNominexMainPage() {
        driver.get(nominexHomePageURL);
        return this;
    }

    public NominexSignInPage openAuthorizationWindow() {
        waitForElementToBeClickable(driver,loginBtn);
        loginBtn.click();
        return this;
    }

    public NominexSignInPage enterEmail(String email) {
        loginInput.sendKeys(email);
        return this;
    }

    public NominexSignInPage enterPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public NominexPage signIn() {
        confirmLoginBtn.click();
        return new NominexPage(driver);
    }
}
