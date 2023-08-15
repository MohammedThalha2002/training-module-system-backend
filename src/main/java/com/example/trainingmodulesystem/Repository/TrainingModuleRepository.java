package com.example.trainingmodulesystem.Repository;

import com.example.trainingmodulesystem.Entity.TrainingModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingModuleRepository extends JpaRepository<TrainingModule, Long> {
    @Query(value = "select t from TrainingModule t where lower(t.name) like lower(concat('%', ?1, '%')) " +
            "or lower(?1) like lower(concat('%', elements(t.topics), '%'))")
    public List<TrainingModule> search(String query);
}
