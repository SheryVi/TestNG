package Class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HardAssertions {
   public static WebDriver driver;
    // go to syntax login
    // enter wrong credentials
    // verify the message is "Invalid credentials"

    @BeforeMethod
    public void openBrowser(){

        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/dashboard");
    }


    @Test
    public void verifyCredentials(){
        String expectedText = "Invalid credentials";

        WebElement userName = driver.findElement(By.id("txtUsername"));
        userName.sendKeys("123456");
        driver.findElement(By.id("txtPassword")).sendKeys("123456");
        driver.findElement(By.id("btnLogin")).click();
        String text = driver.findElement(By.id("spanMessage")).getText();
        Assert.assertEquals(text, expectedText);

        boolean displayed = userName.isEnabled();
        System.out.println("helloworld");
        Assert.assertTrue(displayed);




    }

    @AfterMethod
    public void closeBrowser(){

        driver.quit();
    }

}
