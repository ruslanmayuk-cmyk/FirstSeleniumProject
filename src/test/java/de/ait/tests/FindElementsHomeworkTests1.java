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

public class FindElementsHomeworkTests1 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");

        //maximize browser to window
        driver.manage().window().maximize();
        //wait to upload all elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void findElementByTagName() {
        // Test: 5 Elements by tagName
        // 1. go to page Login
        driver.get("https://demowebshop.tricentis.com/login");
        //find one element by tagName -> h1
        WebElement title = driver.findElement(By.tagName("h1"));
        System.out.println(title.getText());

        // 2. return to the main page
        driver.get("https://demowebshop.tricentis.com/");
        //find one element by tagName -> h2
        WebElement h2 = driver.findElement(By.tagName("h2"));
        System.out.println(h2.getText());

        // 3. find list of elements by tag name -> input
        List<WebElement> inputs = driver.findElements(By.tagName("input"));
        System.out.println("inputs count: " + inputs.size());

        // 4. find list of elements by tag name -> div
        List<WebElement> divs = driver.findElements(By.tagName("div"));
        System.out.println("divs count: " + divs.size());

        // 5. find list of elements by tag name -> ul
        List<WebElement> ul = driver.findElements(By.tagName("ul"));
        System.out.println("ul count: " + ul.size());

    }
    @Test
    public void findElementByClassName() {
        // Test: 5 Elements by ClassName

        WebElement content = driver.findElement(By.className("topic-html-content-header"));
        System.out.println(content.getText());

        WebElement productGrid = driver.findElement(By.className("product-grid"));
        System.out.println("product Grid class: " + productGrid.getAttribute("class"));

        WebElement newsletterEmail = driver.findElement(By.className("newsletter-email"));
        System.out.println("newsletter-email class: " + newsletterEmail.getAttribute("class"));

        WebElement disclaimer = driver.findElement(By.className("footer-disclaimer"));
        System.out.println(disclaimer.getText());

        WebElement footer = driver.findElement(By.className("footer"));
        System.out.println("Footer text: " + footer.getText());

    }

    @Test
    public void findElementsByIdTest() {
        // Test: 5 Elements by Id


        WebElement newsletter = driver.findElement(By.id("newsletter-email"));
        System.out.println("Newsletter input id: " + newsletter.getAttribute("id"));

        WebElement pollAnswers = driver.findElement(By.id("pollanswers-1"));
        System.out.println("Poll answers id: " + pollAnswers.getAttribute("id"));

        WebElement votePoll = driver.findElement(By.id("vote-poll-1"));
        System.out.println("Vote poll button id: " + votePoll.getAttribute("id"));

        WebElement searchInput = driver.findElement(By.id("small-searchterms"));
        System.out.println("Search input id: " + searchInput.getAttribute("id"));

        WebElement topMenu = driver.findElement(By.id("ui-id-1"));
        System.out.println("Top menu item id: " + topMenu.getAttribute("id"));

    }
}



