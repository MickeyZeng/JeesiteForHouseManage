/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.fcl.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.fcl.entity.SysFollowupClient;
import com.thinkgem.jeesite.modules.fcl.dao.SysFollowupClientDao;

/**
 * 跟进表Service
 * @author Mickey
 * @version 2019-04-09
 */
@Service
@Transactional(readOnly = true)
public class SysFollowupClientService extends CrudService<SysFollowupClientDao, SysFollowupClient> {

	public SysFollowupClient get(String id) {
		return super.get(id);
	}
	
	public List<SysFollowupClient> findList(SysFollowupClient sysFollowupClient) {
		return super.findList(sysFollowupClient);
	}
	
	public Page<SysFollowupClient> findPage(Page<SysFollowupClient> page, SysFollowupClient sysFollowupClient) {
		return super.findPage(page, sysFollowupClient);
	}
	
	@Transactional(readOnly = false)
	public void save(SysFollowupClient sysFollowupClient) {
		super.save(sysFollowupClient);
	}
	
	@Transactional(readOnly = false)
	public void delete(SysFollowupClient sysFollowupClient) {
		super.delete(sysFollowupClient);
	}
	
}