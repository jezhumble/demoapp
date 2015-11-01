package net.jezhumble.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.*;

public class SurveyDriver {

    public String convertToCubicMeters(String acreFeet) {
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://192.168.34.10/convert.php");
        final List<WebElement> resultElements = driver.findElements(new By.ByXPath("//input[@type=\"text\"]"));
        for (WebElement resultElement : resultElements) {
            if (resultElement.getAttribute("name").equals("acreFeet")) {
                resultElement.sendKeys(acreFeet);
            }
        }
        driver.findElement(new By.ByXPath("(//input[@type=\"submit\"])[last()]")).click();
        String result = driver.findElement(new By.ByXPath("//p[@class=\"result\"]")).getText();
        driver.quit();
        return result;
    }
}
