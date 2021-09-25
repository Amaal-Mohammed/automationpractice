package util;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ExcelRead {
    private static XSSFSheet ExcelWSheet;
    private static XSSFWorkbook ExcelWBook;
    private static XSSFCell Cell;
    private static XSSFRow Row;

    public static ArrayList<String> readFromExcel(String path, int sheetnumber) throws IOException {
        FileInputStream fs = new FileInputStream(path);
        ArrayList<String> data = new ArrayList<String>();
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet sheet = workbook.getSheetAt(sheetnumber);
        for (int j = 0; j < sheet.getRow(sheet.getLastRowNum()).getLastCellNum(); j++) {
            DataFormatter formatter = new DataFormatter();
            String val = formatter.formatCellValue(sheet.getRow(sheet.getLastRowNum()).getCell(j));
            data.add(val);
        }
        return data;
    }


}
