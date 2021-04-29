import GitHubPagesDescription.MainPageGitHub;
import GitHubPagesDescription.SignInPageGithub;
import GitHubPagesDescription.SignUpPageGithub;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MainPageButtonsValidation {

    private WebDriver driver;

    private MainPageGitHub mainPage;


    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Viktor_Kutsyk\\IdeaProjects\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://github.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mainPage = new MainPageGitHub(driver);

    }

    @Test(description = "Link to SignInPage Validation")
    public void signInButtonValidation() {
        SignInPageGithub signInPage = mainPage.clickSignIn();
        Assert.assertEquals(signInPage.gettingUrl(), "https://github.com/login");
    }

    @Test(description = "Link to SignUpPage Validation")
    public void signUpButtonValidation() {
        SignUpPageGithub signUpPage = mainPage.clickSignUpHeader();
        Assert.assertEquals(signUpPage.getHeadingText(), "Create your account");
        Assert.assertEquals(signUpPage.gettingTitle(), "Join GitHub · GitHub");
    }


    @Test(description = "Link to SignUpPage Validation")
    public void signUpForGithubButtonValidation() {
        SignUpPageGithub signUpPage = mainPage.clickSignUpEmail();
        Assert.assertEquals(signUpPage.getHeadingText(), "Create your account");
    }


    @AfterMethod
    public void closingWindows() {
        driver.quit();
    }
}
