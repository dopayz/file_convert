package com.yudu.file_convert.controller;

import com.suwell.ofd.custom.agent.HTTPAgent;
import com.yudu.file_convert.config.ConvertFileConfig;
import com.yudu.file_convert.service.XtFilePdfService;
import com.yudu.file_convert.service.XtFileService;
import com.yudu.file_convert.utils.Byte2FileUtil;
import com.yudu.file_convert.utils.File2ByteUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileOutputStream;

@RestController
@RequestMapping("/oa/convert")
public class OAConvertController {
    private static final Logger logger = LoggerFactory.getLogger(OAConvertController.class);
    @Autowired
    private ConvertFileConfig convertFileConfig;
    @Autowired
    private XtFileService xtFileService;
    @Autowired
    private XtFilePdfService xtFilePdfService;
    @GetMapping("ofd2Pdf")
    public boolean ofd2Pdf(@RequestParam("id") String id){
        HTTPAgent ha = new HTTPAgent(convertFileConfig.convertUrl);
        boolean res  = xtFilePdfService.queryById(id);
        try{
            if(!res){
                String fileName = xtFileService.getFileNameById(id);
                File file = Byte2FileUtil.byte2File(xtFileService.getBytesById(id),
                        convertFileConfig.ofdPath, fileName+".ofd");
                String pdfPath = convertFileConfig.pdfPath+fileName+".pdf";
                reduceFile(convertFileConfig.pdfPath);
                //ofd转pdf
                ha.OFDToPDF(file, new FileOutputStream(pdfPath));
                //删除pdf文件
                //file.delete();
                File ofdFile = new File(pdfPath);
                String bid = xtFileService.queryById(id);
                byte[] bytes = File2ByteUtil.file2Byte(ofdFile);
                //临时修改
                pdfPath ="upload/" + bid.substring(0,6)+"/"+bid+"/"+id+".pdf";
                return xtFilePdfService.insert(id,bid,fileName,pdfPath,ofdFile.length(),bytes);
            }else {
                return false;
            }
        }catch (Exception e){
            logger.error(e.toString(),e);
            e.printStackTrace();
        }
        return false  ;
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
