package org.example.select;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SingleSelect {


    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/formPage.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));




        WebElement numbers = driver.findElement(By.cssSelector("select[name='selectomatic']"));
        Select select = new Select(numbers);

        List<WebElement> list = select.getOptions();
        for(WebElement element : list) {
            System.out.println(element.getText());
        }


        select.selectByIndex(0);
        select.selectByValue("two");
        select.selectByVisibleText("Still learning how to count, apparently");


        List<WebElement> selectedItems = select.getAllSelectedOptions();
        for (WebElement element: selectedItems){
            System.out.println(element.getAttribute("value"));

        }

        driver.quit();

    }
}
