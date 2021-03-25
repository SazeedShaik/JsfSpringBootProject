package com.jsfspring.service;
import java.util.List;

import com.jsfspring.pojo.Skill;

public interface SkillService {

	List<Skill> getAllSkill(); 

	Skill getSkill(Skill skill);

}