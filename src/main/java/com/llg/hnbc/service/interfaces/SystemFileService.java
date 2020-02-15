package com.llg.hnbc.service.interfaces;

import com.llg.hnbc.entity.SystemFile;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface SystemFileService {

    void add(SystemFile systemFile);

    List<SystemFile> getSystemFileList(SystemFile systemFile);

    void deleteSystemFile(SystemFile systemFile);

    SystemFile saveSystemFile(MultipartFile file, SystemFile systemFile);

    void addBatch(List<SystemFile> fileList);

    String getSavePath();
}
