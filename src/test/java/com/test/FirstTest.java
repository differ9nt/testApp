package com.test;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class FirstTest {
    private static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver(ops);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.google.com/");
    }

    @Test
    public void facebookLogin() throws InterruptedException, IOException {

        WebElement search = driver.findElement(By.xpath("//*[@id='lst-ib']"));
        search.sendKeys("facebook");
        search.sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//*[contains(text(), 'Facebook')]")).click();

        System.out.println(driver.getTitle());

        WebElement login = driver.findElement(By.id("email"));
        login.sendKeys("differ9nt.ey9s@gmail.com");

        WebElement pass = driver.findElement(By.id("pass"));
        pass.sendKeys("122klaster1993");

        driver.findElement(By.xpath("//*[@id='loginbutton']")).click();


        WebElement profi = driver.findElement(By.xpath("//*[@id='u_0_a']/div[1]/div[1]/div/a/span"));
        Actions actions = new Actions(driver);
        actions.moveToElement(profi, 1, 1).build().perform();
        Thread.sleep(500);
        profi.click();
        Thread.sleep(500);

        WebElement before = driver.findElement(By.xpath("//a[@rel='theater'][not(@id='fbCoverImageContainer')]"));
        String beforeStr = before.getAttribute("href");

        WebElement changePhoto = driver.findElement(By.cssSelector("#u_fetchstream_2_f > div > div"));
        Actions action1 = new Actions(driver);
        action1.moveToElement(changePhoto, 1, 1).build().perform();
        Thread.sleep(500);
        changePhoto.click();
        Thread.sleep(500);

        WebElement photoNew = driver.findElement(By.className("_3jjt"));
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOf(photoNew));
        photoNew.click();

        driver.findElement(By.xpath("//button[@data-testid='profilePicSaveButton']")).click();

        Thread.sleep(10000);

        WebElement after = driver.findElement(By.xpath("//a[@rel='theater'][not(@id='fbCoverImageContainer')]"));
        String afterStr = after.getAttribute("href");

        Assert.assertNotEquals(beforeStr,afterStr);

    }

       /* @AfterClass
        public static void tearDown() {
             driver.quit(); }*/
}
