package com.sust.swy.crowd.entity;

public class Member {
	private Integer id;

	private String loginacct;

	private String userpswd;

	private String username;

	private String email;

	private Integer authstatus;

	private Integer usertype;

	private String realname;

	private String cardnum;

	private Integer accttype;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accttype == null) ? 0 : accttype.hashCode());
		result = prime * result + ((authstatus == null) ? 0 : authstatus.hashCode());
		result = prime * result + ((cardnum == null) ? 0 : cardnum.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((loginacct == null) ? 0 : loginacct.hashCode());
		result = prime * result + ((realname == null) ? 0 : realname.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((userpswd == null) ? 0 : userpswd.hashCode());
		result = prime * result + ((usertype == null) ? 0 : usertype.hashCode());
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
		Member other = (Member) obj;
		if (accttype == null) {
			if (other.accttype != null)
				return false;
		} else if (!accttype.equals(other.accttype))
			return false;
		if (authstatus == null) {
			if (other.authstatus != null)
				return false;
		} else if (!authstatus.equals(other.authstatus))
			return false;
		if (cardnum == null) {
			if (other.cardnum != null)
				return false;
		} else if (!cardnum.equals(other.cardnum))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (loginacct == null) {
			if (other.loginacct != null)
				return false;
		} else if (!loginacct.equals(other.loginacct))
			return false;
		if (realname == null) {
			if (other.realname != null)
				return false;
		} else if (!realname.equals(other.realname))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (userpswd == null) {
			if (other.userpswd != null)
				return false;
		} else if (!userpswd.equals(other.userpswd))
			return false;
		if (usertype == null) {
			if (other.usertype != null)
				return false;
		} else if (!usertype.equals(other.usertype))
			return false;
		return true;
	}

	public Member() {
		super();
	}

	public Member(Integer id, String loginacct, String userpswd, String username, String email, Integer authstatus,
			Integer usertype, String realname, String cardnum, Integer accttype) {
		super();
		this.id = id;
		this.loginacct = loginacct;
		this.userpswd = userpswd;
		this.username = username;
		this.email = email;
		this.authstatus = authstatus;
		this.usertype = usertype;
		this.realname = realname;
		this.cardnum = cardnum;
		this.accttype = accttype;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", loginacct=" + loginacct + ", userpswd=" + userpswd + ", username=" + username
				+ ", email=" + email + ", authstatus=" + authstatus + ", usertype=" + usertype + ", realname="
				+ realname + ", cardnum=" + cardnum + ", accttype=" + accttype + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLoginacct() {
		return loginacct;
	}

	public void setLoginacct(String loginacct) {
		this.loginacct = loginacct == null ? null : loginacct.trim();
	}

	public String getUserpswd() {
		return userpswd;
	}

	public void setUserpswd(String userpswd) {
		this.userpswd = userpswd == null ? null : userpswd.trim();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public Integer getAuthstatus() {
		return authstatus;
	}

	public void setAuthstatus(Integer authstatus) {
		this.authstatus = authstatus;
	}

	public Integer getUsertype() {
		return usertype;
	}

	public void setUsertype(Integer usertype) {
		this.usertype = usertype;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname == null ? null : realname.trim();
	}

	public String getCardnum() {
		return cardnum;
	}

	public void setCardnum(String cardnum) {
		this.cardnum = cardnum == null ? null : cardnum.trim();
	}

	public Integer getAccttype() {
		return accttype;
	}

	public void setAccttype(Integer accttype) {
		this.accttype = accttype;
	}
}