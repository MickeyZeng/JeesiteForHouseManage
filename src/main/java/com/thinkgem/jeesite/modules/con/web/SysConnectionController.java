/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.con.web;

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
import com.thinkgem.jeesite.modules.con.entity.SysConnection;
import com.thinkgem.jeesite.modules.con.service.SysConnectionService;

/**
 * 通讯录表Controller
 * @author Mickey
 * @version 2019-04-09
 */
@Controller
@RequestMapping(value = "${adminPath}/con/sysConnection")
public class SysConnectionController extends BaseController {

	@Autowired
	private SysConnectionService sysConnectionService;
	
	@ModelAttribute
	public SysConnection get(@RequestParam(required=false) String id) {
		SysConnection entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = sysConnectionService.get(id);
		}
		if (entity == null){
			entity = new SysConnection();
		}
		return entity;
	}
	
	@RequiresPermissions("con:sysConnection:view")
	@RequestMapping(value = {"list", ""})
	public String list(SysConnection sysConnection, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<SysConnection> page = sysConnectionService.findPage(new Page<SysConnection>(request, response), sysConnection); 
		model.addAttribute("page", page);
		return "modules/con/sysConnectionList";
	}

	@RequiresPermissions("con:sysConnection:view")
	@RequestMapping(value = "form")
	public String form(SysConnection sysConnection, Model model) {
		model.addAttribute("sysConnection", sysConnection);
		return "modules/con/sysConnectionForm";
	}

	@RequiresPermissions("con:sysConnection:edit")
	@RequestMapping(value = "save")
	public String save(SysConnection sysConnection, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, sysConnection)){
			return form(sysConnection, model);
		}
		sysConnectionService.save(sysConnection);
		addMessage(redirectAttributes, "保存Connection成功");
		return "redirect:"+Global.getAdminPath()+"/con/sysConnection/?repage";
	}
	
	@RequiresPermissions("con:sysConnection:edit")
	@RequestMapping(value = "delete")
	public String delete(SysConnection sysConnection, RedirectAttributes redirectAttributes) {
		sysConnectionService.delete(sysConnection);
		addMessage(redirectAttributes, "删除Connection成功");
		return "redirect:"+Global.getAdminPath()+"/con/sysConnection/?repage";
	}

}