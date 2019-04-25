/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cus.web;

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
import com.thinkgem.jeesite.modules.cus.entity.SysClient;
import com.thinkgem.jeesite.modules.cus.service.SysClientService;

/**
 * 客服类Controller
 * @author Mickey
 * @version 2019-04-09
 */
@Controller
@RequestMapping(value = "${adminPath}/cus/sysClient")
public class SysClientController extends BaseController {

	@Autowired
	private SysClientService sysClientService;
	
	@ModelAttribute
	public SysClient get(@RequestParam(required=false) String id) {
		SysClient entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = sysClientService.get(id);
		}
		if (entity == null){
			entity = new SysClient();
		}
		return entity;
	}
	
	@RequiresPermissions("cus:sysClient:view")
	@RequestMapping(value = {"list", ""})
	public String list(SysClient sysClient, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<SysClient> page = sysClientService.findPage(new Page<SysClient>(request, response), sysClient); 
		model.addAttribute("page", page);
		return "modules/cus/sysClientList";
	}

	@RequiresPermissions("cus:sysClient:view")
	@RequestMapping(value = "form")
	public String form(SysClient sysClient, Model model) {
		model.addAttribute("sysClient", sysClient);
		return "modules/cus/sysClientForm";
	}

	@RequiresPermissions("cus:sysClient:edit")
	@RequestMapping(value = "save")
	public String save(SysClient sysClient, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, sysClient)){
			return form(sysClient, model);
		}
		sysClientService.save(sysClient);
		addMessage(redirectAttributes, "保存Client成功");
		return "redirect:"+Global.getAdminPath()+"/cus/sysClient/?repage";
	}
	
	@RequiresPermissions("cus:sysClient:edit")
	@RequestMapping(value = "delete")
	public String delete(SysClient sysClient, RedirectAttributes redirectAttributes) {
		sysClientService.delete(sysClient);
		addMessage(redirectAttributes, "删除Client成功");
		return "redirect:"+Global.getAdminPath()+"/cus/sysClient/?repage";
	}

}