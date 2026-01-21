package de.ait.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FindElementsByCssSelectorHomeworkTests2 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        // maximize browser window
        driver.manage().window().maximize();
        // wait for elements to load
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void findElementsByCssClass() {
        // Переделать локаторы By.tagName / By.id / By.className  в  cssSelector

        System.out.println ("-------- TAG NAME --------");
        // find element by tag name using css selector
        // tagName "h1" -> css "h1"
        driver.get("https://demowebshop.tricentis.com/login");
        WebElement title = driver.findElement(By.cssSelector("h1"));
        System.out.println(title.getText());

        // tag "h2"
        driver.get("https://demowebshop.tricentis.com/"); // return to the main page
        WebElement h2 = driver.findElement(By.cssSelector("h2"));
        System.out.println(h2.getText());

        // tag "input"
        List<WebElement> inputs = driver.findElements(By.cssSelector("input"));
        System.out.println("Inputs count: " + inputs.size());
        System.out.println("***********************************");


        // -------- ID --------
        System.out.println ("-------- ID --------");
        // id "small-searchterms" -> css "#small-searchterms"
        WebElement searchInput = driver.findElement(By.cssSelector("#small-searchterms"));
        System.out.println(searchInput.getAttribute("id"));

        // id "newsletter-email"
        WebElement newsletter = driver.findElement(By.cssSelector("#newsletter-email"));
        System.out.println(newsletter.getAttribute("id"));

        // id "vote-poll-1"
        WebElement votePoll = driver.findElement(By.cssSelector("#vote-poll-1"));
        System.out.println(votePoll.getAttribute("id"));
        System.out.println("***********************************");

        // -------- CLASS --------
        System.out.println ("-------- CLASS --------");
        // class "footer" -> css ".footer"
        WebElement footer = driver.findElement(By.cssSelector(".footer"));
        System.out.println(footer.getText());

        // class "product-grid"
        WebElement productGrid = driver.findElement(By.cssSelector(".product-grid"));
        System.out.println(productGrid.getAttribute("class"));

        // class "newsletter-email"
        WebElement newsletterClass = driver.findElement(By.cssSelector(".newsletter-email"));
        System.out.println(newsletterClass.getAttribute("class"));
        System.out.println("***********************************");

        // -------- ATTRIBUTE [key='value'] --------
        // attribute selector
        driver.findElement(By.cssSelector("input[type='text']"));
        driver.findElement(By.cssSelector("input[name='NewsletterEmail']"));
        driver.findElement(By.cssSelector("a[href='/login']"));

        // -------- CONTAINS / STARTS / ENDS --------
        // * -> contains
        driver.findElement(By.cssSelector("[class*='search']"));

        // ^ -> starts with
        driver.findElement(By.cssSelector("[id^='small']"));

        // $ -> ends with
        driver.findElement(By.cssSelector("[id$='email']"));

        // -------- COMPOSITE CSS --------
        // tag + class + attribute
        driver.findElement(By.cssSelector("a.ico-login[href='/login']"));
        driver.findElement(By.cssSelector("input.search-box-text[type='text']"));
        driver.findElement(By.cssSelector("div.footer a[href='/news']"));

        // -------- ONE STEP BELOW (>) --------
        driver.findElement(By.cssSelector(".top-menu > li"));

        // -------- ONE OR MORE STEPS BELOW (space) --------
        List<WebElement> footerLinks = driver.findElements(By.cssSelector(".footer a"));
        System.out.println("Footer links: " + footerLinks.size());

        // -------- nth-child(n) --------
        System.out.println ("-------- nth-child(n) --------");
        WebElement firstMenuItem = driver.findElement(By.cssSelector(".top-menu > li:nth-child(1)"));
        System.out.println(firstMenuItem.getText());

        WebElement secondMenuItem = driver.findElement(By.cssSelector(".top-menu > li:nth-child(2)"));
        System.out.println(secondMenuItem.getText());

        WebElement thirdMenuItem = driver.findElement(By.cssSelector(".top-menu > li:nth-child(3)"));
        System.out.println(thirdMenuItem.getText());

    }





}
