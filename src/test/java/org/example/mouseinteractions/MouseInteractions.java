package org.example.mouseinteractions;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class MouseInteractions {


    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/mouse_interaction.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));


        WebElement click= driver.findElement(By.cssSelector("input[id='clickable']"));

        new Actions(driver)
                .moveToElement(click)
                .pause(Duration.ofSeconds(1))
                .clickAndHold()
                .pause(Duration.ofSeconds(1))
                .sendKeys("Hello")
                .perform();

        String result = driver.findElement(By.cssSelector("strong[id='click-status']")).getText();
        Assertions.assertThat(result).isEqualTo("focused");

        new Actions(driver)
                .moveToElement(click)
                        .doubleClick()
                                .perform();

        String result1 = driver.findElement(By.cssSelector("strong[id='click-status']")).getText();
        Assertions.assertThat(result1).isEqualTo("double-clicked");

        new Actions(driver)
                .moveToElement(click)
                .contextClick()
                .perform();

        String result2 = driver.findElement(By.cssSelector("strong[id='click-status']")).getText();
        Assertions.assertThat(result2).isEqualTo("context-clicked");
        driver.quit();

    }
}
