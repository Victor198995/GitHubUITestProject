import GitHubPagesDescription.MainPageGitHub;
import GitHubPagesDescription.SearchResultsPageGithub;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SearchResultsPageTest {
    private WebDriver driver;
    private MainPageGitHub mainPage;




    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Viktor_Kutsyk\\IdeaProjects\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://github.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mainPage = new MainPageGitHub(driver);

    }


    @Test(description = "Page Title Validation")
    public void titleValidation() {
        SearchResultsPageGithub searchResultsPage = mainPage.searching("test");
        Assert.assertEquals(searchResultsPage.gettingTitle(), "Search · test · GitHub");
    }

    @Test(description = "Page URL Validation")
    public void urlValidation() {
        SearchResultsPageGithub searchResultsPage = mainPage.searching("test");
        Assert.assertEquals(searchResultsPage.gettingUrl(), "https://github.com/search?q=test&type=");
    }


    @AfterTest
    public void closingWindows() {
        driver.quit();
    }


}
