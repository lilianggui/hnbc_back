package com.llg.hnbc.mapper.dao;

import com.llg.hnbc.entity.SystemFile;

import java.util.List;

public interface SystemFileDao {
    void add(SystemFile systemFile);

    List<SystemFile> getSystemFileList(SystemFile systemFile);

    void deleteSystemFile(SystemFile systemFile);

    void addBatch(List<SystemFile> fileList);
}
