package com.andyadc.utilities.poi;

import com.alibaba.fastjson.JSON;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author andy.an
 * @since 2017/9/22
 */
public class TestExce {

    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream(new File("e:\\123-5.xlsx"));
        XSSFWorkbook wb = new XSSFWorkbook(fis);

        XSSFSheet sheet = wb.getSheetAt(0);
        System.out.println(sheet.getLastRowNum());

        Map<String, String> map = new HashMap<>(64);
        for (int i = 0; i <= sheet.getLastRowNum(); i++) {
            XSSFRow row = sheet.getRow(i);

            XSSFCell cell = row.getCell(0);
            cell.setCellType(CellType.STRING);
            String key = cell.getStringCellValue();

            XSSFCell cell1 = row.getCell(1);
            cell1.setCellType(CellType.STRING);
            String value = cell1.getStringCellValue();

            map.put(key, value);
        }

        System.out.println(map.size());
        System.out.println(map);

        System.out.println(JSON.toJSONString(map));
    }
}
