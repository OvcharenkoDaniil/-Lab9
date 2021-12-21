package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LimitTabPage extends Base{
    @FindBy(xpath = "//p[@class='mb-8']")
    private WebElement confirmTossNotification;

    @FindBy(xpath = "//div[text()=' Limit price ']/..")
    private WebElement BuyingLimitPriceField;

    @FindBy(xpath = "//sl-input[@class='order-form-input relative']")
    private WebElement BuyingLimitAmountField;

    @FindBy(xpath = "//sl-button[contains(text(),' Buy BTC ')]")
    private WebElement BuyBtn;

    public LimitTabPage(WebDriver driver){
        super(driver);
    }

    public LimitTabPage enterLimitBuyingPrice(String price) {
        waitForVisibilityOfElement(driver,BuyingLimitPriceField);
        return this;
    }

    public LimitTabPage enterLimitBuyingAmount(String amount) {
        BuyingLimitAmountField.sendKeys(amount);
        return this;
    }

    public LimitTabPage buyBTC() {
        waitForElementToBeClickable(driver,BuyBtn);
        BuyBtn.click();
        waitForVisibilityOfElement(driver, confirmTossNotification);
        return this;
    }
    public boolean hasTheOperationBeenPerformed() {
        return confirmTossNotification.isDisplayed();
    }
}
