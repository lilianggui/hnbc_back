package com.llg.hnbc.service.impl;

import com.llg.hnbc.entity.ShortVideo;
import com.llg.hnbc.mapper.dao.ShortVideoDao;
import com.llg.hnbc.service.interfaces.ShortVideoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ShortVideoServiceImpl implements ShortVideoService {

    @Resource
    private ShortVideoDao shortVideoDao;

    @Override
    public void add(ShortVideo shortVideo) {
        shortVideoDao.add(shortVideo);
    }

    @Override
    public List<ShortVideo> listShortVideo(ShortVideo shortVideo) {
        return shortVideoDao.listShortVideo(shortVideo);
    }

    @Override
    public void updateShortVideo(ShortVideo shortVideo) {
        shortVideoDao.updateShortVideo(shortVideo);
    }

    @Override
    public void deleteShortVideo(ShortVideo shortVideo) {
        shortVideoDao.deleteShortVideo(shortVideo);
    }
}
