/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.hsk.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.hsk.entity.SysHousekey;

/**
 * 房屋钥匙DAO接口
 * @author Mickey
 * @version 2019-04-09
 */
@MyBatisDao
public interface SysHousekeyDao extends CrudDao<SysHousekey> {
	
}