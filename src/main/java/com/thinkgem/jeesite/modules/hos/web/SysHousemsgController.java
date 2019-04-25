/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.hos.web;

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
import com.thinkgem.jeesite.modules.hos.entity.SysHousemsg;
import com.thinkgem.jeesite.modules.hos.service.SysHousemsgService;

/**
 * 房屋信息Controller
 * @author Mickey
 * @version 2019-04-09
 */
@Controller
@RequestMapping(value = "${adminPath}/hos/sysHousemsg")
public class SysHousemsgController extends BaseController {

	@Autowired
	private SysHousemsgService sysHousemsgService;
	
	@ModelAttribute
	public SysHousemsg get(@RequestParam(required=false) String id) {
		SysHousemsg entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = sysHousemsgService.get(id);
		}
		if (entity == null){
			entity = new SysHousemsg();
		}
		return entity;
	}
	
	@RequiresPermissions("hos:sysHousemsg:view")
	@RequestMapping(value = {"list", ""})
	public String list(SysHousemsg sysHousemsg, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<SysHousemsg> page = sysHousemsgService.findPage(new Page<SysHousemsg>(request, response), sysHousemsg); 
		model.addAttribute("page", page);
		return "modules/hos/sysHousemsgList";
	}

	@RequiresPermissions("hos:sysHousemsg:view")
	@RequestMapping(value = "form")
	public String form(SysHousemsg sysHousemsg, Model model) {
		model.addAttribute("sysHousemsg", sysHousemsg);
		return "modules/hos/sysHousemsgForm";
	}

	@RequiresPermissions("hos:sysHousemsg:edit")
	@RequestMapping(value = "save")
	public String save(SysHousemsg sysHousemsg, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, sysHousemsg)){
			return form(sysHousemsg, model);
		}
		sysHousemsgService.save(sysHousemsg);
		addMessage(redirectAttributes, "保存HouseMsg成功");
		return "redirect:"+Global.getAdminPath()+"/hos/sysHousemsg/?repage";
	}
	
	@RequiresPermissions("hos:sysHousemsg:edit")
	@RequestMapping(value = "delete")
	public String delete(SysHousemsg sysHousemsg, RedirectAttributes redirectAttributes) {
		sysHousemsgService.delete(sysHousemsg);
		addMessage(redirectAttributes, "删除HouseMsg成功");
		return "redirect:"+Global.getAdminPath()+"/hos/sysHousemsg/?repage";
	}

}