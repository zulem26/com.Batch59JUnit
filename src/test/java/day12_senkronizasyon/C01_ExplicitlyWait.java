package day12_senkronizasyon;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C01_ExplicitlyWait extends TestBase {

    @Test
    public void implicitlyWaitTesti(){
        // https://the-internet.herokuapp.com/dynamic_controls
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // Remove butonuna basiniz
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        // "It's gone!" mesajinin goruntulendigini dogrulayin
        WebElement itsGoneYazisiElementi = driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));
        Assert.assertTrue(itsGoneYazisiElementi.isDisplayed());

        // Add butonuna basiniz
        driver.findElement(By.xpath("//button[text()='Add']")).click();

        // It's back yazisinin dondugunu gorunuz
        WebElement itsBackElementi = driver.findElement(By.xpath("//button[text()='Remove']"));
        Assert.assertTrue(itsBackElementi.isDisplayed());

    }

    @Test
    public void explicitlyWaitTesti(){
        // https://the-internet.herokuapp.com/dynamic_controls
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // Remove butonuna basiniz
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        // "It's gone!" mesajinin goruntulendigini dogrulayin
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        /*
        WebElement itsGoneYazisiElementi = driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));
        wait.until(ExpectedConditions.visibilityOf(itsGoneYazisiElementi));
        Assert.assertTrue(itsGoneYazisiElementi.isDisplayed());

        yazinin gorunur olmasini beklerken yazinin locate ini kullanmak sorun olusturur cunku henuz
        gorunmeyen bir yazinin locate edilmesi de mumkun olmayabilir
        (HTML kodlari yazan developer farkli uygulamalar yapabilir)
        Bu durumda bekleme islemi ve locate i birlikte yapmaliyiz
         */
        WebElement itsGoneYazisiElementi = wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//p[text()=\"It's gone!\"]")));
        Assert.assertTrue(itsGoneYazisiElementi.isDisplayed());

        // Add butonuna basiniz
        driver.findElement(By.xpath("//button[text()='Add']")).click();

        // It's back yazisinin dondugunu gorunuz
        WebElement itsBackElementi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Remove']")));

        Assert.assertTrue(itsBackElementi.isDisplayed());
    }
}
