/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.pms.web;

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
import com.thinkgem.jeesite.modules.pms.entity.SysPersonalInformation;
import com.thinkgem.jeesite.modules.pms.service.SysPersonalInformationService;

/**
 * 用户个人信息Controller
 * @author Mickey
 * @version 2019-04-09
 */
@Controller
@RequestMapping(value = "${adminPath}/pms/sysPersonalInformation")
public class SysPersonalInformationController extends BaseController {

	@Autowired
	private SysPersonalInformationService sysPersonalInformationService;
	
	@ModelAttribute
	public SysPersonalInformation get(@RequestParam(required=false) String id) {
		SysPersonalInformation entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = sysPersonalInformationService.get(id);
		}
		if (entity == null){
			entity = new SysPersonalInformation();
		}
		return entity;
	}
	
	@RequiresPermissions("pms:sysPersonalInformation:view")
	@RequestMapping(value = {"list", ""})
	public String list(SysPersonalInformation sysPersonalInformation, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<SysPersonalInformation> page = sysPersonalInformationService.findPage(new Page<SysPersonalInformation>(request, response), sysPersonalInformation); 
		model.addAttribute("page", page);
		return "modules/pms/sysPersonalInformationList";
	}

	@RequiresPermissions("pms:sysPersonalInformation:view")
	@RequestMapping(value = "form")
	public String form(SysPersonalInformation sysPersonalInformation, Model model) {
		model.addAttribute("sysPersonalInformation", sysPersonalInformation);
		return "modules/pms/sysPersonalInformationForm";
	}

	@RequiresPermissions("pms:sysPersonalInformation:edit")
	@RequestMapping(value = "save")
	public String save(SysPersonalInformation sysPersonalInformation, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, sysPersonalInformation)){
			return form(sysPersonalInformation, model);
		}
		sysPersonalInformationService.save(sysPersonalInformation);
		addMessage(redirectAttributes, "保存用户个人信息成功");
		return "redirect:"+Global.getAdminPath()+"/pms/sysPersonalInformation/?repage";
	}
	
	@RequiresPermissions("pms:sysPersonalInformation:edit")
	@RequestMapping(value = "delete")
	public String delete(SysPersonalInformation sysPersonalInformation, RedirectAttributes redirectAttributes) {
		sysPersonalInformationService.delete(sysPersonalInformation);
		addMessage(redirectAttributes, "删除用户个人信息成功");
		return "redirect:"+Global.getAdminPath()+"/pms/sysPersonalInformation/?repage";
	}

}