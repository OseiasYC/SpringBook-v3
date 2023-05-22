package com.uu.labservice.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uu.labservice.models.Lab;

@Repository
public interface LabRepository extends JpaRepository<Lab, Long> {

    @Modifying
    @Query("UPDATE Lab SET lami = :#{#lab.lami}, description = :#{#lab.description}, status = :#{#lab.status}, desktops = :#{#lab.desktops}, location = :#{#lab.location} WHERE id = :#{#lab.id}")
    void update(@Param("lab") Lab lab);

    @Modifying
    @Query("UPDATE Lab SET status = :#{#status} WHERE id = :#{#labId}")
    void updateStatus(@Param("labId") Long labId, @Param("status") boolean status);

}
