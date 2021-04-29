package GitHubPagesDescription;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPageGithub extends BaseGithub
{

    private WebDriver driver;

    public SignInPageGithub(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    //elements
    private By loginField = By.xpath("//input[@id=\"login_field\"]");

    private By passwordField = By.xpath("//input[@id=\"password\"]");

    private By signInButton = By.xpath("//input[@value=\"Sign in\"]");

    private By forgotPasswordLink = By.linkText("Forgot password?");

    private By signUpLink = By.linkText("Create an account");

    private By heading = By.xpath("//div[@class=\"auth-form-header p-0\"]/h1");

    //Incorrect username or password.


    private By errorMsg = By.xpath("//div[@class=\"container-lg px-2\"]");

    //methods

    public SignInPageGithub typeUserName(String username){
        driver.findElement(loginField).sendKeys(username);
        return new SignInPageGithub(driver);
    }

    public SignInPageGithub typePassword(String password){
        driver.findElement(passwordField).sendKeys(password);
        return new SignInPageGithub(driver);
    }
    //general method
    public SignInPageGithub login(String username,String password){
        this.typeUserName(username);
        this.typePassword(password);
        driver.findElement(signInButton).click();
        return  new SignInPageGithub(driver);
    }

    public String getHeadingText(){
        return driver.findElement(heading).getText();
    }

    public String getErrorText(){
        return driver.findElement(errorMsg).getText();
    }

    public SignUpPageGithub signUpLinkClick(){
        driver.findElement(signUpLink).click();
        return new SignUpPageGithub(driver);
    }

    public ForgotPasswordPageGithub forgotPassLinkClick(){
        driver.findElement(forgotPasswordLink).click();
        return new ForgotPasswordPageGithub(driver);
    }

}
