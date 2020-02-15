package com.llg.hnbc.service.impl;

import com.llg.hnbc.entity.SystemFile;
import com.llg.hnbc.mapper.dao.SystemFileDao;
import com.llg.hnbc.service.interfaces.SystemFileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class SystemFileImpl implements SystemFileService {


    @Value("${system.saveFilePath}")
    public String saveFilePath;

    private static SimpleDateFormat SF = new SimpleDateFormat("yyyyMMdd");

    @Resource
    private SystemFileDao systemFileDao;

    @Override
    public void add(SystemFile systemFile) {
        systemFileDao.add(systemFile);
    }

    @Override
    public List<SystemFile> getSystemFileList(SystemFile systemFile) {
        return systemFileDao.getSystemFileList(systemFile);
    }

    @Override
    public void deleteSystemFile(SystemFile systemFile) {
        systemFileDao.deleteSystemFile(systemFile);
    }

    @Override
    public SystemFile saveSystemFile(MultipartFile file, SystemFile systemFile) {
        String fileOriginName = file.getOriginalFilename();
        String fileFormat = fileOriginName.substring(fileOriginName.lastIndexOf("."));
//        File savePath = new File(saveFilePath + SF.format(new Date()));
//        if(!savePath.exists()){
//            savePath.mkdirs();
//        }
        String savePath = this.getSavePath();
        String saveFileName = UUID.randomUUID().toString().replaceAll("-", "") + fileFormat;
        File dest = new File(savePath, saveFileName);
        try {
            file.transferTo(dest);
            systemFile.setFileOriginName(fileOriginName);
            systemFile.setFileName(saveFileName);
            systemFile.setFileFormat(fileFormat);
            systemFile.setFilePath(dest.getAbsolutePath());
            this.add(systemFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return systemFile;
    }

    public String getSavePath(){
        File savePath = new File(saveFilePath + SF.format(new Date()));
        if(!savePath.exists()){
            savePath.mkdirs();
        }
        return savePath.getAbsolutePath();
    }


    @Override
    public void addBatch(List<SystemFile> fileList) {
        systemFileDao.addBatch(fileList);
    }
}
