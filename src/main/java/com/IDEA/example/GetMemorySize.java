package com.IDEA.example;

import java.io.*;

public class GetMemorySize {
    public static void main(String[] args) {
        FileInputStream fs = null;
        InputStreamReader input = null;
        BufferedReader br = null;
        try{
            fs = new FileInputStream(new File("F:\\Document\\HandleFiles\\hdp198_memory.txt"));
            input = new InputStreamReader(fs);
            br = new BufferedReader(input);
            String str;
            double total_sum = 0;
            double actual_sum = 0;
            String[] strs = null;
//            str = br.readLine();
//            str = str.split("]")[1].trim();
//            strs = str.split("\\s+");
//            System.out.println(Double.parseDouble(strs[1]));
            while((str = br.readLine()) != null){
                str = str.split("]")[1].trim();
                strs = str.split("\\s+");
                total_sum += Double.parseDouble(strs[2]);
                actual_sum += Double.parseDouble(strs[3]);
            }

            System.out.println("total memory: " + total_sum/256/1024 + "G");
            System.out.println("actual memory: " + actual_sum/256/1024 + "G");

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                if(br != null) br.close();
                if(input != null) input.close();
                if(fs != null) fs.close();
            }catch (IOException ioe){ioe.printStackTrace();}
        }

    }
}
