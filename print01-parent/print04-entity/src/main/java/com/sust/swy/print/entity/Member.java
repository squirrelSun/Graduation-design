package com.sust.swy.print.entity;

import java.util.Date;

public class Member {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_member.id
     *
     * @mbggenerated Tue May 18 09:20:06 CST 2021
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_member.login_acct
     *
     * @mbggenerated Tue May 18 09:20:06 CST 2021
     */
    private String loginAcct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_member.login_pswd
     *
     * @mbggenerated Tue May 18 09:20:06 CST 2021
     */
    private String loginPswd;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_member.member_name
     *
     * @mbggenerated Tue May 18 09:20:06 CST 2021
     */
    private String memberName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_member.member_email
     *
     * @mbggenerated Tue May 18 09:20:06 CST 2021
     */
    private String memberEmail;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_member.member_status
     *
     * @mbggenerated Tue May 18 09:20:06 CST 2021
     */
    private Integer memberStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_member.update_time
     *
     * @mbggenerated Tue May 18 09:20:06 CST 2021
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_member.is_delete
     *
     * @mbggenerated Tue May 18 09:20:06 CST 2021
     */
    private Integer isDelete;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_member.id
     *
     * @return the value of t_member.id
     *
     * @mbggenerated Tue May 18 09:20:06 CST 2021
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_member.id
     *
     * @param id the value for t_member.id
     *
     * @mbggenerated Tue May 18 09:20:06 CST 2021
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_member.login_acct
     *
     * @return the value of t_member.login_acct
     *
     * @mbggenerated Tue May 18 09:20:06 CST 2021
     */
    public String getLoginAcct() {
        return loginAcct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_member.login_acct
     *
     * @param loginAcct the value for t_member.login_acct
     *
     * @mbggenerated Tue May 18 09:20:06 CST 2021
     */
    public void setLoginAcct(String loginAcct) {
        this.loginAcct = loginAcct == null ? null : loginAcct.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_member.login_pswd
     *
     * @return the value of t_member.login_pswd
     *
     * @mbggenerated Tue May 18 09:20:06 CST 2021
     */
    public String getLoginPswd() {
        return loginPswd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_member.login_pswd
     *
     * @param loginPswd the value for t_member.login_pswd
     *
     * @mbggenerated Tue May 18 09:20:06 CST 2021
     */
    public void setLoginPswd(String loginPswd) {
        this.loginPswd = loginPswd == null ? null : loginPswd.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_member.member_name
     *
     * @return the value of t_member.member_name
     *
     * @mbggenerated Tue May 18 09:20:06 CST 2021
     */
    public String getMemberName() {
        return memberName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_member.member_name
     *
     * @param memberName the value for t_member.member_name
     *
     * @mbggenerated Tue May 18 09:20:06 CST 2021
     */
    public void setMemberName(String memberName) {
        this.memberName = memberName == null ? null : memberName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_member.member_email
     *
     * @return the value of t_member.member_email
     *
     * @mbggenerated Tue May 18 09:20:06 CST 2021
     */
    public String getMemberEmail() {
        return memberEmail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_member.member_email
     *
     * @param memberEmail the value for t_member.member_email
     *
     * @mbggenerated Tue May 18 09:20:06 CST 2021
     */
    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail == null ? null : memberEmail.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_member.member_status
     *
     * @return the value of t_member.member_status
     *
     * @mbggenerated Tue May 18 09:20:06 CST 2021
     */
    public Integer getMemberStatus() {
        return memberStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_member.member_status
     *
     * @param memberStatus the value for t_member.member_status
     *
     * @mbggenerated Tue May 18 09:20:06 CST 2021
     */
    public void setMemberStatus(Integer memberStatus) {
        this.memberStatus = memberStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_member.update_time
     *
     * @return the value of t_member.update_time
     *
     * @mbggenerated Tue May 18 09:20:06 CST 2021
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_member.update_time
     *
     * @param updateTime the value for t_member.update_time
     *
     * @mbggenerated Tue May 18 09:20:06 CST 2021
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_member.is_delete
     *
     * @return the value of t_member.is_delete
     *
     * @mbggenerated Tue May 18 09:20:06 CST 2021
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_member.is_delete
     *
     * @param isDelete the value for t_member.is_delete
     *
     * @mbggenerated Tue May 18 09:20:06 CST 2021
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}