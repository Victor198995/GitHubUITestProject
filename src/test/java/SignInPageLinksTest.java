import GitHubPagesDescription.ForgotPasswordPageGithub;
import GitHubPagesDescription.SignInPageGithub;
import GitHubPagesDescription.SignUpPageGithub;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SignInPageLinksTest {

    private WebDriver driver;
    private SignInPageGithub signInPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Viktor_Kutsyk\\IdeaProjects\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://github.com/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        signInPage = new SignInPageGithub(driver);

    }


    @Test(description = "Link to SignUpPage Validation")
    public void creaTeAccountLinkTest(){
        SignUpPageGithub signupPage = signInPage.signUpLinkClick();
        String text = signupPage.getHeadingText();
        Assert.assertEquals(text,"Create your account");
    }

    @Test(description = "Link to Password Recovery Validation")
    public void forgotPasswordLinkLinkTest(){
        ForgotPasswordPageGithub forgotPasswordPage = signInPage.forgotPassLinkClick();
        String url = forgotPasswordPage.gettingUrl();
        String title = forgotPasswordPage.gettingTitle();

        Assert.assertEquals(url,"https://github.com/password_reset");
        Assert.assertEquals(title,"Forgot your password? · GitHub");
    }

    @AfterMethod
    public void closingWindows() {
        driver.quit();
    }
}

