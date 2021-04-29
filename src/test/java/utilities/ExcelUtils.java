package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtils {


    public HashMap<String, String> getData( String sheetName) throws IOException {
        //fileInputStream argument
        HashMap<String, String> data = new HashMap<>();
        XSSFSheet sheet = null;
        String value = null;


        FileInputStream fis = new FileInputStream("C:\\Work\\Assignment\\src\\test\\java\\resources\\data.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        int sheets = workbook.getNumberOfSheets();
        for (int i = 0; i < sheets; i++) {
            if (workbook.getSheetName(i).equalsIgnoreCase(sheetName))//get the sheet
            {
                sheet = workbook.getSheetAt(i);
            }
            int lastrownum = sheet.getLastRowNum();


            for (int n = 1; n <= lastrownum; n++) {
                Row row = sheet.getRow(n);

                Cell keycell = row.getCell(0);
                String key = keycell.getStringCellValue();

                Cell valuecell = row.getCell(1);
                if(valuecell.getCellType()== CellType.STRING)
                {

                    value = valuecell.getStringCellValue();
                }
                else{

                    value = NumberToTextConverter.toText(valuecell.getNumericCellValue());

                }
                data.put(key,value);
            }




        }

        return data;

    }
}



