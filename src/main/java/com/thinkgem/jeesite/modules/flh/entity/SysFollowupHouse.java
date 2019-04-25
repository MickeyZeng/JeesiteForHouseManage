/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.flh.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 跟进房源Entity
 * @author Mickey
 * @version 2019-04-09
 */
public class SysFollowupHouse extends DataEntity<SysFollowupHouse> {
	
	private static final long serialVersionUID = 1L;
	private String content;		// 跟进内容
	private String userid;		// 员工id
	private String houseid;		// 房源id
	private Date time;		// 跟进时间
	private String method;		// 跟进方式
	
	public SysFollowupHouse() {
		super();
	}

	public SysFollowupHouse(String id){
		super(id);
	}

	@Length(min=0, max=100, message="跟进内容长度必须介于 0 和 100 之间")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@Length(min=1, max=45, message="员工id长度必须介于 1 和 45 之间")
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	@Length(min=1, max=45, message="房源id长度必须介于 1 和 45 之间")
	public String getHouseid() {
		return houseid;
	}

	public void setHouseid(String houseid) {
		this.houseid = houseid;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
	@Length(min=0, max=45, message="跟进方式长度必须介于 0 和 45 之间")
	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
	
}