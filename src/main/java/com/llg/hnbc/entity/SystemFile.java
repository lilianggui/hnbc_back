package com.llg.hnbc.entity;

import java.util.Date;

public class SystemFile {
    private Integer id;
    private String module;
    private String moduleName;
    private Integer businessId;
    private String fileName;
    private String fileOriginName;
    private String filePath;
    private String fileFormat;
    private Integer createBy;
    private Date createTime;
    private Integer updateBy;
    private Date updateTime;

    public SystemFile() {
    }

    public SystemFile(String module, String moduleName, Integer businessId
            , String fileName, String fileOriginName, String filePath, String fileFormat) {
        this.module = module;
        this.moduleName = moduleName;
        this.businessId = businessId;
        this.fileName = fileName;
        this.fileOriginName = fileOriginName;
        this.filePath = filePath;
        this.fileFormat = fileFormat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileOriginName() {
        return fileOriginName;
    }

    public void setFileOriginName(String fileOriginName) {
        this.fileOriginName = fileOriginName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
