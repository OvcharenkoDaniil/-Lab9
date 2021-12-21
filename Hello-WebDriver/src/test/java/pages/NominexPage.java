package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NominexPage extends Base {

    @FindBy(xpath = "//sl-tab[@panel='LIMIT']")
    private WebElement limitTab;

    @FindBy(xpath = "//sl-tab[@panel='MARKET']")
    private WebElement marketTab;

    @FindBy(xpath = "//*[@href='/markets/']")
    private WebElement markets;

    @FindBy(xpath = "//h1[text()='Markets']")
    private WebElement marketsHeader;

    @FindBy(xpath = "//h3[text()='Personal Information']")
    private WebElement personalInfo;

    @FindBy(xpath = "//sl-button[contains(text(),'USDT')]")
    private WebElement subMenu;

    @FindBy(xpath = "//sl-menu-item[@value='USDT']")
    private WebElement usdtTab;

    //@FindBy(xpath = "//tr[@row-key='109']")
    @FindBy(xpath = "//span[contains(text(),'BTC')]")
    private WebElement usdtToBTCTab;

    @FindBy(xpath = "//sl-button[text()=' Demo ']")
    private WebElement demoTab;

    public NominexPage(WebDriver driver){
        super(driver);
    }

    public NominexPage openMarketList() {
        waitForVisibilityOfElement(driver, personalInfo);
        markets.click();
        return this;
    }

    public NominexPage openUSDTTab() {
        waitForVisibilityOfElement(driver, marketsHeader);
        subMenu.click();
        usdtTab.click();
        return this;
    }

    public NominexPage openUSDTToBTC() {
        scrollToObject(driver,usdtToBTCTab);
        usdtToBTCTab.click();
        return this;
    }

    public NominexPage openDemoTab() {
        scrollToObject(driver,demoTab);
        waitForVisibilityOfElement(driver, demoTab);
        demoTab.click();
        return this;
    }

    public MarketTabPage openMarketModeTab() {
        marketTab.click();
        return new MarketTabPage(driver);
    }

    public LimitTabPage openLimitModeTab() {
        limitTab.click();
        return new LimitTabPage(driver);
    }
}
