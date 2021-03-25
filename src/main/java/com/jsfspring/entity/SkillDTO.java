package com.jsfspring.entity;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;

@Entity
@Table(name = "SKILL_MASTER")
public class SkillDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SKILL_ID")
	private Long skillId;
	@Column(name = "Skill_Name")
	private String skillName;

	@OneToMany(mappedBy = "skillDTO")
	private List<DeveloperDTO> developertolst;

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

	public List<DeveloperDTO> getDevelopertolst() {
		if (null == developertolst) {
			developertolst = new ArrayList<>();
		}
		return developertolst;
	}

	public void setDevelopertolst(List<DeveloperDTO> developertolst) {
		this.developertolst = developertolst;
	}
}
