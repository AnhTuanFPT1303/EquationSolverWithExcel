/*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package read;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import App.EquationSolver;
import write.excel_write;

/**
 *
 * @author HELLO
 */
public class excel_read {

    public void read_file(String path) throws FileNotFoundException, IOException {
    FileInputStream file = new FileInputStream(new File(path));
    excel_write writer = new excel_write();
    XSSFWorkbook workbook = new XSSFWorkbook(file);
    XSSFSheet sheet = workbook.getSheetAt(0);
    EquationSolver solver = new EquationSolver();
    int rowIndex = 0;
    int[] arr = new int[3];
    for (Row row : sheet) {
        boolean isValidRow = true;
        for (int i = 0; i < 3; i++) {
            Cell cell = row.getCell(i);
            if (cell == null) {
                isValidRow = false;
                break;
            }
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_NUMERIC:
                    if (cell.getNumericCellValue() % 1 != 0 || cell.getNumericCellValue()<0 || cell.getNumericCellValue()>65536) {
                        isValidRow = false;
                        break;
                    }
                    arr[i] = (int) cell.getNumericCellValue();
                    break;
                default:
                    isValidRow = false;
                    break;
            }
        }
        
        String delta = Double.toString(arr[1] * arr[1] - 4*arr[0]*arr[2]);
        if (isValidRow) {
            writer.write_file(path, solver.EquationSolve(arr[0], arr[1], arr[2]), delta, rowIndex);
        } else {
            writer.write_file(path, "Invalid input", "Invalid delta", rowIndex);
        }
        rowIndex++;
    }
}
}


