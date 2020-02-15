package com.llg.hnbc.mapper.dao;

import com.llg.hnbc.entity.ShortVideo;

import java.util.List;

public interface ShortVideoDao {

    void add(ShortVideo shortVideo);

    List<ShortVideo> listShortVideo(ShortVideo shortVideo);

    void updateShortVideo(ShortVideo shortVideo);

    void deleteShortVideo(ShortVideo shortVideo);
}
