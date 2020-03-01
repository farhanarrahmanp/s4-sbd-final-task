/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes.sbd_ifik4103_k5;

import static java.lang.Math.floor;

/**
 *
 * @author Farhan
 */
public class Menu_1 {
    
    static int BFR(int B, int R){
        double BFR = B/R;
        return (int) floor(BFR);
    }
    
    static int Fan_Out_Ratio(int B, int V, int P){
        double Fan_Out_Ratio = B/(V+P);
        return (int) floor(Fan_Out_Ratio);
    }

}
