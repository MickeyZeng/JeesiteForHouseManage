/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.con.entity;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 通讯录表Entity
 * @author Mickey
 * @version 2019-04-09
 */
public class SysConnection extends DataEntity<SysConnection> {
	
	private static final long serialVersionUID = 1L;
	private Long connection;		// 联系方式
	private String style;		// 绑定类型（手机，微信..）
	private String binding;		// 绑定状态
	private String connectionUser;		// 联系人
	
	public SysConnection() {
		super();
	}

	public SysConnection(String id){
		super(id);
	}

	@NotNull(message="联系方式不能为空")
	public Long getConnection() {
		return connection;
	}

	public void setConnection(Long connection) {
		this.connection = connection;
	}

	@Length(min=0, max=11, message="绑定状态长度必须介于 0 和 11 之间")
	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}
	
	@Length(min=0, max=11, message="绑定状态长度必须介于 0 和 11 之间")
	public String getBinding() {
		return binding;
	}

	public void setBinding(String binding) {
		this.binding = binding;
	}
	
	@Length(min=1, max=11, message="联系人长度必须介于 1 和 11 之间")
	public String getConnectionUser() {
		return connectionUser;
	}

	public void setConnectionUser(String connectionUser) {
		this.connectionUser = connectionUser;
	}
	
}