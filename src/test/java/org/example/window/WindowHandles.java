package org.example.window;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.selenium.dev/selenium/web/window_switching_tests/page_with_frame.html");
        driver.findElement(By.cssSelector("a[id^='a-link-that']")).click();
        Object[] allWindows = driver.getWindowHandles().toArray();

        String newWindowTitle = driver.switchTo().window((String) allWindows[1]).getTitle();
        System.out.println(newWindowTitle);


        System.out.println(driver.getWindowHandle());
        driver.close();
        driver.switchTo().window((String) allWindows[0]);
        System.out.println(driver.getTitle());
        System.out.println(newWindowTitle);

        driver.quit();

    }
}
