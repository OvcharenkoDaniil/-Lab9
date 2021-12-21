package test;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LimitTabPage;
import pages.MarketTabPage;
import pages.NominexSignInPage;
import pages.NominexPage;

public class NominexTest {
    private WebDriver driver;
    private MarketTabPage marketTabPage;
    private LimitTabPage limitTabPage;
    private NominexPage nominexPage;

    private String login = "9182daniil9182@gmail.com";
    private String password = "Dd130278";
    private String marketAmount = "0.001";
    private String limitAmount = "0.002";
    private String limitPrice = "20000";

    @BeforeMethod(alwaysRun = true)
    public void authorizeNominex() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        nominexPage = new NominexSignInPage(driver)
                .openNominexMainPage()
                .openAuthorizationWindow()
                .enterEmail(login)
                .enterPassword(password)
                .signIn();
    }

    @Test(description = "Buy 0.001 BTC/USD tokens by market price")
    public void buyTokensByMarketPrice() {
        marketTabPage = nominexPage.openMarketList()
                .openUSDTTab()
                .openUSDTToBTC()
                .openDemoTab()
                .openMarketModeTab()
                .enterMarketBuyingAmount(marketAmount)
                .buyBTC();

        Assert.assertTrue(marketTabPage.hasTheOperationBeenPerformed());
    }

    @Test(description = "Create BTC/USD limit order with price 20000")
    public void createLimitOrder() {
        limitTabPage = nominexPage.openMarketList()
                .openUSDTTab()
                .openUSDTToBTC()
                .openDemoTab()
                .openLimitModeTab()
                .enterLimitBuyingPrice(limitPrice)
                .enterLimitBuyingAmount(limitAmount)
                .buyBTC();

        Assert.assertTrue(limitTabPage.hasTheOperationBeenPerformed());
    }

    @AfterMethod(alwaysRun = true)
    public void browserShutDown() {
        driver.quit();
        driver = null;
    }
}
