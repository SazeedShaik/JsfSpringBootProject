package com.jsfspring.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsfspring.entity.SkillDTO;

@Repository
public interface SkillRepo extends JpaRepository<SkillDTO, Long> {

	SkillDTO findTitleBySkillName(String skillName);
}