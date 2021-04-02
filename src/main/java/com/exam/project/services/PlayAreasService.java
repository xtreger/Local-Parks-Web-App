package com.exam.project.services;

import com.exam.project.models.PlayAreas;

import java.util.List;

public interface PlayAreasService {
    List<PlayAreas> getAllPlayAreas();

    void addAllPlayAreas();

    void savePlayAreas(PlayAreas playAreas);

    void deletePlayAreasById(Long id);

    PlayAreas getPlayAreasById(Long id);
}
