package com.llg.hnbc.service.interfaces;

import com.llg.hnbc.entity.ShortVideo;

import java.util.List;

public interface ShortVideoService {

    void add(ShortVideo shortVideo);

    List<ShortVideo> listShortVideo(ShortVideo shortVideo);


    void updateShortVideo(ShortVideo shortVideo);

    void deleteShortVideo(ShortVideo shortVideo);
}
