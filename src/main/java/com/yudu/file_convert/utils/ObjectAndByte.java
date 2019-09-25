package com.yudu.file_convert.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectAndByte {
    public static byte[] object2ByteArray(Object obj){
        byte[] bytes = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.flush();
            bytes = bos.toByteArray();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                oos.close();
                bos.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return bytes;
    }
}
