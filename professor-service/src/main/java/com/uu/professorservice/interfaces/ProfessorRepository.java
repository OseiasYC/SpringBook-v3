package com.uu.professorservice.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uu.professorservice.models.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    @Modifying
    @Query("UPDATE Professor p SET p.name = :#{#professor.name} WHERE p.id = :#{#professor.id}")
    void update(@Param("professor") Professor professor);

    @Modifying
    @Query(value = "INSERT INTO professor_subject (professor_id, subject_id) VALUES (:professorId, :subjectId)", nativeQuery = true)
    void insertProfessorSubject(Long professorId, Long subjectId);

    @Modifying
    @Query(value = "DELETE FROM professor_subject WHERE professor_id = :professorId AND subject_id = :subjectId", nativeQuery = true)
    void removeProfessorSubject(Long professorId, Long subjectId);
}
