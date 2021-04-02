package com.exam.project.services;

import com.exam.project.models.DunLaoghairePark;

import java.util.List;

public interface DunLaoghaireParkService {
    List<DunLaoghairePark> getAllDunLaoghairePark();

    void addAllDunLaoghairePark();

    void saveDunLaoghairePark(DunLaoghairePark dublinPark);

    void deleteDunLaoghaireParkById(Long id);

    DunLaoghairePark getDunLaoghaireParkById(Long id);
}