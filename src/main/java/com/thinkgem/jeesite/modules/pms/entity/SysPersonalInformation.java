/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.pms.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 用户个人信息Entity
 * @author Mickey
 * @version 2019-04-09
 */
public class SysPersonalInformation extends DataEntity<SysPersonalInformation> {
	
	private static final long serialVersionUID = 1L;
	private String personId;		// 个人信息编号
	private String idCard;		// 身份证号
	private String nation;		// 民族
	private String email;		// 电子邮件
	private String address;		// 联系电话
	private String bankAccount;		// 银行账号
	private String signature;		// 个人签名
	private String resume;		// 个人简介
	private String sex;		// 性别
	private String nativePlace;		// 籍贯
	private Date birthday;		// 生日
	private String politicalStatus;		// 政治面貌
	private String educationalBackground;		// 学历
	private String graduateInstitutions;		// 毕业院校
	private String major;		// 专业
	private String tip;		// 备注
	
	public SysPersonalInformation() {
		super();
	}

	public SysPersonalInformation(String id){
		super(id);
	}

	@Length(min=1, max=45, message="个人信息编号长度必须介于 1 和 45 之间")
	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}
	
	@Length(min=0, max=45, message="身份证号长度必须介于 0 和 45 之间")
	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	
	@Length(min=0, max=45, message="民族长度必须介于 0 和 45 之间")
	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}
	
	@Length(min=0, max=45, message="电子邮件长度必须介于 0 和 45 之间")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Length(min=0, max=45, message="联系电话长度必须介于 0 和 45 之间")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Length(min=0, max=45, message="银行账号长度必须介于 0 和 45 之间")
	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	
	@Length(min=0, max=45, message="个人签名长度必须介于 0 和 45 之间")
	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}
	
	@Length(min=0, max=145, message="个人简介长度必须介于 0 和 145 之间")
	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}
	
	@Length(min=0, max=5, message="性别长度必须介于 0 和 5 之间")
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Length(min=0, max=20, message="籍贯长度必须介于 0 和 20 之间")
	public String getNativePlace() {
		return nativePlace;
	}

	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	@Length(min=0, max=45, message="政治面貌长度必须介于 0 和 45 之间")
	public String getPoliticalStatus() {
		return politicalStatus;
	}

	public void setPoliticalStatus(String politicalStatus) {
		this.politicalStatus = politicalStatus;
	}
	
	@Length(min=0, max=45, message="学历长度必须介于 0 和 45 之间")
	public String getEducationalBackground() {
		return educationalBackground;
	}

	public void setEducationalBackground(String educationalBackground) {
		this.educationalBackground = educationalBackground;
	}
	
	@Length(min=0, max=45, message="毕业院校长度必须介于 0 和 45 之间")
	public String getGraduateInstitutions() {
		return graduateInstitutions;
	}

	public void setGraduateInstitutions(String graduateInstitutions) {
		this.graduateInstitutions = graduateInstitutions;
	}
	
	@Length(min=0, max=45, message="专业长度必须介于 0 和 45 之间")
	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	
	@Length(min=0, max=255, message="备注长度必须介于 0 和 255 之间")
	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}
	
}