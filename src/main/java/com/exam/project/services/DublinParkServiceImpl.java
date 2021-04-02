package com.exam.project.services;

import com.exam.project.models.DublinPark;
import com.exam.project.repositiories.DublinParkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DublinParkServiceImpl implements DublinParkService {

    @Autowired
    private HTMLParser htmlParser;

    @Autowired
    private DublinParkRepository dublinParkRepository;


    @Override
    public List<DublinPark> getAllDublinPark() {
        return dublinParkRepository.findAll();
    }

    @Override
    public void addAllDublinPark() {
        if (dublinParkRepository.count() == 0) {
            List<DublinPark> list = htmlParser.dublinParksList();
            for (DublinPark dublinPark : list) {
                this.dublinParkRepository.save(dublinPark);
            }
        }
    }


    @Override
    public void saveDublinPark(DublinPark dublinPark) {
        this.dublinParkRepository.save(dublinPark);
    }

    @Override
    public void deleteDublinParkById(Long id) {
        this.dublinParkRepository.deleteById(id);
    }

    @Override
    public DublinPark getDublinParkById(Long id) {
        Optional<DublinPark> optional = dublinParkRepository.findById(id);
        DublinPark dublinPark;
        if (optional.isPresent()) {
            dublinPark = optional.get();
        } else {
            throw new RuntimeException("Dublin Park not found for id:" + id);
        }
        return dublinPark;
    }

}
