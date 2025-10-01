package org.example.waits;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ImplicitTests {

    WebDriver driver;

    @BeforeEach
    public void beforeEach() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.selenium.dev/selenium/web/index.html");
    }

    @Test
    public void formPageTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1500));
        WebElement formPageLink = driver.findElement(By.cssSelector("a[href='formPage.html']"));
        formPageLink.click();
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertThat(currentUrl).endsWith("web/formPage.html");

    }

    @AfterEach
    public void afterEach() {
        driver.quit();
    }





    // static ChromeOptions options;

//    protected static ChromeOptions getDefaultChromeOptions() {
//        options = new ChromeOptions();
//        options.addArguments("--start-maximized");
//        options.addArguments("--no-sandbox");
//        return options;
//    }
//


}