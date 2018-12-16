import java.util.Collection;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Predicate;

public class PageObjectSample {
    private WebDriverWait wait;
    private final WebDriver driver = null;

    @FindBy(xpath = "//*[@id=\"j_username\"]")
    private WebElement username;

    @FindBy(xpath = "/html/body/div/div/form/div[2]/input")
    private WebElement password;

    @FindBy(xpath = "/html/body/div/div/form/div[3]/input")
    private WebElement signin_button;

    @FindBy(xpath = "//*[@id=\"tasks\"]/div[4]/a[2]")
    private WebElement manageJenkins_button;

    @FindBy(xpath = "//*[@id=\"main-panel\"]/div[16]/a/dl/dt")
    private WebElement dt;

    @FindBy(xpath = "//*[@id=\"main-panel\"]/div[16]/a/dl/dd[1]")
    private WebElement dd;

    @FindBy(xpath = "//*[@id=\"tasks\"]/div[3]/a[2]")
    private WebElement createUser;

    @FindBy(name = "username")
    private WebElement Username;

    @FindBy(name = "password1")
    private WebElement Password;

    @FindBy(name = "password2")
    private WebElement ConfirmPassword;

    @FindBy(name = "fullname")
    private WebElement FulllName;

    @FindBy(name = "email")
    private WebElement Email;

    @FindBy(xpath = "//*[@id=\"yui-gen1-button\"]")
    private WebElement createUser_button;

    @FindBy(xpath = "//*[@id=\"people\"]/tbody/tr[3]")
    private WebElement tr;

    @FindBy(xpath = "//*[@id=\"people\"]/tbody/tr[3]/td[2]")
    private WebElement td;

    @FindBy(xpath = "//*[@id=\"tasks\"]/div[6]/a[2]")
    private WebElement deleteUser;

    @FindBy(xpath = "//*[@id=\"main-panel\"]/form/text()")
    private WebElement deletingText;


    public PageObjectSample setUsername(String value) {
        username.sendKeys(value);
        return this;
    }

    public PageObjectSample setPassword(String value) {
        password.sendKeys(value);
        return this;
    }

    public PageObjectSample signIn() {
        signin_button.click();
        return this;
    }

    public PageObjectSample manageJenkins() {
        manageJenkins_button.click();
        return this;
    }

    public boolean tst1(){
        return ( dt.isDisplayed() && dd.isDisplayed() );
    }

    public PageObjectSample manageUsers() {
        dt.click();
        return this;
    }

    public boolean tst2(){
        return createUser.isEnabled();
    }

    public PageObjectSample createUsers() {
        createUser.click();
        return this;
    }

    public boolean tst3(){
        return Username.isDisplayed() && Password.isDisplayed() && ConfirmPassword.isDisplayed() && FulllName.isDisplayed() && Email.isDisplayed();
    }

    public void fillForm(){
        Username.sendKeys("someuser");
        Password.sendKeys("somepassword");
        ConfirmPassword.sendKeys("somepassword");
        FulllName.sendKeys("Some Full Name");
        Email.sendKeys("some@addr.com");
    }

    public PageObjectSample createUserClick(){
        createUser_button.click();
        return this;
    }

    public boolean tst4(){
        return td.isDisplayed() && tr.isDisplayed();
    }

    public boolean tst5(){
        deleteUser.click();
       return deletingText.isDisplayed();
    }

}
