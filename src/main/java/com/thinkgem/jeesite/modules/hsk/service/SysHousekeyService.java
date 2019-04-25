/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.hsk.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.hsk.entity.SysHousekey;
import com.thinkgem.jeesite.modules.hsk.dao.SysHousekeyDao;

/**
 * 房屋钥匙Service
 * @author Mickey
 * @version 2019-04-09
 */
@Service
@Transactional(readOnly = true)
public class SysHousekeyService extends CrudService<SysHousekeyDao, SysHousekey> {

	public SysHousekey get(String id) {
		return super.get(id);
	}
	
	public List<SysHousekey> findList(SysHousekey sysHousekey) {
		return super.findList(sysHousekey);
	}
	
	public Page<SysHousekey> findPage(Page<SysHousekey> page, SysHousekey sysHousekey) {
		return super.findPage(page, sysHousekey);
	}
	
	@Transactional(readOnly = false)
	public void save(SysHousekey sysHousekey) {
		super.save(sysHousekey);
	}
	
	@Transactional(readOnly = false)
	public void delete(SysHousekey sysHousekey) {
		super.delete(sysHousekey);
	}
	
}