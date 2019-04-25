/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.hsk.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.hsk.entity.SysHousekey;
import com.thinkgem.jeesite.modules.hsk.service.SysHousekeyService;

/**
 * 房屋钥匙Controller
 * @author Mickey
 * @version 2019-04-09
 */
@Controller
@RequestMapping(value = "${adminPath}/hsk/sysHousekey")
public class SysHousekeyController extends BaseController {

	@Autowired
	private SysHousekeyService sysHousekeyService;
	
	@ModelAttribute
	public SysHousekey get(@RequestParam(required=false) String id) {
		SysHousekey entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = sysHousekeyService.get(id);
		}
		if (entity == null){
			entity = new SysHousekey();
		}
		return entity;
	}
	
	@RequiresPermissions("hsk:sysHousekey:view")
	@RequestMapping(value = {"list", ""})
	public String list(SysHousekey sysHousekey, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<SysHousekey> page = sysHousekeyService.findPage(new Page<SysHousekey>(request, response), sysHousekey); 
		model.addAttribute("page", page);
		return "modules/hsk/sysHousekeyList";
	}

	@RequiresPermissions("hsk:sysHousekey:view")
	@RequestMapping(value = "form")
	public String form(SysHousekey sysHousekey, Model model) {
		model.addAttribute("sysHousekey", sysHousekey);
		return "modules/hsk/sysHousekeyForm";
	}

	@RequiresPermissions("hsk:sysHousekey:edit")
	@RequestMapping(value = "save")
	public String save(SysHousekey sysHousekey, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, sysHousekey)){
			return form(sysHousekey, model);
		}
		sysHousekeyService.save(sysHousekey);
		addMessage(redirectAttributes, "保存房屋钥匙成功");
		return "redirect:"+Global.getAdminPath()+"/hsk/sysHousekey/?repage";
	}
	
	@RequiresPermissions("hsk:sysHousekey:edit")
	@RequestMapping(value = "delete")
	public String delete(SysHousekey sysHousekey, RedirectAttributes redirectAttributes) {
		sysHousekeyService.delete(sysHousekey);
		addMessage(redirectAttributes, "删除房屋钥匙成功");
		return "redirect:"+Global.getAdminPath()+"/hsk/sysHousekey/?repage";
	}

}