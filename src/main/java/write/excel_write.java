package write;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class excel_write {

    public void write_file(String path, String message, String delta, int rowIndex) throws FileNotFoundException, IOException {
        FileInputStream file = new FileInputStream(new File(path));
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);

        Row row = sheet.getRow(rowIndex);
        if (row == null) {
            row = sheet.createRow(rowIndex);
        }

        Cell logMessage = row.createCell(3); 
        logMessage.setCellValue(message);
        Cell logDelta = row.createCell(4);
        logDelta.setCellValue(delta);
        try (FileOutputStream fileOut = new FileOutputStream(path)) {
            workbook.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace(); 
        }
        System.out.println("Data written to Excel file successfully.");
    }
}
