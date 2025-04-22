FROM openjdk:17-jdk
WORKDIR /app
COPY . .
RUN javac Main.java  # 編譯 Java 文件
CMD ["java", "Main"] # 執行主類別
