/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cus.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.cus.entity.SysClient;

/**
 * 客服类DAO接口
 * @author Mickey
 * @version 2019-04-09
 */
@MyBatisDao
public interface SysClientDao extends CrudDao<SysClient> {
	
}