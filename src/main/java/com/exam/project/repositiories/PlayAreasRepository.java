package com.exam.project.repositiories;

import com.exam.project.models.PlayAreas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayAreasRepository extends JpaRepository<PlayAreas, Long> {

}
