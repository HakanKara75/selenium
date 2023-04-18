package day05_practice;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;

public class C02 {
    // Desktop(masaustu)'da bir text dosyası olusturun
    // Desktop(masaustu)'da text dosyasının olup olmadıgını test edin
    @Test
    public void test() {
        // Desktop(masaustu)'da bir text dosyası olusturun
        // Desktop(masaustu)'da text dosyasının olup olmadıgını test edin
        String farkliKisim = System.getProperty("user.home");
        System.out.println(farkliKisim);

        String ortakKisim = "\\Desktop\\hakan";
        System.out.println(ortakKisim);


        String dosyaYolu = farkliKisim+ortakKisim;

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));



    }
}
