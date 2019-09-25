package com.yudu.file_convert.service;

import com.yudu.file_convert.utils.ObjectAndByte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.util.Map;

@Service
public class XtFileService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String queryById(String id){
        String sql = "select * from xt_file where id = ? ";
        Map<String, Object> res = jdbcTemplate.queryForMap(sql,id);
        if(null != res.get("DATA")){
            return (String)res.get("BID");
        }else{
            return null;
        }
    }
    public byte[] getBytesById(String id) throws Exception{
        String sql = "select * from xt_file where id = ? ";
        Map<String, Object> res = jdbcTemplate.queryForMap(sql,id);
        byte[] data = (byte[])res.get("DATA");
//      FileOutputStream fos = new FileOutputStream("D:\\ofd\\123.ofd");
//      fos.write(data);
//      fos.close();
        return data;
    }
    public String getFileNameById(String id){
        String sql = "select * from xt_file where id = ? ";
        Map<String, Object> res = jdbcTemplate.queryForMap(sql,id);
        if(null != res.get("NAME")){
            return (String)res.get("NAME");
        }else{
            return null;
        }
    }
}
