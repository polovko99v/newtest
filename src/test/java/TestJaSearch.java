import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestJaSearch {
    WebDriver driver;
    JaSearchPage search;

    @BeforeMethod
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\polov\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.justanswer.com/archives/elastic-search.aspx?");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testSearchWord()
    {
    search=new JaSearchPage(driver);
    String searchValue = "Selenium";
    search.enterSearchValue(searchValue).clickSearchButton();
    Assert.assertEquals(search.searchResultSummary(), "You searched for \"Selenium\". 3420 results found.");

    }

    @AfterMethod
    public void tearDown()
    {
        driver.manage().deleteAllCookies();
        driver.quit();
    }




}
