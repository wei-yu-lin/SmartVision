# SmartVision

SmartVision 是一個圖片分類與模型管理平台，整合了以下技術：

- **前端**：React
- **後端**：Spring Boot
- **AI 模型 API**：FastAPI + PyTorch
1
### 功能特色

- 圖片上傳與分類結果查詢
- 模型版本追蹤與管理
- MLOps 自動部署與紀錄

此平台可作為 AI 團隊內部的簡易落地系統展示範例。


## 架構圖
```
[使用者] ⇄ [React 前端]
              ⇅
      [Spring Boot 後端]
         ⇅             ⇅
[FastAPI 模型服務]   [MLflow Server]
         ⇅
   [儲存模型 / 預測結果]
```

## Tech Stack

<table>
  <tr>
    <th>模組</th>
    <th>技術</th>
  </tr>
  <tr>
    <td>前端</td>
    <td>React.js + Tailwind + Axios</td>
  </tr>
  <tr>
    <td>後端</td>
    <td>Spring Boot（REST API + Multipart Upload）</td>
  </tr>
  <tr>
    <td>AI 模型服務</td>
    <td>Python + FastAPI + PyTorch (or TensorFlow)</td>
  </tr>
  <tr>
    <td>MLOps</td>
    <td>MLflow Tracking + Docker</td>
  </tr>
  <tr>
    <td>資料庫</td>
    <td>PostgreSQL or SQLite（記錄預測歷史）</td>
  </tr>
  <tr>
    <td>DevOps</td>
    <td>Docker Compose + GitHub Actions（進階可部署到雲端）</td>
  </tr>
</table>


## ✅ 專案功能總覽

### 使用者端 (React)
- ✅ 圖片上傳表單
- ✅ 展示預測結果（圖 + 分類 + 信心度）
- ✅ 歷史紀錄頁（拉取 Spring Boot API 顯示預測紀錄）
- ✅ 模型版本顯示（從 MLflow 拉目前的模型版本）

---

### 後端 (Spring Boot)
- ✅ 上傳圖片 API
- ✅ 呼叫 FastAPI 模型服務取得預測結果
- ✅ 存入預測紀錄至資料庫（圖片名稱、結果、模型版本、時間戳）
- ✅ API 提供歷史紀錄資料給前端

---

###  模型 API (Python + FastAPI)
- ✅ 載入預訓練模型（可用 torchvision 或 HuggingFace）
- ✅ 預測上傳圖片並回傳 JSON 結果
- ✅ 加入 MLflow log：input hash、model version、prediction、accuracy
- ✅ 支援模型版本切換（例如用 querystring 控制版本）

### MLOps
- ✅ MLflow Tracking Server 記錄訓練實驗
- ✅ 可選自動 retrain 流程（用 GitHub Actions / shell 模擬）
- ✅ Docker 化整個系統 → docker-compose up 一鍵起服務