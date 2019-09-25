package com.yudu.file_convert.utils;

import java.io.*;

public class File2ByteUtil {
    public static byte[] file2Byte(File tradeFile){
        byte[] buffer = null;
        try {
            FileInputStream ofdFis = new FileInputStream(tradeFile);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] bytes = new byte[1024];
            int n;
            while ((n = ofdFis.read(bytes)) != -1) {
                bos.write(bytes, 0, n);
            }
            ofdFis.close();
            bos.close();
            buffer = bos.toByteArray();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return buffer;
    }
}
