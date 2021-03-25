package com.jsfspring.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsfspring.entity.DeveloperDTO;

@Repository
public interface DeveloperRepo extends JpaRepository<DeveloperDTO, Long> {
}