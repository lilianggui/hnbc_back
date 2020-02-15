package com.llg.hnbc.service.impl;

import com.llg.hnbc.entity.Calligraphy;
import com.llg.hnbc.mapper.dao.CalligraphyDao;
import com.llg.hnbc.service.interfaces.CalligraphyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CalligraphyServiceImpl implements CalligraphyService {

    @Resource
    private CalligraphyDao calligraphyDao;

    @Override
    public void add(Calligraphy calligraphy) {
        calligraphyDao.add(calligraphy);
    }

    @Override
    public List<Calligraphy> listCalligraphy(Calligraphy calligraphy) {
        return calligraphyDao.listCalligraphy(calligraphy);
    }

    @Override
    public void updateCalligraphy(Calligraphy calligraphy) {
        calligraphyDao.updateCalligraphy(calligraphy);
    }

    @Override
    public void deleteCalligraphy(Calligraphy calligraphy) {
        calligraphyDao.deleteCalligraphy(calligraphy);
    }
}
