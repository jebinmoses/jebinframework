package org.pop;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel extends Base {
	public static void main(String[] args) throws IOException {
		
		File f = new File("C:\\Users\\jebin\\eclipse-workspace\\MavenWorks\\target\\File\\Book1.xlsx");
		boolean a = f.createNewFile();
		System.out.println(a);
		
		
		FileInputStream fin = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fin);
		
		Sheet s = w.getSheet("Work");
		Row row = s.getRow(3);
		Cell cell = row.getCell(0);
				String value = cell.getStringCellValue();
				
				if (value.equals("sql")) {
					
					cell.setCellValue("GREENS");
					
					FileOutputStream fout = new FileOutputStream(f);
				w.write(fout);
				System.out.println("sucess");
				
					
				}
	}

}
