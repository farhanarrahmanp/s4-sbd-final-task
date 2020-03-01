/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes.sbd_ifik4103_k5;

import static java.lang.Math.ceil;
import java.util.Scanner;

/**
 *
 * @author Farhan
 */
public class Menu_3 {
    
    static int Menggunakan_indeks(int rk, int B, int V, int P){
        double Fan_Out_Ratio = B/(V+P);
        return (int) ceil(rk/Fan_Out_Ratio);
    }
    
    static int Tanpa_indeks(int rk, int B, int R){
        double BFR = B/R;
        return (int) ceil(rk/BFR);
    }
    
}
