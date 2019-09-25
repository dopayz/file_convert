package com.yudu.file_convert.ofdConvert;

import com.suwell.ofd.custom.agent.HTTPAgent;
import com.yudu.file_convert.config.ConvertFileConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class OfdConvertTest {
//        @Autowired
//        private ConvertFileConfig convertFileConfig;
//        @Test
//        public void test01(){
//            HTTPAgent ha = new HTTPAgent(convertFileConfig.convertUrl);
//            //File file = new File("F:\\BaiduNetdiskDownload\\SpringApplication.pdf");//pdf
//            File file = new File("C:\\Users\\Administrator\\Desktop\\files\\idea安装.docx");//docx
//            String fileName = file.getName();
//            String suffix = fileName.substring(0,fileName.lastIndexOf("."));
//            try {
//                ha.officeToOFD(file, new FileOutputStream("D:\\ofd\\" +suffix+System.currentTimeMillis()+ ".ofd"));
//            } catch (Exception e) {
//                e.printStackTrace();
//            } finally {
//                try {
//                    ha.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        @Test
//        public void test02(){
//            HTTPAgent ha = new HTTPAgent(convertFileConfig.convertUrl);
//            File file = new File("C:\\Users\\Administrator\\Desktop\\SpringApplication(2).ofd");
//            String fileName = file.getName();
//            String suffix = fileName.substring(0,fileName.lastIndexOf("."));
//            try{
//                ha.OFDToPDF(file,new FileOutputStream("D:\\pdf\\"+suffix+System.currentTimeMillis()+".pdf"));
//            }catch (Exception e){
//                e.printStackTrace();
//            }finally {
//                try {
//                    ha.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
}
