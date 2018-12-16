import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;

public class tstJenkins {
    String base_url = "http://localhost:8080";
    StringBuffer verificationErrors = new StringBuffer();
    WebDriver driver = null;

    @BeforeClass
    public void beforeClass() throws Exception {
        System.setProperty("webdriver.chrome.driver", "D:/!EPAM/chromedriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability("chrome.switches", Arrays.asList("--homepage=about:blank"));
        driver = new ChromeDriver(capabilities);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            Assert.fail(verificationErrorString);
        }
    }

    @Test
    public void tstSignIn(){
       //WebDriver driver = new ChromeDriver();
        driver.get(base_url);
        PageObjectSample page = PageFactory.initElements(driver, PageObjectSample.class);
        page.setUsername("admin");
        page.setPassword("46854b31b6444c48a279daf0e27ceb95");
        page.signIn();
    }

    @Test
    public void tst1(){
        driver.get(base_url);
        PageObjectSample page = PageFactory.initElements(driver, PageObjectSample.class);
        page.manageJenkins();
        Assert.assertTrue(page.tst1());
    }

    @Test
    public void tst2(){
        driver.get(base_url + "/manage");
        PageObjectSample page = PageFactory.initElements(driver, PageObjectSample.class);
        page.manageUsers();
        Assert.assertTrue(page.tst2());
    }

    @Test
    public void tst3(){
        driver.get(base_url + "securityRealm/");
        PageObjectSample page = PageFactory.initElements(driver, PageObjectSample.class);
        page.createUsers();
        Assert.assertTrue(page.tst3());
    }

    @Test
    public void tst4(){
        driver.get(base_url + "securityRealm/");
        PageObjectSample page = PageFactory.initElements(driver, PageObjectSample.class);
        page.fillForm();
        page.createUserClick();
        Assert.assertTrue(page.tst4());
    }

    @Test
    public void tst5(){
        driver.get(base_url + "securityRealm/user/someuser/");
        PageObjectSample page = PageFactory.initElements(driver, PageObjectSample.class);
        Assert.assertTrue(page.tst5());
    }

    @Test
    public void tst6(){

    }
}
