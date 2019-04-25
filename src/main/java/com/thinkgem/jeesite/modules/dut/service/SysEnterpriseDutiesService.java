/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.dut.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.dut.entity.SysEnterpriseDuties;
import com.thinkgem.jeesite.modules.dut.dao.SysEnterpriseDutiesDao;

/**
 * Duties类Service
 * @author Mickey
 * @version 2019-04-09
 */
@Service
@Transactional(readOnly = true)
public class SysEnterpriseDutiesService extends CrudService<SysEnterpriseDutiesDao, SysEnterpriseDuties> {

	public SysEnterpriseDuties get(String id) {
		return super.get(id);
	}
	
	public List<SysEnterpriseDuties> findList(SysEnterpriseDuties sysEnterpriseDuties) {
		return super.findList(sysEnterpriseDuties);
	}
	
	public Page<SysEnterpriseDuties> findPage(Page<SysEnterpriseDuties> page, SysEnterpriseDuties sysEnterpriseDuties) {
		return super.findPage(page, sysEnterpriseDuties);
	}
	
	@Transactional(readOnly = false)
	public void save(SysEnterpriseDuties sysEnterpriseDuties) {
		super.save(sysEnterpriseDuties);
	}
	
	@Transactional(readOnly = false)
	public void delete(SysEnterpriseDuties sysEnterpriseDuties) {
		super.delete(sysEnterpriseDuties);
	}
	
}