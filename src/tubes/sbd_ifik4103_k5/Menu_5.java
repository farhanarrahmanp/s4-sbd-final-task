/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes.sbd_ifik4103_k5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Farhan
 */
public class Menu_5 {
    void Shared_Pool(String lokasi_file){
        System.out.println("");
        try {
            FileReader fr = new FileReader(lokasi_file);
            BufferedReader br = new BufferedReader(fr);
            String text;
            while ((text = br.readLine()) != null)
                System.out.println(text);
        }catch (FileNotFoundException fnfe) {
                    fnfe.getMessage();
        }catch (IOException ioe) {
                    ioe.getMessage();
        }
    }
}
