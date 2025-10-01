package org.example.waits;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitTests {

    WebDriver driver;

    @BeforeEach
    public void beforeEach() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
    }

    @Test
    public void dynamicPageTest() {
        WebElement rev = driver.findElement(By.id("adder"));
        rev.click();

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(driver -> driver.findElement(By.cssSelector("div[id='box0']")).isDisplayed());

        WebElement box1 = driver.findElement(By.cssSelector("div[id='box0']"));
        String boxName = box1.getAttribute("class");
        Assertions.assertThat(boxName).isEqualTo("redbox");

    }

    @AfterEach
    public void afterEach() {
        driver.quit();
    }


}