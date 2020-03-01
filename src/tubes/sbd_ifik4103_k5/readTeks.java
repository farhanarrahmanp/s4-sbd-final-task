/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes.sbd_ifik4103_k5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Farhan
 */
public class readTeks {
    public static ArrayList<String> readTeks(String bacateks) throws 
            FileNotFoundException, IOException {
        File bacafile = new File(bacateks);
        FileReader inputDokumen = new FileReader(bacafile);
        BufferedReader bufferBaca = new BufferedReader(inputDokumen);
        StringBuffer content = new StringBuffer();
        String barisData;
        ArrayList<String> data = new ArrayList<String>();
        while ((barisData = bufferBaca.readLine()) != null) {
            content.append(barisData);
            content.append(System.getProperty("line.separator"));
            data.add(barisData);
        }
        return data;
    }
}
