package com.uu.professorservice.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uu.professorservice.models.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

    @Modifying
    @Query("UPDATE Subject s SET s.name = :#{#subject.name} WHERE s.id = :#{#subject.id}")
    void update(@Param("subject") Subject subject);

    @Modifying
    @Query(value = "DELETE FROM professor_subject WHERE subject_id = :id", nativeQuery = true)
    void deleteRelated(@Param("id") Long id);
}
