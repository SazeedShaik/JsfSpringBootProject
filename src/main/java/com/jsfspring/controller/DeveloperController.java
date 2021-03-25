package com.jsfspring.controller;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import org.primefaces.context.RequestContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

import com.jsfspring.pojo.Developer;
import com.jsfspring.pojo.Skill;
import com.jsfspring.service.DeveloperService;
import com.jsfspring.service.SkillService;

@Controller("developerController")
@SessionScope
public class DeveloperController {
	@Autowired
	private DeveloperService developerService;

	@Autowired
	private SkillService skillService;

	private String actionLabel;
	private Developer developer;
	private List<Developer> developerList;
	private List<Skill> skillList;

	//save developers
	public void saveInfoDeveloper() {
		developerService.saveDeveloper(this.getDeveloper());
		getAllDevelopers();
		this.setDeveloper(new Developer());
	}

	//get all the developers
	@PostConstruct
	public void getAllDevelopers() { 
	    this.getDeveloperList().clear();
		this.getSkillList().clear();
		this.getDeveloperList().addAll(developerService.fetchAllDeveloper());
		this.getSkillList().addAll(skillService.getAllSkill());
		this.setActionLabel("Create");
	}

	//edit the developer
	public void editDeveloper(Developer developer) { 
		this.setActionLabel("Update");
		BeanUtils.copyProperties(developer, this.getDeveloper());
		System.out.println(this.getDeveloper());
	}

	
	public Developer getDeveloper() {
		if (developer == null) {
			developer = new Developer();
		}
		return developer;
	}

	public void setDeveloper(Developer developer) {
		this.developer = developer;
	}

	public List<Developer> getDeveloperList() {
		if (null == developerList) {
			developerList = new ArrayList<>();
		}
		return developerList;
	}

	public String getActionLabel() {
		return actionLabel;
	}

	public void setActionLabel(String actionLabel) {
		this.actionLabel = actionLabel;
	}

	public List<Skill> getSkillList() {
		if (skillList == null) {
			skillList = new ArrayList<>();
		}
		return skillList;
	}

	public void setSkillList(List<Skill> skillList) {
		this.skillList = skillList;
	}
}