package com.newsletter.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "testData")
    public static Object[][] testData() throws IOException {
        ExcelDataReader excelDataReader = new ExcelDataReader();
        return excelDataReader.readTestData("C:\\Users\\dhara\\login.xlsx", "Sheet1");
    }
}

