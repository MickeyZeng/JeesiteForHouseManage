/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.tkl.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.tkl.entity.SysTakelook;
import com.thinkgem.jeesite.modules.tkl.dao.SysTakelookDao;

/**
 * 带看房源Service
 * @author Mickey
 * @version 2019-04-09
 */
@Service
@Transactional(readOnly = true)
public class SysTakelookService extends CrudService<SysTakelookDao, SysTakelook> {

	public SysTakelook get(String id) {
		return super.get(id);
	}
	
	public List<SysTakelook> findList(SysTakelook sysTakelook) {
		return super.findList(sysTakelook);
	}
	
	public Page<SysTakelook> findPage(Page<SysTakelook> page, SysTakelook sysTakelook) {
		return super.findPage(page, sysTakelook);
	}
	
	@Transactional(readOnly = false)
	public void save(SysTakelook sysTakelook) {
		super.save(sysTakelook);
	}
	
	@Transactional(readOnly = false)
	public void delete(SysTakelook sysTakelook) {
		super.delete(sysTakelook);
	}
	
}