package com.hardingTest.Test;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {

    @Before
    public void setup(){
        //Assume that we will go to the url
    }

    @org.junit.Test
    public void loginDDTTest() throws IOException {

        String path = "ertugbatar.xlsx";
        FileInputStream in = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(in);
        XSSFSheet sheet = workbook.getSheet("Company Data");

        String companyName="harding";
        String websiteUrl="www.hardinggjkfgvbkg.com";
        String companyAddress="Washington/US";
        String contactEmailAddress="Washington DC";
        String contactName="Emilia";
        String contactPhoneNumber="94135344663";
        String padAccountNumber="4638";
        String padSortCode="54564463";
        String updatedCompanyName="harding";


        for (int rowNum = 2; rowNum < sheet.getLastRowNum(); rowNum++) {
            if (updatedCompanyName.equals(sheet.getRow(rowNum).getCell(0).toString())){
                sheet.getRow(rowNum).getCell(0).setCellValue(companyName);
                sheet.getRow(rowNum).getCell(1).setCellValue(websiteUrl);
                sheet.getRow(rowNum).getCell(2).setCellValue(companyAddress);
                sheet.getRow(rowNum).getCell(3).setCellValue(contactName);
                sheet.getRow(rowNum).getCell(4).setCellValue(contactPhoneNumber);
                sheet.getRow(rowNum).getCell(5).setCellValue(contactEmailAddress);
                sheet.getRow(rowNum).getCell(6).setCellValue(padSortCode);
                sheet.getRow(rowNum).getCell(7).setCellValue(padAccountNumber);

            }
        }

        FileOutputStream output =new FileOutputStream(path);
        workbook.write(output);

        in.close();
        output.close();
        workbook.close();

    }

}

