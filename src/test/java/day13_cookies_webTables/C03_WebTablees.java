package day13_cookies_webTables;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;
import org.junit.*;

public class C03_WebTablees extends TestBase {

    @Test
    public void dinamikYazici(){
        // onceki class daki adrese gidip
        // girisYap method unu kullanarak sayfaya giris yapin
        // input olarak verilen satir sayisi ve sutun sayisina sahip cell deki tect i yazdirin

        int satir = 3;
        int sutun = 5;
        girisYap();


        WebElement arananCell= driver.findElement(By.xpath("//tbody//tr["+satir+"]//td["+sutun+"]"));

        System.out.println(arananCell.getText());

    }

    public void girisYap() {
        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.linkText("Log in")).click();
        Actions actions = new Actions(driver);
        WebElement username = driver.findElement(By.id("UserName"));
        actions.click(username).
                sendKeys("manager").
                sendKeys(Keys.TAB).
                sendKeys("Manager1!").
                sendKeys(Keys.ENTER).
                perform();
    }

}
