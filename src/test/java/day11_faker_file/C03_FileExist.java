package day11_faker_file;
import org.junit.*;
public class C03_FileExist {

    @Test
    public void test01(){
        System.out.println(System.getProperty("user.dir"));

        System.out.println(System.getProperty("user.home"));

        String dosyaYolu= System.getProperty("user.home")+ "\\Desktop\\text.txt";
        System.out.println(dosyaYolu);
    }
}
