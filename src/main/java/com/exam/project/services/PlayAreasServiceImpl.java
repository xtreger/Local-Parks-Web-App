package com.exam.project.services;

import com.exam.project.models.PlayAreas;
import com.exam.project.repositiories.PlayAreasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayAreasServiceImpl implements PlayAreasService {

    @Autowired
    private XMLParser xmlParser;

    @Autowired
    private PlayAreasRepository playAreasRepository;


    @Override
    public List<PlayAreas> getAllPlayAreas() {
        return playAreasRepository.findAll();
    }

    @Override
    public void addAllPlayAreas() {
        if (playAreasRepository.count() == 0) {
            List<PlayAreas> list = xmlParser.parse();
            for (PlayAreas playAreas : list) {
                this.playAreasRepository.save(playAreas);
            }
        }
    }

    @Override
    public void savePlayAreas(PlayAreas playAreas) {
        this.playAreasRepository.save(playAreas);
    }

    @Override
    public void deletePlayAreasById(Long id) {
        this.playAreasRepository.deleteById(id);
    }

    @Override
    public PlayAreas getPlayAreasById(Long id) {
        Optional<PlayAreas> optional = playAreasRepository.findById(id);
        PlayAreas playAreas;
        if (optional.isPresent()) {
            playAreas = optional.get();
        } else {
            throw new RuntimeException("Play Area not found for id:" + id);
        }
        return playAreas;
    }

}
