package com.newsletter.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataReader {
    public Object[][] readTestData(String filePath, String sheetName) throws IOException {
        FileInputStream inputStream = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheet(sheetName);

        int rowCount = sheet.getLastRowNum();
        int columnCount = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rowCount][columnCount];

        for (int i = 1; i <= rowCount; i++) {
            XSSFRow row = sheet.getRow(i);
            for (int j = 0; j < columnCount; j++) {
                XSSFCell cell = row.getCell(j);
                //Cell cell = row.getCell(j, Row.MissingCellPolicy.class);
                data[i - 1][j] = cell.toString();
            }
        }

        workbook.close();
        inputStream.close();
        return data;
    }
}
