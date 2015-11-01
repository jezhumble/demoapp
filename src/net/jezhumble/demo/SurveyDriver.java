package net.jezhumble.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class SurveyDriver {

    private String hostname;

    public SurveyDriver() {
        try {
            byte[] encoded = Files.readAllBytes(Paths.get("url"));
            hostname = new String(encoded, Charset.forName("UTF-8"));
        } catch (Exception e) {
            hostname = "localhost:8000";
        }
    }

    public String convertToCubicMeters(String acreFeet) {
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://" + hostname + "/convert.php");
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
