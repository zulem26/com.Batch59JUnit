package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;
import org.junit.*;

import java.time.Duration;

public class Q08_ExplicitlyWait extends TestBase {
/*
    //go to web site : https://www.jqueryscript.net/demo/bootstrap-alert-box/
    //maximize the window
    //click on action dialog button
    //if need use explicitly wait
    //click on the ok button
    //accept the alert message
 */


    @Test
    public void test(){
        //go to web site : https://www.jqueryscript.net/demo/bootstrap-alert-box/
        driver.get("https://www.jqueryscript.net/demo/bootstrap-alert-box/");

        //click on action dialog button
        driver.findElement(By.xpath("//button[@id='action']")).click();

        //if need use explicitly wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='modal-body']"))));

        //WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[@class='modal-body']"))));

        WebElement textMesaj = driver.findElement(By.xpath("//div[@class='modal-body']"));
        Assert.assertTrue(textMesaj.isDisplayed());

        //click on the ok button
        driver.findElement(By.id("dialog-mycodemyway-action")).click();

        //accept the alert message
        driver.switchTo().alert().accept();


    }


}
