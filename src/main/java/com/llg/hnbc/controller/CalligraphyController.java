package com.llg.hnbc.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.llg.hnbc.entity.Calligraphy;
import com.llg.hnbc.entity.SystemFile;
import com.llg.hnbc.entity.vo.PageQO;
import com.llg.hnbc.result.Result;
import com.llg.hnbc.service.interfaces.CalligraphyService;
import com.llg.hnbc.service.interfaces.SystemFileService;
import com.llg.hnbc.utils.CommonConst;
import com.llg.hnbc.utils.ZipUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CalligraphyController {

    @Resource
    private CalligraphyService calligraphyService;

    @Resource
    private SystemFileService systemFileService;

    @PostMapping("addCalligraphy")
    public Result add(Calligraphy calligraphy){
        calligraphyService.add(calligraphy);
        return Result.buildBaseSuccess();
    }

    @GetMapping("listCalligraphy")
    public Result<Calligraphy> listCalligraphy(Calligraphy calligraphy, PageQO pageQO){
        Page<Calligraphy> page = PageHelper.startPage(pageQO.getPageNum(), pageQO.getPageSize());
        List<Calligraphy> calligraphyList = calligraphyService.listCalligraphy(calligraphy);
        return Result.buildPageSuccess(page, calligraphyList);
    }

    @PostMapping("updateCalligraphy")
    public Result updateCalligraphy(Calligraphy calligraphy){
        calligraphyService.updateCalligraphy(calligraphy);
        return Result.buildBaseSuccess();
    }

    @PostMapping("deleteCalligraphy")
    public Result deleteCalligraphy(Calligraphy calligraphy){
        calligraphyService.deleteCalligraphy(calligraphy);
        return Result.buildBaseSuccess();
    }

    @PostMapping("uploadCalligraphyImgBatch")
    public Result uploadCalligraphyImgBatch(MultipartFile file, SystemFile systemFile){
        //先保存zip文件
        systemFile.setModule(CommonConst.SYSTEM_FILE_MODULE.CALLIGRAPHY_BATCH_ZIP.getIndex()); //书法模块批量上传图片zip文件
        systemFile = systemFileService.saveSystemFile(file, systemFile);
        String[] fileValid = {
                ".jpg", ".png", ".jpeg"
        };
        systemFile.setModule(CommonConst.SYSTEM_FILE_MODULE.CALLIGRAPHY_IMG.getIndex());
        List<SystemFile> fileList = new ArrayList<>();
        String errorMsg = ZipUtils.unZip(systemFile.getFilePath(), systemFileService.getSavePath(), fileValid, systemFile, fileList);
        if(errorMsg != null){
            return Result.buildBaseFail(errorMsg);
        }
        systemFileService.addBatch(fileList);
        return Result.buildBaseSuccess();
    }




}
