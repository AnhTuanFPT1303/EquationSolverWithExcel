/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package App;

import java.io.IOException;
import read.excel_read;
/**
 *
 * @author HELLO
 */
public class AppMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        excel_read reader = new excel_read();
        reader.read_file("data.xlsx");
    }
    
}
