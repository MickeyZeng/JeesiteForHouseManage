/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.tkl.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 带看房源Entity
 * @author Mickey
 * @version 2019-04-09
 */
public class SysTakelook extends DataEntity<SysTakelook> {
	
	private static final long serialVersionUID = 1L;
	private Date lastTime;		// 最后带看时间
	private String lookTimes;		// 带看次数
	private String houseid;		// 房源id
	private String takeNumber;		// 带看编号
	private String houseNumber;		// 套数
	private String status;		// 状态
	private Date creatTime;		// 创建时间
	private String inspector;		// inspector
	private Date inspectTime;		// 审核时间
	
	public SysTakelook() {
		super();
	}

	public SysTakelook(String id){
		super(id);
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getLastTime() {
		return lastTime;
	}

	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}
	
	@Length(min=0, max=45, message="带看次数长度必须介于 0 和 45 之间")
	public String getLookTimes() {
		return lookTimes;
	}

	public void setLookTimes(String lookTimes) {
		this.lookTimes = lookTimes;
	}
	
	@Length(min=0, max=45, message="房源id长度必须介于 0 和 45 之间")
	public String getHouseid() {
		return houseid;
	}

	public void setHouseid(String houseid) {
		this.houseid = houseid;
	}
	
	@Length(min=0, max=45, message="带看编号长度必须介于 0 和 45 之间")
	public String getTakeNumber() {
		return takeNumber;
	}

	public void setTakeNumber(String takeNumber) {
		this.takeNumber = takeNumber;
	}
	
	@Length(min=0, max=45, message="套数长度必须介于 0 和 45 之间")
	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	
	@Length(min=0, max=45, message="状态长度必须介于 0 和 45 之间")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}
	
	@Length(min=0, max=45, message="inspector长度必须介于 0 和 45 之间")
	public String getInspector() {
		return inspector;
	}

	public void setInspector(String inspector) {
		this.inspector = inspector;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getInspectTime() {
		return inspectTime;
	}

	public void setInspectTime(Date inspectTime) {
		this.inspectTime = inspectTime;
	}
	
}