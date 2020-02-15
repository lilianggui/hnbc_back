package com.llg.hnbc.controller;

import com.llg.hnbc.entity.SystemFile;
import com.llg.hnbc.result.Result;
import com.llg.hnbc.service.interfaces.SystemFileService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;

@RestController
public class SystemFileController {

    @Resource
    private SystemFileService systemfileService;

    @RequestMapping(value = "upload",method = RequestMethod.POST)
    public Result upload(MultipartFile file, SystemFile systemFile){
        systemfileService.saveSystemFile(file, systemFile);
        return Result.buildBaseSuccess(systemFile);
    }

    @GetMapping("getPicture")
    public void getPicture(SystemFile systemFile, HttpServletResponse response){
        this.getFile(systemFile, response);
    }

    @GetMapping("getFile")
    public void getFile(SystemFile systemFile, HttpServletResponse response){
        File file = new File(systemFile.getFilePath());
        try (BufferedInputStream buf = new BufferedInputStream(new FileInputStream(file));
             ServletOutputStream out = response.getOutputStream()) {
            byte[] buffer = new byte[1024];
            while (buf.read(buffer) != -1) {
                out.write(buffer);
            }
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("getSystemFileList")
    public Result getSystemFileList(SystemFile systemFile){
        List<SystemFile> systemFileList = systemfileService.getSystemFileList(systemFile);
        return Result.buildBaseSuccess(systemFileList);
    }

    @PostMapping("deleteSystemFile")
    public Result deleteSystemFile(SystemFile systemFile){
        systemfileService.deleteSystemFile(systemFile);
        return Result.buildBaseSuccess();
    }



}
