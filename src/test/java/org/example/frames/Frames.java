package org.example.frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Frames {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/iframes.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
        WebElement frame = driver.findElement(By.cssSelector("iframe[id='iframe1']"));
        driver.switchTo().frame(frame);
        driver.findElement(By.cssSelector("input[id='imageButton']")).click();
        System.out.println("Clicked button");

        driver.switchTo().defaultContent();
        String heading = driver.findElement(By.cssSelector("h1[id='iframe_page_heading']")).getText();
        System.out.println(heading);

        driver.quit();
    }
}
