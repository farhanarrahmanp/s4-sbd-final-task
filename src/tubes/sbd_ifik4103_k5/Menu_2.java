/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes.sbd_ifik4103_k5;

import static java.lang.Math.ceil;

/**
 *
 * @author Farhan
 */
public class Menu_2 {
    static int Total_Block_Data(int n, int B, int R){
        double BFR = B/R;
        return (int) ceil(n/BFR);
    }
    static int Blok_Index(int n, int B, int V, int P){
        double Fan_Out_Ratio = B/(V+P);
        return (int) ceil(n/Fan_Out_Ratio);
        /*
        Jumlah Blok
        n/BFR + ceil(B/Fan_Out_Ratio)
        */
    }
}
