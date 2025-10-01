package org.example.navigate;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigate {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://selenium.dev");
        Assertions.assertThat(driver.getTitle()).isEqualTo("Selenium");


        driver.navigate().forward();

        driver.navigate().back();;

        driver.navigate().refresh();

        //driver.quit();
    }
}

