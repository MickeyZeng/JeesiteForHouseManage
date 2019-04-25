/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.flh.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.flh.entity.SysFollowupHouse;
import com.thinkgem.jeesite.modules.flh.dao.SysFollowupHouseDao;

/**
 * 跟进房源Service
 * @author Mickey
 * @version 2019-04-09
 */
@Service
@Transactional(readOnly = true)
public class SysFollowupHouseService extends CrudService<SysFollowupHouseDao, SysFollowupHouse> {

	public SysFollowupHouse get(String id) {
		return super.get(id);
	}
	
	public List<SysFollowupHouse> findList(SysFollowupHouse sysFollowupHouse) {
		return super.findList(sysFollowupHouse);
	}
	
	public Page<SysFollowupHouse> findPage(Page<SysFollowupHouse> page, SysFollowupHouse sysFollowupHouse) {
		return super.findPage(page, sysFollowupHouse);
	}
	
	@Transactional(readOnly = false)
	public void save(SysFollowupHouse sysFollowupHouse) {
		super.save(sysFollowupHouse);
	}
	
	@Transactional(readOnly = false)
	public void delete(SysFollowupHouse sysFollowupHouse) {
		super.delete(sysFollowupHouse);
	}
	
}