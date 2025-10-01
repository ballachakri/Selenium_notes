package org.example.keyboardinteractions;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class KeyBoardInteractions {


    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/mouse_interaction.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));


        WebElement click = driver.findElement(By.cssSelector("input[id='clickable']"));

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
                .clickAndHold(click)
                .keyDown(Keys.SHIFT)
                .sendKeys("a")
                .pause(Duration.ofSeconds(5))
                .perform();

        new Actions(driver)
                .clickAndHold(click)
                .sendKeys(Keys.TAB)
                .pause(Duration.ofSeconds(2))
                .perform();

        WebElement hover = driver.findElement(By.cssSelector("hover"));
        System.out.println(hover.getText());

        driver.quit();

    }
}
