package com.llg.hnbc.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.llg.hnbc.entity.ShortVideo;
import com.llg.hnbc.entity.vo.PageQO;
import com.llg.hnbc.result.Result;
import com.llg.hnbc.service.interfaces.ShortVideoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ShortVideoController {

    @Resource
    private ShortVideoService shortVideoService;

    @PostMapping("addShortVideo")
    public Result add(ShortVideo shortVideo){
        shortVideoService.add(shortVideo);
        return Result.buildBaseSuccess();
    }

    @GetMapping("listShortVideo")
    public Result<ShortVideo> listShortVideo(ShortVideo shortVideo, PageQO pageQO){
        Page<ShortVideo> page = PageHelper.startPage(pageQO.getPageNum(), pageQO.getPageSize());
        List<ShortVideo> shortVideoList = shortVideoService.listShortVideo(shortVideo);
        return Result.buildPageSuccess(page, shortVideoList);
    }

    @PostMapping("updateShortVideo")
    public Result updateShortVideo(ShortVideo shortVideo){
        shortVideoService.updateShortVideo(shortVideo);
        return Result.buildBaseSuccess();
    }

    @PostMapping("deleteShortVideo")
    public Result deleteShortVideo(ShortVideo shortVideo){
        shortVideoService.deleteShortVideo(shortVideo);
        return Result.buildBaseSuccess();
    }

}
