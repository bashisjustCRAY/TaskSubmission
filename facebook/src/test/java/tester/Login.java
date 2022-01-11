package tester;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Login extends TestBase {

    @Test
    public void postMessage() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(getDriver(), 50);
        //Make sure to input your username and password before running the code
        String username = "";
        String password = "";

        //Everything below here is for the login page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
        getDriver().findElement(By.xpath("//input[@id='email']")).sendKeys(username);
        Thread.sleep(3000);
        getDriver().findElement(By.xpath("//input[@id='pass']")).sendKeys(password);
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//button[@name='login']")).click();

        //Everything below here is for the dashboard
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[3]/div/div[2]/div/div/div/div[1]/div/div[1]/span")));
        getDriver().findElement(By.xpath("//div[3]/div/div[2]/div/div/div/div[1]/div/div[1]/span")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//div[@class='_1mf _1mj']")).sendKeys("Hello World");
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span/span[contains(text(), 'Post')]")));
        getDriver().findElement(By.xpath("//span/span[contains(text(), 'Post')]")).click();

    }
}
