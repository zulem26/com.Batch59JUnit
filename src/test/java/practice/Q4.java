package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Q4 {
    /*
    ...Exercise4...
    https://www.teknosa.com/ adresine gidiniz
    arama cubuguna oppo yazip enter deyiniz
    sonuc sayisini yazdiriniz
    cikan ilk urune tiklayiniz
    sepete ekleyiniz
    sepetime git e tiklayiniz
    consol da "Sipariş Özeti" webelementinin text ini yazidiriniz
    Alisverisi tamamlayiniz
    son alarak da "Teknosa'ya hoş geldiniz"  webelementinin text ini yazidiriniz
    driver i kapatiniz
*/

    //Not : https://www.guru99.com/chrome-options-desiredcapabilities.html

    /*
    note :
    JavaScriptExecutor nedir?
    JavaScriptExecutor, JavaScript'i Selenium Web sürücüsü aracılığıyla çalıştırmaya yardımcı olan bir Arayüzdür.
    JavaScriptExecutor, javascript'i seçilen pencerede veya geçerli sayfada çalıştırmak için "executescript" ve "executeAsyncScript"
    olmak üzere iki yöntem sunar.
    JavaScriptExecutor'a neden ihtiyacımız var?
    Selenium Webdriver'da, bir web sayfasındaki işlemleri tanımlamak ve gerçekleştirmek için
    XPath, CSS vb. gibi konum belirleyiciler kullanılır.
    Bu konum belirleyicilerin çalışmaması durumunda JavaScriptExecutor'ı kullanabilirsiniz.
    Bir web öğesinde istenen bir işlemi gerçekleştirmek için JavaScriptExecutor'ı kullanabilirsiniz.
    Selenium, javaScriptExecutor'ı destekler. Ekstra bir eklenti veya eklentiye gerek yoktur.
    JavaScriptExecutor kullanmak için komut dosyasında (org.openqa.selenium.JavascriptExecutor) içe aktarmanız yeterlidir.
            executeScript aracılığıyla sayfayı 1000 piksel kaydırın.
            Javascript yöntemi ScrollBy(), web sayfasını belirli piksel sayısına kaydırır.
            ScrollBy() yöntemlerinin sözdizimi şöyledir:
            executeScript("window.scrollBy(x-piksel,y-piksel)");  ya da js.executeScript("scroll(x,y);");
            x-piksel x eksenindeki sayıdır, sayı pozitifse sola, sayı negatifse sağa hareket eder.
            y-piksel y eksenindeki sayıdır, sayı pozitifse ise aşağı doğru,sayı negatif ise yukarı doğru hareket eder.
            Örnek:
            js.executeScript("window.scrollBy(0,1000)"); // Dikey olarak 1000 piksel aşağı kaydır
     */

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.teknosa.com/");

        ChromeOptions op = new ChromeOptions();
        op.addArguments("disable-popup-blocking");

        // arama cubuguna oppo yazip enter deyiniz
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='search-input']"));
        aramaKutusu.sendKeys("oppo" +  Keys.ENTER);

       // sonuc sayisini yazdiriniz
        System.out.println(driver.findElement(By.xpath("//div[@class='plp-info']")).getText());

       // cikan ilk urune tiklayiniz
        driver.findElement(By.xpath("(//a[@class='prd-link'])[1]")).click();

       // sepete ekleyiniz
       driver.findElement(By.xpath("//button[@id='addToCartButton'][1]")).click();

       // sepetime git e tiklayiniz
        driver.findElement(By.xpath("//a[@class='btn btn-secondary']")).click();

       // consol da "Sipariş Özeti" webelementinin text ini yazidiriniz
        System.out.println("siparis ozeti yazisi : " + driver.findElement(By.xpath("//div[@class='cart-sum-title']")).getText());
       // Alisverisi tamamlayiniz
        driver.findElement(By.xpath("//a[@class='btn btn-primary js-checkout-controls']")).click();
       // son alarak da "Teknosa'ya hoş geldiniz"  webelementinin text ini yazidiriniz
        System.out.println("hosgeldiniz yazisi : " + driver.findElement(By.xpath("//div[text()='Teknosa’ya hoş geldiniz']")).getText());
       // driver i kapatiniz

        driver.close();





    }
}
