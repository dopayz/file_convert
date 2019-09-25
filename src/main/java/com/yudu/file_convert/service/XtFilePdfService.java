package com.yudu.file_convert.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class XtFilePdfService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean queryById(String id){
        String sql = "select * from xt_file_pdf where id = ? ";
        List<Map<String, Object>> res = jdbcTemplate.queryForList(sql,id);
        return res.size() !=0 ? true:false;
    }

    public boolean insert(String id,String bid,String name,String path,Long fileSize,byte[] bytes){
        String sql = "insert into xt_file_pdf(id,bid,name,path,file_type,file_size,upload_time," +
                "upload_stepid,state,version,data,file_sort) values(?,?,?,?,?,?,to_date(?,'YYYY-MM-DD HH24:MI:SS'),?,?,?,?,?)";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        int res = jdbcTemplate.update(sql, id,
                bid,name,path,"pdf",fileSize, LocalDateTime.now().format(formatter),0,1,0,bytes,1);
        return res == 0 ? false:true;
    }
}
