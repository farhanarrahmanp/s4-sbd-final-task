/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes.sbd_ifik4103_k5;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Math.ceil;
/**
 *
 * @author Farhan
 */
public class Menu_4 {
    int A1_key;
    int A1;
    int A2;
    int A3;
    int Worst_case_1;
    int Worst_case_2;
    
    
    void Menulis_Data(String text) throws FileNotFoundException, IOException{
        
        FileWriter fw = new FileWriter("SHARED POOL.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw);
        out.println(text);
        out.close();
    }
        
    
    void Query_BASIC(String[] ai41, String[] ai42) throws IOException{
        System.out.println("");
        System.out.println("Output:");
        for (int h = 0; h < 1; h++) {
            System.out.println(">> Tabel ("+(h+1)+") : "+ai41[h+2].toUpperCase());
            System.out.print("List Kolom : ");
            for (int j = 0; j < ai42.length; j++) {
                System.out.print(ai42[j].toUpperCase()+", ");   
            }
        }
        System.out.println("");
        for (int i = 0; i < 2; i++) {
            System.out.println(">> QEP #"+(i+1));
            System.out.print("PROJECTION ");
            for (int j = 0; j < ai42.length; j++) {
                System.out.print(ai42[j].toUpperCase()+", ");
            }
            System.out.println("-- on the fly");
            for (int k = 4; k < 5; k++) {
                System.out.print("SELECTION "+ai41[k].toUpperCase());
                System.out.print(" "+ai41[k+1].toUpperCase());
                System.out.print(" "+ai41[k+2].toUpperCase());               
            }
            if(ai41[4].equalsIgnoreCase(parsing.data_dictionary[1][1])&&i==0||
                    ai41[4].equalsIgnoreCase(parsing.data_dictionary[2][1])&&i==0||
                    ai41[4].equalsIgnoreCase(parsing.data_dictionary[3][1])&&i==0){
                System.out.println(" -- A"+(i+1)+" key");
            }else if(ai41[4]!=parsing.data_dictionary[1][1]&&i==0||
                    ai41[4]!=parsing.data_dictionary[2][1]&&i==0||
                    ai41[4]!=parsing.data_dictionary[3][1]&&i==0){
                System.out.println(" -- A"+(i+1));
            }else if(ai41[4].equalsIgnoreCase(parsing.data_dictionary[1][1])&&i==1||
                    ai41[4].equalsIgnoreCase(parsing.data_dictionary[2][1])&&i==1||
                    ai41[4].equalsIgnoreCase(parsing.data_dictionary[3][1])&&i==1){
                System.out.println(" -- A"+(i+1));
            }else if(ai41[4]!=parsing.data_dictionary[1][1]&&i==1||
                    ai41[4]!=parsing.data_dictionary[2][1]&&i==1||
                    ai41[4]!=parsing.data_dictionary[3][1]&&i==1){
                System.out.println(" -- A"+(i+2));
            }
            int tS = 0;
            int tT = 1;
            int A1_key = 0;
            int A1 = 0;
            int A2 = 0;
            int A3 = 0;
            double hi = 0;
            System.out.println(ai41[2].toUpperCase());
            System.out.print("Cost : ");
            if((this.A1_key == 0 || this.A1 == 0) && i==0/*(ai41[2].equalsIgnoreCase(parsing.data_dictionary[1][0])||
                    ai41[2].equalsIgnoreCase(parsing.data_dictionary[2][0])||
                    ai41[2].equalsIgnoreCase(parsing.data_dictionary[3][0]))*/){
                if(ai41[4].equalsIgnoreCase(parsing.data_dictionary[1][1])){ // A1_Key
                    A1_key = tS + ((Menu_2.Total_Block_Data(
                            Integer.parseInt(parsing.data_dictionary[1][8]), 
                            Integer.parseInt(parsing.data_dictionary[0][3]), 
                            Integer.parseInt(parsing.data_dictionary[1][6])))/2) * tT;
                    this.A1_key = A1_key;
                    System.out.println(A1_key+" block");
                }else if(ai41[4].equalsIgnoreCase(parsing.data_dictionary[2][1])){
                    A1_key = tS + ((Menu_2.Total_Block_Data(
                            Integer.parseInt(parsing.data_dictionary[2][8]), 
                            Integer.parseInt(parsing.data_dictionary[0][3]), 
                            Integer.parseInt(parsing.data_dictionary[2][6])))/2) * tT;
                    this.A1_key = A1_key;
                    System.out.println(A1_key+" block");
                }else if(ai41[4].equalsIgnoreCase(parsing.data_dictionary[3][1])){
                    A1_key = tS + ((Menu_2.Total_Block_Data(
                            Integer.parseInt(parsing.data_dictionary[3][8]), 
                            Integer.parseInt(parsing.data_dictionary[0][3]), 
                            Integer.parseInt(parsing.data_dictionary[3][6])))/2) * tT;
                    this.A1_key = A1_key;
                    System.out.println(A1_key+" block");
                }else if(this.A1_key == 0 && i == 0){   // A1_Nonkey
                    if(ai41[2].equalsIgnoreCase(parsing.data_dictionary[1][0])){
                        A1 = tS + (Menu_2.Total_Block_Data(
                            Integer.parseInt(parsing.data_dictionary[1][8]), 
                            Integer.parseInt(parsing.data_dictionary[0][3]), 
                            Integer.parseInt(parsing.data_dictionary[1][6]))) * tT;
                        this.A1 = A1;
                        System.out.println(A1+" block");
                    }else if(ai41[2].equalsIgnoreCase(parsing.data_dictionary[2][0])){
                        A1 = tS + (Menu_2.Total_Block_Data(
                            Integer.parseInt(parsing.data_dictionary[2][8]), 
                            Integer.parseInt(parsing.data_dictionary[0][3]), 
                            Integer.parseInt(parsing.data_dictionary[2][6]))) * tT;
                        this.A1 = A1;
                        System.out.println(A1+" block");
                    }else if(ai41[2].equalsIgnoreCase(parsing.data_dictionary[3][0])){
                        A1 = tS + (Menu_2.Total_Block_Data(
                            Integer.parseInt(parsing.data_dictionary[3][8]), 
                            Integer.parseInt(parsing.data_dictionary[0][3]), 
                            Integer.parseInt(parsing.data_dictionary[3][6]))) * tT;
                        this.A1 = A1;
                        System.out.println(A1+" block");
                    }
                }
            }
            if((this.A1_key != 0) && i==1/*i == 1 && (ai41[2].equalsIgnoreCase(parsing.data_dictionary[1][0])||
                    ai41[2].equalsIgnoreCase(parsing.data_dictionary[2][0])||
                    ai41[2].equalsIgnoreCase(parsing.data_dictionary[3][0]))*/){ // A2_Key
                            if(ai41[4].equalsIgnoreCase(parsing.data_dictionary[1][1])){
                                hi = (int) ceil(Math.log(Menu_2.Total_Block_Data(
                            Integer.parseInt(parsing.data_dictionary[1][8]), 
                            Integer.parseInt(parsing.data_dictionary[0][3]), 
                            Integer.parseInt(parsing.data_dictionary[1][6])))/
                                        Math.log(Menu_1.Fan_Out_Ratio(
                                                Integer.parseInt(parsing.data_dictionary[0][3]), 
                                                Integer.parseInt(parsing.data_dictionary[1][10]), 
                                                Integer.parseInt(parsing.data_dictionary[0][1]))));
                                A2 = (int) ((hi + 1) * tT + tS);
                                this.A2 = A2;
                                System.out.println(this.A2+" block");
                            }else if(ai41[4].equalsIgnoreCase(parsing.data_dictionary[2][1])){
                                hi = (int) ceil(Math.log(Menu_2.Total_Block_Data(
                            Integer.parseInt(parsing.data_dictionary[2][8]), 
                            Integer.parseInt(parsing.data_dictionary[0][3]), 
                            Integer.parseInt(parsing.data_dictionary[2][6])))/
                                        Math.log(Menu_1.Fan_Out_Ratio(
                                                Integer.parseInt(parsing.data_dictionary[0][3]), 
                                                Integer.parseInt(parsing.data_dictionary[2][10]), 
                                                Integer.parseInt(parsing.data_dictionary[0][1]))));
                                A2 = (int) ((hi + 1) * tT + tS);
                                this.A2 = A2;
                                System.out.println(this.A2+" block");
                            }else if(ai41[4].equalsIgnoreCase(parsing.data_dictionary[3][1])){
                                hi = (int) ceil(Math.log(Menu_2.Total_Block_Data(
                            Integer.parseInt(parsing.data_dictionary[3][8]), 
                            Integer.parseInt(parsing.data_dictionary[0][3]), 
                            Integer.parseInt(parsing.data_dictionary[3][6])))/
                                        Math.log(Menu_1.Fan_Out_Ratio(
                                                Integer.parseInt(parsing.data_dictionary[0][3]), 
                                                Integer.parseInt(parsing.data_dictionary[3][10]), 
                                                Integer.parseInt(parsing.data_dictionary[0][1]))));
                                A2 = (int) ((hi + 1) * tT + tS);
                                this.A2 = A2;
                                System.out.println(this.A2+" block");
                            }
                        }else if (this.A1 != 0 && i==1){ // A2_Nonkey (A3)
                            if(ai41[2].equalsIgnoreCase(parsing.data_dictionary[1][0])){
                                hi = (int) ceil(Math.log(Menu_2.Total_Block_Data(
                            Integer.parseInt(parsing.data_dictionary[1][8]), 
                            Integer.parseInt(parsing.data_dictionary[0][3]), 
                            Integer.parseInt(parsing.data_dictionary[1][6])))/
                                        Math.log(Menu_1.Fan_Out_Ratio(
                                                Integer.parseInt(parsing.data_dictionary[0][3]), 
                                                Integer.parseInt(parsing.data_dictionary[1][10]), 
                                                Integer.parseInt(parsing.data_dictionary[0][1])))); 
                                A3 = (int) hi * (tT + tS) + Menu_2.Total_Block_Data(
                            Integer.parseInt(parsing.data_dictionary[1][8]), 
                            Integer.parseInt(parsing.data_dictionary[0][3]), 
                            Integer.parseInt(parsing.data_dictionary[1][6])) * tT;
                                this.A3 = A3;
                                System.out.println(this.A3+" block");
                        }else if(ai41[2].equalsIgnoreCase(parsing.data_dictionary[2][0])){
                                hi = (int) ceil(Math.log(Menu_2.Total_Block_Data(
                            Integer.parseInt(parsing.data_dictionary[2][8]), 
                            Integer.parseInt(parsing.data_dictionary[0][3]), 
                            Integer.parseInt(parsing.data_dictionary[2][6])))/
                                        Math.log(Menu_1.Fan_Out_Ratio(
                                                Integer.parseInt(parsing.data_dictionary[0][3]), 
                                                Integer.parseInt(parsing.data_dictionary[2][10]), 
                                                Integer.parseInt(parsing.data_dictionary[0][1])))); 
                                A3 = (int) hi * (tT + tS) + Menu_2.Total_Block_Data(
                            Integer.parseInt(parsing.data_dictionary[2][8]), 
                            Integer.parseInt(parsing.data_dictionary[0][3]), 
                            Integer.parseInt(parsing.data_dictionary[2][6])) * tT;
                                this.A3 = A3;
                                System.out.println(this.A3+" block");
                        }else if(ai41[2].equalsIgnoreCase(parsing.data_dictionary[3][0])){
                                hi = (int) ceil(Math.log(Menu_2.Total_Block_Data(
                            Integer.parseInt(parsing.data_dictionary[3][8]), 
                            Integer.parseInt(parsing.data_dictionary[0][3]), 
                            Integer.parseInt(parsing.data_dictionary[3][6])))/
                                        Math.log(Menu_1.Fan_Out_Ratio(
                                                Integer.parseInt(parsing.data_dictionary[0][3]), 
                                                Integer.parseInt(parsing.data_dictionary[3][10]), 
                                                Integer.parseInt(parsing.data_dictionary[0][1])))); 
                                A3 = (int) hi * (tT + tS) + Menu_2.Total_Block_Data(
                            Integer.parseInt(parsing.data_dictionary[3][8]), 
                            Integer.parseInt(parsing.data_dictionary[0][3]), 
                            Integer.parseInt(parsing.data_dictionary[3][6])) * tT;
                                this.A3 = A3;
                                System.out.println(this.A3+" block");
                                }
                            }
                        }
            System.out.print(">> QEP optimal : ");
            Menu_4 menu_4 = new Menu_4();
            if(A1_key>A2){
                System.out.println("QEP#2");
                menu_4.Menulis_Data("Query : SELECT "+ai42[0].toUpperCase()+", "+ai42[1].toUpperCase()+" FROM "+ai41[2].toUpperCase()+
                        " WHERE "+ai42[0].toUpperCase()+" = "+ai41[6].toUpperCase()+";\n"+
                        "PROJECTION "+ai42[0].toUpperCase()+", "+ai42[1].toUpperCase()+" -- on the fly"+"\n"+
                        "SELECTION "+ai42[0].toUpperCase()+" = "+ai41[6].toUpperCase()+" -- A2\n"+
                        ai41[2].toUpperCase()+"\n"+"Cost : "+A2+ " block\n");
            }else if (A1_key<A2){
                System.out.println("QEP#1");
                menu_4.Menulis_Data("Query : SELECT "+ai42[0].toUpperCase()+", "+ai42[1].toUpperCase()+" FROM "+ai41[2].toUpperCase()+
                        " WHERE "+ai42[0].toUpperCase()+" = "+ai41[6].toUpperCase()+";\n"+
                        "PROJECTION "+ai42[0].toUpperCase()+", "+ai42[1].toUpperCase()+" -- on the fly"+"\n"+
                        "SELECTION "+ai42[0].toUpperCase()+" = "+ai41[6].toUpperCase()+" -- A1 key\n"+
                        ai41[2].toUpperCase()+"\n"+"Cost : "+A1_key+" block\n");
            }else if(A1>A3){
                System.out.println("QEP#2");
                menu_4.Menulis_Data("Query : SELECT "+ai42[0].toUpperCase()+", "+ai42[1].toUpperCase()+" FROM "+ai41[2].toUpperCase()+
                        " WHERE "+ai42[0].toUpperCase()+" = "+ai41[6].toUpperCase()+";\n"+
                        "PROJECTION "+ai42[0].toUpperCase()+", "+ai42[1].toUpperCase()+" -- on the fly"+"\n"+
                        "SELECTION "+ai42[0].toUpperCase()+" = "+ai41[6].toUpperCase()+" -- A3\n"+
                        ai41[2].toUpperCase()+"\n"+"Cost : "+A3+" block\n");
            }else if(A1<A3){
                System.out.println("QEP#1");
                menu_4.Menulis_Data("Query : SELECT "+ai42[0].toUpperCase()+", "+ai42[1].toUpperCase()+" FROM "+ai41[2].toUpperCase()+
                        " WHERE "+ai42[0].toUpperCase()+" = "+ai41[6].toUpperCase()+";\n"+
                        "PROJECTION "+ai42[0].toUpperCase()+", "+ai42[1].toUpperCase()+" -- on the fly"+"\n"+
                        "SELECTION "+ai42[0].toUpperCase()+" = "+ai41[6].toUpperCase()+" -- A1\n"+
                        ai41[2].toUpperCase()+"\n"+"Cost : "+A1+" block\n");
            }
    }
    
    void Query_JOIN(String[] ai41, String[] ai42) throws IOException{
        System.out.println("");
        System.out.println("Output:");
        for (int h = 0; h < 2; h++) {
            if(h == 1){
                System.out.println(">> Tabel ("+(h+1)+") : "+ai41[h+3].toUpperCase());
                System.out.println("List Kolom : "+ai42[h-1].toUpperCase());
            }else{ System.out.println(">> Tabel ("+(h+1)+") : "+ai41[h+2].toUpperCase());
                System.out.print("List Kolom : ");
                for (int j = 0; j < ai42.length; j++) {
                    System.out.print(ai42[j].toUpperCase()+", "); 
                }
                System.out.println("");
            }
        }
        System.out.println("");
        for (int i = 0; i < 2; i++) {
            System.out.println(">> QEP #"+(i+1));
            System.out.print("PROJECTION ");
            for (int j = 0; j < ai42.length; j++) {
                System.out.print(ai42[j].toUpperCase()+", ");
            }
            System.out.println("-- on the fly");
            for (int k = 4; k < 5; k++) {
                System.out.println("\tJOIN "+ai41[k-2].toUpperCase()+"."+ai42[k-4].toUpperCase()+
                        " = "+ai41[k].toUpperCase()+"."+ai42[k-4].toUpperCase()+" -- BNLJ");         
            }
            if(i == 0){
                System.out.println(ai41[2].toUpperCase()+"\t"+ai41[4].toUpperCase());
            }else if(i == 1){
                System.out.println(ai41[4].toUpperCase()+"\t"+ai41[2].toUpperCase());
            }
            int Worst_case_1;
            int Worst_case_2;
            System.out.print("Cost (worst case): ");
            if(ai41[2].equalsIgnoreCase(parsing.data_dictionary[1][0])&&
                    ai41[4].equalsIgnoreCase(parsing.data_dictionary[3][0])){
                if(i == 0){
                                Worst_case_1 = (Menu_2.Total_Block_Data(
                            Integer.parseInt(parsing.data_dictionary[1][8]), 
                            Integer.parseInt(parsing.data_dictionary[0][3]), 
                            Integer.parseInt(parsing.data_dictionary[1][6])))*
                                (Menu_2.Total_Block_Data(
                            Integer.parseInt(parsing.data_dictionary[3][8]), 
                            Integer.parseInt(parsing.data_dictionary[0][3]), 
                            Integer.parseInt(parsing.data_dictionary[3][6])))+
                                  (Menu_2.Total_Block_Data(
                            Integer.parseInt(parsing.data_dictionary[1][8]), 
                            Integer.parseInt(parsing.data_dictionary[0][3]), 
                            Integer.parseInt(parsing.data_dictionary[1][6])));
                                this.Worst_case_1 = Worst_case_1;
                                System.out.println(this.Worst_case_1 + " block");
                                
                }else if(i == 1){           
                    Worst_case_2 = (Menu_2.Total_Block_Data(
                            Integer.parseInt(parsing.data_dictionary[3][8]), 
                            Integer.parseInt(parsing.data_dictionary[0][3]), 
                            Integer.parseInt(parsing.data_dictionary[3][6])))*
                                (Menu_2.Total_Block_Data(
                            Integer.parseInt(parsing.data_dictionary[1][8]), 
                            Integer.parseInt(parsing.data_dictionary[0][3]), 
                            Integer.parseInt(parsing.data_dictionary[1][6])))+
                                  (Menu_2.Total_Block_Data(
                            Integer.parseInt(parsing.data_dictionary[3][8]), 
                            Integer.parseInt(parsing.data_dictionary[0][3]), 
                            Integer.parseInt(parsing.data_dictionary[3][6])));
                                this.Worst_case_2 = Worst_case_2;
                                System.out.println(this.Worst_case_2 + " block");
                }
                
            }else if(ai41[2].equalsIgnoreCase(parsing.data_dictionary[2][0])&&
                    ai41[4].equalsIgnoreCase(parsing.data_dictionary[3][0])){
                if(i == 0){
                                Worst_case_1 = (Menu_2.Total_Block_Data(
                            Integer.parseInt(parsing.data_dictionary[2][8]), 
                            Integer.parseInt(parsing.data_dictionary[0][3]), 
                            Integer.parseInt(parsing.data_dictionary[2][6])))*
                                (Menu_2.Total_Block_Data(
                            Integer.parseInt(parsing.data_dictionary[3][8]), 
                            Integer.parseInt(parsing.data_dictionary[0][3]), 
                            Integer.parseInt(parsing.data_dictionary[3][6])))+
                                  (Menu_2.Total_Block_Data(
                            Integer.parseInt(parsing.data_dictionary[2][8]), 
                            Integer.parseInt(parsing.data_dictionary[0][3]), 
                            Integer.parseInt(parsing.data_dictionary[2][6])));
                                this.Worst_case_1 = Worst_case_1;
                                System.out.println(this.Worst_case_1 + " block");
                                
                }else if(i == 1){
                                Worst_case_2 = (Menu_2.Total_Block_Data(
                            Integer.parseInt(parsing.data_dictionary[3][8]), 
                            Integer.parseInt(parsing.data_dictionary[0][3]), 
                            Integer.parseInt(parsing.data_dictionary[3][6])))*
                                (Menu_2.Total_Block_Data(
                            Integer.parseInt(parsing.data_dictionary[2][8]), 
                            Integer.parseInt(parsing.data_dictionary[0][3]), 
                            Integer.parseInt(parsing.data_dictionary[2][6])))+
                                  (Menu_2.Total_Block_Data(
                            Integer.parseInt(parsing.data_dictionary[3][8]), 
                            Integer.parseInt(parsing.data_dictionary[0][3]), 
                            Integer.parseInt(parsing.data_dictionary[3][6])));
                                this.Worst_case_2 = Worst_case_2;
                                System.out.println(this.Worst_case_2 + " block");
                }
            }
        }
        Menu_4 menu_4j = new Menu_4();
        System.out.print(">> QEP optimal : ");
            if(Worst_case_1>Worst_case_2){
                System.out.println("QEP#2");
                menu_4j.Menulis_Data("Query : SELECT "+ai42[0].toUpperCase()+", "+ai42[1].toUpperCase()+
                        " FROM "+ai41[2].toUpperCase()+" JOIN "+ai41[4].toUpperCase()+" USING"+" ("+ai42[0].toUpperCase()+");\n"+
                        "PROJECTION "+ai42[0].toUpperCase()+", "+ai42[1].toUpperCase()+" -- on the fly"+"\n\t"+
                        "JOIN "+ai41[2].toUpperCase()+"."+ai42[0].toUpperCase()+" == "+ ai41[4].toUpperCase()+"."+ai42[0].toUpperCase()+" -- BNLJ\n"+
                        ai41[4].toUpperCase()+"\t"+ai41[2].toUpperCase()+"\n"+
                        "Cost (worst case) : "+Worst_case_2+" block\n");
            }else if (Worst_case_1<Worst_case_2){
                System.out.println("QEP#1");
                menu_4j.Menulis_Data("Query : SELECT "+ai42[0].toUpperCase()+", "+ai42[1].toUpperCase()+
                        " FROM "+ai41[2]+" JOIN "+ai41[4].toUpperCase()+" USING"+" ("+ai42[0].toUpperCase()+");\n"+
                        "PROJECTION "+ai42[0].toUpperCase()+", "+ai42[1].toUpperCase()+" -- on the fly"+"\n\t"+
                        "JOIN "+ai41[2].toUpperCase()+"."+ai42[0].toUpperCase()+" = "+ ai41[4].toUpperCase()+"."+ai42[0].toUpperCase()+" -- BNLJ\n"+
                        ai41[2].toUpperCase()+"\t"+ai41[4].toUpperCase()+"\n"+
                        "Cost (worst case) : "+Worst_case_1+" block\n");
            }
    }
}

            
            
