package day06_practice;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static org.junit.Assert.assertTrue;

public class C03_Read_Excell  {
    // Ulkeler dosyasındaki 3.satırdaki indexin, 3.sutunundaki indexinin
    // "Cezayir" oldugunu test eden method olusturunuz
    @Test
    public void name() throws Exception {

int satirNoIndex=3;
int sutunNoIndex=3;
        // Ulkeler dosyasındaki 3.satırdaki indexin, 3.sutunundaki indexinin
        // "Cezayir" oldugunu test eden method olusturunuz
String actuelData= banaDataGetir(satirNoIndex,sutunNoIndex);
String expectedData= "Cezayir" ;
assertTrue(actuelData.equals(expectedData));

    }

    public String banaDataGetir(int satirNoIndex, int sutunNoIndex) throws Exception {
        String dosyYolu="src/resorcues/ulkeler.xlsx"; //okunacak dosyanin yolunu aldim
        FileInputStream fileInputStream=new FileInputStream(dosyYolu); //dosyayi verip sisteme dahil ettim

        Workbook workbook= WorkbookFactory.create(fileInputStream);
        String istenenData = workbook.getSheet("Sayfa1").getRow(satirNoIndex).getCell(sutunNoIndex).toString();
        return istenenData;
    }
}
