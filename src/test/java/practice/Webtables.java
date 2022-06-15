package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
import org.junit.Test;

import java.util.List;

public class Webtables extends TestBase{

    @Test
    public void test01(){

        driver.get("https://demoqa.com/webtables");

        //Headers da bulunan department isimlerini yazdirin
        WebElement theadIsim = driver.findElement(By.xpath("//div[@class='rt-thead -header']"));
        //System.out.println(theadIsim.getText());

        //sutunun basligini yazdirin

        //Tablodaki tum datalari yazdirin
        WebElement tabloData = driver.findElement(By.xpath("//div[@class='rt-table']"));
        System.out.println(tabloData.getText());

        //tablo da kac cell oldugunu yazdirin
        List<WebElement> hucreSayisi = driver.findElements(By.xpath("//div[@class='rt-th rt-resizable-header -cursor-pointer']"));
        System.out.println("hucreSayisi " + hucreSayisi.size());

        // tablo daki satir sayisini yazdirin
        List<WebElement> tabloSatirSayisi = driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
        System.out.println("tabloSatirSayisi " + tabloSatirSayisi.size());

        for (WebElement each:tabloSatirSayisi){
            System.out.println(each.getText());
        }

        //tablo daki 3.kolonu yazdirin

        // Kierra nin salary sini yazdirin

        for (WebElement each:tabloSatirSayisi){
            if (each.getText().equals("Kierra")){
            }
        }


    }

}
