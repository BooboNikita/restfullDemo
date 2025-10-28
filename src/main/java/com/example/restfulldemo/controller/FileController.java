package com.example.restfulldemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Controller
@RequestMapping(value = "/file")
public class FileController {
    private static final Logger logger = LoggerFactory.getLogger(FileController.class);
    private static final String UPLOAD_DIR = "D:\\upload\\";

    @RequestMapping(value = "upload")
    @ResponseBody
    public String upload(@RequestParam("testFile") MultipartFile file) {
        if (file.isEmpty()) {
            return "文件为空";
        }

        // 获取文件名
        String fileName = file.getOriginalFilename();
        logger.info("上传的文件名为：" + fileName);

        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        logger.info("上传的后缀名为：" + suffixName);

        // 创建上传目录（如果不存在）
        File dir = new File(UPLOAD_DIR);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        File dest = new File(UPLOAD_DIR + fileName);

        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }

        try {
            file.transferTo(dest);
            return "上传成功";
        } catch (IOException e) {
            logger.error("文件上传失败", e);
            return "上传失败: " + e.getMessage();
        }
    }

    /**
     * 文件下载
     * @param filename 要下载的文件名
     * @return 文件流
     */
    @GetMapping("/download/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> downloadFile(@PathVariable String filename) {
        try {
            // 设置文件路径
            File file = new File(UPLOAD_DIR + filename);

            if (!file.exists()) {
                return ResponseEntity.notFound().build();
            }

            // 设置响应头
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION,
                    "attachment; filename=" + URLEncoder.encode(filename, StandardCharsets.UTF_8));
            headers.add(HttpHeaders.CONTENT_TYPE, "application/octet-stream");

            // 读取文件内容到资源对象
            Resource resource = new FileSystemResource(file);

            return ResponseEntity.ok()
                    .headers(headers)
                    .contentLength(file.length())
                    .body(resource);

        } catch (Exception e) {
            logger.error("下载文件时发生错误: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
