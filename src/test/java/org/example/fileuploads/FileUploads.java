package org.example.fileuploads;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class FileUploads {

    WebDriver driver;

    @BeforeEach
    public void beforeEach() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/upload");
    }

    @Test
    public void formPageTest() {

        WebElement uploadButton = driver.findElement(By.cssSelector("input[id='file-upload']"));
        uploadButton.sendKeys(System.getProperty("user.dir") + "\\src\\test\\sample.txt");
        driver.findElement(By.cssSelector("input[id='file-submit']")).click();


        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(3))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class);

        wait.until(driver -> driver.findElement(By.cssSelector("div[id='uploaded-files']")).isDisplayed());
        String result = driver.findElement(By.cssSelector("div[id='uploaded-files']")).getText();
        Assertions.assertThat(result).isEqualTo("sample.txt");

    }

    @AfterEach
    public void afterEach() {
        driver.quit();
    }
}
