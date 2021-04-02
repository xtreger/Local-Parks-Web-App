package com.exam.project.repositiories;

import com.exam.project.models.DunLaoghairePark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DunLaoghaireParkRepository extends JpaRepository<DunLaoghairePark, Long> {
}