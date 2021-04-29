import GitHubPagesDescription.SignUpPageGithub;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SignUpPageTest {

    private WebDriver driver;
    private SignUpPageGithub signUpPage;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Viktor_Kutsyk\\IdeaProjects\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://github.com/join");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        signUpPage = new SignUpPageGithub(driver);

    }

    @Test(description = "Page URL Validation")
    public void urlValidation() {
        Assert.assertEquals(signUpPage.gettingUrl(), "https://github.com/join");
    }

    @Test(description = "Page Title Validation")
    public void titleValidation(){
        Assert.assertEquals(signUpPage.gettingTitle(),"Join GitHub · GitHub");
    }

    @Test(description = "Page header text validation")
    public void headerTextValidation(){
        Assert.assertEquals(signUpPage.getHeadingText(),"Create your account");
    }

    @Test(description = "Error message validation after wrong credentials entering")
    public void errorMessagesValidation(){
        signUpPage.fillSignUpForm("user","email","password123");

        String usernameErrorText =signUpPage.getUsernameErrorText();
        String emailErrorText = signUpPage.getEmailErrorText();
        String passwordErrorText = signUpPage.getPasswordErrorText();
        Assert.assertEquals(usernameErrorText,"Username user is not available.");
        Assert.assertEquals(emailErrorText,"Email is invalid or already taken");
        Assert.assertEquals(passwordErrorText,"Password is in a list of passwords commonly used on other websites");
    }

    @AfterTest
    public void closingWindows() {
        System.out.println("Report is ready to be shared, with screenshots of tests");
        driver.quit();
    }
}
