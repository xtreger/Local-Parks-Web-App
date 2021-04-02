package com.exam.project.repositiories;

import com.exam.project.models.DublinPark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DublinParkRepository extends JpaRepository<DublinPark, Long> {
}
