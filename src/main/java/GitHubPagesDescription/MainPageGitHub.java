package GitHubPagesDescription;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class MainPageGitHub extends BaseGithub{

    private WebDriver driver;

    public MainPageGitHub(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    //elements
    private By searchField = By.xpath("//input[@data-scoped-placeholder=\"Search\"]");

    private By signInButton = By.xpath("//a[@class='HeaderMenu-link flex-shrink-0 no-underline mr-3']");

    private By signUpButtonHeader = By.xpath("//header/div[1]/div[2]/div[2]/a[2]");
            //By.className("HeaderMenu-link flex-shrink-0 d-inline-block no-underline border color-border-tertiary rounded px-2 py-1 js-signup-redesign-target js-signup-redesign-control");


    private By emailField = By.xpath("//input[@id=\"user_email_control\"]");

    private By signUpButtonEmail = By.xpath("//button[@class=\"btn-mktg-fluid btn-green-mktg-fluid width-full width-sm-auto\"][1]");//not sure

    // Where the world builds software
    private By header = By.xpath("//h1[@class=\"h2-5-mktg-fluid h1-sm-mktg-fluid h0-lg-mktg-fluid color-text-white mb-3 position-relative z-2\"]");


    //methods

    public SignInPageGithub clickSignIn() {
        driver.findElement(signInButton).click();
        //as soon as we will come to page
        return new SignInPageGithub(driver);
    }

    public SignUpPageGithub clickSignUpHeader() {
        driver.findElement(signUpButtonHeader).click();
        return new SignUpPageGithub(driver);
    }

    public SignUpPageGithub clickSignUpEmail() {
        driver.findElement(signUpButtonEmail).click();
        return new SignUpPageGithub(driver);
    }

    public SearchResultsPageGithub searching(String query) {
        driver.findElement(searchField).clear();
        driver.findElement(searchField).sendKeys(query, Keys.ENTER);
        return new SearchResultsPageGithub(driver);
    }


    public MainPageGitHub enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public String getHeadingText() {
        return driver.findElement(header).getText();
    }

    public String getUrlll(){
        return driver.getCurrentUrl();
    }


}
