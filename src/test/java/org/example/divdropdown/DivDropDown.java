package org.example.divdropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class DivDropDown {

    public static void main(String[] args) {
        String item = "Electronics & Appliances";
        WebDriver driver = new ChromeDriver();
        driver.get("https://quikr.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(By.cssSelector("a[id='searchedCat']")).click();

        List<WebElement> list = driver.findElements(By.cssSelector("div[id='category-dropdown'] > ul li"));
        ArrayList<String> items = new ArrayList<>();
        for (WebElement webElement : list) {
            System.out.println(webElement.getText());
            if (webElement.getText().equals(item)) {
                System.out.println(webElement.getText() + "  IS SELECTED");
                webElement.click();
                break;
            }
        }


//        driver.findElement(By.linkText("Jobs")).click();
        driver.quit();
    }
}
