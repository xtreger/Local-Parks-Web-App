package com.exam.project.services;

import com.exam.project.models.DublinPark;

import java.util.List;

public interface DublinParkService {
    List<DublinPark> getAllDublinPark();

    void addAllDublinPark();

    void saveDublinPark(DublinPark dublinPark);

    void deleteDublinParkById(Long id);

    DublinPark getDublinParkById(Long id);
}
