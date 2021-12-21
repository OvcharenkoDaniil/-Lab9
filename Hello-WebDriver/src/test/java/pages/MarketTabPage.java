package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MarketTabPage extends Base{
    @FindBy(xpath = "//sl-input[@class='order-form-input relative']")
    private WebElement BuyingMarketAmountField;

    @FindBy(xpath = "//p[@class='mb-8']")
    private WebElement confirmTossNotification;

    @FindBy(xpath = "//sl-button[contains(text(),' Buy BTC ')]")
    private WebElement BuyBtn;

    public MarketTabPage(WebDriver driver){
        super(driver);
    }

    public MarketTabPage enterMarketBuyingAmount(String amount) {
        BuyingMarketAmountField.sendKeys(amount);
        return this;
    }
    public MarketTabPage buyBTC() {
        waitForElementToBeClickable(driver,BuyBtn);
        BuyBtn.click();
        waitForVisibilityOfElement(driver, confirmTossNotification);
        return this;
    }
    public boolean hasTheOperationBeenPerformed() {
        return confirmTossNotification.isDisplayed();
    }
}
