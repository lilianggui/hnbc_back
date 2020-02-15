package com.llg.hnbc.entity;

import java.util.Date;

public class ShortVideo {

    private Integer id;
    private String title;
    private String description;
    private String videoType;
    private Integer videoFileId;
    private String videoFilePath;
    private Integer coverImgId;
    private String coverImgPath;
    private Integer createBy;
    private Date createTime;
    private Integer updateBy;
    private Date updateTime;

    private String videoFileOriginName;

    public String getVideoFileOriginName() {
        return videoFileOriginName;
    }

    public void setVideoFileOriginName(String videoFileOriginName) {
        this.videoFileOriginName = videoFileOriginName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVideoType() {
        return videoType;
    }

    public void setVideoType(String videoType) {
        this.videoType = videoType;
    }

    public Integer getVideoFileId() {
        return videoFileId;
    }

    public void setVideoFileId(Integer videoFileId) {
        this.videoFileId = videoFileId;
    }

    public String getVideoFilePath() {
        return videoFilePath;
    }

    public void setVideoFilePath(String videoFilePath) {
        this.videoFilePath = videoFilePath;
    }

    public Integer getCoverImgId() {
        return coverImgId;
    }

    public void setCoverImgId(Integer coverImgId) {
        this.coverImgId = coverImgId;
    }

    public String getCoverImgPath() {
        return coverImgPath;
    }

    public void setCoverImgPath(String coverImgPath) {
        this.coverImgPath = coverImgPath;
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
