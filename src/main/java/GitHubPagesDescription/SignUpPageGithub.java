package GitHubPagesDescription;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPageGithub extends BaseGithub {

    private WebDriver driver;

    public SignUpPageGithub(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    //elements
    private By heading = By.xpath("//div[@class=\"mb-4 mb-md-8 container-md\"]/h1");

    private By usernameField = By.id("user_login");

    private By emailField = By.id("user_email");

    private By passwordField = By.id("user_password");

    private By checkbox = By.xpath("//input[@id='all_emails']");

    private By createAccoutButton = By.id("signup_button");

    //errormsg
    //Username may only contain alphanumeric characters or single hyphens, and cannot begin or end with a hyphen.
    private By errorUserName = By.xpath("//div[@class=\"mb-1\"]");
    //private By errorUsername = By.xpath("//div[@class='mb-1']");

    //Email is invalid or already taken
    private By errorEmail = By.xpath("/html[1]/body[1]/div[4]/main[1]/div[1]/div[2]/div[1]/form[1]/auto-check[2]/dl[1]/dd[2]");

    //Password is too short (minimum is 8 characters), needs at least 1 lowercase letter, needs at least 1 number, and is in a list of passwords commonly used on other websites
    private By errorPassword = By.xpath("/html[1]/body[1]/div[4]/main[1]/div[1]/div[2]/div[1]/form[1]/password-strength[1]/auto-check[1]/dl[1]/dd[2]");



    //methods
    public SignUpPageGithub typeUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
        return this;
    }

    public SignUpPageGithub typeEmail(String email){
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public SignUpPageGithub typePassword(String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    //general method
    public SignUpPageGithub fillSignUpForm(String username,String email,String password){
        this.typeUsername(username);
        this.typeEmail(email);
        this.typePassword(password);

        driver.findElement(checkbox).click();
        //driver.findElement(createAccoutButton).click();
        return new SignUpPageGithub(driver);
    }

    //text getting
    public String getHeadingText(){
        return driver.findElement(heading).getText();
    }

    public String getUsernameErrorText(){
        return driver.findElement(errorUserName).getText();
    }

    public String getEmailErrorText(){
        return driver.findElement(errorEmail).getText();
    }

    public String getPasswordErrorText(){
        return driver.findElement(errorPassword).getText();
    }


}


