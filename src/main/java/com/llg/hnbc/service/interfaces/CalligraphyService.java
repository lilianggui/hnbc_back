package com.llg.hnbc.service.interfaces;

import com.llg.hnbc.entity.Calligraphy;

import java.util.List;

public interface CalligraphyService {
    void add(Calligraphy calligraphy);

    List<Calligraphy> listCalligraphy(Calligraphy calligraphy);

    void updateCalligraphy(Calligraphy calligraphy);

    void deleteCalligraphy(Calligraphy calligraphy);
}
