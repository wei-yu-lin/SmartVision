package com.example.SmartVision.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class ImageService {

  @Value("${app.upload.dir}")
  private String uploadDir;

  // 依照每月建立資料夾
  public String buildFolderPath() {
    // 確保資料夾存在
    String currentMonth = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMM"));
    String directoryName = uploadDir + "/" + currentMonth;
    File uploadDirectory = new File(directoryName);
    if (!uploadDirectory.exists())
        uploadDirectory.mkdirs();
    return directoryName;
  }

}