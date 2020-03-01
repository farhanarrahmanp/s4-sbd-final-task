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
import java.util.Scanner;

/**
 *
 * @author Farhan
 */
public class Menu_Utama {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, 
            IOException{
        // TODO code application logic here
        parsing.listData = readTeks.readTeks("DATA DICTIONARY.txt");
        parsing.data_dictionary=saveToArray.saveToArray(parsing.listData);
        int[][] PBRnV = 
        {{Integer.parseInt(parsing.data_dictionary[0][1]),Integer.parseInt(parsing.data_dictionary[0][3])},
        {Integer.parseInt(parsing.data_dictionary[1][6]),Integer.parseInt(parsing.data_dictionary[1][8]),Integer.parseInt(parsing.data_dictionary[1][10])},
        {Integer.parseInt(parsing.data_dictionary[2][6]),Integer.parseInt(parsing.data_dictionary[2][8]),Integer.parseInt(parsing.data_dictionary[2][10])},
        {Integer.parseInt(parsing.data_dictionary[3][6]),Integer.parseInt(parsing.data_dictionary[3][8]),Integer.parseInt(parsing.data_dictionary[3][10])}};
        String[][] table = 
        {{parsing.data_dictionary[1][0],parsing.data_dictionary[1][1],parsing.data_dictionary[1][2],parsing.data_dictionary[1][3],parsing.data_dictionary[1][4]},
        {parsing.data_dictionary[2][0],parsing.data_dictionary[2][1],parsing.data_dictionary[2][2],parsing.data_dictionary[2][3],parsing.data_dictionary[2][4]},
        {parsing.data_dictionary[3][0],parsing.data_dictionary[3][1],parsing.data_dictionary[3][2],parsing.data_dictionary[3][3],parsing.data_dictionary[3][4]}};
        Scanner keyboard = new Scanner(System.in);
        System.out.println(">> Menu Utama:");
        System.out.println("1. Tampilkan BFR dan Fanout Ratio Setiap Tabel");
        System.out.println("2. Tampilkan Total Blok Data + Blok Index Setiap Tabel");
        System.out.println("3. Tampilkan Jumlah Blok yang Diakses Untuk Pencarian Rekord");
        System.out.println("4. Tampilkan QEP dan Cost");
        System.out.println("5. Tampilkan Isi File Shared Pool");
        System.out.print(">> Masukan Pilihan Anda: ");
        int pilihan = keyboard.nextInt();
        
        switch(pilihan){
            case 1: 
                System.out.println("");
                System.out.println("BFR "+table[0][0]+" : "+Menu_1.BFR(PBRnV[0][1],PBRnV[1][0]));
                System.out.println("Fan Out Ratio "+table[0][0]+" : "+Menu_1.Fan_Out_Ratio(PBRnV[0][1],PBRnV[1][2],PBRnV[0][0]));
                
                System.out.println("BFR "+table[1][0]+" : "+Menu_1.BFR(PBRnV[0][1],PBRnV[2][0]));
                System.out.println("Fan Out Ratio "+table[1][0]+" : "+Menu_1.Fan_Out_Ratio(PBRnV[0][1],PBRnV[2][2],PBRnV[0][0]));
                
                System.out.println("BFR "+table[2][0]+" : "+Menu_1.BFR(PBRnV[0][1],PBRnV[3][0]));
                System.out.println("Fan Out Ratio "+table[2][0]+" : "+Menu_1.Fan_Out_Ratio(PBRnV[0][1],PBRnV[3][2],PBRnV[0][0]));
                break;
            case 2: 
                System.out.println("");
                System.out.println("Tabel Data "+table[0][0]+" : "+Menu_2.Total_Block_Data(PBRnV[1][1],PBRnV[0][1],PBRnV[1][0]));
                System.out.println("Indeks "+table[0][0]+" : "+Menu_2.Blok_Index(PBRnV[1][1],PBRnV[0][1],PBRnV[1][2],PBRnV[0][0]));
                
                System.out.println("Tabel Data "+table[1][0]+" : "+Menu_2.Total_Block_Data(PBRnV[2][1],PBRnV[0][1],PBRnV[2][0]));
                System.out.println("Indeks "+table[1][0]+" : "+Menu_2.Blok_Index(PBRnV[2][1],PBRnV[0][1],PBRnV[2][2],PBRnV[0][0]));
                
                System.out.println("Tabel Data "+table[2][0]+" : "+Menu_2.Total_Block_Data(PBRnV[3][1],PBRnV[0][1],PBRnV[3][0]));
                System.out.println("Indeks "+table[2][0]+" : "+Menu_2.Blok_Index(PBRnV[3][1],PBRnV[0][1],PBRnV[3][2],PBRnV[0][0]));
                break;
            case 3:
                System.out.println("");
                Scanner sc31 = new Scanner(System.in);
                System.out.println("Input:");
                System.out.print(">> Cari Rekord ke- : ");
                int i31 = sc31.nextInt();
                System.out.print(">> Nama Tabel : ");
                Scanner sc32 = new Scanner(System.in);
                String i32 = sc32.nextLine();
                System.out.println("");
                System.out.println("Output:");
                if(i32.equalsIgnoreCase(table[0][0])){
                    if(i31 >= 0 && i31 <= PBRnV[1][1]){
                    System.out.println(">> Menggunakan indeks, jumlah blok yang"
                        + " diakses : "+Menu_3.Menggunakan_indeks
                    (i31, PBRnV[0][1], PBRnV[1][2], PBRnV[0][0])+" blok");
                    System.out.println(">> Tanpa indeks, jumlah blok yang diakses : "+
                        Menu_3.Tanpa_indeks(i31, PBRnV[0][1], PBRnV[1][0])+ " blok");
                    break;
                    }else{
                        System.out.println("Invalid");
                        break;
                    }
                }else if(i32.equalsIgnoreCase(table[1][0])){
                    if(i31 >= 0 && i31 <= PBRnV[2][1]){
                    System.out.println(">> Menggunakan indeks, jumlah blok yang"
                        + " diakses : "+Menu_3.Menggunakan_indeks
                    (i31, PBRnV[0][1], PBRnV[2][2], PBRnV[0][0])+" blok");
                    System.out.println(">> Tanpa indeks, jumlah blok yang diakses : "+
                        Menu_3.Tanpa_indeks(i31, PBRnV[0][1], PBRnV[2][0])+ " blok");
                    break;
                    }else{
                        System.out.println("Invalid");
                        break;
                    }
                }else if(i32.equalsIgnoreCase(table[2][0])){
                    if(i31 >= 0 && i31 <= PBRnV[3][1]){
                    System.out.println(">> Menggunakan indeks, jumlah blok yang"
                        + " diakses : "+Menu_3.Menggunakan_indeks
                    (i31, PBRnV[0][1], PBRnV[3][2], PBRnV[0][0])+" blok");
                    System.out.println(">> Tanpa indeks, jumlah blok yang diakses : "+
                        Menu_3.Tanpa_indeks(i31, PBRnV[0][1], PBRnV[3][0])+ " blok");
                    break;
                    }else{
                        System.out.println("Invalid");
                        break;
                    }
                }else System.out.println("Table not found");
                break;
            case 4: 
                System.out.println("");
                System.out.println("Input Query:");
                System.out.print(">> SELECT "); 
                // id_pelanggan,nama_pelanggan from pelanggan where id_pelanggan = 190 ;
                // id_pelanggan,nama_pelanggan from pelanggan join sewa using (id_pelanggan) ;
                Scanner sc4 = new Scanner(System.in);
                String i4 = sc4.nextLine();
                String[] ai41 = i4.split(" "); // Split Input
                String[] ai42 = ai41[0].split(","); // Projection
                
                Menu_4 menu_4 = new Menu_4();
                for (int i = 0; i < ai42.length; i++){
                    boolean t = false;
                    if(ai41[2].equalsIgnoreCase(table[0][0])){
                        for (int j = 1; j < 5; j++) {
                            if(ai42[i].equalsIgnoreCase(table[0][j])){
                                t = true;
                                break;
                            }else{
                                /*System.out.println("\nOutput:");
                                System.out.println("Cannot find column");
                                System.exit(0);*/
                            }
                        }
                        if(t == false){
                            System.out.println("\nOutput:");
                            System.out.println("Cannot find column");
                            System.exit(0);
                        }
                    }else{
                        if(ai41[2].equalsIgnoreCase(table[1][0])){
                        for (int j = 1; j < 5; j++) {
                            if(ai42[i].equalsIgnoreCase(table[1][j])){
                                t = true;
                                break;
                            }else{
                                /*System.out.println("\nOutput:");
                                System.out.println("Cannot find column");
                                System.exit(0);*/
                            }
                        }
                        if(t == false){
                            System.out.println("\nOutput:");
                            System.out.println("Cannot find column");
                            System.exit(0);
                        }
                        }else{
                            if(ai41[2].equalsIgnoreCase(table[2][0])){
                            for (int j = 1; j < 5; j++) {
                                if(ai42[i].equalsIgnoreCase(table[2][j])){
                                    t = true;
                                    break;
                                }else{
                                    /*System.out.println("\nOutput:");
                                    System.out.println("Cannot find column");
                                    System.exit(0);*/
                                }
                            }
                            if(t == false){
                                System.out.println("\nOutput:");
                                System.out.println("Cannot find column");
                                System.exit(0);
                            }
                            }else{
                                break;
                            }
                        }
                    }
                }
                
                if(ai41[1].equalsIgnoreCase("FROM") && ai41[3].equalsIgnoreCase("WHERE") && ai41[5].equalsIgnoreCase("=")){
                    try{
                    if(ai41[7].equalsIgnoreCase(";")){
                        menu_4.Query_BASIC(ai41, ai42);
                        System.exit(0);
                    }else{
                        /*System.out.println("\nOutput:");
                        System.out.println("SQL Error (Missing ;)");
                        System.exit(0);*/
                    }
                    }catch(Exception e){
                        System.out.println("\nOutput:");
                        System.out.println("SQL Error (Missing ;)");
                        System.exit(0);
                    }
                }else{
                    if(ai41[1].equalsIgnoreCase("FROM") && ai41[3].equalsIgnoreCase("JOIN") && ai41[5].equalsIgnoreCase("USING") && (ai41[6].equalsIgnoreCase("("+table[0][1]+")")||ai41[6].equalsIgnoreCase("("+table[1][1]+")")
                            || ai41[6].equalsIgnoreCase("("+table[2][1]+")"))){
                        try{
                        if(ai41[7].equalsIgnoreCase(";")){
                            menu_4.Query_JOIN(ai41, ai42);
                            System.exit(0);
                        }else{
                            /*System.out.println("\nOutput:");
                            System.out.println("SQL Error (Missing ;)");
                            System.exit(0);*/
                        }
                        }catch(Exception e){
                            System.out.println("\nOutput:");
                            System.out.println("SQL Error (Missing ;)");
                            System.exit(0);
                        }
                    }else{
                        System.out.println("\nOutput:");
                        System.out.println("SQL Error (Syntax Error)");
                        System.exit(0);
                    }
                }
            case 5: 
                String lokasi_file = "SHARED POOL.txt";
                Menu_5 menu_5 = new Menu_5();
                menu_5.Shared_Pool(lokasi_file);
                break;
            default: 
                System.out.println("Invalid");
                break;
        }
        
        
    }
    
}
