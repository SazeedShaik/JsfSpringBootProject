package com.jsfspring.pojo;
import java.io.Serializable;
import java.util.List;

public class Skill implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long skillId;
	private String skillName;
	private List<Developer> developerList;

	public Long getSkillId() {
		return skillId;
	}

	public void setSkillId(Long skillId) {
		this.skillId = skillId;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public List<Developer> getDeveloperList() {
		return developerList;
	}

	public void setDeveloperList(List<Developer> developerList) {
		this.developerList = developerList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((skillId == null) ? 0 : skillId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Skill other = (Skill) obj;
		if (skillId == null) {
			if (other.skillId != null)
				return false;
		} else if (!skillId.equals(other.skillId))
			return false;
		return true;
	}

}
