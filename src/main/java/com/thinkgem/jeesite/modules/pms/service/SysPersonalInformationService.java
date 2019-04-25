/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.pms.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.pms.entity.SysPersonalInformation;
import com.thinkgem.jeesite.modules.pms.dao.SysPersonalInformationDao;

/**
 * 用户个人信息Service
 * @author Mickey
 * @version 2019-04-09
 */
@Service
@Transactional(readOnly = true)
public class SysPersonalInformationService extends CrudService<SysPersonalInformationDao, SysPersonalInformation> {

	public SysPersonalInformation get(String id) {
		return super.get(id);
	}
	
	public List<SysPersonalInformation> findList(SysPersonalInformation sysPersonalInformation) {
		return super.findList(sysPersonalInformation);
	}
	
	public Page<SysPersonalInformation> findPage(Page<SysPersonalInformation> page, SysPersonalInformation sysPersonalInformation) {
		return super.findPage(page, sysPersonalInformation);
	}
	
	@Transactional(readOnly = false)
	public void save(SysPersonalInformation sysPersonalInformation) {
		super.save(sysPersonalInformation);
	}
	
	@Transactional(readOnly = false)
	public void delete(SysPersonalInformation sysPersonalInformation) {
		super.delete(sysPersonalInformation);
	}
	
}