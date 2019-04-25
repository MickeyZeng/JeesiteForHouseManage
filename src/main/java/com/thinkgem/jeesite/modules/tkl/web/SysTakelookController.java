/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.tkl.web;

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
import com.thinkgem.jeesite.modules.tkl.entity.SysTakelook;
import com.thinkgem.jeesite.modules.tkl.service.SysTakelookService;

/**
 * 带看房源Controller
 * @author Mickey
 * @version 2019-04-09
 */
@Controller
@RequestMapping(value = "${adminPath}/tkl/sysTakelook")
public class SysTakelookController extends BaseController {

	@Autowired
	private SysTakelookService sysTakelookService;
	
	@ModelAttribute
	public SysTakelook get(@RequestParam(required=false) String id) {
		SysTakelook entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = sysTakelookService.get(id);
		}
		if (entity == null){
			entity = new SysTakelook();
		}
		return entity;
	}
	
	@RequiresPermissions("tkl:sysTakelook:view")
	@RequestMapping(value = {"list", ""})
	public String list(SysTakelook sysTakelook, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<SysTakelook> page = sysTakelookService.findPage(new Page<SysTakelook>(request, response), sysTakelook); 
		model.addAttribute("page", page);
		return "modules/tkl/sysTakelookList";
	}

	@RequiresPermissions("tkl:sysTakelook:view")
	@RequestMapping(value = "form")
	public String form(SysTakelook sysTakelook, Model model) {
		model.addAttribute("sysTakelook", sysTakelook);
		return "modules/tkl/sysTakelookForm";
	}

	@RequiresPermissions("tkl:sysTakelook:edit")
	@RequestMapping(value = "save")
	public String save(SysTakelook sysTakelook, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, sysTakelook)){
			return form(sysTakelook, model);
		}
		sysTakelookService.save(sysTakelook);
		addMessage(redirectAttributes, "保存带看房源成功");
		return "redirect:"+Global.getAdminPath()+"/tkl/sysTakelook/?repage";
	}
	
	@RequiresPermissions("tkl:sysTakelook:edit")
	@RequestMapping(value = "delete")
	public String delete(SysTakelook sysTakelook, RedirectAttributes redirectAttributes) {
		sysTakelookService.delete(sysTakelook);
		addMessage(redirectAttributes, "删除带看房源成功");
		return "redirect:"+Global.getAdminPath()+"/tkl/sysTakelook/?repage";
	}

}