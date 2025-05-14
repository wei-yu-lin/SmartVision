package com.example.SmartVision.controller;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.SmartVision.controller.dto.image.Request.HistoryRequest;
import com.example.SmartVision.controller.dto.image.Response.HistoryResponse;
import com.example.SmartVision.service.ImageService;

import java.nio.file.Files;
import java.nio.file.Path;

@Slf4j
@RestController
@RequestMapping("/image")
public class ImageController {
    private final ImageService imageService;
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }
    @GetMapping("test")
    public void getMethodName() {
        String currentDir = System.getProperty("user.dir"); // 取得當前路徑
    log.info("Current working directory: {}", currentDir);
    }

    @PostMapping
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            String uploadFolder = this.imageService.buildFolderPath();
            // 儲存檔案（避免覆蓋，加上 UUID）
            String filename = UUID.randomUUID() + "_" + file.getOriginalFilename();
            Path filepath = Paths.get(uploadFolder, filename);
            Files.write(filepath, file.getBytes());

            return ResponseEntity.ok("上傳成功，檔案名稱：" + filename);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("上傳失敗：" + e.getMessage());
        }
    }
    @GetMapping("/history")
    public ResponseEntity<List<HistoryResponse>> getHistory(
            @RequestParam(required = false) Integer limit,
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) String modelVersion,
            @RequestParam(required = false) String prediction) {
        try {
            HistoryRequest historyRequestDto = new HistoryRequest(limit, page, modelVersion, prediction);
            List<HistoryResponse> historyResponse = new ArrayList<>();

            return ResponseEntity.ok(historyResponse);
        } catch (Error e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
