import GitHubPagesDescription.SignInPageGithub;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SignInPageTest {

    private WebDriver driver;
    private SignInPageGithub signInPage;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Viktor_Kutsyk\\IdeaProjects\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://github.com/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        signInPage = new SignInPageGithub(driver);

    }

    @Test(description = "Page URL Validation")
    public void urlValidation() {
        Assert.assertEquals(signInPage.gettingUrl(), "https://github.com/login");
    }

    @Test(description = "Page header text Validation")
    public void textValidation() {
        Assert.assertEquals(signInPage.getHeadingText(), "Sign in to GitHub");
    }

    @Test(description = "Page Title Validation")
    public void titleValidation() {
        Assert.assertEquals(signInPage.gettingTitle(), "Sign in to GitHub · GitHub");
    }

    @Test(dependsOnMethods = {"urlValidation"})
    public void loggingInWithWrongCreds() {
        signInPage.login("test", "test213");
        Assert.assertEquals(signInPage.getErrorText(), "Incorrect username or password.");
    }

    @Test(dependsOnMethods = {"loggingInWithWrongCreds"})
    public void urlValidationAfterError() {
        Assert.assertEquals(signInPage.gettingUrl(), "https://github.com/session");
    }


    @AfterTest
    public void closingWindows() {
        System.out.println("Report is ready to be shared, with screenshots of tests");
        driver.quit();
    }
}
