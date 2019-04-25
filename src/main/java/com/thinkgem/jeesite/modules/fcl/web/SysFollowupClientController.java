/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.fcl.web;

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
import com.thinkgem.jeesite.modules.fcl.entity.SysFollowupClient;
import com.thinkgem.jeesite.modules.fcl.service.SysFollowupClientService;

/**
 * 跟进表Controller
 * @author Mickey
 * @version 2019-04-09
 */
@Controller
@RequestMapping(value = "${adminPath}/fcl/sysFollowupClient")
public class SysFollowupClientController extends BaseController {

	@Autowired
	private SysFollowupClientService sysFollowupClientService;
	
	@ModelAttribute
	public SysFollowupClient get(@RequestParam(required=false) String id) {
		SysFollowupClient entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = sysFollowupClientService.get(id);
		}
		if (entity == null){
			entity = new SysFollowupClient();
		}
		return entity;
	}
	
	@RequiresPermissions("fcl:sysFollowupClient:view")
	@RequestMapping(value = {"list", ""})
	public String list(SysFollowupClient sysFollowupClient, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<SysFollowupClient> page = sysFollowupClientService.findPage(new Page<SysFollowupClient>(request, response), sysFollowupClient); 
		model.addAttribute("page", page);
		return "modules/fcl/sysFollowupClientList";
	}

	@RequiresPermissions("fcl:sysFollowupClient:view")
	@RequestMapping(value = "form")
	public String form(SysFollowupClient sysFollowupClient, Model model) {
		model.addAttribute("sysFollowupClient", sysFollowupClient);
		return "modules/fcl/sysFollowupClientForm";
	}

	@RequiresPermissions("fcl:sysFollowupClient:edit")
	@RequestMapping(value = "save")
	public String save(SysFollowupClient sysFollowupClient, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, sysFollowupClient)){
			return form(sysFollowupClient, model);
		}
		sysFollowupClientService.save(sysFollowupClient);
		addMessage(redirectAttributes, "保存followClient成功");
		return "redirect:"+Global.getAdminPath()+"/fcl/sysFollowupClient/?repage";
	}
	
	@RequiresPermissions("fcl:sysFollowupClient:edit")
	@RequestMapping(value = "delete")
	public String delete(SysFollowupClient sysFollowupClient, RedirectAttributes redirectAttributes) {
		sysFollowupClientService.delete(sysFollowupClient);
		addMessage(redirectAttributes, "删除followClient成功");
		return "redirect:"+Global.getAdminPath()+"/fcl/sysFollowupClient/?repage";
	}

}