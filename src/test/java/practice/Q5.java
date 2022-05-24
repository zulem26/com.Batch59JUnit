package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q5 {
    /*
       ...Exercise5...
      @BeforeClass ın icerisinde driver i kuralim
      maximize edip tum web elementler yuklenene kadar 10 sn bekletelim
      Google 'a gidelim ve sayfa basliginin Google icerdigini dogrulayalim
      Amazon'a gidelim ve url in www.amazon.com icerip icermedigini dogrulayalim
      @AfterClass ta driver ı kapatalim
       */

    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public void test01(){
        driver.get("https://google.com/");
        //sayfa basliginin Google icerdigini dogrulayalim
        String arananKelime = "Google";
        String sayfaBasligi = driver.getTitle();
        Assert.assertTrue(sayfaBasligi.contains(arananKelime));

        //Amazon'a gidelim ve url in www.amazon.com icerip icermedigini dogrulayalim
        driver.get("https://amazon.com");

        String istenenKelime = "www.amazon.com";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(istenenKelime));

    }
}
