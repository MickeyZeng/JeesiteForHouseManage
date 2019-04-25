/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.dut.web;

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
import com.thinkgem.jeesite.modules.dut.entity.SysEnterpriseDuties;
import com.thinkgem.jeesite.modules.dut.service.SysEnterpriseDutiesService;

/**
 * Duties类Controller
 * @author Mickey
 * @version 2019-04-09
 */
@Controller
@RequestMapping(value = "${adminPath}/dut/sysEnterpriseDuties")
public class SysEnterpriseDutiesController extends BaseController {

	@Autowired
	private SysEnterpriseDutiesService sysEnterpriseDutiesService;
	
	@ModelAttribute
	public SysEnterpriseDuties get(@RequestParam(required=false) String id) {
		SysEnterpriseDuties entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = sysEnterpriseDutiesService.get(id);
		}
		if (entity == null){
			entity = new SysEnterpriseDuties();
		}
		return entity;
	}
	
	@RequiresPermissions("dut:sysEnterpriseDuties:view")
	@RequestMapping(value = {"list", ""})
	public String list(SysEnterpriseDuties sysEnterpriseDuties, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<SysEnterpriseDuties> page = sysEnterpriseDutiesService.findPage(new Page<SysEnterpriseDuties>(request, response), sysEnterpriseDuties); 
		model.addAttribute("page", page);
		return "modules/dut/sysEnterpriseDutiesList";
	}

	@RequiresPermissions("dut:sysEnterpriseDuties:view")
	@RequestMapping(value = "form")
	public String form(SysEnterpriseDuties sysEnterpriseDuties, Model model) {
		model.addAttribute("sysEnterpriseDuties", sysEnterpriseDuties);
		return "modules/dut/sysEnterpriseDutiesForm";
	}

	@RequiresPermissions("dut:sysEnterpriseDuties:edit")
	@RequestMapping(value = "save")
	public String save(SysEnterpriseDuties sysEnterpriseDuties, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, sysEnterpriseDuties)){
			return form(sysEnterpriseDuties, model);
		}
		sysEnterpriseDutiesService.save(sysEnterpriseDuties);
		addMessage(redirectAttributes, "保存Duties成功");
		return "redirect:"+Global.getAdminPath()+"/dut/sysEnterpriseDuties/?repage";
	}
	
	@RequiresPermissions("dut:sysEnterpriseDuties:edit")
	@RequestMapping(value = "delete")
	public String delete(SysEnterpriseDuties sysEnterpriseDuties, RedirectAttributes redirectAttributes) {
		sysEnterpriseDutiesService.delete(sysEnterpriseDuties);
		addMessage(redirectAttributes, "删除Duties成功");
		return "redirect:"+Global.getAdminPath()+"/dut/sysEnterpriseDuties/?repage";
	}

}