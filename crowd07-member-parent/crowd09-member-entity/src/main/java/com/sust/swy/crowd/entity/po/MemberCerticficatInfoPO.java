package com.sust.swy.crowd.entity.po;

public class MemberCerticficatInfoPO {
    private Integer id;

    private Integer memberid;

    private String realname;

    private String cardnum;

    private String phone;

    private String photoHand;

    private String photoOn;

    private String photoOff;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMemberid() {
        return memberid;
    }

    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getPhotoHand() {
        return photoHand;
    }

    public void setPhotoHand(String photoHand) {
        this.photoHand = photoHand == null ? null : photoHand.trim();
    }

    public String getPhotoOn() {
        return photoOn;
    }

    public void setPhotoOn(String photoOn) {
        this.photoOn = photoOn == null ? null : photoOn.trim();
    }

    public String getPhotoOff() {
        return photoOff;
    }

    public void setPhotoOff(String photoOff) {
        this.photoOff = photoOff == null ? null : photoOff.trim();
    }
}