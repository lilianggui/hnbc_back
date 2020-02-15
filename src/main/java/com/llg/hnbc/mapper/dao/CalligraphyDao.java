package com.llg.hnbc.mapper.dao;

import com.llg.hnbc.entity.Calligraphy;

import java.util.List;

public interface CalligraphyDao {

    void add(Calligraphy calligraphy);

    List<Calligraphy> listCalligraphy(Calligraphy calligraphy);

    void updateCalligraphy(Calligraphy calligraphy);

    void deleteCalligraphy(Calligraphy calligraphy);
}
