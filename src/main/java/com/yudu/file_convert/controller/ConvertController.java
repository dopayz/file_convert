package com.yudu.file_convert.controller;

import com.suwell.ofd.custom.agent.HTTPAgent;
import com.yudu.file_convert.VO.ResultVO;
import com.yudu.file_convert.config.ConvertFileConfig;
import com.yudu.file_convert.utils.File2ByteUtil;
import com.yudu.file_convert.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;

@RestController
@RequestMapping("/api/convert")
public class ConvertController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private ConvertFileConfig convertFileConfig;

    @PostMapping("/pdfToOfd")
    public ResultVO pdfToOfd(@RequestParam("file") MultipartFile file){
        if(reduceFile(convertFileConfig.ofdPath) & reduceFile(convertFileConfig.pdfPath)) {
            HTTPAgent ha = new HTTPAgent(convertFileConfig.convertUrl);
            if (file.isEmpty()) {
                return ResultVOUtil.fileNotEmpty(null);
            }
            String fileName = file.getOriginalFilename();
            String prefix = fileName.substring(0, fileName.lastIndexOf("."));//前缀
            String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);//后缀
            String customName = System.currentTimeMillis() + "." + suffix;
            String filePath = convertFileConfig.pdfPath;
            File dest = new File(filePath + customName);
            try {
                //https://blog.csdn.net/maowendi/article/details/80537304 postman模拟文件上传
                //MultipartFile转File
                file.transferTo(dest);
                String ofdPath = convertFileConfig.ofdPath + prefix + System.currentTimeMillis() + ".ofd";
                //pdf转ofd
                ha.officeToOFD(dest, new FileOutputStream(ofdPath));
                //删除pdf文件
                dest.delete();
                //转二进制数据
                File ofdFile = new File(ofdPath);
                byte[] bytes = File2ByteUtil.file2Byte(ofdFile);
                //模拟数据
//                String sql = "update xt_file set data = ? where id=?";
//                jdbcTemplate.update(sql, bytes, "2");
                return ResultVOUtil.success(bytes);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ResultVOUtil.error(null);
    }

    @PostMapping("/ofdToPdf")
    public ResultVO ofdToPdf(@RequestParam("file") MultipartFile file){
        if(reduceFile(convertFileConfig.ofdPath) & reduceFile(convertFileConfig.pdfPath)) {
            HTTPAgent ha = new HTTPAgent(convertFileConfig.convertUrl);
            if (file.isEmpty()) {
                return ResultVOUtil.fileNotEmpty(null);
            }
            String fileName = file.getOriginalFilename();
            String prefix = fileName.substring(0, fileName.lastIndexOf("."));//前缀
            String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);//后缀
            String customName = System.currentTimeMillis() + "." + suffix;
            String filePath = convertFileConfig.ofdPath;
            File dest = new File(filePath + customName);
            try {
                //MultipartFile转File
                file.transferTo(dest);
                String pdfPath = convertFileConfig.pdfPath + System.currentTimeMillis() + ".pdf";
                //ofd转pdf
                ha.OFDToPDF(dest, new FileOutputStream(pdfPath));
                //删除pdf文件
                dest.delete();
                //转二进制数据
                File ofdFile = new File(pdfPath);
                byte[] bytes = File2ByteUtil.file2Byte(ofdFile);
                return ResultVOUtil.success(bytes);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ResultVOUtil.error(null);
    }
    //创建文件夹
    public boolean reduceFile(String filePath){
        File dir = new File(filePath);
        if (dir.exists() == false){
            dir.mkdirs();
            return true;
        }
        return true;
    }
}
