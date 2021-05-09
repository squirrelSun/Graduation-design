package com.sust.swy.crowd.entity;

public class MemberCerticficatInfoDetail {

	private String certicficatId;

	private String memberId;

	private String realName;

	private String cardNum;

	private String phone;

	private String authstatus;

	private String photoHand;

	private String photoOn;

	private String photoOff;

	private String loginacct;

	private String username;

	private String email;

	@Override
	public String toString() {
		return "MemberCerticficatInfoDetail [certicficatId=" + certicficatId + ", memberId=" + memberId + ", realName="
				+ realName + ", cardNum=" + cardNum + ", phone=" + phone + ", photoHand=" + photoHand + ", authstatus="
				+ authstatus + ", photoOn=" + photoOn + ", photoOff=" + photoOff + ", loginacct=" + loginacct
				+ ", username=" + username + ", email=" + email + "]";
	}

	public MemberCerticficatInfoDetail() {
		super();
	}

	public MemberCerticficatInfoDetail(String certicficatId, String memberId, String realName, String cardNum,
			String phone, String photoHand, String authstatus, String photoOn, String photoOff, String loginacct,
			String username, String email) {
		super();
		this.certicficatId = certicficatId;
		this.memberId = memberId;
		this.realName = realName;
		this.cardNum = cardNum;
		this.phone = phone;
		this.photoHand = photoHand;
		this.authstatus = authstatus;
		this.photoOn = photoOn;
		this.photoOff = photoOff;
		this.loginacct = loginacct;
		this.username = username;
		this.email = email;
	}

	public String getAuthstatus() {
		return authstatus;
	}

	public void setAuthstatus(String authstatus) {
		this.authstatus = authstatus;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public String getCerticficatId() {
		return certicficatId;
	}

	public void setCerticficatId(String certicficatId) {
		this.certicficatId = certicficatId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardnum(String cardNum) {
		this.cardNum = cardNum;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhotoHand() {
		return photoHand;
	}

	public void setPhotoHand(String photoHand) {
		this.photoHand = photoHand;
	}

	public String getPhotoOn() {
		return photoOn;
	}

	public void setPhotoOn(String photoOn) {
		this.photoOn = photoOn;
	}

	public String getPhotoOff() {
		return photoOff;
	}

	public void setPhotoOff(String photoOff) {
		this.photoOff = photoOff;
	}

	public String getLoginacct() {
		return loginacct;
	}

	public void setLoginacct(String loginacct) {
		this.loginacct = loginacct;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

}
