package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Q6 {
    /*
      ...Exercise6...
   // 1. Amazon.com'a gidelim.
   // 2. DropDown üzerinde Books secelim.(All yazan yerde)
   //    kategorilerin hepsini konsola yazdiralim
   // 3. Arama kutusuna Les Miserables yazalım ve arama yapalim.
   // 4. Sonuc sayisini ekrana yazdiralim.
   // 5. Sonucların Les Miserables i icerdigini assert edelim
   */

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }



    @Test
    public void test01(){
        // 1. Amazon.com'a gidelim.
        driver.get("https://www.amazon.com");

        // 2. DropDown üzerinde Books secelim.(All yazan yerde)
        WebElement ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select options = new Select(ddm);
        options.selectByVisibleText("Books");


        // 3. Arama kutusuna Les Miserables yazalım ve arama yapalim.
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Les Miserables" + Keys.ENTER);

        // 4. Sonuc sayisini ekrana yazdiralim.
        System.out.println(driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small'][1]")).getText());
        //WebElement sonucSayisi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small'][1]"));
        //System.out.println(sonucSayisi.getText()); 1-16 of over 5,000 results for "Les Miserables"


        // 5. Sonucların Les Miserables i icerdigini assert edelim
        WebElement sonucYazisiElementi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small'][1]"));
        String sonucYazisiStr = sonucYazisiElementi.getText();
        String arananKelime = "Miserables";

        Assert.assertTrue(sonucYazisiStr.contains(arananKelime));
        //Assert.assertEquals("les Misrables icermez", sonucSayisi.getText().contains("Les Miserables"), true);
    }

    @AfterClass
    public static void tearDown(){
        //driver.close();
    }
}
