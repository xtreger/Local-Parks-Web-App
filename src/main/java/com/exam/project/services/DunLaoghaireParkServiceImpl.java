package com.exam.project.services;

import com.exam.project.models.DunLaoghairePark;
import com.exam.project.repositiories.DunLaoghaireParkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DunLaoghaireParkServiceImpl implements DunLaoghaireParkService {

    @Autowired
    private HTMLParser htmlParser;

    @Autowired
    private DunLaoghaireParkRepository dunLaoghaireParkRepository;


    @Override
    public List<DunLaoghairePark> getAllDunLaoghairePark() {
        return dunLaoghaireParkRepository.findAll();
    }

    @Override
    public void addAllDunLaoghairePark() {
        if (dunLaoghaireParkRepository.count() == 0) {
            List<DunLaoghairePark> list = htmlParser.dunLaoghaireParkList();
            for (DunLaoghairePark dunLaoghairePark : list) {
                this.dunLaoghaireParkRepository.save(dunLaoghairePark);
            }
        }
    }


    @Override
    public void saveDunLaoghairePark(DunLaoghairePark dunLaoghairePark) {
        this.dunLaoghaireParkRepository.save(dunLaoghairePark);
    }

    @Override
    public void deleteDunLaoghaireParkById(Long id) {
        this.dunLaoghaireParkRepository.deleteById(id);
    }

    @Override
    public DunLaoghairePark getDunLaoghaireParkById(Long id) {
        Optional<DunLaoghairePark> optional = dunLaoghaireParkRepository.findById(id);
        DunLaoghairePark dunLaoghairePark;
        if (optional.isPresent()) {
            dunLaoghairePark = optional.get();
        } else {
            throw new RuntimeException("DunLaoghaire Park not found for id:" + id);
        }
        return dunLaoghairePark;
    }

}