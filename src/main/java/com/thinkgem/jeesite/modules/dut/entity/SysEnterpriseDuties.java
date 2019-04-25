/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.dut.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * Duties类Entity
 * @author Mickey
 * @version 2019-04-09
 */
public class SysEnterpriseDuties extends DataEntity<SysEnterpriseDuties> {
	
	private static final long serialVersionUID = 1L;
	private String enterpriseDutiesId;		// 职务编号
	private String dutiesName;		// 职务名称
	private String basicSalary;		// 底薪
	private String jobAttributes;		// 职务属性（业务，管理等）
	private String beginBasicSalary;		// 开始 底薪
	private String endBasicSalary;		// 结束 底薪
	
	public SysEnterpriseDuties() {
		super();
	}

	public SysEnterpriseDuties(String id){
		super(id);
	}

	@Length(min=1, max=45, message="职务编号长度必须介于 1 和 45 之间")
	public String getEnterpriseDutiesId() {
		return enterpriseDutiesId;
	}

	public void setEnterpriseDutiesId(String enterpriseDutiesId) {
		this.enterpriseDutiesId = enterpriseDutiesId;
	}
	
	@Length(min=1, max=45, message="职务名称长度必须介于 1 和 45 之间")
	public String getDutiesName() {
		return dutiesName;
	}

	public void setDutiesName(String dutiesName) {
		this.dutiesName = dutiesName;
	}
	
	public String getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(String basicSalary) {
		this.basicSalary = basicSalary;
	}
	
	@Length(min=1, max=20, message="职务属性（业务，管理等）长度必须介于 1 和 20 之间")
	public String getJobAttributes() {
		return jobAttributes;
	}

	public void setJobAttributes(String jobAttributes) {
		this.jobAttributes = jobAttributes;
	}
	
	public String getBeginBasicSalary() {
		return beginBasicSalary;
	}

	public void setBeginBasicSalary(String beginBasicSalary) {
		this.beginBasicSalary = beginBasicSalary;
	}
	
	public String getEndBasicSalary() {
		return endBasicSalary;
	}

	public void setEndBasicSalary(String endBasicSalary) {
		this.endBasicSalary = endBasicSalary;
	}
		
}