package com.project.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Base {

    private WebDriver driver;

    public Base(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver chromeDriverConnection() {
        // Selenium con Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\Ingesoft\\chromedriver\\chromedriver.exe");
        // Inicializando el controlador de Chrome
        driver = new ChromeDriver();
        return driver;
    }

    public WebElement findElement(By by){
        return  driver.findElement(by);
    }

    public void type(String inputText, By by){
        driver.findElement(by).sendKeys(inputText);
    }

    public void clear(By by){
        driver.findElement(by).clear();
    }

    public void click(By by){
        driver.findElement(by).click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void visit(String url){
        driver.get(url);
    }

}
