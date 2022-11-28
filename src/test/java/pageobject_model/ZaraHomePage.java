package pageobject_model;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.time.Duration;

public class ZaraHomePage {
    private static final String HOMEPAGE_URL = "https://www.zara.com/by/";
    private WebDriver driver;
    @FindBy(xpath = "//span[text()='Search']")
    private WebElement searchBtnElement;
    @FindBy(id = "search-products-form-combo-input")
    private WebElement searchInputElement;

    public ZaraHomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public  ZaraHomePage openPage()
    {
        driver.get(HOMEPAGE_URL);
        searchBtnElement.click();
        return this;
    }

    public ZaraSearchResultsPage searchForJeans(String str)
    {
//        new WebDriverWait(driver, Duration.ofSeconds(20))
//                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Search']")));
        searchInputElement.sendKeys(str);
        searchInputElement.sendKeys(Keys.ENTER);
        return new ZaraSearchResultsPage(driver,str);
    }
}
