/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes.sbd_ifik4103_k5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Farhan
 */
public class token {
    public static ArrayList<String> token(String kalimat) throws 
            FileNotFoundException, IOException {
        ArrayList<String> listKata = new ArrayList<String>();
        StringTokenizer token = new StringTokenizer(kalimat, " ");//pemisahan kata dengan delimiter spasi
        while (token.hasMoreTokens()) {
            listKata.add(token.nextToken());
        }
        return listKata;
    }
}
