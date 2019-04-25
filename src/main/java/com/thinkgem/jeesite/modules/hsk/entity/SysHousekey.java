/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.hsk.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 房屋钥匙Entity
 * @author Mickey
 * @version 2019-04-09
 */
public class SysHousekey extends DataEntity<SysHousekey> {
	
	private static final long serialVersionUID = 1L;
	private String houseId;		// 房屋ID
	private String name;		// 钥匙名称
	private String type;		// 钥匙类别
	private String organizationid;		// 保管门店id
	private String userid;		// 员工id
	private String status;		// 状态
	private String remark;		// 备注
	
	public SysHousekey() {
		super();
	}

	public SysHousekey(String id){
		super(id);
	}

	@Length(min=1, max=45, message="房屋ID长度必须介于 1 和 45 之间")
	public String getHouseId() {
		return houseId;
	}

	public void setHouseId(String houseId) {
		this.houseId = houseId;
	}
	
	@Length(min=0, max=45, message="钥匙名称长度必须介于 0 和 45 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=45, message="钥匙类别长度必须介于 0 和 45 之间")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Length(min=0, max=20, message="保管门店id长度必须介于 0 和 20 之间")
	public String getOrganizationid() {
		return organizationid;
	}

	public void setOrganizationid(String organizationid) {
		this.organizationid = organizationid;
	}
	
	@Length(min=0, max=45, message="员工id长度必须介于 0 和 45 之间")
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	@Length(min=0, max=45, message="状态长度必须介于 0 和 45 之间")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Length(min=0, max=45, message="备注长度必须介于 0 和 45 之间")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}