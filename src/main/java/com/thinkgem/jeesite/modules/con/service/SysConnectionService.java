/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.con.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.con.entity.SysConnection;
import com.thinkgem.jeesite.modules.con.dao.SysConnectionDao;

/**
 * 通讯录表Service
 * @author Mickey
 * @version 2019-04-09
 */
@Service
@Transactional(readOnly = true)
public class SysConnectionService extends CrudService<SysConnectionDao, SysConnection> {

	public SysConnection get(String id) {
		return super.get(id);
	}
	
	public List<SysConnection> findList(SysConnection sysConnection) {
		return super.findList(sysConnection);
	}
	
	public Page<SysConnection> findPage(Page<SysConnection> page, SysConnection sysConnection) {
		return super.findPage(page, sysConnection);
	}
	
	@Transactional(readOnly = false)
	public void save(SysConnection sysConnection) {
		super.save(sysConnection);
	}
	
	@Transactional(readOnly = false)
	public void delete(SysConnection sysConnection) {
		super.delete(sysConnection);
	}
	
}