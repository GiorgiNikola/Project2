package ge.tbc.tbcitacademy.Tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import ge.tbc.tbcitacademy.POM.Listeners.CustomTestListener;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import java.util.HashMap;
import java.util.Map;

@Listeners({CustomTestListener.class})
public class ConfigTests {
    @BeforeSuite(groups = {"SauceDemoLogin","SwoopRegression"})
    public void initialSetup(){
        Configuration.timeout = 12000;
        Configuration.reopenBrowserOnFail = true;
        Configuration.screenshots = true;
        Configuration.fileDownload = FileDownloadMode.HTTPGET;
        Configuration.pageLoadTimeout = 20000;
    }
    @BeforeTest(groups = {"SauceDemoLogin","SwoopRegression"})
    public void testSetup(){
        Configuration.browser = "chrome";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("safebrowsing.enabled", false);
        options.setExperimentalOption("prefs", prefs);
        Configuration.browserCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
        Configuration.browserSize = null;
    }
}
