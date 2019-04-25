/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.flh.web;

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
import com.thinkgem.jeesite.modules.flh.entity.SysFollowupHouse;
import com.thinkgem.jeesite.modules.flh.service.SysFollowupHouseService;

/**
 * 跟进房源Controller
 * @author Mickey
 * @version 2019-04-09
 */
@Controller
@RequestMapping(value = "${adminPath}/flh/sysFollowupHouse")
public class SysFollowupHouseController extends BaseController {

	@Autowired
	private SysFollowupHouseService sysFollowupHouseService;
	
	@ModelAttribute
	public SysFollowupHouse get(@RequestParam(required=false) String id) {
		SysFollowupHouse entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = sysFollowupHouseService.get(id);
		}
		if (entity == null){
			entity = new SysFollowupHouse();
		}
		return entity;
	}
	
	@RequiresPermissions("flh:sysFollowupHouse:view")
	@RequestMapping(value = {"list", ""})
	public String list(SysFollowupHouse sysFollowupHouse, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<SysFollowupHouse> page = sysFollowupHouseService.findPage(new Page<SysFollowupHouse>(request, response), sysFollowupHouse); 
		model.addAttribute("page", page);
		return "modules/flh/sysFollowupHouseList";
	}

	@RequiresPermissions("flh:sysFollowupHouse:view")
	@RequestMapping(value = "form")
	public String form(SysFollowupHouse sysFollowupHouse, Model model) {
		model.addAttribute("sysFollowupHouse", sysFollowupHouse);
		return "modules/flh/sysFollowupHouseForm";
	}

	@RequiresPermissions("flh:sysFollowupHouse:edit")
	@RequestMapping(value = "save")
	public String save(SysFollowupHouse sysFollowupHouse, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, sysFollowupHouse)){
			return form(sysFollowupHouse, model);
		}
		sysFollowupHouseService.save(sysFollowupHouse);
		addMessage(redirectAttributes, "保存FollowupHouse成功");
		return "redirect:"+Global.getAdminPath()+"/flh/sysFollowupHouse/?repage";
	}
	
	@RequiresPermissions("flh:sysFollowupHouse:edit")
	@RequestMapping(value = "delete")
	public String delete(SysFollowupHouse sysFollowupHouse, RedirectAttributes redirectAttributes) {
		sysFollowupHouseService.delete(sysFollowupHouse);
		addMessage(redirectAttributes, "删除FollowupHouse成功");
		return "redirect:"+Global.getAdminPath()+"/flh/sysFollowupHouse/?repage";
	}

}