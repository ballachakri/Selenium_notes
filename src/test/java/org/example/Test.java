package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Test {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/formPage.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));

        WebElement email= driver.findElement(By.cssSelector("input[id='email']"));
        email.sendKeys("abc@gmail.com");
        email.sendKeys(Keys.TAB);

        new Actions(driver).pause(Duration.ofSeconds(1)).perform();
        WebElement number= driver.findElement(By.cssSelector("input[id='age']"));

        number.sendKeys("1222");
        number.sendKeys(Keys.TAB);
        new Actions(driver).pause(Duration.ofSeconds(1)).perform();

        WebElement submit= driver.findElement(By.cssSelector("input[id='submitButton']"));
        submit.click();

    }
}
