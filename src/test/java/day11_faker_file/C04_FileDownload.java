package day11_faker_file;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
import org.junit.Assert;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownload extends TestBase {
    //1. Tests packagenin altina bir class oluşturalim
    //2. https://the-internet.herokuapp.com/download adresine gidelim.
    //3. dummy.txt dosyasını indirelim
    //4. dosyanın başarıyla indirilip indirilmediğini test edelim

    @Test
    public void test01() throws InterruptedException {
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        //3. dummy.txt dosyasını indirelim
        WebElement dummyLinki = driver.findElement(By.xpath("//*[text()='dummy.txt']"));
        dummyLinki.click();
        Thread.sleep(5000);

        //4. dosyanın başarıyla indirilip indirilmediğini test edelim
        //dosya download a indirilecek, bize downloads in dosya yolu lazim

        System.out.println(System.getProperty("user.home"));
        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "\\Downloads\\dummy(1).txt";


        String arananDosyaYolu = farkliKisim+ortakKisim;
        //geriye o dosya yolundaki dosyanin var oldugunu assert edelim
        Assert.assertTrue(Files.exists(Paths.get(arananDosyaYolu)));

    }



}
