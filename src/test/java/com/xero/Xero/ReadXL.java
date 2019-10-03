package com.xero.Xero;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ReadXL {
	public static String[][] readXlData(String path,String sheet1) throws IOException {
		FileInputStream fs = new FileInputStream(new File(path));
		HSSFWorkbook wb = new HSSFWorkbook(fs);
		HSSFSheet sheet = wb.getSheet(sheet1);
		int rowCount = sheet.getLastRowNum() + 1;
		int colCount = sheet.getRow(0).getLastCellNum();
		String[][] data = new String[rowCount][colCount];
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				int cellType = sheet.getRow(i).getCell(j).getCellType();
				if (cellType == HSSFCell.CELL_TYPE_NUMERIC) {
					int val = (int) sheet.getRow(i).getCell(j).getNumericCellValue();
					data[i][j] = String.valueOf(val);
				} else
					data[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();

			}
		}
		return (data);
	}

	
}
