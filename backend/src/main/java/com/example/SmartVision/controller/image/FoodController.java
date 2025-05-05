package com.example.SmartVision.controller.image;
import com.example.SmartVision.controller.dto.food.Request.HistoryRequest;
import com.example.SmartVision.controller.dto.food.Response.HistoryResponse;

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

import java.nio.file.Files;
import java.nio.file.Path;

@RestController
@RequestMapping("/image/food")
public class FoodController {
    private static final String UPLOAD_DIR = "uploads/";

    @PostMapping
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            // 確保資料夾存在
            File uploadDir = new File(UPLOAD_DIR);
            if (!uploadDir.exists())
                uploadDir.mkdirs();

            // 儲存檔案（避免覆蓋，加上 UUID）
            String filename = UUID.randomUUID() + "_" + file.getOriginalFilename();
            Path filepath = Paths.get(UPLOAD_DIR, filename);
            Files.write(filepath, file.getBytes());

            return ResponseEntity.ok("上傳成功，檔案名稱：" + filename);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("上傳失敗：" + e.getMessage());
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
