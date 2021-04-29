import GitHubPagesDescription.MainPageGitHub;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MainPageTest {

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

    @Test(description = "Page header text validation")
    public void textValidation() {
        Assert.assertEquals(mainPage.getHeadingText(), "Where the world builds software");
    }

    @Test(description = "Page URL Validation")
    public void urlValidation() {
        Assert.assertEquals(mainPage.gettingUrl(), "https://github.com/");
    }

    @Test(description = "Page Title Validation")
    public void titleValidation() {
        Assert.assertEquals(mainPage.gettingTitle(), "GitHub: Where the world builds software · GitHub");
    }


    @AfterTest
    public void closingWindows() {
        driver.quit();
    }
}
