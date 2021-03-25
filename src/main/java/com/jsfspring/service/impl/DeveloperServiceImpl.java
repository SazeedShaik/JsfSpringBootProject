package com.jsfspring.service.impl;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsfspring.entity.DeveloperDTO;
import com.jsfspring.entity.SkillDTO;
import com.jsfspring.pojo.Developer;
import com.jsfspring.pojo.Skill;
import com.jsfspring.repository.DeveloperRepo;
import com.jsfspring.service.DeveloperService;

@Service
@Transactional
public class DeveloperServiceImpl implements DeveloperService {
	@Autowired
	DeveloperRepo developerRepo;

	@Override
	@Transactional(readOnly = false)
	public Developer saveDeveloper(Developer developer) {
		DeveloperDTO dto = frontendToDatabase(developer);
		dto = developerRepo.save(dto);
		BeanUtils.copyProperties(dto, developer);
		databaseToFrontend(developer, dto);
		return developer;
	}

	private void databaseToFrontend(Developer developer, DeveloperDTO dto) {
		Skill skill = new Skill();
		BeanUtils.copyProperties(dto.getSkillDTO(), skill);
		developer.setSkill(skill);
	}

	private DeveloperDTO frontendToDatabase(Developer developer) {
		DeveloperDTO developerdto = new DeveloperDTO();
		SkillDTO skillDto = new SkillDTO();
		BeanUtils.copyProperties(developer, developerdto);
		BeanUtils.copyProperties(developer.getSkill(), skillDto);
		developerdto.setSkillDTO(skillDto);
		List<DeveloperDTO> list = new ArrayList<>();
		list.add(developerdto);
		skillDto.getDevelopertolst().addAll(list);
		return developerdto;
	}

	@Override
	public List<Developer> fetchAllDeveloper() {
		List<DeveloperDTO> databaseList = developerRepo.findAll();
		List<Developer> frontendList = new ArrayList<>();
		databaseList.forEach(dto -> {
			Developer tmp = new Developer();
			System.out.println(dto.getSkillDTO());
			BeanUtils.copyProperties(dto, tmp);
			databaseToFrontend(tmp, dto);
			frontendList.add(tmp);
		});
		return frontendList;
	}

}