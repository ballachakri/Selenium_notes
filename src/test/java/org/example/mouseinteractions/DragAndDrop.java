package org.example.mouseinteractions;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class DragAndDrop {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/mouse_interaction.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));

        WebElement pick = driver.findElement(By.cssSelector("div[id='draggable']"));
        WebElement drop = driver.findElement(By.cssSelector("div[id='droppable']"));

        new Actions(driver)
                .moveToElement(pick)
                .pause(Duration.ofSeconds(1))
                .dragAndDrop(pick,drop)
                .pause(Duration.ofSeconds(1))
                .perform();


        String result = driver.findElement(By.cssSelector("strong[id='drop-status']")).getText();
        Assertions.assertThat(result).isEqualTo("dropped");

        driver.quit();

    }
}
