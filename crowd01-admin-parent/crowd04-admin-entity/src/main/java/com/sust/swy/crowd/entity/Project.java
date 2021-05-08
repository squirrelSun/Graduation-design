package com.sust.swy.crowd.entity;

public class Project {
	private Integer id;

	private String projectName;

	private String projectDescription;

	private Long money;

	private Integer day;

	private Integer status;

	private String deploydate;

	private Long supportmoney;

	private Integer supporter;

	private Integer completion;

	private Integer memberid;

	private String createdate;

	private Integer follower;

	private String headerPicturePath;

	public Project() {
		super();
	}

	public Project(Integer id, String projectName, String projectDescription, Long money, Integer day, Integer status,
			String deploydate, Long supportmoney, Integer supporter, Integer completion, Integer memberid,
			String createdate, Integer follower, String headerPicturePath) {
		super();
		this.id = id;
		this.projectName = projectName;
		this.projectDescription = projectDescription;
		this.money = money;
		this.day = day;
		this.status = status;
		this.deploydate = deploydate;
		this.supportmoney = supportmoney;
		this.supporter = supporter;
		this.completion = completion;
		this.memberid = memberid;
		this.createdate = createdate;
		this.follower = follower;
		this.headerPicturePath = headerPicturePath;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", projectName=" + projectName + ", projectDescription=" + projectDescription
				+ ", money=" + money + ", day=" + day + ", status=" + status + ", deploydate=" + deploydate
				+ ", supportmoney=" + supportmoney + ", supporter=" + supporter + ", completion=" + completion
				+ ", memberid=" + memberid + ", createdate=" + createdate + ", follower=" + follower
				+ ", headerPicturePath=" + headerPicturePath + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((completion == null) ? 0 : completion.hashCode());
		result = prime * result + ((createdate == null) ? 0 : createdate.hashCode());
		result = prime * result + ((day == null) ? 0 : day.hashCode());
		result = prime * result + ((deploydate == null) ? 0 : deploydate.hashCode());
		result = prime * result + ((follower == null) ? 0 : follower.hashCode());
		result = prime * result + ((headerPicturePath == null) ? 0 : headerPicturePath.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((memberid == null) ? 0 : memberid.hashCode());
		result = prime * result + ((money == null) ? 0 : money.hashCode());
		result = prime * result + ((projectDescription == null) ? 0 : projectDescription.hashCode());
		result = prime * result + ((projectName == null) ? 0 : projectName.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((supporter == null) ? 0 : supporter.hashCode());
		result = prime * result + ((supportmoney == null) ? 0 : supportmoney.hashCode());
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
		Project other = (Project) obj;
		if (completion == null) {
			if (other.completion != null)
				return false;
		} else if (!completion.equals(other.completion))
			return false;
		if (createdate == null) {
			if (other.createdate != null)
				return false;
		} else if (!createdate.equals(other.createdate))
			return false;
		if (day == null) {
			if (other.day != null)
				return false;
		} else if (!day.equals(other.day))
			return false;
		if (deploydate == null) {
			if (other.deploydate != null)
				return false;
		} else if (!deploydate.equals(other.deploydate))
			return false;
		if (follower == null) {
			if (other.follower != null)
				return false;
		} else if (!follower.equals(other.follower))
			return false;
		if (headerPicturePath == null) {
			if (other.headerPicturePath != null)
				return false;
		} else if (!headerPicturePath.equals(other.headerPicturePath))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (memberid == null) {
			if (other.memberid != null)
				return false;
		} else if (!memberid.equals(other.memberid))
			return false;
		if (money == null) {
			if (other.money != null)
				return false;
		} else if (!money.equals(other.money))
			return false;
		if (projectDescription == null) {
			if (other.projectDescription != null)
				return false;
		} else if (!projectDescription.equals(other.projectDescription))
			return false;
		if (projectName == null) {
			if (other.projectName != null)
				return false;
		} else if (!projectName.equals(other.projectName))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (supporter == null) {
			if (other.supporter != null)
				return false;
		} else if (!supporter.equals(other.supporter))
			return false;
		if (supportmoney == null) {
			if (other.supportmoney != null)
				return false;
		} else if (!supportmoney.equals(other.supportmoney))
			return false;
		return true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName == null ? null : projectName.trim();
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription == null ? null : projectDescription.trim();
	}

	public Long getMoney() {
		return money;
	}

	public void setMoney(Long money) {
		this.money = money;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getDeploydate() {
		return deploydate;
	}

	public void setDeploydate(String deploydate) {
		this.deploydate = deploydate == null ? null : deploydate.trim();
	}

	public Long getSupportmoney() {
		return supportmoney;
	}

	public void setSupportmoney(Long supportmoney) {
		this.supportmoney = supportmoney;
	}

	public Integer getSupporter() {
		return supporter;
	}

	public void setSupporter(Integer supporter) {
		this.supporter = supporter;
	}

	public Integer getCompletion() {
		return completion;
	}

	public void setCompletion(Integer completion) {
		this.completion = completion;
	}

	public Integer getMemberid() {
		return memberid;
	}

	public void setMemberid(Integer memberid) {
		this.memberid = memberid;
	}

	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate == null ? null : createdate.trim();
	}

	public Integer getFollower() {
		return follower;
	}

	public void setFollower(Integer follower) {
		this.follower = follower;
	}

	public String getHeaderPicturePath() {
		return headerPicturePath;
	}

	public void setHeaderPicturePath(String headerPicturePath) {
		this.headerPicturePath = headerPicturePath == null ? null : headerPicturePath.trim();
	}
}