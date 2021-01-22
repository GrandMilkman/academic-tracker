package org.edu.vsu.dao;

import org.edu.vsu.entity.Academic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface AcademicRepository extends JpaRepository<Academic, Long> {
}
