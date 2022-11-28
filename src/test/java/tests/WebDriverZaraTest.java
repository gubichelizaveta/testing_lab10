package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject_model.ZaraHomePage;

public class WebDriverZaraTest {
    WebDriver driver;
    @BeforeMethod(alwaysRun = true)
    public void browserSetup()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public  void ZaraSearchWomanJeansTest()
    {
        int expectedCount = new ZaraHomePage(driver)
                .openPage()
                .searchForJeans("woman jeans")
                .CountSearchResults();
        System.out.println(expectedCount);
        Assert.assertTrue(expectedCount > 0, "");
    }
    @AfterMethod(alwaysRun = true)
    public void browserTearDown()
    {
        driver.quit();
        driver = null;
    }
}
