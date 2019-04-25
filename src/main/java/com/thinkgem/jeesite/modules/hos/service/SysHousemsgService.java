/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.hos.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.hos.entity.SysHousemsg;
import com.thinkgem.jeesite.modules.hos.dao.SysHousemsgDao;

/**
 * 房屋信息Service
 * @author Mickey
 * @version 2019-04-09
 */
@Service
@Transactional(readOnly = true)
public class SysHousemsgService extends CrudService<SysHousemsgDao, SysHousemsg> {

	public SysHousemsg get(String id) {
		return super.get(id);
	}
	
	public List<SysHousemsg> findList(SysHousemsg sysHousemsg) {
		return super.findList(sysHousemsg);
	}
	
	public Page<SysHousemsg> findPage(Page<SysHousemsg> page, SysHousemsg sysHousemsg) {
		return super.findPage(page, sysHousemsg);
	}
	
	@Transactional(readOnly = false)
	public void save(SysHousemsg sysHousemsg) {
		super.save(sysHousemsg);
	}
	
	@Transactional(readOnly = false)
	public void delete(SysHousemsg sysHousemsg) {
		super.delete(sysHousemsg);
	}
	
}