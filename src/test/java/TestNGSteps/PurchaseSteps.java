package TestNGSteps;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class PurchaseSteps {



    WebDriver driver;

    @BeforeClass
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }


    @Test(priority = 1)
    public void URL() {

        System.out.println("The user goes to the website");
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);




    }

    @Test(priority = 2)
    public void Login() {

        System.out.println("The user is login");
        WebElement UName = driver.findElement(By.xpath("//input[@id='user-name']"));
        UName.sendKeys("performance_glitch_user");
        WebElement PWord = driver.findElement(By.id("password"));
        PWord.sendKeys("secret_sauce");
        WebElement Login = driver.findElement(By.id("login-button"));
        Login.click();

    }

    @Test(priority = 3)
    public void Add() {

        System.out.println("The user is adding the item into the cart");
        WebElement AddToCart = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        AddToCart.click();
        WebElement ClickCart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        ClickCart.click();
        WebElement Checkout = driver.findElement(By.id("checkout"));
        Checkout.click();


    }

    @Test(priority = 4)
    public void Information() {

        System.out.println("The user fill up the information");
        WebElement FName = driver.findElement(By.id("first-name"));
        FName.sendKeys("Jonathan");
        WebElement LName = driver.findElement(By.id("last-name"));
        LName.sendKeys("Jostar");
        WebElement PCode = driver.findElement(By.id("postal-code"));
        PCode.sendKeys("26155");
        WebElement Continue = driver.findElement(By.id("continue"));
        Continue.click();
        WebElement Finish = driver.findElement(By.id("finish"));
        Finish.click();

    }


    @Test(priority = 5)
    public void Confrimation() {


        System.out.println("The user has successfully Ordered!");
        WebElement actualMes = driver.findElement(By.xpath("//h2[@class='complete-header']"));
        String ActualMessage = actualMes.getText();
        Assert.assertTrue(ActualMessage.contains("Thank you for your order!"));










    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }

}
