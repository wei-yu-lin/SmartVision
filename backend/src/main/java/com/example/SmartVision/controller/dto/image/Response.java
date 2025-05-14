package com.example.SmartVision.controller.dto.image;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Response {
  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  public static class HistoryResponse {
    private UUID id;
    private String imageUrl;
    private String prediction; // 分類結果（例如："cat"、"pizza"）
    private double confidence; // 信心度（例如：0.92）
    private String modelVersion; // 模型版本（例如：v1.0、resnet50_2024）
    private LocalDateTime timestamp;
    private Integer totalCount;
    private Integer page;
  }
}
