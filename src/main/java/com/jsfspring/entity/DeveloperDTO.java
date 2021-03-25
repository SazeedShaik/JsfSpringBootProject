package com.jsfspring.entity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DEVELOPER_INFO")
public class DeveloperDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long developerId;
	@Column(name = "DEVELOPER_NAME" )
	private String developerName;
	@Column(name = "EMAIL_ID")
	private String emailId;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SKILL_ID")
	private SkillDTO skillDTO;

	public Long getDeveloperId() {
		return developerId;
	}

	public void setDeveloperId(Long developerId) {
		this.developerId = developerId;
	}

	public String getDeveloperName() {
		return developerName;
	}

	public void setDeveloperName(String developerName) {
		this.developerName = developerName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public SkillDTO getSkillDTO() {

		return skillDTO;
	}

	public void setSkillDTO(SkillDTO skillDTO) {
		this.skillDTO = skillDTO;
	}

}
