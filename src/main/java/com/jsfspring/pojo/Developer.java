package com.jsfspring.pojo;
import java.io.Serializable;

public class Developer implements Serializable {
	private static final long serialVersionUID = 4840260415183676656L;
	private Long developerId;
	private String developerName;
	private String emailId;
	private Skill skill;

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

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	@Override
	public String toString() {
		return "Developer [developerId=" + developerId + ", developerName=" + developerName + ""
				+ ", emailId=" + emailId + ", skill=" + skill + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((developerName == null) ? 0 : developerName.hashCode());
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
		Developer other = (Developer) obj;
		if (developerName == null) {
			if (other.developerName != null)
				return false;
		} else if (!developerName.equals(other.developerName))
			return false;
		return true;
	}

}
