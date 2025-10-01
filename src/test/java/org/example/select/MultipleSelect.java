package org.example.select;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class MultipleSelect {


    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/formPage.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));




        WebElement foods = driver.findElement(By.cssSelector("select[name='multi']"));
        Select select = new Select(foods);

        List<WebElement> list = select.getAllSelectedOptions();
        for(WebElement element : list) {
            System.out.println(element.getText());
        }

        select.deselectAll();

        System.out.println("Deselected .................");
        List<WebElement> list1 = select.getAllSelectedOptions();
        for(WebElement element : list1) {
            System.out.println(element.getText());
        }

        select.selectByValue("ham");
        select.selectByVisibleText("Onion gravy");


        System.out.println("Reselected .................");
        List<WebElement> list2 = select.getAllSelectedOptions();
        for(WebElement element : list2) {
            System.out.println(element.getText());
        }

        driver.quit();
    }
}
