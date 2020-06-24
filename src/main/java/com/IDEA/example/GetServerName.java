package com.IDEA.example;

import java.io.*;

public class GetServerName {
    public static void main(String[] args) {
        RandomAccessFile raf = null;
        FileReader fr = null;
        BufferedReader br = null;
        try{
//            FileInputStream fs = new FileInputStream(new File("G:/LanxinFile/zzjt_port"));
//            InputStreamReader input = new InputStreamReader(fs);
//            BufferedReader br = new BufferedReader(input);
            raf = new RandomAccessFile(new File(""), "r");
fr = new FileReader(new File(""));
br = new BufferedReader(fr);
            String str;
            String[] strs = null;
            while((str = raf.readLine()) != null){
                strs = str.split(";");
                for(int i=0;i<strs.length;i++){
                    strs[i] = strs[i].split(",")[0];
                }
            }
            System.out.println(strs.length);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{if(raf != null) raf.close();
                if(br != null) br.close();
                if(fr != null) fr.close();
            }catch (IOException ioe){ioe.printStackTrace();}
        }

    }
}
