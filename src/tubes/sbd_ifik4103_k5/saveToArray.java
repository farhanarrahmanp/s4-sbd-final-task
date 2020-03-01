/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes.sbd_ifik4103_k5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Farhan
 */
public class saveToArray {
    public static String[][] saveToArray(ArrayList<String> input) throws 
            FileNotFoundException, IOException{
        String[][] data=new String[input.size()][11];
        for (int i = 0; i < input.size(); i++) {
             ArrayList<String> item=token.token(input.get(i));
             for (int j = 0; j < item.size(); j++) {
                data[i][j]=item.get(j);//memasukkan data ke dalam array
            }
        }
        return data;
    }
}
