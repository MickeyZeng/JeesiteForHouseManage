/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.fcl.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 跟进表Entity
 * @author Mickey
 * @version 2019-04-09
 */
public class SysFollowupClient extends DataEntity<SysFollowupClient> {
	
	private static final long serialVersionUID = 1L;
	private String contents;		// 跟进内容
	private String userid;		// 员工id
	private Date time;		// 跟进时间
	private String clientid;		// 客户id
	
	public SysFollowupClient() {
		super();
	}

	public SysFollowupClient(String id){
		super(id);
	}

	@Length(min=0, max=100, message="跟进内容长度必须介于 0 和 100 之间")
	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}
	
	@Length(min=1, max=45, message="员工id长度必须介于 1 和 45 之间")
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
	@Length(min=1, max=45, message="客户id长度必须介于 1 和 45 之间")
	public String getClientid() {
		return clientid;
	}

	public void setClientid(String clientid) {
		this.clientid = clientid;
	}
	
}