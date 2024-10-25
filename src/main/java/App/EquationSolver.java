/*









 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package App;

/**
 *
 * @author HELLO
 */
public class EquationSolver {

    public String EquationSolve(int a, int b, int c) {
        if (a == b && a == c && a == 0) {
            return "Phuong trinh vo so nghiem";
        }
        if (a == b && a == 0) {
            return "Phuong trinh vo nghiem";
        }
        if (a == b && c == 0) {
            return "Phuong trinh 1 nghiem";
        }
        if (a == 0) {
            return "Phuong trinh co 1 nghiem";
        }
        
        double delta = b * b - 4 * a * c;
        
        if(delta == 0) {
            return "Phuong trinh co nghiem kep";
        }
        if(delta > 0) {
            return "Phuong trinh co 2 nghiem";
        }
        return "Phuong trinh vo nghiem";
    }
}
