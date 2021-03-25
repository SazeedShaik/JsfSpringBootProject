package com.jsfspring.service.impl;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsfspring.entity.SkillDTO;
import com.jsfspring.pojo.Developer;
import com.jsfspring.pojo.Skill;
import com.jsfspring.repository.SkillRepo;
import com.jsfspring.service.SkillService;

@Service
@Transactional
public class SkillServiceImpl implements SkillService {
	@Autowired
	private SkillRepo skillRepo;

	@Override
	public List<Skill> getAllSkill() {
		List<Skill> skillList = new ArrayList<>();
		List<SkillDTO> skillDTOList = skillRepo.findAll();
		skillDTOList.forEach(dto -> {
		Skill tmpUiTO = new Skill();
		BeanUtils.copyProperties(dto, tmpUiTO);
		skillList.add(tmpUiTO);
		});
		return skillList;
	}

	@Override
	public Skill getSkill(Skill skill) {
		SkillDTO dto = skillRepo.findTitleBySkillName(skill.getSkillName());
		Skill uito = new Skill();
		BeanUtils.copyProperties(dto, uito);
		return uito;
	}
}