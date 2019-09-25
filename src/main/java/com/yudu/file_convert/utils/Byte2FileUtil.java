package com.yudu.file_convert.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Byte2FileUtil {
    public static File byte2File(byte[] buf,String filePath,String fileName){
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file = null;
        try{
            File dir = new File(filePath);
            if (dir.exists() == false){
                dir.mkdirs();
            }
            file = new File(filePath+File.separator+fileName);
            //file.createNewFile();
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(buf);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (null != bos){
                try {
                    bos.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if (null != fos){
                try {
                    fos.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return file;
    }
}
