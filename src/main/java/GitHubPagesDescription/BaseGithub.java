package GitHubPagesDescription;

import org.openqa.selenium.WebDriver;

public class BaseGithub {

    WebDriver driver;

    public BaseGithub(WebDriver driver) {
        this.driver = driver;
    }


    //get title

    public String gettingTitle(){
        return driver.getTitle();
    }

    //get url
    public String gettingUrl(){
        return driver.getCurrentUrl();
    }
}
