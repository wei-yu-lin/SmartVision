package com.example.SmartVision.controller.dto.image;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Request {
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class HistoryRequest {
        private Integer limit;
        private Integer page;
        private String modelVersion;
        private String prediction;
    }
}
