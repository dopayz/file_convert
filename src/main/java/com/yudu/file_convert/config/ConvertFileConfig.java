package com.yudu.file_convert.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConvertFileConfig {
    @Value("${convert.url}")
    public String convertUrl;
    @Value("${ofd.path}")
    public String ofdPath;
    @Value("${pdf.path}")
    public String pdfPath;
}
