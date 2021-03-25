package com.jsfspring.utills;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsfspring.pojo.Skill;
import com.jsfspring.service.SkillService;

@Service
public class SkillConverter implements Converter {

	@Autowired
	private SkillService skillService;
	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
		Skill skill = new Skill();
		skill.setSkillName(string);
		skill = skillService.getSkill(skill);
		System.out.println(skill.toString());
		return skill;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object obj) {
		if (obj instanceof Skill) {
			Skill skill = (Skill) obj;
			return skill.getSkillName();
		} else {
			StringBuilder sbError = new StringBuilder("The object of class ");
			sbError.append(obj.getClass().getName()).append(" is not of SkillUITO");
			throw new ClassCastException(sbError.toString());
		}
	}
}