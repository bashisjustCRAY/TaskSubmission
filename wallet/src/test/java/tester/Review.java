package tester;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Review extends TestBase {

    @Test
    public void reviewCompany() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(getDriver(), 50);
        Actions act = new Actions(getDriver());
        String expectedFirstItem = "Test Insurance Company";
        String statement = "This part of my code was quite tricky. I was able to utilize my zeal to always expand my skills and solve problems. " +
                "To be specific, when I was inspecting the elements I noticed that the dropdown was not in a select tag " +
                "and I simply went with the most basic approach just because I like to always keep things simple.";

        // The lines below hover over the review stars and click on them
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='reviews-section']/div[1]/div[3]/review-star/div")));
        WebElement Element = getDriver().findElement(By.xpath("//*[@id='reviews-section']/div[1]/div[3]/review-star/div"));
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();",Element);
        Thread.sleep(1500);
        act.moveToElement(getDriver().findElement(By.xpath("//*[@id='reviews-section']/div[1]/div[3]/review-star/div/*[name()='svg'][4]"))).perform();
        Thread.sleep(1500);
        getDriver().findElement(By.xpath("//*[@id='reviews-section']/div[1]/div[3]/review-star/div/*[name()='svg'][4]")).click();

        // The lines below click on the dropdown to select Health insurance and also inputs the 200 characters
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ng-dropdown[@class='wrev-drp']/div/span[1]")));
        getDriver().findElement(By.xpath("//ng-dropdown[@class='wrev-drp']/div/span[1]")).click();
        Thread.sleep(1500);
        getDriver().findElement(By.xpath("//ng-dropdown[@class='wrev-drp']//ul[@role='listbox']/li[2]")).click();
        Thread.sleep(1500);
        getDriver().findElement(By.xpath("//textarea[@placeholder='Write your review...']")).sendKeys(statement);
        Thread.sleep(1500);
        getDriver().findElement(By.xpath("//div[contains(text(), 'Submit')]")).click();

        //The lines below redirect to the profile and asserts that the review was posted
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='top-header-nav']//div[5]/span")));
        Element = getDriver().findElement(By.xpath("//div[@class='top-header-nav']//div[5]/span"));
        act.moveToElement(Element).perform();
        getDriver().findElement(By.xpath("//*[@id='web-app']/header/div/nav[1]/div[5]/div/a[1]")).click();
        Thread.sleep(2000);

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='scroller']/main/div[2]/div/section/h2")));
            String actualFirstItem = getDriver().findElement(By.xpath("//section[@class='pr-ct-box pr-rec']//a")).getText();
            Thread.sleep(1500);
            Assert.assertEquals(expectedFirstItem, actualFirstItem);
            System.out.println("Test Successful");
        }
        catch (Exception e) {
            System.out.println("Your review could not be viewed.");
        }

    }
}
